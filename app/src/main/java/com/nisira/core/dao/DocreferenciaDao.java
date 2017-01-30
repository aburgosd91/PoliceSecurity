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

public class DocreferenciaDao extends BaseDao<Docreferencia> {
	public DocreferenciaDao() {
		super(Docreferencia.class);
	}
	public DocreferenciaDao(boolean usaCnBase) throws Exception {
		super(Docreferencia.class, usaCnBase);
	}

	public Boolean insert(Docreferencia docreferencia) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",docreferencia.getIdempresa()); 
			initialValues.put("IDORIGEN",docreferencia.getIdorigen()); 
			initialValues.put("TABLA",docreferencia.getTabla()); 
			initialValues.put("IDREFERENCIA",docreferencia.getIdreferencia()); 
			initialValues.put("IDDOCUMENTO",docreferencia.getIddocumento()); 
			initialValues.put("SERIE",docreferencia.getSerie()); 
			initialValues.put("NUMERO",docreferencia.getNumero()); 
			initialValues.put("FECHA",dateFormat.format(docreferencia.getFecha() ) ); 
			initialValues.put("EXONERADO",docreferencia.getExonerado()); 
			initialValues.put("ARCHIVAR",docreferencia.getArchivar()); 
			resultado = mDb.insert("DOCREFERENCIA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Docreferencia docreferencia,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",docreferencia.getIdempresa()) ; 
			initialValues.put("IDORIGEN",docreferencia.getIdorigen()) ; 
			initialValues.put("TABLA",docreferencia.getTabla()) ; 
			initialValues.put("IDREFERENCIA",docreferencia.getIdreferencia()) ; 
			initialValues.put("IDDOCUMENTO",docreferencia.getIddocumento()) ; 
			initialValues.put("SERIE",docreferencia.getSerie()) ; 
			initialValues.put("NUMERO",docreferencia.getNumero()) ; 
			initialValues.put("FECHA",dateFormat.format(docreferencia.getFecha() ) ) ; 
			initialValues.put("EXONERADO",docreferencia.getExonerado()) ; 
			initialValues.put("ARCHIVAR",docreferencia.getArchivar()) ; 
			resultado = mDb.update("DOCREFERENCIA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DOCREFERENCIA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Docreferencia> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Docreferencia> lista  = new ArrayList<Docreferencia>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DOCREFERENCIA",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORIGEN" ,
							 "TABLA" ,
							 "IDREFERENCIA" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "FECHA" ,
							 "EXONERADO" ,
							 "ARCHIVAR" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Docreferencia docreferencia = new Docreferencia() ;
					docreferencia.setIdempresa(cur.getString(j++));
					docreferencia.setIdorigen(cur.getString(j++));
					docreferencia.setTabla(cur.getString(j++));
					docreferencia.setIdreferencia(cur.getString(j++));
					docreferencia.setIddocumento(cur.getString(j++));
					docreferencia.setSerie(cur.getString(j++));
					docreferencia.setNumero(cur.getString(j++));
					docreferencia.setFecha(dateFormat.parse(cur.getString(j++)) );
					docreferencia.setExonerado(cur.getDouble(j++));
					docreferencia.setArchivar(cur.getDouble(j++));

					lista.add(docreferencia); 
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