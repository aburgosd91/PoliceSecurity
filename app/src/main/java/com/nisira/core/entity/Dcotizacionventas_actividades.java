package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "DCOTIZACIONVENTAS_ACTIVIDADES")
@XStreamAlias("DCOTIZACIONVENTAS_ACTIVIDADES")

public class Dcotizacionventas_actividades implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcotizacionv") 
	@XStreamAlias("IDCOTIZACIONV") 
	private String idcotizacionv = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("itemc") 
	@XStreamAlias("ITEMC") 
	private String itemc = "" ;
	@Columna
	@SerializedName("itemref") 
	@XStreamAlias("ITEMREF") 
	private String itemref = "" ;
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("cantidad") 
	@XStreamAlias("CANTIDAD") 
	private Double cantidad = 0.00 ;
	@Columna
	@SerializedName("costo") 
	@XStreamAlias("COSTO") 
	private Double costo = 0.00 ;
	@Columna
	@SerializedName("total") 
	@XStreamAlias("TOTAL") 
	private Double total = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setItemc(String itemc) {
		this.itemc = itemc;
	}

	public String getItemc() {
		return this.itemc;
	}

	public void setItemref(String itemref) {
		this.itemref = itemref;
	}

	public String getItemref() {
		return this.itemref;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getCosto() {
		return this.costo;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotal() {
		return this.total;
	}



	/* Sets & Gets FK*/

}