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

public class Estructura_costos_mano_obra_cotizacionventasDao extends BaseDao<Estructura_costos_mano_obra_cotizacionventas> {
	public Estructura_costos_mano_obra_cotizacionventasDao() {
		super(Estructura_costos_mano_obra_cotizacionventas.class);
	}
	public Estructura_costos_mano_obra_cotizacionventasDao(boolean usaCnBase) throws Exception {
		super(Estructura_costos_mano_obra_cotizacionventas.class, usaCnBase);
	}

	public Boolean insert(Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra_cotizacionventas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_mano_obra_cotizacionventas.getIdempresa()); 
			initialValues.put("CODIGO",estructura_costos_mano_obra_cotizacionventas.getCodigo()); 
			initialValues.put("IDCOTIZACIONV",estructura_costos_mano_obra_cotizacionventas.getIdcotizacionv()); 
			initialValues.put("IDCARGO",estructura_costos_mano_obra_cotizacionventas.getIdcargo()); 
			initialValues.put("ITEM",estructura_costos_mano_obra_cotizacionventas.getItem()); 
			initialValues.put("ESTADO",estructura_costos_mano_obra_cotizacionventas.getEstado()); 
			initialValues.put("IDPRODUCTO",estructura_costos_mano_obra_cotizacionventas.getIdproducto()); 
			initialValues.put("COSTO",estructura_costos_mano_obra_cotizacionventas.getCosto()); 
			resultado = mDb.insert("ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra_cotizacionventas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_mano_obra_cotizacionventas.getIdempresa()) ; 
			initialValues.put("CODIGO",estructura_costos_mano_obra_cotizacionventas.getCodigo()) ; 
			initialValues.put("IDCOTIZACIONV",estructura_costos_mano_obra_cotizacionventas.getIdcotizacionv()) ; 
			initialValues.put("IDCARGO",estructura_costos_mano_obra_cotizacionventas.getIdcargo()) ; 
			initialValues.put("ITEM",estructura_costos_mano_obra_cotizacionventas.getItem()) ; 
			initialValues.put("ESTADO",estructura_costos_mano_obra_cotizacionventas.getEstado()) ; 
			initialValues.put("IDPRODUCTO",estructura_costos_mano_obra_cotizacionventas.getIdproducto()) ; 
			initialValues.put("COSTO",estructura_costos_mano_obra_cotizacionventas.getCosto()) ; 
			resultado = mDb.update("ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estructura_costos_mano_obra_cotizacionventas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estructura_costos_mano_obra_cotizacionventas> lista  = new ArrayList<Estructura_costos_mano_obra_cotizacionventas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "IDCOTIZACIONV" ,
							 "IDCARGO" ,
							 "ITEM" ,
							 "ESTADO" ,
							 "IDPRODUCTO" ,
							 "COSTO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra_cotizacionventas = new Estructura_costos_mano_obra_cotizacionventas() ;
					estructura_costos_mano_obra_cotizacionventas.setIdempresa(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setCodigo(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setIdcotizacionv(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setIdcargo(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setItem(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setEstado(cur.getDouble(j++));
					estructura_costos_mano_obra_cotizacionventas.setIdproducto(cur.getString(j++));
					estructura_costos_mano_obra_cotizacionventas.setCosto(cur.getDouble(j++));

					lista.add(estructura_costos_mano_obra_cotizacionventas); 
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