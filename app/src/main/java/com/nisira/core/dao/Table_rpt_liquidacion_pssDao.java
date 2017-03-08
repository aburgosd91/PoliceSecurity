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

public class Table_rpt_liquidacion_pssDao extends BaseDao<Table_rpt_liquidacion_pss> {
	public Table_rpt_liquidacion_pssDao() {
		super(Table_rpt_liquidacion_pss.class);
	}
	public Table_rpt_liquidacion_pssDao(boolean usaCnBase) throws Exception {
		super(Table_rpt_liquidacion_pss.class, usaCnBase);
	}

	public Boolean insert(Table_rpt_liquidacion_pss table_rpt_liquidacion_pss) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("CAMPO1",table_rpt_liquidacion_pss.getCampo1()); 
			initialValues.put("CAMPO2",table_rpt_liquidacion_pss.getCampo2()); 
			initialValues.put("CAMPO3",table_rpt_liquidacion_pss.getCampo3()); 
			initialValues.put("CAMPO4",table_rpt_liquidacion_pss.getCampo4()); 
			initialValues.put("CAMPO5",table_rpt_liquidacion_pss.getCampo5()); 
			initialValues.put("CAMPO6",table_rpt_liquidacion_pss.getCampo6()); 
			initialValues.put("CAMPO7",table_rpt_liquidacion_pss.getCampo7()); 
			initialValues.put("CAMPO8",table_rpt_liquidacion_pss.getCampo8()); 
			initialValues.put("CAMPO9",table_rpt_liquidacion_pss.getCampo9()); 
			initialValues.put("CAMPO10",table_rpt_liquidacion_pss.getCampo10()); 
			initialValues.put("CAMPO11",table_rpt_liquidacion_pss.getCampo11()); 
			initialValues.put("CAMPO12",table_rpt_liquidacion_pss.getCampo12()); 
			initialValues.put("CAMPO13",table_rpt_liquidacion_pss.getCampo13()); 
			initialValues.put("CAMPO14",table_rpt_liquidacion_pss.getCampo14()); 
			initialValues.put("CAMPO15",table_rpt_liquidacion_pss.getCampo15()); 
			resultado = mDb.insert("TABLE_RPT_LIQUIDACION_PSS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Table_rpt_liquidacion_pss table_rpt_liquidacion_pss,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("CAMPO1",table_rpt_liquidacion_pss.getCampo1()) ; 
			initialValues.put("CAMPO2",table_rpt_liquidacion_pss.getCampo2()) ; 
			initialValues.put("CAMPO3",table_rpt_liquidacion_pss.getCampo3()) ; 
			initialValues.put("CAMPO4",table_rpt_liquidacion_pss.getCampo4()) ; 
			initialValues.put("CAMPO5",table_rpt_liquidacion_pss.getCampo5()) ; 
			initialValues.put("CAMPO6",table_rpt_liquidacion_pss.getCampo6()) ; 
			initialValues.put("CAMPO7",table_rpt_liquidacion_pss.getCampo7()) ; 
			initialValues.put("CAMPO8",table_rpt_liquidacion_pss.getCampo8()) ; 
			initialValues.put("CAMPO9",table_rpt_liquidacion_pss.getCampo9()) ; 
			initialValues.put("CAMPO10",table_rpt_liquidacion_pss.getCampo10()) ; 
			initialValues.put("CAMPO11",table_rpt_liquidacion_pss.getCampo11()) ; 
			initialValues.put("CAMPO12",table_rpt_liquidacion_pss.getCampo12()) ; 
			initialValues.put("CAMPO13",table_rpt_liquidacion_pss.getCampo13()) ; 
			initialValues.put("CAMPO14",table_rpt_liquidacion_pss.getCampo14()) ; 
			initialValues.put("CAMPO15",table_rpt_liquidacion_pss.getCampo15()) ; 
			resultado = mDb.update("TABLE_RPT_LIQUIDACION_PSS",initialValues,where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boolean delete(String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			resultado = mDb.delete("TABLE_RPT_LIQUIDACION_PSS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Table_rpt_liquidacion_pss> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Table_rpt_liquidacion_pss> lista  = new ArrayList<Table_rpt_liquidacion_pss>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("TABLE_RPT_LIQUIDACION_PSS",
					new String[] {
							 "CAMPO1" ,
							 "CAMPO2" ,
							 "CAMPO3" ,
							 "CAMPO4" ,
							 "CAMPO5" ,
							 "CAMPO6" ,
							 "CAMPO7" ,
							 "CAMPO8" ,
							 "CAMPO9" ,
							 "CAMPO10" ,
							 "CAMPO11" ,
							 "CAMPO12" ,
							 "CAMPO13" ,
							 "CAMPO14" ,
							 "CAMPO15" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Table_rpt_liquidacion_pss table_rpt_liquidacion_pss = new Table_rpt_liquidacion_pss() ;
					table_rpt_liquidacion_pss.setCampo1(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo2(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo3(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo4(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo5(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo6(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo7(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo8(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo9(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo10(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo11(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo12(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo13(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo14(cur.getString(j++));
					table_rpt_liquidacion_pss.setCampo15(cur.getString(j++));

					lista.add(table_rpt_liquidacion_pss); 
					i++; 
					if(i == limit){ 
						break; 
					} 
					cur.moveToNext(); 
				} 
				cur.close(); 
			} 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return lista; 
	} 
}