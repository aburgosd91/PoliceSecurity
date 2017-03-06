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

public class MotivosproduccionDao extends BaseDao<Motivosproduccion> {
	public MotivosproduccionDao() {
		super(Motivosproduccion.class);
	}
	public MotivosproduccionDao(boolean usaCnBase) throws Exception {
		super(Motivosproduccion.class, usaCnBase);
	}

	public Boolean insert(Motivosproduccion motivosproduccion) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",motivosproduccion.getIdempresa()); 
			initialValues.put("IDMOTIVO",motivosproduccion.getIdmotivo()); 
			initialValues.put("DESCRIPCION",motivosproduccion.getDescripcion()); 
			initialValues.put("NOMBRE_CORTO",motivosproduccion.getNombre_corto()); 
			initialValues.put("EXIGE_OCC",motivosproduccion.getExige_occ()); 
			initialValues.put("INSUMOS_OCC",motivosproduccion.getInsumos_occ()); 
			initialValues.put("GENERA_INGRESO",motivosproduccion.getGenera_ingreso()); 
			initialValues.put("ESTADO",motivosproduccion.getEstado()); 
			initialValues.put("SINCRONIZA",motivosproduccion.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(motivosproduccion.getFechacreacion() ) ); 
			initialValues.put("IDMOTSALIDA",motivosproduccion.getIdmotsalida()); 
			initialValues.put("IPIDECOTIZACION",motivosproduccion.getIpidecotizacion()); 
			initialValues.put("IPIDESOLICITUD",motivosproduccion.getIpidesolicitud()); 
			initialValues.put("ES_PREVENTIVO",motivosproduccion.getEs_preventivo()); 
			initialValues.put("EXIGE_REQI",motivosproduccion.getExige_reqi()); 
			initialValues.put("NO_EXIGE_EQP",motivosproduccion.getNo_exige_eqp()); 
			initialValues.put("NO_EXIGE_OPM",motivosproduccion.getNo_exige_opm()); 
			initialValues.put("IDDOCUMENTO_S",motivosproduccion.getIddocumento_s()); 
			initialValues.put("IDMOTIVO_S",motivosproduccion.getIdmotivo_s()); 
			initialValues.put("IDSUCURSAL_S",motivosproduccion.getIdsucursal_s()); 
			initialValues.put("IDALMACEN_S",motivosproduccion.getIdalmacen_s()); 
			initialValues.put("IDDOCUMENTO_I",motivosproduccion.getIddocumento_i()); 
			initialValues.put("IDMOTIVO_I",motivosproduccion.getIdmotivo_i()); 
			initialValues.put("IDSUCURSAL_I",motivosproduccion.getIdsucursal_i()); 
			initialValues.put("IDALMACEN_I",motivosproduccion.getIdalmacen_i()); 
			initialValues.put("ALMACEN_AUTO",motivosproduccion.getAlmacen_auto()); 
			initialValues.put("SERIE_I",motivosproduccion.getSerie_i()); 
			initialValues.put("SERIE_S",motivosproduccion.getSerie_s()); 
			initialValues.put("SUCURSAL_CC",motivosproduccion.getSucursal_cc()); 
			initialValues.put("IDCONSUMIDOR",motivosproduccion.getIdconsumidor()); 
			initialValues.put("IDDOCUMENTO_OP",motivosproduccion.getIddocumento_op()); 
			initialValues.put("DIAS",motivosproduccion.getDias()); 
			initialValues.put("IDDOCUMENTO",motivosproduccion.getIddocumento()); 
			initialValues.put("SERIE",motivosproduccion.getSerie()); 
			initialValues.put("ES_PREDICTIVO",motivosproduccion.getEs_predictivo()); 
			initialValues.put("IDMOTIVOREQINTERNO",motivosproduccion.getIdmotivoreqinterno()); 
			initialValues.put("ES_COTIZACION",motivosproduccion.getEs_cotizacion()); 
			initialValues.put("ES_REQUERIMIENTO",motivosproduccion.getEs_requerimiento()); 
			initialValues.put("ES_INGPERSONAL",motivosproduccion.getEs_ingpersonal()); 
			resultado = mDb.insert("MOTIVOSPRODUCCION",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Motivosproduccion motivosproduccion,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",motivosproduccion.getIdempresa()) ; 
			initialValues.put("IDMOTIVO",motivosproduccion.getIdmotivo()) ; 
			initialValues.put("DESCRIPCION",motivosproduccion.getDescripcion()) ; 
			initialValues.put("NOMBRE_CORTO",motivosproduccion.getNombre_corto()) ; 
			initialValues.put("EXIGE_OCC",motivosproduccion.getExige_occ()) ; 
			initialValues.put("INSUMOS_OCC",motivosproduccion.getInsumos_occ()) ; 
			initialValues.put("GENERA_INGRESO",motivosproduccion.getGenera_ingreso()) ; 
			initialValues.put("ESTADO",motivosproduccion.getEstado()) ; 
			initialValues.put("SINCRONIZA",motivosproduccion.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(motivosproduccion.getFechacreacion() ) ) ; 
			initialValues.put("IDMOTSALIDA",motivosproduccion.getIdmotsalida()) ; 
			initialValues.put("IPIDECOTIZACION",motivosproduccion.getIpidecotizacion()) ; 
			initialValues.put("IPIDESOLICITUD",motivosproduccion.getIpidesolicitud()) ; 
			initialValues.put("ES_PREVENTIVO",motivosproduccion.getEs_preventivo()) ; 
			initialValues.put("EXIGE_REQI",motivosproduccion.getExige_reqi()) ; 
			initialValues.put("NO_EXIGE_EQP",motivosproduccion.getNo_exige_eqp()) ; 
			initialValues.put("NO_EXIGE_OPM",motivosproduccion.getNo_exige_opm()) ; 
			initialValues.put("IDDOCUMENTO_S",motivosproduccion.getIddocumento_s()) ; 
			initialValues.put("IDMOTIVO_S",motivosproduccion.getIdmotivo_s()) ; 
			initialValues.put("IDSUCURSAL_S",motivosproduccion.getIdsucursal_s()) ; 
			initialValues.put("IDALMACEN_S",motivosproduccion.getIdalmacen_s()) ; 
			initialValues.put("IDDOCUMENTO_I",motivosproduccion.getIddocumento_i()) ; 
			initialValues.put("IDMOTIVO_I",motivosproduccion.getIdmotivo_i()) ; 
			initialValues.put("IDSUCURSAL_I",motivosproduccion.getIdsucursal_i()) ; 
			initialValues.put("IDALMACEN_I",motivosproduccion.getIdalmacen_i()) ; 
			initialValues.put("ALMACEN_AUTO",motivosproduccion.getAlmacen_auto()) ; 
			initialValues.put("SERIE_I",motivosproduccion.getSerie_i()) ; 
			initialValues.put("SERIE_S",motivosproduccion.getSerie_s()) ; 
			initialValues.put("SUCURSAL_CC",motivosproduccion.getSucursal_cc()) ; 
			initialValues.put("IDCONSUMIDOR",motivosproduccion.getIdconsumidor()) ; 
			initialValues.put("IDDOCUMENTO_OP",motivosproduccion.getIddocumento_op()) ; 
			initialValues.put("DIAS",motivosproduccion.getDias()) ; 
			initialValues.put("IDDOCUMENTO",motivosproduccion.getIddocumento()) ; 
			initialValues.put("SERIE",motivosproduccion.getSerie()) ; 
			initialValues.put("ES_PREDICTIVO",motivosproduccion.getEs_predictivo()) ; 
			initialValues.put("IDMOTIVOREQINTERNO",motivosproduccion.getIdmotivoreqinterno()) ; 
			initialValues.put("ES_COTIZACION",motivosproduccion.getEs_cotizacion()) ; 
			initialValues.put("ES_REQUERIMIENTO",motivosproduccion.getEs_requerimiento()) ; 
			initialValues.put("ES_INGPERSONAL",motivosproduccion.getEs_ingpersonal()) ; 
			resultado = mDb.update("MOTIVOSPRODUCCION",initialValues,where,null)>0; 
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
			resultado = mDb.delete("MOTIVOSPRODUCCION",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Motivosproduccion> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Motivosproduccion> lista  = new ArrayList<Motivosproduccion>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("MOTIVOSPRODUCCION",
					new String[] {
							 "IDEMPRESA" ,
							 "IDMOTIVO" ,
							 "DESCRIPCION" ,
							 "NOMBRE_CORTO" ,
							 "EXIGE_OCC" ,
							 "INSUMOS_OCC" ,
							 "GENERA_INGRESO" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "IDMOTSALIDA" ,
							 "IPIDECOTIZACION" ,
							 "IPIDESOLICITUD" ,
							 "ES_PREVENTIVO" ,
							 "EXIGE_REQI" ,
							 "NO_EXIGE_EQP" ,
							 "NO_EXIGE_OPM" ,
							 "IDDOCUMENTO_S" ,
							 "IDMOTIVO_S" ,
							 "IDSUCURSAL_S" ,
							 "IDALMACEN_S" ,
							 "IDDOCUMENTO_I" ,
							 "IDMOTIVO_I" ,
							 "IDSUCURSAL_I" ,
							 "IDALMACEN_I" ,
							 "ALMACEN_AUTO" ,
							 "SERIE_I" ,
							 "SERIE_S" ,
							 "SUCURSAL_CC" ,
							 "IDCONSUMIDOR" ,
							 "IDDOCUMENTO_OP" ,
							 "DIAS" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "ES_PREDICTIVO" ,
							 "IDMOTIVOREQINTERNO" ,
							 "ES_COTIZACION" ,
							 "ES_REQUERIMIENTO" ,
							 "ES_INGPERSONAL" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Motivosproduccion motivosproduccion = new Motivosproduccion() ;
					motivosproduccion.setIdempresa(cur.getString(j++));
					motivosproduccion.setIdmotivo(cur.getString(j++));
					motivosproduccion.setDescripcion(cur.getString(j++));
					motivosproduccion.setNombre_corto(cur.getString(j++));
					motivosproduccion.setExige_occ(cur.getDouble(j++));
					motivosproduccion.setInsumos_occ(cur.getDouble(j++));
					motivosproduccion.setGenera_ingreso(cur.getDouble(j++));
					motivosproduccion.setEstado(cur.getDouble(j++));
					motivosproduccion.setSincroniza(cur.getString(j++));
					motivosproduccion.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					motivosproduccion.setIdmotsalida(cur.getString(j++));
					motivosproduccion.setIpidecotizacion(cur.getInt(j++));
					motivosproduccion.setIpidesolicitud(cur.getInt(j++));
					motivosproduccion.setEs_preventivo(cur.getDouble(j++));
					motivosproduccion.setExige_reqi(cur.getDouble(j++));
					motivosproduccion.setNo_exige_eqp(cur.getDouble(j++));
					motivosproduccion.setNo_exige_opm(cur.getDouble(j++));
					motivosproduccion.setIddocumento_s(cur.getString(j++));
					motivosproduccion.setIdmotivo_s(cur.getString(j++));
					motivosproduccion.setIdsucursal_s(cur.getString(j++));
					motivosproduccion.setIdalmacen_s(cur.getString(j++));
					motivosproduccion.setIddocumento_i(cur.getString(j++));
					motivosproduccion.setIdmotivo_i(cur.getString(j++));
					motivosproduccion.setIdsucursal_i(cur.getString(j++));
					motivosproduccion.setIdalmacen_i(cur.getString(j++));
					motivosproduccion.setAlmacen_auto(cur.getDouble(j++));
					motivosproduccion.setSerie_i(cur.getString(j++));
					motivosproduccion.setSerie_s(cur.getString(j++));
					motivosproduccion.setSucursal_cc(cur.getDouble(j++));
					motivosproduccion.setIdconsumidor(cur.getString(j++));
					motivosproduccion.setIddocumento_op(cur.getString(j++));
					motivosproduccion.setDias(cur.getInt(j++));
					motivosproduccion.setIddocumento(cur.getString(j++));
					motivosproduccion.setSerie(cur.getString(j++));
					motivosproduccion.setEs_predictivo(cur.getDouble(j++));
					motivosproduccion.setIdmotivoreqinterno(cur.getString(j++));
					motivosproduccion.setEs_cotizacion(cur.getDouble(j++));
					motivosproduccion.setEs_requerimiento(cur.getDouble(j++));
					motivosproduccion.setEs_ingpersonal(cur.getDouble(j++));

					lista.add(motivosproduccion); 
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