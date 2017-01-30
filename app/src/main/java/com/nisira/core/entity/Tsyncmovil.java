package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "TSYNCMOVIL")
@XStreamAlias("TSYNCMOVIL")

public class Tsyncmovil implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idappmovil") 
	@XStreamAlias("IDAPPMOVIL") 
	private String idappmovil = "" ;
	@Columna
	@SerializedName("tabla") 
	@XStreamAlias("TABLA") 
	private String tabla = "" ;
	@Columna
	@SerializedName("idseriemovil") 
	@XStreamAlias("IDSERIEMOVIL") 
	private String idseriemovil = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("FECHA") 
	private Date fecha;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdappmovil(String idappmovil) {
		this.idappmovil = idappmovil;
	}

	public String getIdappmovil() {
		return this.idappmovil;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setIdseriemovil(String idseriemovil) {
		this.idseriemovil = idseriemovil;
	}

	public String getIdseriemovil() {
		return this.idseriemovil;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}



	/* Sets & Gets FK*/

}