package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "RUTA")
@XStreamAlias("RUTA")

public class Ruta implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idruta") 
	@XStreamAlias("IDRUTA") 
	private Integer idruta;
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@Columna
	@SerializedName("nroruta") 
	@XStreamAlias("NRORUTA") 
	private String nroruta = "" ;
	@Columna
	@SerializedName("denominacionruta") 
	@XStreamAlias("DENOMINACIONRUTA") 
	private String denominacionruta = "" ;
	@Columna
	@SerializedName("idtiporuta") 
	@XStreamAlias("IDTIPORUTA") 
	private Integer idtiporuta;
	@Columna
	@SerializedName("idterminalorigen") 
	@XStreamAlias("IDTERMINALORIGEN") 
	private Integer idterminalorigen;
	@Columna
	@SerializedName("idterminaldestino") 
	@XStreamAlias("IDTERMINALDESTINO") 
	private Integer idterminaldestino;
	@Columna
	@SerializedName("distancia") 
	@XStreamAlias("DISTANCIA") 
	private Double distancia = 0.00 ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@Columna
	@SerializedName("maxpasajero") 
	@XStreamAlias("MAXPASAJERO") 
	private Double maxpasajero = 0.00 ;
	@Columna
	@SerializedName("ciclovuelo") 
	@XStreamAlias("CICLOVUELO") 
	private Integer ciclovuelo;
	@Columna
	@SerializedName("rutamultiple") 
	@XStreamAlias("RUTAMULTIPLE") 
	private Integer rutamultiple;
	@Columna
	@SerializedName("idtipoventa") 
	@XStreamAlias("IDTIPOVENTA") 
	private String idtipoventa = "" ;



	/* Sets & Gets */
	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}

	public Integer getIdruta() {
		return this.idruta;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setNroruta(String nroruta) {
		this.nroruta = nroruta;
	}

	public String getNroruta() {
		return this.nroruta;
	}

	public void setDenominacionruta(String denominacionruta) {
		this.denominacionruta = denominacionruta;
	}

	public String getDenominacionruta() {
		return this.denominacionruta;
	}

	public void setIdtiporuta(Integer idtiporuta) {
		this.idtiporuta = idtiporuta;
	}

	public Integer getIdtiporuta() {
		return this.idtiporuta;
	}

	public void setIdterminalorigen(Integer idterminalorigen) {
		this.idterminalorigen = idterminalorigen;
	}

	public Integer getIdterminalorigen() {
		return this.idterminalorigen;
	}

	public void setIdterminaldestino(Integer idterminaldestino) {
		this.idterminaldestino = idterminaldestino;
	}

	public Integer getIdterminaldestino() {
		return this.idterminaldestino;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getDistancia() {
		return this.distancia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
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

	public void setMaxpasajero(Double maxpasajero) {
		this.maxpasajero = maxpasajero;
	}

	public Double getMaxpasajero() {
		return this.maxpasajero;
	}

	public void setCiclovuelo(Integer ciclovuelo) {
		this.ciclovuelo = ciclovuelo;
	}

	public Integer getCiclovuelo() {
		return this.ciclovuelo;
	}

	public void setRutamultiple(Integer rutamultiple) {
		this.rutamultiple = rutamultiple;
	}

	public Integer getRutamultiple() {
		return this.rutamultiple;
	}

	public void setIdtipoventa(String idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public String getIdtipoventa() {
		return this.idtipoventa;
	}



	/* Sets & Gets FK*/

}