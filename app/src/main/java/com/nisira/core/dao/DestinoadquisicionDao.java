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

public class DestinoadquisicionDao extends BaseDao<Destinoadquisicion> {
	public DestinoadquisicionDao() {
		super(Destinoadquisicion.class);
	}
	public DestinoadquisicionDao(boolean usaCnBase) throws Exception {
		super(Destinoadquisicion.class, usaCnBase);
	}
	public void mezclarLocal(Destinoadquisicion obj)throws Exception{
		List<Destinoadquisicion> lst= listar("LTRIM(RTRIM(t0.IDDESTINO))=?",obj.getIddestino().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}

}