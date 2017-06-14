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

public class Estructura_costos_productoDao extends BaseDao<Estructura_costos_producto> {
	public Estructura_costos_productoDao() {
		super(Estructura_costos_producto.class);
	}
	public Estructura_costos_productoDao(boolean usaCnBase) throws Exception {
		super(Estructura_costos_producto.class, usaCnBase);
	}

	public Boolean insert(Estructura_costos_producto estructura_costos_producto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_producto.getIdempresa()); 
			initialValues.put("CODIGO",estructura_costos_producto.getCodigo()); 
			initialValues.put("IDPRODUCTO",estructura_costos_producto.getIdproducto()); 
			initialValues.put("DESCRIPCION",estructura_costos_producto.getDescripcion()); 
			initialValues.put("ITEM",estructura_costos_producto.getItem()); 
			initialValues.put("AJUSTE",estructura_costos_producto.getAjuste()); 
			initialValues.put("NHORAS",estructura_costos_producto.getNhoras()); 
			initialValues.put("CODOPERATIVO",estructura_costos_producto.getCodoperativo()); 
			initialValues.put("IDRUTA",estructura_costos_producto.getIdruta()); 
			resultado = mDb.insert("ESTRUCTURA_COSTOS_PRODUCTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estructura_costos_producto estructura_costos_producto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",estructura_costos_producto.getIdempresa()) ; 
			initialValues.put("CODIGO",estructura_costos_producto.getCodigo()) ; 
			initialValues.put("IDPRODUCTO",estructura_costos_producto.getIdproducto()) ; 
			initialValues.put("DESCRIPCION",estructura_costos_producto.getDescripcion()) ; 
			initialValues.put("ITEM",estructura_costos_producto.getItem()) ; 
			initialValues.put("AJUSTE",estructura_costos_producto.getAjuste()) ; 
			initialValues.put("NHORAS",estructura_costos_producto.getNhoras()) ; 
			initialValues.put("CODOPERATIVO",estructura_costos_producto.getCodoperativo()) ; 
			initialValues.put("IDRUTA",estructura_costos_producto.getIdruta()) ; 
			resultado = mDb.update("ESTRUCTURA_COSTOS_PRODUCTO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTRUCTURA_COSTOS_PRODUCTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estructura_costos_producto> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estructura_costos_producto> lista  = new ArrayList<Estructura_costos_producto>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTRUCTURA_COSTOS_PRODUCTO",
					new String[] {
							 "IDEMPRESA" ,
							 "CODIGO" ,
							 "IDPRODUCTO" ,
							 "DESCRIPCION" ,
							 "ITEM" ,
							 "AJUSTE" ,
							 "NHORAS" ,
							 "CODOPERATIVO" ,
							 "IDRUTA" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto() ;
					estructura_costos_producto.setIdempresa(cur.getString(j++));
					estructura_costos_producto.setCodigo(cur.getString(j++));
					estructura_costos_producto.setIdproducto(cur.getString(j++));
					estructura_costos_producto.setDescripcion(cur.getString(j++));
					estructura_costos_producto.setItem(cur.getString(j++));
					estructura_costos_producto.setAjuste(cur.getDouble(j++));
					estructura_costos_producto.setNhoras(cur.getDouble(j++));
					estructura_costos_producto.setCodoperativo(cur.getString(j++));
					estructura_costos_producto.setIdruta(cur.getString(j++));

					lista.add(estructura_costos_producto); 
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