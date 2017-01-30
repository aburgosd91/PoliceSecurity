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

public class IdordenliquidaciongastoDao extends BaseDao<Idordenliquidaciongasto> {
	public IdordenliquidaciongastoDao() {
		super(Idordenliquidaciongasto.class);
	}
	public IdordenliquidaciongastoDao(boolean usaCnBase) throws Exception {
		super(Idordenliquidaciongasto.class, usaCnBase);
	}

	public Boolean insert(Idordenliquidaciongasto idordenliquidaciongasto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",idordenliquidaciongasto.getIdempresa()); 
			initialValues.put("IDORDEN",idordenliquidaciongasto.getIdorden()); 
			initialValues.put("ITEM",idordenliquidaciongasto.getItem()); 
			initialValues.put("IDIMPUESTO",idordenliquidaciongasto.getIdimpuesto()); 
			initialValues.put("SUBITEM",idordenliquidaciongasto.getSubitem()); 
			initialValues.put("VALOR",idordenliquidaciongasto.getValor()); 
			initialValues.put("BASEIMPONIBLE",idordenliquidaciongasto.getBaseimponible()); 
			initialValues.put("IMPUESTO",idordenliquidaciongasto.getImpuesto()); 
			initialValues.put("IDCUENTA",idordenliquidaciongasto.getIdcuenta()); 
			initialValues.put("IDCCOSTO",idordenliquidaciongasto.getIdccosto()); 
			initialValues.put("ORDEN",idordenliquidaciongasto.getOrden()); 
			initialValues.put("PORCENTUAL",idordenliquidaciongasto.getPorcentual()); 
			initialValues.put("APLICAIANTERIOR",idordenliquidaciongasto.getAplicaianterior()); 
			resultado = mDb.insert("IDORDENLIQUIDACIONGASTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Idordenliquidaciongasto idordenliquidaciongasto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",idordenliquidaciongasto.getIdempresa()) ; 
			initialValues.put("IDORDEN",idordenliquidaciongasto.getIdorden()) ; 
			initialValues.put("ITEM",idordenliquidaciongasto.getItem()) ; 
			initialValues.put("IDIMPUESTO",idordenliquidaciongasto.getIdimpuesto()) ; 
			initialValues.put("SUBITEM",idordenliquidaciongasto.getSubitem()) ; 
			initialValues.put("VALOR",idordenliquidaciongasto.getValor()) ; 
			initialValues.put("BASEIMPONIBLE",idordenliquidaciongasto.getBaseimponible()) ; 
			initialValues.put("IMPUESTO",idordenliquidaciongasto.getImpuesto()) ; 
			initialValues.put("IDCUENTA",idordenliquidaciongasto.getIdcuenta()) ; 
			initialValues.put("IDCCOSTO",idordenliquidaciongasto.getIdccosto()) ; 
			initialValues.put("ORDEN",idordenliquidaciongasto.getOrden()) ; 
			initialValues.put("PORCENTUAL",idordenliquidaciongasto.getPorcentual()) ; 
			initialValues.put("APLICAIANTERIOR",idordenliquidaciongasto.getAplicaianterior()) ; 
			resultado = mDb.update("IDORDENLIQUIDACIONGASTO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("IDORDENLIQUIDACIONGASTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Idordenliquidaciongasto> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Idordenliquidaciongasto> lista  = new ArrayList<Idordenliquidaciongasto>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("IDORDENLIQUIDACIONGASTO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDEN" ,
							 "ITEM" ,
							 "IDIMPUESTO" ,
							 "SUBITEM" ,
							 "VALOR" ,
							 "BASEIMPONIBLE" ,
							 "IMPUESTO" ,
							 "IDCUENTA" ,
							 "IDCCOSTO" ,
							 "ORDEN" ,
							 "PORCENTUAL" ,
							 "APLICAIANTERIOR" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Idordenliquidaciongasto idordenliquidaciongasto = new Idordenliquidaciongasto() ;
					idordenliquidaciongasto.setIdempresa(cur.getString(j++));
					idordenliquidaciongasto.setIdorden(cur.getString(j++));
					idordenliquidaciongasto.setItem(cur.getString(j++));
					idordenliquidaciongasto.setIdimpuesto(cur.getString(j++));
					idordenliquidaciongasto.setSubitem(cur.getString(j++));
					idordenliquidaciongasto.setValor(cur.getDouble(j++));
					idordenliquidaciongasto.setBaseimponible(cur.getDouble(j++));
					idordenliquidaciongasto.setImpuesto(cur.getDouble(j++));
					idordenliquidaciongasto.setIdcuenta(cur.getString(j++));
					idordenliquidaciongasto.setIdccosto(cur.getString(j++));
					idordenliquidaciongasto.setOrden(cur.getDouble(j++));
					idordenliquidaciongasto.setPorcentual(cur.getDouble(j++));
					idordenliquidaciongasto.setAplicaianterior(cur.getDouble(j++));

					lista.add(idordenliquidaciongasto); 
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