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

public class EstadosDao extends BaseDao<Estados> {
	public EstadosDao() {
		super(Estados.class);
	}
	public EstadosDao(boolean usaCnBase) throws Exception {
		super(Estados.class, usaCnBase);
	}

	public Boolean insert(Estados estados) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDESTADO",estados.getIdestado()); 
			initialValues.put("DESCRIPCION",estados.getDescripcion()); 
			initialValues.put("ORDEN",estados.getOrden()); 
			initialValues.put("VERFLUJO",estados.getVerflujo()); 
			initialValues.put("ACCION",estados.getAccion()); 
			initialValues.put("SINCRONIZA",estados.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(estados.getFechacreacion() ) ); 
			initialValues.put("COLOR",estados.getColor()); 
			resultado = mDb.insert("ESTADOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Estados estados,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDESTADO",estados.getIdestado()) ; 
			initialValues.put("DESCRIPCION",estados.getDescripcion()) ; 
			initialValues.put("ORDEN",estados.getOrden()) ; 
			initialValues.put("VERFLUJO",estados.getVerflujo()) ; 
			initialValues.put("ACCION",estados.getAccion()) ; 
			initialValues.put("SINCRONIZA",estados.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(estados.getFechacreacion() ) ) ; 
			initialValues.put("COLOR",estados.getColor()) ; 
			resultado = mDb.update("ESTADOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ESTADOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Estados> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Estados> lista  = new ArrayList<Estados>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ESTADOS",
					new String[] {
							 "IDESTADO" ,
							 "DESCRIPCION" ,
							 "ORDEN" ,
							 "VERFLUJO" ,
							 "ACCION" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "COLOR" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Estados estados = new Estados() ;
					estados.setIdestado(cur.getString(j++));
					estados.setDescripcion(cur.getString(j++));
					estados.setOrden(cur.getDouble(j++));
					estados.setVerflujo(cur.getDouble(j++));
					estados.setAccion(cur.getString(j++));
					estados.setSincroniza(cur.getString(j++));
					estados.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					estados.setColor(cur.getString(j++));

					lista.add(estados); 
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