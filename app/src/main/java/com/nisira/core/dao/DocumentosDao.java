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

public class DocumentosDao extends BaseDao<Documentos> {
	public DocumentosDao() {
		super(Documentos.class);
	}
	public DocumentosDao(boolean usaCnBase) throws Exception {
		super(Documentos.class, usaCnBase);
	}
	public void mezclarLocal(Documentos obj)throws Exception{
		List<Documentos> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDDOCUMENTO))=?",obj.getIdempresa().trim(),obj.getIddocumento().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}