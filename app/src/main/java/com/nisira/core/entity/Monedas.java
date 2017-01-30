package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "MONEDAS")
@XStreamAlias("MONEDAS")

public class Monedas implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idmoneda") 
	@XStreamAlias("IDMONEDA") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("nombre_corto") 
	@XStreamAlias("NOMBRE_CORTO") 
	private String nombre_corto = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("tipo_moneda") 
	@XStreamAlias("TIPO_MONEDA") 
	private String tipo_moneda = "" ;
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
	@SerializedName("idregistro_sunat") 
	@XStreamAlias("IDREGISTRO_SUNAT") 
	private String idregistro_sunat = "" ;
	@Columna
	@SerializedName("descripcion_ingles") 
	@XStreamAlias("DESCRIPCION_INGLES") 
	private String descripcion_ingles = "" ;
	@Columna
	@SerializedName("tipo_busqueda") 
	@XStreamAlias("TIPO_BUSQUEDA") 
	private String tipo_busqueda = "" ;
	@Columna
	@SerializedName("descripcion2") 
	@XStreamAlias("DESCRIPCION2") 
	private String descripcion2 = "" ;
	@Columna
	@SerializedName("idbusqueda") 
	@XStreamAlias("IDBUSQUEDA") 
	private String idbusqueda = "" ;
	@Columna
	@SerializedName("difdias") 
	@XStreamAlias("DIFDIAS") 
	private Double difdias = 0.00 ;
	@Columna
	@SerializedName("orden_ajuste") 
	@XStreamAlias("ORDEN_AJUSTE") 
	private Double orden_ajuste = 0.00 ;



	/* Sets & Gets */
	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}

	public String getTipo_moneda() {
		return this.tipo_moneda;
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

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setDescripcion_ingles(String descripcion_ingles) {
		this.descripcion_ingles = descripcion_ingles;
	}

	public String getDescripcion_ingles() {
		return this.descripcion_ingles;
	}

	public void setTipo_busqueda(String tipo_busqueda) {
		this.tipo_busqueda = tipo_busqueda;
	}

	public String getTipo_busqueda() {
		return this.tipo_busqueda;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setIdbusqueda(String idbusqueda) {
		this.idbusqueda = idbusqueda;
	}

	public String getIdbusqueda() {
		return this.idbusqueda;
	}

	public void setDifdias(Double difdias) {
		this.difdias = difdias;
	}

	public Double getDifdias() {
		return this.difdias;
	}

	public void setOrden_ajuste(Double orden_ajuste) {
		this.orden_ajuste = orden_ajuste;
	}

	public Double getOrden_ajuste() {
		return this.orden_ajuste;
	}



	/* Sets & Gets FK*/

}