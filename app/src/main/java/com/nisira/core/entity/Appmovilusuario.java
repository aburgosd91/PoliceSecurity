package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "APPMOVILUSUARIO")
@XStreamAlias("APPMOVILUSUARIO")

public class Appmovilusuario implements Serializable {
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
	@ClavePrimaria
	@Columna
	@SerializedName("idusuario") 
	@XStreamAlias("IDUSUARIO") 
	private String idusuario = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;



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

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}



	/* Sets & Gets FK*/

}