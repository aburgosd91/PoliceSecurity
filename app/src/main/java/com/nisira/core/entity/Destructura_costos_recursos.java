package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "DESTRUCTURA_COSTOS_RECURSOS")
@XStreamAlias("DESTRUCTURA_COSTOS_RECURSOS")

public class Destructura_costos_recursos implements Serializable {
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
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("tipo_recurso") 
	@XStreamAlias("TIPO_RECURSO") 
	private String tipo_recurso = "" ;
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
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("es_porcentaje") 
	@XStreamAlias("ES_PORCENTAJE") 
	private Double es_porcentaje = 0.00 ;
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("IDMEDIDA") 
	private String idmedida = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idproducto_ec") 
	@XStreamAlias("IDPRODUCTO_EC") 
	private String idproducto_ec = "" ;



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

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}

	public String getTipo_recurso() {
		return this.tipo_recurso;
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

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setEs_porcentaje(Double es_porcentaje) {
		this.es_porcentaje = es_porcentaje;
	}

	public Double getEs_porcentaje() {
		return this.es_porcentaje;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setIdproducto_ec(String idproducto_ec) {
		this.idproducto_ec = idproducto_ec;
	}

	public String getIdproducto_ec() {
		return this.idproducto_ec;
	}



	/* Sets & Gets FK*/

}