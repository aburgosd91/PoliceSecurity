package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "ORDENSERVICIOCLIENTE")
@XStreamAlias("ORDENSERVICIOCLIENTE")

public class Ordenserviciocliente implements Serializable {
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
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("SERIE") 
	private String serie = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	private String numero = "" ;
	@Columna
	@SerializedName("nromanual") 
	@XStreamAlias("NROMANUAL") 
	private String nromanual = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("FECHA") 
	private Date fecha;
	@Columna
	@SerializedName("tipo_servicio") 
	@XStreamAlias("TIPO_SERVICIO") 
	private String tipo_servicio = "" ;
	@Columna
	@SerializedName("ambito_servicio") 
	@XStreamAlias("AMBITO_SERVICIO") 
	private String ambito_servicio = "" ;
	@Columna
	@SerializedName("idestado") 
	@XStreamAlias("IDESTADO") 
	private String idestado = "" ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("nrocontenedor") 
	@XStreamAlias("NROCONTENEDOR") 
	private String nrocontenedor = "" ;
	@Columna
	@SerializedName("nroprecinto") 
	@XStreamAlias("NROPRECINTO") 
	private String nroprecinto = "" ;
	@Columna
	@SerializedName("nro_oservicio") 
	@XStreamAlias("NRO_OSERVICIO") 
	private String nro_oservicio = "" ;
	private String cliente = "";
	private String ruc = "";

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

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNromanual(String nromanual) {
		this.nromanual = nromanual;
	}

	public String getNromanual() {
		return this.nromanual;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getTipo_servicio() {
		return this.tipo_servicio;
	}

	public void setAmbito_servicio(String ambito_servicio) {
		this.ambito_servicio = ambito_servicio;
	}

	public String getAmbito_servicio() {
		return this.ambito_servicio;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
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

	public void setNrocontenedor(String nrocontenedor) {
		this.nrocontenedor = nrocontenedor;
	}

	public String getNrocontenedor() {
		return this.nrocontenedor;
	}

	public void setNroprecinto(String nroprecinto) {
		this.nroprecinto = nroprecinto;
	}

	public String getNroprecinto() {
		return this.nroprecinto;
	}

	public void setNro_oservicio(String nro_oservicio) {
		this.nro_oservicio = nro_oservicio;
	}

	public String getNro_oservicio() {
		return this.nro_oservicio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}





	/* Sets & Gets FK*/

}