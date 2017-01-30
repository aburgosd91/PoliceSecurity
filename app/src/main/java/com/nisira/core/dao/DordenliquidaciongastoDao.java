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

public class DordenliquidaciongastoDao extends BaseDao<Dordenliquidaciongasto> {
	public DordenliquidaciongastoDao() {
		super(Dordenliquidaciongasto.class);
	}
	public DordenliquidaciongastoDao(boolean usaCnBase) throws Exception {
		super(Dordenliquidaciongasto.class, usaCnBase);
	}
	public void mezclarLocal(Dordenliquidaciongasto obj)throws Exception{
		if(obj !=null){
			List<Dordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=? AND LTRIM(RTRIM(t0.ITEM))=?",obj.getIdempresa().trim(),obj.getIdorden().trim(),obj.getItem().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
}