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

public class Dpersonal_servicioDao extends BaseDao<Dpersonal_servicio> {
	public Dpersonal_servicioDao() {
		super(Dpersonal_servicio.class);
	}
	public Dpersonal_servicioDao(boolean usaCnBase) throws Exception {
		super(Dpersonal_servicio.class, usaCnBase);
	}
	public void mezclarLocal(Dpersonal_servicio obj)throws Exception{
		if(obj !=null){
			List<Dpersonal_servicio> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND " +
					"LTRIM(RTRIM(t0.ITEM_DORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM2))=? AND LTRIM(RTRIM(t0.ITEM))=? ",obj.getIdempresa().trim(),
					obj.getIdordenservicio().trim(),obj.getItem_dordenservicio().trim(),obj.getItem2().trim(),obj.getItem().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Dpersonal_servicio> listarxPersonalServicio(Personal_servicio obj) throws Exception {
		List<Dpersonal_servicio> lst= new ArrayList<>();
		if(obj !=null) {
			lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND " +
							"LTRIM(RTRIM(t0.ITEM_DORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM2))=? ", obj.getIdempresa().trim(),
					obj.getIdordenservicio().trim(), obj.getItem().trim(), obj.getItem2().trim());
			if(!lst.isEmpty())return lst;
		}
		return null;
	}
	public void Eliminar(Dpersonal_servicio obj) throws Exception {
		borrar(obj);
	}
}