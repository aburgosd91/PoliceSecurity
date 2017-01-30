package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "CONCEPTO_CUENTA")
@XStreamAlias("CONCEPTO_CUENTA")

public class Concepto_cuenta implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idconcepto") 
	@XStreamAlias("IDCONCEPTO") 
	private String idconcepto = "" ;
	@Columna
	@SerializedName("idcuenta") 
	@XStreamAlias("IDCUENTA") 
	private String idcuenta = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
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



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdconcepto(String idconcepto) {
		this.idconcepto = idconcepto;
	}

	public String getIdconcepto() {
		return this.idconcepto;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
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



	/* Sets & Gets FK*/

}