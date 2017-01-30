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

public class OrdenliquidaciongastoDao extends BaseDao<Ordenliquidaciongasto> {
	public OrdenliquidaciongastoDao() {
		super(Ordenliquidaciongasto.class);
	}
	public OrdenliquidaciongastoDao(boolean usaCnBase) throws Exception {
		super(Ordenliquidaciongasto.class, usaCnBase);
	}
	public void mezclarLocal(Ordenliquidaciongasto obj)throws Exception{
		if(obj !=null){
			List<Ordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=?",obj.getIdempresa().trim(),obj.getIdorden().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
}