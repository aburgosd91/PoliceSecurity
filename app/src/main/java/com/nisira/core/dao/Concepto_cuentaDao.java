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

public class Concepto_cuentaDao extends BaseDao<Concepto_cuenta> {
	public Concepto_cuentaDao() {
		super(Concepto_cuenta.class);
	}
	public Concepto_cuentaDao(boolean usaCnBase) throws Exception {
		super(Concepto_cuenta.class, usaCnBase);
	}
	public void mezclarLocal(Concepto_cuenta obj)throws Exception{
		List<Concepto_cuenta> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCONCEPTO))=?",obj.getIdempresa().trim(),obj.getIdconcepto().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}

	public List<Concepto_cuenta> ListarConsumidor(Dordenliquidaciongasto obj)throws Exception {
		if (obj != null) {
			List<Concepto_cuenta> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? ", obj.getIdempresa().trim());
			if(lst.isEmpty()){
				return null;
			}else
				return lst;
		}
		return null;
	}
	public Boolean insert(Concepto_cuenta concepto_cuenta) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",concepto_cuenta.getIdempresa()); 
			initialValues.put("IDCONCEPTO",concepto_cuenta.getIdconcepto()); 
			initialValues.put("IDCUENTA",concepto_cuenta.getIdcuenta()); 
			initialValues.put("DESCRIPCION",concepto_cuenta.getDescripcion()); 
			initialValues.put("REGISTRAR_EN",concepto_cuenta.getRegistrar_en()); 
			initialValues.put("ESTADO",concepto_cuenta.getEstado()); 
			initialValues.put("SINCRONIZA",concepto_cuenta.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(concepto_cuenta.getFechacreacion() ) ); 
			resultado = mDb.insert("CONCEPTO_CUENTA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Concepto_cuenta concepto_cuenta,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",concepto_cuenta.getIdempresa()) ; 
			initialValues.put("IDCONCEPTO",concepto_cuenta.getIdconcepto()) ; 
			initialValues.put("IDCUENTA",concepto_cuenta.getIdcuenta()) ; 
			initialValues.put("DESCRIPCION",concepto_cuenta.getDescripcion()) ; 
			initialValues.put("REGISTRAR_EN",concepto_cuenta.getRegistrar_en()) ; 
			initialValues.put("ESTADO",concepto_cuenta.getEstado()) ; 
			initialValues.put("SINCRONIZA",concepto_cuenta.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(concepto_cuenta.getFechacreacion() ) ) ; 
			resultado = mDb.update("CONCEPTO_CUENTA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CONCEPTO_CUENTA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Concepto_cuenta> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Concepto_cuenta> lista  = new ArrayList<Concepto_cuenta>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CONCEPTO_CUENTA",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCONCEPTO" ,
							 "IDCUENTA" ,
							 "DESCRIPCION" ,
							 "REGISTRAR_EN" ,
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
					Concepto_cuenta concepto_cuenta = new Concepto_cuenta() ;
					concepto_cuenta.setIdempresa(cur.getString(j++));
					concepto_cuenta.setIdconcepto(cur.getString(j++));
					concepto_cuenta.setIdcuenta(cur.getString(j++));
					concepto_cuenta.setDescripcion(cur.getString(j++));
					concepto_cuenta.setRegistrar_en(cur.getString(j++));
					concepto_cuenta.setEstado(cur.getDouble(j++));
					concepto_cuenta.setSincroniza(cur.getString(j++));
					concepto_cuenta.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(concepto_cuenta); 
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