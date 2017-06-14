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

public class Cargos_personalDao extends BaseDao<Cargos_personal> {
	public Cargos_personalDao() {
		super(Cargos_personal.class);
	}
	public Cargos_personalDao(boolean usaCnBase) throws Exception {
		super(Cargos_personal.class, usaCnBase);
	}

	public void mezclarLocal(Cargos_personal obj)throws Exception{
		if(obj !=null){
			List<Cargos_personal> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCARGO))=?",obj.getIdempresa().trim(),obj.getIdcargo().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
//			update(obj,"IDEMPRESA='"+obj.getIdempresa()+"' AND IDCLIEPROV='"+obj.getIdclieprov()+"'");
		}
	}

	public Boolean insert(Cargos_personal cargos_personal) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cargos_personal.getIdempresa()); 
			initialValues.put("IDCARGO",cargos_personal.getIdcargo()); 
			initialValues.put("DESCRIPCION",cargos_personal.getDescripcion()); 
			initialValues.put("IDACTIVIDAD",cargos_personal.getIdactividad()); 
			initialValues.put("IDLABOR",cargos_personal.getIdlabor()); 
			initialValues.put("SINCRONIZA",cargos_personal.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(cargos_personal.getFechacreacion() ) ); 
			initialValues.put("CODALTERNO",cargos_personal.getCodalterno()); 
			initialValues.put("ES_GUARDIAN",cargos_personal.getEs_guardian()); 
			initialValues.put("ES_PERS_AEREO",cargos_personal.getEs_pers_aereo()); 
			initialValues.put("PRODUCCION_PESQUERA",cargos_personal.getProduccion_pesquera()); 
			initialValues.put("CARGO_PESQUERA",cargos_personal.getCargo_pesquera()); 
			initialValues.put("TIPO_TRABAJO",cargos_personal.getTipo_trabajo()); 
			initialValues.put("IDAREA",cargos_personal.getIdarea()); 
			initialValues.put("ES_JEFEDEAREA",cargos_personal.getEs_jefedearea()); 
			initialValues.put("USA_SUBSECTOR",cargos_personal.getUsa_subsector()); 
			initialValues.put("TIPO_CARGO",cargos_personal.getTipo_cargo()); 
			initialValues.put("ES_CHOFER",cargos_personal.getEs_chofer()); 
			resultado = mDb.insert("CARGOS_PERSONAL",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Cargos_personal cargos_personal,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cargos_personal.getIdempresa()) ; 
			initialValues.put("IDCARGO",cargos_personal.getIdcargo()) ; 
			initialValues.put("DESCRIPCION",cargos_personal.getDescripcion()) ; 
			initialValues.put("IDACTIVIDAD",cargos_personal.getIdactividad()) ; 
			initialValues.put("IDLABOR",cargos_personal.getIdlabor()) ; 
			initialValues.put("SINCRONIZA",cargos_personal.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(cargos_personal.getFechacreacion() ) ) ; 
			initialValues.put("CODALTERNO",cargos_personal.getCodalterno()) ; 
			initialValues.put("ES_GUARDIAN",cargos_personal.getEs_guardian()) ; 
			initialValues.put("ES_PERS_AEREO",cargos_personal.getEs_pers_aereo()) ; 
			initialValues.put("PRODUCCION_PESQUERA",cargos_personal.getProduccion_pesquera()) ; 
			initialValues.put("CARGO_PESQUERA",cargos_personal.getCargo_pesquera()) ; 
			initialValues.put("TIPO_TRABAJO",cargos_personal.getTipo_trabajo()) ; 
			initialValues.put("IDAREA",cargos_personal.getIdarea()) ; 
			initialValues.put("ES_JEFEDEAREA",cargos_personal.getEs_jefedearea()) ; 
			initialValues.put("USA_SUBSECTOR",cargos_personal.getUsa_subsector()) ; 
			initialValues.put("TIPO_CARGO",cargos_personal.getTipo_cargo()) ; 
			initialValues.put("ES_CHOFER",cargos_personal.getEs_chofer()) ; 
			resultado = mDb.update("CARGOS_PERSONAL",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CARGOS_PERSONAL",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Cargos_personal> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Cargos_personal> lista  = new ArrayList<Cargos_personal>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CARGOS_PERSONAL",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCARGO" ,
							 "DESCRIPCION" ,
							 "IDACTIVIDAD" ,
							 "IDLABOR" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "CODALTERNO" ,
							 "ES_GUARDIAN" ,
							 "ES_PERS_AEREO" ,
							 "PRODUCCION_PESQUERA" ,
							 "CARGO_PESQUERA" ,
							 "TIPO_TRABAJO" ,
							 "IDAREA" ,
							 "ES_JEFEDEAREA" ,
							 "USA_SUBSECTOR" ,
							 "TIPO_CARGO" ,
							 "ES_CHOFER" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Cargos_personal cargos_personal = new Cargos_personal() ;
					cargos_personal.setIdempresa(cur.getString(j++));
					cargos_personal.setIdcargo(cur.getString(j++));
					cargos_personal.setDescripcion(cur.getString(j++));
					cargos_personal.setIdactividad(cur.getString(j++));
					cargos_personal.setIdlabor(cur.getString(j++));
					cargos_personal.setSincroniza(cur.getString(j++));
					cargos_personal.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					cargos_personal.setCodalterno(cur.getString(j++));
					cargos_personal.setEs_guardian(cur.getInt(j++));
					cargos_personal.setEs_pers_aereo(cur.getDouble(j++));
					cargos_personal.setProduccion_pesquera(cur.getDouble(j++));
					cargos_personal.setCargo_pesquera(cur.getString(j++));
					cargos_personal.setTipo_trabajo(cur.getString(j++));
					cargos_personal.setIdarea(cur.getString(j++));
					cargos_personal.setEs_jefedearea(cur.getDouble(j++));
					cargos_personal.setUsa_subsector(cur.getDouble(j++));
					cargos_personal.setTipo_cargo(cur.getDouble(j++));
					cargos_personal.setEs_chofer(cur.getDouble(j++));

					lista.add(cargos_personal); 
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