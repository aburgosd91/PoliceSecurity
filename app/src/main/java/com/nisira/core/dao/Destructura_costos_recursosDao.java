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

public class Destructura_costos_recursosDao extends BaseDao<Destructura_costos_recursos> {
	public Destructura_costos_recursosDao() {
		super(Destructura_costos_recursos.class);
	}
	public Destructura_costos_recursosDao(boolean usaCnBase) throws Exception {
		super(Destructura_costos_recursos.class, usaCnBase);
	}

	public Boolean insert(Destructura_costos_recursos destructura_costos_recursos) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",destructura_costos_recursos.getIdempresa()); 
			initialValues.put("CODIGO",destructura_costos_recursos.getCodigo()); 
			initialValues.put("ITEM",destructura_costos_recursos.getItem()); 
			initialValues.put("TIPO_RECURSO",destructura_costos_recursos.getTipo_recurso()); 
			initialValues.put("DESCRIPCION",destructura_costos_recursos.getDescripcion()); 
			initialValues.put("CANTIDAD",destructura_costos_recursos.getCantidad()); 
			initialValues.put("COSTO",destructura_costos_recursos.getCosto()); 
			initialValues.put("IDPRODUCTO",destructura_costos_recursos.getIdproducto()); 
			initialValues.put("ES_PORCENTAJE",destructura_costos_recursos.getEs_porcentaje()); 
			initialValues.put("IDMEDIDA",destructura_costos_recursos.getIdmedida()); 
			initialValues.put("IDPRODUCTO_EC",destructura_costos_recursos.getIdproducto_ec()); 
			initialValues.put("ITEMRANGO",destructura_costos_recursos.getItemrango()); 
			resultado = mDb.insert("DESTRUCTURA_COSTOS_RECURSOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Destructura_costos_recursos destructura_costos_recursos,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",destructura_costos_recursos.getIdempresa()) ; 
			initialValues.put("CODIGO",destructura_costos_recursos.getCodigo()) ; 
			initialValues.put("ITEM",destructura_costos_recursos.getItem()) ; 
			initialValues.put("TIPO_RECURSO",destructura_costos_recursos.getTipo_recurso()) ; 
			initialValues.put("DESCRIPCION",destructura_costos_recursos.getDescripcion()) ; 
			initialValues.put("CANTIDAD",destructura_costos_recursos.getCantidad()) ; 
			initialValues.put("COSTO",destructura_costos_recursos.getCosto()) ; 
			initialValues.put("IDPRODUCTO",destructura_costos_recursos.getIdproducto()) ; 
			initialValues.put("ES_PORCENTAJE",destructura_costos_recursos.getEs_porcentaje()) ; 
			initialValues.put("IDMEDIDA",destructura_costos_recursos.getIdmedida()) ; 
			initialValues.put("IDPRODUCTO_EC",destructura_costos_recursos.getIdproducto_ec()) ; 
			initialValues.put("ITEMRANGO",destructura_costos_recursos.getItemrango()) ; 
			resultado = mDb.update("DESTRUCTURA_COSTOS_RECURSOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DESTRUCTURA_COSTOS_RECURSOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Destructura_costos_recursos> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Destructura_costos_recursos> lista  = new ArrayList<Destructura_costos_recursos>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DESTRUCTURA_COSTOS_RECURSOS",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "ITEM" ,
							 "TIPO_RECURSO" ,
							 "DESCRIPCION" ,
							 "CANTIDAD" ,
							 "COSTO" ,
							 "IDPRODUCTO" ,
							 "ES_PORCENTAJE" ,
							 "IDMEDIDA" ,
							 "IDPRODUCTO_EC" ,
							 "ITEMRANGO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Destructura_costos_recursos destructura_costos_recursos = new Destructura_costos_recursos() ;
					destructura_costos_recursos.setIdempresa(cur.getString(j++));
					destructura_costos_recursos.setCodigo(cur.getString(j++));
					destructura_costos_recursos.setItem(cur.getString(j++));
					destructura_costos_recursos.setTipo_recurso(cur.getString(j++));
					destructura_costos_recursos.setDescripcion(cur.getString(j++));
					destructura_costos_recursos.setCantidad(cur.getDouble(j++));
					destructura_costos_recursos.setCosto(cur.getDouble(j++));
					destructura_costos_recursos.setIdproducto(cur.getString(j++));
					destructura_costos_recursos.setEs_porcentaje(cur.getDouble(j++));
					destructura_costos_recursos.setIdmedida(cur.getString(j++));
					destructura_costos_recursos.setIdproducto_ec(cur.getString(j++));
					destructura_costos_recursos.setItemrango(cur.getString(j++));

					lista.add(destructura_costos_recursos); 
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