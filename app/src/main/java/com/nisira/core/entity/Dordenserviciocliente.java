package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DORDENSERVICIOCLIENTE")
@XStreamAlias("DORDENSERVICIOCLIENTE")

public class Dordenserviciocliente implements Serializable {
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
	@Columna
	@SerializedName("idvehiculo") 
	@XStreamAlias("IDVEHICULO") 
	private String idvehiculo = "" ;
	@Columna
	@SerializedName("placa_cliente") 
	@XStreamAlias("PLACA_CLIENTE") 
	private String placa_cliente = "" ;
	@Columna
	@SerializedName("hora_req") 
	@XStreamAlias("HORA_REQ") 
	private Double hora_req = 0.00 ;
	@Columna
	@SerializedName("fecha_fin_servicio") 
	@XStreamAlias("FECHA_FIN_SERVICIO") 
	private Date fecha_fin_servicio;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("idreferencia") 
	@XStreamAlias("IDREFERENCIA") 
	private String idreferencia = "" ;
	@Columna
	@SerializedName("itemreferencia") 
	@XStreamAlias("ITEMREFERENCIA") 
	private String itemreferencia = "" ;
	@Columna
	@SerializedName("idservicio") 
	@XStreamAlias("IDSERVICIO") 
	private String idservicio = "" ;
	@Columna
	@SerializedName("conductor_cliente") 
	@XStreamAlias("CONDUCTOR_CLIENTE") 
	private String conductor_cliente = "" ;
	@Columna
	@SerializedName("glosa") 
	@XStreamAlias("GLOSA") 
	private String glosa = "" ;
	@Columna
	@SerializedName("hora_rc") 
	@XStreamAlias("HORA_RC") 
	private Double hora_rc = 0.00 ;
	@Columna
	@SerializedName("codoperaciones") 
	@XStreamAlias("CODOPERACIONES") 
	private String codoperaciones = "" ;
	@Columna
	@SerializedName("idruta_ec") 
	@XStreamAlias("IDRUTA_EC") 
	private String idruta_ec = "" ;

	private boolean Seleccion;

	private String descripcion_servicio = "" ;

	private String descripcion_vehiculo="";




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

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setPlaca_cliente(String placa_cliente) {
		this.placa_cliente = placa_cliente;
	}

	public String getPlaca_cliente() {
		return this.placa_cliente;
	}

	public void setHora_req(Double hora_req) {
		this.hora_req = hora_req;
	}

	public Double getHora_req() {
		return this.hora_req;
	}

	public void setFecha_fin_servicio(Date fecha_fin_servicio) {
		this.fecha_fin_servicio = fecha_fin_servicio;
	}

	public Date getFecha_fin_servicio() {
		return this.fecha_fin_servicio;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setIdreferencia(String idreferencia) {
		this.idreferencia = idreferencia;
	}

	public String getIdreferencia() {
		return this.idreferencia;
	}

	public void setItemreferencia(String itemreferencia) {
		this.itemreferencia = itemreferencia;
	}

	public String getItemreferencia() {
		return this.itemreferencia;
	}

	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public String getIdservicio() {
		return this.idservicio;
	}

	public void setConductor_cliente(String conductor_cliente) {
		this.conductor_cliente = conductor_cliente;
	}

	public String getConductor_cliente() {
		return this.conductor_cliente;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setHora_rc(Double hora_rc) {
		this.hora_rc = hora_rc;
	}

	public Double getHora_rc() {
		return this.hora_rc;
	}

	public void setCodoperaciones(String codoperaciones) {
		this.codoperaciones = codoperaciones;
	}

	public String getCodoperaciones() {
		return this.codoperaciones;
	}

	public void setIdruta_ec(String idruta_ec) {
		this.idruta_ec = idruta_ec;
	}

	public String getIdruta_ec() {
		return this.idruta_ec;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	public boolean isSeleccion() {
		return Seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		Seleccion = seleccion;
	}

	public String getDescripcion_vehiculo() {
		return descripcion_vehiculo;
	}

	public void setDescripcion_vehiculo(String descripcion_vehiculo) {
		this.descripcion_vehiculo = descripcion_vehiculo;
	}


	/* Sets & Gets FK*/

}