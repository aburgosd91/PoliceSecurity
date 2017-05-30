package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "TURNO_TRABAJO")
@XStreamAlias("TURNO_TRABAJO")

public class Turno_trabajo implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idturnotrabajo") 
	@XStreamAlias("IDTURNOTRABAJO") 
	private String idturnotrabajo = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("desde") 
	@XStreamAlias("DESDE") 
	private Double desde = 0.00 ;
	@Columna
	@SerializedName("hasta") 
	@XStreamAlias("HASTA") 
	private Double hasta = 0.00 ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("mingreso") 
	@XStreamAlias("MINGRESO") 
	private Double mingreso = 0.00 ;
	@Columna
	@SerializedName("msalida") 
	@XStreamAlias("MSALIDA") 
	private Double msalida = 0.00 ;
	@Columna
	@SerializedName("hrefrigerio") 
	@XStreamAlias("HREFRIGERIO") 
	private Double hrefrigerio = 0.00 ;
	@Columna
	@SerializedName("mrefrigerio") 
	@XStreamAlias("MREFRIGERIO") 
	private Double mrefrigerio = 0.00 ;
	@Columna
	@SerializedName("hextra") 
	@XStreamAlias("HEXTRA") 
	private Double hextra = 0.00 ;
	@Columna
	@SerializedName("mextra") 
	@XStreamAlias("MEXTRA") 
	private Double mextra = 0.00 ;
	@Columna
	@SerializedName("refhdesde") 
	@XStreamAlias("REFHDESDE") 
	private Double refhdesde = 0.00 ;
	@Columna
	@SerializedName("refmdesde") 
	@XStreamAlias("REFMDESDE") 
	private Double refmdesde = 0.00 ;
	@Columna
	@SerializedName("refhhasta") 
	@XStreamAlias("REFHHASTA") 
	private Double refhhasta = 0.00 ;
	@Columna
	@SerializedName("refmhasta") 
	@XStreamAlias("REFMHASTA") 
	private Double refmhasta = 0.00 ;
	@Columna
	@SerializedName("diasgte") 
	@XStreamAlias("DIASGTE") 
	private Double diasgte = 0.00 ;
	@Columna
	@SerializedName("slsalida") 
	@XStreamAlias("SLSALIDA") 
	private Double slsalida = 0.00 ;
	@Columna
	@SerializedName("fds") 
	@XStreamAlias("FDS") 
	private Double fds = 0.00 ;
	@Columna
	@SerializedName("amanecida") 
	@XStreamAlias("AMANECIDA") 
	private Double amanecida = 0.00 ;
	@Columna
	@SerializedName("notardanza1") 
	@XStreamAlias("NOTARDANZA1") 
	private Double notardanza1 = 0.00 ;
	@Columna
	@SerializedName("mtolerancia") 
	@XStreamAlias("MTOLERANCIA") 
	private Double mtolerancia = 0.00 ;
	@Columna
	@SerializedName("hdurmax") 
	@XStreamAlias("HDURMAX") 
	private Double hdurmax = 0.00 ;
	@Columna
	@SerializedName("mdurmax") 
	@XStreamAlias("MDURMAX") 
	private Double mdurmax = 0.00 ;



	/* Sets & Gets */
	public void setIdturnotrabajo(String idturnotrabajo) {
		this.idturnotrabajo = idturnotrabajo;
	}

	public String getIdturnotrabajo() {
		return this.idturnotrabajo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDesde(Double desde) {
		this.desde = desde;
	}

	public Double getDesde() {
		return this.desde;
	}

	public void setHasta(Double hasta) {
		this.hasta = hasta;
	}

	public Double getHasta() {
		return this.hasta;
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

	public void setMingreso(Double mingreso) {
		this.mingreso = mingreso;
	}

	public Double getMingreso() {
		return this.mingreso;
	}

	public void setMsalida(Double msalida) {
		this.msalida = msalida;
	}

	public Double getMsalida() {
		return this.msalida;
	}

	public void setHrefrigerio(Double hrefrigerio) {
		this.hrefrigerio = hrefrigerio;
	}

	public Double getHrefrigerio() {
		return this.hrefrigerio;
	}

	public void setMrefrigerio(Double mrefrigerio) {
		this.mrefrigerio = mrefrigerio;
	}

	public Double getMrefrigerio() {
		return this.mrefrigerio;
	}

	public void setHextra(Double hextra) {
		this.hextra = hextra;
	}

	public Double getHextra() {
		return this.hextra;
	}

	public void setMextra(Double mextra) {
		this.mextra = mextra;
	}

	public Double getMextra() {
		return this.mextra;
	}

	public void setRefhdesde(Double refhdesde) {
		this.refhdesde = refhdesde;
	}

	public Double getRefhdesde() {
		return this.refhdesde;
	}

	public void setRefmdesde(Double refmdesde) {
		this.refmdesde = refmdesde;
	}

	public Double getRefmdesde() {
		return this.refmdesde;
	}

	public void setRefhhasta(Double refhhasta) {
		this.refhhasta = refhhasta;
	}

	public Double getRefhhasta() {
		return this.refhhasta;
	}

	public void setRefmhasta(Double refmhasta) {
		this.refmhasta = refmhasta;
	}

	public Double getRefmhasta() {
		return this.refmhasta;
	}

	public void setDiasgte(Double diasgte) {
		this.diasgte = diasgte;
	}

	public Double getDiasgte() {
		return this.diasgte;
	}

	public void setSlsalida(Double slsalida) {
		this.slsalida = slsalida;
	}

	public Double getSlsalida() {
		return this.slsalida;
	}

	public void setFds(Double fds) {
		this.fds = fds;
	}

	public Double getFds() {
		return this.fds;
	}

	public void setAmanecida(Double amanecida) {
		this.amanecida = amanecida;
	}

	public Double getAmanecida() {
		return this.amanecida;
	}

	public void setNotardanza1(Double notardanza1) {
		this.notardanza1 = notardanza1;
	}

	public Double getNotardanza1() {
		return this.notardanza1;
	}

	public void setMtolerancia(Double mtolerancia) {
		this.mtolerancia = mtolerancia;
	}

	public Double getMtolerancia() {
		return this.mtolerancia;
	}

	public void setHdurmax(Double hdurmax) {
		this.hdurmax = hdurmax;
	}

	public Double getHdurmax() {
		return this.hdurmax;
	}

	public void setMdurmax(Double mdurmax) {
		this.mdurmax = mdurmax;
	}

	public Double getMdurmax() {
		return this.mdurmax;
	}



	/* Sets & Gets FK*/

}