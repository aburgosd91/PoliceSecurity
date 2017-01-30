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

public class DordenservicioclienteDao extends BaseDao<Dordenserviciocliente> {
	public DordenservicioclienteDao() {
		super(Dordenserviciocliente.class);
	}
	public DordenservicioclienteDao(boolean usaCnBase) throws Exception {
		super(Dordenserviciocliente.class, usaCnBase);
	}
	public void mezclarLocal(Dordenserviciocliente obj)throws Exception{
		if(obj !=null){
			List<Dordenserviciocliente> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=? AND LTRIM(RTRIM(t0.ITEM))=?",obj.getIdempresa().trim(),obj.getIdordenservicio().trim(),obj.getItem().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Dordenserviciocliente> ListarxOrdenServicio(Ordenserviciocliente obj) throws Exception {

		if(obj!=null) {
			List<Dordenserviciocliente> dordenservicioclientes = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=?", obj.getIdempresa().trim(), obj.getIdordenservicio().trim());
			ProductosDao productosDao = new ProductosDao();
			int i = 0;
			for(Dordenserviciocliente x:dordenservicioclientes){
				List<Productos> lst = productosDao.listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDPRODUCTO))=?", x.getIdempresa().trim(), x.getIdservicio().trim());
				if(!lst.isEmpty()){
					x.setDescripcion_servicio(lst.get(0).getDescripcion());
					dordenservicioclientes.set(i,x);
				}
				i++;
			}
			return dordenservicioclientes;
		}
		return null;
	}


}