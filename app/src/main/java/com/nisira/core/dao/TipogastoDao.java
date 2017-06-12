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

public class TipogastoDao extends BaseDao<Tipogasto> {
	public TipogastoDao() {
		super(Tipogasto.class);
	}
	public TipogastoDao(boolean usaCnBase) throws Exception {
		super(Tipogasto.class, usaCnBase);
	}
	public void mezclarLocal(Tipogasto obj)throws Exception{
		if(obj !=null){
			List<Tipogasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? and LTRIM(RTRIM(t0.IDTIPOGASTO))",
					obj.getIdempresa().trim(),obj.getIdtipogasto().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public  List<Tipogasto> listarxID(String id)throws  Exception{
		List<Tipogasto> list= listar("LTRIM(RTRIM(t0.idtipogasto)) =?",id);
		return list;
	}

	public Boolean insert(Tipogasto tipogasto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",tipogasto.getIdempresa()); 
			initialValues.put("IDTIPOGASTO",tipogasto.getIdtipogasto()); 
			initialValues.put("DESCRIPCION",tipogasto.getDescripcion()); 
			initialValues.put("IDCUENTA",tipogasto.getIdcuenta()); 
			initialValues.put("ESTADO",tipogasto.getEstado()); 
			initialValues.put("SINCRONIZA",tipogasto.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(tipogasto.getFechacreacion() ) ); 
			resultado = mDb.insert("TIPOGASTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Tipogasto tipogasto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",tipogasto.getIdempresa()) ; 
			initialValues.put("IDTIPOGASTO",tipogasto.getIdtipogasto()) ; 
			initialValues.put("DESCRIPCION",tipogasto.getDescripcion()) ; 
			initialValues.put("IDCUENTA",tipogasto.getIdcuenta()) ; 
			initialValues.put("ESTADO",tipogasto.getEstado()) ; 
			initialValues.put("SINCRONIZA",tipogasto.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(tipogasto.getFechacreacion() ) ) ; 
			resultado = mDb.update("TIPOGASTO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("TIPOGASTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Tipogasto> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Tipogasto> lista  = new ArrayList<Tipogasto>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("TIPOGASTO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDTIPOGASTO" ,
							 "DESCRIPCION" ,
							 "IDCUENTA" ,
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
					Tipogasto tipogasto = new Tipogasto() ;
					tipogasto.setIdempresa(cur.getString(j++));
					tipogasto.setIdtipogasto(cur.getString(j++));
					tipogasto.setDescripcion(cur.getString(j++));
					tipogasto.setIdcuenta(cur.getString(j++));
					tipogasto.setEstado(cur.getDouble(j++));
					tipogasto.setSincroniza(cur.getString(j++));
					tipogasto.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(tipogasto); 
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