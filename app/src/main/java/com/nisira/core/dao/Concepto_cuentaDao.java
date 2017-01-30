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

public class Concepto_cuentaDao extends BaseDao<Concepto_cuenta> {
	public Concepto_cuentaDao() {
		super(Concepto_cuenta.class);
	}
	public Concepto_cuentaDao(boolean usaCnBase) throws Exception {
		super(Concepto_cuenta.class, usaCnBase);
	}
	public void mezclarLocal(Concepto_cuenta obj)throws Exception{
		List<Concepto_cuenta> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCONCEPTO))=?",obj.getIdempresa().trim(),obj.getIdconcepto().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}