package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DOCUMENTOS")
@XStreamAlias("DOCUMENTOS")

public class Documentos implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("codigo_sunat") 
	@XStreamAlias("CODIGO_SUNAT") 
	private String codigo_sunat = "" ;
	@Columna
	@SerializedName("es_honorarios") 
	@XStreamAlias("ES_HONORARIOS") 
	private Double es_honorarios = 0.00 ;
	@Columna
	@SerializedName("es_importacion") 
	@XStreamAlias("ES_IMPORTACION") 
	private Double es_importacion = 0.00 ;
	@Columna
	@SerializedName("incluir_cronograma") 
	@XStreamAlias("INCLUIR_CRONOGRAMA") 
	private Double incluir_cronograma = 0.00 ;
	@Columna
	@SerializedName("pide_referencia") 
	@XStreamAlias("PIDE_REFERENCIA") 
	private Double pide_referencia = 0.00 ;
	@Columna
	@SerializedName("registrar_en") 
	@XStreamAlias("REGISTRAR_EN") 
	private String registrar_en = "" ;
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
	@SerializedName("factor") 
	@XStreamAlias("FACTOR") 
	private Double factor = 0.00 ;
	@Columna
	@SerializedName("incluir_igv") 
	@XStreamAlias("INCLUIR_IGV") 
	private Double incluir_igv = 0.00 ;
	@Columna
	@SerializedName("mostrar_en") 
	@XStreamAlias("MOSTRAR_EN") 
	private String mostrar_en = "" ;
	@Columna
	@SerializedName("retener_igv") 
	@XStreamAlias("RETENER_IGV") 
	private Double retener_igv = 0.00 ;
	@Columna
	@SerializedName("es_4ta5ta") 
	@XStreamAlias("ES_4TA5TA") 
	private Double es_4ta5ta = 0.00 ;
	@Columna
	@SerializedName("num_grande") 
	@XStreamAlias("NUM_GRANDE") 
	private Double num_grande = 0.00 ;
	@Columna
	@SerializedName("es_rrhh") 
	@XStreamAlias("ES_RRHH") 
	private Double es_rrhh = 0.00 ;
	@Columna
	@SerializedName("retener_odoc") 
	@XStreamAlias("RETENER_ODOC") 
	private Double retener_odoc = 0.00 ;
	@Columna
	@SerializedName("solo_impuesto") 
	@XStreamAlias("SOLO_IMPUESTO") 
	private Double solo_impuesto = 0.00 ;
	@Columna
	@SerializedName("sin_igv") 
	@XStreamAlias("SIN_IGV") 
	private Double sin_igv = 0.00 ;
	@Columna
	@SerializedName("pide_doccompra") 
	@XStreamAlias("PIDE_DOCCOMPRA") 
	private Double pide_doccompra = 0.00 ;
	@Columna
	@SerializedName("idregistro_sunat") 
	@XStreamAlias("IDREGISTRO_SUNAT") 
	private String idregistro_sunat = "" ;
	@Columna
	@SerializedName("para_declaracion") 
	@XStreamAlias("PARA_DECLARACION") 
	private Double para_declaracion = 0.00 ;
	@Columna
	@SerializedName("es_leasing") 
	@XStreamAlias("ES_LEASING") 
	private Double es_leasing = 0.00 ;
	@Columna
	@SerializedName("es_nodomiciliado") 
	@XStreamAlias("ES_NODOMICILIADO") 
	private Double es_nodomiciliado = 0.00 ;
	@Columna
	@SerializedName("es_noemitido") 
	@XStreamAlias("ES_NOEMITIDO") 
	private Double es_noemitido = 0.00 ;
	@Columna
	@SerializedName("es_electronico") 
	@XStreamAlias("ES_ELECTRONICO") 
	private Double es_electronico = 0.00 ;
	@Columna
	@SerializedName("inicial_docelectronico") 
	@XStreamAlias("INICIAL_DOCELECTRONICO") 
	private String inicial_docelectronico = "" ;
	@Columna
	@SerializedName("incluir_docan_compra_le") 
	@XStreamAlias("INCLUIR_DOCAN_COMPRA_LE") 
	private Double incluir_docan_compra_le = 0.00 ;
	@Columna
	@SerializedName("idtipotitulo_sunat") 
	@XStreamAlias("IDTIPOTITULO_SUNAT") 
	private String idtipotitulo_sunat = "" ;
	@Columna
	@SerializedName("es_dieta") 
	@XStreamAlias("ES_DIETA") 
	private Double es_dieta = 0.00 ;
	@Columna
	@SerializedName("para_ppago") 
	@XStreamAlias("PARA_PPAGO") 
	private Double para_ppago = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public String getCodigo_sunat() {
		return this.codigo_sunat;
	}

	public void setEs_honorarios(Double es_honorarios) {
		this.es_honorarios = es_honorarios;
	}

	public Double getEs_honorarios() {
		return this.es_honorarios;
	}

	public void setEs_importacion(Double es_importacion) {
		this.es_importacion = es_importacion;
	}

	public Double getEs_importacion() {
		return this.es_importacion;
	}

	public void setIncluir_cronograma(Double incluir_cronograma) {
		this.incluir_cronograma = incluir_cronograma;
	}

	public Double getIncluir_cronograma() {
		return this.incluir_cronograma;
	}

	public void setPide_referencia(Double pide_referencia) {
		this.pide_referencia = pide_referencia;
	}

	public Double getPide_referencia() {
		return this.pide_referencia;
	}

	public void setRegistrar_en(String registrar_en) {
		this.registrar_en = registrar_en;
	}

	public String getRegistrar_en() {
		return this.registrar_en;
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

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public Double getFactor() {
		return this.factor;
	}

	public void setIncluir_igv(Double incluir_igv) {
		this.incluir_igv = incluir_igv;
	}

	public Double getIncluir_igv() {
		return this.incluir_igv;
	}

	public void setMostrar_en(String mostrar_en) {
		this.mostrar_en = mostrar_en;
	}

	public String getMostrar_en() {
		return this.mostrar_en;
	}

	public void setRetener_igv(Double retener_igv) {
		this.retener_igv = retener_igv;
	}

	public Double getRetener_igv() {
		return this.retener_igv;
	}

	public void setEs_4ta5ta(Double es_4ta5ta) {
		this.es_4ta5ta = es_4ta5ta;
	}

	public Double getEs_4ta5ta() {
		return this.es_4ta5ta;
	}

	public void setNum_grande(Double num_grande) {
		this.num_grande = num_grande;
	}

	public Double getNum_grande() {
		return this.num_grande;
	}

	public void setEs_rrhh(Double es_rrhh) {
		this.es_rrhh = es_rrhh;
	}

	public Double getEs_rrhh() {
		return this.es_rrhh;
	}

	public void setRetener_odoc(Double retener_odoc) {
		this.retener_odoc = retener_odoc;
	}

	public Double getRetener_odoc() {
		return this.retener_odoc;
	}

	public void setSolo_impuesto(Double solo_impuesto) {
		this.solo_impuesto = solo_impuesto;
	}

	public Double getSolo_impuesto() {
		return this.solo_impuesto;
	}

	public void setSin_igv(Double sin_igv) {
		this.sin_igv = sin_igv;
	}

	public Double getSin_igv() {
		return this.sin_igv;
	}

	public void setPide_doccompra(Double pide_doccompra) {
		this.pide_doccompra = pide_doccompra;
	}

	public Double getPide_doccompra() {
		return this.pide_doccompra;
	}

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setPara_declaracion(Double para_declaracion) {
		this.para_declaracion = para_declaracion;
	}

	public Double getPara_declaracion() {
		return this.para_declaracion;
	}

	public void setEs_leasing(Double es_leasing) {
		this.es_leasing = es_leasing;
	}

	public Double getEs_leasing() {
		return this.es_leasing;
	}

	public void setEs_nodomiciliado(Double es_nodomiciliado) {
		this.es_nodomiciliado = es_nodomiciliado;
	}

	public Double getEs_nodomiciliado() {
		return this.es_nodomiciliado;
	}

	public void setEs_noemitido(Double es_noemitido) {
		this.es_noemitido = es_noemitido;
	}

	public Double getEs_noemitido() {
		return this.es_noemitido;
	}

	public void setEs_electronico(Double es_electronico) {
		this.es_electronico = es_electronico;
	}

	public Double getEs_electronico() {
		return this.es_electronico;
	}

	public void setInicial_docelectronico(String inicial_docelectronico) {
		this.inicial_docelectronico = inicial_docelectronico;
	}

	public String getInicial_docelectronico() {
		return this.inicial_docelectronico;
	}

	public void setIncluir_docan_compra_le(Double incluir_docan_compra_le) {
		this.incluir_docan_compra_le = incluir_docan_compra_le;
	}

	public Double getIncluir_docan_compra_le() {
		return this.incluir_docan_compra_le;
	}

	public void setIdtipotitulo_sunat(String idtipotitulo_sunat) {
		this.idtipotitulo_sunat = idtipotitulo_sunat;
	}

	public String getIdtipotitulo_sunat() {
		return this.idtipotitulo_sunat;
	}

	public void setEs_dieta(Double es_dieta) {
		this.es_dieta = es_dieta;
	}

	public Double getEs_dieta() {
		return this.es_dieta;
	}

	public void setPara_ppago(Double para_ppago) {
		this.para_ppago = para_ppago;
	}

	public Double getPara_ppago() {
		return this.para_ppago;
	}



	/* Sets & Gets FK*/

}