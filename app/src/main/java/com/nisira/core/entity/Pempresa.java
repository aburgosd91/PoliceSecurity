package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "PEMPRESA")
@XStreamAlias("PEMPRESA")

public class Pempresa implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("tipoparametro") 
	@XStreamAlias("TIPOPARAMETRO") 
	private String tipoparametro = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("parametro") 
	@XStreamAlias("PARAMETRO") 
	private String parametro = "" ;
	@Columna
	@SerializedName("valor") 
	@XStreamAlias("VALOR") 
	private String valor = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("posicion") 
	@XStreamAlias("POSICION") 
	private String posicion = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@Columna
	@SerializedName("modulo") 
	@XStreamAlias("MODULO") 
	private String modulo = "" ;
	@Columna
	@SerializedName("datoscombo") 
	@XStreamAlias("DATOSCOMBO") 
	private String datoscombo = "" ;
	@Columna
	@SerializedName("tipovalor") 
	@XStreamAlias("TIPOVALOR") 
	private String tipovalor = "" ;
	@Columna
	@SerializedName("desccorta") 
	@XStreamAlias("DESCCORTA") 
	private String desccorta = "" ;
	@Columna
	@SerializedName("desclarga") 
	@XStreamAlias("DESCLARGA") 
	private String desclarga = "" ;
	@Columna
	@SerializedName("valorxdefecto") 
	@XStreamAlias("VALORXDEFECTO") 
	private String valorxdefecto = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("idbasedatos") 
	@XStreamAlias("IDBASEDATOS") 
	private String idbasedatos = "" ;
	@Columna
	@SerializedName("valorlargo") 
	@XStreamAlias("VALORLARGO") 
	private String valorlargo = "" ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setTipoparametro(String tipoparametro) {
		this.tipoparametro = tipoparametro;
	}

	public String getTipoparametro() {
		return this.tipoparametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setDatoscombo(String datoscombo) {
		this.datoscombo = datoscombo;
	}

	public String getDatoscombo() {
		return this.datoscombo;
	}

	public void setTipovalor(String tipovalor) {
		this.tipovalor = tipovalor;
	}

	public String getTipovalor() {
		return this.tipovalor;
	}

	public void setDesccorta(String desccorta) {
		this.desccorta = desccorta;
	}

	public String getDesccorta() {
		return this.desccorta;
	}

	public void setDesclarga(String desclarga) {
		this.desclarga = desclarga;
	}

	public String getDesclarga() {
		return this.desclarga;
	}

	public void setValorxdefecto(String valorxdefecto) {
		this.valorxdefecto = valorxdefecto;
	}

	public String getValorxdefecto() {
		return this.valorxdefecto;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

	public void setValorlargo(String valorlargo) {
		this.valorlargo = valorlargo;
	}

	public String getValorlargo() {
		return this.valorlargo;
	}



	/* Sets & Gets FK*/

}