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

public class TsyncmovilDao extends BaseDao<Tsyncmovil> {
	public TsyncmovilDao() {
		super(Tsyncmovil.class);
	}
	public TsyncmovilDao(boolean usaCnBase) throws Exception {
		super(Tsyncmovil.class, usaCnBase);
	}

	public Boolean insert(Tsyncmovil tsyncmovil) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",tsyncmovil.getIdempresa()); 
			initialValues.put("IDAPPMOVIL",tsyncmovil.getIdappmovil()); 
			initialValues.put("TABLA",tsyncmovil.getTabla()); 
			initialValues.put("IDSERIEMOVIL",tsyncmovil.getIdseriemovil()); 
			initialValues.put("FECHA",dateFormat.format(tsyncmovil.getFecha() ) ); 
			resultado = mDb.insert("TSYNCMOVIL",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Tsyncmovil tsyncmovil,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",tsyncmovil.getIdempresa()) ; 
			initialValues.put("IDAPPMOVIL",tsyncmovil.getIdappmovil()) ; 
			initialValues.put("TABLA",tsyncmovil.getTabla()) ; 
			initialValues.put("IDSERIEMOVIL",tsyncmovil.getIdseriemovil()) ; 
			initialValues.put("FECHA",dateFormat.format(tsyncmovil.getFecha() ) ) ; 
			resultado = mDb.update("TSYNCMOVIL",initialValues,where,null)>0; 
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
			resultado = mDb.delete("TSYNCMOVIL",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Tsyncmovil> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Tsyncmovil> lista  = new ArrayList<Tsyncmovil>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("TSYNCMOVIL",
					new String[] {
							 "IDEMPRESA" ,
							 "IDAPPMOVIL" ,
							 "TABLA" ,
							 "IDSERIEMOVIL" ,
							 "FECHA" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Tsyncmovil tsyncmovil = new Tsyncmovil() ;
					tsyncmovil.setIdempresa(cur.getString(j++));
					tsyncmovil.setIdappmovil(cur.getString(j++));
					tsyncmovil.setTabla(cur.getString(j++));
					tsyncmovil.setIdseriemovil(cur.getString(j++));
					tsyncmovil.setFecha(dateFormat.parse(cur.getString(j++)) );

					lista.add(tsyncmovil); 
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