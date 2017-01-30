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

public class EmisorDao extends BaseDao<Emisor> {
	public EmisorDao() {
		super(Emisor.class);
	}
	public EmisorDao(boolean usaCnBase) throws Exception {
		super(Emisor.class, usaCnBase);
	}

	public Boolean insert(Emisor emisor) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",emisor.getIdempresa()); 
			initialValues.put("IDEMISOR",emisor.getIdemisor()); 
			initialValues.put("DESCRIPCION",emisor.getDescripcion()); 
			initialValues.put("ESTADO",emisor.getEstado()); 
			initialValues.put("SINCRONIZA",emisor.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(emisor.getFechacreacion() ) ); 
			resultado = mDb.insert("EMISOR",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Emisor emisor,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",emisor.getIdempresa()) ; 
			initialValues.put("IDEMISOR",emisor.getIdemisor()) ; 
			initialValues.put("DESCRIPCION",emisor.getDescripcion()) ; 
			initialValues.put("ESTADO",emisor.getEstado()) ; 
			initialValues.put("SINCRONIZA",emisor.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(emisor.getFechacreacion() ) ) ; 
			resultado = mDb.update("EMISOR",initialValues,where,null)>0; 
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
			resultado = mDb.delete("EMISOR",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Emisor> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Emisor> lista  = new ArrayList<Emisor>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("EMISOR",
					new String[] {
							 "IDEMPRESA" ,
							 "IDEMISOR" ,
							 "DESCRIPCION" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Emisor emisor = new Emisor() ;
					emisor.setIdempresa(cur.getString(j++));
					emisor.setIdemisor(cur.getString(j++));
					emisor.setDescripcion(cur.getString(j++));
					emisor.setEstado(cur.getDouble(j++));
					emisor.setSincroniza(cur.getString(j++));
					emisor.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(emisor); 
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