package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS")
@XStreamAlias("ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS")

public class Estructura_costos_mano_obra_cotizacionventas implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("codigo") 
	@XStreamAlias("CODIGO") 
	private String codigo = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcotizacionv") 
	@XStreamAlias("IDCOTIZACIONV") 
	private String idcotizacionv = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@ClavePrimaria
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("costo") 
	@XStreamAlias("COSTO") 
	private Double costo = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getCosto() {
		return this.costo;
	}



	/* Sets & Gets FK*/

}