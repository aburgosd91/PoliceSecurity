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

public class ConsumidorDao extends BaseDao<Consumidor> {
	public ConsumidorDao() {
		super(Consumidor.class);
	}
	public ConsumidorDao(boolean usaCnBase) throws Exception {
		super(Consumidor.class, usaCnBase);
	}
	public void mezclarLocal(Consumidor obj)throws Exception{
		if(obj !=null){
			List<Consumidor> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCONSUMIDOR))=?",obj.getIdempresa().trim(),obj.getIdconsumidor().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
}