package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DORDENLIQUIDACIONGASTO")
@XStreamAlias("DORDENLIQUIDACIONGASTO")

public class Dordenliquidaciongasto implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idorden") 
	@XStreamAlias("IDORDEN") 
	private String idorden = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("glosa") 
	@XStreamAlias("GLOSA") 
	private String glosa = "" ;
	@Columna
	@SerializedName("idconcepto") 
	@XStreamAlias("IDCONCEPTO") 
	private String idconcepto = "" ;
	@Columna
	@SerializedName("idcuenta") 
	@XStreamAlias("IDCUENTA") 
	private String idcuenta = "" ;
	@Columna
	@SerializedName("idccosto") 
	@XStreamAlias("IDCCOSTO") 
	private String idccosto = "" ;
	@Columna
	@SerializedName("idtipomov") 
	@XStreamAlias("IDTIPOMOV") 
	private String idtipomov = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
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
	@SerializedName("fecha") 
	@XStreamAlias("FECHA") 
	private Date fecha;
	@Columna
	@SerializedName("iddestino") 
	@XStreamAlias("IDDESTINO") 
	private String iddestino = "" ;
	@Columna
	@SerializedName("idmoneda") 
	@XStreamAlias("IDMONEDA") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("tcmoneda") 
	@XStreamAlias("TCMONEDA") 
	private Double tcmoneda = 0.00 ;
	@Columna
	@SerializedName("tcambio") 
	@XStreamAlias("TCAMBIO") 
	private Double tcambio = 0.00 ;
	@Columna
	@SerializedName("idregimen") 
	@XStreamAlias("IDREGIMEN") 
	private String idregimen = "" ;
	@Columna
	@SerializedName("afecto") 
	@XStreamAlias("AFECTO") 
	private Double afecto = 0.00 ;
	@Columna
	@SerializedName("inafecto") 
	@XStreamAlias("INAFECTO") 
	private Double inafecto = 0.00 ;
	@Columna
	@SerializedName("pimpuesto") 
	@XStreamAlias("PIMPUESTO") 
	private Double pimpuesto = 0.00 ;
	@Columna
	@SerializedName("impuesto") 
	@XStreamAlias("IMPUESTO") 
	private Double impuesto = 0.00 ;
	@Columna
	@SerializedName("importe") 
	@XStreamAlias("IMPORTE") 
	private Double importe = 0.00 ;
	@Columna
	@SerializedName("otros") 
	@XStreamAlias("OTROS") 
	private Double otros = 0.00 ;
	@Columna
	@SerializedName("idconsumidor") 
	@XStreamAlias("IDCONSUMIDOR") 
	private String idconsumidor = "" ;
	@Columna
	@SerializedName("numero_rcompras") 
	@XStreamAlias("NUMERO_RCOMPRAS") 
	private String numero_rcompras = "" ;
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("IDMEDIDA") 
	private String idmedida = "" ;
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("itemalmacen") 
	@XStreamAlias("ITEMALMACEN") 
	private String itemalmacen = "" ;
	@Columna
	@SerializedName("producto") 
	@XStreamAlias("PRODUCTO") 
	private String producto = "" ;
	@Columna
	@SerializedName("ventana") 
	@XStreamAlias("VENTANA") 
	private String ventana = "" ;
	@Columna
	@SerializedName("cantidad") 
	@XStreamAlias("CANTIDAD") 
	private Double cantidad = 0.00 ;
	@Columna
	@SerializedName("idsiembra") 
	@XStreamAlias("IDSIEMBRA") 
	private String idsiembra = "" ;
	@Columna
	@SerializedName("idcampana") 
	@XStreamAlias("IDCAMPANA") 
	private String idcampana = "" ;
	@Columna
	@SerializedName("idordenproduccion") 
	@XStreamAlias("IDORDENPRODUCCION") 
	private String idordenproduccion = "" ;
	@Columna
	@SerializedName("idloteproduccion") 
	@XStreamAlias("IDLOTEPRODUCCION") 
	private String idloteproduccion = "" ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorden(String idorden) {
		this.idorden = idorden;
	}

	public String getIdorden() {
		return this.idorden;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setIdconcepto(String idconcepto) {
		this.idconcepto = idconcepto;
	}

	public String getIdconcepto() {
		return this.idconcepto;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setIdtipomov(String idtipomov) {
		this.idtipomov = idtipomov;
	}

	public String getIdtipomov() {
		return this.idtipomov;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setIddestino(String iddestino) {
		this.iddestino = iddestino;
	}

	public String getIddestino() {
		return this.iddestino;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setTcmoneda(Double tcmoneda) {
		this.tcmoneda = tcmoneda;
	}

	public Double getTcmoneda() {
		return this.tcmoneda;
	}

	public void setTcambio(Double tcambio) {
		this.tcambio = tcambio;
	}

	public Double getTcambio() {
		return this.tcambio;
	}

	public void setIdregimen(String idregimen) {
		this.idregimen = idregimen;
	}

	public String getIdregimen() {
		return this.idregimen;
	}

	public void setAfecto(Double afecto) {
		this.afecto = afecto;
	}

	public Double getAfecto() {
		return this.afecto;
	}

	public void setInafecto(Double inafecto) {
		this.inafecto = inafecto;
	}

	public Double getInafecto() {
		return this.inafecto;
	}

	public void setPimpuesto(Double pimpuesto) {
		this.pimpuesto = pimpuesto;
	}

	public Double getPimpuesto() {
		return this.pimpuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getImpuesto() {
		return this.impuesto;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setOtros(Double otros) {
		this.otros = otros;
	}

	public Double getOtros() {
		return this.otros;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setNumero_rcompras(String numero_rcompras) {
		this.numero_rcompras = numero_rcompras;
	}

	public String getNumero_rcompras() {
		return this.numero_rcompras;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setItemalmacen(String itemalmacen) {
		this.itemalmacen = itemalmacen;
	}

	public String getItemalmacen() {
		return this.itemalmacen;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setIdsiembra(String idsiembra) {
		this.idsiembra = idsiembra;
	}

	public String getIdsiembra() {
		return this.idsiembra;
	}

	public void setIdcampana(String idcampana) {
		this.idcampana = idcampana;
	}

	public String getIdcampana() {
		return this.idcampana;
	}

	public void setIdordenproduccion(String idordenproduccion) {
		this.idordenproduccion = idordenproduccion;
	}

	public String getIdordenproduccion() {
		return this.idordenproduccion;
	}

	public void setIdloteproduccion(String idloteproduccion) {
		this.idloteproduccion = idloteproduccion;
	}

	public String getIdloteproduccion() {
		return this.idloteproduccion;
	}



	/* Sets & Gets FK*/

}