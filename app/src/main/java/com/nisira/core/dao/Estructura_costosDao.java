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

public class Estructura_costosDao extends BaseDao<Estructura_costos> {
	public Estructura_costosDao() {
		super(Estructura_costos.class);
	}
	public Estructura_costosDao(boolean usaCnBase) throws Exception {
		super(Estructura_costos.class, usaCnBase);
	}

	public Boolean insert(Estructura_costos estructura_costos) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos.getIdempresa()); 
			initialValues.put("CODIGO",estructura_costos.getCodigo()); 
			initialValues.put("DESCRIPCION",estructura_costos.getDescripcion()); 
			initialValues.put("NOMBRE_CORTO",estructura_costos.getNombre_corto()); 
			initialValues.put("ESTADO",estructura_costos.getEstado()); 
			initialValues.put("IDMONEDA",estructura_costos.getIdmoneda()); 
			initialValues.put("FECHACREACION",dateFormat.format(estructura_costos.getFechacreacion() ) ); 
			resultado = mDb.insert("ESTRUCTURA_COSTOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estructura_costos estructura_costos,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos.getIdempresa()) ; 
			initialValues.put("CODIGO",estructura_costos.getCodigo()) ; 
			initialValues.put("DESCRIPCION",estructura_costos.getDescripcion()) ; 
			initialValues.put("NOMBRE_CORTO",estructura_costos.getNombre_corto()) ; 
			initialValues.put("ESTADO",estructura_costos.getEstado()) ; 
			initialValues.put("IDMONEDA",estructura_costos.getIdmoneda()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(estructura_costos.getFechacreacion() ) ) ; 
			resultado = mDb.update("ESTRUCTURA_COSTOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTRUCTURA_COSTOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estructura_costos> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estructura_costos> lista  = new ArrayList<Estructura_costos>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTRUCTURA_COSTOS",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "DESCRIPCION" ,
							 "NOMBRE_CORTO" ,
							 "ESTADO" ,
							 "IDMONEDA" ,
							 "FECHACREACION" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estructura_costos estructura_costos = new Estructura_costos() ;
					estructura_costos.setIdempresa(cur.getString(j++));
					estructura_costos.setCodigo(cur.getString(j++));
					estructura_costos.setDescripcion(cur.getString(j++));
					estructura_costos.setNombre_corto(cur.getString(j++));
					estructura_costos.setEstado(cur.getDouble(j++));
					estructura_costos.setIdmoneda(cur.getString(j++));
					estructura_costos.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(estructura_costos); 
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