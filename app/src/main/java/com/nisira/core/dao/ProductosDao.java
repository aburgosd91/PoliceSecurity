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

public class ProductosDao extends BaseDao<Productos> {
	public ProductosDao() {
		super(Productos.class);
	}
	public ProductosDao(boolean usaCnBase) throws Exception {
		super(Productos.class, usaCnBase);
	}
	public void mezclarLocal(Productos obj)throws Exception{
		List<Productos> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDPRODUCTO))=?",obj.getIdempresa().trim(),obj.getIdproducto().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public Boolean insert(Productos productos) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",productos.getIdempresa()); 
			initialValues.put("IDPRODUCTO",productos.getIdproducto()); 
			initialValues.put("ARANCELES",productos.getAranceles()); 
			initialValues.put("EN_MAQUINA",productos.getEn_maquina()); 
			initialValues.put("ES_DESCARTE",productos.getEs_descarte()); 
			initialValues.put("ES_TERMINADO",productos.getEs_terminado()); 
			initialValues.put("IDTERMINADO",productos.getIdterminado()); 
			initialValues.put("IDSUBGRUPO",productos.getIdsubgrupo()); 
			initialValues.put("IDGRUPO",productos.getIdgrupo()); 
			initialValues.put("IDALGORITMO",productos.getIdalgoritmo()); 
			initialValues.put("PARA_EXPORTACION",productos.getPara_exportacion()); 
			initialValues.put("PARA_VENTA",productos.getPara_venta()); 
			initialValues.put("PARA_CONSERVA",productos.getPara_conserva()); 
			initialValues.put("PIDE_LOTE",productos.getPide_lote()); 
			initialValues.put("PIDE_SERIE",productos.getPide_serie()); 
			initialValues.put("ES_AFECTO",productos.getEs_afecto()); 
			initialValues.put("TIEMPOREPOSICION",productos.getTiemporeposicion()); 
			initialValues.put("CARACTERISTICAS",productos.getCaracteristicas()); 
			initialValues.put("ES_COMPUESTO",productos.getEs_compuesto()); 
			initialValues.put("DESCRIPCION",productos.getDescripcion()); 
			initialValues.put("DESCRIPCION1",productos.getDescripcion1()); 
			initialValues.put("ES_EXONERADO",productos.getEs_exonerado()); 
			initialValues.put("FOTO",productos.getFoto()); 
			initialValues.put("IDMEDIDA",productos.getIdmedida()); 
			initialValues.put("PESO",productos.getPeso()); 
			initialValues.put("REGIMEN_AGRARIO",productos.getRegimen_agrario()); 
			initialValues.put("VOLUMEN",productos.getVolumen()); 
			initialValues.put("LONGITUD",productos.getLongitud()); 
			initialValues.put("TIPO_PUNTA",productos.getTipo_punta()); 
			initialValues.put("DIAMETRO",productos.getDiametro()); 
			initialValues.put("ES_APROVECHABLE",productos.getEs_aprovechable()); 
			initialValues.put("NOMBRE_COMERCIAL",productos.getNombre_comercial()); 
			initialValues.put("IDMARCA",productos.getIdmarca()); 
			initialValues.put("IDPARTIDA",productos.getIdpartida()); 
			initialValues.put("IDCOLOR",productos.getIdcolor()); 
			initialValues.put("IDINSUMO",productos.getIdinsumo()); 
			initialValues.put("PIDE_ESTADO",productos.getPide_estado()); 
			initialValues.put("IDPRODUCTO2",productos.getIdproducto2()); 
			initialValues.put("ESTADO",productos.getEstado()); 
			initialValues.put("SINCRONIZA",productos.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(productos.getFechacreacion() ) ); 
			initialValues.put("REVISADO",productos.getRevisado()); 
			initialValues.put("IDMODELO",productos.getIdmodelo()); 
			initialValues.put("GENERA_SERIE",productos.getGenera_serie()); 
			initialValues.put("ES_SERVICIO",productos.getEs_servicio()); 
			initialValues.put("HORAS_STD",productos.getHoras_std()); 
			initialValues.put("IDDESCUENTO",productos.getIddescuento()); 
			initialValues.put("FACTORREPOSICION",productos.getFactorreposicion()); 
			initialValues.put("IDUBICACION",productos.getIdubicacion()); 
			initialValues.put("ES_NEUMATICO",productos.getEs_neumatico()); 
			initialValues.put("PROF_COCADA",productos.getProf_cocada()); 
			initialValues.put("PRES_MONTAJE",productos.getPres_montaje()); 
			initialValues.put("IDTIPOPRODUCTO",productos.getIdtipoproducto()); 
			initialValues.put("ES_TERCERO",productos.getEs_tercero()); 
			initialValues.put("ES_KIT",productos.getEs_kit()); 
			initialValues.put("ES_MERMA",productos.getEs_merma()); 
			initialValues.put("ES_ENSAMBLADO",productos.getEs_ensamblado()); 
			initialValues.put("CODIGOSAP",productos.getCodigosap()); 
			initialValues.put("ES_GANADO",productos.getEs_ganado()); 
			initialValues.put("ES_PPROCESO",productos.getEs_pproceso()); 
			initialValues.put("ES_MATPRIMA",productos.getEs_matprima()); 
			initialValues.put("ES_CONGELADO",productos.getEs_congelado()); 
			initialValues.put("ES_FRESCO",productos.getEs_fresco()); 
			initialValues.put("IDTALLA",productos.getIdtalla()); 
			initialValues.put("UGG",productos.getUgg()); 
			initialValues.put("IDCCOSTO_GANADO",productos.getIdccosto_ganado()); 
			initialValues.put("IDCLASECCOSTO",productos.getIdclaseccosto()); 
			initialValues.put("ES_ACTIVO",productos.getEs_activo()); 
			initialValues.put("IDTIPOACTIVO",productos.getIdtipoactivo()); 
			initialValues.put("IDCCOSTO_ACTIVO",productos.getIdccosto_activo()); 
			initialValues.put("IDCTA_ACTIVO",productos.getIdcta_activo()); 
			initialValues.put("IDCTA_DEPREC",productos.getIdcta_deprec()); 
			initialValues.put("ES_DETRACCION",productos.getEs_detraccion()); 
			initialValues.put("IDTIPODETRA",productos.getIdtipodetra()); 
			initialValues.put("ES_DRAWBACK",productos.getEs_drawback()); 
			initialValues.put("IDNOMENCLATURA",productos.getIdnomenclatura()); 
			initialValues.put("PARA_FRESCO",productos.getPara_fresco()); 
			initialValues.put("IDCULTIVO",productos.getIdcultivo()); 
			initialValues.put("IDVARIEDAD",productos.getIdvariedad()); 
			initialValues.put("ES_INDDRAWBACK",productos.getEs_inddrawback()); 
			initialValues.put("PESONETO",productos.getPesoneto()); 
			initialValues.put("TIPO_ISC",productos.getTipo_isc()); 
			initialValues.put("VALOR_ISC",productos.getValor_isc()); 
			initialValues.put("EQUIV_ISC",productos.getEquiv_isc()); 
			initialValues.put("KG_CAJAS",productos.getKg_cajas()); 
			initialValues.put("PIDE_LOTE_CCOSTO",productos.getPide_lote_ccosto()); 
			initialValues.put("IDMEDIDA2",productos.getIdmedida2()); 
			initialValues.put("EXIGE_U2",productos.getExige_u2()); 
			initialValues.put("FACTOR_U2",productos.getFactor_u2()); 
			initialValues.put("PORCEN_MERMA",productos.getPorcen_merma()); 
			initialValues.put("AFECTO_PERCEPCION",productos.getAfecto_percepcion()); 
			initialValues.put("IDCONDICION",productos.getIdcondicion()); 
			initialValues.put("UAC",productos.getUac()); 
			initialValues.put("UM2_FORMULA",productos.getUm2_formula()); 
			initialValues.put("TIPO_PROCESO",productos.getTipo_proceso()); 
			initialValues.put("IDTIPORET",productos.getIdtiporet()); 
			initialValues.put("AFECTO_RETENCION",productos.getAfecto_retencion()); 
			initialValues.put("TIPOPRODUCTO",productos.getTipoproducto()); 
			initialValues.put("TIPO_PROCESO_ORIGEN",productos.getTipo_proceso_origen()); 
			initialValues.put("IDPRODUCTO_EQUIV",productos.getIdproducto_equiv()); 
			initialValues.put("CESTANDAR_MOF",productos.getCestandar_mof()); 
			initialValues.put("CESTANDAR_MEX",productos.getCestandar_mex()); 
			initialValues.put("FACTORCOSTO",productos.getFactorcosto()); 
			initialValues.put("ES_VEHICULO",productos.getEs_vehiculo()); 
			initialValues.put("RETIQUETA",productos.getRetiqueta()); 
			initialValues.put("RTECNICA",productos.getRtecnica()); 
			initialValues.put("RSEGURIDAD",productos.getRseguridad()); 
			initialValues.put("RCALIDAD",productos.getRcalidad()); 
			initialValues.put("ETIQUETA",productos.getEtiqueta()); 
			initialValues.put("TECNICA",productos.getTecnica()); 
			initialValues.put("SEGURIDAD",productos.getSeguridad()); 
			initialValues.put("CALIDAD",productos.getCalidad()); 
			initialValues.put("PROHIBIDO",productos.getProhibido()); 
			initialValues.put("DESCRIPCION2",productos.getDescripcion2()); 
			initialValues.put("PESO_TARA",productos.getPeso_tara()); 
			initialValues.put("ES_HERRAMIENTA",productos.getEs_herramienta()); 
			initialValues.put("REGLA_OT",productos.getRegla_ot()); 
			initialValues.put("IMPORTADO_EXTERNO",productos.getImportado_externo()); 
			initialValues.put("IDTIPOCATALOGO",productos.getIdtipocatalogo()); 
			initialValues.put("ES_CONVERSION_GLP",productos.getEs_conversion_glp()); 
			initialValues.put("NO_DECLARA_LE",productos.getNo_declara_le()); 
			initialValues.put("PARA_DECLARACION",productos.getPara_declaracion()); 
			initialValues.put("CALIBREMM",productos.getCalibremm()); 
			initialValues.put("IDPRESENTACION",productos.getIdpresentacion()); 
			initialValues.put("LARGO",productos.getLargo()); 
			initialValues.put("UNDXPHL",productos.getUndxphl()); 
			initialValues.put("PORCENT_PESO_PERMITIDO",productos.getPorcent_peso_permitido()); 
			initialValues.put("COD_EQUIVALENTE",productos.getCod_equivalente()); 
			initialValues.put("COD_GTIN",productos.getCod_gtin()); 
			initialValues.put("ES_GENERICO",productos.getEs_generico()); 
			initialValues.put("FACTORCE",productos.getFactorce()); 
			initialValues.put("IDCCOSTO_PT",productos.getIdccosto_pt()); 
			initialValues.put("IDGRUPO2",productos.getIdgrupo2()); 
			initialValues.put("ES_ACCESORIO",productos.getEs_accesorio()); 
			initialValues.put("VALORIZA_RESULTADO",productos.getValoriza_resultado()); 
			initialValues.put("IDCATALOGO_UNICO",productos.getIdcatalogo_unico()); 
			initialValues.put("IDPRODUCTO_SPRING",productos.getIdproducto_spring()); 
			initialValues.put("ES_PRODUCCION_CC",productos.getEs_produccion_cc()); 
			initialValues.put("IDCONSUMIDOR",productos.getIdconsumidor()); 
			initialValues.put("ES_HOJAFRESCA",productos.getEs_hojafresca()); 
			initialValues.put("ES_PLANTAFRESCA",productos.getEs_plantafresca()); 
			initialValues.put("PARTNUMBER",productos.getPartnumber()); 
			initialValues.put("IDPRODUCTO_AGRITASK",productos.getIdproducto_agritask()); 
			initialValues.put("MAS_CCOSTO",productos.getMas_ccosto()); 
			initialValues.put("IDNOMBRECOMERCIAL",productos.getIdnombrecomercial()); 
			initialValues.put("IDCUENTA_PTR",productos.getIdcuenta_ptr()); 
			initialValues.put("IDCUENTA_VPT",productos.getIdcuenta_vpt()); 
			initialValues.put("IDCUENTA_CIC",productos.getIdcuenta_cic()); 
			initialValues.put("VENTANA",productos.getVentana()); 
			initialValues.put("PIDE_INFORME_ACTIVO",productos.getPide_informe_activo()); 
			initialValues.put("POR_ISC",productos.getPor_isc()); 
			initialValues.put("IDCONSUMIDOR_O",productos.getIdconsumidor_o()); 
			initialValues.put("IDCLIEPROV",productos.getIdclieprov()); 
			initialValues.put("ES_PESADA",productos.getEs_pesada()); 
			initialValues.put("ES_FISCALIZADO",productos.getEs_fiscalizado()); 
			initialValues.put("CONTROL_CALIDAD",productos.getControl_calidad()); 
			resultado = mDb.insert("PRODUCTOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Productos productos,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",productos.getIdempresa()) ; 
			initialValues.put("IDPRODUCTO",productos.getIdproducto()) ; 
			initialValues.put("ARANCELES",productos.getAranceles()) ; 
			initialValues.put("EN_MAQUINA",productos.getEn_maquina()) ; 
			initialValues.put("ES_DESCARTE",productos.getEs_descarte()) ; 
			initialValues.put("ES_TERMINADO",productos.getEs_terminado()) ; 
			initialValues.put("IDTERMINADO",productos.getIdterminado()) ; 
			initialValues.put("IDSUBGRUPO",productos.getIdsubgrupo()) ; 
			initialValues.put("IDGRUPO",productos.getIdgrupo()) ; 
			initialValues.put("IDALGORITMO",productos.getIdalgoritmo()) ; 
			initialValues.put("PARA_EXPORTACION",productos.getPara_exportacion()) ; 
			initialValues.put("PARA_VENTA",productos.getPara_venta()) ; 
			initialValues.put("PARA_CONSERVA",productos.getPara_conserva()) ; 
			initialValues.put("PIDE_LOTE",productos.getPide_lote()) ; 
			initialValues.put("PIDE_SERIE",productos.getPide_serie()) ; 
			initialValues.put("ES_AFECTO",productos.getEs_afecto()) ; 
			initialValues.put("TIEMPOREPOSICION",productos.getTiemporeposicion()) ; 
			initialValues.put("CARACTERISTICAS",productos.getCaracteristicas()) ; 
			initialValues.put("ES_COMPUESTO",productos.getEs_compuesto()) ; 
			initialValues.put("DESCRIPCION",productos.getDescripcion()) ; 
			initialValues.put("DESCRIPCION1",productos.getDescripcion1()) ; 
			initialValues.put("ES_EXONERADO",productos.getEs_exonerado()) ; 
			initialValues.put("FOTO",productos.getFoto()) ; 
			initialValues.put("IDMEDIDA",productos.getIdmedida()) ; 
			initialValues.put("PESO",productos.getPeso()) ; 
			initialValues.put("REGIMEN_AGRARIO",productos.getRegimen_agrario()) ; 
			initialValues.put("VOLUMEN",productos.getVolumen()) ; 
			initialValues.put("LONGITUD",productos.getLongitud()) ; 
			initialValues.put("TIPO_PUNTA",productos.getTipo_punta()) ; 
			initialValues.put("DIAMETRO",productos.getDiametro()) ; 
			initialValues.put("ES_APROVECHABLE",productos.getEs_aprovechable()) ; 
			initialValues.put("NOMBRE_COMERCIAL",productos.getNombre_comercial()) ; 
			initialValues.put("IDMARCA",productos.getIdmarca()) ; 
			initialValues.put("IDPARTIDA",productos.getIdpartida()) ; 
			initialValues.put("IDCOLOR",productos.getIdcolor()) ; 
			initialValues.put("IDINSUMO",productos.getIdinsumo()) ; 
			initialValues.put("PIDE_ESTADO",productos.getPide_estado()) ; 
			initialValues.put("IDPRODUCTO2",productos.getIdproducto2()) ; 
			initialValues.put("ESTADO",productos.getEstado()) ; 
			initialValues.put("SINCRONIZA",productos.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(productos.getFechacreacion() ) ) ; 
			initialValues.put("REVISADO",productos.getRevisado()) ; 
			initialValues.put("IDMODELO",productos.getIdmodelo()) ; 
			initialValues.put("GENERA_SERIE",productos.getGenera_serie()) ; 
			initialValues.put("ES_SERVICIO",productos.getEs_servicio()) ; 
			initialValues.put("HORAS_STD",productos.getHoras_std()) ; 
			initialValues.put("IDDESCUENTO",productos.getIddescuento()) ; 
			initialValues.put("FACTORREPOSICION",productos.getFactorreposicion()) ; 
			initialValues.put("IDUBICACION",productos.getIdubicacion()) ; 
			initialValues.put("ES_NEUMATICO",productos.getEs_neumatico()) ; 
			initialValues.put("PROF_COCADA",productos.getProf_cocada()) ; 
			initialValues.put("PRES_MONTAJE",productos.getPres_montaje()) ; 
			initialValues.put("IDTIPOPRODUCTO",productos.getIdtipoproducto()) ; 
			initialValues.put("ES_TERCERO",productos.getEs_tercero()) ; 
			initialValues.put("ES_KIT",productos.getEs_kit()) ; 
			initialValues.put("ES_MERMA",productos.getEs_merma()) ; 
			initialValues.put("ES_ENSAMBLADO",productos.getEs_ensamblado()) ; 
			initialValues.put("CODIGOSAP",productos.getCodigosap()) ; 
			initialValues.put("ES_GANADO",productos.getEs_ganado()) ; 
			initialValues.put("ES_PPROCESO",productos.getEs_pproceso()) ; 
			initialValues.put("ES_MATPRIMA",productos.getEs_matprima()) ; 
			initialValues.put("ES_CONGELADO",productos.getEs_congelado()) ; 
			initialValues.put("ES_FRESCO",productos.getEs_fresco()) ; 
			initialValues.put("IDTALLA",productos.getIdtalla()) ; 
			initialValues.put("UGG",productos.getUgg()) ; 
			initialValues.put("IDCCOSTO_GANADO",productos.getIdccosto_ganado()) ; 
			initialValues.put("IDCLASECCOSTO",productos.getIdclaseccosto()) ; 
			initialValues.put("ES_ACTIVO",productos.getEs_activo()) ; 
			initialValues.put("IDTIPOACTIVO",productos.getIdtipoactivo()) ; 
			initialValues.put("IDCCOSTO_ACTIVO",productos.getIdccosto_activo()) ; 
			initialValues.put("IDCTA_ACTIVO",productos.getIdcta_activo()) ; 
			initialValues.put("IDCTA_DEPREC",productos.getIdcta_deprec()) ; 
			initialValues.put("ES_DETRACCION",productos.getEs_detraccion()) ; 
			initialValues.put("IDTIPODETRA",productos.getIdtipodetra()) ; 
			initialValues.put("ES_DRAWBACK",productos.getEs_drawback()) ; 
			initialValues.put("IDNOMENCLATURA",productos.getIdnomenclatura()) ; 
			initialValues.put("PARA_FRESCO",productos.getPara_fresco()) ; 
			initialValues.put("IDCULTIVO",productos.getIdcultivo()) ; 
			initialValues.put("IDVARIEDAD",productos.getIdvariedad()) ; 
			initialValues.put("ES_INDDRAWBACK",productos.getEs_inddrawback()) ; 
			initialValues.put("PESONETO",productos.getPesoneto()) ; 
			initialValues.put("TIPO_ISC",productos.getTipo_isc()) ; 
			initialValues.put("VALOR_ISC",productos.getValor_isc()) ; 
			initialValues.put("EQUIV_ISC",productos.getEquiv_isc()) ; 
			initialValues.put("KG_CAJAS",productos.getKg_cajas()) ; 
			initialValues.put("PIDE_LOTE_CCOSTO",productos.getPide_lote_ccosto()) ; 
			initialValues.put("IDMEDIDA2",productos.getIdmedida2()) ; 
			initialValues.put("EXIGE_U2",productos.getExige_u2()) ; 
			initialValues.put("FACTOR_U2",productos.getFactor_u2()) ; 
			initialValues.put("PORCEN_MERMA",productos.getPorcen_merma()) ; 
			initialValues.put("AFECTO_PERCEPCION",productos.getAfecto_percepcion()) ; 
			initialValues.put("IDCONDICION",productos.getIdcondicion()) ; 
			initialValues.put("UAC",productos.getUac()) ; 
			initialValues.put("UM2_FORMULA",productos.getUm2_formula()) ; 
			initialValues.put("TIPO_PROCESO",productos.getTipo_proceso()) ; 
			initialValues.put("IDTIPORET",productos.getIdtiporet()) ; 
			initialValues.put("AFECTO_RETENCION",productos.getAfecto_retencion()) ; 
			initialValues.put("TIPOPRODUCTO",productos.getTipoproducto()) ; 
			initialValues.put("TIPO_PROCESO_ORIGEN",productos.getTipo_proceso_origen()) ; 
			initialValues.put("IDPRODUCTO_EQUIV",productos.getIdproducto_equiv()) ; 
			initialValues.put("CESTANDAR_MOF",productos.getCestandar_mof()) ; 
			initialValues.put("CESTANDAR_MEX",productos.getCestandar_mex()) ; 
			initialValues.put("FACTORCOSTO",productos.getFactorcosto()) ; 
			initialValues.put("ES_VEHICULO",productos.getEs_vehiculo()) ; 
			initialValues.put("RETIQUETA",productos.getRetiqueta()) ; 
			initialValues.put("RTECNICA",productos.getRtecnica()) ; 
			initialValues.put("RSEGURIDAD",productos.getRseguridad()) ; 
			initialValues.put("RCALIDAD",productos.getRcalidad()) ; 
			initialValues.put("ETIQUETA",productos.getEtiqueta()) ; 
			initialValues.put("TECNICA",productos.getTecnica()) ; 
			initialValues.put("SEGURIDAD",productos.getSeguridad()) ; 
			initialValues.put("CALIDAD",productos.getCalidad()) ; 
			initialValues.put("PROHIBIDO",productos.getProhibido()) ; 
			initialValues.put("DESCRIPCION2",productos.getDescripcion2()) ; 
			initialValues.put("PESO_TARA",productos.getPeso_tara()) ; 
			initialValues.put("ES_HERRAMIENTA",productos.getEs_herramienta()) ; 
			initialValues.put("REGLA_OT",productos.getRegla_ot()) ; 
			initialValues.put("IMPORTADO_EXTERNO",productos.getImportado_externo()) ; 
			initialValues.put("IDTIPOCATALOGO",productos.getIdtipocatalogo()) ; 
			initialValues.put("ES_CONVERSION_GLP",productos.getEs_conversion_glp()) ; 
			initialValues.put("NO_DECLARA_LE",productos.getNo_declara_le()) ; 
			initialValues.put("PARA_DECLARACION",productos.getPara_declaracion()) ; 
			initialValues.put("CALIBREMM",productos.getCalibremm()) ; 
			initialValues.put("IDPRESENTACION",productos.getIdpresentacion()) ; 
			initialValues.put("LARGO",productos.getLargo()) ; 
			initialValues.put("UNDXPHL",productos.getUndxphl()) ; 
			initialValues.put("PORCENT_PESO_PERMITIDO",productos.getPorcent_peso_permitido()) ; 
			initialValues.put("COD_EQUIVALENTE",productos.getCod_equivalente()) ; 
			initialValues.put("COD_GTIN",productos.getCod_gtin()) ; 
			initialValues.put("ES_GENERICO",productos.getEs_generico()) ; 
			initialValues.put("FACTORCE",productos.getFactorce()) ; 
			initialValues.put("IDCCOSTO_PT",productos.getIdccosto_pt()) ; 
			initialValues.put("IDGRUPO2",productos.getIdgrupo2()) ; 
			initialValues.put("ES_ACCESORIO",productos.getEs_accesorio()) ; 
			initialValues.put("VALORIZA_RESULTADO",productos.getValoriza_resultado()) ; 
			initialValues.put("IDCATALOGO_UNICO",productos.getIdcatalogo_unico()) ; 
			initialValues.put("IDPRODUCTO_SPRING",productos.getIdproducto_spring()) ; 
			initialValues.put("ES_PRODUCCION_CC",productos.getEs_produccion_cc()) ; 
			initialValues.put("IDCONSUMIDOR",productos.getIdconsumidor()) ; 
			initialValues.put("ES_HOJAFRESCA",productos.getEs_hojafresca()) ; 
			initialValues.put("ES_PLANTAFRESCA",productos.getEs_plantafresca()) ; 
			initialValues.put("PARTNUMBER",productos.getPartnumber()) ; 
			initialValues.put("IDPRODUCTO_AGRITASK",productos.getIdproducto_agritask()) ; 
			initialValues.put("MAS_CCOSTO",productos.getMas_ccosto()) ; 
			initialValues.put("IDNOMBRECOMERCIAL",productos.getIdnombrecomercial()) ; 
			initialValues.put("IDCUENTA_PTR",productos.getIdcuenta_ptr()) ; 
			initialValues.put("IDCUENTA_VPT",productos.getIdcuenta_vpt()) ; 
			initialValues.put("IDCUENTA_CIC",productos.getIdcuenta_cic()) ; 
			initialValues.put("VENTANA",productos.getVentana()) ; 
			initialValues.put("PIDE_INFORME_ACTIVO",productos.getPide_informe_activo()) ; 
			initialValues.put("POR_ISC",productos.getPor_isc()) ; 
			initialValues.put("IDCONSUMIDOR_O",productos.getIdconsumidor_o()) ; 
			initialValues.put("IDCLIEPROV",productos.getIdclieprov()) ; 
			initialValues.put("ES_PESADA",productos.getEs_pesada()) ; 
			initialValues.put("ES_FISCALIZADO",productos.getEs_fiscalizado()) ; 
			initialValues.put("CONTROL_CALIDAD",productos.getControl_calidad()) ; 
			resultado = mDb.update("PRODUCTOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PRODUCTOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Productos> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Productos> lista  = new ArrayList<Productos>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PRODUCTOS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDPRODUCTO" ,
							 "ARANCELES" ,
							 "EN_MAQUINA" ,
							 "ES_DESCARTE" ,
							 "ES_TERMINADO" ,
							 "IDTERMINADO" ,
							 "IDSUBGRUPO" ,
							 "IDGRUPO" ,
							 "IDALGORITMO" ,
							 "PARA_EXPORTACION" ,
							 "PARA_VENTA" ,
							 "PARA_CONSERVA" ,
							 "PIDE_LOTE" ,
							 "PIDE_SERIE" ,
							 "ES_AFECTO" ,
							 "TIEMPOREPOSICION" ,
							 "CARACTERISTICAS" ,
							 "ES_COMPUESTO" ,
							 "DESCRIPCION" ,
							 "DESCRIPCION1" ,
							 "ES_EXONERADO" ,
							 "FOTO" ,
							 "IDMEDIDA" ,
							 "PESO" ,
							 "REGIMEN_AGRARIO" ,
							 "VOLUMEN" ,
							 "LONGITUD" ,
							 "TIPO_PUNTA" ,
							 "DIAMETRO" ,
							 "ES_APROVECHABLE" ,
							 "NOMBRE_COMERCIAL" ,
							 "IDMARCA" ,
							 "IDPARTIDA" ,
							 "IDCOLOR" ,
							 "IDINSUMO" ,
							 "PIDE_ESTADO" ,
							 "IDPRODUCTO2" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "REVISADO" ,
							 "IDMODELO" ,
							 "GENERA_SERIE" ,
							 "ES_SERVICIO" ,
							 "HORAS_STD" ,
							 "IDDESCUENTO" ,
							 "FACTORREPOSICION" ,
							 "IDUBICACION" ,
							 "ES_NEUMATICO" ,
							 "PROF_COCADA" ,
							 "PRES_MONTAJE" ,
							 "IDTIPOPRODUCTO" ,
							 "ES_TERCERO" ,
							 "ES_KIT" ,
							 "ES_MERMA" ,
							 "ES_ENSAMBLADO" ,
							 "CODIGOSAP" ,
							 "ES_GANADO" ,
							 "ES_PPROCESO" ,
							 "ES_MATPRIMA" ,
							 "ES_CONGELADO" ,
							 "ES_FRESCO" ,
							 "IDTALLA" ,
							 "UGG" ,
							 "IDCCOSTO_GANADO" ,
							 "IDCLASECCOSTO" ,
							 "ES_ACTIVO" ,
							 "IDTIPOACTIVO" ,
							 "IDCCOSTO_ACTIVO" ,
							 "IDCTA_ACTIVO" ,
							 "IDCTA_DEPREC" ,
							 "ES_DETRACCION" ,
							 "IDTIPODETRA" ,
							 "ES_DRAWBACK" ,
							 "IDNOMENCLATURA" ,
							 "PARA_FRESCO" ,
							 "IDCULTIVO" ,
							 "IDVARIEDAD" ,
							 "ES_INDDRAWBACK" ,
							 "PESONETO" ,
							 "TIPO_ISC" ,
							 "VALOR_ISC" ,
							 "EQUIV_ISC" ,
							 "KG_CAJAS" ,
							 "PIDE_LOTE_CCOSTO" ,
							 "IDMEDIDA2" ,
							 "EXIGE_U2" ,
							 "FACTOR_U2" ,
							 "PORCEN_MERMA" ,
							 "AFECTO_PERCEPCION" ,
							 "IDCONDICION" ,
							 "UAC" ,
							 "UM2_FORMULA" ,
							 "TIPO_PROCESO" ,
							 "IDTIPORET" ,
							 "AFECTO_RETENCION" ,
							 "TIPOPRODUCTO" ,
							 "TIPO_PROCESO_ORIGEN" ,
							 "IDPRODUCTO_EQUIV" ,
							 "CESTANDAR_MOF" ,
							 "CESTANDAR_MEX" ,
							 "FACTORCOSTO" ,
							 "ES_VEHICULO" ,
							 "RETIQUETA" ,
							 "RTECNICA" ,
							 "RSEGURIDAD" ,
							 "RCALIDAD" ,
							 "ETIQUETA" ,
							 "TECNICA" ,
							 "SEGURIDAD" ,
							 "CALIDAD" ,
							 "PROHIBIDO" ,
							 "DESCRIPCION2" ,
							 "PESO_TARA" ,
							 "ES_HERRAMIENTA" ,
							 "REGLA_OT" ,
							 "IMPORTADO_EXTERNO" ,
							 "IDTIPOCATALOGO" ,
							 "ES_CONVERSION_GLP" ,
							 "NO_DECLARA_LE" ,
							 "PARA_DECLARACION" ,
							 "CALIBREMM" ,
							 "IDPRESENTACION" ,
							 "LARGO" ,
							 "UNDXPHL" ,
							 "PORCENT_PESO_PERMITIDO" ,
							 "COD_EQUIVALENTE" ,
							 "COD_GTIN" ,
							 "ES_GENERICO" ,
							 "FACTORCE" ,
							 "IDCCOSTO_PT" ,
							 "IDGRUPO2" ,
							 "ES_ACCESORIO" ,
							 "VALORIZA_RESULTADO" ,
							 "IDCATALOGO_UNICO" ,
							 "IDPRODUCTO_SPRING" ,
							 "ES_PRODUCCION_CC" ,
							 "IDCONSUMIDOR" ,
							 "ES_HOJAFRESCA" ,
							 "ES_PLANTAFRESCA" ,
							 "PARTNUMBER" ,
							 "IDPRODUCTO_AGRITASK" ,
							 "MAS_CCOSTO" ,
							 "IDNOMBRECOMERCIAL" ,
							 "IDCUENTA_PTR" ,
							 "IDCUENTA_VPT" ,
							 "IDCUENTA_CIC" ,
							 "VENTANA" ,
							 "PIDE_INFORME_ACTIVO" ,
							 "POR_ISC" ,
							 "IDCONSUMIDOR_O" ,
							 "IDCLIEPROV" ,
							 "ES_PESADA" ,
							 "ES_FISCALIZADO" ,
							 "CONTROL_CALIDAD" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Productos productos = new Productos() ;
					productos.setIdempresa(cur.getString(j++));
					productos.setIdproducto(cur.getString(j++));
					productos.setAranceles(cur.getString(j++));
					productos.setEn_maquina(cur.getDouble(j++));
					productos.setEs_descarte(cur.getDouble(j++));
					productos.setEs_terminado(cur.getDouble(j++));
					productos.setIdterminado(cur.getString(j++));
					productos.setIdsubgrupo(cur.getString(j++));
					productos.setIdgrupo(cur.getString(j++));
					productos.setIdalgoritmo(cur.getString(j++));
					productos.setPara_exportacion(cur.getDouble(j++));
					productos.setPara_venta(cur.getDouble(j++));
					productos.setPara_conserva(cur.getDouble(j++));
					productos.setPide_lote(cur.getDouble(j++));
					productos.setPide_serie(cur.getDouble(j++));
					productos.setEs_afecto(cur.getDouble(j++));
					productos.setTiemporeposicion(cur.getDouble(j++));
					productos.setCaracteristicas(cur.getString(j++));
					productos.setEs_compuesto(cur.getDouble(j++));
					productos.setDescripcion(cur.getString(j++));
					productos.setDescripcion1(cur.getString(j++));
					productos.setEs_exonerado(cur.getDouble(j++));
					productos.setFoto(cur.getString(j++));
					productos.setIdmedida(cur.getString(j++));
					productos.setPeso(cur.getDouble(j++));
					productos.setRegimen_agrario(cur.getDouble(j++));
					productos.setVolumen(cur.getDouble(j++));
					productos.setLongitud(cur.getString(j++));
					productos.setTipo_punta(cur.getString(j++));
					productos.setDiametro(cur.getString(j++));
					productos.setEs_aprovechable(cur.getDouble(j++));
					productos.setNombre_comercial(cur.getString(j++));
					productos.setIdmarca(cur.getString(j++));
					productos.setIdpartida(cur.getString(j++));
					productos.setIdcolor(cur.getString(j++));
					productos.setIdinsumo(cur.getString(j++));
					productos.setPide_estado(cur.getDouble(j++));
					productos.setIdproducto2(cur.getString(j++));
					productos.setEstado(cur.getDouble(j++));
					productos.setSincroniza(cur.getString(j++));
					productos.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					productos.setRevisado(cur.getDouble(j++));
					productos.setIdmodelo(cur.getString(j++));
					productos.setGenera_serie(cur.getDouble(j++));
					productos.setEs_servicio(cur.getDouble(j++));
					productos.setHoras_std(cur.getDouble(j++));
					productos.setIddescuento(cur.getString(j++));
					productos.setFactorreposicion(cur.getDouble(j++));
					productos.setIdubicacion(cur.getString(j++));
					productos.setEs_neumatico(cur.getDouble(j++));
					productos.setProf_cocada(cur.getDouble(j++));
					productos.setPres_montaje(cur.getDouble(j++));
					productos.setIdtipoproducto(cur.getString(j++));
					productos.setEs_tercero(cur.getDouble(j++));
					productos.setEs_kit(cur.getDouble(j++));
					productos.setEs_merma(cur.getDouble(j++));
					productos.setEs_ensamblado(cur.getDouble(j++));
					productos.setCodigosap(cur.getString(j++));
					productos.setEs_ganado(cur.getDouble(j++));
					productos.setEs_pproceso(cur.getDouble(j++));
					productos.setEs_matprima(cur.getDouble(j++));
					productos.setEs_congelado(cur.getDouble(j++));
					productos.setEs_fresco(cur.getDouble(j++));
					productos.setIdtalla(cur.getString(j++));
					productos.setUgg(cur.getDouble(j++));
					productos.setIdccosto_ganado(cur.getString(j++));
					productos.setIdclaseccosto(cur.getString(j++));
					productos.setEs_activo(cur.getDouble(j++));
					productos.setIdtipoactivo(cur.getString(j++));
					productos.setIdccosto_activo(cur.getString(j++));
					productos.setIdcta_activo(cur.getString(j++));
					productos.setIdcta_deprec(cur.getString(j++));
					productos.setEs_detraccion(cur.getDouble(j++));
					productos.setIdtipodetra(cur.getString(j++));
					productos.setEs_drawback(cur.getDouble(j++));
					productos.setIdnomenclatura(cur.getString(j++));
					productos.setPara_fresco(cur.getDouble(j++));
					productos.setIdcultivo(cur.getString(j++));
					productos.setIdvariedad(cur.getString(j++));
					productos.setEs_inddrawback(cur.getDouble(j++));
					productos.setPesoneto(cur.getDouble(j++));
					productos.setTipo_isc(cur.getDouble(j++));
					productos.setValor_isc(cur.getDouble(j++));
					productos.setEquiv_isc(cur.getDouble(j++));
					productos.setKg_cajas(cur.getDouble(j++));
					productos.setPide_lote_ccosto(cur.getDouble(j++));
					productos.setIdmedida2(cur.getString(j++));
					productos.setExige_u2(cur.getDouble(j++));
					productos.setFactor_u2(cur.getDouble(j++));
					productos.setPorcen_merma(cur.getDouble(j++));
					productos.setAfecto_percepcion(cur.getDouble(j++));
					productos.setIdcondicion(cur.getString(j++));
					productos.setUac(cur.getInt(j++));
					productos.setUm2_formula(cur.getDouble(j++));
					productos.setTipo_proceso(cur.getString(j++));
					productos.setIdtiporet(cur.getString(j++));
					productos.setAfecto_retencion(cur.getDouble(j++));
					productos.setTipoproducto(cur.getString(j++));
					productos.setTipo_proceso_origen(cur.getString(j++));
					productos.setIdproducto_equiv(cur.getString(j++));
					productos.setCestandar_mof(cur.getDouble(j++));
					productos.setCestandar_mex(cur.getDouble(j++));
					productos.setFactorcosto(cur.getDouble(j++));
					productos.setEs_vehiculo(cur.getDouble(j++));
					productos.setRetiqueta(cur.getString(j++));
					productos.setRtecnica(cur.getString(j++));
					productos.setRseguridad(cur.getString(j++));
					productos.setRcalidad(cur.getString(j++));
					productos.setEtiqueta(cur.getDouble(j++));
					productos.setTecnica(cur.getDouble(j++));
					productos.setSeguridad(cur.getDouble(j++));
					productos.setCalidad(cur.getDouble(j++));
					productos.setProhibido(cur.getDouble(j++));
					productos.setDescripcion2(cur.getString(j++));
					productos.setPeso_tara(cur.getDouble(j++));
					productos.setEs_herramienta(cur.getDouble(j++));
					productos.setRegla_ot(cur.getDouble(j++));
					productos.setImportado_externo(cur.getDouble(j++));
					productos.setIdtipocatalogo(cur.getString(j++));
					productos.setEs_conversion_glp(cur.getDouble(j++));
					productos.setNo_declara_le(cur.getDouble(j++));
					productos.setPara_declaracion(cur.getDouble(j++));
					productos.setCalibremm(cur.getString(j++));
					productos.setIdpresentacion(cur.getString(j++));
					productos.setLargo(cur.getString(j++));
					productos.setUndxphl(cur.getInt(j++));
					productos.setPorcent_peso_permitido(cur.getInt(j++));
					productos.setCod_equivalente(cur.getString(j++));
					productos.setCod_gtin(cur.getString(j++));
					productos.setEs_generico(cur.getDouble(j++));
					productos.setFactorce(cur.getDouble(j++));
					productos.setIdccosto_pt(cur.getString(j++));
					productos.setIdgrupo2(cur.getString(j++));
					productos.setEs_accesorio(cur.getDouble(j++));
					productos.setValoriza_resultado(cur.getInt(j++));
					productos.setIdcatalogo_unico(cur.getString(j++));
					productos.setIdproducto_spring(cur.getString(j++));
					productos.setEs_produccion_cc(cur.getDouble(j++));
					productos.setIdconsumidor(cur.getString(j++));
					productos.setEs_hojafresca(cur.getDouble(j++));
					productos.setEs_plantafresca(cur.getDouble(j++));
					productos.setPartnumber(cur.getString(j++));
					productos.setIdproducto_agritask(cur.getString(j++));
					productos.setMas_ccosto(cur.getDouble(j++));
					productos.setIdnombrecomercial(cur.getString(j++));
					productos.setIdcuenta_ptr(cur.getString(j++));
					productos.setIdcuenta_vpt(cur.getString(j++));
					productos.setIdcuenta_cic(cur.getString(j++));
					productos.setVentana(cur.getString(j++));
					productos.setPide_informe_activo(cur.getDouble(j++));
					productos.setPor_isc(cur.getDouble(j++));
					productos.setIdconsumidor_o(cur.getString(j++));
					productos.setIdclieprov(cur.getString(j++));
					productos.setEs_pesada(cur.getDouble(j++));
					productos.setEs_fiscalizado(cur.getDouble(j++));
					productos.setControl_calidad(cur.getDouble(j++));

					lista.add(productos); 
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