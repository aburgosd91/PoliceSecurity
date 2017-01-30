package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "CONSUMIDOR")
@XStreamAlias("CONSUMIDOR")

public class Consumidor implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idconsumidor") 
	@XStreamAlias("IDCONSUMIDOR") 
	private String idconsumidor = "" ;
	@Columna
	@SerializedName("tipo") 
	@XStreamAlias("TIPO") 
	private String tipo = "" ;
	@Columna
	@SerializedName("jerarquia") 
	@XStreamAlias("JERARQUIA") 
	private String jerarquia = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("idccosto") 
	@XStreamAlias("IDCCOSTO") 
	private String idccosto = "" ;
	@Columna
	@SerializedName("fecha_ingreso") 
	@XStreamAlias("FECHA_INGRESO") 
	private Date fecha_ingreso;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("IDSUCURSAL") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("area") 
	@XStreamAlias("AREA") 
	private Double area = 0.00 ;
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
	@SerializedName("kminicial") 
	@XStreamAlias("KMINICIAL") 
	private Double kminicial = 0.00 ;
	@Columna
	@SerializedName("kilometros") 
	@XStreamAlias("KILOMETROS") 
	private Double kilometros = 0.00 ;
	@Columna
	@SerializedName("idnivelconsumidor") 
	@XStreamAlias("IDNIVELCONSUMIDOR") 
	private String idnivelconsumidor = "" ;
	@Columna
	@SerializedName("es_titulo") 
	@XStreamAlias("ES_TITULO") 
	private Double es_titulo = 0.00 ;
	@Columna
	@SerializedName("final_") 
	@XStreamAlias("FINAL_") 
	private Double final_ = 0.00 ;
	@Columna
	@SerializedName("es_produccion") 
	@XStreamAlias("ES_PRODUCCION") 
	private Double es_produccion = 0.00 ;
	@Columna
	@SerializedName("idunidadnegocio") 
	@XStreamAlias("IDUNIDADNEGOCIO") 
	private String idunidadnegocio = "" ;
	@Columna
	@SerializedName("idclaseccosto") 
	@XStreamAlias("IDCLASECCOSTO") 
	private String idclaseccosto = "" ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}

	public String getJerarquia() {
		return this.jerarquia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_ingreso() {
		return this.fecha_ingreso;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getArea() {
		return this.area;
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

	public void setKminicial(Double kminicial) {
		this.kminicial = kminicial;
	}

	public Double getKminicial() {
		return this.kminicial;
	}

	public void setKilometros(Double kilometros) {
		this.kilometros = kilometros;
	}

	public Double getKilometros() {
		return this.kilometros;
	}

	public void setIdnivelconsumidor(String idnivelconsumidor) {
		this.idnivelconsumidor = idnivelconsumidor;
	}

	public String getIdnivelconsumidor() {
		return this.idnivelconsumidor;
	}

	public void setEs_titulo(Double es_titulo) {
		this.es_titulo = es_titulo;
	}

	public Double getEs_titulo() {
		return this.es_titulo;
	}

	public void setFinal_(Double final_) {
		this.final_ = final_;
	}

	public Double getFinal_() {
		return this.final_;
	}

	public void setEs_produccion(Double es_produccion) {
		this.es_produccion = es_produccion;
	}

	public Double getEs_produccion() {
		return this.es_produccion;
	}

	public void setIdunidadnegocio(String idunidadnegocio) {
		this.idunidadnegocio = idunidadnegocio;
	}

	public String getIdunidadnegocio() {
		return this.idunidadnegocio;
	}

	public void setIdclaseccosto(String idclaseccosto) {
		this.idclaseccosto = idclaseccosto;
	}

	public String getIdclaseccosto() {
		return this.idclaseccosto;
	}



	/* Sets & Gets FK*/

}