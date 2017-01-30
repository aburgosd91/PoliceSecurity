package com.nisira.core.dao;

import com.nisira.core.entity.*;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.nisira.core.database.DataBaseClass;
import android.content.ContentValues;
import android.database.Cursor;
import com.nisira.core.util.ClaveMovil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ruta_serviciosDao extends BaseDao<Ruta_servicios> {
	public Ruta_serviciosDao() {
		super(Ruta_servicios.class);
	}
	public Ruta_serviciosDao(boolean usaCnBase) throws Exception {
		super(Ruta_servicios.class, usaCnBase);
	}

	public Boolean insert(Ruta_servicios ruta_servicios) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",ruta_servicios.getIdempresa()); 
			initialValues.put("IDORDENSERVICIO",ruta_servicios.getIdordenservicio()); 
			initialValues.put("ITEM",ruta_servicios.getItem()); 
			initialValues.put("ITEMRUTA",ruta_servicios.getItemruta()); 
			initialValues.put("IDRUTA",ruta_servicios.getIdruta()); 
			initialValues.put("LATITUD",ruta_servicios.getLatitud()); 
			initialValues.put("LONGITUD",ruta_servicios.getLongitud()); 
			initialValues.put("GLOSA",ruta_servicios.getGlosa()); 
			initialValues.put("FECHACREACION",dateFormat.format(ruta_servicios.getFechacreacion() ) ); 
			resultado = mDb.insert("RUTA_SERVICIOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Ruta_servicios ruta_servicios,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",ruta_servicios.getIdempresa()) ; 
			initialValues.put("IDORDENSERVICIO",ruta_servicios.getIdordenservicio()) ; 
			initialValues.put("ITEM",ruta_servicios.getItem()) ; 
			initialValues.put("ITEMRUTA",ruta_servicios.getItemruta()) ; 
			initialValues.put("IDRUTA",ruta_servicios.getIdruta()) ; 
			initialValues.put("LATITUD",ruta_servicios.getLatitud()) ; 
			initialValues.put("LONGITUD",ruta_servicios.getLongitud()) ; 
			initialValues.put("GLOSA",ruta_servicios.getGlosa()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(ruta_servicios.getFechacreacion() ) ) ; 
			resultado = mDb.update("RUTA_SERVICIOS",initialValues,where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boolean delete(String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			resultado = mDb.delete("RUTA_SERVICIOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Ruta_servicios> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Ruta_servicios> lista  = new ArrayList<Ruta_servicios>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("RUTA_SERVICIOS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDENSERVICIO" ,
							 "ITEM" ,
							 "ITEMRUTA" ,
							 "IDRUTA" ,
							 "LATITUD" ,
							 "LONGITUD" ,
							 "GLOSA" ,
							 "FECHACREACION" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Ruta_servicios ruta_servicios = new Ruta_servicios() ;
					ruta_servicios.setIdempresa(cur.getString(j++));
					ruta_servicios.setIdordenservicio(cur.getString(j++));
					ruta_servicios.setItem(cur.getString(j++));
					ruta_servicios.setItemruta(cur.getString(j++));
					ruta_servicios.setIdruta(cur.getString(j++));
					ruta_servicios.setLatitud(cur.getString(j++));
					ruta_servicios.setLongitud(cur.getString(j++));
					ruta_servicios.setGlosa(cur.getString(j++));
					ruta_servicios.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(ruta_servicios); 
					i++; 
					if(i == limit){ 
						break; 
					} 
					cur.moveToNext(); 
				} 
				cur.close(); 
			} 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return lista; 
	} 
}