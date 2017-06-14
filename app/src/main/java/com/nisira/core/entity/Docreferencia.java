package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DOCREFERENCIA")
@XStreamAlias("DOCREFERENCIA")

public class Docreferencia implements Serializable {
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@Columna
	@SerializedName("idorigen") 
	@XStreamAlias("IDORIGEN") 
	private String idorigen = "" ;
	@Columna
	@SerializedName("tabla") 
	@XStreamAlias("TABLA") 
	private String tabla = "" ;
	@Columna
	@SerializedName("idreferencia") 
	@XStreamAlias("IDREFERENCIA") 
	private String idreferencia = "" ;
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("SERIE") 
	private String serie = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	private String numero = "" ;
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("FECHA") 
	private Date fecha;
	@Columna
	@SerializedName("exonerado") 
	@XStreamAlias("EXONERADO") 
	private Double exonerado = 0.00 ;
	@Columna
	@SerializedName("archivar") 
	@XStreamAlias("ARCHIVAR") 
	private Double archivar = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorigen(String idorigen) {
		this.idorigen = idorigen;
	}

	public String getIdorigen() {
		return this.idorigen;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setIdreferencia(String idreferencia) {
		this.idreferencia = idreferencia;
	}

	public String getIdreferencia() {
		return this.idreferencia;
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setExonerado(Double exonerado) {
		this.exonerado = exonerado;
	}

	public Double getExonerado() {
		return this.exonerado;
	}

	public void setArchivar(Double archivar) {
		this.archivar = archivar;
	}

	public Double getArchivar() {
		return this.archivar;
	}



	/* Sets & Gets FK*/

}