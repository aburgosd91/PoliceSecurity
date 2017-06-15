package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "ORDENLIQUIDACIONGASTO")
@XStreamAlias("ORDENLIQUIDACIONGASTO")

public class Ordenliquidaciongasto implements Serializable {
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
	@Columna
	@SerializedName("idemisor") 
	@XStreamAlias("IDEMISOR") 
	private String idemisor = "" ;
	@Columna
	@SerializedName("periodo") 
	@XStreamAlias("PERIODO") 
	private String periodo = "" ;
	@Columna
	@SerializedName("fecharegistro") 
	@XStreamAlias("FECHAREGISTRO") 
	private Date fecharegistro;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("IDSUCURSAL") 
	private String idsucursal = "" ;
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
	@SerializedName("tcambio") 
	@XStreamAlias("TCAMBIO") 
	private Double tcambio = 0.00 ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("direccion") 
	@XStreamAlias("DIRECCION") 
	private String direccion = "" ;
	@Columna
	@SerializedName("ruc") 
	@XStreamAlias("RUC") 
	private String ruc = "" ;
	@Columna
	@SerializedName("razonsocial") 
	@XStreamAlias("RAZONSOCIAL") 
	private String razonsocial = "" ;
	@Columna
	@SerializedName("idregimen") 
	@XStreamAlias("IDREGIMEN") 
	private String idregimen = "" ;
	@Columna
	@SerializedName("idmoneda") 
	@XStreamAlias("IDMONEDA") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("tcmoneda") 
	@XStreamAlias("TCMONEDA") 
	private Double tcmoneda = 0.00 ;
	@Columna
	@SerializedName("idtipomov") 
	@XStreamAlias("IDTIPOMOV") 
	private String idtipomov = "" ;
	@Columna
	@SerializedName("idfpago") 
	@XStreamAlias("IDFPAGO") 
	private String idfpago = "" ;
	@Columna
	@SerializedName("idarea") 
	@XStreamAlias("IDAREA") 
	private String idarea = "" ;
	@Columna
	@SerializedName("glosa") 
	@XStreamAlias("GLOSA") 
	private String glosa = "" ;
	@Columna
	@SerializedName("vventa") 
	@XStreamAlias("VVENTA") 
	private Double vventa = 0.00 ;
	@Columna
	@SerializedName("inafecto") 
	@XStreamAlias("INAFECTO") 
	private Double inafecto = 0.00 ;
	@Columna
	@SerializedName("otros") 
	@XStreamAlias("OTROS") 
	private Double otros = 0.00 ;
	@Columna
	@SerializedName("impuesto") 
	@XStreamAlias("IMPUESTO") 
	private Double impuesto = 0.00 ;
	@Columna
	@SerializedName("pimpuesto") 
	@XStreamAlias("PIMPUESTO") 
	private Double pimpuesto = 0.00 ;
	@Columna
	@SerializedName("descuento") 
	@XStreamAlias("DESCUENTO") 
	private Double descuento = 0.00 ;
	@Columna
	@SerializedName("pdescuento") 
	@XStreamAlias("PDESCUENTO") 
	private Double pdescuento = 0.00 ;
	@Columna
	@SerializedName("descuentodoc") 
	@XStreamAlias("DESCUENTODOC") 
	private Double descuentodoc = 0.00 ;
	@Columna
	@SerializedName("redondeo") 
	@XStreamAlias("REDONDEO") 
	private Double redondeo = 0.00 ;
	@Columna
	@SerializedName("importe") 
	@XStreamAlias("IMPORTE") 
	private Double importe = 0.00 ;
	@Columna
	@SerializedName("importemof") 
	@XStreamAlias("IMPORTEMOF") 
	private Double importemof = 0.00 ;
	@Columna
	@SerializedName("importemex") 
	@XStreamAlias("IMPORTEMEX") 
	private Double importemex = 0.00 ;
	@Columna
	@SerializedName("idestado") 
	@XStreamAlias("IDESTADO") 
	private String idestado = "" ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("igv") 
	@XStreamAlias("IGV") 
	private Double igv = 0.00 ;
	@Columna
	@SerializedName("idusuario") 
	@XStreamAlias("IDUSUARIO") 
	private String idusuario = "" ;
	@Columna
	@SerializedName("ventana") 
	@XStreamAlias("VENTANA") 
	private String ventana = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("impreso") 
	@XStreamAlias("IMPRESO") 
	private Double impreso = 0.00 ;
	@Columna
	@SerializedName("idmediopago") 
	@XStreamAlias("IDMEDIOPAGO") 
	private String idmediopago = "" ;
	@Columna
	@SerializedName("idcontacto") 
	@XStreamAlias("IDCONTACTO") 
	private String idcontacto = "" ;
	@Columna
	@SerializedName("certiftransporte") 
	@XStreamAlias("CERTIFTRANSPORTE") 
	private String certiftransporte = "" ;
	@Columna
	@SerializedName("certiftransporte1") 
	@XStreamAlias("CERTIFTRANSPORTE1") 
	private String certiftransporte1 = "" ;
	@Columna
	@SerializedName("idvehiculo") 
	@XStreamAlias("IDVEHICULO") 
	private String idvehiculo = "" ;
	@Columna
	@SerializedName("placa") 
	@XStreamAlias("PLACA") 
	private String placa = "" ;
	@Columna
	@SerializedName("placa1") 
	@XStreamAlias("PLACA1") 
	private String placa1 = "" ;
	@Columna
	@SerializedName("marca") 
	@XStreamAlias("MARCA") 
	private String marca = "" ;
	@Columna
	@SerializedName("marca1") 
	@XStreamAlias("MARCA1") 
	private String marca1 = "" ;
	@Columna
	@SerializedName("idchofer") 
	@XStreamAlias("IDCHOFER") 
	private String idchofer = "" ;
	@Columna
	@SerializedName("chofer") 
	@XStreamAlias("CHOFER") 
	private String chofer = "" ;
	@Columna
	@SerializedName("brevete") 
	@XStreamAlias("BREVETE") 
	private String brevete = "" ;
	@Columna
	@SerializedName("fechatraslado") 
	@XStreamAlias("FECHATRASLADO") 
	private Date fechatraslado;
	@Columna
	@SerializedName("razonsocial2") 
	@XStreamAlias("RAZONSOCIAL2") 
	private String razonsocial2 = "" ;
	@Columna
	@SerializedName("glosa1") 
	@XStreamAlias("GLOSA1") 
	private String glosa1 = "" ;
	@Columna
	@SerializedName("condicionsunat") 
	@XStreamAlias("CONDICIONSUNAT") 
	private String condicionsunat = "" ;
	@Columna
	@SerializedName("estadosunat") 
	@XStreamAlias("ESTADOSUNAT") 
	private String estadosunat = "" ;



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

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
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

	public void setTcambio(Double tcambio) {
		this.tcambio = tcambio;
	}

	public Double getTcambio() {
		return this.tcambio;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setIdregimen(String idregimen) {
		this.idregimen = idregimen;
	}

	public String getIdregimen() {
		return this.idregimen;
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

	public void setIdtipomov(String idtipomov) {
		this.idtipomov = idtipomov;
	}

	public String getIdtipomov() {
		return this.idtipomov;
	}

	public void setIdfpago(String idfpago) {
		this.idfpago = idfpago;
	}

	public String getIdfpago() {
		return this.idfpago;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setVventa(Double vventa) {
		this.vventa = vventa;
	}

	public Double getVventa() {
		return this.vventa;
	}

	public void setInafecto(Double inafecto) {
		this.inafecto = inafecto;
	}

	public Double getInafecto() {
		return this.inafecto;
	}

	public void setOtros(Double otros) {
		this.otros = otros;
	}

	public Double getOtros() {
		return this.otros;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getImpuesto() {
		return this.impuesto;
	}

	public void setPimpuesto(Double pimpuesto) {
		this.pimpuesto = pimpuesto;
	}

	public Double getPimpuesto() {
		return this.pimpuesto;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setPdescuento(Double pdescuento) {
		this.pdescuento = pdescuento;
	}

	public Double getPdescuento() {
		return this.pdescuento;
	}

	public void setDescuentodoc(Double descuentodoc) {
		this.descuentodoc = descuentodoc;
	}

	public Double getDescuentodoc() {
		return this.descuentodoc;
	}

	public void setRedondeo(Double redondeo) {
		this.redondeo = redondeo;
	}

	public Double getRedondeo() {
		return this.redondeo;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImportemof(Double importemof) {
		this.importemof = importemof;
	}

	public Double getImportemof() {
		return this.importemof;
	}

	public void setImportemex(Double importemex) {
		this.importemex = importemex;
	}

	public Double getImportemex() {
		return this.importemex;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getIgv() {
		return this.igv;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setImpreso(Double impreso) {
		this.impreso = impreso;
	}

	public Double getImpreso() {
		return this.impreso;
	}

	public void setIdmediopago(String idmediopago) {
		this.idmediopago = idmediopago;
	}

	public String getIdmediopago() {
		return this.idmediopago;
	}

	public void setIdcontacto(String idcontacto) {
		this.idcontacto = idcontacto;
	}

	public String getIdcontacto() {
		return this.idcontacto;
	}

	public void setCertiftransporte(String certiftransporte) {
		this.certiftransporte = certiftransporte;
	}

	public String getCertiftransporte() {
		return this.certiftransporte;
	}

	public void setCertiftransporte1(String certiftransporte1) {
		this.certiftransporte1 = certiftransporte1;
	}

	public String getCertiftransporte1() {
		return this.certiftransporte1;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca1(String placa1) {
		this.placa1 = placa1;
	}

	public String getPlaca1() {
		return this.placa1;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca1(String marca1) {
		this.marca1 = marca1;
	}

	public String getMarca1() {
		return this.marca1;
	}

	public void setIdchofer(String idchofer) {
		this.idchofer = idchofer;
	}

	public String getIdchofer() {
		return this.idchofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getChofer() {
		return this.chofer;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}

	public String getBrevete() {
		return this.brevete;
	}

	public void setFechatraslado(Date fechatraslado) {
		this.fechatraslado = fechatraslado;
	}

	public Date getFechatraslado() {
		return this.fechatraslado;
	}

	public void setRazonsocial2(String razonsocial2) {
		this.razonsocial2 = razonsocial2;
	}

	public String getRazonsocial2() {
		return this.razonsocial2;
	}

	public void setGlosa1(String glosa1) {
		this.glosa1 = glosa1;
	}

	public String getGlosa1() {
		return this.glosa1;
	}

	public void setCondicionsunat(String condicionsunat) {
		this.condicionsunat = condicionsunat;
	}

	public String getCondicionsunat() {
		return this.condicionsunat;
	}

	public void setEstadosunat(String estadosunat) {
		this.estadosunat = estadosunat;
	}

	public String getEstadosunat() {
		return this.estadosunat;
	}



	/* Sets & Gets FK*/

}