package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DPERSONAL_SERVICIO")
@XStreamAlias("DPERSONAL_SERVICIO")

public class Dpersonal_servicio implements Serializable {
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
	@SerializedName("item_dordenservicio") 
	@XStreamAlias("ITEM_DORDENSERVICIO") 
	private String item_dordenservicio = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item2") 
	@XStreamAlias("ITEM2") 
	private String item2 = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("hora_req") 
	@XStreamAlias("HORA_REQ") 
	private Double hora_req = 0.00 ;
	@Columna
	@SerializedName("hora_llegada") 
	@XStreamAlias("HORA_LLEGADA") 
	private Double hora_llegada = 0.00 ;
	@Columna
	@SerializedName("hora_inicio_serv") 
	@XStreamAlias("HORA_INICIO_SERV") 
	private Double hora_inicio_serv = 0.00 ;
	@Columna
	@SerializedName("hora_fin_serv") 
	@XStreamAlias("HORA_FIN_SERV") 
	private Double hora_fin_serv = 0.00 ;
	@Columna
	@SerializedName("hora_liberacion") 
	@XStreamAlias("HORA_LIBERACION") 
	private Double hora_liberacion = 0.00 ;
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("fecharegistro") 
	@XStreamAlias("FECHAREGISTRO") 
	private Date fecharegistro;



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

	public void setItem_dordenservicio(String item_dordenservicio) {
		this.item_dordenservicio = item_dordenservicio;
	}

	public String getItem_dordenservicio() {
		return this.item_dordenservicio;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setHora_req(Double hora_req) {
		this.hora_req = hora_req;
	}

	public Double getHora_req() {
		return this.hora_req;
	}

	public void setHora_llegada(Double hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public Double getHora_llegada() {
		return this.hora_llegada;
	}

	public void setHora_inicio_serv(Double hora_inicio_serv) {
		this.hora_inicio_serv = hora_inicio_serv;
	}

	public Double getHora_inicio_serv() {
		return this.hora_inicio_serv;
	}

	public void setHora_fin_serv(Double hora_fin_serv) {
		this.hora_fin_serv = hora_fin_serv;
	}

	public Double getHora_fin_serv() {
		return this.hora_fin_serv;
	}

	public void setHora_liberacion(Double hora_liberacion) {
		this.hora_liberacion = hora_liberacion;
	}

	public Double getHora_liberacion() {
		return this.hora_liberacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}



	/* Sets & Gets FK*/

}