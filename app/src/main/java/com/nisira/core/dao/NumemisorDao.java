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

public class NumemisorDao extends BaseDao<Numemisor> {
	public NumemisorDao() {
		super(Numemisor.class);
	}
	public NumemisorDao(boolean usaCnBase) throws Exception {
		super(Numemisor.class, usaCnBase);
	}
	public void mezclarLocal(Numemisor obj)throws Exception{

		List<Numemisor> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDEMISOR))=? AND LTRIM(RTRIM(t0.IDDOCUMENTO))=? AND LTRIM(RTRIM(t0.SERIE))=?",
				obj.getIdempresa().trim(),obj.getIdemisor().trim(),obj.getIddocumento().trim(),obj.getSerie().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
}