package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "MOTIVOSPRODUCCION")
@XStreamAlias("MOTIVOSPRODUCCION")

public class Motivosproduccion implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idmotivo") 
	@XStreamAlias("IDMOTIVO") 
	private String idmotivo = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("nombre_corto") 
	@XStreamAlias("NOMBRE_CORTO") 
	private String nombre_corto = "" ;
	@Columna
	@SerializedName("exige_occ") 
	@XStreamAlias("EXIGE_OCC") 
	private Double exige_occ = 0.00 ;
	@Columna
	@SerializedName("insumos_occ") 
	@XStreamAlias("INSUMOS_OCC") 
	private Double insumos_occ = 0.00 ;
	@Columna
	@SerializedName("genera_ingreso") 
	@XStreamAlias("GENERA_INGRESO") 
	private Double genera_ingreso = 0.00 ;
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
	@SerializedName("idmotsalida") 
	@XStreamAlias("IDMOTSALIDA") 
	private String idmotsalida = "" ;
	@Columna
	@SerializedName("ipidecotizacion") 
	@XStreamAlias("IPIDECOTIZACION") 
	private Integer ipidecotizacion;
	@Columna
	@SerializedName("ipidesolicitud") 
	@XStreamAlias("IPIDESOLICITUD") 
	private Integer ipidesolicitud;
	@Columna
	@SerializedName("es_preventivo") 
	@XStreamAlias("ES_PREVENTIVO") 
	private Double es_preventivo = 0.00 ;
	@Columna
	@SerializedName("exige_reqi") 
	@XStreamAlias("EXIGE_REQI") 
	private Double exige_reqi = 0.00 ;
	@Columna
	@SerializedName("no_exige_eqp") 
	@XStreamAlias("NO_EXIGE_EQP") 
	private Double no_exige_eqp = 0.00 ;
	@Columna
	@SerializedName("no_exige_opm") 
	@XStreamAlias("NO_EXIGE_OPM") 
	private Double no_exige_opm = 0.00 ;
	@Columna
	@SerializedName("iddocumento_s") 
	@XStreamAlias("IDDOCUMENTO_S") 
	private String iddocumento_s = "" ;
	@Columna
	@SerializedName("idmotivo_s") 
	@XStreamAlias("IDMOTIVO_S") 
	private String idmotivo_s = "" ;
	@Columna
	@SerializedName("idsucursal_s") 
	@XStreamAlias("IDSUCURSAL_S") 
	private String idsucursal_s = "" ;
	@Columna
	@SerializedName("idalmacen_s") 
	@XStreamAlias("IDALMACEN_S") 
	private String idalmacen_s = "" ;
	@Columna
	@SerializedName("iddocumento_i") 
	@XStreamAlias("IDDOCUMENTO_I") 
	private String iddocumento_i = "" ;
	@Columna
	@SerializedName("idmotivo_i") 
	@XStreamAlias("IDMOTIVO_I") 
	private String idmotivo_i = "" ;
	@Columna
	@SerializedName("idsucursal_i") 
	@XStreamAlias("IDSUCURSAL_I") 
	private String idsucursal_i = "" ;
	@Columna
	@SerializedName("idalmacen_i") 
	@XStreamAlias("IDALMACEN_I") 
	private String idalmacen_i = "" ;
	@Columna
	@SerializedName("almacen_auto") 
	@XStreamAlias("ALMACEN_AUTO") 
	private Double almacen_auto = 0.00 ;
	@Columna
	@SerializedName("serie_i") 
	@XStreamAlias("SERIE_I") 
	private String serie_i = "" ;
	@Columna
	@SerializedName("serie_s") 
	@XStreamAlias("SERIE_S") 
	private String serie_s = "" ;
	@Columna
	@SerializedName("sucursal_cc") 
	@XStreamAlias("SUCURSAL_CC") 
	private Double sucursal_cc = 0.00 ;
	@Columna
	@SerializedName("idconsumidor") 
	@XStreamAlias("IDCONSUMIDOR") 
	private String idconsumidor = "" ;
	@Columna
	@SerializedName("iddocumento_op") 
	@XStreamAlias("IDDOCUMENTO_OP") 
	private String iddocumento_op = "" ;
	@Columna
	@SerializedName("dias") 
	@XStreamAlias("DIAS") 
	private Integer dias;
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("SERIE") 
	private String serie = "" ;
	@Columna
	@SerializedName("es_predictivo") 
	@XStreamAlias("ES_PREDICTIVO") 
	private Double es_predictivo = 0.00 ;
	@Columna
	@SerializedName("idmotivoreqinterno") 
	@XStreamAlias("IDMOTIVOREQINTERNO") 
	private String idmotivoreqinterno = "" ;
	@Columna
	@SerializedName("es_cotizacion") 
	@XStreamAlias("ES_COTIZACION") 
	private Double es_cotizacion = 0.00 ;
	@Columna
	@SerializedName("es_requerimiento") 
	@XStreamAlias("ES_REQUERIMIENTO") 
	private Double es_requerimiento = 0.00 ;
	@Columna
	@SerializedName("es_ingpersonal") 
	@XStreamAlias("ES_INGPERSONAL") 
	private Double es_ingpersonal = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdmotivo(String idmotivo) {
		this.idmotivo = idmotivo;
	}

	public String getIdmotivo() {
		return this.idmotivo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setExige_occ(Double exige_occ) {
		this.exige_occ = exige_occ;
	}

	public Double getExige_occ() {
		return this.exige_occ;
	}

	public void setInsumos_occ(Double insumos_occ) {
		this.insumos_occ = insumos_occ;
	}

	public Double getInsumos_occ() {
		return this.insumos_occ;
	}

	public void setGenera_ingreso(Double genera_ingreso) {
		this.genera_ingreso = genera_ingreso;
	}

	public Double getGenera_ingreso() {
		return this.genera_ingreso;
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

	public void setIdmotsalida(String idmotsalida) {
		this.idmotsalida = idmotsalida;
	}

	public String getIdmotsalida() {
		return this.idmotsalida;
	}

	public void setIpidecotizacion(Integer ipidecotizacion) {
		this.ipidecotizacion = ipidecotizacion;
	}

	public Integer getIpidecotizacion() {
		return this.ipidecotizacion;
	}

	public void setIpidesolicitud(Integer ipidesolicitud) {
		this.ipidesolicitud = ipidesolicitud;
	}

	public Integer getIpidesolicitud() {
		return this.ipidesolicitud;
	}

	public void setEs_preventivo(Double es_preventivo) {
		this.es_preventivo = es_preventivo;
	}

	public Double getEs_preventivo() {
		return this.es_preventivo;
	}

	public void setExige_reqi(Double exige_reqi) {
		this.exige_reqi = exige_reqi;
	}

	public Double getExige_reqi() {
		return this.exige_reqi;
	}

	public void setNo_exige_eqp(Double no_exige_eqp) {
		this.no_exige_eqp = no_exige_eqp;
	}

	public Double getNo_exige_eqp() {
		return this.no_exige_eqp;
	}

	public void setNo_exige_opm(Double no_exige_opm) {
		this.no_exige_opm = no_exige_opm;
	}

	public Double getNo_exige_opm() {
		return this.no_exige_opm;
	}

	public void setIddocumento_s(String iddocumento_s) {
		this.iddocumento_s = iddocumento_s;
	}

	public String getIddocumento_s() {
		return this.iddocumento_s;
	}

	public void setIdmotivo_s(String idmotivo_s) {
		this.idmotivo_s = idmotivo_s;
	}

	public String getIdmotivo_s() {
		return this.idmotivo_s;
	}

	public void setIdsucursal_s(String idsucursal_s) {
		this.idsucursal_s = idsucursal_s;
	}

	public String getIdsucursal_s() {
		return this.idsucursal_s;
	}

	public void setIdalmacen_s(String idalmacen_s) {
		this.idalmacen_s = idalmacen_s;
	}

	public String getIdalmacen_s() {
		return this.idalmacen_s;
	}

	public void setIddocumento_i(String iddocumento_i) {
		this.iddocumento_i = iddocumento_i;
	}

	public String getIddocumento_i() {
		return this.iddocumento_i;
	}

	public void setIdmotivo_i(String idmotivo_i) {
		this.idmotivo_i = idmotivo_i;
	}

	public String getIdmotivo_i() {
		return this.idmotivo_i;
	}

	public void setIdsucursal_i(String idsucursal_i) {
		this.idsucursal_i = idsucursal_i;
	}

	public String getIdsucursal_i() {
		return this.idsucursal_i;
	}

	public void setIdalmacen_i(String idalmacen_i) {
		this.idalmacen_i = idalmacen_i;
	}

	public String getIdalmacen_i() {
		return this.idalmacen_i;
	}

	public void setAlmacen_auto(Double almacen_auto) {
		this.almacen_auto = almacen_auto;
	}

	public Double getAlmacen_auto() {
		return this.almacen_auto;
	}

	public void setSerie_i(String serie_i) {
		this.serie_i = serie_i;
	}

	public String getSerie_i() {
		return this.serie_i;
	}

	public void setSerie_s(String serie_s) {
		this.serie_s = serie_s;
	}

	public String getSerie_s() {
		return this.serie_s;
	}

	public void setSucursal_cc(Double sucursal_cc) {
		this.sucursal_cc = sucursal_cc;
	}

	public Double getSucursal_cc() {
		return this.sucursal_cc;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setIddocumento_op(String iddocumento_op) {
		this.iddocumento_op = iddocumento_op;
	}

	public String getIddocumento_op() {
		return this.iddocumento_op;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getDias() {
		return this.dias;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setEs_predictivo(Double es_predictivo) {
		this.es_predictivo = es_predictivo;
	}

	public Double getEs_predictivo() {
		return this.es_predictivo;
	}

	public void setIdmotivoreqinterno(String idmotivoreqinterno) {
		this.idmotivoreqinterno = idmotivoreqinterno;
	}

	public String getIdmotivoreqinterno() {
		return this.idmotivoreqinterno;
	}

	public void setEs_cotizacion(Double es_cotizacion) {
		this.es_cotizacion = es_cotizacion;
	}

	public Double getEs_cotizacion() {
		return this.es_cotizacion;
	}

	public void setEs_requerimiento(Double es_requerimiento) {
		this.es_requerimiento = es_requerimiento;
	}

	public Double getEs_requerimiento() {
		return this.es_requerimiento;
	}

	public void setEs_ingpersonal(Double es_ingpersonal) {
		this.es_ingpersonal = es_ingpersonal;
	}

	public Double getEs_ingpersonal() {
		return this.es_ingpersonal;
	}



	/* Sets & Gets FK*/

}