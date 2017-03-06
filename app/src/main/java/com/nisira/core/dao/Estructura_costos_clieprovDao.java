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

public class Estructura_costos_clieprovDao extends BaseDao<Estructura_costos_clieprov> {
	public Estructura_costos_clieprovDao() {
		super(Estructura_costos_clieprov.class);
	}
	public Estructura_costos_clieprovDao(boolean usaCnBase) throws Exception {
		super(Estructura_costos_clieprov.class, usaCnBase);
	}

	public Boolean insert(Estructura_costos_clieprov estructura_costos_clieprov) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_clieprov.getIdempresa()); 
			initialValues.put("CODIGO",estructura_costos_clieprov.getCodigo()); 
			initialValues.put("IDCLIEPROV",estructura_costos_clieprov.getIdclieprov()); 
			initialValues.put("ESTADO",estructura_costos_clieprov.getEstado()); 
			resultado = mDb.insert("ESTRUCTURA_COSTOS_CLIEPROV",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estructura_costos_clieprov estructura_costos_clieprov,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_clieprov.getIdempresa()) ; 
			initialValues.put("CODIGO",estructura_costos_clieprov.getCodigo()) ; 
			initialValues.put("IDCLIEPROV",estructura_costos_clieprov.getIdclieprov()) ; 
			initialValues.put("ESTADO",estructura_costos_clieprov.getEstado()) ; 
			resultado = mDb.update("ESTRUCTURA_COSTOS_CLIEPROV",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTRUCTURA_COSTOS_CLIEPROV",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estructura_costos_clieprov> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estructura_costos_clieprov> lista  = new ArrayList<Estructura_costos_clieprov>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTRUCTURA_COSTOS_CLIEPROV",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "IDCLIEPROV" ,
							 "ESTADO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estructura_costos_clieprov estructura_costos_clieprov = new Estructura_costos_clieprov() ;
					estructura_costos_clieprov.setIdempresa(cur.getString(j++));
					estructura_costos_clieprov.setCodigo(cur.getString(j++));
					estructura_costos_clieprov.setIdclieprov(cur.getString(j++));
					estructura_costos_clieprov.setEstado(cur.getDouble(j++));

					lista.add(estructura_costos_clieprov); 
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