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

public class NisiraDao extends BaseDao<Nisira> {
	public NisiraDao() {
		super(Nisira.class);
	}
	public NisiraDao(boolean usaCnBase) throws Exception {
		super(Nisira.class, usaCnBase);
	}

	public Boolean insert(Nisira nisira) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("A",nisira.getA()); 
			initialValues.put("B",nisira.getB()); 
			initialValues.put("C",nisira.getC()); 
			initialValues.put("D",nisira.getD()); 
			initialValues.put("E",nisira.getE()); 
			initialValues.put("F",nisira.getF()); 
			initialValues.put("G",nisira.getG()); 
			initialValues.put("H",nisira.getH()); 
			initialValues.put("I",nisira.getI()); 
			initialValues.put("J",nisira.getJ()); 
			initialValues.put("K",nisira.getK()); 
			initialValues.put("L",nisira.getL()); 
			initialValues.put("M",nisira.getM()); 
			initialValues.put("N",nisira.getN()); 
			initialValues.put("O",nisira.getO()); 
			initialValues.put("P",nisira.getP()); 
			initialValues.put("Q",nisira.getQ()); 
			initialValues.put("R",nisira.getR()); 
			initialValues.put("S",nisira.getS()); 
			initialValues.put("T",nisira.getT()); 
			initialValues.put("U",nisira.getU()); 
			initialValues.put("V",nisira.getV()); 
			initialValues.put("W",nisira.getW()); 
			initialValues.put("X",nisira.getX()); 
			initialValues.put("Y",nisira.getY()); 
			initialValues.put("Z",nisira.getZ()); 
			initialValues.put("AA",nisira.getAa()); 
			initialValues.put("AB",nisira.getAb()); 
			resultado = mDb.insert("NISIRA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Nisira nisira,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("A",nisira.getA()) ; 
			initialValues.put("B",nisira.getB()) ; 
			initialValues.put("C",nisira.getC()) ; 
			initialValues.put("D",nisira.getD()) ; 
			initialValues.put("E",nisira.getE()) ; 
			initialValues.put("F",nisira.getF()) ; 
			initialValues.put("G",nisira.getG()) ; 
			initialValues.put("H",nisira.getH()) ; 
			initialValues.put("I",nisira.getI()) ; 
			initialValues.put("J",nisira.getJ()) ; 
			initialValues.put("K",nisira.getK()) ; 
			initialValues.put("L",nisira.getL()) ; 
			initialValues.put("M",nisira.getM()) ; 
			initialValues.put("N",nisira.getN()) ; 
			initialValues.put("O",nisira.getO()) ; 
			initialValues.put("P",nisira.getP()) ; 
			initialValues.put("Q",nisira.getQ()) ; 
			initialValues.put("R",nisira.getR()) ; 
			initialValues.put("S",nisira.getS()) ; 
			initialValues.put("T",nisira.getT()) ; 
			initialValues.put("U",nisira.getU()) ; 
			initialValues.put("V",nisira.getV()) ; 
			initialValues.put("W",nisira.getW()) ; 
			initialValues.put("X",nisira.getX()) ; 
			initialValues.put("Y",nisira.getY()) ; 
			initialValues.put("Z",nisira.getZ()) ; 
			initialValues.put("AA",nisira.getAa()) ; 
			initialValues.put("AB",nisira.getAb()) ; 
			resultado = mDb.update("NISIRA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("NISIRA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Nisira> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Nisira> lista  = new ArrayList<Nisira>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("NISIRA",
					new String[] {
							 "A" ,
							 "B" ,
							 "C" ,
							 "D" ,
							 "E" ,
							 "F" ,
							 "G" ,
							 "H" ,
							 "I" ,
							 "J" ,
							 "K" ,
							 "L" ,
							 "M" ,
							 "N" ,
							 "O" ,
							 "P" ,
							 "Q" ,
							 "R" ,
							 "S" ,
							 "T" ,
							 "U" ,
							 "V" ,
							 "W" ,
							 "X" ,
							 "Y" ,
							 "Z" ,
							 "AA" ,
							 "AB" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Nisira nisira = new Nisira() ;
					nisira.setA(cur.getString(j++));
					nisira.setB(cur.getString(j++));
					nisira.setC(cur.getString(j++));
					nisira.setD(cur.getString(j++));
					nisira.setE(cur.getString(j++));
					nisira.setF(cur.getString(j++));
					nisira.setG(cur.getString(j++));
					nisira.setH(cur.getString(j++));
					nisira.setI(cur.getString(j++));
					nisira.setJ(cur.getString(j++));
					nisira.setK(cur.getString(j++));
					nisira.setL(cur.getString(j++));
					nisira.setM(cur.getString(j++));
					nisira.setN(cur.getString(j++));
					nisira.setO(cur.getString(j++));
					nisira.setP(cur.getString(j++));
					nisira.setQ(cur.getString(j++));
					nisira.setR(cur.getString(j++));
					nisira.setS(cur.getString(j++));
					nisira.setT(cur.getString(j++));
					nisira.setU(cur.getString(j++));
					nisira.setV(cur.getString(j++));
					nisira.setW(cur.getString(j++));
					nisira.setX(cur.getString(j++));
					nisira.setY(cur.getString(j++));
					nisira.setZ(cur.getString(j++));
					nisira.setAa(cur.getString(j++));
					nisira.setAb(cur.getString(j++));

					lista.add(nisira); 
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