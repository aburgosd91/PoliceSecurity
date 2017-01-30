package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "CARGOS_PERSONAL")
@XStreamAlias("CARGOS_PERSONAL")

public class Cargos_personal implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("idactividad") 
	@XStreamAlias("IDACTIVIDAD") 
	private String idactividad = "" ;
	@Columna
	@SerializedName("idlabor") 
	@XStreamAlias("IDLABOR") 
	private String idlabor = "" ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("codalterno") 
	@XStreamAlias("CODALTERNO") 
	private String codalterno = "" ;
	@Columna
	@SerializedName("es_guardian") 
	@XStreamAlias("ES_GUARDIAN") 
	private Integer es_guardian;
	@Columna
	@SerializedName("es_pers_aereo") 
	@XStreamAlias("ES_PERS_AEREO") 
	private Double es_pers_aereo = 0.00 ;
	@Columna
	@SerializedName("cargo_pesquera") 
	@XStreamAlias("CARGO_PESQUERA") 
	private String cargo_pesquera = "" ;
	@Columna
	@SerializedName("produccion_pesquera") 
	@XStreamAlias("PRODUCCION_PESQUERA") 
	private Double produccion_pesquera = 0.00 ;
	@Columna
	@SerializedName("tipo_trabajo") 
	@XStreamAlias("TIPO_TRABAJO") 
	private String tipo_trabajo = "" ;
	@Columna
	@SerializedName("idarea") 
	@XStreamAlias("IDAREA") 
	private String idarea = "" ;
	@Columna
	@SerializedName("es_jefedearea") 
	@XStreamAlias("ES_JEFEDEAREA") 
	private Double es_jefedearea = 0.00 ;
	@Columna
	@SerializedName("usa_subsector") 
	@XStreamAlias("USA_SUBSECTOR") 
	private Double usa_subsector = 0.00 ;
	@Columna
	@SerializedName("tipo_cargo") 
	@XStreamAlias("TIPO_CARGO") 
	private Double tipo_cargo = 0.00 ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdactividad(String idactividad) {
		this.idactividad = idactividad;
	}

	public String getIdactividad() {
		return this.idactividad;
	}

	public void setIdlabor(String idlabor) {
		this.idlabor = idlabor;
	}

	public String getIdlabor() {
		return this.idlabor;
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

	public void setCodalterno(String codalterno) {
		this.codalterno = codalterno;
	}

	public String getCodalterno() {
		return this.codalterno;
	}

	public void setEs_guardian(Integer es_guardian) {
		this.es_guardian = es_guardian;
	}

	public Integer getEs_guardian() {
		return this.es_guardian;
	}

	public void setEs_pers_aereo(Double es_pers_aereo) {
		this.es_pers_aereo = es_pers_aereo;
	}

	public Double getEs_pers_aereo() {
		return this.es_pers_aereo;
	}

	public void setCargo_pesquera(String cargo_pesquera) {
		this.cargo_pesquera = cargo_pesquera;
	}

	public String getCargo_pesquera() {
		return this.cargo_pesquera;
	}

	public void setProduccion_pesquera(Double produccion_pesquera) {
		this.produccion_pesquera = produccion_pesquera;
	}

	public Double getProduccion_pesquera() {
		return this.produccion_pesquera;
	}

	public void setTipo_trabajo(String tipo_trabajo) {
		this.tipo_trabajo = tipo_trabajo;
	}

	public String getTipo_trabajo() {
		return this.tipo_trabajo;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setEs_jefedearea(Double es_jefedearea) {
		this.es_jefedearea = es_jefedearea;
	}

	public Double getEs_jefedearea() {
		return this.es_jefedearea;
	}

	public void setUsa_subsector(Double usa_subsector) {
		this.usa_subsector = usa_subsector;
	}

	public Double getUsa_subsector() {
		return this.usa_subsector;
	}

	public void setTipo_cargo(Double tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public Double getTipo_cargo() {
		return this.tipo_cargo;
	}



	/* Sets & Gets FK*/

}