package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "ESTRUCTURA_COSTOS_PRODUCTO")
@XStreamAlias("ESTRUCTURA_COSTOS_PRODUCTO")

public class Estructura_costos_producto implements Serializable {
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
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("ajuste") 
	@XStreamAlias("AJUSTE") 
	private Double ajuste = 0.00 ;
	@Columna
	@SerializedName("nhoras") 
	@XStreamAlias("NHORAS") 
	private Double nhoras = 0.00 ;
	@Columna
	@SerializedName("codoperativo") 
	@XStreamAlias("CODOPERATIVO") 
	private String codoperativo = "" ;
	@Columna
	@SerializedName("idruta") 
	@XStreamAlias("IDRUTA") 
	private String idruta = "" ;



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

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setAjuste(Double ajuste) {
		this.ajuste = ajuste;
	}

	public Double getAjuste() {
		return this.ajuste;
	}

	public void setNhoras(Double nhoras) {
		this.nhoras = nhoras;
	}

	public Double getNhoras() {
		return this.nhoras;
	}

	public void setCodoperativo(String codoperativo) {
		this.codoperativo = codoperativo;
	}

	public String getCodoperativo() {
		return this.codoperativo;
	}

	public void setIdruta(String idruta) {
		this.idruta = idruta;
	}

	public String getIdruta() {
		return this.idruta;
	}



	/* Sets & Gets FK*/

}