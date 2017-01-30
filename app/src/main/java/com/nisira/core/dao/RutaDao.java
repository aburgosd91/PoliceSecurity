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

public class RutaDao extends BaseDao<Ruta> {
	public RutaDao() {
		super(Ruta.class);
	}
	public RutaDao(boolean usaCnBase) throws Exception {
		super(Ruta.class, usaCnBase);
	}

	public Boolean insert(Ruta ruta) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDRUTA",ruta.getIdruta()); 
			initialValues.put("IDEMPRESA",ruta.getIdempresa()); 
			initialValues.put("NRORUTA",ruta.getNroruta()); 
			initialValues.put("DENOMINACIONRUTA",ruta.getDenominacionruta()); 
			initialValues.put("IDTIPORUTA",ruta.getIdtiporuta()); 
			initialValues.put("IDTERMINALORIGEN",ruta.getIdterminalorigen()); 
			initialValues.put("IDTERMINALDESTINO",ruta.getIdterminaldestino()); 
			initialValues.put("DISTANCIA",ruta.getDistancia()); 
			initialValues.put("DESCRIPCION",ruta.getDescripcion()); 
			initialValues.put("IDPRODUCTO",ruta.getIdproducto()); 
			initialValues.put("FECHACREACION",dateFormat.format(ruta.getFechacreacion() ) ); 
			initialValues.put("ESTADO",ruta.getEstado()); 
			initialValues.put("MAXPASAJERO",ruta.getMaxpasajero()); 
			initialValues.put("CICLOVUELO",ruta.getCiclovuelo()); 
			initialValues.put("RUTAMULTIPLE",ruta.getRutamultiple()); 
			initialValues.put("IDTIPOVENTA",ruta.getIdtipoventa()); 
			resultado = mDb.insert("RUTA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Ruta ruta,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDRUTA",ruta.getIdruta()) ; 
			initialValues.put("IDEMPRESA",ruta.getIdempresa()) ; 
			initialValues.put("NRORUTA",ruta.getNroruta()) ; 
			initialValues.put("DENOMINACIONRUTA",ruta.getDenominacionruta()) ; 
			initialValues.put("IDTIPORUTA",ruta.getIdtiporuta()) ; 
			initialValues.put("IDTERMINALORIGEN",ruta.getIdterminalorigen()) ; 
			initialValues.put("IDTERMINALDESTINO",ruta.getIdterminaldestino()) ; 
			initialValues.put("DISTANCIA",ruta.getDistancia()) ; 
			initialValues.put("DESCRIPCION",ruta.getDescripcion()) ; 
			initialValues.put("IDPRODUCTO",ruta.getIdproducto()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(ruta.getFechacreacion() ) ) ; 
			initialValues.put("ESTADO",ruta.getEstado()) ; 
			initialValues.put("MAXPASAJERO",ruta.getMaxpasajero()) ; 
			initialValues.put("CICLOVUELO",ruta.getCiclovuelo()) ; 
			initialValues.put("RUTAMULTIPLE",ruta.getRutamultiple()) ; 
			initialValues.put("IDTIPOVENTA",ruta.getIdtipoventa()) ; 
			resultado = mDb.update("RUTA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("RUTA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Ruta> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Ruta> lista  = new ArrayList<Ruta>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("RUTA",
					new String[] {
							 "IDRUTA" ,
							 "IDEMPRESA" ,
							 "NRORUTA" ,
							 "DENOMINACIONRUTA" ,
							 "IDTIPORUTA" ,
							 "IDTERMINALORIGEN" ,
							 "IDTERMINALDESTINO" ,
							 "DISTANCIA" ,
							 "DESCRIPCION" ,
							 "IDPRODUCTO" ,
							 "FECHACREACION" ,
							 "ESTADO" ,
							 "MAXPASAJERO" ,
							 "CICLOVUELO" ,
							 "RUTAMULTIPLE" ,
							 "IDTIPOVENTA" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Ruta ruta = new Ruta() ;
					ruta.setIdruta(cur.getInt(j++));
					ruta.setIdempresa(cur.getString(j++));
					ruta.setNroruta(cur.getString(j++));
					ruta.setDenominacionruta(cur.getString(j++));
					ruta.setIdtiporuta(cur.getInt(j++));
					ruta.setIdterminalorigen(cur.getInt(j++));
					ruta.setIdterminaldestino(cur.getInt(j++));
					ruta.setDistancia(cur.getDouble(j++));
					ruta.setDescripcion(cur.getString(j++));
					ruta.setIdproducto(cur.getString(j++));
					ruta.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					ruta.setEstado(cur.getDouble(j++));
					ruta.setMaxpasajero(cur.getDouble(j++));
					ruta.setCiclovuelo(cur.getInt(j++));
					ruta.setRutamultiple(cur.getInt(j++));
					ruta.setIdtipoventa(cur.getString(j++));

					lista.add(ruta); 
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