package com.nisira.core.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.nisira.generator.Columna;
import com.nisira.generator.MainEje;
import com.nisira.generator.Tabla;

import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseClass {

    public static File externalStorage = Environment.getExternalStorageDirectory();
    public static String FOLDER_BASE_SISTEMA = externalStorage.getAbsolutePath();

    public static String FOLDER_BASE_APP = FOLDER_BASE_SISTEMA+"/nsrtmpdroid";  // \.nsr*ABREVIATURA_APP*droid

    public static String FOLDER_DATABASE = FOLDER_BASE_APP+"/reg/";

    public static String FOLDER_EXCEL = FOLDER_BASE_APP+"/excel/";
    public static String FOLDER_BACKUP = FOLDER_BASE_APP+"/back/";
    public static String DATABASE_NAME_SDCARD = "tmp.nsr";
    public static String DATABASE_NAME_MEMORY = "data";
    public static String DATABASE_VERSION= "1";

    public static String PATH_DATABASE=FOLDER_DATABASE+DATABASE_NAME_SDCARD;

    public static boolean ExistsDB() {
        SQLiteDatabase checkDB = null;
        try
        {
            checkDB = SQLiteDatabase.openDatabase(PATH_DATABASE, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public static void SincronizarDB(Context ctx)
    {

        File directorio = new File(FOLDER_DATABASE);
        directorio.mkdirs();

        directorio = new File(FOLDER_BACKUP);
        directorio.mkdirs();

        directorio = new File(FOLDER_EXCEL);
        directorio.mkdirs();
        try {
            if (!ExistsDB()){
                SQLiteDatabase myDB= null;
                try {
                    myDB = SQLiteDatabase.openOrCreateDatabase(PATH_DATABASE, null);

                }
                catch(Exception e) {
                    String error = e.toString();
                    e.printStackTrace();
                } finally {
                    if (myDB != null)
                        myDB.close();
                }
            }

            SincronizarEstructuraDB(ctx);
        }
        catch (Exception e)
        {
            String error = e.toString();
            e.printStackTrace();
        }
    }


    public static void SincronizarEstructuraDB(Context ctx) {
        String TipoBD = "SQLITE";
        try {

            List<Tabla> lista = retornaEstructura();

            InputStream filesync_stream = ctx.getAssets().open("file.nsrsync");

            ObjectInputStream ingreso = new ObjectInputStream(filesync_stream);

            List<Tabla> lstUpd = (List<Tabla>) ingreso.readObject();

            List<Tabla> listaCircular = MainEje.getClavesCirculares(lstUpd);

            List<Tabla> lstOrden = new ArrayList<Tabla>();

            boolean continuar = lstUpd.size() > 0;
            while (continuar) {
                for (int i = 0; i < lstUpd.size(); i++) {
                    Tabla t = lstUpd.get(i);
                    if (!MainEje.existeReferencia(t, lstUpd, listaCircular)) {
                        lstOrden.add(t);
                        lstUpd.remove(t);

                        break;
                    }
                }
                continuar = lstUpd.size() > 0;
            }

            // Con lista ordenada realizar ejecución de Scripts

            SQLiteDatabase myDB = null;
            myDB = SQLiteDatabase.openOrCreateDatabase(PATH_DATABASE, null);
            for (Tabla t : lstOrden) {

                // Buscar T en BD actual
                Tabla tblAct = null;

                for (Tabla o : lista) {
                    if (t.getNombre().equalsIgnoreCase(o.getNombre())) {
                        tblAct = o;
                        break;
                    }
                }

                if (tblAct != null) { // Existe
                    // Buscar si existe campos
                    for (Columna c : t.getColumnas()) {
                        Columna oc = null;
                        for (Columna o : tblAct.getColumnas()) {
                            if (c.getNombre().equalsIgnoreCase(o.getNombre())) {
                                oc = o;
                                break;
                            }
                        }

                        if (oc != null) {
                            /*
                            if (!c.igualEstructura(oc)) {
                                //SQLITE MODIFICAR COLUMNA
                                String query = t.queryModificaColumna(TipoBD,c);
                                System.out.println("SQL QUERY:"+query);
                                String result = cGen.ejecutarSQL(query);

                                if (!result.isEmpty()) {
                                    //txtLog.append(result);
                                }
                            }
                            */
                        } else {
                            //SQLITE CREAR COLUMNA
                            String query = t.queryCreaColumna(TipoBD,c);
                            System.out.println("SQL QUERY:"+query);

                            myDB.execSQL(query);

                        }
                    }

                } else {
                    // Crear Tabla con Clave Primaria
                    String result = "";
                    String query = t.queryCrearconClavePrimaria(TipoBD);
                    System.out.println("SQL QUERY:"+query);
                    myDB.execSQL(query);

                }
            }
            myDB.close();

            ingreso.close();

        } catch (Exception e) {
            e.printStackTrace();
            //UtilMensajes.mensaje_error("NO_ARCHIVO_CONFIG");
        }
    }

    public static List<Tabla> retornaEstructura() {

        List<Tabla> lst = new ArrayList<Tabla>();

        try {

            String aTabla = "";
            Tabla tabla = null;

            String nom_tabla, nom_columna, tipo, porDefecto;

            int longitud, precision, escala;
            boolean esNulo;

            List<String> lista_tablassqlite = new ArrayList<String>();

            SQLiteDatabase myDB = null;
            myDB = SQLiteDatabase.openOrCreateDatabase(PATH_DATABASE, null);

            String query = "SELECT tbl_name FROM SQLITE_MASTER WHERE name <> 'android_metadata' and type = 'table' ";
            Cursor cur=null;
            cur= myDB.rawQuery(query,null);
            if (cur!=null){
                cur.moveToFirst();
                int i=0;
                while (cur.isAfterLast() == false) {
                    String tabla_name = cur.getString(0);
                    lista_tablassqlite.add(tabla_name);
                    cur.moveToNext();
                }
            }
            myDB.close();

            for(String tabla_name: lista_tablassqlite)
            {
                nom_tabla = tabla_name;

                query = " pragma table_info ('"+nom_tabla+"')";

                myDB = SQLiteDatabase.openOrCreateDatabase(PATH_DATABASE, null);
                cur=null;
                cur= myDB.rawQuery(query,null);
                if (cur!=null){
                    cur.moveToFirst();
                    int i=0;
                    while (cur.isAfterLast() == false) {
                        int j=0;
                        nom_columna = cur.getString(1);//name
                        tipo = cur.getString(2);// type

                        porDefecto = cur.getString(4); //dflt_value
                        longitud = 0;
                        precision = 0;
                        escala = 0;
                        esNulo = (cur.getInt(3) == 0) ? true : false; // notnull

                        if (aTabla.isEmpty() || !aTabla.equalsIgnoreCase(nom_tabla)) {
                            tabla = new Tabla();
                            lst.add(tabla);
                            tabla.setNombre(nom_tabla);
                            tabla.setColumnas(new ArrayList<Columna>());
                        }
                        Columna columna;
                        columna = new Columna();
                        columna.setNombre(nom_columna);
                        columna.setTipo(tipo);
                        columna.setEsNulo(esNulo);
                        columna.setLongitud(longitud);
                        columna.setPrecision(precision);
                        columna.setEscala(escala);
                        columna.setPorDefecto(porDefecto);

                        tabla.getColumnas().add(columna);
                        aTabla = nom_tabla;

                        cur.moveToNext();
                    }
                }
                myDB.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }

        return lst;
    }

}