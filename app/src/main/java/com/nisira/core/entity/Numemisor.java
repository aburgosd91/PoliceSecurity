package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "NUMEMISOR")
@XStreamAlias("NUMEMISOR")

public class Numemisor implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idemisor") 
	@XStreamAlias("IDEMISOR") 
	private String idemisor = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("SERIE") 
	private String serie = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	private String numero = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@Columna
	@SerializedName("es_importacion") 
	@XStreamAlias("ES_IMPORTACION") 
	private Double es_importacion = 0.00 ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("nlineas") 
	@XStreamAlias("NLINEAS") 
	private Double nlineas = 0.00 ;
	@Columna
	@SerializedName("observacion") 
	@XStreamAlias("OBSERVACION") 
	private String observacion = "" ;
	@Columna
	@SerializedName("idtipoventa") 
	@XStreamAlias("IDTIPOVENTA") 
	private String idtipoventa = "" ;
	@Columna
	@SerializedName("paradeclaracion_ce") 
	@XStreamAlias("PARADECLARACION_CE") 
	private Double paradeclaracion_ce = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
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

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}

	public void setEs_importacion(Double es_importacion) {
		this.es_importacion = es_importacion;
	}

	public Double getEs_importacion() {
		return this.es_importacion;
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

	public void setNlineas(Double nlineas) {
		this.nlineas = nlineas;
	}

	public Double getNlineas() {
		return this.nlineas;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setIdtipoventa(String idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public String getIdtipoventa() {
		return this.idtipoventa;
	}

	public void setParadeclaracion_ce(Double paradeclaracion_ce) {
		this.paradeclaracion_ce = paradeclaracion_ce;
	}

	public Double getParadeclaracion_ce() {
		return this.paradeclaracion_ce;
	}



	/* Sets & Gets FK*/

}