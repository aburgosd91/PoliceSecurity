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

public class NumemisorDao extends BaseDao<Numemisor> {
	public NumemisorDao() {
		super(Numemisor.class);
	}
	public NumemisorDao(boolean usaCnBase) throws Exception {
		super(Numemisor.class, usaCnBase);
	}
	public void mezclarLocal(Numemisor obj)throws Exception{

		List<Numemisor> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDEMISOR))=? AND LTRIM(RTRIM(t0.IDDOCUMENTO))=? AND LTRIM(RTRIM(t0.SERIE))=?",
				obj.getIdempresa().trim(),obj.getIdemisor().trim(),obj.getIddocumento().trim(),obj.getSerie().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public Boolean insert(Numemisor numemisor) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",numemisor.getIdempresa()); 
			initialValues.put("IDEMISOR",numemisor.getIdemisor()); 
			initialValues.put("IDDOCUMENTO",numemisor.getIddocumento()); 
			initialValues.put("SERIE",numemisor.getSerie()); 
			initialValues.put("NUMERO",numemisor.getNumero()); 
			initialValues.put("ESTADO",numemisor.getEstado()); 
			initialValues.put("ES_IMPORTACION",numemisor.getEs_importacion()); 
			initialValues.put("SINCRONIZA",numemisor.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(numemisor.getFechacreacion() ) ); 
			initialValues.put("NLINEAS",numemisor.getNlineas()); 
			initialValues.put("OBSERVACION",numemisor.getObservacion()); 
			initialValues.put("IDTIPOVENTA",numemisor.getIdtipoventa()); 
			initialValues.put("PARADECLARACION_CE",numemisor.getParadeclaracion_ce()); 
			resultado = mDb.insert("NUMEMISOR",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Numemisor numemisor,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",numemisor.getIdempresa()) ; 
			initialValues.put("IDEMISOR",numemisor.getIdemisor()) ; 
			initialValues.put("IDDOCUMENTO",numemisor.getIddocumento()) ; 
			initialValues.put("SERIE",numemisor.getSerie()) ; 
			initialValues.put("NUMERO",numemisor.getNumero()) ; 
			initialValues.put("ESTADO",numemisor.getEstado()) ; 
			initialValues.put("ES_IMPORTACION",numemisor.getEs_importacion()) ; 
			initialValues.put("SINCRONIZA",numemisor.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(numemisor.getFechacreacion() ) ) ; 
			initialValues.put("NLINEAS",numemisor.getNlineas()) ; 
			initialValues.put("OBSERVACION",numemisor.getObservacion()) ; 
			initialValues.put("IDTIPOVENTA",numemisor.getIdtipoventa()) ; 
			initialValues.put("PARADECLARACION_CE",numemisor.getParadeclaracion_ce()) ; 
			resultado = mDb.update("NUMEMISOR",initialValues,where,null)>0; 
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
			resultado = mDb.delete("NUMEMISOR",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Numemisor> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Numemisor> lista  = new ArrayList<Numemisor>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("NUMEMISOR",
					new String[] {
							 "IDEMPRESA" ,
							 "IDEMISOR" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "ESTADO" ,
							 "ES_IMPORTACION" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "NLINEAS" ,
							 "OBSERVACION" ,
							 "IDTIPOVENTA" ,
							 "PARADECLARACION_CE" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Numemisor numemisor = new Numemisor() ;
					numemisor.setIdempresa(cur.getString(j++));
					numemisor.setIdemisor(cur.getString(j++));
					numemisor.setIddocumento(cur.getString(j++));
					numemisor.setSerie(cur.getString(j++));
					numemisor.setNumero(cur.getString(j++));
					numemisor.setEstado(cur.getDouble(j++));
					numemisor.setEs_importacion(cur.getDouble(j++));
					numemisor.setSincroniza(cur.getString(j++));
					numemisor.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					numemisor.setNlineas(cur.getDouble(j++));
					numemisor.setObservacion(cur.getString(j++));
					numemisor.setIdtipoventa(cur.getString(j++));
					numemisor.setParadeclaracion_ce(cur.getDouble(j++));

					lista.add(numemisor); 
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