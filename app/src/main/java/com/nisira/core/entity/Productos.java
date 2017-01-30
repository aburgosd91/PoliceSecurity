package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "PRODUCTOS")
@XStreamAlias("PRODUCTOS")

public class Productos implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("aranceles") 
	@XStreamAlias("ARANCELES") 
	private String aranceles = "" ;
	@Columna
	@SerializedName("en_maquina") 
	@XStreamAlias("EN_MAQUINA") 
	private Double en_maquina = 0.00 ;
	@Columna
	@SerializedName("es_descarte") 
	@XStreamAlias("ES_DESCARTE") 
	private Double es_descarte = 0.00 ;
	@Columna
	@SerializedName("es_terminado") 
	@XStreamAlias("ES_TERMINADO") 
	private Double es_terminado = 0.00 ;
	@Columna
	@SerializedName("idterminado") 
	@XStreamAlias("IDTERMINADO") 
	private String idterminado = "" ;
	@Columna
	@SerializedName("idsubgrupo") 
	@XStreamAlias("IDSUBGRUPO") 
	private String idsubgrupo = "" ;
	@Columna
	@SerializedName("idgrupo") 
	@XStreamAlias("IDGRUPO") 
	private String idgrupo = "" ;
	@Columna
	@SerializedName("idalgoritmo") 
	@XStreamAlias("IDALGORITMO") 
	private String idalgoritmo = "" ;
	@Columna
	@SerializedName("para_exportacion") 
	@XStreamAlias("PARA_EXPORTACION") 
	private Double para_exportacion = 0.00 ;
	@Columna
	@SerializedName("para_venta") 
	@XStreamAlias("PARA_VENTA") 
	private Double para_venta = 0.00 ;
	@Columna
	@SerializedName("para_conserva") 
	@XStreamAlias("PARA_CONSERVA") 
	private Double para_conserva = 0.00 ;
	@Columna
	@SerializedName("pide_lote") 
	@XStreamAlias("PIDE_LOTE") 
	private Double pide_lote = 0.00 ;
	@Columna
	@SerializedName("pide_serie") 
	@XStreamAlias("PIDE_SERIE") 
	private Double pide_serie = 0.00 ;
	@Columna
	@SerializedName("es_afecto") 
	@XStreamAlias("ES_AFECTO") 
	private Double es_afecto = 0.00 ;
	@Columna
	@SerializedName("tiemporeposicion") 
	@XStreamAlias("TIEMPOREPOSICION") 
	private Double tiemporeposicion = 0.00 ;
	@Columna
	@SerializedName("caracteristicas") 
	@XStreamAlias("CARACTERISTICAS") 
	private String caracteristicas = "" ;
	@Columna
	@SerializedName("es_compuesto") 
	@XStreamAlias("ES_COMPUESTO") 
	private Double es_compuesto = 0.00 ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("descripcion1") 
	@XStreamAlias("DESCRIPCION1") 
	private String descripcion1 = "" ;
	@Columna
	@SerializedName("es_exonerado") 
	@XStreamAlias("ES_EXONERADO") 
	private Double es_exonerado = 0.00 ;
	@Columna
	@SerializedName("foto") 
	@XStreamAlias("FOTO") 
	private String foto = "" ;
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("IDMEDIDA") 
	private String idmedida = "" ;
	@Columna
	@SerializedName("peso") 
	@XStreamAlias("PESO") 
	private Double peso = 0.00 ;
	@Columna
	@SerializedName("regimen_agrario") 
	@XStreamAlias("REGIMEN_AGRARIO") 
	private Double regimen_agrario = 0.00 ;
	@Columna
	@SerializedName("volumen") 
	@XStreamAlias("VOLUMEN") 
	private Double volumen = 0.00 ;
	@Columna
	@SerializedName("longitud") 
	@XStreamAlias("LONGITUD") 
	private String longitud = "" ;
	@Columna
	@SerializedName("tipo_punta") 
	@XStreamAlias("TIPO_PUNTA") 
	private String tipo_punta = "" ;
	@Columna
	@SerializedName("diametro") 
	@XStreamAlias("DIAMETRO") 
	private String diametro = "" ;
	@Columna
	@SerializedName("es_aprovechable") 
	@XStreamAlias("ES_APROVECHABLE") 
	private Double es_aprovechable = 0.00 ;
	@Columna
	@SerializedName("nombre_comercial") 
	@XStreamAlias("NOMBRE_COMERCIAL") 
	private String nombre_comercial = "" ;
	@Columna
	@SerializedName("idmarca") 
	@XStreamAlias("IDMARCA") 
	private String idmarca = "" ;
	@Columna
	@SerializedName("idpartida") 
	@XStreamAlias("IDPARTIDA") 
	private String idpartida = "" ;
	@Columna
	@SerializedName("idcolor") 
	@XStreamAlias("IDCOLOR") 
	private String idcolor = "" ;
	@Columna
	@SerializedName("idinsumo") 
	@XStreamAlias("IDINSUMO") 
	private String idinsumo = "" ;
	@Columna
	@SerializedName("pide_estado") 
	@XStreamAlias("PIDE_ESTADO") 
	private Double pide_estado = 0.00 ;
	@Columna
	@SerializedName("idproducto2") 
	@XStreamAlias("IDPRODUCTO2") 
	private String idproducto2 = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("revisado") 
	@XStreamAlias("REVISADO") 
	private Double revisado = 0.00 ;
	@Columna
	@SerializedName("idmodelo") 
	@XStreamAlias("IDMODELO") 
	private String idmodelo = "" ;
	@Columna
	@SerializedName("genera_serie") 
	@XStreamAlias("GENERA_SERIE") 
	private Double genera_serie = 0.00 ;
	@Columna
	@SerializedName("es_servicio") 
	@XStreamAlias("ES_SERVICIO") 
	private Double es_servicio = 0.00 ;
	@Columna
	@SerializedName("horas_std") 
	@XStreamAlias("HORAS_STD") 
	private Double horas_std = 0.00 ;
	@Columna
	@SerializedName("iddescuento") 
	@XStreamAlias("IDDESCUENTO") 
	private String iddescuento = "" ;
	@Columna
	@SerializedName("factorreposicion") 
	@XStreamAlias("FACTORREPOSICION") 
	private Double factorreposicion = 0.00 ;
	@Columna
	@SerializedName("idubicacion") 
	@XStreamAlias("IDUBICACION") 
	private String idubicacion = "" ;
	@Columna
	@SerializedName("es_neumatico") 
	@XStreamAlias("ES_NEUMATICO") 
	private Double es_neumatico = 0.00 ;
	@Columna
	@SerializedName("prof_cocada") 
	@XStreamAlias("PROF_COCADA") 
	private Double prof_cocada = 0.00 ;
	@Columna
	@SerializedName("pres_montaje") 
	@XStreamAlias("PRES_MONTAJE") 
	private Double pres_montaje = 0.00 ;
	@Columna
	@SerializedName("idtipoproducto") 
	@XStreamAlias("IDTIPOPRODUCTO") 
	private String idtipoproducto = "" ;
	@Columna
	@SerializedName("es_tercero") 
	@XStreamAlias("ES_TERCERO") 
	private Double es_tercero = 0.00 ;
	@Columna
	@SerializedName("es_kit") 
	@XStreamAlias("ES_KIT") 
	private Double es_kit = 0.00 ;
	@Columna
	@SerializedName("es_merma") 
	@XStreamAlias("ES_MERMA") 
	private Double es_merma = 0.00 ;
	@Columna
	@SerializedName("es_ensamblado") 
	@XStreamAlias("ES_ENSAMBLADO") 
	private Double es_ensamblado = 0.00 ;
	@Columna
	@SerializedName("codigosap") 
	@XStreamAlias("CODIGOSAP") 
	private String codigosap = "" ;
	@Columna
	@SerializedName("es_ganado") 
	@XStreamAlias("ES_GANADO") 
	private Double es_ganado = 0.00 ;
	@Columna
	@SerializedName("es_pproceso") 
	@XStreamAlias("ES_PPROCESO") 
	private Double es_pproceso = 0.00 ;
	@Columna
	@SerializedName("es_matprima") 
	@XStreamAlias("ES_MATPRIMA") 
	private Double es_matprima = 0.00 ;
	@Columna
	@SerializedName("es_congelado") 
	@XStreamAlias("ES_CONGELADO") 
	private Double es_congelado = 0.00 ;
	@Columna
	@SerializedName("es_fresco") 
	@XStreamAlias("ES_FRESCO") 
	private Double es_fresco = 0.00 ;
	@Columna
	@SerializedName("idtalla") 
	@XStreamAlias("IDTALLA") 
	private String idtalla = "" ;
	@Columna
	@SerializedName("ugg") 
	@XStreamAlias("UGG") 
	private Double ugg = 0.00 ;
	@Columna
	@SerializedName("idccosto_ganado") 
	@XStreamAlias("IDCCOSTO_GANADO") 
	private String idccosto_ganado = "" ;
	@Columna
	@SerializedName("idclaseccosto") 
	@XStreamAlias("IDCLASECCOSTO") 
	private String idclaseccosto = "" ;
	@Columna
	@SerializedName("es_activo") 
	@XStreamAlias("ES_ACTIVO") 
	private Double es_activo = 0.00 ;
	@Columna
	@SerializedName("idtipoactivo") 
	@XStreamAlias("IDTIPOACTIVO") 
	private String idtipoactivo = "" ;
	@Columna
	@SerializedName("idccosto_activo") 
	@XStreamAlias("IDCCOSTO_ACTIVO") 
	private String idccosto_activo = "" ;
	@Columna
	@SerializedName("idcta_activo") 
	@XStreamAlias("IDCTA_ACTIVO") 
	private String idcta_activo = "" ;
	@Columna
	@SerializedName("idcta_deprec") 
	@XStreamAlias("IDCTA_DEPREC") 
	private String idcta_deprec = "" ;
	@Columna
	@SerializedName("es_detraccion") 
	@XStreamAlias("ES_DETRACCION") 
	private Double es_detraccion = 0.00 ;
	@Columna
	@SerializedName("idtipodetra") 
	@XStreamAlias("IDTIPODETRA") 
	private String idtipodetra = "" ;
	@Columna
	@SerializedName("es_drawback") 
	@XStreamAlias("ES_DRAWBACK") 
	private Double es_drawback = 0.00 ;
	@Columna
	@SerializedName("idnomenclatura") 
	@XStreamAlias("IDNOMENCLATURA") 
	private String idnomenclatura = "" ;
	@Columna
	@SerializedName("para_fresco") 
	@XStreamAlias("PARA_FRESCO") 
	private Double para_fresco = 0.00 ;
	@Columna
	@SerializedName("idcultivo") 
	@XStreamAlias("IDCULTIVO") 
	private String idcultivo = "" ;
	@Columna
	@SerializedName("idvariedad") 
	@XStreamAlias("IDVARIEDAD") 
	private String idvariedad = "" ;
	@Columna
	@SerializedName("es_inddrawback") 
	@XStreamAlias("ES_INDDRAWBACK") 
	private Double es_inddrawback = 0.00 ;
	@Columna
	@SerializedName("pesoneto") 
	@XStreamAlias("PESONETO") 
	private Double pesoneto = 0.00 ;
	@Columna
	@SerializedName("tipo_isc") 
	@XStreamAlias("TIPO_ISC") 
	private Double tipo_isc = 0.00 ;
	@Columna
	@SerializedName("valor_isc") 
	@XStreamAlias("VALOR_ISC") 
	private Double valor_isc = 0.00 ;
	@Columna
	@SerializedName("equiv_isc") 
	@XStreamAlias("EQUIV_ISC") 
	private Double equiv_isc = 0.00 ;
	@Columna
	@SerializedName("kg_cajas") 
	@XStreamAlias("KG_CAJAS") 
	private Double kg_cajas = 0.00 ;
	@Columna
	@SerializedName("pide_lote_ccosto") 
	@XStreamAlias("PIDE_LOTE_CCOSTO") 
	private Double pide_lote_ccosto = 0.00 ;
	@Columna
	@SerializedName("idmedida2") 
	@XStreamAlias("IDMEDIDA2") 
	private String idmedida2 = "" ;
	@Columna
	@SerializedName("exige_u2") 
	@XStreamAlias("EXIGE_U2") 
	private Double exige_u2 = 0.00 ;
	@Columna
	@SerializedName("factor_u2") 
	@XStreamAlias("FACTOR_U2") 
	private Double factor_u2 = 0.00 ;
	@Columna
	@SerializedName("porcen_merma") 
	@XStreamAlias("PORCEN_MERMA") 
	private Double porcen_merma = 0.00 ;
	@Columna
	@SerializedName("afecto_percepcion") 
	@XStreamAlias("AFECTO_PERCEPCION") 
	private Double afecto_percepcion = 0.00 ;
	@Columna
	@SerializedName("idcondicion") 
	@XStreamAlias("IDCONDICION") 
	private String idcondicion = "" ;
	@Columna
	@SerializedName("uac") 
	@XStreamAlias("UAC") 
	private Integer uac;
	@Columna
	@SerializedName("um2_formula") 
	@XStreamAlias("UM2_FORMULA") 
	private Double um2_formula = 0.00 ;
	@Columna
	@SerializedName("tipo_proceso") 
	@XStreamAlias("TIPO_PROCESO") 
	private String tipo_proceso = "" ;
	@Columna
	@SerializedName("idtiporet") 
	@XStreamAlias("IDTIPORET") 
	private String idtiporet = "" ;
	@Columna
	@SerializedName("afecto_retencion") 
	@XStreamAlias("AFECTO_RETENCION") 
	private Double afecto_retencion = 0.00 ;
	@Columna
	@SerializedName("tipoproducto") 
	@XStreamAlias("TIPOPRODUCTO") 
	private String tipoproducto = "" ;
	@Columna
	@SerializedName("tipo_proceso_origen") 
	@XStreamAlias("TIPO_PROCESO_ORIGEN") 
	private String tipo_proceso_origen = "" ;
	@Columna
	@SerializedName("idproducto_equiv") 
	@XStreamAlias("IDPRODUCTO_EQUIV") 
	private String idproducto_equiv = "" ;
	@Columna
	@SerializedName("cestandar_mof") 
	@XStreamAlias("CESTANDAR_MOF") 
	private Double cestandar_mof = 0.00 ;
	@Columna
	@SerializedName("cestandar_mex") 
	@XStreamAlias("CESTANDAR_MEX") 
	private Double cestandar_mex = 0.00 ;
	@Columna
	@SerializedName("factorcosto") 
	@XStreamAlias("FACTORCOSTO") 
	private Double factorcosto = 0.00 ;
	@Columna
	@SerializedName("es_vehiculo") 
	@XStreamAlias("ES_VEHICULO") 
	private Double es_vehiculo = 0.00 ;
	@Columna
	@SerializedName("retiqueta") 
	@XStreamAlias("RETIQUETA") 
	private String retiqueta = "" ;
	@Columna
	@SerializedName("rtecnica") 
	@XStreamAlias("RTECNICA") 
	private String rtecnica = "" ;
	@Columna
	@SerializedName("rseguridad") 
	@XStreamAlias("RSEGURIDAD") 
	private String rseguridad = "" ;
	@Columna
	@SerializedName("rcalidad") 
	@XStreamAlias("RCALIDAD") 
	private String rcalidad = "" ;
	@Columna
	@SerializedName("etiqueta") 
	@XStreamAlias("ETIQUETA") 
	private Double etiqueta = 0.00 ;
	@Columna
	@SerializedName("tecnica") 
	@XStreamAlias("TECNICA") 
	private Double tecnica = 0.00 ;
	@Columna
	@SerializedName("seguridad") 
	@XStreamAlias("SEGURIDAD") 
	private Double seguridad = 0.00 ;
	@Columna
	@SerializedName("calidad") 
	@XStreamAlias("CALIDAD") 
	private Double calidad = 0.00 ;
	@Columna
	@SerializedName("prohibido") 
	@XStreamAlias("PROHIBIDO") 
	private Double prohibido = 0.00 ;
	@Columna
	@SerializedName("descripcion2") 
	@XStreamAlias("DESCRIPCION2") 
	private String descripcion2 = "" ;
	@Columna
	@SerializedName("peso_tara") 
	@XStreamAlias("PESO_TARA") 
	private Double peso_tara = 0.00 ;
	@Columna
	@SerializedName("es_herramienta") 
	@XStreamAlias("ES_HERRAMIENTA") 
	private Double es_herramienta = 0.00 ;
	@Columna
	@SerializedName("regla_ot") 
	@XStreamAlias("REGLA_OT") 
	private Double regla_ot = 0.00 ;
	@Columna
	@SerializedName("importado_externo") 
	@XStreamAlias("IMPORTADO_EXTERNO") 
	private Double importado_externo = 0.00 ;
	@Columna
	@SerializedName("idtipocatalogo") 
	@XStreamAlias("IDTIPOCATALOGO") 
	private String idtipocatalogo = "" ;
	@Columna
	@SerializedName("es_conversion_glp") 
	@XStreamAlias("ES_CONVERSION_GLP") 
	private Double es_conversion_glp = 0.00 ;
	@Columna
	@SerializedName("no_declara_le") 
	@XStreamAlias("NO_DECLARA_LE") 
	private Double no_declara_le = 0.00 ;
	@Columna
	@SerializedName("para_declaracion") 
	@XStreamAlias("PARA_DECLARACION") 
	private Double para_declaracion = 0.00 ;
	@Columna
	@SerializedName("idpresentacion") 
	@XStreamAlias("IDPRESENTACION") 
	private String idpresentacion = "" ;
	@Columna
	@SerializedName("undxphl") 
	@XStreamAlias("UNDXPHL") 
	private Integer undxphl;
	@Columna
	@SerializedName("largo") 
	@XStreamAlias("LARGO") 
	private String largo = "" ;
	@Columna
	@SerializedName("calibremm") 
	@XStreamAlias("CALIBREMM") 
	private String calibremm = "" ;
	@Columna
	@SerializedName("porcent_peso_permitido") 
	@XStreamAlias("PORCENT_PESO_PERMITIDO") 
	private Integer porcent_peso_permitido;
	@Columna
	@SerializedName("es_generico") 
	@XStreamAlias("ES_GENERICO") 
	private Double es_generico = 0.00 ;
	@Columna
	@SerializedName("cod_equivalente") 
	@XStreamAlias("COD_EQUIVALENTE") 
	private String cod_equivalente = "" ;
	@Columna
	@SerializedName("factorce") 
	@XStreamAlias("FACTORCE") 
	private Double factorce = 0.00 ;
	@Columna
	@SerializedName("cod_gtin") 
	@XStreamAlias("COD_GTIN") 
	private String cod_gtin = "" ;
	@Columna
	@SerializedName("idccosto_pt") 
	@XStreamAlias("IDCCOSTO_PT") 
	private String idccosto_pt = "" ;
	@Columna
	@SerializedName("idgrupo2") 
	@XStreamAlias("IDGRUPO2") 
	private String idgrupo2 = "" ;
	@Columna
	@SerializedName("es_accesorio") 
	@XStreamAlias("ES_ACCESORIO") 
	private Double es_accesorio = 0.00 ;
	@Columna
	@SerializedName("valoriza_resultado") 
	@XStreamAlias("VALORIZA_RESULTADO") 
	private Integer valoriza_resultado;
	@Columna
	@SerializedName("idcatalogo_unico") 
	@XStreamAlias("IDCATALOGO_UNICO") 
	private String idcatalogo_unico = "" ;
	@Columna
	@SerializedName("idproducto_spring") 
	@XStreamAlias("IDPRODUCTO_SPRING") 
	private String idproducto_spring = "" ;
	@Columna
	@SerializedName("es_produccion_cc") 
	@XStreamAlias("ES_PRODUCCION_CC") 
	private Double es_produccion_cc = 0.00 ;
	@Columna
	@SerializedName("idconsumidor") 
	@XStreamAlias("IDCONSUMIDOR") 
	private String idconsumidor = "" ;
	@Columna
	@SerializedName("es_hojafresca") 
	@XStreamAlias("ES_HOJAFRESCA") 
	private Double es_hojafresca = 0.00 ;
	@Columna
	@SerializedName("es_plantafresca") 
	@XStreamAlias("ES_PLANTAFRESCA") 
	private Double es_plantafresca = 0.00 ;
	@Columna
	@SerializedName("partnumber") 
	@XStreamAlias("PARTNUMBER") 
	private String partnumber = "" ;
	@Columna
	@SerializedName("idproducto_agritask") 
	@XStreamAlias("IDPRODUCTO_AGRITASK") 
	private String idproducto_agritask = "" ;
	@Columna
	@SerializedName("mas_ccosto") 
	@XStreamAlias("MAS_CCOSTO") 
	private Double mas_ccosto = 0.00 ;
	@Columna
	@SerializedName("idnombrecomercial") 
	@XStreamAlias("IDNOMBRECOMERCIAL") 
	private String idnombrecomercial = "" ;
	@Columna
	@SerializedName("idcuenta_ptr") 
	@XStreamAlias("IDCUENTA_PTR") 
	private String idcuenta_ptr = "" ;
	@Columna
	@SerializedName("idcuenta_vpt") 
	@XStreamAlias("IDCUENTA_VPT") 
	private String idcuenta_vpt = "" ;
	@Columna
	@SerializedName("idcuenta_cic") 
	@XStreamAlias("IDCUENTA_CIC") 
	private String idcuenta_cic = "" ;
	@Columna
	@SerializedName("ventana") 
	@XStreamAlias("VENTANA") 
	private String ventana = "" ;
	@Columna
	@SerializedName("pide_informe_activo") 
	@XStreamAlias("PIDE_INFORME_ACTIVO") 
	private Double pide_informe_activo = 0.00 ;
	@Columna
	@SerializedName("por_isc") 
	@XStreamAlias("POR_ISC") 
	private Double por_isc = 0.00 ;
	@Columna
	@SerializedName("idconsumidor_o") 
	@XStreamAlias("IDCONSUMIDOR_O") 
	private String idconsumidor_o = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("es_pesada") 
	@XStreamAlias("ES_PESADA") 
	private Double es_pesada = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setAranceles(String aranceles) {
		this.aranceles = aranceles;
	}

	public String getAranceles() {
		return this.aranceles;
	}

	public void setEn_maquina(Double en_maquina) {
		this.en_maquina = en_maquina;
	}

	public Double getEn_maquina() {
		return this.en_maquina;
	}

	public void setEs_descarte(Double es_descarte) {
		this.es_descarte = es_descarte;
	}

	public Double getEs_descarte() {
		return this.es_descarte;
	}

	public void setEs_terminado(Double es_terminado) {
		this.es_terminado = es_terminado;
	}

	public Double getEs_terminado() {
		return this.es_terminado;
	}

	public void setIdterminado(String idterminado) {
		this.idterminado = idterminado;
	}

	public String getIdterminado() {
		return this.idterminado;
	}

	public void setIdsubgrupo(String idsubgrupo) {
		this.idsubgrupo = idsubgrupo;
	}

	public String getIdsubgrupo() {
		return this.idsubgrupo;
	}

	public void setIdgrupo(String idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdalgoritmo(String idalgoritmo) {
		this.idalgoritmo = idalgoritmo;
	}

	public String getIdalgoritmo() {
		return this.idalgoritmo;
	}

	public void setPara_exportacion(Double para_exportacion) {
		this.para_exportacion = para_exportacion;
	}

	public Double getPara_exportacion() {
		return this.para_exportacion;
	}

	public void setPara_venta(Double para_venta) {
		this.para_venta = para_venta;
	}

	public Double getPara_venta() {
		return this.para_venta;
	}

	public void setPara_conserva(Double para_conserva) {
		this.para_conserva = para_conserva;
	}

	public Double getPara_conserva() {
		return this.para_conserva;
	}

	public void setPide_lote(Double pide_lote) {
		this.pide_lote = pide_lote;
	}

	public Double getPide_lote() {
		return this.pide_lote;
	}

	public void setPide_serie(Double pide_serie) {
		this.pide_serie = pide_serie;
	}

	public Double getPide_serie() {
		return this.pide_serie;
	}

	public void setEs_afecto(Double es_afecto) {
		this.es_afecto = es_afecto;
	}

	public Double getEs_afecto() {
		return this.es_afecto;
	}

	public void setTiemporeposicion(Double tiemporeposicion) {
		this.tiemporeposicion = tiemporeposicion;
	}

	public Double getTiemporeposicion() {
		return this.tiemporeposicion;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setEs_compuesto(Double es_compuesto) {
		this.es_compuesto = es_compuesto;
	}

	public Double getEs_compuesto() {
		return this.es_compuesto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setEs_exonerado(Double es_exonerado) {
		this.es_exonerado = es_exonerado;
	}

	public Double getEs_exonerado() {
		return this.es_exonerado;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setRegimen_agrario(Double regimen_agrario) {
		this.regimen_agrario = regimen_agrario;
	}

	public Double getRegimen_agrario() {
		return this.regimen_agrario;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	public Double getVolumen() {
		return this.volumen;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setTipo_punta(String tipo_punta) {
		this.tipo_punta = tipo_punta;
	}

	public String getTipo_punta() {
		return this.tipo_punta;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getDiametro() {
		return this.diametro;
	}

	public void setEs_aprovechable(Double es_aprovechable) {
		this.es_aprovechable = es_aprovechable;
	}

	public Double getEs_aprovechable() {
		return this.es_aprovechable;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getNombre_comercial() {
		return this.nombre_comercial;
	}

	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}

	public String getIdmarca() {
		return this.idmarca;
	}

	public void setIdpartida(String idpartida) {
		this.idpartida = idpartida;
	}

	public String getIdpartida() {
		return this.idpartida;
	}

	public void setIdcolor(String idcolor) {
		this.idcolor = idcolor;
	}

	public String getIdcolor() {
		return this.idcolor;
	}

	public void setIdinsumo(String idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getIdinsumo() {
		return this.idinsumo;
	}

	public void setPide_estado(Double pide_estado) {
		this.pide_estado = pide_estado;
	}

	public Double getPide_estado() {
		return this.pide_estado;
	}

	public void setIdproducto2(String idproducto2) {
		this.idproducto2 = idproducto2;
	}

	public String getIdproducto2() {
		return this.idproducto2;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setRevisado(Double revisado) {
		this.revisado = revisado;
	}

	public Double getRevisado() {
		return this.revisado;
	}

	public void setIdmodelo(String idmodelo) {
		this.idmodelo = idmodelo;
	}

	public String getIdmodelo() {
		return this.idmodelo;
	}

	public void setGenera_serie(Double genera_serie) {
		this.genera_serie = genera_serie;
	}

	public Double getGenera_serie() {
		return this.genera_serie;
	}

	public void setEs_servicio(Double es_servicio) {
		this.es_servicio = es_servicio;
	}

	public Double getEs_servicio() {
		return this.es_servicio;
	}

	public void setHoras_std(Double horas_std) {
		this.horas_std = horas_std;
	}

	public Double getHoras_std() {
		return this.horas_std;
	}

	public void setIddescuento(String iddescuento) {
		this.iddescuento = iddescuento;
	}

	public String getIddescuento() {
		return this.iddescuento;
	}

	public void setFactorreposicion(Double factorreposicion) {
		this.factorreposicion = factorreposicion;
	}

	public Double getFactorreposicion() {
		return this.factorreposicion;
	}

	public void setIdubicacion(String idubicacion) {
		this.idubicacion = idubicacion;
	}

	public String getIdubicacion() {
		return this.idubicacion;
	}

	public void setEs_neumatico(Double es_neumatico) {
		this.es_neumatico = es_neumatico;
	}

	public Double getEs_neumatico() {
		return this.es_neumatico;
	}

	public void setProf_cocada(Double prof_cocada) {
		this.prof_cocada = prof_cocada;
	}

	public Double getProf_cocada() {
		return this.prof_cocada;
	}

	public void setPres_montaje(Double pres_montaje) {
		this.pres_montaje = pres_montaje;
	}

	public Double getPres_montaje() {
		return this.pres_montaje;
	}

	public void setIdtipoproducto(String idtipoproducto) {
		this.idtipoproducto = idtipoproducto;
	}

	public String getIdtipoproducto() {
		return this.idtipoproducto;
	}

	public void setEs_tercero(Double es_tercero) {
		this.es_tercero = es_tercero;
	}

	public Double getEs_tercero() {
		return this.es_tercero;
	}

	public void setEs_kit(Double es_kit) {
		this.es_kit = es_kit;
	}

	public Double getEs_kit() {
		return this.es_kit;
	}

	public void setEs_merma(Double es_merma) {
		this.es_merma = es_merma;
	}

	public Double getEs_merma() {
		return this.es_merma;
	}

	public void setEs_ensamblado(Double es_ensamblado) {
		this.es_ensamblado = es_ensamblado;
	}

	public Double getEs_ensamblado() {
		return this.es_ensamblado;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setEs_ganado(Double es_ganado) {
		this.es_ganado = es_ganado;
	}

	public Double getEs_ganado() {
		return this.es_ganado;
	}

	public void setEs_pproceso(Double es_pproceso) {
		this.es_pproceso = es_pproceso;
	}

	public Double getEs_pproceso() {
		return this.es_pproceso;
	}

	public void setEs_matprima(Double es_matprima) {
		this.es_matprima = es_matprima;
	}

	public Double getEs_matprima() {
		return this.es_matprima;
	}

	public void setEs_congelado(Double es_congelado) {
		this.es_congelado = es_congelado;
	}

	public Double getEs_congelado() {
		return this.es_congelado;
	}

	public void setEs_fresco(Double es_fresco) {
		this.es_fresco = es_fresco;
	}

	public Double getEs_fresco() {
		return this.es_fresco;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}

	public String getIdtalla() {
		return this.idtalla;
	}

	public void setUgg(Double ugg) {
		this.ugg = ugg;
	}

	public Double getUgg() {
		return this.ugg;
	}

	public void setIdccosto_ganado(String idccosto_ganado) {
		this.idccosto_ganado = idccosto_ganado;
	}

	public String getIdccosto_ganado() {
		return this.idccosto_ganado;
	}

	public void setIdclaseccosto(String idclaseccosto) {
		this.idclaseccosto = idclaseccosto;
	}

	public String getIdclaseccosto() {
		return this.idclaseccosto;
	}

	public void setEs_activo(Double es_activo) {
		this.es_activo = es_activo;
	}

	public Double getEs_activo() {
		return this.es_activo;
	}

	public void setIdtipoactivo(String idtipoactivo) {
		this.idtipoactivo = idtipoactivo;
	}

	public String getIdtipoactivo() {
		return this.idtipoactivo;
	}

	public void setIdccosto_activo(String idccosto_activo) {
		this.idccosto_activo = idccosto_activo;
	}

	public String getIdccosto_activo() {
		return this.idccosto_activo;
	}

	public void setIdcta_activo(String idcta_activo) {
		this.idcta_activo = idcta_activo;
	}

	public String getIdcta_activo() {
		return this.idcta_activo;
	}

	public void setIdcta_deprec(String idcta_deprec) {
		this.idcta_deprec = idcta_deprec;
	}

	public String getIdcta_deprec() {
		return this.idcta_deprec;
	}

	public void setEs_detraccion(Double es_detraccion) {
		this.es_detraccion = es_detraccion;
	}

	public Double getEs_detraccion() {
		return this.es_detraccion;
	}

	public void setIdtipodetra(String idtipodetra) {
		this.idtipodetra = idtipodetra;
	}

	public String getIdtipodetra() {
		return this.idtipodetra;
	}

	public void setEs_drawback(Double es_drawback) {
		this.es_drawback = es_drawback;
	}

	public Double getEs_drawback() {
		return this.es_drawback;
	}

	public void setIdnomenclatura(String idnomenclatura) {
		this.idnomenclatura = idnomenclatura;
	}

	public String getIdnomenclatura() {
		return this.idnomenclatura;
	}

	public void setPara_fresco(Double para_fresco) {
		this.para_fresco = para_fresco;
	}

	public Double getPara_fresco() {
		return this.para_fresco;
	}

	public void setIdcultivo(String idcultivo) {
		this.idcultivo = idcultivo;
	}

	public String getIdcultivo() {
		return this.idcultivo;
	}

	public void setIdvariedad(String idvariedad) {
		this.idvariedad = idvariedad;
	}

	public String getIdvariedad() {
		return this.idvariedad;
	}

	public void setEs_inddrawback(Double es_inddrawback) {
		this.es_inddrawback = es_inddrawback;
	}

	public Double getEs_inddrawback() {
		return this.es_inddrawback;
	}

	public void setPesoneto(Double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public Double getPesoneto() {
		return this.pesoneto;
	}

	public void setTipo_isc(Double tipo_isc) {
		this.tipo_isc = tipo_isc;
	}

	public Double getTipo_isc() {
		return this.tipo_isc;
	}

	public void setValor_isc(Double valor_isc) {
		this.valor_isc = valor_isc;
	}

	public Double getValor_isc() {
		return this.valor_isc;
	}

	public void setEquiv_isc(Double equiv_isc) {
		this.equiv_isc = equiv_isc;
	}

	public Double getEquiv_isc() {
		return this.equiv_isc;
	}

	public void setKg_cajas(Double kg_cajas) {
		this.kg_cajas = kg_cajas;
	}

	public Double getKg_cajas() {
		return this.kg_cajas;
	}

	public void setPide_lote_ccosto(Double pide_lote_ccosto) {
		this.pide_lote_ccosto = pide_lote_ccosto;
	}

	public Double getPide_lote_ccosto() {
		return this.pide_lote_ccosto;
	}

	public void setIdmedida2(String idmedida2) {
		this.idmedida2 = idmedida2;
	}

	public String getIdmedida2() {
		return this.idmedida2;
	}

	public void setExige_u2(Double exige_u2) {
		this.exige_u2 = exige_u2;
	}

	public Double getExige_u2() {
		return this.exige_u2;
	}

	public void setFactor_u2(Double factor_u2) {
		this.factor_u2 = factor_u2;
	}

	public Double getFactor_u2() {
		return this.factor_u2;
	}

	public void setPorcen_merma(Double porcen_merma) {
		this.porcen_merma = porcen_merma;
	}

	public Double getPorcen_merma() {
		return this.porcen_merma;
	}

	public void setAfecto_percepcion(Double afecto_percepcion) {
		this.afecto_percepcion = afecto_percepcion;
	}

	public Double getAfecto_percepcion() {
		return this.afecto_percepcion;
	}

	public void setIdcondicion(String idcondicion) {
		this.idcondicion = idcondicion;
	}

	public String getIdcondicion() {
		return this.idcondicion;
	}

	public void setUac(Integer uac) {
		this.uac = uac;
	}

	public Integer getUac() {
		return this.uac;
	}

	public void setUm2_formula(Double um2_formula) {
		this.um2_formula = um2_formula;
	}

	public Double getUm2_formula() {
		return this.um2_formula;
	}

	public void setTipo_proceso(String tipo_proceso) {
		this.tipo_proceso = tipo_proceso;
	}

	public String getTipo_proceso() {
		return this.tipo_proceso;
	}

	public void setIdtiporet(String idtiporet) {
		this.idtiporet = idtiporet;
	}

	public String getIdtiporet() {
		return this.idtiporet;
	}

	public void setAfecto_retencion(Double afecto_retencion) {
		this.afecto_retencion = afecto_retencion;
	}

	public Double getAfecto_retencion() {
		return this.afecto_retencion;
	}

	public void setTipoproducto(String tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public String getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipo_proceso_origen(String tipo_proceso_origen) {
		this.tipo_proceso_origen = tipo_proceso_origen;
	}

	public String getTipo_proceso_origen() {
		return this.tipo_proceso_origen;
	}

	public void setIdproducto_equiv(String idproducto_equiv) {
		this.idproducto_equiv = idproducto_equiv;
	}

	public String getIdproducto_equiv() {
		return this.idproducto_equiv;
	}

	public void setCestandar_mof(Double cestandar_mof) {
		this.cestandar_mof = cestandar_mof;
	}

	public Double getCestandar_mof() {
		return this.cestandar_mof;
	}

	public void setCestandar_mex(Double cestandar_mex) {
		this.cestandar_mex = cestandar_mex;
	}

	public Double getCestandar_mex() {
		return this.cestandar_mex;
	}

	public void setFactorcosto(Double factorcosto) {
		this.factorcosto = factorcosto;
	}

	public Double getFactorcosto() {
		return this.factorcosto;
	}

	public void setEs_vehiculo(Double es_vehiculo) {
		this.es_vehiculo = es_vehiculo;
	}

	public Double getEs_vehiculo() {
		return this.es_vehiculo;
	}

	public void setRetiqueta(String retiqueta) {
		this.retiqueta = retiqueta;
	}

	public String getRetiqueta() {
		return this.retiqueta;
	}

	public void setRtecnica(String rtecnica) {
		this.rtecnica = rtecnica;
	}

	public String getRtecnica() {
		return this.rtecnica;
	}

	public void setRseguridad(String rseguridad) {
		this.rseguridad = rseguridad;
	}

	public String getRseguridad() {
		return this.rseguridad;
	}

	public void setRcalidad(String rcalidad) {
		this.rcalidad = rcalidad;
	}

	public String getRcalidad() {
		return this.rcalidad;
	}

	public void setEtiqueta(Double etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Double getEtiqueta() {
		return this.etiqueta;
	}

	public void setTecnica(Double tecnica) {
		this.tecnica = tecnica;
	}

	public Double getTecnica() {
		return this.tecnica;
	}

	public void setSeguridad(Double seguridad) {
		this.seguridad = seguridad;
	}

	public Double getSeguridad() {
		return this.seguridad;
	}

	public void setCalidad(Double calidad) {
		this.calidad = calidad;
	}

	public Double getCalidad() {
		return this.calidad;
	}

	public void setProhibido(Double prohibido) {
		this.prohibido = prohibido;
	}

	public Double getProhibido() {
		return this.prohibido;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setPeso_tara(Double peso_tara) {
		this.peso_tara = peso_tara;
	}

	public Double getPeso_tara() {
		return this.peso_tara;
	}

	public void setEs_herramienta(Double es_herramienta) {
		this.es_herramienta = es_herramienta;
	}

	public Double getEs_herramienta() {
		return this.es_herramienta;
	}

	public void setRegla_ot(Double regla_ot) {
		this.regla_ot = regla_ot;
	}

	public Double getRegla_ot() {
		return this.regla_ot;
	}

	public void setImportado_externo(Double importado_externo) {
		this.importado_externo = importado_externo;
	}

	public Double getImportado_externo() {
		return this.importado_externo;
	}

	public void setIdtipocatalogo(String idtipocatalogo) {
		this.idtipocatalogo = idtipocatalogo;
	}

	public String getIdtipocatalogo() {
		return this.idtipocatalogo;
	}

	public void setEs_conversion_glp(Double es_conversion_glp) {
		this.es_conversion_glp = es_conversion_glp;
	}

	public Double getEs_conversion_glp() {
		return this.es_conversion_glp;
	}

	public void setNo_declara_le(Double no_declara_le) {
		this.no_declara_le = no_declara_le;
	}

	public Double getNo_declara_le() {
		return this.no_declara_le;
	}

	public void setPara_declaracion(Double para_declaracion) {
		this.para_declaracion = para_declaracion;
	}

	public Double getPara_declaracion() {
		return this.para_declaracion;
	}

	public void setIdpresentacion(String idpresentacion) {
		this.idpresentacion = idpresentacion;
	}

	public String getIdpresentacion() {
		return this.idpresentacion;
	}

	public void setUndxphl(Integer undxphl) {
		this.undxphl = undxphl;
	}

	public Integer getUndxphl() {
		return this.undxphl;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getLargo() {
		return this.largo;
	}

	public void setCalibremm(String calibremm) {
		this.calibremm = calibremm;
	}

	public String getCalibremm() {
		return this.calibremm;
	}

	public void setPorcent_peso_permitido(Integer porcent_peso_permitido) {
		this.porcent_peso_permitido = porcent_peso_permitido;
	}

	public Integer getPorcent_peso_permitido() {
		return this.porcent_peso_permitido;
	}

	public void setEs_generico(Double es_generico) {
		this.es_generico = es_generico;
	}

	public Double getEs_generico() {
		return this.es_generico;
	}

	public void setCod_equivalente(String cod_equivalente) {
		this.cod_equivalente = cod_equivalente;
	}

	public String getCod_equivalente() {
		return this.cod_equivalente;
	}

	public void setFactorce(Double factorce) {
		this.factorce = factorce;
	}

	public Double getFactorce() {
		return this.factorce;
	}

	public void setCod_gtin(String cod_gtin) {
		this.cod_gtin = cod_gtin;
	}

	public String getCod_gtin() {
		return this.cod_gtin;
	}

	public void setIdccosto_pt(String idccosto_pt) {
		this.idccosto_pt = idccosto_pt;
	}

	public String getIdccosto_pt() {
		return this.idccosto_pt;
	}

	public void setIdgrupo2(String idgrupo2) {
		this.idgrupo2 = idgrupo2;
	}

	public String getIdgrupo2() {
		return this.idgrupo2;
	}

	public void setEs_accesorio(Double es_accesorio) {
		this.es_accesorio = es_accesorio;
	}

	public Double getEs_accesorio() {
		return this.es_accesorio;
	}

	public void setValoriza_resultado(Integer valoriza_resultado) {
		this.valoriza_resultado = valoriza_resultado;
	}

	public Integer getValoriza_resultado() {
		return this.valoriza_resultado;
	}

	public void setIdcatalogo_unico(String idcatalogo_unico) {
		this.idcatalogo_unico = idcatalogo_unico;
	}

	public String getIdcatalogo_unico() {
		return this.idcatalogo_unico;
	}

	public void setIdproducto_spring(String idproducto_spring) {
		this.idproducto_spring = idproducto_spring;
	}

	public String getIdproducto_spring() {
		return this.idproducto_spring;
	}

	public void setEs_produccion_cc(Double es_produccion_cc) {
		this.es_produccion_cc = es_produccion_cc;
	}

	public Double getEs_produccion_cc() {
		return this.es_produccion_cc;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setEs_hojafresca(Double es_hojafresca) {
		this.es_hojafresca = es_hojafresca;
	}

	public Double getEs_hojafresca() {
		return this.es_hojafresca;
	}

	public void setEs_plantafresca(Double es_plantafresca) {
		this.es_plantafresca = es_plantafresca;
	}

	public Double getEs_plantafresca() {
		return this.es_plantafresca;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getPartnumber() {
		return this.partnumber;
	}

	public void setIdproducto_agritask(String idproducto_agritask) {
		this.idproducto_agritask = idproducto_agritask;
	}

	public String getIdproducto_agritask() {
		return this.idproducto_agritask;
	}

	public void setMas_ccosto(Double mas_ccosto) {
		this.mas_ccosto = mas_ccosto;
	}

	public Double getMas_ccosto() {
		return this.mas_ccosto;
	}

	public void setIdnombrecomercial(String idnombrecomercial) {
		this.idnombrecomercial = idnombrecomercial;
	}

	public String getIdnombrecomercial() {
		return this.idnombrecomercial;
	}

	public void setIdcuenta_ptr(String idcuenta_ptr) {
		this.idcuenta_ptr = idcuenta_ptr;
	}

	public String getIdcuenta_ptr() {
		return this.idcuenta_ptr;
	}

	public void setIdcuenta_vpt(String idcuenta_vpt) {
		this.idcuenta_vpt = idcuenta_vpt;
	}

	public String getIdcuenta_vpt() {
		return this.idcuenta_vpt;
	}

	public void setIdcuenta_cic(String idcuenta_cic) {
		this.idcuenta_cic = idcuenta_cic;
	}

	public String getIdcuenta_cic() {
		return this.idcuenta_cic;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setPide_informe_activo(Double pide_informe_activo) {
		this.pide_informe_activo = pide_informe_activo;
	}

	public Double getPide_informe_activo() {
		return this.pide_informe_activo;
	}

	public void setPor_isc(Double por_isc) {
		this.por_isc = por_isc;
	}

	public Double getPor_isc() {
		return this.por_isc;
	}

	public void setIdconsumidor_o(String idconsumidor_o) {
		this.idconsumidor_o = idconsumidor_o;
	}

	public String getIdconsumidor_o() {
		return this.idconsumidor_o;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setEs_pesada(Double es_pesada) {
		this.es_pesada = es_pesada;
	}

	public Double getEs_pesada() {
		return this.es_pesada;
	}



	/* Sets & Gets FK*/

}