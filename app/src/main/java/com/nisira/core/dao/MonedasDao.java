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

public class MonedasDao extends BaseDao<Monedas> {
	public MonedasDao() {
		super(Monedas.class);
	}
	public MonedasDao(boolean usaCnBase) throws Exception {
		super(Monedas.class, usaCnBase);
	}

	public Boolean insert(Monedas monedas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDMONEDA",monedas.getIdmoneda()); 
			initialValues.put("NOMBRE_CORTO",monedas.getNombre_corto()); 
			initialValues.put("DESCRIPCION",monedas.getDescripcion()); 
			initialValues.put("TIPO_MONEDA",monedas.getTipo_moneda()); 
			initialValues.put("ESTADO",monedas.getEstado()); 
			initialValues.put("SINCRONIZA",monedas.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(monedas.getFechacreacion() ) ); 
			initialValues.put("IDREGISTRO_SUNAT",monedas.getIdregistro_sunat()); 
			initialValues.put("DESCRIPCION_INGLES",monedas.getDescripcion_ingles()); 
			initialValues.put("TIPO_BUSQUEDA",monedas.getTipo_busqueda()); 
			initialValues.put("DESCRIPCION2",monedas.getDescripcion2()); 
			initialValues.put("IDBUSQUEDA",monedas.getIdbusqueda()); 
			initialValues.put("DIFDIAS",monedas.getDifdias()); 
			initialValues.put("ORDEN_AJUSTE",monedas.getOrden_ajuste()); 
			resultado = mDb.insert("MONEDAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Monedas monedas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDMONEDA",monedas.getIdmoneda()) ; 
			initialValues.put("NOMBRE_CORTO",monedas.getNombre_corto()) ; 
			initialValues.put("DESCRIPCION",monedas.getDescripcion()) ; 
			initialValues.put("TIPO_MONEDA",monedas.getTipo_moneda()) ; 
			initialValues.put("ESTADO",monedas.getEstado()) ; 
			initialValues.put("SINCRONIZA",monedas.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(monedas.getFechacreacion() ) ) ; 
			initialValues.put("IDREGISTRO_SUNAT",monedas.getIdregistro_sunat()) ; 
			initialValues.put("DESCRIPCION_INGLES",monedas.getDescripcion_ingles()) ; 
			initialValues.put("TIPO_BUSQUEDA",monedas.getTipo_busqueda()) ; 
			initialValues.put("DESCRIPCION2",monedas.getDescripcion2()) ; 
			initialValues.put("IDBUSQUEDA",monedas.getIdbusqueda()) ; 
			initialValues.put("DIFDIAS",monedas.getDifdias()) ; 
			initialValues.put("ORDEN_AJUSTE",monedas.getOrden_ajuste()) ; 
			resultado = mDb.update("MONEDAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("MONEDAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Monedas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Monedas> lista  = new ArrayList<Monedas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("MONEDAS",
					new String[] {
							 "IDMONEDA" ,
							 "NOMBRE_CORTO" ,
							 "DESCRIPCION" ,
							 "TIPO_MONEDA" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "IDREGISTRO_SUNAT" ,
							 "DESCRIPCION_INGLES" ,
							 "TIPO_BUSQUEDA" ,
							 "DESCRIPCION2" ,
							 "IDBUSQUEDA" ,
							 "DIFDIAS" ,
							 "ORDEN_AJUSTE" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Monedas monedas = new Monedas() ;
					monedas.setIdmoneda(cur.getString(j++));
					monedas.setNombre_corto(cur.getString(j++));
					monedas.setDescripcion(cur.getString(j++));
					monedas.setTipo_moneda(cur.getString(j++));
					monedas.setEstado(cur.getDouble(j++));
					monedas.setSincroniza(cur.getString(j++));
					monedas.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					monedas.setIdregistro_sunat(cur.getString(j++));
					monedas.setDescripcion_ingles(cur.getString(j++));
					monedas.setTipo_busqueda(cur.getString(j++));
					monedas.setDescripcion2(cur.getString(j++));
					monedas.setIdbusqueda(cur.getString(j++));
					monedas.setDifdias(cur.getDouble(j++));
					monedas.setOrden_ajuste(cur.getDouble(j++));

					lista.add(monedas); 
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