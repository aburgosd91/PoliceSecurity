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

public class AppmovilusuarioDao extends BaseDao<Appmovilusuario> {
	public AppmovilusuarioDao() {
		super(Appmovilusuario.class);
	}
	public AppmovilusuarioDao(boolean usaCnBase) throws Exception {
		super(Appmovilusuario.class, usaCnBase);
	}

	public Boolean insert(Appmovilusuario appmovilusuario) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",appmovilusuario.getIdempresa()); 
			initialValues.put("IDAPPMOVIL",appmovilusuario.getIdappmovil()); 
			initialValues.put("IDUSUARIO",appmovilusuario.getIdusuario()); 
			initialValues.put("IDCLIEPROV",appmovilusuario.getIdclieprov()); 
			resultado = mDb.insert("APPMOVILUSUARIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Appmovilusuario appmovilusuario,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",appmovilusuario.getIdempresa()) ; 
			initialValues.put("IDAPPMOVIL",appmovilusuario.getIdappmovil()) ; 
			initialValues.put("IDUSUARIO",appmovilusuario.getIdusuario()) ; 
			initialValues.put("IDCLIEPROV",appmovilusuario.getIdclieprov()) ; 
			resultado = mDb.update("APPMOVILUSUARIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("APPMOVILUSUARIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Appmovilusuario> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Appmovilusuario> lista  = new ArrayList<Appmovilusuario>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("APPMOVILUSUARIO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDAPPMOVIL" ,
							 "IDUSUARIO" ,
							 "IDCLIEPROV" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Appmovilusuario appmovilusuario = new Appmovilusuario() ;
					appmovilusuario.setIdempresa(cur.getString(j++));
					appmovilusuario.setIdappmovil(cur.getString(j++));
					appmovilusuario.setIdusuario(cur.getString(j++));
					appmovilusuario.setIdclieprov(cur.getString(j++));

					lista.add(appmovilusuario); 
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