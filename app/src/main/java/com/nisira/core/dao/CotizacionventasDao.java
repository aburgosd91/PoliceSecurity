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

public class CotizacionventasDao extends BaseDao<Cotizacionventas> {
	public CotizacionventasDao() {
		super(Cotizacionventas.class);
	}
	public CotizacionventasDao(boolean usaCnBase) throws Exception {
		super(Cotizacionventas.class, usaCnBase);
	}

	public Boolean insert(Cotizacionventas cotizacionventas) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cotizacionventas.getIdempresa()); 
			initialValues.put("IDCOTIZACIONV",cotizacionventas.getIdcotizacionv()); 
			initialValues.put("IDEMISOR",cotizacionventas.getIdemisor()); 
			initialValues.put("IDSUCURSAL",cotizacionventas.getIdsucursal()); 
			initialValues.put("IDALMACEN",cotizacionventas.getIdalmacen()); 
			initialValues.put("IDDOCUMENTO",cotizacionventas.getIddocumento()); 
			initialValues.put("PERIODO",cotizacionventas.getPeriodo()); 
			initialValues.put("SERIE",cotizacionventas.getSerie()); 
			initialValues.put("NUMERO",cotizacionventas.getNumero()); 
			initialValues.put("FECHA",dateFormat.format(cotizacionventas.getFecha() ) ); 
			initialValues.put("IDCLIEPROV",cotizacionventas.getIdclieprov()); 
			initialValues.put("IDPROYECTO",cotizacionventas.getIdproyecto()); 
			initialValues.put("TCAMBIO",cotizacionventas.getTcambio()); 
			initialValues.put("IDMONEDA",cotizacionventas.getIdmoneda()); 
			initialValues.put("GLOSA",cotizacionventas.getGlosa()); 
			initialValues.put("IDESTADO",cotizacionventas.getIdestado()); 
			initialValues.put("IDESTADOOLD",cotizacionventas.getIdestadoold()); 
			initialValues.put("VVENTA",cotizacionventas.getVventa()); 
			initialValues.put("IMPUESTO",cotizacionventas.getImpuesto()); 
			initialValues.put("IMPUESTO_I",cotizacionventas.getImpuesto_i()); 
			initialValues.put("IMPORTE",cotizacionventas.getImporte()); 
			initialValues.put("FECHACREACION",dateFormat.format(cotizacionventas.getFechacreacion() ) ); 
			initialValues.put("SINCRONIZA",cotizacionventas.getSincroniza()); 
			initialValues.put("CONTACTO",cotizacionventas.getContacto()); 
			initialValues.put("LUGAR_ENTREGA",cotizacionventas.getLugar_entrega()); 
			initialValues.put("SOLICITADO",cotizacionventas.getSolicitado()); 
			initialValues.put("TCMONEDA",cotizacionventas.getTcmoneda()); 
			initialValues.put("SUBTOTALSINDSCTO",cotizacionventas.getSubtotalsindscto()); 
			initialValues.put("DESCUENTO",cotizacionventas.getDescuento()); 
			initialValues.put("SUBTOTALCONDSCTO",cotizacionventas.getSubtotalcondscto()); 
			initialValues.put("FECHAVIGENCIA",dateFormat.format(cotizacionventas.getFechavigencia() ) ); 
			initialValues.put("DURACIONVIGENCIA",cotizacionventas.getDuracionvigencia()); 
			initialValues.put("CONFIRMASTOCK",cotizacionventas.getConfirmastock()); 
			initialValues.put("FECHAVISITA",dateFormat.format(cotizacionventas.getFechavisita() ) ); 
			initialValues.put("IDFPAGO",cotizacionventas.getIdfpago()); 
			initialValues.put("PLAZOENTREGA",cotizacionventas.getPlazoentrega()); 
			initialValues.put("VENTANA",cotizacionventas.getVentana()); 
			initialValues.put("IDVENDEDOR",cotizacionventas.getIdvendedor()); 
			initialValues.put("COMISION",cotizacionventas.getComision()); 
			initialValues.put("IDEMBALAJE",cotizacionventas.getIdembalaje()); 
			initialValues.put("GARANTIA",cotizacionventas.getGarantia()); 
			initialValues.put("IDPREVALORIZA",cotizacionventas.getIdprevaloriza()); 
			initialValues.put("REFERENCIA",cotizacionventas.getReferencia()); 
			initialValues.put("MULTIVENDEDORES",cotizacionventas.getMultivendedores()); 
			initialValues.put("PESOBRUTO",cotizacionventas.getPesobruto()); 
			initialValues.put("PESOTARA",cotizacionventas.getPesotara()); 
			initialValues.put("PESONETO",cotizacionventas.getPesoneto()); 
			initialValues.put("IDTIPOCONTENEDOR",cotizacionventas.getIdtipocontenedor()); 
			initialValues.put("NROCONTENEDOR",cotizacionventas.getNrocontenedor()); 
			initialValues.put("CIUDADORIGEN",cotizacionventas.getCiudadorigen()); 
			initialValues.put("CIUDADDESTINO",cotizacionventas.getCiudaddestino()); 
			initialValues.put("FECHAEMBARQUE",dateFormat.format(cotizacionventas.getFechaembarque() ) ); 
			initialValues.put("FECHAARRIBO",dateFormat.format(cotizacionventas.getFechaarribo() ) ); 
			initialValues.put("IDPUERTOORIGEN",cotizacionventas.getIdpuertoorigen()); 
			initialValues.put("IDPUERTODESTINO",cotizacionventas.getIdpuertodestino()); 
			initialValues.put("PUERTOCIUDADORI",cotizacionventas.getPuertociudadori()); 
			initialValues.put("PUERTOCIUDADDES",cotizacionventas.getPuertociudaddes()); 
			initialValues.put("IDUBIGEO",cotizacionventas.getIdubigeo()); 
			initialValues.put("CONTAINER",cotizacionventas.getContainer()); 
			initialValues.put("IDTIPOPRECIO",cotizacionventas.getIdtipoprecio()); 
			initialValues.put("IDFLETE",cotizacionventas.getIdflete()); 
			initialValues.put("EXONERADO",cotizacionventas.getExonerado()); 
			initialValues.put("ES_PROYECTO",cotizacionventas.getEs_proyecto()); 
			initialValues.put("SMFCRED",cotizacionventas.getSmfcred()); 
			initialValues.put("SMFVENC",cotizacionventas.getSmfvenc()); 
			initialValues.put("IDUNIDADNEGOCIO",cotizacionventas.getIdunidadnegocio()); 
			initialValues.put("IDSUBUNIDADNEGOCIO",cotizacionventas.getIdsubunidadnegocio()); 
			initialValues.put("AREA_HA",cotizacionventas.getArea_ha()); 
			initialValues.put("REDONDEO",cotizacionventas.getRedondeo()); 
			initialValues.put("FLETEUSD",cotizacionventas.getFleteusd()); 
			initialValues.put("IDAGENTECARGA",cotizacionventas.getIdagentecarga()); 
			initialValues.put("IDCONDVENTA",cotizacionventas.getIdcondventa()); 
			initialValues.put("IDLINEAAEREA",cotizacionventas.getIdlineaaerea()); 
			initialValues.put("NRO_FORMA_PAGO",cotizacionventas.getNro_forma_pago()); 
			initialValues.put("NRO_MANUAL",cotizacionventas.getNro_manual()); 
			initialValues.put("IDCLIEPROV_DESTINO",cotizacionventas.getIdclieprov_destino()); 
			initialValues.put("PRIORIDAD",cotizacionventas.getPrioridad()); 
			initialValues.put("NROBUCKIN",cotizacionventas.getNrobuckin()); 
			initialValues.put("CONTENEDOR",cotizacionventas.getContenedor()); 
			initialValues.put("PESO_REAL",cotizacionventas.getPeso_real()); 
			initialValues.put("NRO_VIAJE",cotizacionventas.getNro_viaje()); 
			initialValues.put("NOMBRE_NAVE",cotizacionventas.getNombre_nave()); 
			initialValues.put("IDDOCUMENTO_PF",cotizacionventas.getIddocumento_pf()); 
			initialValues.put("SERIE_PF",cotizacionventas.getSerie_pf()); 
			initialValues.put("NUMERO_PF",cotizacionventas.getNumero_pf()); 
			initialValues.put("FECHA_PF",dateFormat.format(cotizacionventas.getFecha_pf() ) ); 
			initialValues.put("GLOSA_L",cotizacionventas.getGlosa_l()); 
			initialValues.put("AWB",cotizacionventas.getAwb()); 
			initialValues.put("IDCULTIVO",cotizacionventas.getIdcultivo()); 
			initialValues.put("IDVARIEDAD",cotizacionventas.getIdvariedad()); 
			initialValues.put("IDESTADOBANCO",cotizacionventas.getIdestadobanco()); 
			initialValues.put("IDTG30CAMPANIAVEH",cotizacionventas.getIdtg30campaniaveh()); 
			initialValues.put("IDBANCO",cotizacionventas.getIdbanco()); 
			initialValues.put("OFRECIO_SEGURO",cotizacionventas.getOfrecio_seguro()); 
			initialValues.put("COPROPIETARIO",cotizacionventas.getCopropietario()); 
			initialValues.put("IDTIPOCREDITO",cotizacionventas.getIdtipocredito()); 
			initialValues.put("CUOTA",cotizacionventas.getCuota()); 
			initialValues.put("VVENTAPUBLICO_CONIGV",cotizacionventas.getVventapublico_conigv()); 
			initialValues.put("IMPORTEDSCTO1_CONIGV",cotizacionventas.getImportedscto1_conigv()); 
			initialValues.put("IMPORTEDSCTO2_CONIGV",cotizacionventas.getImportedscto2_conigv()); 
			initialValues.put("IMPORTEDSCTO3_CONIGV",cotizacionventas.getImportedscto3_conigv()); 
			initialValues.put("ACCESORIOS_CONIGV",cotizacionventas.getAccesorios_conigv()); 
			initialValues.put("IDCOPROPIETARIO",cotizacionventas.getIdcopropietario()); 
			initialValues.put("IDTG10TIPOCOTIZACION",cotizacionventas.getIdtg10tipocotizacion()); 
			initialValues.put("IDTG30COTVENT_WEB",cotizacionventas.getIdtg30cotvent_web()); 
			initialValues.put("CUOTAINICIAL",cotizacionventas.getCuotainicial()); 
			initialValues.put("IDCTACTE",cotizacionventas.getIdctacte()); 
			resultado = mDb.insert("COTIZACIONVENTAS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Cotizacionventas cotizacionventas,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",cotizacionventas.getIdempresa()) ; 
			initialValues.put("IDCOTIZACIONV",cotizacionventas.getIdcotizacionv()) ; 
			initialValues.put("IDEMISOR",cotizacionventas.getIdemisor()) ; 
			initialValues.put("IDSUCURSAL",cotizacionventas.getIdsucursal()) ; 
			initialValues.put("IDALMACEN",cotizacionventas.getIdalmacen()) ; 
			initialValues.put("IDDOCUMENTO",cotizacionventas.getIddocumento()) ; 
			initialValues.put("PERIODO",cotizacionventas.getPeriodo()) ; 
			initialValues.put("SERIE",cotizacionventas.getSerie()) ; 
			initialValues.put("NUMERO",cotizacionventas.getNumero()) ; 
			initialValues.put("FECHA",dateFormat.format(cotizacionventas.getFecha() ) ) ; 
			initialValues.put("IDCLIEPROV",cotizacionventas.getIdclieprov()) ; 
			initialValues.put("IDPROYECTO",cotizacionventas.getIdproyecto()) ; 
			initialValues.put("TCAMBIO",cotizacionventas.getTcambio()) ; 
			initialValues.put("IDMONEDA",cotizacionventas.getIdmoneda()) ; 
			initialValues.put("GLOSA",cotizacionventas.getGlosa()) ; 
			initialValues.put("IDESTADO",cotizacionventas.getIdestado()) ; 
			initialValues.put("IDESTADOOLD",cotizacionventas.getIdestadoold()) ; 
			initialValues.put("VVENTA",cotizacionventas.getVventa()) ; 
			initialValues.put("IMPUESTO",cotizacionventas.getImpuesto()) ; 
			initialValues.put("IMPUESTO_I",cotizacionventas.getImpuesto_i()) ; 
			initialValues.put("IMPORTE",cotizacionventas.getImporte()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(cotizacionventas.getFechacreacion() ) ) ; 
			initialValues.put("SINCRONIZA",cotizacionventas.getSincroniza()) ; 
			initialValues.put("CONTACTO",cotizacionventas.getContacto()) ; 
			initialValues.put("LUGAR_ENTREGA",cotizacionventas.getLugar_entrega()) ; 
			initialValues.put("SOLICITADO",cotizacionventas.getSolicitado()) ; 
			initialValues.put("TCMONEDA",cotizacionventas.getTcmoneda()) ; 
			initialValues.put("SUBTOTALSINDSCTO",cotizacionventas.getSubtotalsindscto()) ; 
			initialValues.put("DESCUENTO",cotizacionventas.getDescuento()) ; 
			initialValues.put("SUBTOTALCONDSCTO",cotizacionventas.getSubtotalcondscto()) ; 
			initialValues.put("FECHAVIGENCIA",dateFormat.format(cotizacionventas.getFechavigencia() ) ) ; 
			initialValues.put("DURACIONVIGENCIA",cotizacionventas.getDuracionvigencia()) ; 
			initialValues.put("CONFIRMASTOCK",cotizacionventas.getConfirmastock()) ; 
			initialValues.put("FECHAVISITA",dateFormat.format(cotizacionventas.getFechavisita() ) ) ; 
			initialValues.put("IDFPAGO",cotizacionventas.getIdfpago()) ; 
			initialValues.put("PLAZOENTREGA",cotizacionventas.getPlazoentrega()) ; 
			initialValues.put("VENTANA",cotizacionventas.getVentana()) ; 
			initialValues.put("IDVENDEDOR",cotizacionventas.getIdvendedor()) ; 
			initialValues.put("COMISION",cotizacionventas.getComision()) ; 
			initialValues.put("IDEMBALAJE",cotizacionventas.getIdembalaje()) ; 
			initialValues.put("GARANTIA",cotizacionventas.getGarantia()) ; 
			initialValues.put("IDPREVALORIZA",cotizacionventas.getIdprevaloriza()) ; 
			initialValues.put("REFERENCIA",cotizacionventas.getReferencia()) ; 
			initialValues.put("MULTIVENDEDORES",cotizacionventas.getMultivendedores()) ; 
			initialValues.put("PESOBRUTO",cotizacionventas.getPesobruto()) ; 
			initialValues.put("PESOTARA",cotizacionventas.getPesotara()) ; 
			initialValues.put("PESONETO",cotizacionventas.getPesoneto()) ; 
			initialValues.put("IDTIPOCONTENEDOR",cotizacionventas.getIdtipocontenedor()) ; 
			initialValues.put("NROCONTENEDOR",cotizacionventas.getNrocontenedor()) ; 
			initialValues.put("CIUDADORIGEN",cotizacionventas.getCiudadorigen()) ; 
			initialValues.put("CIUDADDESTINO",cotizacionventas.getCiudaddestino()) ; 
			initialValues.put("FECHAEMBARQUE",dateFormat.format(cotizacionventas.getFechaembarque() ) ) ; 
			initialValues.put("FECHAARRIBO",dateFormat.format(cotizacionventas.getFechaarribo() ) ) ; 
			initialValues.put("IDPUERTOORIGEN",cotizacionventas.getIdpuertoorigen()) ; 
			initialValues.put("IDPUERTODESTINO",cotizacionventas.getIdpuertodestino()) ; 
			initialValues.put("PUERTOCIUDADORI",cotizacionventas.getPuertociudadori()) ; 
			initialValues.put("PUERTOCIUDADDES",cotizacionventas.getPuertociudaddes()) ; 
			initialValues.put("IDUBIGEO",cotizacionventas.getIdubigeo()) ; 
			initialValues.put("CONTAINER",cotizacionventas.getContainer()) ; 
			initialValues.put("IDTIPOPRECIO",cotizacionventas.getIdtipoprecio()) ; 
			initialValues.put("IDFLETE",cotizacionventas.getIdflete()) ; 
			initialValues.put("EXONERADO",cotizacionventas.getExonerado()) ; 
			initialValues.put("ES_PROYECTO",cotizacionventas.getEs_proyecto()) ; 
			initialValues.put("SMFCRED",cotizacionventas.getSmfcred()) ; 
			initialValues.put("SMFVENC",cotizacionventas.getSmfvenc()) ; 
			initialValues.put("IDUNIDADNEGOCIO",cotizacionventas.getIdunidadnegocio()) ; 
			initialValues.put("IDSUBUNIDADNEGOCIO",cotizacionventas.getIdsubunidadnegocio()) ; 
			initialValues.put("AREA_HA",cotizacionventas.getArea_ha()) ; 
			initialValues.put("REDONDEO",cotizacionventas.getRedondeo()) ; 
			initialValues.put("FLETEUSD",cotizacionventas.getFleteusd()) ; 
			initialValues.put("IDAGENTECARGA",cotizacionventas.getIdagentecarga()) ; 
			initialValues.put("IDCONDVENTA",cotizacionventas.getIdcondventa()) ; 
			initialValues.put("IDLINEAAEREA",cotizacionventas.getIdlineaaerea()) ; 
			initialValues.put("NRO_FORMA_PAGO",cotizacionventas.getNro_forma_pago()) ; 
			initialValues.put("NRO_MANUAL",cotizacionventas.getNro_manual()) ; 
			initialValues.put("IDCLIEPROV_DESTINO",cotizacionventas.getIdclieprov_destino()) ; 
			initialValues.put("PRIORIDAD",cotizacionventas.getPrioridad()) ; 
			initialValues.put("NROBUCKIN",cotizacionventas.getNrobuckin()) ; 
			initialValues.put("CONTENEDOR",cotizacionventas.getContenedor()) ; 
			initialValues.put("PESO_REAL",cotizacionventas.getPeso_real()) ; 
			initialValues.put("NRO_VIAJE",cotizacionventas.getNro_viaje()) ; 
			initialValues.put("NOMBRE_NAVE",cotizacionventas.getNombre_nave()) ; 
			initialValues.put("IDDOCUMENTO_PF",cotizacionventas.getIddocumento_pf()) ; 
			initialValues.put("SERIE_PF",cotizacionventas.getSerie_pf()) ; 
			initialValues.put("NUMERO_PF",cotizacionventas.getNumero_pf()) ; 
			initialValues.put("FECHA_PF",dateFormat.format(cotizacionventas.getFecha_pf() ) ) ; 
			initialValues.put("GLOSA_L",cotizacionventas.getGlosa_l()) ; 
			initialValues.put("AWB",cotizacionventas.getAwb()) ; 
			initialValues.put("IDCULTIVO",cotizacionventas.getIdcultivo()) ; 
			initialValues.put("IDVARIEDAD",cotizacionventas.getIdvariedad()) ; 
			initialValues.put("IDESTADOBANCO",cotizacionventas.getIdestadobanco()) ; 
			initialValues.put("IDTG30CAMPANIAVEH",cotizacionventas.getIdtg30campaniaveh()) ; 
			initialValues.put("IDBANCO",cotizacionventas.getIdbanco()) ; 
			initialValues.put("OFRECIO_SEGURO",cotizacionventas.getOfrecio_seguro()) ; 
			initialValues.put("COPROPIETARIO",cotizacionventas.getCopropietario()) ; 
			initialValues.put("IDTIPOCREDITO",cotizacionventas.getIdtipocredito()) ; 
			initialValues.put("CUOTA",cotizacionventas.getCuota()) ; 
			initialValues.put("VVENTAPUBLICO_CONIGV",cotizacionventas.getVventapublico_conigv()) ; 
			initialValues.put("IMPORTEDSCTO1_CONIGV",cotizacionventas.getImportedscto1_conigv()) ; 
			initialValues.put("IMPORTEDSCTO2_CONIGV",cotizacionventas.getImportedscto2_conigv()) ; 
			initialValues.put("IMPORTEDSCTO3_CONIGV",cotizacionventas.getImportedscto3_conigv()) ; 
			initialValues.put("ACCESORIOS_CONIGV",cotizacionventas.getAccesorios_conigv()) ; 
			initialValues.put("IDCOPROPIETARIO",cotizacionventas.getIdcopropietario()) ; 
			initialValues.put("IDTG10TIPOCOTIZACION",cotizacionventas.getIdtg10tipocotizacion()) ; 
			initialValues.put("IDTG30COTVENT_WEB",cotizacionventas.getIdtg30cotvent_web()) ; 
			initialValues.put("CUOTAINICIAL",cotizacionventas.getCuotainicial()) ; 
			initialValues.put("IDCTACTE",cotizacionventas.getIdctacte()) ; 
			resultado = mDb.update("COTIZACIONVENTAS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("COTIZACIONVENTAS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Cotizacionventas> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Cotizacionventas> lista  = new ArrayList<Cotizacionventas>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("COTIZACIONVENTAS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCOTIZACIONV" ,
							 "IDEMISOR" ,
							 "IDSUCURSAL" ,
							 "IDALMACEN" ,
							 "IDDOCUMENTO" ,
							 "PERIODO" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "FECHA" ,
							 "IDCLIEPROV" ,
							 "IDPROYECTO" ,
							 "TCAMBIO" ,
							 "IDMONEDA" ,
							 "GLOSA" ,
							 "IDESTADO" ,
							 "IDESTADOOLD" ,
							 "VVENTA" ,
							 "IMPUESTO" ,
							 "IMPUESTO_I" ,
							 "IMPORTE" ,
							 "FECHACREACION" ,
							 "SINCRONIZA" ,
							 "CONTACTO" ,
							 "LUGAR_ENTREGA" ,
							 "SOLICITADO" ,
							 "TCMONEDA" ,
							 "SUBTOTALSINDSCTO" ,
							 "DESCUENTO" ,
							 "SUBTOTALCONDSCTO" ,
							 "FECHAVIGENCIA" ,
							 "DURACIONVIGENCIA" ,
							 "CONFIRMASTOCK" ,
							 "FECHAVISITA" ,
							 "IDFPAGO" ,
							 "PLAZOENTREGA" ,
							 "VENTANA" ,
							 "IDVENDEDOR" ,
							 "COMISION" ,
							 "IDEMBALAJE" ,
							 "GARANTIA" ,
							 "IDPREVALORIZA" ,
							 "REFERENCIA" ,
							 "MULTIVENDEDORES" ,
							 "PESOBRUTO" ,
							 "PESOTARA" ,
							 "PESONETO" ,
							 "IDTIPOCONTENEDOR" ,
							 "NROCONTENEDOR" ,
							 "CIUDADORIGEN" ,
							 "CIUDADDESTINO" ,
							 "FECHAEMBARQUE" ,
							 "FECHAARRIBO" ,
							 "IDPUERTOORIGEN" ,
							 "IDPUERTODESTINO" ,
							 "PUERTOCIUDADORI" ,
							 "PUERTOCIUDADDES" ,
							 "IDUBIGEO" ,
							 "CONTAINER" ,
							 "IDTIPOPRECIO" ,
							 "IDFLETE" ,
							 "EXONERADO" ,
							 "ES_PROYECTO" ,
							 "SMFCRED" ,
							 "SMFVENC" ,
							 "IDUNIDADNEGOCIO" ,
							 "IDSUBUNIDADNEGOCIO" ,
							 "AREA_HA" ,
							 "REDONDEO" ,
							 "FLETEUSD" ,
							 "IDAGENTECARGA" ,
							 "IDCONDVENTA" ,
							 "IDLINEAAEREA" ,
							 "NRO_FORMA_PAGO" ,
							 "NRO_MANUAL" ,
							 "IDCLIEPROV_DESTINO" ,
							 "PRIORIDAD" ,
							 "NROBUCKIN" ,
							 "CONTENEDOR" ,
							 "PESO_REAL" ,
							 "NRO_VIAJE" ,
							 "NOMBRE_NAVE" ,
							 "IDDOCUMENTO_PF" ,
							 "SERIE_PF" ,
							 "NUMERO_PF" ,
							 "FECHA_PF" ,
							 "GLOSA_L" ,
							 "AWB" ,
							 "IDCULTIVO" ,
							 "IDVARIEDAD" ,
							 "IDESTADOBANCO" ,
							 "IDTG30CAMPANIAVEH" ,
							 "IDBANCO" ,
							 "OFRECIO_SEGURO" ,
							 "COPROPIETARIO" ,
							 "IDTIPOCREDITO" ,
							 "CUOTA" ,
							 "VVENTAPUBLICO_CONIGV" ,
							 "IMPORTEDSCTO1_CONIGV" ,
							 "IMPORTEDSCTO2_CONIGV" ,
							 "IMPORTEDSCTO3_CONIGV" ,
							 "ACCESORIOS_CONIGV" ,
							 "IDCOPROPIETARIO" ,
							 "IDTG10TIPOCOTIZACION" ,
							 "IDTG30COTVENT_WEB" ,
							 "CUOTAINICIAL" ,
							 "IDCTACTE" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Cotizacionventas cotizacionventas = new Cotizacionventas() ;
					cotizacionventas.setIdempresa(cur.getString(j++));
					cotizacionventas.setIdcotizacionv(cur.getString(j++));
					cotizacionventas.setIdemisor(cur.getString(j++));
					cotizacionventas.setIdsucursal(cur.getString(j++));
					cotizacionventas.setIdalmacen(cur.getString(j++));
					cotizacionventas.setIddocumento(cur.getString(j++));
					cotizacionventas.setPeriodo(cur.getString(j++));
					cotizacionventas.setSerie(cur.getString(j++));
					cotizacionventas.setNumero(cur.getString(j++));
					cotizacionventas.setFecha(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setIdclieprov(cur.getString(j++));
					cotizacionventas.setIdproyecto(cur.getString(j++));
					cotizacionventas.setTcambio(cur.getDouble(j++));
					cotizacionventas.setIdmoneda(cur.getString(j++));
					cotizacionventas.setGlosa(cur.getString(j++));
					cotizacionventas.setIdestado(cur.getString(j++));
					cotizacionventas.setIdestadoold(cur.getString(j++));
					cotizacionventas.setVventa(cur.getDouble(j++));
					cotizacionventas.setImpuesto(cur.getDouble(j++));
					cotizacionventas.setImpuesto_i(cur.getDouble(j++));
					cotizacionventas.setImporte(cur.getDouble(j++));
					cotizacionventas.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setSincroniza(cur.getString(j++));
					cotizacionventas.setContacto(cur.getString(j++));
					cotizacionventas.setLugar_entrega(cur.getString(j++));
					cotizacionventas.setSolicitado(cur.getString(j++));
					cotizacionventas.setTcmoneda(cur.getDouble(j++));
					cotizacionventas.setSubtotalsindscto(cur.getDouble(j++));
					cotizacionventas.setDescuento(cur.getDouble(j++));
					cotizacionventas.setSubtotalcondscto(cur.getDouble(j++));
					cotizacionventas.setFechavigencia(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setDuracionvigencia(cur.getDouble(j++));
					cotizacionventas.setConfirmastock(cur.getDouble(j++));
					cotizacionventas.setFechavisita(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setIdfpago(cur.getString(j++));
					cotizacionventas.setPlazoentrega(cur.getString(j++));
					cotizacionventas.setVentana(cur.getString(j++));
					cotizacionventas.setIdvendedor(cur.getString(j++));
					cotizacionventas.setComision(cur.getDouble(j++));
					cotizacionventas.setIdembalaje(cur.getString(j++));
					cotizacionventas.setGarantia(cur.getString(j++));
					cotizacionventas.setIdprevaloriza(cur.getString(j++));
					cotizacionventas.setReferencia(cur.getString(j++));
					cotizacionventas.setMultivendedores(cur.getDouble(j++));
					cotizacionventas.setPesobruto(cur.getDouble(j++));
					cotizacionventas.setPesotara(cur.getDouble(j++));
					cotizacionventas.setPesoneto(cur.getDouble(j++));
					cotizacionventas.setIdtipocontenedor(cur.getString(j++));
					cotizacionventas.setNrocontenedor(cur.getString(j++));
					cotizacionventas.setCiudadorigen(cur.getString(j++));
					cotizacionventas.setCiudaddestino(cur.getString(j++));
					cotizacionventas.setFechaembarque(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setFechaarribo(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setIdpuertoorigen(cur.getString(j++));
					cotizacionventas.setIdpuertodestino(cur.getString(j++));
					cotizacionventas.setPuertociudadori(cur.getString(j++));
					cotizacionventas.setPuertociudaddes(cur.getString(j++));
					cotizacionventas.setIdubigeo(cur.getString(j++));
					cotizacionventas.setContainer(cur.getString(j++));
					cotizacionventas.setIdtipoprecio(cur.getString(j++));
					cotizacionventas.setIdflete(cur.getString(j++));
					cotizacionventas.setExonerado(cur.getDouble(j++));
					cotizacionventas.setEs_proyecto(cur.getDouble(j++));
					cotizacionventas.setSmfcred(cur.getString(j++));
					cotizacionventas.setSmfvenc(cur.getString(j++));
					cotizacionventas.setIdunidadnegocio(cur.getString(j++));
					cotizacionventas.setIdsubunidadnegocio(cur.getString(j++));
					cotizacionventas.setArea_ha(cur.getDouble(j++));
					cotizacionventas.setRedondeo(cur.getDouble(j++));
					cotizacionventas.setFleteusd(cur.getDouble(j++));
					cotizacionventas.setIdagentecarga(cur.getString(j++));
					cotizacionventas.setIdcondventa(cur.getString(j++));
					cotizacionventas.setIdlineaaerea(cur.getString(j++));
					cotizacionventas.setNro_forma_pago(cur.getString(j++));
					cotizacionventas.setNro_manual(cur.getString(j++));
					cotizacionventas.setIdclieprov_destino(cur.getString(j++));
					cotizacionventas.setPrioridad(cur.getInt(j++));
					cotizacionventas.setNrobuckin(cur.getString(j++));
					cotizacionventas.setContenedor(cur.getString(j++));
					cotizacionventas.setPeso_real(cur.getDouble(j++));
					cotizacionventas.setNro_viaje(cur.getString(j++));
					cotizacionventas.setNombre_nave(cur.getString(j++));
					cotizacionventas.setIddocumento_pf(cur.getString(j++));
					cotizacionventas.setSerie_pf(cur.getString(j++));
					cotizacionventas.setNumero_pf(cur.getString(j++));
					cotizacionventas.setFecha_pf(dateFormat.parse(cur.getString(j++)) );
					cotizacionventas.setGlosa_l(cur.getString(j++));
					cotizacionventas.setAwb(cur.getString(j++));
					cotizacionventas.setIdcultivo(cur.getString(j++));
					cotizacionventas.setIdvariedad(cur.getString(j++));
					cotizacionventas.setIdestadobanco(cur.getString(j++));
					cotizacionventas.setIdtg30campaniaveh(cur.getInt(j++));
					cotizacionventas.setIdbanco(cur.getString(j++));
					cotizacionventas.setOfrecio_seguro(cur.getString(j++));
					cotizacionventas.setCopropietario(cur.getDouble(j++));
					cotizacionventas.setIdtipocredito(cur.getString(j++));
					cotizacionventas.setCuota(cur.getString(j++));
					cotizacionventas.setVventapublico_conigv(cur.getDouble(j++));
					cotizacionventas.setImportedscto1_conigv(cur.getDouble(j++));
					cotizacionventas.setImportedscto2_conigv(cur.getDouble(j++));
					cotizacionventas.setImportedscto3_conigv(cur.getDouble(j++));
					cotizacionventas.setAccesorios_conigv(cur.getDouble(j++));
					cotizacionventas.setIdcopropietario(cur.getString(j++));
					cotizacionventas.setIdtg10tipocotizacion(cur.getString(j++));
					cotizacionventas.setIdtg30cotvent_web(cur.getInt(j++));
					cotizacionventas.setCuotainicial(cur.getDouble(j++));
					cotizacionventas.setIdctacte(cur.getString(j++));

					lista.add(cotizacionventas); 
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