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

public class UsuarioDao extends BaseDao<Usuario> {
	public UsuarioDao() {
		super(Usuario.class);
	}
	public UsuarioDao(boolean usaCnBase) throws Exception {
		super(Usuario.class, usaCnBase);
	}

	public Boolean insert(Usuario usuario) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",usuario.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",usuario.getIdempresa()); 
			initialValues.put("IDUSUARIO",usuario.getIdusuario()); 
			initialValues.put("USR_NOMBRES",usuario.getUsr_nombres()); 
			initialValues.put("PASSWORD",usuario.getPassword()); 
			initialValues.put("ESTADO",usuario.getEstado()); 
			initialValues.put("FECHACREACION",dateFormat.format(usuario.getFechacreacion() ) ); 
			resultado = mDb.insert("USUARIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Usuario usuario,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",usuario.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",usuario.getIdempresa()) ; 
			initialValues.put("IDUSUARIO",usuario.getIdusuario()) ; 
			initialValues.put("USR_NOMBRES",usuario.getUsr_nombres()) ; 
			initialValues.put("PASSWORD",usuario.getPassword()) ; 
			initialValues.put("ESTADO",usuario.getEstado()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(usuario.getFechacreacion() ) ) ; 
			resultado = mDb.update("USUARIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("USUARIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Usuario> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Usuario> lista  = new ArrayList<Usuario>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("USUARIO",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDUSUARIO" ,
							 "USR_NOMBRES" ,
							 "PASSWORD" ,
							 "ESTADO" ,
							 "FECHACREACION" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Usuario usuario = new Usuario() ;
					usuario.setIdbasedatos(cur.getString(j++));
					usuario.setIdempresa(cur.getString(j++));
					usuario.setIdusuario(cur.getString(j++));
					usuario.setUsr_nombres(cur.getString(j++));
					usuario.setPassword(cur.getString(j++));
					usuario.setEstado(cur.getInt(j++));
					usuario.setFechacreacion(dateFormat.parse(cur.getString(j++)) );

					lista.add(usuario); 
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
	/*-Fin-*/
}