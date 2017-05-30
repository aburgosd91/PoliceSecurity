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

public class Det_tareowebDao extends BaseDao<Det_tareoweb> {
	public Det_tareowebDao() {
		super(Det_tareoweb.class);
	}
	public Det_tareowebDao(boolean usaCnBase) throws Exception {
		super(Det_tareoweb.class, usaCnBase);
	}

	public Boolean insert(Det_tareoweb det_tareoweb) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",det_tareoweb.getIdempresa()); 
			initialValues.put("IDCABTAREOWEB",det_tareoweb.getIdcabtareoweb()); 
			initialValues.put("IDORDENSERVICIO",det_tareoweb.getIdordenservicio()); 
			initialValues.put("IDDOCUMENTO",det_tareoweb.getIddocumento()); 
			initialValues.put("SERIE",det_tareoweb.getSerie()); 
			initialValues.put("NUMERO",det_tareoweb.getNumero()); 
			initialValues.put("RUC",det_tareoweb.getRuc()); 
			initialValues.put("RAZON",det_tareoweb.getRazon()); 
			initialValues.put("IDCARGO",det_tareoweb.getIdcargo()); 
			initialValues.put("IDPERSONAL",det_tareoweb.getIdpersonal()); 
			initialValues.put("ITEM_DORDENSERVICIO",det_tareoweb.getItem_dordenservicio()); 
			initialValues.put("ITEM2_PERSONALSERVICIO",det_tareoweb.getItem2_personalservicio()); 
			initialValues.put("ITEM_DPERSONALSERVICIO",det_tareoweb.getItem_dpersonalservicio()); 
			initialValues.put("HORA_REQ",det_tareoweb.getHora_req()); 
			initialValues.put("HORA_LLEGADA",det_tareoweb.getHora_llegada()); 
			initialValues.put("HORA_INICIO_SERV",det_tareoweb.getHora_inicio_serv()); 
			initialValues.put("HORA_FIN_SERV",det_tareoweb.getHora_fin_serv()); 
			initialValues.put("HORA_LIBERACION",det_tareoweb.getHora_liberacion()); 
			initialValues.put("FECHAREGISTRO",dateFormat.format(det_tareoweb.getFecharegistro() ) ); 
			initialValues.put("FECHAFINREGISTRO",dateFormat.format(det_tareoweb.getFechafinregistro() ) ); 
			resultado = mDb.insert("DET_TAREOWEB",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Det_tareoweb det_tareoweb,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",det_tareoweb.getIdempresa()) ; 
			initialValues.put("IDCABTAREOWEB",det_tareoweb.getIdcabtareoweb()) ; 
			initialValues.put("IDORDENSERVICIO",det_tareoweb.getIdordenservicio()) ; 
			initialValues.put("IDDOCUMENTO",det_tareoweb.getIddocumento()) ; 
			initialValues.put("SERIE",det_tareoweb.getSerie()) ; 
			initialValues.put("NUMERO",det_tareoweb.getNumero()) ; 
			initialValues.put("RUC",det_tareoweb.getRuc()) ; 
			initialValues.put("RAZON",det_tareoweb.getRazon()) ; 
			initialValues.put("IDCARGO",det_tareoweb.getIdcargo()) ; 
			initialValues.put("IDPERSONAL",det_tareoweb.getIdpersonal()) ; 
			initialValues.put("ITEM_DORDENSERVICIO",det_tareoweb.getItem_dordenservicio()) ; 
			initialValues.put("ITEM2_PERSONALSERVICIO",det_tareoweb.getItem2_personalservicio()) ; 
			initialValues.put("ITEM_DPERSONALSERVICIO",det_tareoweb.getItem_dpersonalservicio()) ; 
			initialValues.put("HORA_REQ",det_tareoweb.getHora_req()) ; 
			initialValues.put("HORA_LLEGADA",det_tareoweb.getHora_llegada()) ; 
			initialValues.put("HORA_INICIO_SERV",det_tareoweb.getHora_inicio_serv()) ; 
			initialValues.put("HORA_FIN_SERV",det_tareoweb.getHora_fin_serv()) ; 
			initialValues.put("HORA_LIBERACION",det_tareoweb.getHora_liberacion()) ; 
			initialValues.put("FECHAREGISTRO",dateFormat.format(det_tareoweb.getFecharegistro() ) ) ; 
			initialValues.put("FECHAFINREGISTRO",dateFormat.format(det_tareoweb.getFechafinregistro() ) ) ; 
			resultado = mDb.update("DET_TAREOWEB",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DET_TAREOWEB",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Det_tareoweb> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Det_tareoweb> lista  = new ArrayList<Det_tareoweb>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DET_TAREOWEB",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCABTAREOWEB" ,
							 "IDORDENSERVICIO" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "RUC" ,
							 "RAZON" ,
							 "IDCARGO" ,
							 "IDPERSONAL" ,
							 "ITEM_DORDENSERVICIO" ,
							 "ITEM2_PERSONALSERVICIO" ,
							 "ITEM_DPERSONALSERVICIO" ,
							 "HORA_REQ" ,
							 "HORA_LLEGADA" ,
							 "HORA_INICIO_SERV" ,
							 "HORA_FIN_SERV" ,
							 "HORA_LIBERACION" ,
							 "FECHAREGISTRO" ,
							 "FECHAFINREGISTRO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Det_tareoweb det_tareoweb = new Det_tareoweb() ;
					det_tareoweb.setIdempresa(cur.getString(j++));
					det_tareoweb.setIdcabtareoweb(cur.getString(j++));
					det_tareoweb.setIdordenservicio(cur.getString(j++));
					det_tareoweb.setIddocumento(cur.getString(j++));
					det_tareoweb.setSerie(cur.getString(j++));
					det_tareoweb.setNumero(cur.getString(j++));
					det_tareoweb.setRuc(cur.getString(j++));
					det_tareoweb.setRazon(cur.getString(j++));
					det_tareoweb.setIdcargo(cur.getString(j++));
					det_tareoweb.setIdpersonal(cur.getString(j++));
					det_tareoweb.setItem_dordenservicio(cur.getString(j++));
					det_tareoweb.setItem2_personalservicio(cur.getString(j++));
					det_tareoweb.setItem_dpersonalservicio(cur.getString(j++));
					det_tareoweb.setHora_req(cur.getDouble(j++));
					det_tareoweb.setHora_llegada(cur.getDouble(j++));
					det_tareoweb.setHora_inicio_serv(cur.getDouble(j++));
					det_tareoweb.setHora_fin_serv(cur.getDouble(j++));
					det_tareoweb.setHora_liberacion(cur.getDouble(j++));
					det_tareoweb.setFecharegistro(dateFormat.parse(cur.getString(j++)) );
					det_tareoweb.setFechafinregistro(dateFormat.parse(cur.getString(j++)) );

					lista.add(det_tareoweb); 
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