package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "CODOPERACIONES_PSS")
@XStreamAlias("CODOPERACIONES_PSS")

public class Codoperaciones_pss implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idcodoperaciones") 
	@XStreamAlias("IDCODOPERACIONES") 
	private String idcodoperaciones = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("descripcion_corta") 
	@XStreamAlias("DESCRIPCION_CORTA") 
	private String descripcion_corta = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;



	/* Sets & Gets */
	public void setIdcodoperaciones(String idcodoperaciones) {
		this.idcodoperaciones = idcodoperaciones;
	}

	public String getIdcodoperaciones() {
		return this.idcodoperaciones;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}

	public String getDescripcion_corta() {
		return this.descripcion_corta;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}