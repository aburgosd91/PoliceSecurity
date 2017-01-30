package com.nisira.core.dao;

import android.database.sqlite.SQLiteDatabase;

import com.nisira.annotation.ECampoRelacionado;
import com.nisira.core.AbstractEntity;
import com.nisira.core.EntityTuple;
import com.nisira.core.database.Conexion;
import com.nisira.core.database.DataBaseClass;
import com.nisira.core.database.SqlLiteConsulta;
import com.nisira.core.database.SqlLiteEstructuraORM;

import org.javatuples.Pair;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aburgos on 13/01/2017.
 */

public abstract class BaseDao<E> extends Conexion {
    protected Class<E> entityClass;
    protected SQLiteDatabase cnBase;
    protected boolean usaCnBase;

    protected SQLiteDatabase commonConnection = null;

    public SQLiteDatabase getConnection() {
        return cnBase;
    }

    public BaseDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public BaseDao(Class<E> entityClass, boolean usaCnBase) throws Exception {
        this(entityClass);
        if (usaCnBase) {
            iniciarConexion();
        }
    }

    public SqlLiteConsulta getInstancia() throws Exception {
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");

        if (commonConnection != null) {
            c.setiConnection(commonConnection);
        } else {
            if (usaCnBase) {
                c.setiConnection(cnBase);
            } else {
                c.setiConnection(obtenerConexion(DataBaseClass.PATH_DATABASE));
            }
        }

        return c;
    }

    public SqlLiteConsulta getInstancia(Class<?> clase, String alias) throws Exception {
        SqlLiteConsulta c = new SqlLiteConsulta(clase, alias);

        if (commonConnection != null) {
            c.setiConnection(commonConnection);
        } else {
            if (usaCnBase) {
                c.setiConnection(cnBase);
            } else {
                c.setiConnection(obtenerConexion(DataBaseClass.PATH_DATABASE));
            }
        }

        return c;
    }

    @Override
    protected void finalize() throws Throwable {
        if (usaCnBase) {
            usaCnBase = false;
            cnBase.close();
        }
    };

    public void actualizar(Map<String, Object> campos, String where, Object... params) throws Exception {
        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");
        if (commonConnection != null) {
            c.actualizar(commonConnection, campos, where, params);
        } else {
            if (usaCnBase) {
                c.actualizar(cnBase, campos, where, params);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.actualizar(cn, campos, where, params);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }

    }

    public void borrar(E entidad) throws Exception {

        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");
        if (commonConnection != null) {
            c.borrar(commonConnection, entidad);
        } else {
            if (usaCnBase) {
                c.borrar(cnBase, entidad);

            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.borrar(cn, entidad);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }
    }

    public void actualizar(E entidad) throws Exception {
        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");

        if (entidad instanceof AbstractEntity) {
            ((AbstractEntity) entidad).setFieldChecksum();
        }
        if (commonConnection != null) {
            c.actualizar(commonConnection, entidad);
        } else {
            if (usaCnBase) {
                c.actualizar(cnBase, entidad);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.actualizar(cn, entidad);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }
    }

    public void mezclar(E entidad) throws Exception {

        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");

        if (entidad instanceof AbstractEntity) {
            ((AbstractEntity) entidad).setFieldChecksum();
        }
        if (commonConnection != null) {
            c.mezclar(commonConnection, entidad);
        } else {
            if (usaCnBase) {
                c.mezclar(cnBase, entidad);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.mezclar(cn, entidad);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }
    }

    public void insertar(E entidad) throws Exception {

        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");
        if (entidad instanceof AbstractEntity) {
            ((AbstractEntity) entidad).setFieldChecksum();
        }

        if (commonConnection != null) {
            c.insertar(commonConnection, entidad);
        } else {
            if (usaCnBase) {
                c.insertar(cnBase, entidad);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.insertar(cn, entidad);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }

    }

    public void insertar(List<E> entidades) throws Exception {
        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");
        for (E entidad : entidades) {
            if (entidad instanceof AbstractEntity) {
                ((AbstractEntity) entidad).setFieldChecksum();
            }
        }
        if (commonConnection != null) {
            c.insertar(commonConnection, entidades);
        } else {
            if (usaCnBase) {
                c.insertar(cnBase, entidades);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.insertar(cn, entidades);
                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }
    }

    public void iniciarConexion() throws Exception {
        cnBase = obtenerConexion(DataBaseClass.PATH_DATABASE);
        usaCnBase = true;
    }

    public void finalizarConexion() throws Exception {
        usaCnBase = false;
        cnBase.close();
    }

    public void borrar(String cwhere, Object... params) throws Exception {
        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");

        if (commonConnection != null) {
            c.borrar(commonConnection, cwhere, params);
        } else {

            if (usaCnBase) {
                c.borrar(cnBase, cwhere, params);
            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);
                c.borrar(cn, cwhere, params);

                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error Close: " + e.getMessage());
                }
            }
        }
    }

    public List<E> listar(String cwhere, Object... params) throws Exception {
        List<E> lista = new ArrayList<E>();
        lista = listar(false, cwhere, params);

        return lista;
    }

    @SuppressWarnings("unchecked")
    public List<E> listar(boolean ref, String cwhere, Object... params) throws Exception {
        List<E> lista = new ArrayList<E>();
        SQLiteDatabase cn = null;
        SqlLiteConsulta c = new SqlLiteConsulta(this.entityClass, "t0");
        SqlLiteEstructuraORM est = c.getMainEstructuraORM();

        if (ref) {
            int i = 0;
            for (Pair<Field, ECampoRelacionado> foreign : est.getListaClaveForanea()) {

                String alias = "t" + String.valueOf(i);
                Field f = foreign.getValue0();

                String onquery = "";
                int ii = 0;
                for (Pair<String, String> refer : foreign.getValue1().getReferencia()) {
                    if (ii != 0) {
                        onquery = onquery.concat(" and ");
                    }
                    onquery = onquery.concat(" t0.".concat(refer.getValue0())).concat(" = ").concat(alias).concat(".")
                            .concat(refer.getValue1());
                    ii++;
                }
                c.join("left", f.getType(), alias, onquery);
                i++;
            }
        }

        if (!cwhere.isEmpty()) {
            c.where(cwhere, params);
        }
        List<EntityTuple> et = null;

        if (commonConnection != null) {
            et = c.execSelect(commonConnection);
        } else {

            if (usaCnBase) {
                et = c.execSelect(cnBase);

            } else {
                cn = obtenerConexion(DataBaseClass.PATH_DATABASE);

                et = c.execSelect(cn);

                try {
                    cn.close();
                } catch (Exception e) {
                    throw new Exception("Error al crear conexión : " + e.getMessage());
                }
            }
        }
        for (EntityTuple ent : et) {
            Object entidad = ent.get("t0");
            int i = 0;
            if (ref) {
                for (Pair<Field, ECampoRelacionado> foreign : est.getListaClaveForanea()) {
                    String alias = "t" + String.valueOf(i);
                    Object campoRef = ent.get(alias);
                    foreign.getValue0().setAccessible(true);
                    try {
                        foreign.getValue0().set(entidad, campoRef);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new Exception("Error Listar: " + e.getMessage());
                    }
                    i++;
                }
            }
            lista.add((E) entidad);
        }
        return lista;
    }

    public List<E> listar() throws Exception {
        return listar("", new Object[] { null });
    }

    public List<E> listar(boolean ref) throws Exception {
        return listar(ref, "", new Object[] { null });
    }

    public List<Object[]> rsToObjectArray(ResultSet rs) throws SQLException {
        ResultSetMetaData rm = rs.getMetaData();
        int numCols = rm.getColumnCount();

        List<Object[]> lista = new ArrayList<Object[]>();

        while (rs.next()) {
            Object[] reg = new Object[numCols];

            for (int i = 0; i < numCols; i++) {
                reg[i] = rs.getObject(i + 1);
            }
            lista.add(reg);
        }
        return lista;
    }

    public SQLiteDatabase getCommonConnection() {
        return commonConnection;
    }

    public void setCommonConnection(SQLiteDatabase commonConnection) {
        this.commonConnection = commonConnection;
    }


}
