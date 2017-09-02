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
			/**ProductosDao productosDao = new ProductosDao();
			int i = 0;
			for(Dordenserviciocliente x:dordenservicioclientes){
				List<Productos> lst = productosDao.listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDPRODUCTO))=?", x.getIdempresa().trim(), x.getIdservicio().trim());
				if(!lst.isEmpty()){
					x.setDescripcion_servicio(lst.get(0).getDescripcion());
					dordenservicioclientes.set(i,x);
				}
				i++;
			}
			ConsumidorDao consumidorDao = new ConsumidorDao();
			i = 0;
			for(Dordenserviciocliente x:dordenservicioclientes){
				List<Consumidor> lst = consumidorDao.listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCONSUMIDOR))=?", x.getIdempresa().trim(), x.getIdvehiculo().trim());
				if(!lst.isEmpty()){
					x.setDescripcion_vehiculo(lst.get(0).getDescripcion());
					dordenservicioclientes.set(i,x);
				}
				i++;
			}**/
			return dordenservicioclientes;
		}
		return null;
	}



	public Boolean insert(Dordenserviciocliente dordenserviciocliente) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dordenserviciocliente.getIdempresa()); 
			initialValues.put("IDORDENSERVICIO",dordenserviciocliente.getIdordenservicio()); 
			initialValues.put("ITEM",dordenserviciocliente.getItem()); 
			initialValues.put("IDVEHICULO",dordenserviciocliente.getIdvehiculo()); 
			initialValues.put("PLACA_CLIENTE",dordenserviciocliente.getPlaca_cliente()); 
			initialValues.put("HORA_REQ",dordenserviciocliente.getHora_req()); 
			initialValues.put("FECHA_FIN_SERVICIO",dateFormat.format(dordenserviciocliente.getFecha_fin_servicio() ) ); 
			initialValues.put("FECHACREACION",dateFormat.format(dordenserviciocliente.getFechacreacion() ) ); 
			initialValues.put("IDREFERENCIA",dordenserviciocliente.getIdreferencia()); 
			initialValues.put("ITEMREFERENCIA",dordenserviciocliente.getItemreferencia()); 
			initialValues.put("IDSERVICIO",dordenserviciocliente.getIdservicio()); 
			initialValues.put("CONDUCTOR_CLIENTE",dordenserviciocliente.getConductor_cliente()); 
			initialValues.put("GLOSA",dordenserviciocliente.getGlosa()); 
			initialValues.put("HORA_RC",dordenserviciocliente.getHora_rc()); 
			initialValues.put("CODOPERACIONES",dordenserviciocliente.getCodoperaciones()); 
			initialValues.put("IDRUTA_EC",dordenserviciocliente.getIdruta_ec());
			//initialValues.put("IDCONSUMIDOR",dordenserviciocliente.getIdconsumidor());
			initialValues.put("DESCRIPCION_VEHICULO",dordenserviciocliente.getDescripcion_vehiculo());
			initialValues.put("DESCRIPCION_SERVICIO", dordenserviciocliente.getDescripcion_servicio());
			resultado = mDb.insert("DORDENSERVICIOCLIENTE",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dordenserviciocliente dordenserviciocliente,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dordenserviciocliente.getIdempresa()) ; 
			initialValues.put("IDORDENSERVICIO",dordenserviciocliente.getIdordenservicio()) ; 
			initialValues.put("ITEM",dordenserviciocliente.getItem()) ; 
			initialValues.put("IDVEHICULO",dordenserviciocliente.getIdvehiculo()) ; 
			initialValues.put("PLACA_CLIENTE",dordenserviciocliente.getPlaca_cliente()) ; 
			initialValues.put("HORA_REQ",dordenserviciocliente.getHora_req()) ; 
			initialValues.put("FECHA_FIN_SERVICIO",dateFormat.format(dordenserviciocliente.getFecha_fin_servicio() ) ) ; 
			initialValues.put("FECHACREACION",dateFormat.format(dordenserviciocliente.getFechacreacion() ) ) ; 
			initialValues.put("IDREFERENCIA",dordenserviciocliente.getIdreferencia()) ; 
			initialValues.put("ITEMREFERENCIA",dordenserviciocliente.getItemreferencia()) ; 
			initialValues.put("IDSERVICIO",dordenserviciocliente.getIdservicio()) ; 
			initialValues.put("CONDUCTOR_CLIENTE",dordenserviciocliente.getConductor_cliente()) ; 
			initialValues.put("GLOSA",dordenserviciocliente.getGlosa()) ; 
			initialValues.put("HORA_RC",dordenserviciocliente.getHora_rc()) ; 
			initialValues.put("CODOPERACIONES",dordenserviciocliente.getCodoperaciones()) ; 
			initialValues.put("IDRUTA_EC",dordenserviciocliente.getIdruta_ec()) ;
			//initialValues.put("IDCOSUMIDOR",dordenserviciocliente.getIdconsumidor());
			initialValues.put("DESCRIPCION_VEHICULO",dordenserviciocliente.getDescripcion_vehiculo());
			initialValues.put("DESCRIPCION_SERVICIO",dordenserviciocliente.getDescripcion_servicio());
			resultado = mDb.update("DORDENSERVICIOCLIENTE",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DORDENSERVICIOCLIENTE",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Dordenserviciocliente> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Dordenserviciocliente> lista  = new ArrayList<Dordenserviciocliente>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DORDENSERVICIOCLIENTE",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDENSERVICIO" ,
							 "ITEM" ,
							 "IDVEHICULO" ,
							 "PLACA_CLIENTE" ,
							 "HORA_REQ" ,
							 "FECHA_FIN_SERVICIO" ,
							 "FECHACREACION" ,
							 "IDREFERENCIA" ,
							 "ITEMREFERENCIA" ,
							 "IDSERVICIO" ,
							 "CONDUCTOR_CLIENTE" ,
							 "GLOSA" ,
							 "HORA_RC" ,
							 "CODOPERACIONES" ,
							 "IDRUTA_EC",
							 //"IDCONSUMIDOR",
							 "DESCRIPCION_VEHICULO",
							 "DESCRIPCION_SERVICIO"
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Dordenserviciocliente dordenserviciocliente = new Dordenserviciocliente() ;
					dordenserviciocliente.setIdempresa(cur.getString(j++));
					dordenserviciocliente.setIdordenservicio(cur.getString(j++));
					dordenserviciocliente.setItem(cur.getString(j++));
					dordenserviciocliente.setIdvehiculo(cur.getString(j++));
					dordenserviciocliente.setPlaca_cliente(cur.getString(j++));
					dordenserviciocliente.setHora_req(cur.getDouble(j++));
					dordenserviciocliente.setFecha_fin_servicio(dateFormat.parse(cur.getString(j++)) );
					dordenserviciocliente.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					dordenserviciocliente.setIdreferencia(cur.getString(j++));
					dordenserviciocliente.setItemreferencia(cur.getString(j++));
					dordenserviciocliente.setIdservicio(cur.getString(j++));
					dordenserviciocliente.setConductor_cliente(cur.getString(j++));
					dordenserviciocliente.setGlosa(cur.getString(j++));
					dordenserviciocliente.setHora_rc(cur.getDouble(j++));
					dordenserviciocliente.setCodoperaciones(cur.getString(j++));
					dordenserviciocliente.setIdruta_ec(cur.getString(j++));
					//dordenserviciocliente.setIdconsumidor(cur.getString(j++));
					dordenserviciocliente.setDescripcion_vehiculo(cur.getString(j++));
					dordenserviciocliente.setDescripcion_servicio(cur.getString(j++));

					lista.add(dordenserviciocliente); 
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