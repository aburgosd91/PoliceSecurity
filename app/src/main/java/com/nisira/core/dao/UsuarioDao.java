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

public class UsuarioDao extends BaseDao<Usuario> {
	public UsuarioDao() {
		super(Usuario.class);
	}
	public UsuarioDao(boolean usaCnBase) throws Exception {
		super(Usuario.class, usaCnBase);
	}

	public void mezclarLocal(Usuario obj)throws Exception{
		if(obj !=null){
			List<Usuario> lst = listar("LTRIM(RTRIM(t0.IDUSUARIO ))=?",obj.getIdusuario().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public Usuario getUsuario_base(String idusuario) throws Exception {
		Usuario user=null;
		if (idusuario != null) {
			List<Usuario> lst = listar("LTRIM(RTRIM(t0.IDUSUARIO)) =? ", idusuario.trim());
			if(lst.isEmpty()){
				return null;
			}else
				return lst.get(0);
		}
		return user;
	}
	/*-Fin-*/
}