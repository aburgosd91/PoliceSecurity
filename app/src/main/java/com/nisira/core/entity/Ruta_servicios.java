package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "RUTA_SERVICIOS")
@XStreamAlias("RUTA_SERVICIOS")

public class Ruta_servicios implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idordenservicio") 
	@XStreamAlias("IDORDENSERVICIO") 
	private String idordenservicio = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("itemruta") 
	@XStreamAlias("ITEMRUTA") 
	private String itemruta = "" ;
	@Columna
	@SerializedName("idruta") 
	@XStreamAlias("IDRUTA") 
	private String idruta = "" ;
	@Columna
	@SerializedName("latitud") 
	@XStreamAlias("LATITUD") 
	private String latitud = "" ;
	@Columna
	@SerializedName("longitud") 
	@XStreamAlias("LONGITUD") 
	private String longitud = "" ;
	@Columna
	@SerializedName("glosa") 
	@XStreamAlias("GLOSA") 
	private String glosa = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setItemruta(String itemruta) {
		this.itemruta = itemruta;
	}

	public String getItemruta() {
		return this.itemruta;
	}

	public void setIdruta(String idruta) {
		this.idruta = idruta;
	}

	public String getIdruta() {
		return this.idruta;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}



	/* Sets & Gets FK*/

}