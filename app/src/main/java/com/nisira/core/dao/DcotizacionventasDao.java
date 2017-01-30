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

public class DcotizacionventasDao extends BaseDao<Dcotizacionventas> {
	public DcotizacionventasDao() {
		super(Dcotizacionventas.class);
	}
	public DcotizacionventasDao(boolean usaCnBase) throws Exception {
		super(Dcotizacionventas.class, usaCnBase);
	}

	public Boolean insert(Dcotizacionventas dcotizacionventas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dcotizacionventas.getIdempresa()); 
			initialValues.put("IDCOTIZACIONV",dcotizacionventas.getIdcotizacionv()); 
			initialValues.put("ITEM",dcotizacionventas.getItem()); 
			initialValues.put("IDCOMPRA",dcotizacionventas.getIdcompra()); 
			initialValues.put("ITEMCOTIZACION",dcotizacionventas.getItemcotizacion()); 
			initialValues.put("IDPRODUCTO",dcotizacionventas.getIdproducto()); 
			initialValues.put("DESCRIPCION",dcotizacionventas.getDescripcion()); 
			initialValues.put("IDMEDIDA",dcotizacionventas.getIdmedida()); 
			initialValues.put("CANTIDAD",dcotizacionventas.getCantidad()); 
			initialValues.put("PRECIO",dcotizacionventas.getPrecio()); 
			initialValues.put("DESCUENTO",dcotizacionventas.getDescuento()); 
			initialValues.put("IMPORTE",dcotizacionventas.getImporte()); 
			initialValues.put("ES_AFECTO",dcotizacionventas.getEs_afecto()); 
			initialValues.put("PORCENTAJEDSCTO1",dcotizacionventas.getPorcentajedscto1()); 
			initialValues.put("PORCENTAJEDSCTO2",dcotizacionventas.getPorcentajedscto2()); 
			initialValues.put("PORCENTAJEDSCTO3",dcotizacionventas.getPorcentajedscto3()); 
			initialValues.put("IMPUESTO_I",dcotizacionventas.getImpuesto_i()); 
			initialValues.put("IMPUESTO",dcotizacionventas.getImpuesto()); 
			initialValues.put("IMPORTEDSCTO1",dcotizacionventas.getImportedscto1()); 
			initialValues.put("IMPORTEDSCTO2",dcotizacionventas.getImportedscto2()); 
			initialValues.put("IMPORTEDSCTO3",dcotizacionventas.getImportedscto3()); 
			initialValues.put("SUBTOTALSINDSCTO",dcotizacionventas.getSubtotalsindscto()); 
			initialValues.put("SUBTOTALCONDSCTO",dcotizacionventas.getSubtotalcondscto()); 
			initialValues.put("IDESTADOPRODUCTO",dcotizacionventas.getIdestadoproducto()); 
			initialValues.put("DESCUENTO_TOTAL",dcotizacionventas.getDescuento_total()); 
			initialValues.put("DESTINO",dcotizacionventas.getDestino()); 
			initialValues.put("IDESTADO",dcotizacionventas.getIdestado()); 
			initialValues.put("IDESTADOOLD",dcotizacionventas.getIdestadoold()); 
			initialValues.put("OBSERVACIONES",dcotizacionventas.getObservaciones()); 
			initialValues.put("ANNIOFABRICACION",dcotizacionventas.getAnniofabricacion()); 
			initialValues.put("CLASE",dcotizacionventas.getClase()); 
			initialValues.put("CARROCERIA",dcotizacionventas.getCarroceria()); 
			initialValues.put("TRANSMISION",dcotizacionventas.getTransmision()); 
			initialValues.put("TIPOMOTOR",dcotizacionventas.getTipomotor()); 
			initialValues.put("COMBUSTIBLE",dcotizacionventas.getCombustible()); 
			initialValues.put("IDREFERENCIA",dcotizacionventas.getIdreferencia()); 
			initialValues.put("ITEMREF",dcotizacionventas.getItemref()); 
			initialValues.put("TABLAREF",dcotizacionventas.getTablaref()); 
			initialValues.put("DOCUMENTOREF",dcotizacionventas.getDocumentoref()); 
			initialValues.put("SINCRONIZA",dcotizacionventas.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(dcotizacionventas.getFechacreacion() ) ); 
			initialValues.put("IDCONSUMIDOR",dcotizacionventas.getIdconsumidor()); 
			initialValues.put("IDPLANTILLACV",dcotizacionventas.getIdplantillacv()); 
			initialValues.put("PARAFECHA",dateFormat.format(dcotizacionventas.getParafecha() ) ); 
			initialValues.put("DIAS",dcotizacionventas.getDias()); 
			initialValues.put("IDSERIE",dcotizacionventas.getIdserie()); 
			initialValues.put("IDCOLOR",dcotizacionventas.getIdcolor()); 
			initialValues.put("IDSUCURSAL",dcotizacionventas.getIdsucursal()); 
			initialValues.put("IDALMACEN",dcotizacionventas.getIdalmacen()); 
			initialValues.put("CALIBREMM",dcotizacionventas.getCalibremm()); 
			initialValues.put("FACTORCE",dcotizacionventas.getFactorce()); 
			initialValues.put("IDINSUMO",dcotizacionventas.getIdinsumo()); 
			initialValues.put("IDPRESENTACION",dcotizacionventas.getIdpresentacion()); 
			initialValues.put("IDTALLA",dcotizacionventas.getIdtalla()); 
			initialValues.put("LARGO",dcotizacionventas.getLargo()); 
			initialValues.put("TOTAL_CE",dcotizacionventas.getTotal_ce()); 
			initialValues.put("UNDXPHL",dcotizacionventas.getUndxphl()); 
			initialValues.put("DESCUENTO_I",dcotizacionventas.getDescuento_i()); 
			initialValues.put("IMPORTE_ISC",dcotizacionventas.getImporte_isc()); 
			initialValues.put("ACCESORIOS_CONIGV",dcotizacionventas.getAccesorios_conigv()); 
			initialValues.put("IMPORTEDSCTO1_CONIGV",dcotizacionventas.getImportedscto1_conigv()); 
			initialValues.put("IMPORTEDSCTO2_CONIGV",dcotizacionventas.getImportedscto2_conigv()); 
			initialValues.put("IMPORTEDSCTO3_CONIGV",dcotizacionventas.getImportedscto3_conigv()); 
			initialValues.put("IMPORTEDSCTO_IMPORTADOR_REAL",dcotizacionventas.getImportedscto_importador_real()); 
			initialValues.put("IMPORTEDSCTO_MAXPERMITIDO",dcotizacionventas.getImportedscto_maxpermitido()); 
			initialValues.put("VVENTAPUBLICO_CONIGV",dcotizacionventas.getVventapublico_conigv()); 
			initialValues.put("ANNIOMODELO",dcotizacionventas.getAnniomodelo()); 
			initialValues.put("IDTG20VERSIONVEH",dcotizacionventas.getIdtg20versionveh()); 
			initialValues.put("IMPORTEACCESORIOS",dcotizacionventas.getImporteaccesorios()); 
			resultado = mDb.insert("DCOTIZACIONVENTAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dcotizacionventas dcotizacionventas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dcotizacionventas.getIdempresa()) ; 
			initialValues.put("IDCOTIZACIONV",dcotizacionventas.getIdcotizacionv()) ; 
			initialValues.put("ITEM",dcotizacionventas.getItem()) ; 
			initialValues.put("IDCOMPRA",dcotizacionventas.getIdcompra()) ; 
			initialValues.put("ITEMCOTIZACION",dcotizacionventas.getItemcotizacion()) ; 
			initialValues.put("IDPRODUCTO",dcotizacionventas.getIdproducto()) ; 
			initialValues.put("DESCRIPCION",dcotizacionventas.getDescripcion()) ; 
			initialValues.put("IDMEDIDA",dcotizacionventas.getIdmedida()) ; 
			initialValues.put("CANTIDAD",dcotizacionventas.getCantidad()) ; 
			initialValues.put("PRECIO",dcotizacionventas.getPrecio()) ; 
			initialValues.put("DESCUENTO",dcotizacionventas.getDescuento()) ; 
			initialValues.put("IMPORTE",dcotizacionventas.getImporte()) ; 
			initialValues.put("ES_AFECTO",dcotizacionventas.getEs_afecto()) ; 
			initialValues.put("PORCENTAJEDSCTO1",dcotizacionventas.getPorcentajedscto1()) ; 
			initialValues.put("PORCENTAJEDSCTO2",dcotizacionventas.getPorcentajedscto2()) ; 
			initialValues.put("PORCENTAJEDSCTO3",dcotizacionventas.getPorcentajedscto3()) ; 
			initialValues.put("IMPUESTO_I",dcotizacionventas.getImpuesto_i()) ; 
			initialValues.put("IMPUESTO",dcotizacionventas.getImpuesto()) ; 
			initialValues.put("IMPORTEDSCTO1",dcotizacionventas.getImportedscto1()) ; 
			initialValues.put("IMPORTEDSCTO2",dcotizacionventas.getImportedscto2()) ; 
			initialValues.put("IMPORTEDSCTO3",dcotizacionventas.getImportedscto3()) ; 
			initialValues.put("SUBTOTALSINDSCTO",dcotizacionventas.getSubtotalsindscto()) ; 
			initialValues.put("SUBTOTALCONDSCTO",dcotizacionventas.getSubtotalcondscto()) ; 
			initialValues.put("IDESTADOPRODUCTO",dcotizacionventas.getIdestadoproducto()) ; 
			initialValues.put("DESCUENTO_TOTAL",dcotizacionventas.getDescuento_total()) ; 
			initialValues.put("DESTINO",dcotizacionventas.getDestino()) ; 
			initialValues.put("IDESTADO",dcotizacionventas.getIdestado()) ; 
			initialValues.put("IDESTADOOLD",dcotizacionventas.getIdestadoold()) ; 
			initialValues.put("OBSERVACIONES",dcotizacionventas.getObservaciones()) ; 
			initialValues.put("ANNIOFABRICACION",dcotizacionventas.getAnniofabricacion()) ; 
			initialValues.put("CLASE",dcotizacionventas.getClase()) ; 
			initialValues.put("CARROCERIA",dcotizacionventas.getCarroceria()) ; 
			initialValues.put("TRANSMISION",dcotizacionventas.getTransmision()) ; 
			initialValues.put("TIPOMOTOR",dcotizacionventas.getTipomotor()) ; 
			initialValues.put("COMBUSTIBLE",dcotizacionventas.getCombustible()) ; 
			initialValues.put("IDREFERENCIA",dcotizacionventas.getIdreferencia()) ; 
			initialValues.put("ITEMREF",dcotizacionventas.getItemref()) ; 
			initialValues.put("TABLAREF",dcotizacionventas.getTablaref()) ; 
			initialValues.put("DOCUMENTOREF",dcotizacionventas.getDocumentoref()) ; 
			initialValues.put("SINCRONIZA",dcotizacionventas.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(dcotizacionventas.getFechacreacion() ) ) ; 
			initialValues.put("IDCONSUMIDOR",dcotizacionventas.getIdconsumidor()) ; 
			initialValues.put("IDPLANTILLACV",dcotizacionventas.getIdplantillacv()) ; 
			initialValues.put("PARAFECHA",dateFormat.format(dcotizacionventas.getParafecha() ) ) ; 
			initialValues.put("DIAS",dcotizacionventas.getDias()) ; 
			initialValues.put("IDSERIE",dcotizacionventas.getIdserie()) ; 
			initialValues.put("IDCOLOR",dcotizacionventas.getIdcolor()) ; 
			initialValues.put("IDSUCURSAL",dcotizacionventas.getIdsucursal()) ; 
			initialValues.put("IDALMACEN",dcotizacionventas.getIdalmacen()) ; 
			initialValues.put("CALIBREMM",dcotizacionventas.getCalibremm()) ; 
			initialValues.put("FACTORCE",dcotizacionventas.getFactorce()) ; 
			initialValues.put("IDINSUMO",dcotizacionventas.getIdinsumo()) ; 
			initialValues.put("IDPRESENTACION",dcotizacionventas.getIdpresentacion()) ; 
			initialValues.put("IDTALLA",dcotizacionventas.getIdtalla()) ; 
			initialValues.put("LARGO",dcotizacionventas.getLargo()) ; 
			initialValues.put("TOTAL_CE",dcotizacionventas.getTotal_ce()) ; 
			initialValues.put("UNDXPHL",dcotizacionventas.getUndxphl()) ; 
			initialValues.put("DESCUENTO_I",dcotizacionventas.getDescuento_i()) ; 
			initialValues.put("IMPORTE_ISC",dcotizacionventas.getImporte_isc()) ; 
			initialValues.put("ACCESORIOS_CONIGV",dcotizacionventas.getAccesorios_conigv()) ; 
			initialValues.put("IMPORTEDSCTO1_CONIGV",dcotizacionventas.getImportedscto1_conigv()) ; 
			initialValues.put("IMPORTEDSCTO2_CONIGV",dcotizacionventas.getImportedscto2_conigv()) ; 
			initialValues.put("IMPORTEDSCTO3_CONIGV",dcotizacionventas.getImportedscto3_conigv()) ; 
			initialValues.put("IMPORTEDSCTO_IMPORTADOR_REAL",dcotizacionventas.getImportedscto_importador_real()) ; 
			initialValues.put("IMPORTEDSCTO_MAXPERMITIDO",dcotizacionventas.getImportedscto_maxpermitido()) ; 
			initialValues.put("VVENTAPUBLICO_CONIGV",dcotizacionventas.getVventapublico_conigv()) ; 
			initialValues.put("ANNIOMODELO",dcotizacionventas.getAnniomodelo()) ; 
			initialValues.put("IDTG20VERSIONVEH",dcotizacionventas.getIdtg20versionveh()) ; 
			initialValues.put("IMPORTEACCESORIOS",dcotizacionventas.getImporteaccesorios()) ; 
			resultado = mDb.update("DCOTIZACIONVENTAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DCOTIZACIONVENTAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Dcotizacionventas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Dcotizacionventas> lista  = new ArrayList<Dcotizacionventas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DCOTIZACIONVENTAS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCOTIZACIONV" ,
							 "ITEM" ,
							 "IDCOMPRA" ,
							 "ITEMCOTIZACION" ,
							 "IDPRODUCTO" ,
							 "DESCRIPCION" ,
							 "IDMEDIDA" ,
							 "CANTIDAD" ,
							 "PRECIO" ,
							 "DESCUENTO" ,
							 "IMPORTE" ,
							 "ES_AFECTO" ,
							 "PORCENTAJEDSCTO1" ,
							 "PORCENTAJEDSCTO2" ,
							 "PORCENTAJEDSCTO3" ,
							 "IMPUESTO_I" ,
							 "IMPUESTO" ,
							 "IMPORTEDSCTO1" ,
							 "IMPORTEDSCTO2" ,
							 "IMPORTEDSCTO3" ,
							 "SUBTOTALSINDSCTO" ,
							 "SUBTOTALCONDSCTO" ,
							 "IDESTADOPRODUCTO" ,
							 "DESCUENTO_TOTAL" ,
							 "DESTINO" ,
							 "IDESTADO" ,
							 "IDESTADOOLD" ,
							 "OBSERVACIONES" ,
							 "ANNIOFABRICACION" ,
							 "CLASE" ,
							 "CARROCERIA" ,
							 "TRANSMISION" ,
							 "TIPOMOTOR" ,
							 "COMBUSTIBLE" ,
							 "IDREFERENCIA" ,
							 "ITEMREF" ,
							 "TABLAREF" ,
							 "DOCUMENTOREF" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "IDCONSUMIDOR" ,
							 "IDPLANTILLACV" ,
							 "PARAFECHA" ,
							 "DIAS" ,
							 "IDSERIE" ,
							 "IDCOLOR" ,
							 "IDSUCURSAL" ,
							 "IDALMACEN" ,
							 "CALIBREMM" ,
							 "FACTORCE" ,
							 "IDINSUMO" ,
							 "IDPRESENTACION" ,
							 "IDTALLA" ,
							 "LARGO" ,
							 "TOTAL_CE" ,
							 "UNDXPHL" ,
							 "DESCUENTO_I" ,
							 "IMPORTE_ISC" ,
							 "ACCESORIOS_CONIGV" ,
							 "IMPORTEDSCTO1_CONIGV" ,
							 "IMPORTEDSCTO2_CONIGV" ,
							 "IMPORTEDSCTO3_CONIGV" ,
							 "IMPORTEDSCTO_IMPORTADOR_REAL" ,
							 "IMPORTEDSCTO_MAXPERMITIDO" ,
							 "VVENTAPUBLICO_CONIGV" ,
							 "ANNIOMODELO" ,
							 "IDTG20VERSIONVEH" ,
							 "IMPORTEACCESORIOS" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Dcotizacionventas dcotizacionventas = new Dcotizacionventas() ;
					dcotizacionventas.setIdempresa(cur.getString(j++));
					dcotizacionventas.setIdcotizacionv(cur.getString(j++));
					dcotizacionventas.setItem(cur.getString(j++));
					dcotizacionventas.setIdcompra(cur.getString(j++));
					dcotizacionventas.setItemcotizacion(cur.getString(j++));
					dcotizacionventas.setIdproducto(cur.getString(j++));
					dcotizacionventas.setDescripcion(cur.getString(j++));
					dcotizacionventas.setIdmedida(cur.getString(j++));
					dcotizacionventas.setCantidad(cur.getDouble(j++));
					dcotizacionventas.setPrecio(cur.getDouble(j++));
					dcotizacionventas.setDescuento(cur.getDouble(j++));
					dcotizacionventas.setImporte(cur.getDouble(j++));
					dcotizacionventas.setEs_afecto(cur.getDouble(j++));
					dcotizacionventas.setPorcentajedscto1(cur.getDouble(j++));
					dcotizacionventas.setPorcentajedscto2(cur.getDouble(j++));
					dcotizacionventas.setPorcentajedscto3(cur.getDouble(j++));
					dcotizacionventas.setImpuesto_i(cur.getDouble(j++));
					dcotizacionventas.setImpuesto(cur.getDouble(j++));
					dcotizacionventas.setImportedscto1(cur.getDouble(j++));
					dcotizacionventas.setImportedscto2(cur.getDouble(j++));
					dcotizacionventas.setImportedscto3(cur.getDouble(j++));
					dcotizacionventas.setSubtotalsindscto(cur.getDouble(j++));
					dcotizacionventas.setSubtotalcondscto(cur.getDouble(j++));
					dcotizacionventas.setIdestadoproducto(cur.getString(j++));
					dcotizacionventas.setDescuento_total(cur.getDouble(j++));
					dcotizacionventas.setDestino(cur.getString(j++));
					dcotizacionventas.setIdestado(cur.getString(j++));
					dcotizacionventas.setIdestadoold(cur.getString(j++));
					dcotizacionventas.setObservaciones(cur.getString(j++));
					dcotizacionventas.setAnniofabricacion(cur.getString(j++));
					dcotizacionventas.setClase(cur.getString(j++));
					dcotizacionventas.setCarroceria(cur.getString(j++));
					dcotizacionventas.setTransmision(cur.getString(j++));
					dcotizacionventas.setTipomotor(cur.getString(j++));
					dcotizacionventas.setCombustible(cur.getString(j++));
					dcotizacionventas.setIdreferencia(cur.getString(j++));
					dcotizacionventas.setItemref(cur.getString(j++));
					dcotizacionventas.setTablaref(cur.getString(j++));
					dcotizacionventas.setDocumentoref(cur.getString(j++));
					dcotizacionventas.setSincroniza(cur.getString(j++));
					dcotizacionventas.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					dcotizacionventas.setIdconsumidor(cur.getString(j++));
					dcotizacionventas.setIdplantillacv(cur.getString(j++));
					dcotizacionventas.setParafecha(dateFormat.parse(cur.getString(j++)) );
					dcotizacionventas.setDias(cur.getDouble(j++));
					dcotizacionventas.setIdserie(cur.getString(j++));
					dcotizacionventas.setIdcolor(cur.getString(j++));
					dcotizacionventas.setIdsucursal(cur.getString(j++));
					dcotizacionventas.setIdalmacen(cur.getString(j++));
					dcotizacionventas.setCalibremm(cur.getString(j++));
					dcotizacionventas.setFactorce(cur.getDouble(j++));
					dcotizacionventas.setIdinsumo(cur.getString(j++));
					dcotizacionventas.setIdpresentacion(cur.getString(j++));
					dcotizacionventas.setIdtalla(cur.getString(j++));
					dcotizacionventas.setLargo(cur.getString(j++));
					dcotizacionventas.setTotal_ce(cur.getDouble(j++));
					dcotizacionventas.setUndxphl(cur.getInt(j++));
					dcotizacionventas.setDescuento_i(cur.getDouble(j++));
					dcotizacionventas.setImporte_isc(cur.getDouble(j++));
					dcotizacionventas.setAccesorios_conigv(cur.getDouble(j++));
					dcotizacionventas.setImportedscto1_conigv(cur.getDouble(j++));
					dcotizacionventas.setImportedscto2_conigv(cur.getDouble(j++));
					dcotizacionventas.setImportedscto3_conigv(cur.getDouble(j++));
					dcotizacionventas.setImportedscto_importador_real(cur.getDouble(j++));
					dcotizacionventas.setImportedscto_maxpermitido(cur.getDouble(j++));
					dcotizacionventas.setVventapublico_conigv(cur.getDouble(j++));
					dcotizacionventas.setAnniomodelo(cur.getString(j++));
					dcotizacionventas.setIdtg20versionveh(cur.getInt(j++));
					dcotizacionventas.setImporteaccesorios(cur.getDouble(j++));

					lista.add(dcotizacionventas); 
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