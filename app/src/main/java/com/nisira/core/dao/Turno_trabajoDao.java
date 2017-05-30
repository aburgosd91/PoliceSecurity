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

public class Turno_trabajoDao extends BaseDao<Turno_trabajo> {
	public Turno_trabajoDao() {
		super(Turno_trabajo.class);
	}
	public Turno_trabajoDao(boolean usaCnBase) throws Exception {
		super(Turno_trabajo.class, usaCnBase);
	}

	public Boolean insert(Turno_trabajo turno_trabajo) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDTURNOTRABAJO",turno_trabajo.getIdturnotrabajo()); 
			initialValues.put("DESCRIPCION",turno_trabajo.getDescripcion()); 
			initialValues.put("DESDE",turno_trabajo.getDesde()); 
			initialValues.put("HASTA",turno_trabajo.getHasta()); 
			initialValues.put("SINCRONIZA",turno_trabajo.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(turno_trabajo.getFechacreacion() ) ); 
			initialValues.put("MINGRESO",turno_trabajo.getMingreso()); 
			initialValues.put("MSALIDA",turno_trabajo.getMsalida()); 
			initialValues.put("HREFRIGERIO",turno_trabajo.getHrefrigerio()); 
			initialValues.put("MREFRIGERIO",turno_trabajo.getMrefrigerio()); 
			initialValues.put("HEXTRA",turno_trabajo.getHextra()); 
			initialValues.put("MEXTRA",turno_trabajo.getMextra()); 
			initialValues.put("REFHDESDE",turno_trabajo.getRefhdesde()); 
			initialValues.put("REFMDESDE",turno_trabajo.getRefmdesde()); 
			initialValues.put("REFHHASTA",turno_trabajo.getRefhhasta()); 
			initialValues.put("REFMHASTA",turno_trabajo.getRefmhasta()); 
			initialValues.put("DIASGTE",turno_trabajo.getDiasgte()); 
			initialValues.put("SLSALIDA",turno_trabajo.getSlsalida()); 
			initialValues.put("FDS",turno_trabajo.getFds()); 
			initialValues.put("AMANECIDA",turno_trabajo.getAmanecida()); 
			initialValues.put("NOTARDANZA1",turno_trabajo.getNotardanza1()); 
			initialValues.put("MTOLERANCIA",turno_trabajo.getMtolerancia()); 
			initialValues.put("HDURMAX",turno_trabajo.getHdurmax()); 
			initialValues.put("MDURMAX",turno_trabajo.getMdurmax()); 
			resultado = mDb.insert("TURNO_TRABAJO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Turno_trabajo turno_trabajo,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDTURNOTRABAJO",turno_trabajo.getIdturnotrabajo()) ; 
			initialValues.put("DESCRIPCION",turno_trabajo.getDescripcion()) ; 
			initialValues.put("DESDE",turno_trabajo.getDesde()) ; 
			initialValues.put("HASTA",turno_trabajo.getHasta()) ; 
			initialValues.put("SINCRONIZA",turno_trabajo.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(turno_trabajo.getFechacreacion() ) ) ; 
			initialValues.put("MINGRESO",turno_trabajo.getMingreso()) ; 
			initialValues.put("MSALIDA",turno_trabajo.getMsalida()) ; 
			initialValues.put("HREFRIGERIO",turno_trabajo.getHrefrigerio()) ; 
			initialValues.put("MREFRIGERIO",turno_trabajo.getMrefrigerio()) ; 
			initialValues.put("HEXTRA",turno_trabajo.getHextra()) ; 
			initialValues.put("MEXTRA",turno_trabajo.getMextra()) ; 
			initialValues.put("REFHDESDE",turno_trabajo.getRefhdesde()) ; 
			initialValues.put("REFMDESDE",turno_trabajo.getRefmdesde()) ; 
			initialValues.put("REFHHASTA",turno_trabajo.getRefhhasta()) ; 
			initialValues.put("REFMHASTA",turno_trabajo.getRefmhasta()) ; 
			initialValues.put("DIASGTE",turno_trabajo.getDiasgte()) ; 
			initialValues.put("SLSALIDA",turno_trabajo.getSlsalida()) ; 
			initialValues.put("FDS",turno_trabajo.getFds()) ; 
			initialValues.put("AMANECIDA",turno_trabajo.getAmanecida()) ; 
			initialValues.put("NOTARDANZA1",turno_trabajo.getNotardanza1()) ; 
			initialValues.put("MTOLERANCIA",turno_trabajo.getMtolerancia()) ; 
			initialValues.put("HDURMAX",turno_trabajo.getHdurmax()) ; 
			initialValues.put("MDURMAX",turno_trabajo.getMdurmax()) ; 
			resultado = mDb.update("TURNO_TRABAJO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("TURNO_TRABAJO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Turno_trabajo> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Turno_trabajo> lista  = new ArrayList<Turno_trabajo>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("TURNO_TRABAJO",
					new String[] {
							 "IDTURNOTRABAJO" ,
							 "DESCRIPCION" ,
							 "DESDE" ,
							 "HASTA" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "MINGRESO" ,
							 "MSALIDA" ,
							 "HREFRIGERIO" ,
							 "MREFRIGERIO" ,
							 "HEXTRA" ,
							 "MEXTRA" ,
							 "REFHDESDE" ,
							 "REFMDESDE" ,
							 "REFHHASTA" ,
							 "REFMHASTA" ,
							 "DIASGTE" ,
							 "SLSALIDA" ,
							 "FDS" ,
							 "AMANECIDA" ,
							 "NOTARDANZA1" ,
							 "MTOLERANCIA" ,
							 "HDURMAX" ,
							 "MDURMAX" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Turno_trabajo turno_trabajo = new Turno_trabajo() ;
					turno_trabajo.setIdturnotrabajo(cur.getString(j++));
					turno_trabajo.setDescripcion(cur.getString(j++));
					turno_trabajo.setDesde(cur.getDouble(j++));
					turno_trabajo.setHasta(cur.getDouble(j++));
					turno_trabajo.setSincroniza(cur.getString(j++));
					turno_trabajo.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					turno_trabajo.setMingreso(cur.getDouble(j++));
					turno_trabajo.setMsalida(cur.getDouble(j++));
					turno_trabajo.setHrefrigerio(cur.getDouble(j++));
					turno_trabajo.setMrefrigerio(cur.getDouble(j++));
					turno_trabajo.setHextra(cur.getDouble(j++));
					turno_trabajo.setMextra(cur.getDouble(j++));
					turno_trabajo.setRefhdesde(cur.getDouble(j++));
					turno_trabajo.setRefmdesde(cur.getDouble(j++));
					turno_trabajo.setRefhhasta(cur.getDouble(j++));
					turno_trabajo.setRefmhasta(cur.getDouble(j++));
					turno_trabajo.setDiasgte(cur.getDouble(j++));
					turno_trabajo.setSlsalida(cur.getDouble(j++));
					turno_trabajo.setFds(cur.getDouble(j++));
					turno_trabajo.setAmanecida(cur.getDouble(j++));
					turno_trabajo.setNotardanza1(cur.getDouble(j++));
					turno_trabajo.setMtolerancia(cur.getDouble(j++));
					turno_trabajo.setHdurmax(cur.getDouble(j++));
					turno_trabajo.setMdurmax(cur.getDouble(j++));

					lista.add(turno_trabajo); 
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