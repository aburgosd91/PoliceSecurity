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

public class RutasDao extends BaseDao<Rutas> {
	public RutasDao() {
		super(Rutas.class);
	}
	public RutasDao(boolean usaCnBase) throws Exception {
		super(Rutas.class, usaCnBase);
	}
	public void mezclarLocal(Rutas obj)throws Exception{
		List<Rutas> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDRUTA))=?",obj.getIdempresa().trim(),obj.getIdruta().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}