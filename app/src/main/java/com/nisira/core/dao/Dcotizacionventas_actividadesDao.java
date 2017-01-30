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

public class Dcotizacionventas_actividadesDao extends BaseDao<Dcotizacionventas_actividades> {
	public Dcotizacionventas_actividadesDao() {
		super(Dcotizacionventas_actividades.class);
	}
	public Dcotizacionventas_actividadesDao(boolean usaCnBase) throws Exception {
		super(Dcotizacionventas_actividades.class, usaCnBase);
	}

	public Boolean insert(Dcotizacionventas_actividades dcotizacionventas_actividades) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dcotizacionventas_actividades.getIdempresa()); 
			initialValues.put("IDCOTIZACIONV",dcotizacionventas_actividades.getIdcotizacionv()); 
			initialValues.put("ITEMC",dcotizacionventas_actividades.getItemc()); 
			initialValues.put("ITEMREF",dcotizacionventas_actividades.getItemref()); 
			initialValues.put("IDCARGO",dcotizacionventas_actividades.getIdcargo()); 
			initialValues.put("DESCRIPCION",dcotizacionventas_actividades.getDescripcion()); 
			initialValues.put("CANTIDAD",dcotizacionventas_actividades.getCantidad()); 
			initialValues.put("COSTO",dcotizacionventas_actividades.getCosto()); 
			initialValues.put("TOTAL",dcotizacionventas_actividades.getTotal()); 
			resultado = mDb.insert("DCOTIZACIONVENTAS_ACTIVIDADES",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dcotizacionventas_actividades dcotizacionventas_actividades,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dcotizacionventas_actividades.getIdempresa()) ; 
			initialValues.put("IDCOTIZACIONV",dcotizacionventas_actividades.getIdcotizacionv()) ; 
			initialValues.put("ITEMC",dcotizacionventas_actividades.getItemc()) ; 
			initialValues.put("ITEMREF",dcotizacionventas_actividades.getItemref()) ; 
			initialValues.put("IDCARGO",dcotizacionventas_actividades.getIdcargo()) ; 
			initialValues.put("DESCRIPCION",dcotizacionventas_actividades.getDescripcion()) ; 
			initialValues.put("CANTIDAD",dcotizacionventas_actividades.getCantidad()) ; 
			initialValues.put("COSTO",dcotizacionventas_actividades.getCosto()) ; 
			initialValues.put("TOTAL",dcotizacionventas_actividades.getTotal()) ; 
			resultado = mDb.update("DCOTIZACIONVENTAS_ACTIVIDADES",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DCOTIZACIONVENTAS_ACTIVIDADES",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Dcotizacionventas_actividades> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Dcotizacionventas_actividades> lista  = new ArrayList<Dcotizacionventas_actividades>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DCOTIZACIONVENTAS_ACTIVIDADES",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCOTIZACIONV" ,
							 "ITEMC" ,
							 "ITEMREF" ,
							 "IDCARGO" ,
							 "DESCRIPCION" ,
							 "CANTIDAD" ,
							 "COSTO" ,
							 "TOTAL" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Dcotizacionventas_actividades dcotizacionventas_actividades = new Dcotizacionventas_actividades() ;
					dcotizacionventas_actividades.setIdempresa(cur.getString(j++));
					dcotizacionventas_actividades.setIdcotizacionv(cur.getString(j++));
					dcotizacionventas_actividades.setItemc(cur.getString(j++));
					dcotizacionventas_actividades.setItemref(cur.getString(j++));
					dcotizacionventas_actividades.setIdcargo(cur.getString(j++));
					dcotizacionventas_actividades.setDescripcion(cur.getString(j++));
					dcotizacionventas_actividades.setCantidad(cur.getDouble(j++));
					dcotizacionventas_actividades.setCosto(cur.getDouble(j++));
					dcotizacionventas_actividades.setTotal(cur.getDouble(j++));

					lista.add(dcotizacionventas_actividades); 
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