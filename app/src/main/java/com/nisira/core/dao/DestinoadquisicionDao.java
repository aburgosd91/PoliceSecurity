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

public class DestinoadquisicionDao extends BaseDao<Destinoadquisicion> {
	public DestinoadquisicionDao() {
		super(Destinoadquisicion.class);
	}
	public DestinoadquisicionDao(boolean usaCnBase) throws Exception {
		super(Destinoadquisicion.class, usaCnBase);
	}
	public void mezclarLocal(Destinoadquisicion obj)throws Exception{
		List<Destinoadquisicion> lst= listar("LTRIM(RTRIM(t0.IDDESTINO))=?",obj.getIddestino().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public Boolean insert(Destinoadquisicion destinoadquisicion) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDDESTINO",destinoadquisicion.getIddestino()); 
			initialValues.put("DESCRIPCION",destinoadquisicion.getDescripcion()); 
			initialValues.put("ESTADO",destinoadquisicion.getEstado()); 
			initialValues.put("SINCRONIZA",destinoadquisicion.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(destinoadquisicion.getFechacreacion() ) ); 
			resultado = mDb.insert("DESTINOADQUISICION",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Destinoadquisicion destinoadquisicion,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDDESTINO",destinoadquisicion.getIddestino()) ; 
			initialValues.put("DESCRIPCION",destinoadquisicion.getDescripcion()) ; 
			initialValues.put("ESTADO",destinoadquisicion.getEstado()) ; 
			initialValues.put("SINCRONIZA",destinoadquisicion.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(destinoadquisicion.getFechacreacion() ) ) ; 
			resultado = mDb.update("DESTINOADQUISICION",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DESTINOADQUISICION",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Destinoadquisicion> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Destinoadquisicion> lista  = new ArrayList<Destinoadquisicion>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DESTINOADQUISICION",
					new String[] {
							 "IDDESTINO" ,
							 "DESCRIPCION" ,
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
					Destinoadquisicion destinoadquisicion = new Destinoadquisicion() ;
					destinoadquisicion.setIddestino(cur.getString(j++));
					destinoadquisicion.setDescripcion(cur.getString(j++));
					destinoadquisicion.setEstado(cur.getDouble(j++));
					destinoadquisicion.setSincroniza(cur.getString(j++));
					destinoadquisicion.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(destinoadquisicion); 
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