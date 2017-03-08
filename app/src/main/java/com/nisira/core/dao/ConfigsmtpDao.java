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

public class ConfigsmtpDao extends BaseDao<Configsmtp> {
	public ConfigsmtpDao() {
		super(Configsmtp.class);
	}
	public ConfigsmtpDao(boolean usaCnBase) throws Exception {
		super(Configsmtp.class, usaCnBase);
	}

	public Boolean insert(Configsmtp configsmtp) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("ID",configsmtp.getId()); 
			initialValues.put("MAIL_SMTP_HOST",configsmtp.getMail_smtp_host()); 
			initialValues.put("MAIL_SMTP_STARTTLS_ENABLE",configsmtp.getMail_smtp_starttls_enable()); 
			initialValues.put("MAIL_SMTP_PORT",configsmtp.getMail_smtp_port()); 
			initialValues.put("MAIL_SMTP_MAIL_SENDER",configsmtp.getMail_smtp_mail_sender()); 
			initialValues.put("MAIL_SMTP_USER",configsmtp.getMail_smtp_user()); 
			initialValues.put("MAIL_SMTP_AUTH",configsmtp.getMail_smtp_auth()); 
			initialValues.put("MAIL_SMTP_PASSWORD",configsmtp.getMail_smtp_password()); 
			initialValues.put("ASUNTO",configsmtp.getAsunto()); 
			initialValues.put("MENSAJE",configsmtp.getMensaje()); 
			resultado = mDb.insert("CONFIGSMTP",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Configsmtp configsmtp,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("ID",configsmtp.getId()) ; 
			initialValues.put("MAIL_SMTP_HOST",configsmtp.getMail_smtp_host()) ; 
			initialValues.put("MAIL_SMTP_STARTTLS_ENABLE",configsmtp.getMail_smtp_starttls_enable()) ; 
			initialValues.put("MAIL_SMTP_PORT",configsmtp.getMail_smtp_port()) ; 
			initialValues.put("MAIL_SMTP_MAIL_SENDER",configsmtp.getMail_smtp_mail_sender()) ; 
			initialValues.put("MAIL_SMTP_USER",configsmtp.getMail_smtp_user()) ; 
			initialValues.put("MAIL_SMTP_AUTH",configsmtp.getMail_smtp_auth()) ; 
			initialValues.put("MAIL_SMTP_PASSWORD",configsmtp.getMail_smtp_password()) ; 
			initialValues.put("ASUNTO",configsmtp.getAsunto()) ; 
			initialValues.put("MENSAJE",configsmtp.getMensaje()) ; 
			resultado = mDb.update("CONFIGSMTP",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CONFIGSMTP",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Configsmtp> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Configsmtp> lista  = new ArrayList<Configsmtp>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CONFIGSMTP",
					new String[] {
							 "ID" ,
							 "MAIL_SMTP_HOST" ,
							 "MAIL_SMTP_STARTTLS_ENABLE" ,
							 "MAIL_SMTP_PORT" ,
							 "MAIL_SMTP_MAIL_SENDER" ,
							 "MAIL_SMTP_USER" ,
							 "MAIL_SMTP_AUTH" ,
							 "MAIL_SMTP_PASSWORD" ,
							 "ASUNTO" ,
							 "MENSAJE" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Configsmtp configsmtp = new Configsmtp() ;
					configsmtp.setId(cur.getString(j++));
					configsmtp.setMail_smtp_host(cur.getString(j++));
					configsmtp.setMail_smtp_starttls_enable(cur.getString(j++));
					configsmtp.setMail_smtp_port(cur.getString(j++));
					configsmtp.setMail_smtp_mail_sender(cur.getString(j++));
					configsmtp.setMail_smtp_user(cur.getString(j++));
					configsmtp.setMail_smtp_auth(cur.getString(j++));
					configsmtp.setMail_smtp_password(cur.getString(j++));
					configsmtp.setAsunto(cur.getString(j++));
					configsmtp.setMensaje(cur.getString(j++));

					lista.add(configsmtp); 
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