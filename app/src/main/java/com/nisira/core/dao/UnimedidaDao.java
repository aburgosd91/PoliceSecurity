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

public class UnimedidaDao extends BaseDao<Unimedida> {
	public UnimedidaDao() {
		super(Unimedida.class);
	}
	public UnimedidaDao(boolean usaCnBase) throws Exception {
		super(Unimedida.class, usaCnBase);
	}

	public Boolean insert(Unimedida unimedida) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",unimedida.getIdempresa()); 
			initialValues.put("IDMEDIDA",unimedida.getIdmedida()); 
			initialValues.put("DESCRIPCION",unimedida.getDescripcion()); 
			initialValues.put("NOMBRE_CORTO",unimedida.getNombre_corto()); 
			initialValues.put("ESTADO",unimedida.getEstado()); 
			initialValues.put("SINCRONIZA",unimedida.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(unimedida.getFechacreacion() ) ); 
			initialValues.put("CODIGO_SUNAT",unimedida.getCodigo_sunat()); 
			initialValues.put("UNIDVIAJE",unimedida.getUnidviaje()); 
			initialValues.put("UNIDTARIFA",unimedida.getUnidtarifa()); 
			initialValues.put("IDREGISTRO_SUNAT",unimedida.getIdregistro_sunat()); 
			initialValues.put("TIEMPO",unimedida.getTiempo()); 
			initialValues.put("UNIDTIEMPO",unimedida.getUnidtiempo()); 
			initialValues.put("CODIGO_ADUANA",unimedida.getCodigo_aduana()); 
			initialValues.put("REDONDEO_DRAWBACK",unimedida.getRedondeo_drawback()); 
			initialValues.put("TIPO_REDONDEO",unimedida.getTipo_redondeo()); 
			initialValues.put("DECIMAL_REDONDEO",unimedida.getDecimal_redondeo()); 
			initialValues.put("COMPANIA",unimedida.getCompania()); 
			resultado = mDb.insert("UNIMEDIDA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Unimedida unimedida,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",unimedida.getIdempresa()) ; 
			initialValues.put("IDMEDIDA",unimedida.getIdmedida()) ; 
			initialValues.put("DESCRIPCION",unimedida.getDescripcion()) ; 
			initialValues.put("NOMBRE_CORTO",unimedida.getNombre_corto()) ; 
			initialValues.put("ESTADO",unimedida.getEstado()) ; 
			initialValues.put("SINCRONIZA",unimedida.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(unimedida.getFechacreacion() ) ) ; 
			initialValues.put("CODIGO_SUNAT",unimedida.getCodigo_sunat()) ; 
			initialValues.put("UNIDVIAJE",unimedida.getUnidviaje()) ; 
			initialValues.put("UNIDTARIFA",unimedida.getUnidtarifa()) ; 
			initialValues.put("IDREGISTRO_SUNAT",unimedida.getIdregistro_sunat()) ; 
			initialValues.put("TIEMPO",unimedida.getTiempo()) ; 
			initialValues.put("UNIDTIEMPO",unimedida.getUnidtiempo()) ; 
			initialValues.put("CODIGO_ADUANA",unimedida.getCodigo_aduana()) ; 
			initialValues.put("REDONDEO_DRAWBACK",unimedida.getRedondeo_drawback()) ; 
			initialValues.put("TIPO_REDONDEO",unimedida.getTipo_redondeo()) ; 
			initialValues.put("DECIMAL_REDONDEO",unimedida.getDecimal_redondeo()) ; 
			initialValues.put("COMPANIA",unimedida.getCompania()) ; 
			resultado = mDb.update("UNIMEDIDA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("UNIMEDIDA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Unimedida> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Unimedida> lista  = new ArrayList<Unimedida>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("UNIMEDIDA",
					new String[] {
							 "IDEMPRESA" ,
							 "IDMEDIDA" ,
							 "DESCRIPCION" ,
							 "NOMBRE_CORTO" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "CODIGO_SUNAT" ,
							 "UNIDVIAJE" ,
							 "UNIDTARIFA" ,
							 "IDREGISTRO_SUNAT" ,
							 "TIEMPO" ,
							 "UNIDTIEMPO" ,
							 "CODIGO_ADUANA" ,
							 "REDONDEO_DRAWBACK" ,
							 "TIPO_REDONDEO" ,
							 "DECIMAL_REDONDEO" ,
							 "COMPANIA" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Unimedida unimedida = new Unimedida() ;
					unimedida.setIdempresa(cur.getString(j++));
					unimedida.setIdmedida(cur.getString(j++));
					unimedida.setDescripcion(cur.getString(j++));
					unimedida.setNombre_corto(cur.getString(j++));
					unimedida.setEstado(cur.getDouble(j++));
					unimedida.setSincroniza(cur.getString(j++));
					unimedida.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					unimedida.setCodigo_sunat(cur.getString(j++));
					unimedida.setUnidviaje(cur.getDouble(j++));
					unimedida.setUnidtarifa(cur.getDouble(j++));
					unimedida.setIdregistro_sunat(cur.getString(j++));
					unimedida.setTiempo(cur.getString(j++));
					unimedida.setUnidtiempo(cur.getDouble(j++));
					unimedida.setCodigo_aduana(cur.getString(j++));
					unimedida.setRedondeo_drawback(cur.getDouble(j++));
					unimedida.setTipo_redondeo(cur.getString(j++));
					unimedida.setDecimal_redondeo(cur.getDouble(j++));
					unimedida.setCompania(cur.getInt(j++));

					lista.add(unimedida); 
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