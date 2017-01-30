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
}