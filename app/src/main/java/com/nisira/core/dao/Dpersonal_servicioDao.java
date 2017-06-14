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

public class Dpersonal_servicioDao extends BaseDao<Dpersonal_servicio> {
	public Dpersonal_servicioDao() {
		super(Dpersonal_servicio.class);
	}
	public Dpersonal_servicioDao(boolean usaCnBase) throws Exception {
		super(Dpersonal_servicio.class, usaCnBase);
	}
	public void mezclarLocal(Dpersonal_servicio obj)throws Exception{
		if(obj !=null){
			List<Dpersonal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND " +
							"LTRIM(RTRIM(t0.ITEM_DORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM2))=? AND LTRIM(RTRIM(t0.ITEM))=? ",obj.getIdempresa().trim(),
					obj.getIdordenservicio().trim(),obj.getItem_dordenservicio().trim(),obj.getItem2().trim(),obj.getItem().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Dpersonal_servicio> listarxPersonalServicio(Personal_servicio obj) throws Exception {
		List<Dpersonal_servicio> lst= new ArrayList<>();
		if(obj !=null) {
			lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND " +
							"LTRIM(RTRIM(t0.ITEM_DORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM2))=? ", obj.getIdempresa().trim(),
					obj.getIdordenservicio().trim(), obj.getItem().trim(), obj.getItem2().trim());
			if(!lst.isEmpty())return lst;
		}
		return null;
	}
	public void Eliminar(Dpersonal_servicio obj) throws Exception {
		borrar(obj);
	}
	public Boolean insert(Dpersonal_servicio dpersonal_servicio) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dpersonal_servicio.getIdempresa()); 
			initialValues.put("IDORDENSERVICIO",dpersonal_servicio.getIdordenservicio()); 
			initialValues.put("ITEM_DORDENSERVICIO",dpersonal_servicio.getItem_dordenservicio()); 
			initialValues.put("ITEM2",dpersonal_servicio.getItem2()); 
			initialValues.put("ITEM",dpersonal_servicio.getItem()); 
			initialValues.put("HORA_REQ",dpersonal_servicio.getHora_req()); 
			initialValues.put("HORA_LLEGADA",dpersonal_servicio.getHora_llegada()); 
			initialValues.put("HORA_INICIO_SERV",dpersonal_servicio.getHora_inicio_serv()); 
			initialValues.put("HORA_FIN_SERV",dpersonal_servicio.getHora_fin_serv()); 
			initialValues.put("HORA_LIBERACION",dpersonal_servicio.getHora_liberacion()); 
			initialValues.put("IDCARGO",dpersonal_servicio.getIdcargo()); 
			initialValues.put("FECHAREGISTRO",dateFormat.format(dpersonal_servicio.getFecharegistro() ) ); 
			initialValues.put("FECHAFINREGISTRO",dateFormat.format(dpersonal_servicio.getFechafinregistro() ) ); 
			resultado = mDb.insert("DPERSONAL_SERVICIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dpersonal_servicio dpersonal_servicio,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dpersonal_servicio.getIdempresa()) ; 
			initialValues.put("IDORDENSERVICIO",dpersonal_servicio.getIdordenservicio()) ; 
			initialValues.put("ITEM_DORDENSERVICIO",dpersonal_servicio.getItem_dordenservicio()) ; 
			initialValues.put("ITEM2",dpersonal_servicio.getItem2()) ; 
			initialValues.put("ITEM",dpersonal_servicio.getItem()) ; 
			initialValues.put("HORA_REQ",dpersonal_servicio.getHora_req()) ; 
			initialValues.put("HORA_LLEGADA",dpersonal_servicio.getHora_llegada()) ; 
			initialValues.put("HORA_INICIO_SERV",dpersonal_servicio.getHora_inicio_serv()) ; 
			initialValues.put("HORA_FIN_SERV",dpersonal_servicio.getHora_fin_serv()) ; 
			initialValues.put("HORA_LIBERACION",dpersonal_servicio.getHora_liberacion()) ; 
			initialValues.put("IDCARGO",dpersonal_servicio.getIdcargo()) ; 
			initialValues.put("FECHAREGISTRO",dateFormat.format(dpersonal_servicio.getFecharegistro() ) ) ; 
			initialValues.put("FECHAFINREGISTRO",dateFormat.format(dpersonal_servicio.getFechafinregistro() ) ) ; 
			resultado = mDb.update("DPERSONAL_SERVICIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DPERSONAL_SERVICIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Dpersonal_servicio> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Dpersonal_servicio> lista  = new ArrayList<Dpersonal_servicio>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DPERSONAL_SERVICIO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDENSERVICIO" ,
							 "ITEM_DORDENSERVICIO" ,
							 "ITEM2" ,
							 "ITEM" ,
							 "HORA_REQ" ,
							 "HORA_LLEGADA" ,
							 "HORA_INICIO_SERV" ,
							 "HORA_FIN_SERV" ,
							 "HORA_LIBERACION" ,
							 "IDCARGO" ,
							 "FECHAREGISTRO" ,
							 "FECHAFINREGISTRO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Dpersonal_servicio dpersonal_servicio = new Dpersonal_servicio() ;
					dpersonal_servicio.setIdempresa(cur.getString(j++));
					dpersonal_servicio.setIdordenservicio(cur.getString(j++));
					dpersonal_servicio.setItem_dordenservicio(cur.getString(j++));
					dpersonal_servicio.setItem2(cur.getString(j++));
					dpersonal_servicio.setItem(cur.getString(j++));
					dpersonal_servicio.setHora_req(cur.getDouble(j++));
					dpersonal_servicio.setHora_llegada(cur.getDouble(j++));
					dpersonal_servicio.setHora_inicio_serv(cur.getDouble(j++));
					dpersonal_servicio.setHora_fin_serv(cur.getDouble(j++));
					dpersonal_servicio.setHora_liberacion(cur.getDouble(j++));
					dpersonal_servicio.setIdcargo(cur.getString(j++));
					dpersonal_servicio.setFecharegistro(dateFormat.parse(cur.getString(j++)) );
					dpersonal_servicio.setFechafinregistro(dateFormat.parse(cur.getString(j++)) );

					lista.add(dpersonal_servicio); 
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