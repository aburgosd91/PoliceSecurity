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

public class Estructura_costos_mano_obraDao extends BaseDao<Estructura_costos_mano_obra> {
	public Estructura_costos_mano_obraDao() {
		super(Estructura_costos_mano_obra.class);
	}
	public Estructura_costos_mano_obraDao(boolean usaCnBase) throws Exception {
		super(Estructura_costos_mano_obra.class, usaCnBase);
	}

	public Boolean insert(Estructura_costos_mano_obra estructura_costos_mano_obra) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_mano_obra.getIdempresa()); 
			initialValues.put("CODIGO",estructura_costos_mano_obra.getCodigo()); 
			initialValues.put("IDCARGO",estructura_costos_mano_obra.getIdcargo()); 
			initialValues.put("ITEM",estructura_costos_mano_obra.getItem()); 
			initialValues.put("ESTADO",estructura_costos_mano_obra.getEstado()); 
			initialValues.put("IDPRODUCTO",estructura_costos_mano_obra.getIdproducto()); 
			resultado = mDb.insert("ESTRUCTURA_COSTOS_MANO_OBRA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estructura_costos_mano_obra estructura_costos_mano_obra,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_mano_obra.getIdempresa()) ; 
			initialValues.put("CODIGO",estructura_costos_mano_obra.getCodigo()) ; 
			initialValues.put("IDCARGO",estructura_costos_mano_obra.getIdcargo()) ; 
			initialValues.put("ITEM",estructura_costos_mano_obra.getItem()) ; 
			initialValues.put("ESTADO",estructura_costos_mano_obra.getEstado()) ; 
			initialValues.put("IDPRODUCTO",estructura_costos_mano_obra.getIdproducto()) ; 
			resultado = mDb.update("ESTRUCTURA_COSTOS_MANO_OBRA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTRUCTURA_COSTOS_MANO_OBRA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estructura_costos_mano_obra> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estructura_costos_mano_obra> lista  = new ArrayList<Estructura_costos_mano_obra>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTRUCTURA_COSTOS_MANO_OBRA",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "IDCARGO" ,
							 "ITEM" ,
							 "ESTADO" ,
							 "IDPRODUCTO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estructura_costos_mano_obra estructura_costos_mano_obra = new Estructura_costos_mano_obra() ;
					estructura_costos_mano_obra.setIdempresa(cur.getString(j++));
					estructura_costos_mano_obra.setCodigo(cur.getString(j++));
					estructura_costos_mano_obra.setIdcargo(cur.getString(j++));
					estructura_costos_mano_obra.setItem(cur.getString(j++));
					estructura_costos_mano_obra.setEstado(cur.getDouble(j++));
					estructura_costos_mano_obra.setIdproducto(cur.getString(j++));

					lista.add(estructura_costos_mano_obra); 
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