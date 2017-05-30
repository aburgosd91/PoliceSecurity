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

@Tabla(nombre = "DET_TAREOWEB")
@XStreamAlias("DET_TAREOWEB")

public class Det_tareoweb implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcabtareoweb") 
	@XStreamAlias("IDCABTAREOWEB") 
	private String idcabtareoweb = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idordenservicio") 
	@XStreamAlias("IDORDENSERVICIO") 
	private String idordenservicio = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("SERIE") 
	private String serie = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	private String numero = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("ruc") 
	@XStreamAlias("RUC") 
	private String ruc = "" ;
	@Columna
	@SerializedName("razon") 
	@XStreamAlias("RAZON") 
	private String razon = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idpersonal") 
	@XStreamAlias("IDPERSONAL") 
	private String idpersonal = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item_dordenservicio") 
	@XStreamAlias("ITEM_DORDENSERVICIO") 
	private String item_dordenservicio = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item2_personalservicio") 
	@XStreamAlias("ITEM2_PERSONALSERVICIO") 
	private String item2_personalservicio = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item_dpersonalservicio") 
	@XStreamAlias("ITEM_DPERSONALSERVICIO") 
	private String item_dpersonalservicio = "" ;
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
	@SerializedName("fecharegistro") 
	@XStreamAlias("FECHAREGISTRO") 
	private Date fecharegistro;
	@Columna
	@SerializedName("fechafinregistro") 
	@XStreamAlias("FECHAFINREGISTRO") 
	private Date fechafinregistro;

	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCABTAREOWEB",campoRelacionado="IDCABTAREOWEB")})
	private Cabtareoweb cabtareoweb_fk_det_tareoweb_cabtareoweb;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcabtareoweb(String idcabtareoweb) {
		this.idcabtareoweb = idcabtareoweb;
	}

	public String getIdcabtareoweb() {
		return this.idcabtareoweb;
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

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getRazon() {
		return this.razon;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setItem_dordenservicio(String item_dordenservicio) {
		this.item_dordenservicio = item_dordenservicio;
	}

	public String getItem_dordenservicio() {
		return this.item_dordenservicio;
	}

	public void setItem2_personalservicio(String item2_personalservicio) {
		this.item2_personalservicio = item2_personalservicio;
	}

	public String getItem2_personalservicio() {
		return this.item2_personalservicio;
	}

	public void setItem_dpersonalservicio(String item_dpersonalservicio) {
		this.item_dpersonalservicio = item_dpersonalservicio;
	}

	public String getItem_dpersonalservicio() {
		return this.item_dpersonalservicio;
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

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFechafinregistro(Date fechafinregistro) {
		this.fechafinregistro = fechafinregistro;
	}

	public Date getFechafinregistro() {
		return this.fechafinregistro;
	}



	/* Sets & Gets FK*/
	public void setCabtareoweb_fk_det_tareoweb_cabtareoweb(Cabtareoweb cabtareoweb_fk_det_tareoweb_cabtareoweb) {
		this.cabtareoweb_fk_det_tareoweb_cabtareoweb = cabtareoweb_fk_det_tareoweb_cabtareoweb;
	}

	public Cabtareoweb getCabtareoweb_fk_det_tareoweb_cabtareoweb() {
		return this.cabtareoweb_fk_det_tareoweb_cabtareoweb;
	}


}