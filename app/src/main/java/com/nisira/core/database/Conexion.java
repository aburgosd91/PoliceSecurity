package com.nisira.core.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by aburgos on 13/01/2017.
 */

public class Conexion {

    public static SQLiteDatabase obtenerConexion(String file) throws Exception{
        SQLiteDatabase connection  = SQLiteDatabase.openDatabase(file,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return connection;
    }
    protected void cerrar(SQLiteDatabase connection) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
