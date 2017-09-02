package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import java.util.ArrayList;

@Tabla(nombre = "PERSONAL_SERVICIO")
@XStreamAlias("PERSONAL_SERVICIO")

public class Personal_servicio implements Serializable {
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
	@SerializedName("item2") 
	@XStreamAlias("ITEM2") 
	private String item2 = "" ;
	@Columna
	@SerializedName("idpersonal") 
	@XStreamAlias("IDPERSONAL") 
	private String idpersonal = "" ;
	@Columna
	@SerializedName("dni") 
	@XStreamAlias("DNI") 
	private String dni = "" ;
	@Columna
	@SerializedName("nombres") 
	@XStreamAlias("NOMBRES") 
	private String nombres = "" ;
	@Columna
	@SerializedName("fechaoperacion") 
	@XStreamAlias("FECHAOPERACION") 
	private Date fechaoperacion;
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("fechafin") 
	@XStreamAlias("FECHAFIN") 
	private Date fechafin;
	@Columna
	@SerializedName("checklist") 
	@XStreamAlias("CHECKLIST") 
	private String checklist = "" ;
	@Columna
	@SerializedName("idvehiculo") 
	@XStreamAlias("IDVEHICULO") 
	private String idvehiculo = "" ;

	/**** ADD NEW FIELDS BY ANGEL ABAD ****/
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
	@Columna
	@SerializedName("placa_cliente")
	@XStreamAlias("PLACA_CLIENTE")
	private String placa_cliente = "" ;
	@Columna
	@SerializedName("conductor_cliente")
	@XStreamAlias("CONDUCTOR_CLIENTE")
	private String conductor_cliente = "" ;
	@Columna
	@SerializedName("brevete_cliente")
	@XStreamAlias("BREVETE_CLIENTE")
	private String brevete_cliente = "" ;
	@Columna
	@SerializedName("descripcion_vehiculo")
	@XStreamAlias("DESCRIPCION_VEHICULO")
	private String descripcion_vehiculo="";
	@Columna
	@SerializedName("descripcion_cargo")
	@XStreamAlias("DESCRIPCION_CARGO")
	private String descripcion_cargo="";
	/**
	@Columna
	@SerializedName("apepaterno")
	@XStreamAlias("APEPATERNO")
	private String apepaterno = "" ;
	@Columna
	@SerializedName("apematerno")
	@XStreamAlias("APEMATERNO")
	private String apematerno = "" ;**/


	private boolean seleccion;





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

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setFechaoperacion(Date fechaoperacion) {
		this.fechaoperacion = fechaoperacion;
	}

	public Date getFechaoperacion() {
		return this.fechaoperacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	public String getDescripcion_cargo() {
		return descripcion_cargo;
	}

	public void setDescripcion_cargo(String descripcion_cargo) {
		this.descripcion_cargo = descripcion_cargo;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}

	public String getChecklist() {
		return this.checklist;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdvehiculo() {
		return this.idvehiculo;
	}

	/* Sets & Gets FK*/


	/****  ADD NEW SETTERS AND GETTERS ***/

	public String getNrocontenedor() {
		return nrocontenedor;
	}

	public void setNrocontenedor(String nrocontenedor) {
		this.nrocontenedor = nrocontenedor;
	}

	public String getNroprecinto() {
		return nroprecinto;
	}

	public void setNroprecinto(String nroprecinto) {
		this.nroprecinto = nroprecinto;
	}

	public String getNro_oservicio() {
		return nro_oservicio;
	}

	public void setNro_oservicio(String nro_oservicio) {
		this.nro_oservicio = nro_oservicio;
	}

	public String getPlaca_cliente() {
		return placa_cliente;
	}

	public void setPlaca_cliente(String placa_cliente) {
		this.placa_cliente = placa_cliente;
	}

	public String getConductor_cliente() {
		return conductor_cliente;
	}

	public void setConductor_cliente(String conductor_cliente) {
		this.conductor_cliente = conductor_cliente;
	}

	public String getBrevete_cliente() {
		return brevete_cliente;
	}

	public void setBrevete_cliente(String brevete_cliente) {
		this.brevete_cliente = brevete_cliente;
	}

	public String getDescripcion_vehiculo() {
		return descripcion_vehiculo;
	}

	public void setDescripcion_vehiculo(String descripcion_vehiculo) {
		this.descripcion_vehiculo = descripcion_vehiculo;
	}
/**
	public String getApepaterno() {
		return apepaterno;
	}

	public void setApepaterno(String apepaterno) {
		this.apepaterno = apepaterno;
	}

	public String getApematerno() {
		return apematerno;
	}

	public void setApematerno(String apematerno) {
		this.apematerno = apematerno;
	}**/
}
