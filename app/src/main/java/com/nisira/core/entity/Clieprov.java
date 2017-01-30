package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "CLIEPROV")
@XStreamAlias("CLIEPROV")

public class Clieprov implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("tipo_clieprov") 
	@XStreamAlias("TIPO_CLIEPROV") 
	private String tipo_clieprov = "" ;
	@Columna
	@SerializedName("tipopersona") 
	@XStreamAlias("TIPOPERSONA") 
	private String tipopersona = "" ;
	@Columna
	@SerializedName("idtipocliente") 
	@XStreamAlias("IDTIPOCLIENTE") 
	private String idtipocliente = "" ;
	@Columna
	@SerializedName("contacto") 
	@XStreamAlias("CONTACTO") 
	private String contacto = "" ;
	@Columna
	@SerializedName("direccion") 
	@XStreamAlias("DIRECCION") 
	private String direccion = "" ;
	@Columna
	@SerializedName("idubigeo1") 
	@XStreamAlias("IDUBIGEO1") 
	private String idubigeo1 = "" ;
	@Columna
	@SerializedName("distrito") 
	@XStreamAlias("DISTRITO") 
	private String distrito = "" ;
	@Columna
	@SerializedName("departamento") 
	@XStreamAlias("DEPARTAMENTO") 
	private String departamento = "" ;
	@Columna
	@SerializedName("apellidopaterno") 
	@XStreamAlias("APELLIDOPATERNO") 
	private String apellidopaterno = "" ;
	@Columna
	@SerializedName("apellidomaterno") 
	@XStreamAlias("APELLIDOMATERNO") 
	private String apellidomaterno = "" ;
	@Columna
	@SerializedName("nombres") 
	@XStreamAlias("NOMBRES") 
	private String nombres = "" ;
	@Columna
	@SerializedName("razon_social") 
	@XStreamAlias("RAZON_SOCIAL") 
	private String razon_social = "" ;
	@Columna
	@SerializedName("iddocidentidad") 
	@XStreamAlias("IDDOCIDENTIDAD") 
	private String iddocidentidad = "" ;
	@Columna
	@SerializedName("nrodocidentidad") 
	@XStreamAlias("NRODOCIDENTIDAD") 
	private String nrodocidentidad = "" ;
	@Columna
	@SerializedName("dni") 
	@XStreamAlias("DNI") 
	private String dni = "" ;
	@Columna
	@SerializedName("provincia") 
	@XStreamAlias("PROVINCIA") 
	private String provincia = "" ;
	@Columna
	@SerializedName("ruc") 
	@XStreamAlias("RUC") 
	private String ruc = "" ;
	@Columna
	@SerializedName("idpersonal") 
	@XStreamAlias("IDPERSONAL") 
	private String idpersonal = "" ;
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
	@SerializedName("sexo") 
	@XStreamAlias("SEXO") 
	private String sexo = "" ;
	@Columna
	@SerializedName("idestadocivil") 
	@XStreamAlias("IDESTADOCIVIL") 
	private String idestadocivil = "" ;
	@Columna
	@SerializedName("codequivalente") 
	@XStreamAlias("CODEQUIVALENTE") 
	private String codequivalente = "" ;
	@Columna
	@SerializedName("seleccion") 
	@XStreamAlias("SELECCION") 
	private Integer seleccion;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setTipo_clieprov(String tipo_clieprov) {
		this.tipo_clieprov = tipo_clieprov;
	}

	public String getTipo_clieprov() {
		return this.tipo_clieprov;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setIdtipocliente(String idtipocliente) {
		this.idtipocliente = idtipocliente;
	}

	public String getIdtipocliente() {
		return this.idtipocliente;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setIdubigeo1(String idubigeo1) {
		this.idubigeo1 = idubigeo1;
	}

	public String getIdubigeo1() {
		return this.idubigeo1;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRazon_social() {
		return this.razon_social;
	}

	public void setIddocidentidad(String iddocidentidad) {
		this.iddocidentidad = iddocidentidad;
	}

	public String getIddocidentidad() {
		return this.iddocidentidad;
	}

	public void setNrodocidentidad(String nrodocidentidad) {
		this.nrodocidentidad = nrodocidentidad;
	}

	public String getNrodocidentidad() {
		return this.nrodocidentidad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
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

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setIdestadocivil(String idestadocivil) {
		this.idestadocivil = idestadocivil;
	}

	public String getIdestadocivil() {
		return this.idestadocivil;
	}

	public void setCodequivalente(String codequivalente) {
		this.codequivalente = codequivalente;
	}

	public String getCodequivalente() {
		return this.codequivalente;
	}

	public void setSeleccion(Integer seleccion) {
		this.seleccion = seleccion;
	}

	public Integer getSeleccion() {
		return this.seleccion;
	}



	/* Sets & Gets FK*/

}