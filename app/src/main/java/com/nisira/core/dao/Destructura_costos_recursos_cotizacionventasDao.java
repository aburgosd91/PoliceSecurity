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

public class Destructura_costos_recursos_cotizacionventasDao extends BaseDao<Destructura_costos_recursos_cotizacionventas> {
	public Destructura_costos_recursos_cotizacionventasDao() {
		super(Destructura_costos_recursos_cotizacionventas.class);
	}
	public Destructura_costos_recursos_cotizacionventasDao(boolean usaCnBase) throws Exception {
		super(Destructura_costos_recursos_cotizacionventas.class, usaCnBase);
	}

	public Boolean insert(Destructura_costos_recursos_cotizacionventas destructura_costos_recursos_cotizacionventas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",destructura_costos_recursos_cotizacionventas.getIdempresa()); 
			initialValues.put("CODIGO",destructura_costos_recursos_cotizacionventas.getCodigo()); 
			initialValues.put("IDCOTIZACIONV",destructura_costos_recursos_cotizacionventas.getIdcotizacionv()); 
			initialValues.put("ITEM",destructura_costos_recursos_cotizacionventas.getItem()); 
			initialValues.put("TIPO_RECURSO",destructura_costos_recursos_cotizacionventas.getTipo_recurso()); 
			initialValues.put("DESCRIPCION",destructura_costos_recursos_cotizacionventas.getDescripcion()); 
			initialValues.put("CANTIDAD",destructura_costos_recursos_cotizacionventas.getCantidad()); 
			initialValues.put("COSTO",destructura_costos_recursos_cotizacionventas.getCosto()); 
			initialValues.put("IDPRODUCTO",destructura_costos_recursos_cotizacionventas.getIdproducto()); 
			initialValues.put("ES_PORCENTAJE",destructura_costos_recursos_cotizacionventas.getEs_porcentaje()); 
			initialValues.put("IDMEDIDA",destructura_costos_recursos_cotizacionventas.getIdmedida()); 
			initialValues.put("IDPRODUCTO_EC",destructura_costos_recursos_cotizacionventas.getIdproducto_ec()); 
			resultado = mDb.insert("DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Destructura_costos_recursos_cotizacionventas destructura_costos_recursos_cotizacionventas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",destructura_costos_recursos_cotizacionventas.getIdempresa()) ; 
			initialValues.put("CODIGO",destructura_costos_recursos_cotizacionventas.getCodigo()) ; 
			initialValues.put("IDCOTIZACIONV",destructura_costos_recursos_cotizacionventas.getIdcotizacionv()) ; 
			initialValues.put("ITEM",destructura_costos_recursos_cotizacionventas.getItem()) ; 
			initialValues.put("TIPO_RECURSO",destructura_costos_recursos_cotizacionventas.getTipo_recurso()) ; 
			initialValues.put("DESCRIPCION",destructura_costos_recursos_cotizacionventas.getDescripcion()) ; 
			initialValues.put("CANTIDAD",destructura_costos_recursos_cotizacionventas.getCantidad()) ; 
			initialValues.put("COSTO",destructura_costos_recursos_cotizacionventas.getCosto()) ; 
			initialValues.put("IDPRODUCTO",destructura_costos_recursos_cotizacionventas.getIdproducto()) ; 
			initialValues.put("ES_PORCENTAJE",destructura_costos_recursos_cotizacionventas.getEs_porcentaje()) ; 
			initialValues.put("IDMEDIDA",destructura_costos_recursos_cotizacionventas.getIdmedida()) ; 
			initialValues.put("IDPRODUCTO_EC",destructura_costos_recursos_cotizacionventas.getIdproducto_ec()) ; 
			resultado = mDb.update("DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Destructura_costos_recursos_cotizacionventas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Destructura_costos_recursos_cotizacionventas> lista  = new ArrayList<Destructura_costos_recursos_cotizacionventas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "IDCOTIZACIONV" ,
							 "ITEM" ,
							 "TIPO_RECURSO" ,
							 "DESCRIPCION" ,
							 "CANTIDAD" ,
							 "COSTO" ,
							 "IDPRODUCTO" ,
							 "ES_PORCENTAJE" ,
							 "IDMEDIDA" ,
							 "IDPRODUCTO_EC" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Destructura_costos_recursos_cotizacionventas destructura_costos_recursos_cotizacionventas = new Destructura_costos_recursos_cotizacionventas() ;
					destructura_costos_recursos_cotizacionventas.setIdempresa(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setCodigo(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setIdcotizacionv(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setItem(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setTipo_recurso(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setDescripcion(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setCantidad(cur.getDouble(j++));
					destructura_costos_recursos_cotizacionventas.setCosto(cur.getDouble(j++));
					destructura_costos_recursos_cotizacionventas.setIdproducto(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setEs_porcentaje(cur.getDouble(j++));
					destructura_costos_recursos_cotizacionventas.setIdmedida(cur.getString(j++));
					destructura_costos_recursos_cotizacionventas.setIdproducto_ec(cur.getString(j++));

					lista.add(destructura_costos_recursos_cotizacionventas); 
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