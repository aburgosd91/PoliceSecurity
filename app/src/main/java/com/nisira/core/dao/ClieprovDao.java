package com.nisira.core.dao;

import com.nisira.core.Consulta;
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

public class ClieprovDao extends BaseDao<Clieprov> {
	public ClieprovDao() {
		super(Clieprov.class);
	}
	public ClieprovDao(boolean usaCnBase) throws Exception {
		super(Clieprov.class, usaCnBase);
	}
	public void mezclarLocal(Clieprov obj)throws Exception{
		if(obj !=null){
			List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCLIEPROV))=?",obj.getIdempresa().trim(),obj.getIdclieprov().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
//			update(obj,"IDEMPRESA='"+obj.getIdempresa()+"' AND IDCLIEPROV='"+obj.getIdclieprov()+"'");
		}
	}
	public Clieprov getClientexempresa_codigo(String idempresa , String idclieprov) throws Exception {
		List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCLIEPROV))=?",idempresa.trim(),idclieprov.trim());
		if(!lst.isEmpty()){
			return lst.get(0);
		}
		return null;
	}
}