package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "UNIMEDIDA")
@XStreamAlias("UNIMEDIDA")

public class Unimedida implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("IDMEDIDA") 
	private String idmedida = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("nombre_corto") 
	@XStreamAlias("NOMBRE_CORTO") 
	private String nombre_corto = "" ;
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
	@SerializedName("codigo_sunat") 
	@XStreamAlias("CODIGO_SUNAT") 
	private String codigo_sunat = "" ;
	@Columna
	@SerializedName("unidviaje") 
	@XStreamAlias("UNIDVIAJE") 
	private Double unidviaje = 0.00 ;
	@Columna
	@SerializedName("unidtarifa") 
	@XStreamAlias("UNIDTARIFA") 
	private Double unidtarifa = 0.00 ;
	@Columna
	@SerializedName("idregistro_sunat") 
	@XStreamAlias("IDREGISTRO_SUNAT") 
	private String idregistro_sunat = "" ;
	@Columna
	@SerializedName("tiempo") 
	@XStreamAlias("TIEMPO") 
	private String tiempo = "" ;
	@Columna
	@SerializedName("unidtiempo") 
	@XStreamAlias("UNIDTIEMPO") 
	private Double unidtiempo = 0.00 ;
	@Columna
	@SerializedName("codigo_aduana") 
	@XStreamAlias("CODIGO_ADUANA") 
	private String codigo_aduana = "" ;
	@Columna
	@SerializedName("redondeo_drawback") 
	@XStreamAlias("REDONDEO_DRAWBACK") 
	private Double redondeo_drawback = 0.00 ;
	@Columna
	@SerializedName("tipo_redondeo") 
	@XStreamAlias("TIPO_REDONDEO") 
	private String tipo_redondeo = "" ;
	@Columna
	@SerializedName("decimal_redondeo") 
	@XStreamAlias("DECIMAL_REDONDEO") 
	private Double decimal_redondeo = 0.00 ;
	@Columna
	@SerializedName("compania") 
	@XStreamAlias("COMPANIA") 
	private Integer compania;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
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

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public String getCodigo_sunat() {
		return this.codigo_sunat;
	}

	public void setUnidviaje(Double unidviaje) {
		this.unidviaje = unidviaje;
	}

	public Double getUnidviaje() {
		return this.unidviaje;
	}

	public void setUnidtarifa(Double unidtarifa) {
		this.unidtarifa = unidtarifa;
	}

	public Double getUnidtarifa() {
		return this.unidtarifa;
	}

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getTiempo() {
		return this.tiempo;
	}

	public void setUnidtiempo(Double unidtiempo) {
		this.unidtiempo = unidtiempo;
	}

	public Double getUnidtiempo() {
		return this.unidtiempo;
	}

	public void setCodigo_aduana(String codigo_aduana) {
		this.codigo_aduana = codigo_aduana;
	}

	public String getCodigo_aduana() {
		return this.codigo_aduana;
	}

	public void setRedondeo_drawback(Double redondeo_drawback) {
		this.redondeo_drawback = redondeo_drawback;
	}

	public Double getRedondeo_drawback() {
		return this.redondeo_drawback;
	}

	public void setTipo_redondeo(String tipo_redondeo) {
		this.tipo_redondeo = tipo_redondeo;
	}

	public String getTipo_redondeo() {
		return this.tipo_redondeo;
	}

	public void setDecimal_redondeo(Double decimal_redondeo) {
		this.decimal_redondeo = decimal_redondeo;
	}

	public Double getDecimal_redondeo() {
		return this.decimal_redondeo;
	}

	public void setCompania(Integer compania) {
		this.compania = compania;
	}

	public Integer getCompania() {
		return this.compania;
	}



	/* Sets & Gets FK*/

}