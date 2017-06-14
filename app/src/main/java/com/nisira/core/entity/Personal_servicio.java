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

	private boolean seleccion;

	private String descripcion_cargo="";



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

}