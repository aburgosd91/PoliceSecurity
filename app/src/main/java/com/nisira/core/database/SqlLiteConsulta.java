package com.nisira.core.database;

/**
 * Created by aburgos on 14/01/2017.
 */
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import static com.nisira.utils.nisiracore.Constantes.DEBUG;
import static com.nisira.utils.nisiracore.Constantes.log;
import static com.nisira.utils.NisiraUtils.isNull;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import com.nisira.annotation.EColumna;
import com.nisira.core.EntityTuple;
import com.nisira.utils.nisiracore.Constantes;

public class SqlLiteConsulta {
    private List<Sextet<String, Class<?>, SqlLiteEstructuraORM, String, String, Boolean>> tablas;
    private String where = "";
    private String orderBy = "";
    private Object[] paramsWhere;

    private SQLiteDatabase iConnection;

    // private List<Pair<String, String>> agrupador = null;

    private List<Triplet<Class<?>, String, String>> groupBy = null;
    // El campo 0 es para la entidad principal

    public SqlLiteConsulta(Class<?> entityClass, String alias) {
        tablas = new ArrayList<Sextet<String, Class<?>, SqlLiteEstructuraORM, String, String, Boolean>>();
        SqlLiteEstructuraORM es = new SqlLiteEstructuraORM(entityClass);

        tablas.add(Sextet.with(alias, entityClass, es, "", "", true));

    }

    public SqlLiteEstructuraORM getMainEstructuraORM() {
        Sextet<String, Class<?>, SqlLiteEstructuraORM, String, String, Boolean> t = tablas.get(0);
        return t.getValue2();
    }

    public SqlLiteConsulta join(String typeJoin, Class<?> entityClass, String alias, String on) {

        join(typeJoin, entityClass, alias, on, true);
        return this;
    }

    public SqlLiteConsulta join(String typeJoin, Class<?> entityClass, String alias, String on, Boolean ret) {
        SqlLiteEstructuraORM es = new SqlLiteEstructuraORM(entityClass);

        tablas.add(Sextet.with(alias, entityClass, es, on, typeJoin, ret));

        return this;
    }

    public SqlLiteConsulta where(String where, Object... params) {
        this.where = where;
        this.paramsWhere = params;
        return this;
    }

    public SqlLiteConsulta orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String getSelectSentence() {
        String campos = "", from = "", sGroupBy = "";
        boolean usagrupo = false;
        if (groupBy != null) {
            for (Triplet<Class<?>, String, String> gb : groupBy) {
                usagrupo = true;
                String campo, grupo;
                campo = isNull(gb.getValue1(), "").trim();
                grupo = isNull(gb.getValue2(), "").trim();
                if (grupo.isEmpty()) {
                    sGroupBy = sGroupBy + (sGroupBy.isEmpty() ? "" : ", ") + campo;
                }
                campos = campos + (campos.isEmpty() ? "" : ", ")
                        + (grupo.isEmpty() ? campo : grupo + "(" + campo + ")");
            }
        }
        for (int i = 0; i < tablas.size(); i++) {
            Sextet<String, Class<?>, SqlLiteEstructuraORM, String, String, Boolean> t = tablas.get(i);
            String alias = t.getValue0();
            String onJoin = t.getValue3();
            String typeJoin = t.getValue4();
            Boolean mostrar = t.getValue5();

            SqlLiteEstructuraORM estructura = t.getValue2();

            if (!usagrupo) {
                if (mostrar) {
                    campos = campos + (campos.isEmpty() ? "" : "\n,") + estructura.concatenaCampos(alias);
                }
            }

            if (from.isEmpty()) {
                from = estructura.getNombreAlias(alias);
            } else {
                from = from + "\n" + typeJoin + " join " + estructura.getNombreAlias(alias);
            }
            if (!onJoin.isEmpty()) {
                from = from + " on " + onJoin;
            }
        }
        if (!this.where.isEmpty()) {
            from = from + "\nwhere " + this.where;
        }

        if (!sGroupBy.isEmpty()) {
            from = from + "\ngroup by " + sGroupBy;
        }

        if (!this.orderBy.isEmpty()) {
            from = from + "\norder by " + this.orderBy;
        }

        return "select\n" + campos + "\nfrom " + from + ";";
    }

    public void groupBy(Class<?> clase, String campo, String agrupador) {
        if (groupBy == null) {
            groupBy = new ArrayList<>();
        }
        groupBy.add(Triplet.with(clase, isNull(campo, "").trim(), isNull(agrupador, "").trim()));
    }

    public void mezclar(SQLiteDatabase connection, Object entidad) throws Exception {
        SqlLiteEstructuraORM est = getMainEstructuraORM();

        // Mezclar se hace bajo la estructura de la tabla que crea

        String sql = "";
        sql = est.sentenciaInsertUpdate(connection);

        if (DEBUG) {
            Log.i("", sql);
        }
        SQLiteStatement ps;
//        PreparedStatement ps;
        try {

            ps = connection.compileStatement(sql);
//            ps = connection.prepareStatement(sql);
        } catch (Exception e) {
            throw new Exception("Select Exec: " + e.getMessage());
        }

        int insertados = 0;

        try {
            insertados = est.setPrepareStamentParams(ps, 1, entidad, false);
            insertados += est.setPrepareStamentParamsPK(ps, insertados + 1, entidad);
            insertados += est.setPrepareStamentParams(ps, insertados + 1, entidad, false);
            insertados += est.setPrepareStamentParamsPK(ps, insertados + 1, entidad);
        } catch (SQLException e) {
            throw new Exception("Params: " + e.getMessage());
        }
        try {
            ps.execute();
        } catch (Exception e) {
            try {
                ps.close();
            } catch (Exception e1) {
                throw new Exception("Exec: " + e.getMessage() + " - " + e1.getMessage());
            }
            throw new Exception("Exec: " + e.getMessage());
        }

    }

    public void insertar(SQLiteDatabase connection, Object entidad) throws Exception {
        try {
            SqlLiteEstructuraORM est = getMainEstructuraORM();

            String sql;
            // Generador de PK
//            connection.setAutoCommit(false);
            for (Pair<Field, EColumna> pks : est.getListaClavePrimaria()) {
                Field field = pks.getValue0();
                field.setAccessible(true);
            }
            sql = est.sentenciaInsert(1, connection);
            if (DEBUG) {
                Log.i("", sql);
            }

            SQLiteStatement ps = connection.compileStatement(sql);
//            PreparedStatement ps = connection.prepareStatement(sql);
            est.setPrepareStamentParams(ps, 1, entidad, false);

            ps.execute();
//            connection.commit();
//            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
//                connection.rollback();
                connection.close();
            } catch (Exception e1) {
                throw new Exception(e1.getMessage());
            }
            throw new Exception(e.getMessage());
        }
    }

    public void insertar(SQLiteDatabase connection, List<?> entidades) throws Exception {
        SqlLiteEstructuraORM est = getMainEstructuraORM();

        try {
            String sql;
            if (!entidades.isEmpty()) {
                int size = entidades.size();
                if (size > est.maxRegsForSentence) {
                    int total = (int) Math.ceil(size / (est.maxRegsForSentence * 1.0));
                    for (int i = 0; i < total; i++) {
                        insertar(connection, entidades.subList(i * est.maxRegsForSentence,
                                (i == total - 1) ? entidades.size() : (i + 1) * est.maxRegsForSentence - 1));
                    }
                } else {
                    sql = est.sentenciaInsert(entidades.size(), connection);
                    SQLiteStatement ps;
                    //PreparedStatement ps;

                    ps = connection.compileStatement(sql);
                    //ps = connection.prepareStatement(sql);

                    int i = 1, insertados = 0;
                    for (Object entidad : entidades) {
                        insertados = est.setPrepareStamentParams(ps, i, entidad, false);
                        i = i + insertados;
                    }
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            throw new Exception("Insertar Lista: " + e.getMessage());
        }
    }

    public void actualizar(SQLiteDatabase connection, Map<String, Object> campos, String where, Object... params)
            throws Exception {
        SqlLiteEstructuraORM est = getMainEstructuraORM();

        String sql = "update " + est.getNombre() + " set ";

        Object[] par = new Object[campos.keySet().size() + params.length];

        int c = -1;
        for (String key : campos.keySet()) {
            sql = sql + " " + key + " = ?";
            c++;
            par[c] = campos.get(key);
        }

        for (Object o : params) {
            c++;
            par[c] = o;
        }

        sql = sql.concat(" where ").concat(where);
        SQLiteStatement ps;
//        PreparedStatement ps;
        try {
            ps = connection.compileStatement(sql);
//            ps = connection.prepareStatement(sql);

            for (int i = 0; i < par.length; i++) {
                ps.bindString(i + 1, par[i].toString());
//                ps.setObject(i + 1, par[i]);
            }
            ps.executeUpdateDelete();
//            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Actualizar: " + e.getMessage());
        }
    }


    public List<EntityTuple> execSelect(SQLiteDatabase connection) throws Exception {
        List<EntityTuple> resultado = new ArrayList<EntityTuple>();
        String[] params = null;
        String select = getSelectSentence();
        boolean usaGrupo = false;
        if (groupBy != null) {
            usaGrupo = groupBy.size() > 0;
        }
        if(this.paramsWhere!=null){
            if(this.paramsWhere.length>0){
                params = new String[this.paramsWhere.length];
            }
        }
        Cursor ps=null;
        if (!this.where.isEmpty()) {
            int indicadorParametro = 0;
            for (Object v : this.paramsWhere) {
                try {
                    if (v == null) {
                        //ps.setObject(indicadorParametro, null);
                        params[indicadorParametro] = null;
                    } else {
                        if (v instanceof java.util.Date) {
//                            ps.setTimestamp(indicadorParametro, new java.sql.Timestamp(((Date) v).getTime()));
                            params[indicadorParametro] = SqlLiteEstructuraORM.datetimeFormat.format(new java.sql.Timestamp(((Date) v).getTime()));
                        } else {
                            params[indicadorParametro] = v.toString();
//                            ps.setObject(indicadorParametro, v);
                        }
                    }
                } catch (Exception e) {
                    throw new Exception("Var asign Select: " + e.getMessage());
                }
                indicadorParametro++;
            }
        }

        try {
            ps = connection.rawQuery(select, params);
            int datos = ps.getCount();
        } catch (Exception e) {
            throw new Exception("Excecute Query: " + e.getMessage());
        }
        try {
            if (ps != null) {
                ps.moveToFirst();
                while (ps.isAfterLast() == false) {
                    int column = 0;
                    EntityTuple et = new EntityTuple();
                    if (!usaGrupo) {
                        for (int i = 0; i < tablas.size(); i++) {
                            Sextet<String, Class<?>, SqlLiteEstructuraORM, String, String, Boolean> tabla = tablas.get(i);
                            Class<?> entityClass = tabla.getValue1();
                            SqlLiteEstructuraORM estructura = tabla.getValue2();
                            Object entidad;
                            try {
                                entidad = entityClass.newInstance();
                            } catch (InstantiationException | IllegalAccessException e) {
                                throw new Exception("Create entity: " + e.getMessage());
                            }
                            column = poblarCampos(estructura, ps, entidad, column);
                            et.addEntity(tabla.getValue0(), entidad);
                            column++;
                        }
                    } else {
                        for (int i = 0; i < groupBy.size(); i++) {
//						Triplet<Class<?>, String, String> gb = groupBy.get(i);
                            et.addEntity("", ps.getString(i + 1));
                        }
                    }
                    resultado.add(et);
                    ps.moveToNext();
                }
            }
            ps.close();
        } catch (SQLException e) {
            throw new Exception("Read ResultSet: " + e.getMessage());
        }

        return resultado;
    }

    public List<EntityTuple> execSelect() throws Exception {
        return execSelect(iConnection);
    }

    public int poblarCampos(SqlLiteEstructuraORM estructura, Cursor rs, Object efk, int inicio) throws Exception {

        try {
            for (int i = inicio; i < inicio + estructura.getCampos().size(); i++) {

                Pair<Field, EColumna> c = estructura.getCampos().get(i - inicio);

                Field f = c.getValue0();

                if (f.getType() == int.class || f.getType() == Integer.class) {
                    if (rs.getInt(i) == 0) {
                        f.set(efk, 0);
                    } else {
                        f.set(efk, rs.getInt(i));
                    }
                    continue;
                }

                if (f.getType() == short.class || f.getType() == Short.class) {
                    // short vShort = rs.getShort(i);
                    // f.set(efk, vShort);
                    if (rs.getLong(i) == 0) {
                        f.set(efk, 0);
                    } else {
                        short val = rs.getShort(i);
                        f.set(efk, val);
                    }
                    continue;
                }

                if (f.getType() == float.class || f.getType() == Float.class) {
                    if (rs.getDouble(i) == 0.0f) {
                        f.set(efk, 0.0f);
                    } else {
                        f.set(efk, rs.getFloat(i));
                    }
                    continue;
                }

                if (f.getType() == double.class || f.getType() == Double.class) {
                    if (rs.getDouble(i) == 0.0d) {
                        f.set(efk, 0.0d);
                    } else {
                        f.set(efk, rs.getDouble(i));
                    }
                    continue;
                }

                if (f.getType() == String.class) {
                    if (rs.getString(i) == null) {
                        f.set(efk, null);
                    } else {
                        f.set(efk, rs.getString(i));
                    }
                    continue;
                }

                if (f.getType() == Timestamp.class) {
                    if (rs.getString(i) == null)
                        f.set(efk, null);
                    else if(rs.getString(i).equals(""))
                        f.set(efk, null);
                    else {
                        f.set(efk, new Timestamp((SqlLiteEstructuraORM.datetimeFormat.parse(rs.getString(i))).getTime()));
                    }
                    continue;
                }

                if (f.getType() == java.util.Date.class) {

                    if (rs.getString(i) == null )
                        f.set(efk, null);
                    else if(rs.getString(i).equals(""))
                        f.set(efk, null);
                    else
                        f.set(efk, SqlLiteEstructuraORM.datetimeFormat.parse(rs.getString(i)));
                    continue;
                }
                if(rs.getString(i) == null){
                    f.set(efk, null);
                }else{
                    f.set(efk, rs.getString(i));
                }

            }
            return inicio + estructura.getCampos().size()-1;
        } catch (Exception e) {
            throw new Exception("Object asgin: " + e.getMessage());
        }
    }

    public void borrar(SQLiteDatabase connection, Object entidad) throws Exception {
        SqlLiteEstructuraORM est = getMainEstructuraORM();

        String sql, where = "";

        for (Pair<Field, EColumna> c : est.getCampos()) {
            if (c.getValue1().isEsPK()) {
                where = where.concat(where.isEmpty() ? "" : " and ").concat(c.getValue1().getNombre()).concat("=?");
            }
        }

        sql = "delete from ".concat(est.getNombre()).concat(" where ").concat(where);

        SQLiteStatement ps;
//        PreparedStatement ps;
        try {
//            ps = connection.prepareStatement(sql);
            ps = connection.compileStatement(sql);
            int i = -1;

            try {

                for (Pair<Field, EColumna> c : est.getCampos()) {

                    Field f = c.getValue0();

                    if (c.getValue1().isEsPK()) {
                        i++;
                        if (f.getType() == int.class || f.getType() == Integer.class) {
//                            ps.setInt(i + 1, f.getInt(entidad));
                            ps.bindLong(i + 1, f.getInt(entidad));
                            continue;
                        }

                        if (f.getType() == short.class) {
//                            ps.setShort(i + 1, f.getShort(entidad));
                            ps.bindLong(i + 1, f.getShort(entidad));
                            continue;
                        }

                        if (f.getType() == float.class || f.getType() == Float.class) {
//                            ps.setFloat(i + 1, f.getFloat(entidad));
                            ps.bindDouble(i + 1, f.getFloat(entidad));
                            continue;
                        }

                        if (f.getType() == double.class || f.getType() == Double.class) {
//                            ps.setDouble(i + 1, f.getDouble(entidad));
                            ps.bindDouble(i + 1, f.getDouble(entidad));
                            continue;
                        }

                        if (f.getType() == String.class) {
//                            ps.setString(i + 1, String.valueOf(f.get(entidad)));
                            ps.bindString(i + 1, String.valueOf(f.get(entidad)));
                            continue;
                        }

                        if (f.getType() == Timestamp.class) {
//                            ps.setTimestamp(i + 1, (Timestamp) f.get(entidad));
                            ps.bindString(i + 1, SqlLiteEstructuraORM.datetimeFormat.format((Timestamp) f.get(entidad)));
                            continue;
                        }
                        ps.bindString(i + 1, f.get(entidad).toString());
//                        ps.setObject(i + 1, f.get(entidad));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

            ps.execute();

        } catch (Exception e) {
            throw new Exception("Borrar: " + e.getMessage());
        }
    }

    public void actualizar(SQLiteDatabase connection, Object entidad) throws Exception {
        SqlLiteEstructuraORM est = getMainEstructuraORM();

        String sql = est.sentenciaUpdate();
        if (DEBUG) {
            Log.i("", sql);
        }
        try {
            SQLiteStatement ps;
//            PreparedStatement ps;
            ps = connection.compileStatement(sql);

            int ipk = est.getCampos().size()+1;
            try {
                for (int i = 0; i < est.getCampos().size(); i++) {
                    Pair<Field, EColumna> c = est.getCampos().get(i);
                    Field f = c.getValue0();
                    Object o = f.get(entidad);
                    if(o==null)
                        ps.bindNull(i + 1);
                    else{
                        if (f.getType() == Integer.class || f.getType() == int.class) {
                            ps.bindLong(i + 1, f.getInt(entidad));
                            if (c.getValue1().isEsPK()) {
                                ps.bindLong(i + 1, f.getInt(entidad));
                                ipk++;
                            }
                            continue;
                        }
                        if (f.getType() == short.class) {
                            ps.bindLong(i + 1, f.getShort(entidad));
                            if (c.getValue1().isEsPK()) {
                                ps.bindLong(i + 1, f.getShort(entidad));
                                ipk++;
                            }
                            continue;
                        }
//                        if (f.getType() == Float.class || f.getType() == float.class) {
//                            ps.bindDouble(i + 1, f.getFloat(entidad));
//                            if (c.getValue1().isEsPK()) {
//                                ps.bindDouble(i + 1, f.getFloat(entidad));
//                                ipk++;
//                            }
//                            continue;
//                        }
//                        if (f.getType() == Double.class || f.getType() == double.class) {
//                            ps.bindDouble(i + 1, f.getDouble(entidad.toString()));
//                            if (c.getValue1().isEsPK()) {
//                                ps.bindDouble(i + 1, f.getDouble(entidad.toString()));
//                                ipk++;
//                            }
//                            continue;
//                        }
                        if (f.getType() == String.class) {
                            ps.bindString(i + 1, String.valueOf(f.get(entidad)));
                            if (c.getValue1().isEsPK()) {
                                ps.bindString(i + 1, String.valueOf(f.get(entidad)));
                                ipk++;
                            }
                            continue;
                        }
                        if (f.getType() == Timestamp.class) {
                            ps.bindString(i + 1,SqlLiteEstructuraORM.datetimeFormat.format((Timestamp) f.get(entidad)));
                            if (c.getValue1().isEsPK()) {
//                            ps.setTimestamp(ipk, (Timestamp) f.get(entidad));
                                ps.bindString(ipk,SqlLiteEstructuraORM.datetimeFormat.format((Timestamp) f.get(entidad)));
                                ipk++;
                            }
                            continue;
                        }
                        if (f.getType() == Date.class) {
                            if(o .toString().equals(""))
                                ps.bindString(i + 1, "");
                            else {
                                ps.bindString(i + 1, SqlLiteEstructuraORM.dateFormat.format((Date)o));
//                            ps.setTimestamp(i + 1, new Timestamp(((Date) o).getTime()));
                            }
                            if (c.getValue1().isEsPK()) {
//                            ps.setTimestamp(ipk, new Timestamp(((Date) o).getTime()));
                                ps.bindString(ipk,SqlLiteEstructuraORM.dateFormat.format(o.toString()));
                                ipk++;
                            }
                            continue;
                        }
                        if(o .toString().equals(""))
                            ps.bindString(i + 1, "");
                        else {
                            ps.bindString(i + 1, o.toString());
                        }
                        if (c.getValue1().isEsPK()) {
                            ps.bindString(ipk, f.get(entidad).toString());
                            ipk++;
                        }
                    }

                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            ps.execute();

        } catch (Exception e) {
            throw new Exception("Actualiza: " + e.getMessage());
        }
    }

    public void borrar(SQLiteDatabase connection, String cwhere, Object... params) throws Exception {
        try {
            SqlLiteEstructuraORM est = getMainEstructuraORM();

            int indicadorParametro = 0;
            String sql = "delete from ".concat(est.getNombre());

            sql = sql.concat(" where ".concat(cwhere));

            if (DEBUG) {
                Log.i("", sql);
            }
            SQLiteStatement ps;
//            PreparedStatement ps;

            ps = connection.compileStatement(sql);

            for (Object v : params) {
                indicadorParametro++;
                if (v instanceof java.util.Date) {
                    ps.bindString(indicadorParametro,SqlLiteEstructuraORM.datetimeFormat.format(new java.sql.Timestamp(((Date) v).getTime())));
//                    ps.setTimestamp(indicadorParametro, new java.sql.Timestamp(((Date) v).getTime()));
                } else {
                    ps.bindString(indicadorParametro,v.toString());
//                    ps.setObject(indicadorParametro, v);
                }
            }

            ps.execute();
        } catch (Exception e) {
            throw new Exception("Borrar String: " + e.getMessage());
        }

    }

    public SQLiteDatabase getiConnection() {
        return iConnection;
    }

    public void setiConnection(SQLiteDatabase iConnection) {
        this.iConnection = iConnection;
    }
}
