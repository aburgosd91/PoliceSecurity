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

public class TcambioDao extends BaseDao<Tcambio> {
	public TcambioDao() {
		super(Tcambio.class);
	}
	public TcambioDao(boolean usaCnBase) throws Exception {
		super(Tcambio.class, usaCnBase);
	}

	public Boolean insert(Tcambio tcambio) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("FECHA",dateFormat.format(tcambio.getFecha() ) ); 
			initialValues.put("PERIODO",tcambio.getPeriodo()); 
			initialValues.put("B_COMPRA",tcambio.getB_compra()); 
			initialValues.put("B_VENTA",tcambio.getB_venta()); 
			initialValues.put("P_COMPRA",tcambio.getP_compra()); 
			initialValues.put("P_VENTA",tcambio.getP_venta()); 
			initialValues.put("T_COMPRA",tcambio.getT_compra()); 
			initialValues.put("T_VENTA",tcambio.getT_venta()); 
			initialValues.put("SINCRONIZA",tcambio.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(tcambio.getFechacreacion() ) ); 
			initialValues.put("E_COMPRA",tcambio.getE_compra()); 
			initialValues.put("E_VENTA",tcambio.getE_venta()); 
			resultado = mDb.insert("TCAMBIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Tcambio tcambio,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("FECHA",dateFormat.format(tcambio.getFecha() ) ) ; 
			initialValues.put("PERIODO",tcambio.getPeriodo()) ; 
			initialValues.put("B_COMPRA",tcambio.getB_compra()) ; 
			initialValues.put("B_VENTA",tcambio.getB_venta()) ; 
			initialValues.put("P_COMPRA",tcambio.getP_compra()) ; 
			initialValues.put("P_VENTA",tcambio.getP_venta()) ; 
			initialValues.put("T_COMPRA",tcambio.getT_compra()) ; 
			initialValues.put("T_VENTA",tcambio.getT_venta()) ; 
			initialValues.put("SINCRONIZA",tcambio.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(tcambio.getFechacreacion() ) ) ; 
			initialValues.put("E_COMPRA",tcambio.getE_compra()) ; 
			initialValues.put("E_VENTA",tcambio.getE_venta()) ; 
			resultado = mDb.update("TCAMBIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("TCAMBIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Tcambio> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Tcambio> lista  = new ArrayList<Tcambio>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("TCAMBIO",
					new String[] {
							 "FECHA" ,
							 "PERIODO" ,
							 "B_COMPRA" ,
							 "B_VENTA" ,
							 "P_COMPRA" ,
							 "P_VENTA" ,
							 "T_COMPRA" ,
							 "T_VENTA" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "E_COMPRA" ,
							 "E_VENTA" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Tcambio tcambio = new Tcambio() ;
					tcambio.setFecha(dateFormat.parse(cur.getString(j++)) );
					tcambio.setPeriodo(cur.getString(j++));
					tcambio.setB_compra(cur.getDouble(j++));
					tcambio.setB_venta(cur.getDouble(j++));
					tcambio.setP_compra(cur.getDouble(j++));
					tcambio.setP_venta(cur.getDouble(j++));
					tcambio.setT_compra(cur.getDouble(j++));
					tcambio.setT_venta(cur.getDouble(j++));
					tcambio.setSincroniza(cur.getString(j++));
					tcambio.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					tcambio.setE_compra(cur.getDouble(j++));
					tcambio.setE_venta(cur.getDouble(j++));

					lista.add(tcambio); 
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