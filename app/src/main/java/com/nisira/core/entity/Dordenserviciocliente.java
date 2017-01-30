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
	@SerializedName("idservicio") 
	@XStreamAlias("IDSERVICIO") 
	private String idservicio = "" ;

	private String descripcion_servicio = "" ;


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

	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public String getIdservicio() {
		return this.idservicio;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}



	/* Sets & Gets FK*/

}