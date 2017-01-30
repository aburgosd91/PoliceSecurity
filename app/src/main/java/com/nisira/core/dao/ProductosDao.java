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

public class ProductosDao extends BaseDao<Productos> {
	public ProductosDao() {
		super(Productos.class);
	}
	public ProductosDao(boolean usaCnBase) throws Exception {
		super(Productos.class, usaCnBase);
	}
	public void mezclarLocal(Productos obj)throws Exception{
		List<Productos> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDPRODUCTO))=?",obj.getIdempresa().trim(),obj.getIdproducto().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}