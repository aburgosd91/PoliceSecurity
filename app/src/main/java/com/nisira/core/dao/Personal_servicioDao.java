package com.nisira.core.dao;

import com.google.gson.Gson;
import com.nisira.core.entity.*;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.nisira.core.database.DataBaseClass;
import android.content.ContentValues;
import android.database.Cursor;
import com.nisira.core.util.ClaveMovil;
import com.nisira.view.Activity.mnt_PersonalServicio_Fragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal_servicioDao extends BaseDao<Personal_servicio> {
	public Personal_servicioDao() {
		super(Personal_servicio.class);
	}
	public Personal_servicioDao(boolean usaCnBase) throws Exception {
		super(Personal_servicio.class, usaCnBase);
	}
	public void mezclarLocal(Personal_servicio obj)throws Exception{
		List<Personal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =?  AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=?" +
						" AND LTRIM(RTRIM(t0.ITEM))=? AND LTRIM(RTRIM(t0.ITEM2))=?",
				obj.getIdempresa().trim(),obj.getIdordenservicio().trim(),obj.getItem().trim(),obj.getItem2().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public 	List<Personal_servicio> listarxDordenservicio(Dordenserviciocliente obj) throws Exception {

		List<Personal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM))=?",
			obj.getIdempresa().trim(),obj.getIdordenservicio(),obj.getItem().trim());
		 if(!lst.isEmpty()){
			 return lst;
		 }else{
			 return null;
		 }/**
		if(!lst.isEmpty()){
			Cargos_personalDao cargosDao = new Cargos_personalDao();
			int i = 0;
			for(Personal_servicio x:lst){
				List<Cargos_personal> lstcargo = cargosDao.listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCARGO))=?", x.getIdempresa().trim(), x.getIdcargo().trim());
				if(!lst.isEmpty()){
					x.setDescripcion_cargo(lstcargo.get(0).getDescripcion());
					lst.set(i,x);
				}
				i++;
			}
			return lst;
		}else{
			return null;
		}**/
	}
	public Boolean insert(Personal_servicio personal_servicio) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",personal_servicio.getIdempresa()); 
			initialValues.put("IDORDENSERVICIO",personal_servicio.getIdordenservicio()); 
			initialValues.put("ITEM",personal_servicio.getItem()); 
			initialValues.put("ITEM2",personal_servicio.getItem2()); 
			initialValues.put("IDPERSONAL",personal_servicio.getIdpersonal()); 
			initialValues.put("DNI",personal_servicio.getDni()); 
			initialValues.put("NOMBRES",personal_servicio.getNombres()); 
			initialValues.put("FECHAOPERACION",dateFormat.format(personal_servicio.getFechaoperacion() ) ); 
			initialValues.put("IDCARGO",personal_servicio.getIdcargo()); 
			initialValues.put("FECHAFIN",dateFormat.format(personal_servicio.getFechafin() ) ); 
			initialValues.put("CHECKLIST",personal_servicio.getChecklist()); 
			initialValues.put("IDVEHICULO",personal_servicio.getIdvehiculo());
			initialValues.put("DESCRIPCION_VEHICULO",personal_servicio.getDescripcion_vehiculo());
			initialValues.put("DESCRIPCION_CARGO",personal_servicio.getDescripcion_cargo());
			resultado = mDb.insert("PERSONAL_SERVICIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Personal_servicio personal_servicio,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",personal_servicio.getIdempresa()) ; 
			initialValues.put("IDORDENSERVICIO",personal_servicio.getIdordenservicio()) ; 
			initialValues.put("ITEM",personal_servicio.getItem()) ; 
			initialValues.put("ITEM2",personal_servicio.getItem2()) ; 
			initialValues.put("IDPERSONAL",personal_servicio.getIdpersonal()) ; 
			initialValues.put("DNI",personal_servicio.getDni()) ; 
			initialValues.put("NOMBRES",personal_servicio.getNombres()) ; 
			initialValues.put("FECHAOPERACION",dateFormat.format(personal_servicio.getFechaoperacion() ) ) ; 
			initialValues.put("IDCARGO",personal_servicio.getIdcargo()) ; 
			initialValues.put("FECHAFIN",dateFormat.format(personal_servicio.getFechafin() ) ) ; 
			initialValues.put("CHECKLIST",personal_servicio.getChecklist()) ; 
			initialValues.put("IDVEHICULO",personal_servicio.getIdvehiculo()) ;
			initialValues.put("DESCRIPCION_VEHICULO",personal_servicio.getDescripcion_vehiculo());
			initialValues.put("DESCRIPCION_CARGO",personal_servicio.getDescripcion_cargo());
			resultado = mDb.update("PERSONAL_SERVICIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PERSONAL_SERVICIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Personal_servicio> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Personal_servicio> lista  = new ArrayList<Personal_servicio>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PERSONAL_SERVICIO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDENSERVICIO" ,
							 "ITEM" ,
							 "ITEM2" ,
							 "IDPERSONAL" ,
							 "DNI" ,
							 "NOMBRES" ,
							 "FECHAOPERACION" ,
							 "IDCARGO" ,
							 "FECHAFIN" ,
							 "CHECKLIST" ,
							 "IDVEHICULO",
							 "DESCRIPCION_VEHICULO",
							 "DESCRIPCION_CARGO"
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Personal_servicio personal_servicio = new Personal_servicio() ;
					personal_servicio.setIdempresa(cur.getString(j++));
					personal_servicio.setIdordenservicio(cur.getString(j++));
					personal_servicio.setItem(cur.getString(j++));
					personal_servicio.setItem2(cur.getString(j++));
					personal_servicio.setIdpersonal(cur.getString(j++));
					personal_servicio.setDni(cur.getString(j++));
					personal_servicio.setNombres(cur.getString(j++));
					personal_servicio.setFechaoperacion(dateFormat.parse(cur.getString(j++)) );
					personal_servicio.setIdcargo(cur.getString(j++));
					personal_servicio.setFechafin(dateFormat.parse(cur.getString(j++)) );
					personal_servicio.setChecklist(cur.getString(j++));
					personal_servicio.setIdvehiculo(cur.getString(j++));
					personal_servicio.setDescripcion_vehiculo(cur.getString(j++));
					personal_servicio.setDescripcion_cargo(cur.getString(j++));

					lista.add(personal_servicio); 
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
	public static String ListClieProv_Free(String Trama){
		String succes="false";
		List<Clieprov> listclieprov = new ArrayList<>();

		List<Clieprov> lst = new ArrayList<>();
		try {
			Gson gson = new Gson();
			EstructClieProvFree ListInfo = gson.fromJson(Trama, EstructClieProvFree.class);

			Clieprov or;
			for (DatosClieProvFree ob : ListInfo.getDatos()) {
				or = new Clieprov();
				or.setIdempresa(ob.getIdempresa());
				or.setIdclieprov(ob.getIdclieprov());
				or.setNombres(ob.getNombres());
				or.setApellidopaterno(ob.getApellidopaterno());
				or.setApellidomaterno(ob.getApellidomaterno());
				or.setDni(ob.getDni());

				lst.add(or);
			}
			if (!lst.isEmpty()) {
				mnt_PersonalServicio_Fragment obj = new mnt_PersonalServicio_Fragment();
				obj.LlenarCampos();
				succes = "OK";
			}


		} catch (Exception e) {
			e.getMessage();
		}
		return succes;
	}
}