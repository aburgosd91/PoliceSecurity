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

public class CabtareowebDao extends BaseDao<Cabtareoweb> {
	public CabtareowebDao() {
		super(Cabtareoweb.class);
	}
	public CabtareowebDao(boolean usaCnBase) throws Exception {
		super(Cabtareoweb.class, usaCnBase);
	}

	public Boolean insert(Cabtareoweb cabtareoweb) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cabtareoweb.getIdempresa()); 
			initialValues.put("IDCABTAREOWEB",cabtareoweb.getIdcabtareoweb()); 
			initialValues.put("IDEMISOR",cabtareoweb.getIdemisor()); 
			initialValues.put("IDSUCURSAL",cabtareoweb.getIdsucursal()); 
			initialValues.put("IDALMACEN",cabtareoweb.getIdalmacen()); 
			initialValues.put("IDDOCUMENTO",cabtareoweb.getIddocumento()); 
			initialValues.put("SERIE",cabtareoweb.getSerie()); 
			initialValues.put("NUMERO",cabtareoweb.getNumero()); 
			initialValues.put("PERIODO",cabtareoweb.getPeriodo()); 
			initialValues.put("FECHA",dateFormat.format(cabtareoweb.getFecha() ) ); 
			initialValues.put("IDESTADO",cabtareoweb.getIdestado()); 
			initialValues.put("IDRESPONSABLE",cabtareoweb.getIdresponsable()); 
			resultado = mDb.insert("CABTAREOWEB",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Cabtareoweb cabtareoweb,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cabtareoweb.getIdempresa()) ; 
			initialValues.put("IDCABTAREOWEB",cabtareoweb.getIdcabtareoweb()) ; 
			initialValues.put("IDEMISOR",cabtareoweb.getIdemisor()) ; 
			initialValues.put("IDSUCURSAL",cabtareoweb.getIdsucursal()) ; 
			initialValues.put("IDALMACEN",cabtareoweb.getIdalmacen()) ; 
			initialValues.put("IDDOCUMENTO",cabtareoweb.getIddocumento()) ; 
			initialValues.put("SERIE",cabtareoweb.getSerie()) ; 
			initialValues.put("NUMERO",cabtareoweb.getNumero()) ; 
			initialValues.put("PERIODO",cabtareoweb.getPeriodo()) ; 
			initialValues.put("FECHA",dateFormat.format(cabtareoweb.getFecha() ) ) ; 
			initialValues.put("IDESTADO",cabtareoweb.getIdestado()) ; 
			initialValues.put("IDRESPONSABLE",cabtareoweb.getIdresponsable()) ; 
			resultado = mDb.update("CABTAREOWEB",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CABTAREOWEB",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Cabtareoweb> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Cabtareoweb> lista  = new ArrayList<Cabtareoweb>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CABTAREOWEB",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCABTAREOWEB" ,
							 "IDEMISOR" ,
							 "IDSUCURSAL" ,
							 "IDALMACEN" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "PERIODO" ,
							 "FECHA" ,
							 "IDESTADO" ,
							 "IDRESPONSABLE" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Cabtareoweb cabtareoweb = new Cabtareoweb() ;
					cabtareoweb.setIdempresa(cur.getString(j++));
					cabtareoweb.setIdcabtareoweb(cur.getString(j++));
					cabtareoweb.setIdemisor(cur.getString(j++));
					cabtareoweb.setIdsucursal(cur.getString(j++));
					cabtareoweb.setIdalmacen(cur.getString(j++));
					cabtareoweb.setIddocumento(cur.getString(j++));
					cabtareoweb.setSerie(cur.getString(j++));
					cabtareoweb.setNumero(cur.getString(j++));
					cabtareoweb.setPeriodo(cur.getString(j++));
					cabtareoweb.setFecha(dateFormat.parse(cur.getString(j++)) );
					cabtareoweb.setIdestado(cur.getString(j++));
					cabtareoweb.setIdresponsable(cur.getString(j++));

					lista.add(cabtareoweb); 
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