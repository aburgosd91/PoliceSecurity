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

public class PempresaDao extends BaseDao<Pempresa> {
	public PempresaDao() {
		super(Pempresa.class);
	}
	public PempresaDao(boolean usaCnBase) throws Exception {
		super(Pempresa.class, usaCnBase);
	}

	public Boolean insert(Pempresa pempresa) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",pempresa.getIdempresa()); 
			initialValues.put("TIPOPARAMETRO",pempresa.getTipoparametro()); 
			initialValues.put("PARAMETRO",pempresa.getParametro()); 
			initialValues.put("VALOR",pempresa.getValor()); 
			initialValues.put("DESCRIPCION",pempresa.getDescripcion()); 
			initialValues.put("POSICION",pempresa.getPosicion()); 
			initialValues.put("ESTADO",pempresa.getEstado()); 
			initialValues.put("MODULO",pempresa.getModulo()); 
			initialValues.put("DATOSCOMBO",pempresa.getDatoscombo()); 
			initialValues.put("TIPOVALOR",pempresa.getTipovalor()); 
			initialValues.put("DESCCORTA",pempresa.getDesccorta()); 
			initialValues.put("DESCLARGA",pempresa.getDesclarga()); 
			initialValues.put("VALORXDEFECTO",pempresa.getValorxdefecto()); 
			initialValues.put("FECHACREACION",dateFormat.format(pempresa.getFechacreacion() ) ); 
			initialValues.put("IDBASEDATOS",pempresa.getIdbasedatos()); 
			initialValues.put("VALORLARGO",pempresa.getValorlargo()); 
			resultado = mDb.insert("PEMPRESA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Pempresa pempresa,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",pempresa.getIdempresa()) ; 
			initialValues.put("TIPOPARAMETRO",pempresa.getTipoparametro()) ; 
			initialValues.put("PARAMETRO",pempresa.getParametro()) ; 
			initialValues.put("VALOR",pempresa.getValor()) ; 
			initialValues.put("DESCRIPCION",pempresa.getDescripcion()) ; 
			initialValues.put("POSICION",pempresa.getPosicion()) ; 
			initialValues.put("ESTADO",pempresa.getEstado()) ; 
			initialValues.put("MODULO",pempresa.getModulo()) ; 
			initialValues.put("DATOSCOMBO",pempresa.getDatoscombo()) ; 
			initialValues.put("TIPOVALOR",pempresa.getTipovalor()) ; 
			initialValues.put("DESCCORTA",pempresa.getDesccorta()) ; 
			initialValues.put("DESCLARGA",pempresa.getDesclarga()) ; 
			initialValues.put("VALORXDEFECTO",pempresa.getValorxdefecto()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(pempresa.getFechacreacion() ) ) ; 
			initialValues.put("IDBASEDATOS",pempresa.getIdbasedatos()) ; 
			initialValues.put("VALORLARGO",pempresa.getValorlargo()) ; 
			resultado = mDb.update("PEMPRESA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PEMPRESA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Pempresa> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Pempresa> lista  = new ArrayList<Pempresa>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PEMPRESA",
					new String[] {
							 "IDEMPRESA" ,
							 "TIPOPARAMETRO" ,
							 "PARAMETRO" ,
							 "VALOR" ,
							 "DESCRIPCION" ,
							 "POSICION" ,
							 "ESTADO" ,
							 "MODULO" ,
							 "DATOSCOMBO" ,
							 "TIPOVALOR" ,
							 "DESCCORTA" ,
							 "DESCLARGA" ,
							 "VALORXDEFECTO" ,
							 "FECHACREACION" ,
							 "IDBASEDATOS" ,
							 "VALORLARGO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Pempresa pempresa = new Pempresa() ;
					pempresa.setIdempresa(cur.getString(j++));
					pempresa.setTipoparametro(cur.getString(j++));
					pempresa.setParametro(cur.getString(j++));
					pempresa.setValor(cur.getString(j++));
					pempresa.setDescripcion(cur.getString(j++));
					pempresa.setPosicion(cur.getString(j++));
					pempresa.setEstado(cur.getDouble(j++));
					pempresa.setModulo(cur.getString(j++));
					pempresa.setDatoscombo(cur.getString(j++));
					pempresa.setTipovalor(cur.getString(j++));
					pempresa.setDesccorta(cur.getString(j++));
					pempresa.setDesclarga(cur.getString(j++));
					pempresa.setValorxdefecto(cur.getString(j++));
					pempresa.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					pempresa.setIdbasedatos(cur.getString(j++));
					pempresa.setValorlargo(cur.getString(j++));

					lista.add(pempresa); 
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