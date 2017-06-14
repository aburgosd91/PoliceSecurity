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

public class SucursalesDao extends BaseDao<Sucursales> {
	public SucursalesDao() {
		super(Sucursales.class);
	}
	public SucursalesDao(boolean usaCnBase) throws Exception {
		super(Sucursales.class, usaCnBase);
	}
	public void mezclarLocal(Sucursales obj)throws Exception{
		List<Sucursales> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDSUCURSAL))=?",obj.getIdempresa().trim(),obj.getIdsucursal().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public Boolean insert(Sucursales sucursales) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",sucursales.getIdempresa()); 
			initialValues.put("IDSUCURSAL",sucursales.getIdsucursal()); 
			initialValues.put("DISTRIBUIR",sucursales.getDistribuir()); 
			initialValues.put("E_MAIL",sucursales.getE_mail()); 
			initialValues.put("DIRECCION",sucursales.getDireccion()); 
			initialValues.put("DESCRIPCION",sucursales.getDescripcion()); 
			initialValues.put("ESTADO",sucursales.getEstado()); 
			initialValues.put("SINCRONIZA",sucursales.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(sucursales.getFechacreacion() ) ); 
			initialValues.put("IDTIPOESTABLECIMIENTO",sucursales.getIdtipoestablecimiento()); 
			initialValues.put("CODESTABLECIMIENTO",sucursales.getCodestablecimiento()); 
			initialValues.put("DOMICILIOFISCAL",sucursales.getDomiciliofiscal()); 
			initialValues.put("IDCONDICIONESTABLECIMIENTO",sucursales.getIdcondicionestablecimiento()); 
			initialValues.put("IDVIA",sucursales.getIdvia()); 
			initialValues.put("NUMERO",sucursales.getNumero()); 
			initialValues.put("INTERIOR",sucursales.getInterior()); 
			initialValues.put("IDZONA",sucursales.getIdzona()); 
			initialValues.put("NOMBREZONA",sucursales.getNombrezona()); 
			initialValues.put("REFERENCIA",sucursales.getReferencia()); 
			initialValues.put("IDUBIGEO",sucursales.getIdubigeo()); 
			initialValues.put("ESPLANTA",sucursales.getEsplanta()); 
			initialValues.put("FCE",sucursales.getFce()); 
			initialValues.put("FDA",sucursales.getFda()); 
			initialValues.put("CODIGO_RTPS",sucursales.getCodigo_rtps()); 
			initialValues.put("TASA",sucursales.getTasa()); 
			initialValues.put("PLANTCODE",sucursales.getPlantcode()); 
			initialValues.put("IDCONTROL",sucursales.getIdcontrol()); 
			initialValues.put("ESPRODUCCIONPROPIA",sucursales.getEsproduccionpropia()); 
			initialValues.put("ESCENTRORIESGO",sucursales.getEscentroriesgo()); 
			initialValues.put("CTACTEMN",sucursales.getCtactemn()); 
			initialValues.put("CTACTEME",sucursales.getCtacteme()); 
			initialValues.put("CODALTERNO",sucursales.getCodalterno()); 
			initialValues.put("CC_CPF",sucursales.getCc_cpf()); 
			initialValues.put("DEPARTAMENTO",sucursales.getDepartamento()); 
			initialValues.put("DISTRITO",sucursales.getDistrito()); 
			initialValues.put("PROVINCIA",sucursales.getProvincia()); 
			initialValues.put("CODIGO_MTC",sucursales.getCodigo_mtc()); 
			initialValues.put("ESDESPACHO",sucursales.getEsdespacho()); 
			initialValues.put("GENERA_REQINTERNO",sucursales.getGenera_reqinterno()); 
			initialValues.put("IDCLIEPROV_DESTINO",sucursales.getIdclieprov_destino()); 
			initialValues.put("IDRESPONSABLE",sucursales.getIdresponsable()); 
			initialValues.put("IDSUCURSAL_SPRING",sucursales.getIdsucursal_spring()); 
			initialValues.put("ES_FUNDO",sucursales.getEs_fundo()); 
			initialValues.put("NOMBRE_CORTO",sucursales.getNombre_corto()); 
			resultado = mDb.insert("SUCURSALES",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Sucursales sucursales,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",sucursales.getIdempresa()) ; 
			initialValues.put("IDSUCURSAL",sucursales.getIdsucursal()) ; 
			initialValues.put("DISTRIBUIR",sucursales.getDistribuir()) ; 
			initialValues.put("E_MAIL",sucursales.getE_mail()) ; 
			initialValues.put("DIRECCION",sucursales.getDireccion()) ; 
			initialValues.put("DESCRIPCION",sucursales.getDescripcion()) ; 
			initialValues.put("ESTADO",sucursales.getEstado()) ; 
			initialValues.put("SINCRONIZA",sucursales.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(sucursales.getFechacreacion() ) ) ; 
			initialValues.put("IDTIPOESTABLECIMIENTO",sucursales.getIdtipoestablecimiento()) ; 
			initialValues.put("CODESTABLECIMIENTO",sucursales.getCodestablecimiento()) ; 
			initialValues.put("DOMICILIOFISCAL",sucursales.getDomiciliofiscal()) ; 
			initialValues.put("IDCONDICIONESTABLECIMIENTO",sucursales.getIdcondicionestablecimiento()) ; 
			initialValues.put("IDVIA",sucursales.getIdvia()) ; 
			initialValues.put("NUMERO",sucursales.getNumero()) ; 
			initialValues.put("INTERIOR",sucursales.getInterior()) ; 
			initialValues.put("IDZONA",sucursales.getIdzona()) ; 
			initialValues.put("NOMBREZONA",sucursales.getNombrezona()) ; 
			initialValues.put("REFERENCIA",sucursales.getReferencia()) ; 
			initialValues.put("IDUBIGEO",sucursales.getIdubigeo()) ; 
			initialValues.put("ESPLANTA",sucursales.getEsplanta()) ; 
			initialValues.put("FCE",sucursales.getFce()) ; 
			initialValues.put("FDA",sucursales.getFda()) ; 
			initialValues.put("CODIGO_RTPS",sucursales.getCodigo_rtps()) ; 
			initialValues.put("TASA",sucursales.getTasa()) ; 
			initialValues.put("PLANTCODE",sucursales.getPlantcode()) ; 
			initialValues.put("IDCONTROL",sucursales.getIdcontrol()) ; 
			initialValues.put("ESPRODUCCIONPROPIA",sucursales.getEsproduccionpropia()) ; 
			initialValues.put("ESCENTRORIESGO",sucursales.getEscentroriesgo()) ; 
			initialValues.put("CTACTEMN",sucursales.getCtactemn()) ; 
			initialValues.put("CTACTEME",sucursales.getCtacteme()) ; 
			initialValues.put("CODALTERNO",sucursales.getCodalterno()) ; 
			initialValues.put("CC_CPF",sucursales.getCc_cpf()) ; 
			initialValues.put("DEPARTAMENTO",sucursales.getDepartamento()) ; 
			initialValues.put("DISTRITO",sucursales.getDistrito()) ; 
			initialValues.put("PROVINCIA",sucursales.getProvincia()) ; 
			initialValues.put("CODIGO_MTC",sucursales.getCodigo_mtc()) ; 
			initialValues.put("ESDESPACHO",sucursales.getEsdespacho()) ; 
			initialValues.put("GENERA_REQINTERNO",sucursales.getGenera_reqinterno()) ; 
			initialValues.put("IDCLIEPROV_DESTINO",sucursales.getIdclieprov_destino()) ; 
			initialValues.put("IDRESPONSABLE",sucursales.getIdresponsable()) ; 
			initialValues.put("IDSUCURSAL_SPRING",sucursales.getIdsucursal_spring()) ; 
			initialValues.put("ES_FUNDO",sucursales.getEs_fundo()) ; 
			initialValues.put("NOMBRE_CORTO",sucursales.getNombre_corto()) ; 
			resultado = mDb.update("SUCURSALES",initialValues,where,null)>0; 
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
			resultado = mDb.delete("SUCURSALES",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Sucursales> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Sucursales> lista  = new ArrayList<Sucursales>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("SUCURSALES",
					new String[] {
							 "IDEMPRESA" ,
							 "IDSUCURSAL" ,
							 "DISTRIBUIR" ,
							 "E_MAIL" ,
							 "DIRECCION" ,
							 "DESCRIPCION" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "IDTIPOESTABLECIMIENTO" ,
							 "CODESTABLECIMIENTO" ,
							 "DOMICILIOFISCAL" ,
							 "IDCONDICIONESTABLECIMIENTO" ,
							 "IDVIA" ,
							 "NUMERO" ,
							 "INTERIOR" ,
							 "IDZONA" ,
							 "NOMBREZONA" ,
							 "REFERENCIA" ,
							 "IDUBIGEO" ,
							 "ESPLANTA" ,
							 "FCE" ,
							 "FDA" ,
							 "CODIGO_RTPS" ,
							 "TASA" ,
							 "PLANTCODE" ,
							 "IDCONTROL" ,
							 "ESPRODUCCIONPROPIA" ,
							 "ESCENTRORIESGO" ,
							 "CTACTEMN" ,
							 "CTACTEME" ,
							 "CODALTERNO" ,
							 "CC_CPF" ,
							 "DEPARTAMENTO" ,
							 "DISTRITO" ,
							 "PROVINCIA" ,
							 "CODIGO_MTC" ,
							 "ESDESPACHO" ,
							 "GENERA_REQINTERNO" ,
							 "IDCLIEPROV_DESTINO" ,
							 "IDRESPONSABLE" ,
							 "IDSUCURSAL_SPRING" ,
							 "ES_FUNDO" ,
							 "NOMBRE_CORTO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Sucursales sucursales = new Sucursales() ;
					sucursales.setIdempresa(cur.getString(j++));
					sucursales.setIdsucursal(cur.getString(j++));
					sucursales.setDistribuir(cur.getDouble(j++));
					sucursales.setE_mail(cur.getString(j++));
					sucursales.setDireccion(cur.getString(j++));
					sucursales.setDescripcion(cur.getString(j++));
					sucursales.setEstado(cur.getDouble(j++));
					sucursales.setSincroniza(cur.getString(j++));
					sucursales.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					sucursales.setIdtipoestablecimiento(cur.getString(j++));
					sucursales.setCodestablecimiento(cur.getString(j++));
					sucursales.setDomiciliofiscal(cur.getDouble(j++));
					sucursales.setIdcondicionestablecimiento(cur.getString(j++));
					sucursales.setIdvia(cur.getString(j++));
					sucursales.setNumero(cur.getDouble(j++));
					sucursales.setInterior(cur.getDouble(j++));
					sucursales.setIdzona(cur.getString(j++));
					sucursales.setNombrezona(cur.getString(j++));
					sucursales.setReferencia(cur.getString(j++));
					sucursales.setIdubigeo(cur.getString(j++));
					sucursales.setEsplanta(cur.getDouble(j++));
					sucursales.setFce(cur.getString(j++));
					sucursales.setFda(cur.getString(j++));
					sucursales.setCodigo_rtps(cur.getString(j++));
					sucursales.setTasa(cur.getDouble(j++));
					sucursales.setPlantcode(cur.getString(j++));
					sucursales.setIdcontrol(cur.getString(j++));
					sucursales.setEsproduccionpropia(cur.getDouble(j++));
					sucursales.setEscentroriesgo(cur.getDouble(j++));
					sucursales.setCtactemn(cur.getString(j++));
					sucursales.setCtacteme(cur.getString(j++));
					sucursales.setCodalterno(cur.getString(j++));
					sucursales.setCc_cpf(cur.getString(j++));
					sucursales.setDepartamento(cur.getString(j++));
					sucursales.setDistrito(cur.getString(j++));
					sucursales.setProvincia(cur.getString(j++));
					sucursales.setCodigo_mtc(cur.getString(j++));
					sucursales.setEsdespacho(cur.getDouble(j++));
					sucursales.setGenera_reqinterno(cur.getDouble(j++));
					sucursales.setIdclieprov_destino(cur.getString(j++));
					sucursales.setIdresponsable(cur.getString(j++));
					sucursales.setIdsucursal_spring(cur.getString(j++));
					sucursales.setEs_fundo(cur.getDouble(j++));
					sucursales.setNombre_corto(cur.getString(j++));

					lista.add(sucursales); 
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