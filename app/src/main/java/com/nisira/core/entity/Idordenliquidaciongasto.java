package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "IDORDENLIQUIDACIONGASTO")
@XStreamAlias("IDORDENLIQUIDACIONGASTO")

public class Idordenliquidaciongasto implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idorden") 
	@XStreamAlias("IDORDEN") 
	private String idorden = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("idimpuesto") 
	@XStreamAlias("IDIMPUESTO") 
	private String idimpuesto = "" ;
	@Columna
	@SerializedName("subitem") 
	@XStreamAlias("SUBITEM") 
	private String subitem = "" ;
	@Columna
	@SerializedName("valor") 
	@XStreamAlias("VALOR") 
	private Double valor = 0.00 ;
	@Columna
	@SerializedName("baseimponible") 
	@XStreamAlias("BASEIMPONIBLE") 
	private Double baseimponible = 0.00 ;
	@Columna
	@SerializedName("impuesto") 
	@XStreamAlias("IMPUESTO") 
	private Double impuesto = 0.00 ;
	@Columna
	@SerializedName("idcuenta") 
	@XStreamAlias("IDCUENTA") 
	private String idcuenta = "" ;
	@Columna
	@SerializedName("idccosto") 
	@XStreamAlias("IDCCOSTO") 
	private String idccosto = "" ;
	@Columna
	@SerializedName("orden") 
	@XStreamAlias("ORDEN") 
	private Double orden = 0.00 ;
	@Columna
	@SerializedName("porcentual") 
	@XStreamAlias("PORCENTUAL") 
	private Double porcentual = 0.00 ;
	@Columna
	@SerializedName("aplicaianterior") 
	@XStreamAlias("APLICAIANTERIOR") 
	private Double aplicaianterior = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorden(String idorden) {
		this.idorden = idorden;
	}

	public String getIdorden() {
		return this.idorden;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setIdimpuesto(String idimpuesto) {
		this.idimpuesto = idimpuesto;
	}

	public String getIdimpuesto() {
		return this.idimpuesto;
	}

	public void setSubitem(String subitem) {
		this.subitem = subitem;
	}

	public String getSubitem() {
		return this.subitem;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setBaseimponible(Double baseimponible) {
		this.baseimponible = baseimponible;
	}

	public Double getBaseimponible() {
		return this.baseimponible;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getImpuesto() {
		return this.impuesto;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setOrden(Double orden) {
		this.orden = orden;
	}

	public Double getOrden() {
		return this.orden;
	}

	public void setPorcentual(Double porcentual) {
		this.porcentual = porcentual;
	}

	public Double getPorcentual() {
		return this.porcentual;
	}

	public void setAplicaianterior(Double aplicaianterior) {
		this.aplicaianterior = aplicaianterior;
	}

	public Double getAplicaianterior() {
		return this.aplicaianterior;
	}



	/* Sets & Gets FK*/

}