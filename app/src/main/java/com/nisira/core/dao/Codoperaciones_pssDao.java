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

public class Codoperaciones_pssDao extends BaseDao<Codoperaciones_pss> {
	public Codoperaciones_pssDao() {
		super(Codoperaciones_pss.class);
	}
	public Codoperaciones_pssDao(boolean usaCnBase) throws Exception {
		super(Codoperaciones_pss.class, usaCnBase);
	}

	public void mezclarLocal(Codoperaciones_pss obj)throws Exception{
		if(obj !=null){
			List<Codoperaciones_pss> lst = listar("LTRIM(RTRIM(t0.IDCODOPERACIONES)) =? ",obj.getIdcodoperaciones().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
//			update(obj,"IDEMPRESA='"+obj.getIdempresa()+"' AND IDCLIEPROV='"+obj.getIdclieprov()+"'");
		}
	}

	public Boolean insert(Codoperaciones_pss codoperaciones_pss) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDCODOPERACIONES",codoperaciones_pss.getIdcodoperaciones()); 
			initialValues.put("DESCRIPCION",codoperaciones_pss.getDescripcion()); 
			initialValues.put("DESCRIPCION_CORTA",codoperaciones_pss.getDescripcion_corta()); 
			initialValues.put("FECHACREACION",dateFormat.format(codoperaciones_pss.getFechacreacion() ) ); 
			initialValues.put("ESTADO",codoperaciones_pss.getEstado()); 
			resultado = mDb.insert("CODOPERACIONES_PSS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Codoperaciones_pss codoperaciones_pss,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDCODOPERACIONES",codoperaciones_pss.getIdcodoperaciones()) ; 
			initialValues.put("DESCRIPCION",codoperaciones_pss.getDescripcion()) ; 
			initialValues.put("DESCRIPCION_CORTA",codoperaciones_pss.getDescripcion_corta()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(codoperaciones_pss.getFechacreacion() ) ) ; 
			initialValues.put("ESTADO",codoperaciones_pss.getEstado()) ; 
			resultado = mDb.update("CODOPERACIONES_PSS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CODOPERACIONES_PSS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Codoperaciones_pss> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Codoperaciones_pss> lista  = new ArrayList<Codoperaciones_pss>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CODOPERACIONES_PSS",
					new String[] {
							 "IDCODOPERACIONES" ,
							 "DESCRIPCION" ,
							 "DESCRIPCION_CORTA" ,
							 "FECHACREACION" ,
							 "ESTADO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Codoperaciones_pss codoperaciones_pss = new Codoperaciones_pss() ;
					codoperaciones_pss.setIdcodoperaciones(cur.getString(j++));
					codoperaciones_pss.setDescripcion(cur.getString(j++));
					codoperaciones_pss.setDescripcion_corta(cur.getString(j++));
					codoperaciones_pss.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					codoperaciones_pss.setEstado(cur.getDouble(j++));

					lista.add(codoperaciones_pss); 
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