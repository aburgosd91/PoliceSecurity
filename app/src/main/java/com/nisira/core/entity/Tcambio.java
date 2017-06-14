package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "TCAMBIO")
@XStreamAlias("TCAMBIO")

public class Tcambio implements Serializable {
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("FECHA") 
	private Date fecha;
	@Columna
	@SerializedName("periodo") 
	@XStreamAlias("PERIODO") 
	private String periodo = "" ;
	@Columna
	@SerializedName("b_compra") 
	@XStreamAlias("B_COMPRA") 
	private Double b_compra = 0.00 ;
	@Columna
	@SerializedName("b_venta") 
	@XStreamAlias("B_VENTA") 
	private Double b_venta = 0.00 ;
	@Columna
	@SerializedName("p_compra") 
	@XStreamAlias("P_COMPRA") 
	private Double p_compra = 0.00 ;
	@Columna
	@SerializedName("p_venta") 
	@XStreamAlias("P_VENTA") 
	private Double p_venta = 0.00 ;
	@Columna
	@SerializedName("t_compra") 
	@XStreamAlias("T_COMPRA") 
	private Double t_compra = 0.00 ;
	@Columna
	@SerializedName("t_venta") 
	@XStreamAlias("T_VENTA") 
	private Double t_venta = 0.00 ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("e_compra") 
	@XStreamAlias("E_COMPRA") 
	private Double e_compra = 0.00 ;
	@Columna
	@SerializedName("e_venta") 
	@XStreamAlias("E_VENTA") 
	private Double e_venta = 0.00 ;



	/* Sets & Gets */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setB_compra(Double b_compra) {
		this.b_compra = b_compra;
	}

	public Double getB_compra() {
		return this.b_compra;
	}

	public void setB_venta(Double b_venta) {
		this.b_venta = b_venta;
	}

	public Double getB_venta() {
		return this.b_venta;
	}

	public void setP_compra(Double p_compra) {
		this.p_compra = p_compra;
	}

	public Double getP_compra() {
		return this.p_compra;
	}

	public void setP_venta(Double p_venta) {
		this.p_venta = p_venta;
	}

	public Double getP_venta() {
		return this.p_venta;
	}

	public void setT_compra(Double t_compra) {
		this.t_compra = t_compra;
	}

	public Double getT_compra() {
		return this.t_compra;
	}

	public void setT_venta(Double t_venta) {
		this.t_venta = t_venta;
	}

	public Double getT_venta() {
		return this.t_venta;
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

	public void setE_compra(Double e_compra) {
		this.e_compra = e_compra;
	}

	public Double getE_compra() {
		return this.e_compra;
	}

	public void setE_venta(Double e_venta) {
		this.e_venta = e_venta;
	}

	public Double getE_venta() {
		return this.e_venta;
	}



	/* Sets & Gets FK*/

}