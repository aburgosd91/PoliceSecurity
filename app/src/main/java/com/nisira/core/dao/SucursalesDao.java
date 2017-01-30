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

public class SucursalesDao extends BaseDao<Sucursales> {
	public SucursalesDao() {
		super(Sucursales.class);
	}
	public SucursalesDao(boolean usaCnBase) throws Exception {
		super(Sucursales.class, usaCnBase);
	}
	public void mezclarLocal(Sucursales obj)throws Exception{
		List<Sucursales> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDSUCURSAL))=?",obj.getIdempresa().trim(),obj.getIdsucursal().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}