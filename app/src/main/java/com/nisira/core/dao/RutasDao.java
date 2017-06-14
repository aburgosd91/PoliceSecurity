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

public class RutasDao extends BaseDao<Rutas> {
	public RutasDao() {
		super(Rutas.class);
	}
	public RutasDao(boolean usaCnBase) throws Exception {
		super(Rutas.class, usaCnBase);
	}
	public void mezclarLocal(Rutas obj)throws Exception{
		List<Rutas> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDRUTA))=?",obj.getIdempresa().trim(),obj.getIdruta().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public Boolean insert(Rutas rutas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",rutas.getIdempresa()); 
			initialValues.put("IDRUTA",rutas.getIdruta()); 
			initialValues.put("DESCRIPCION",rutas.getDescripcion()); 
			initialValues.put("KILOMETROS",rutas.getKilometros()); 
			initialValues.put("PEAJE",rutas.getPeaje()); 
			initialValues.put("ESTADO",rutas.getEstado()); 
			initialValues.put("SINCRONIZA",rutas.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(rutas.getFechacreacion() ) ); 
			initialValues.put("VALORREF",rutas.getValorref()); 
			initialValues.put("FLETE",rutas.getFlete()); 
			initialValues.put("ORIGEN",rutas.getOrigen()); 
			initialValues.put("DESTINO",rutas.getDestino()); 
			initialValues.put("IDCONTRATOTRANS",rutas.getIdcontratotrans()); 
			initialValues.put("IDOPETRANS",rutas.getIdopetrans()); 
			initialValues.put("IDCLIEPROV",rutas.getIdclieprov()); 
			initialValues.put("KMVIRTUAL",rutas.getKmvirtual()); 
			initialValues.put("ORIGENALTERNO",rutas.getOrigenalterno()); 
			initialValues.put("DESTINOALTERNO",rutas.getDestinoalterno()); 
			initialValues.put("EXIGE_GUIA_CONFIRMACION",rutas.getExige_guia_confirmacion()); 
			resultado = mDb.insert("RUTAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Rutas rutas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",rutas.getIdempresa()) ; 
			initialValues.put("IDRUTA",rutas.getIdruta()) ; 
			initialValues.put("DESCRIPCION",rutas.getDescripcion()) ; 
			initialValues.put("KILOMETROS",rutas.getKilometros()) ; 
			initialValues.put("PEAJE",rutas.getPeaje()) ; 
			initialValues.put("ESTADO",rutas.getEstado()) ; 
			initialValues.put("SINCRONIZA",rutas.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(rutas.getFechacreacion() ) ) ; 
			initialValues.put("VALORREF",rutas.getValorref()) ; 
			initialValues.put("FLETE",rutas.getFlete()) ; 
			initialValues.put("ORIGEN",rutas.getOrigen()) ; 
			initialValues.put("DESTINO",rutas.getDestino()) ; 
			initialValues.put("IDCONTRATOTRANS",rutas.getIdcontratotrans()) ; 
			initialValues.put("IDOPETRANS",rutas.getIdopetrans()) ; 
			initialValues.put("IDCLIEPROV",rutas.getIdclieprov()) ; 
			initialValues.put("KMVIRTUAL",rutas.getKmvirtual()) ; 
			initialValues.put("ORIGENALTERNO",rutas.getOrigenalterno()) ; 
			initialValues.put("DESTINOALTERNO",rutas.getDestinoalterno()) ; 
			initialValues.put("EXIGE_GUIA_CONFIRMACION",rutas.getExige_guia_confirmacion()) ; 
			resultado = mDb.update("RUTAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("RUTAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Rutas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Rutas> lista  = new ArrayList<Rutas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("RUTAS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDRUTA" ,
							 "DESCRIPCION" ,
							 "KILOMETROS" ,
							 "PEAJE" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "VALORREF" ,
							 "FLETE" ,
							 "ORIGEN" ,
							 "DESTINO" ,
							 "IDCONTRATOTRANS" ,
							 "IDOPETRANS" ,
							 "IDCLIEPROV" ,
							 "KMVIRTUAL" ,
							 "ORIGENALTERNO" ,
							 "DESTINOALTERNO" ,
							 "EXIGE_GUIA_CONFIRMACION" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Rutas rutas = new Rutas() ;
					rutas.setIdempresa(cur.getString(j++));
					rutas.setIdruta(cur.getString(j++));
					rutas.setDescripcion(cur.getString(j++));
					rutas.setKilometros(cur.getDouble(j++));
					rutas.setPeaje(cur.getString(j++));
					rutas.setEstado(cur.getDouble(j++));
					rutas.setSincroniza(cur.getString(j++));
					rutas.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					rutas.setValorref(cur.getDouble(j++));
					rutas.setFlete(cur.getDouble(j++));
					rutas.setOrigen(cur.getString(j++));
					rutas.setDestino(cur.getString(j++));
					rutas.setIdcontratotrans(cur.getString(j++));
					rutas.setIdopetrans(cur.getString(j++));
					rutas.setIdclieprov(cur.getString(j++));
					rutas.setKmvirtual(cur.getDouble(j++));
					rutas.setOrigenalterno(cur.getString(j++));
					rutas.setDestinoalterno(cur.getString(j++));
					rutas.setExige_guia_confirmacion(cur.getDouble(j++));

					lista.add(rutas); 
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