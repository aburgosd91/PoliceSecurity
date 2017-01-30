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

public class Personal_servicioDao extends BaseDao<Personal_servicio> {
	public Personal_servicioDao() {
		super(Personal_servicio.class);
	}
	public Personal_servicioDao(boolean usaCnBase) throws Exception {
		super(Personal_servicio.class, usaCnBase);
	}
	public void mezclarLocal(Personal_servicio obj)throws Exception{
		List<Personal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=?" +
				" AND LTRIM(RTRIM(t0.ITEM))=? AND LTRIM(RTRIM(t0.ITEM2))=?",
				obj.getIdempresa().trim(),obj.getIdordenservicio().trim(),obj.getItem().trim(),obj.getItem2().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public 	List<Personal_servicio> listarxDordenservicio(Dordenserviciocliente obj) throws Exception {

		List<Personal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM))=?",
				obj.getIdempresa().trim(),obj.getIdordenservicio(),obj.getItem().trim());

		if(!lst.isEmpty()){
			return lst;
		}else{
			return null;
		}
	}
}