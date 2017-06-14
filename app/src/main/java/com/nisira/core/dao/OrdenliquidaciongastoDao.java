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

public class OrdenliquidaciongastoDao extends BaseDao<Ordenliquidaciongasto> {
	public OrdenliquidaciongastoDao() {
		super(Ordenliquidaciongasto.class);
	}
	public OrdenliquidaciongastoDao(boolean usaCnBase) throws Exception {
		super(Ordenliquidaciongasto.class, usaCnBase);
	}
	public void mezclarLocal(Ordenliquidaciongasto obj)throws Exception{
		if(obj !=null){
			List<Ordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=?",obj.getIdempresa().trim(),obj.getIdorden().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Ordenliquidaciongasto> ListarxUsuario(String IDUSUARIO)throws Exception{

		List<Ordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDCLIEPROV)) =?",IDUSUARIO.trim());
		return lst;

	}
	public List<Ordenliquidaciongasto> listOrdenLiquidacionxClienteFiltro(String IDUSUARIO,String RAZONSOCIAL)throws Exception{
		List<Ordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDCLIEPROV)) =? AND t0.RAZONSOCIAL like '%'||?||'%' ",IDUSUARIO.trim(),RAZONSOCIAL.trim());
		return lst;
	}
	public Boolean insert(Ordenliquidaciongasto ordenliquidaciongasto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",ordenliquidaciongasto.getIdempresa()); 
			initialValues.put("IDORDEN",ordenliquidaciongasto.getIdorden()); 
			initialValues.put("IDEMISOR",ordenliquidaciongasto.getIdemisor()); 
			initialValues.put("PERIODO",ordenliquidaciongasto.getPeriodo()); 
			initialValues.put("FECHAREGISTRO",dateFormat.format(ordenliquidaciongasto.getFecharegistro() ) ); 
			initialValues.put("IDSUCURSAL",ordenliquidaciongasto.getIdsucursal()); 
			initialValues.put("IDDOCUMENTO",ordenliquidaciongasto.getIddocumento()); 
			initialValues.put("SERIE",ordenliquidaciongasto.getSerie()); 
			initialValues.put("NUMERO",ordenliquidaciongasto.getNumero()); 
			initialValues.put("FECHA",dateFormat.format(ordenliquidaciongasto.getFecha() ) ); 
			initialValues.put("TCAMBIO",ordenliquidaciongasto.getTcambio()); 
			initialValues.put("IDCLIEPROV",ordenliquidaciongasto.getIdclieprov()); 
			initialValues.put("DIRECCION",ordenliquidaciongasto.getDireccion()); 
			initialValues.put("RUC",ordenliquidaciongasto.getRuc()); 
			initialValues.put("RAZONSOCIAL",ordenliquidaciongasto.getRazonsocial()); 
			initialValues.put("IDREGIMEN",ordenliquidaciongasto.getIdregimen()); 
			initialValues.put("IDMONEDA",ordenliquidaciongasto.getIdmoneda()); 
			initialValues.put("TCMONEDA",ordenliquidaciongasto.getTcmoneda()); 
			initialValues.put("IDTIPOMOV",ordenliquidaciongasto.getIdtipomov()); 
			initialValues.put("IDFPAGO",ordenliquidaciongasto.getIdfpago()); 
			initialValues.put("IDAREA",ordenliquidaciongasto.getIdarea()); 
			initialValues.put("GLOSA",ordenliquidaciongasto.getGlosa()); 
			initialValues.put("VVENTA",ordenliquidaciongasto.getVventa()); 
			initialValues.put("INAFECTO",ordenliquidaciongasto.getInafecto()); 
			initialValues.put("OTROS",ordenliquidaciongasto.getOtros()); 
			initialValues.put("IMPUESTO",ordenliquidaciongasto.getImpuesto()); 
			initialValues.put("PIMPUESTO",ordenliquidaciongasto.getPimpuesto()); 
			initialValues.put("DESCUENTO",ordenliquidaciongasto.getDescuento()); 
			initialValues.put("PDESCUENTO",ordenliquidaciongasto.getPdescuento()); 
			initialValues.put("DESCUENTODOC",ordenliquidaciongasto.getDescuentodoc()); 
			initialValues.put("REDONDEO",ordenliquidaciongasto.getRedondeo()); 
			initialValues.put("IMPORTE",ordenliquidaciongasto.getImporte()); 
			initialValues.put("IMPORTEMOF",ordenliquidaciongasto.getImportemof()); 
			initialValues.put("IMPORTEMEX",ordenliquidaciongasto.getImportemex()); 
			initialValues.put("IDESTADO",ordenliquidaciongasto.getIdestado()); 
			initialValues.put("SINCRONIZA",ordenliquidaciongasto.getSincroniza()); 
			initialValues.put("IGV",ordenliquidaciongasto.getIgv()); 
			initialValues.put("IDUSUARIO",ordenliquidaciongasto.getIdusuario()); 
			initialValues.put("VENTANA",ordenliquidaciongasto.getVentana()); 
			initialValues.put("FECHACREACION",dateFormat.format(ordenliquidaciongasto.getFechacreacion() ) ); 
			initialValues.put("IMPRESO",ordenliquidaciongasto.getImpreso()); 
			initialValues.put("IDMEDIOPAGO",ordenliquidaciongasto.getIdmediopago()); 
			initialValues.put("IDCONTACTO",ordenliquidaciongasto.getIdcontacto()); 
			initialValues.put("CERTIFTRANSPORTE",ordenliquidaciongasto.getCertiftransporte()); 
			initialValues.put("CERTIFTRANSPORTE1",ordenliquidaciongasto.getCertiftransporte1()); 
			initialValues.put("IDVEHICULO",ordenliquidaciongasto.getIdvehiculo()); 
			initialValues.put("PLACA",ordenliquidaciongasto.getPlaca()); 
			initialValues.put("PLACA1",ordenliquidaciongasto.getPlaca1()); 
			initialValues.put("MARCA",ordenliquidaciongasto.getMarca()); 
			initialValues.put("MARCA1",ordenliquidaciongasto.getMarca1()); 
			initialValues.put("IDCHOFER",ordenliquidaciongasto.getIdchofer()); 
			initialValues.put("CHOFER",ordenliquidaciongasto.getChofer()); 
			initialValues.put("BREVETE",ordenliquidaciongasto.getBrevete()); 
			initialValues.put("FECHATRASLADO",dateFormat.format(ordenliquidaciongasto.getFechatraslado() ) ); 
			initialValues.put("RAZONSOCIAL2",ordenliquidaciongasto.getRazonsocial2()); 
			initialValues.put("GLOSA1",ordenliquidaciongasto.getGlosa1()); 
			initialValues.put("CONDICIONSUNAT",ordenliquidaciongasto.getCondicionsunat()); 
			initialValues.put("ESTADOSUNAT",ordenliquidaciongasto.getEstadosunat()); 
			resultado = mDb.insert("ORDENLIQUIDACIONGASTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Ordenliquidaciongasto ordenliquidaciongasto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",ordenliquidaciongasto.getIdempresa()) ; 
			initialValues.put("IDORDEN",ordenliquidaciongasto.getIdorden()) ; 
			initialValues.put("IDEMISOR",ordenliquidaciongasto.getIdemisor()) ; 
			initialValues.put("PERIODO",ordenliquidaciongasto.getPeriodo()) ; 
			initialValues.put("FECHAREGISTRO",dateFormat.format(ordenliquidaciongasto.getFecharegistro() ) ) ; 
			initialValues.put("IDSUCURSAL",ordenliquidaciongasto.getIdsucursal()) ; 
			initialValues.put("IDDOCUMENTO",ordenliquidaciongasto.getIddocumento()) ; 
			initialValues.put("SERIE",ordenliquidaciongasto.getSerie()) ; 
			initialValues.put("NUMERO",ordenliquidaciongasto.getNumero()) ; 
			initialValues.put("FECHA",dateFormat.format(ordenliquidaciongasto.getFecha() ) ) ; 
			initialValues.put("TCAMBIO",ordenliquidaciongasto.getTcambio()) ; 
			initialValues.put("IDCLIEPROV",ordenliquidaciongasto.getIdclieprov()) ; 
			initialValues.put("DIRECCION",ordenliquidaciongasto.getDireccion()) ; 
			initialValues.put("RUC",ordenliquidaciongasto.getRuc()) ; 
			initialValues.put("RAZONSOCIAL",ordenliquidaciongasto.getRazonsocial()) ; 
			initialValues.put("IDREGIMEN",ordenliquidaciongasto.getIdregimen()) ; 
			initialValues.put("IDMONEDA",ordenliquidaciongasto.getIdmoneda()) ; 
			initialValues.put("TCMONEDA",ordenliquidaciongasto.getTcmoneda()) ; 
			initialValues.put("IDTIPOMOV",ordenliquidaciongasto.getIdtipomov()) ; 
			initialValues.put("IDFPAGO",ordenliquidaciongasto.getIdfpago()) ; 
			initialValues.put("IDAREA",ordenliquidaciongasto.getIdarea()) ; 
			initialValues.put("GLOSA",ordenliquidaciongasto.getGlosa()) ; 
			initialValues.put("VVENTA",ordenliquidaciongasto.getVventa()) ; 
			initialValues.put("INAFECTO",ordenliquidaciongasto.getInafecto()) ; 
			initialValues.put("OTROS",ordenliquidaciongasto.getOtros()) ; 
			initialValues.put("IMPUESTO",ordenliquidaciongasto.getImpuesto()) ; 
			initialValues.put("PIMPUESTO",ordenliquidaciongasto.getPimpuesto()) ; 
			initialValues.put("DESCUENTO",ordenliquidaciongasto.getDescuento()) ; 
			initialValues.put("PDESCUENTO",ordenliquidaciongasto.getPdescuento()) ; 
			initialValues.put("DESCUENTODOC",ordenliquidaciongasto.getDescuentodoc()) ; 
			initialValues.put("REDONDEO",ordenliquidaciongasto.getRedondeo()) ; 
			initialValues.put("IMPORTE",ordenliquidaciongasto.getImporte()) ; 
			initialValues.put("IMPORTEMOF",ordenliquidaciongasto.getImportemof()) ; 
			initialValues.put("IMPORTEMEX",ordenliquidaciongasto.getImportemex()) ; 
			initialValues.put("IDESTADO",ordenliquidaciongasto.getIdestado()) ; 
			initialValues.put("SINCRONIZA",ordenliquidaciongasto.getSincroniza()) ; 
			initialValues.put("IGV",ordenliquidaciongasto.getIgv()) ; 
			initialValues.put("IDUSUARIO",ordenliquidaciongasto.getIdusuario()) ; 
			initialValues.put("VENTANA",ordenliquidaciongasto.getVentana()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(ordenliquidaciongasto.getFechacreacion() ) ) ; 
			initialValues.put("IMPRESO",ordenliquidaciongasto.getImpreso()) ; 
			initialValues.put("IDMEDIOPAGO",ordenliquidaciongasto.getIdmediopago()) ; 
			initialValues.put("IDCONTACTO",ordenliquidaciongasto.getIdcontacto()) ; 
			initialValues.put("CERTIFTRANSPORTE",ordenliquidaciongasto.getCertiftransporte()) ; 
			initialValues.put("CERTIFTRANSPORTE1",ordenliquidaciongasto.getCertiftransporte1()) ; 
			initialValues.put("IDVEHICULO",ordenliquidaciongasto.getIdvehiculo()) ; 
			initialValues.put("PLACA",ordenliquidaciongasto.getPlaca()) ; 
			initialValues.put("PLACA1",ordenliquidaciongasto.getPlaca1()) ; 
			initialValues.put("MARCA",ordenliquidaciongasto.getMarca()) ; 
			initialValues.put("MARCA1",ordenliquidaciongasto.getMarca1()) ; 
			initialValues.put("IDCHOFER",ordenliquidaciongasto.getIdchofer()) ; 
			initialValues.put("CHOFER",ordenliquidaciongasto.getChofer()) ; 
			initialValues.put("BREVETE",ordenliquidaciongasto.getBrevete()) ; 
			initialValues.put("FECHATRASLADO",dateFormat.format(ordenliquidaciongasto.getFechatraslado() ) ) ; 
			initialValues.put("RAZONSOCIAL2",ordenliquidaciongasto.getRazonsocial2()) ; 
			initialValues.put("GLOSA1",ordenliquidaciongasto.getGlosa1()) ; 
			initialValues.put("CONDICIONSUNAT",ordenliquidaciongasto.getCondicionsunat()) ; 
			initialValues.put("ESTADOSUNAT",ordenliquidaciongasto.getEstadosunat()) ; 
			resultado = mDb.update("ORDENLIQUIDACIONGASTO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ORDENLIQUIDACIONGASTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Ordenliquidaciongasto> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Ordenliquidaciongasto> lista  = new ArrayList<Ordenliquidaciongasto>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ORDENLIQUIDACIONGASTO",
					new String[] {
							 "IDEMPRESA" ,
							 "IDORDEN" ,
							 "IDEMISOR" ,
							 "PERIODO" ,
							 "FECHAREGISTRO" ,
							 "IDSUCURSAL" ,
							 "IDDOCUMENTO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "FECHA" ,
							 "TCAMBIO" ,
							 "IDCLIEPROV" ,
							 "DIRECCION" ,
							 "RUC" ,
							 "RAZONSOCIAL" ,
							 "IDREGIMEN" ,
							 "IDMONEDA" ,
							 "TCMONEDA" ,
							 "IDTIPOMOV" ,
							 "IDFPAGO" ,
							 "IDAREA" ,
							 "GLOSA" ,
							 "VVENTA" ,
							 "INAFECTO" ,
							 "OTROS" ,
							 "IMPUESTO" ,
							 "PIMPUESTO" ,
							 "DESCUENTO" ,
							 "PDESCUENTO" ,
							 "DESCUENTODOC" ,
							 "REDONDEO" ,
							 "IMPORTE" ,
							 "IMPORTEMOF" ,
							 "IMPORTEMEX" ,
							 "IDESTADO" ,
							 "SINCRONIZA" ,
							 "IGV" ,
							 "IDUSUARIO" ,
							 "VENTANA" ,
							 "FECHACREACION" ,
							 "IMPRESO" ,
							 "IDMEDIOPAGO" ,
							 "IDCONTACTO" ,
							 "CERTIFTRANSPORTE" ,
							 "CERTIFTRANSPORTE1" ,
							 "IDVEHICULO" ,
							 "PLACA" ,
							 "PLACA1" ,
							 "MARCA" ,
							 "MARCA1" ,
							 "IDCHOFER" ,
							 "CHOFER" ,
							 "BREVETE" ,
							 "FECHATRASLADO" ,
							 "RAZONSOCIAL2" ,
							 "GLOSA1" ,
							 "CONDICIONSUNAT" ,
							 "ESTADOSUNAT" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Ordenliquidaciongasto ordenliquidaciongasto = new Ordenliquidaciongasto() ;
					ordenliquidaciongasto.setIdempresa(cur.getString(j++));
					ordenliquidaciongasto.setIdorden(cur.getString(j++));
					ordenliquidaciongasto.setIdemisor(cur.getString(j++));
					ordenliquidaciongasto.setPeriodo(cur.getString(j++));
					ordenliquidaciongasto.setFecharegistro(dateFormat.parse(cur.getString(j++)) );
					ordenliquidaciongasto.setIdsucursal(cur.getString(j++));
					ordenliquidaciongasto.setIddocumento(cur.getString(j++));
					ordenliquidaciongasto.setSerie(cur.getString(j++));
					ordenliquidaciongasto.setNumero(cur.getString(j++));
					ordenliquidaciongasto.setFecha(dateFormat.parse(cur.getString(j++)) );
					ordenliquidaciongasto.setTcambio(cur.getDouble(j++));
					ordenliquidaciongasto.setIdclieprov(cur.getString(j++));
					ordenliquidaciongasto.setDireccion(cur.getString(j++));
					ordenliquidaciongasto.setRuc(cur.getString(j++));
					ordenliquidaciongasto.setRazonsocial(cur.getString(j++));
					ordenliquidaciongasto.setIdregimen(cur.getString(j++));
					ordenliquidaciongasto.setIdmoneda(cur.getString(j++));
					ordenliquidaciongasto.setTcmoneda(cur.getDouble(j++));
					ordenliquidaciongasto.setIdtipomov(cur.getString(j++));
					ordenliquidaciongasto.setIdfpago(cur.getString(j++));
					ordenliquidaciongasto.setIdarea(cur.getString(j++));
					ordenliquidaciongasto.setGlosa(cur.getString(j++));
					ordenliquidaciongasto.setVventa(cur.getDouble(j++));
					ordenliquidaciongasto.setInafecto(cur.getDouble(j++));
					ordenliquidaciongasto.setOtros(cur.getDouble(j++));
					ordenliquidaciongasto.setImpuesto(cur.getDouble(j++));
					ordenliquidaciongasto.setPimpuesto(cur.getDouble(j++));
					ordenliquidaciongasto.setDescuento(cur.getDouble(j++));
					ordenliquidaciongasto.setPdescuento(cur.getDouble(j++));
					ordenliquidaciongasto.setDescuentodoc(cur.getDouble(j++));
					ordenliquidaciongasto.setRedondeo(cur.getDouble(j++));
					ordenliquidaciongasto.setImporte(cur.getDouble(j++));
					ordenliquidaciongasto.setImportemof(cur.getDouble(j++));
					ordenliquidaciongasto.setImportemex(cur.getDouble(j++));
					ordenliquidaciongasto.setIdestado(cur.getString(j++));
					ordenliquidaciongasto.setSincroniza(cur.getString(j++));
					ordenliquidaciongasto.setIgv(cur.getDouble(j++));
					ordenliquidaciongasto.setIdusuario(cur.getString(j++));
					ordenliquidaciongasto.setVentana(cur.getString(j++));
					ordenliquidaciongasto.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					ordenliquidaciongasto.setImpreso(cur.getDouble(j++));
					ordenliquidaciongasto.setIdmediopago(cur.getString(j++));
					ordenliquidaciongasto.setIdcontacto(cur.getString(j++));
					ordenliquidaciongasto.setCertiftransporte(cur.getString(j++));
					ordenliquidaciongasto.setCertiftransporte1(cur.getString(j++));
					ordenliquidaciongasto.setIdvehiculo(cur.getString(j++));
					ordenliquidaciongasto.setPlaca(cur.getString(j++));
					ordenliquidaciongasto.setPlaca1(cur.getString(j++));
					ordenliquidaciongasto.setMarca(cur.getString(j++));
					ordenliquidaciongasto.setMarca1(cur.getString(j++));
					ordenliquidaciongasto.setIdchofer(cur.getString(j++));
					ordenliquidaciongasto.setChofer(cur.getString(j++));
					ordenliquidaciongasto.setBrevete(cur.getString(j++));
					ordenliquidaciongasto.setFechatraslado(dateFormat.parse(cur.getString(j++)) );
					ordenliquidaciongasto.setRazonsocial2(cur.getString(j++));
					ordenliquidaciongasto.setGlosa1(cur.getString(j++));
					ordenliquidaciongasto.setCondicionsunat(cur.getString(j++));
					ordenliquidaciongasto.setEstadosunat(cur.getString(j++));

					lista.add(ordenliquidaciongasto); 
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