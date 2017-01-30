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

public class GeopointDao extends BaseDao<Geopoint> {
	public GeopointDao() {
		super(Geopoint.class);
	}
	public GeopointDao(boolean usaCnBase) throws Exception {
		super(Geopoint.class, usaCnBase);
	}

	public Boolean insert(Geopoint geopoint) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDGEOPOINT",geopoint.getIdgeopoint()); 
			initialValues.put("DESCRIPCION",geopoint.getDescripcion()); 
			initialValues.put("LATITUD",geopoint.getLatitud()); 
			initialValues.put("LONGITUD",geopoint.getLongitud()); 
			initialValues.put("IDCLIEPROV",geopoint.getIdclieprov()); 
			initialValues.put("FECHACREACION",dateFormat.format(geopoint.getFechacreacion() ) ); 
			initialValues.put("ESTADO",geopoint.getEstado()); 
			resultado = mDb.insert("GEOPOINT",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Geopoint geopoint,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDGEOPOINT",geopoint.getIdgeopoint()) ; 
			initialValues.put("DESCRIPCION",geopoint.getDescripcion()) ; 
			initialValues.put("LATITUD",geopoint.getLatitud()) ; 
			initialValues.put("LONGITUD",geopoint.getLongitud()) ; 
			initialValues.put("IDCLIEPROV",geopoint.getIdclieprov()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(geopoint.getFechacreacion() ) ) ; 
			initialValues.put("ESTADO",geopoint.getEstado()) ; 
			resultado = mDb.update("GEOPOINT",initialValues,where,null)>0; 
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
			resultado = mDb.delete("GEOPOINT",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Geopoint> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Geopoint> lista  = new ArrayList<Geopoint>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("GEOPOINT",
					new String[] {
							 "IDGEOPOINT" ,
							 "DESCRIPCION" ,
							 "LATITUD" ,
							 "LONGITUD" ,
							 "IDCLIEPROV" ,
							 "FECHACREACION" ,
							 "ESTADO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Geopoint geopoint = new Geopoint() ;
					geopoint.setIdgeopoint(cur.getInt(j++));
					geopoint.setDescripcion(cur.getString(j++));
					geopoint.setLatitud(cur.getFloat(j++));
					geopoint.setLongitud(cur.getFloat(j++));
					geopoint.setIdclieprov(cur.getString(j++));
					geopoint.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					geopoint.setEstado(cur.getInt(j++));

					lista.add(geopoint); 
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