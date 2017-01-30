package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "COTIZACIONVENTAS")
@XStreamAlias("COTIZACIONVENTAS")

public class Cotizacionventas implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idcotizacionv") 
	@XStreamAlias("IDCOTIZACIONV") 
	private String idcotizacionv = "" ;
	@Columna
	@SerializedName("idemisor") 
	@XStreamAlias("IDEMISOR") 
	private String idemisor = "" ;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("IDSUCURSAL") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("idalmacen") 
	@XStreamAlias("IDALMACEN") 
	private String idalmacen = "" ;
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("periodo") 
	@XStreamAlias("PERIODO") 
	private String periodo = "" ;
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
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("idproyecto") 
	@XStreamAlias("IDPROYECTO") 
	private String idproyecto = "" ;
	@Columna
	@SerializedName("tcambio") 
	@XStreamAlias("TCAMBIO") 
	private Double tcambio = 0.00 ;
	@Columna
	@SerializedName("idmoneda") 
	@XStreamAlias("IDMONEDA") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("glosa") 
	@XStreamAlias("GLOSA") 
	private String glosa = "" ;
	@Columna
	@SerializedName("idestado") 
	@XStreamAlias("IDESTADO") 
	private String idestado = "" ;
	@Columna
	@SerializedName("idestadoold") 
	@XStreamAlias("IDESTADOOLD") 
	private String idestadoold = "" ;
	@Columna
	@SerializedName("vventa") 
	@XStreamAlias("VVENTA") 
	private Double vventa = 0.00 ;
	@Columna
	@SerializedName("impuesto") 
	@XStreamAlias("IMPUESTO") 
	private Double impuesto = 0.00 ;
	@Columna
	@SerializedName("impuesto_i") 
	@XStreamAlias("IMPUESTO_I") 
	private Double impuesto_i = 0.00 ;
	@Columna
	@SerializedName("importe") 
	@XStreamAlias("IMPORTE") 
	private Double importe = 0.00 ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("contacto") 
	@XStreamAlias("CONTACTO") 
	private String contacto = "" ;
	@Columna
	@SerializedName("lugar_entrega") 
	@XStreamAlias("LUGAR_ENTREGA") 
	private String lugar_entrega = "" ;
	@Columna
	@SerializedName("solicitado") 
	@XStreamAlias("SOLICITADO") 
	private String solicitado = "" ;
	@Columna
	@SerializedName("tcmoneda") 
	@XStreamAlias("TCMONEDA") 
	private Double tcmoneda = 0.00 ;
	@Columna
	@SerializedName("subtotalsindscto") 
	@XStreamAlias("SUBTOTALSINDSCTO") 
	private Double subtotalsindscto = 0.00 ;
	@Columna
	@SerializedName("descuento") 
	@XStreamAlias("DESCUENTO") 
	private Double descuento = 0.00 ;
	@Columna
	@SerializedName("subtotalcondscto") 
	@XStreamAlias("SUBTOTALCONDSCTO") 
	private Double subtotalcondscto = 0.00 ;
	@Columna
	@SerializedName("fechavigencia") 
	@XStreamAlias("FECHAVIGENCIA") 
	private Date fechavigencia;
	@Columna
	@SerializedName("duracionvigencia") 
	@XStreamAlias("DURACIONVIGENCIA") 
	private Double duracionvigencia = 0.00 ;
	@Columna
	@SerializedName("confirmastock") 
	@XStreamAlias("CONFIRMASTOCK") 
	private Double confirmastock = 0.00 ;
	@Columna
	@SerializedName("fechavisita") 
	@XStreamAlias("FECHAVISITA") 
	private Date fechavisita;
	@Columna
	@SerializedName("idfpago") 
	@XStreamAlias("IDFPAGO") 
	private String idfpago = "" ;
	@Columna
	@SerializedName("plazoentrega") 
	@XStreamAlias("PLAZOENTREGA") 
	private String plazoentrega = "" ;
	@Columna
	@SerializedName("ventana") 
	@XStreamAlias("VENTANA") 
	private String ventana = "" ;
	@Columna
	@SerializedName("idvendedor") 
	@XStreamAlias("IDVENDEDOR") 
	private String idvendedor = "" ;
	@Columna
	@SerializedName("comision") 
	@XStreamAlias("COMISION") 
	private Double comision = 0.00 ;
	@Columna
	@SerializedName("idembalaje") 
	@XStreamAlias("IDEMBALAJE") 
	private String idembalaje = "" ;
	@Columna
	@SerializedName("garantia") 
	@XStreamAlias("GARANTIA") 
	private String garantia = "" ;
	@Columna
	@SerializedName("idprevaloriza") 
	@XStreamAlias("IDPREVALORIZA") 
	private String idprevaloriza = "" ;
	@Columna
	@SerializedName("referencia") 
	@XStreamAlias("REFERENCIA") 
	private String referencia = "" ;
	@Columna
	@SerializedName("multivendedores") 
	@XStreamAlias("MULTIVENDEDORES") 
	private Double multivendedores = 0.00 ;
	@Columna
	@SerializedName("pesobruto") 
	@XStreamAlias("PESOBRUTO") 
	private Double pesobruto = 0.00 ;
	@Columna
	@SerializedName("pesotara") 
	@XStreamAlias("PESOTARA") 
	private Double pesotara = 0.00 ;
	@Columna
	@SerializedName("pesoneto") 
	@XStreamAlias("PESONETO") 
	private Double pesoneto = 0.00 ;
	@Columna
	@SerializedName("idtipocontenedor") 
	@XStreamAlias("IDTIPOCONTENEDOR") 
	private String idtipocontenedor = "" ;
	@Columna
	@SerializedName("nrocontenedor") 
	@XStreamAlias("NROCONTENEDOR") 
	private String nrocontenedor = "" ;
	@Columna
	@SerializedName("ciudadorigen") 
	@XStreamAlias("CIUDADORIGEN") 
	private String ciudadorigen = "" ;
	@Columna
	@SerializedName("ciudaddestino") 
	@XStreamAlias("CIUDADDESTINO") 
	private String ciudaddestino = "" ;
	@Columna
	@SerializedName("fechaembarque") 
	@XStreamAlias("FECHAEMBARQUE") 
	private Date fechaembarque;
	@Columna
	@SerializedName("fechaarribo") 
	@XStreamAlias("FECHAARRIBO") 
	private Date fechaarribo;
	@Columna
	@SerializedName("idpuertoorigen") 
	@XStreamAlias("IDPUERTOORIGEN") 
	private String idpuertoorigen = "" ;
	@Columna
	@SerializedName("idpuertodestino") 
	@XStreamAlias("IDPUERTODESTINO") 
	private String idpuertodestino = "" ;
	@Columna
	@SerializedName("puertociudadori") 
	@XStreamAlias("PUERTOCIUDADORI") 
	private String puertociudadori = "" ;
	@Columna
	@SerializedName("puertociudaddes") 
	@XStreamAlias("PUERTOCIUDADDES") 
	private String puertociudaddes = "" ;
	@Columna
	@SerializedName("idubigeo") 
	@XStreamAlias("IDUBIGEO") 
	private String idubigeo = "" ;
	@Columna
	@SerializedName("container") 
	@XStreamAlias("CONTAINER") 
	private String container = "" ;
	@Columna
	@SerializedName("idtipoprecio") 
	@XStreamAlias("IDTIPOPRECIO") 
	private String idtipoprecio = "" ;
	@Columna
	@SerializedName("idflete") 
	@XStreamAlias("IDFLETE") 
	private String idflete = "" ;
	@Columna
	@SerializedName("exonerado") 
	@XStreamAlias("EXONERADO") 
	private Double exonerado = 0.00 ;
	@Columna
	@SerializedName("es_proyecto") 
	@XStreamAlias("ES_PROYECTO") 
	private Double es_proyecto = 0.00 ;
	@Columna
	@SerializedName("smfcred") 
	@XStreamAlias("SMFCRED") 
	private String smfcred = "" ;
	@Columna
	@SerializedName("smfvenc") 
	@XStreamAlias("SMFVENC") 
	private String smfvenc = "" ;
	@Columna
	@SerializedName("idunidadnegocio") 
	@XStreamAlias("IDUNIDADNEGOCIO") 
	private String idunidadnegocio = "" ;
	@Columna
	@SerializedName("idsubunidadnegocio") 
	@XStreamAlias("IDSUBUNIDADNEGOCIO") 
	private String idsubunidadnegocio = "" ;
	@Columna
	@SerializedName("area_ha") 
	@XStreamAlias("AREA_HA") 
	private Double area_ha = 0.00 ;
	@Columna
	@SerializedName("redondeo") 
	@XStreamAlias("REDONDEO") 
	private Double redondeo = 0.00 ;
	@Columna
	@SerializedName("fleteusd") 
	@XStreamAlias("FLETEUSD") 
	private Double fleteusd = 0.00 ;
	@Columna
	@SerializedName("idagentecarga") 
	@XStreamAlias("IDAGENTECARGA") 
	private String idagentecarga = "" ;
	@Columna
	@SerializedName("idcondventa") 
	@XStreamAlias("IDCONDVENTA") 
	private String idcondventa = "" ;
	@Columna
	@SerializedName("idlineaaerea") 
	@XStreamAlias("IDLINEAAEREA") 
	private String idlineaaerea = "" ;
	@Columna
	@SerializedName("nro_forma_pago") 
	@XStreamAlias("NRO_FORMA_PAGO") 
	private String nro_forma_pago = "" ;
	@Columna
	@SerializedName("nro_manual") 
	@XStreamAlias("NRO_MANUAL") 
	private String nro_manual = "" ;
	@Columna
	@SerializedName("idclieprov_destino") 
	@XStreamAlias("IDCLIEPROV_DESTINO") 
	private String idclieprov_destino = "" ;
	@Columna
	@SerializedName("prioridad") 
	@XStreamAlias("PRIORIDAD") 
	private Integer prioridad;
	@Columna
	@SerializedName("nrobuckin") 
	@XStreamAlias("NROBUCKIN") 
	private String nrobuckin = "" ;
	@Columna
	@SerializedName("contenedor") 
	@XStreamAlias("CONTENEDOR") 
	private String contenedor = "" ;
	@Columna
	@SerializedName("peso_real") 
	@XStreamAlias("PESO_REAL") 
	private Double peso_real = 0.00 ;
	@Columna
	@SerializedName("nro_viaje") 
	@XStreamAlias("NRO_VIAJE") 
	private String nro_viaje = "" ;
	@Columna
	@SerializedName("nombre_nave") 
	@XStreamAlias("NOMBRE_NAVE") 
	private String nombre_nave = "" ;
	@Columna
	@SerializedName("iddocumento_pf") 
	@XStreamAlias("IDDOCUMENTO_PF") 
	private String iddocumento_pf = "" ;
	@Columna
	@SerializedName("serie_pf") 
	@XStreamAlias("SERIE_PF") 
	private String serie_pf = "" ;
	@Columna
	@SerializedName("numero_pf") 
	@XStreamAlias("NUMERO_PF") 
	private String numero_pf = "" ;
	@Columna
	@SerializedName("fecha_pf") 
	@XStreamAlias("FECHA_PF") 
	private Date fecha_pf;
	@Columna
	@SerializedName("glosa_l") 
	@XStreamAlias("GLOSA_L") 
	private String glosa_l = "" ;
	@Columna
	@SerializedName("awb") 
	@XStreamAlias("AWB") 
	private String awb = "" ;
	@Columna
	@SerializedName("idcultivo") 
	@XStreamAlias("IDCULTIVO") 
	private String idcultivo = "" ;
	@Columna
	@SerializedName("idvariedad") 
	@XStreamAlias("IDVARIEDAD") 
	private String idvariedad = "" ;
	@Columna
	@SerializedName("idestadobanco") 
	@XStreamAlias("IDESTADOBANCO") 
	private String idestadobanco = "" ;
	@Columna
	@SerializedName("idtg30campaniaveh") 
	@XStreamAlias("IDTG30CAMPANIAVEH") 
	private Integer idtg30campaniaveh;
	@Columna
	@SerializedName("idbanco") 
	@XStreamAlias("IDBANCO") 
	private String idbanco = "" ;
	@Columna
	@SerializedName("ofrecio_seguro") 
	@XStreamAlias("OFRECIO_SEGURO") 
	private String ofrecio_seguro = "" ;
	@Columna
	@SerializedName("copropietario") 
	@XStreamAlias("COPROPIETARIO") 
	private Double copropietario = 0.00 ;
	@Columna
	@SerializedName("idtipocredito") 
	@XStreamAlias("IDTIPOCREDITO") 
	private String idtipocredito = "" ;
	@Columna
	@SerializedName("cuota") 
	@XStreamAlias("CUOTA") 
	private String cuota = "" ;
	@Columna
	@SerializedName("vventapublico_conigv") 
	@XStreamAlias("VVENTAPUBLICO_CONIGV") 
	private Double vventapublico_conigv = 0.00 ;
	@Columna
	@SerializedName("importedscto1_conigv") 
	@XStreamAlias("IMPORTEDSCTO1_CONIGV") 
	private Double importedscto1_conigv = 0.00 ;
	@Columna
	@SerializedName("importedscto2_conigv") 
	@XStreamAlias("IMPORTEDSCTO2_CONIGV") 
	private Double importedscto2_conigv = 0.00 ;
	@Columna
	@SerializedName("importedscto3_conigv") 
	@XStreamAlias("IMPORTEDSCTO3_CONIGV") 
	private Double importedscto3_conigv = 0.00 ;
	@Columna
	@SerializedName("accesorios_conigv") 
	@XStreamAlias("ACCESORIOS_CONIGV") 
	private Double accesorios_conigv = 0.00 ;
	@Columna
	@SerializedName("idcopropietario") 
	@XStreamAlias("IDCOPROPIETARIO") 
	private String idcopropietario = "" ;
	@Columna
	@SerializedName("idtg10tipocotizacion") 
	@XStreamAlias("IDTG10TIPOCOTIZACION") 
	private String idtg10tipocotizacion = "" ;
	@Columna
	@SerializedName("idtg30cotvent_web") 
	@XStreamAlias("IDTG30COTVENT_WEB") 
	private Integer idtg30cotvent_web;
	@Columna
	@SerializedName("cuotainicial") 
	@XStreamAlias("CUOTAINICIAL") 
	private Double cuotainicial = 0.00 ;
	@Columna
	@SerializedName("idctacte") 
	@XStreamAlias("IDCTACTE") 
	private String idctacte = "" ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
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

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setIdproyecto(String idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getIdproyecto() {
		return this.idproyecto;
	}

	public void setTcambio(Double tcambio) {
		this.tcambio = tcambio;
	}

	public Double getTcambio() {
		return this.tcambio;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setIdestadoold(String idestadoold) {
		this.idestadoold = idestadoold;
	}

	public String getIdestadoold() {
		return this.idestadoold;
	}

	public void setVventa(Double vventa) {
		this.vventa = vventa;
	}

	public Double getVventa() {
		return this.vventa;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto_i(Double impuesto_i) {
		this.impuesto_i = impuesto_i;
	}

	public Double getImpuesto_i() {
		return this.impuesto_i;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setLugar_entrega(String lugar_entrega) {
		this.lugar_entrega = lugar_entrega;
	}

	public String getLugar_entrega() {
		return this.lugar_entrega;
	}

	public void setSolicitado(String solicitado) {
		this.solicitado = solicitado;
	}

	public String getSolicitado() {
		return this.solicitado;
	}

	public void setTcmoneda(Double tcmoneda) {
		this.tcmoneda = tcmoneda;
	}

	public Double getTcmoneda() {
		return this.tcmoneda;
	}

	public void setSubtotalsindscto(Double subtotalsindscto) {
		this.subtotalsindscto = subtotalsindscto;
	}

	public Double getSubtotalsindscto() {
		return this.subtotalsindscto;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setSubtotalcondscto(Double subtotalcondscto) {
		this.subtotalcondscto = subtotalcondscto;
	}

	public Double getSubtotalcondscto() {
		return this.subtotalcondscto;
	}

	public void setFechavigencia(Date fechavigencia) {
		this.fechavigencia = fechavigencia;
	}

	public Date getFechavigencia() {
		return this.fechavigencia;
	}

	public void setDuracionvigencia(Double duracionvigencia) {
		this.duracionvigencia = duracionvigencia;
	}

	public Double getDuracionvigencia() {
		return this.duracionvigencia;
	}

	public void setConfirmastock(Double confirmastock) {
		this.confirmastock = confirmastock;
	}

	public Double getConfirmastock() {
		return this.confirmastock;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public Date getFechavisita() {
		return this.fechavisita;
	}

	public void setIdfpago(String idfpago) {
		this.idfpago = idfpago;
	}

	public String getIdfpago() {
		return this.idfpago;
	}

	public void setPlazoentrega(String plazoentrega) {
		this.plazoentrega = plazoentrega;
	}

	public String getPlazoentrega() {
		return this.plazoentrega;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public Double getComision() {
		return this.comision;
	}

	public void setIdembalaje(String idembalaje) {
		this.idembalaje = idembalaje;
	}

	public String getIdembalaje() {
		return this.idembalaje;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getGarantia() {
		return this.garantia;
	}

	public void setIdprevaloriza(String idprevaloriza) {
		this.idprevaloriza = idprevaloriza;
	}

	public String getIdprevaloriza() {
		return this.idprevaloriza;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setMultivendedores(Double multivendedores) {
		this.multivendedores = multivendedores;
	}

	public Double getMultivendedores() {
		return this.multivendedores;
	}

	public void setPesobruto(Double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public Double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesotara(Double pesotara) {
		this.pesotara = pesotara;
	}

	public Double getPesotara() {
		return this.pesotara;
	}

	public void setPesoneto(Double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public Double getPesoneto() {
		return this.pesoneto;
	}

	public void setIdtipocontenedor(String idtipocontenedor) {
		this.idtipocontenedor = idtipocontenedor;
	}

	public String getIdtipocontenedor() {
		return this.idtipocontenedor;
	}

	public void setNrocontenedor(String nrocontenedor) {
		this.nrocontenedor = nrocontenedor;
	}

	public String getNrocontenedor() {
		return this.nrocontenedor;
	}

	public void setCiudadorigen(String ciudadorigen) {
		this.ciudadorigen = ciudadorigen;
	}

	public String getCiudadorigen() {
		return this.ciudadorigen;
	}

	public void setCiudaddestino(String ciudaddestino) {
		this.ciudaddestino = ciudaddestino;
	}

	public String getCiudaddestino() {
		return this.ciudaddestino;
	}

	public void setFechaembarque(Date fechaembarque) {
		this.fechaembarque = fechaembarque;
	}

	public Date getFechaembarque() {
		return this.fechaembarque;
	}

	public void setFechaarribo(Date fechaarribo) {
		this.fechaarribo = fechaarribo;
	}

	public Date getFechaarribo() {
		return this.fechaarribo;
	}

	public void setIdpuertoorigen(String idpuertoorigen) {
		this.idpuertoorigen = idpuertoorigen;
	}

	public String getIdpuertoorigen() {
		return this.idpuertoorigen;
	}

	public void setIdpuertodestino(String idpuertodestino) {
		this.idpuertodestino = idpuertodestino;
	}

	public String getIdpuertodestino() {
		return this.idpuertodestino;
	}

	public void setPuertociudadori(String puertociudadori) {
		this.puertociudadori = puertociudadori;
	}

	public String getPuertociudadori() {
		return this.puertociudadori;
	}

	public void setPuertociudaddes(String puertociudaddes) {
		this.puertociudaddes = puertociudaddes;
	}

	public String getPuertociudaddes() {
		return this.puertociudaddes;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getContainer() {
		return this.container;
	}

	public void setIdtipoprecio(String idtipoprecio) {
		this.idtipoprecio = idtipoprecio;
	}

	public String getIdtipoprecio() {
		return this.idtipoprecio;
	}

	public void setIdflete(String idflete) {
		this.idflete = idflete;
	}

	public String getIdflete() {
		return this.idflete;
	}

	public void setExonerado(Double exonerado) {
		this.exonerado = exonerado;
	}

	public Double getExonerado() {
		return this.exonerado;
	}

	public void setEs_proyecto(Double es_proyecto) {
		this.es_proyecto = es_proyecto;
	}

	public Double getEs_proyecto() {
		return this.es_proyecto;
	}

	public void setSmfcred(String smfcred) {
		this.smfcred = smfcred;
	}

	public String getSmfcred() {
		return this.smfcred;
	}

	public void setSmfvenc(String smfvenc) {
		this.smfvenc = smfvenc;
	}

	public String getSmfvenc() {
		return this.smfvenc;
	}

	public void setIdunidadnegocio(String idunidadnegocio) {
		this.idunidadnegocio = idunidadnegocio;
	}

	public String getIdunidadnegocio() {
		return this.idunidadnegocio;
	}

	public void setIdsubunidadnegocio(String idsubunidadnegocio) {
		this.idsubunidadnegocio = idsubunidadnegocio;
	}

	public String getIdsubunidadnegocio() {
		return this.idsubunidadnegocio;
	}

	public void setArea_ha(Double area_ha) {
		this.area_ha = area_ha;
	}

	public Double getArea_ha() {
		return this.area_ha;
	}

	public void setRedondeo(Double redondeo) {
		this.redondeo = redondeo;
	}

	public Double getRedondeo() {
		return this.redondeo;
	}

	public void setFleteusd(Double fleteusd) {
		this.fleteusd = fleteusd;
	}

	public Double getFleteusd() {
		return this.fleteusd;
	}

	public void setIdagentecarga(String idagentecarga) {
		this.idagentecarga = idagentecarga;
	}

	public String getIdagentecarga() {
		return this.idagentecarga;
	}

	public void setIdcondventa(String idcondventa) {
		this.idcondventa = idcondventa;
	}

	public String getIdcondventa() {
		return this.idcondventa;
	}

	public void setIdlineaaerea(String idlineaaerea) {
		this.idlineaaerea = idlineaaerea;
	}

	public String getIdlineaaerea() {
		return this.idlineaaerea;
	}

	public void setNro_forma_pago(String nro_forma_pago) {
		this.nro_forma_pago = nro_forma_pago;
	}

	public String getNro_forma_pago() {
		return this.nro_forma_pago;
	}

	public void setNro_manual(String nro_manual) {
		this.nro_manual = nro_manual;
	}

	public String getNro_manual() {
		return this.nro_manual;
	}

	public void setIdclieprov_destino(String idclieprov_destino) {
		this.idclieprov_destino = idclieprov_destino;
	}

	public String getIdclieprov_destino() {
		return this.idclieprov_destino;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setNrobuckin(String nrobuckin) {
		this.nrobuckin = nrobuckin;
	}

	public String getNrobuckin() {
		return this.nrobuckin;
	}

	public void setContenedor(String contenedor) {
		this.contenedor = contenedor;
	}

	public String getContenedor() {
		return this.contenedor;
	}

	public void setPeso_real(Double peso_real) {
		this.peso_real = peso_real;
	}

	public Double getPeso_real() {
		return this.peso_real;
	}

	public void setNro_viaje(String nro_viaje) {
		this.nro_viaje = nro_viaje;
	}

	public String getNro_viaje() {
		return this.nro_viaje;
	}

	public void setNombre_nave(String nombre_nave) {
		this.nombre_nave = nombre_nave;
	}

	public String getNombre_nave() {
		return this.nombre_nave;
	}

	public void setIddocumento_pf(String iddocumento_pf) {
		this.iddocumento_pf = iddocumento_pf;
	}

	public String getIddocumento_pf() {
		return this.iddocumento_pf;
	}

	public void setSerie_pf(String serie_pf) {
		this.serie_pf = serie_pf;
	}

	public String getSerie_pf() {
		return this.serie_pf;
	}

	public void setNumero_pf(String numero_pf) {
		this.numero_pf = numero_pf;
	}

	public String getNumero_pf() {
		return this.numero_pf;
	}

	public void setFecha_pf(Date fecha_pf) {
		this.fecha_pf = fecha_pf;
	}

	public Date getFecha_pf() {
		return this.fecha_pf;
	}

	public void setGlosa_l(String glosa_l) {
		this.glosa_l = glosa_l;
	}

	public String getGlosa_l() {
		return this.glosa_l;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public String getAwb() {
		return this.awb;
	}

	public void setIdcultivo(String idcultivo) {
		this.idcultivo = idcultivo;
	}

	public String getIdcultivo() {
		return this.idcultivo;
	}

	public void setIdvariedad(String idvariedad) {
		this.idvariedad = idvariedad;
	}

	public String getIdvariedad() {
		return this.idvariedad;
	}

	public void setIdestadobanco(String idestadobanco) {
		this.idestadobanco = idestadobanco;
	}

	public String getIdestadobanco() {
		return this.idestadobanco;
	}

	public void setIdtg30campaniaveh(Integer idtg30campaniaveh) {
		this.idtg30campaniaveh = idtg30campaniaveh;
	}

	public Integer getIdtg30campaniaveh() {
		return this.idtg30campaniaveh;
	}

	public void setIdbanco(String idbanco) {
		this.idbanco = idbanco;
	}

	public String getIdbanco() {
		return this.idbanco;
	}

	public void setOfrecio_seguro(String ofrecio_seguro) {
		this.ofrecio_seguro = ofrecio_seguro;
	}

	public String getOfrecio_seguro() {
		return this.ofrecio_seguro;
	}

	public void setCopropietario(Double copropietario) {
		this.copropietario = copropietario;
	}

	public Double getCopropietario() {
		return this.copropietario;
	}

	public void setIdtipocredito(String idtipocredito) {
		this.idtipocredito = idtipocredito;
	}

	public String getIdtipocredito() {
		return this.idtipocredito;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getCuota() {
		return this.cuota;
	}

	public void setVventapublico_conigv(Double vventapublico_conigv) {
		this.vventapublico_conigv = vventapublico_conigv;
	}

	public Double getVventapublico_conigv() {
		return this.vventapublico_conigv;
	}

	public void setImportedscto1_conigv(Double importedscto1_conigv) {
		this.importedscto1_conigv = importedscto1_conigv;
	}

	public Double getImportedscto1_conigv() {
		return this.importedscto1_conigv;
	}

	public void setImportedscto2_conigv(Double importedscto2_conigv) {
		this.importedscto2_conigv = importedscto2_conigv;
	}

	public Double getImportedscto2_conigv() {
		return this.importedscto2_conigv;
	}

	public void setImportedscto3_conigv(Double importedscto3_conigv) {
		this.importedscto3_conigv = importedscto3_conigv;
	}

	public Double getImportedscto3_conigv() {
		return this.importedscto3_conigv;
	}

	public void setAccesorios_conigv(Double accesorios_conigv) {
		this.accesorios_conigv = accesorios_conigv;
	}

	public Double getAccesorios_conigv() {
		return this.accesorios_conigv;
	}

	public void setIdcopropietario(String idcopropietario) {
		this.idcopropietario = idcopropietario;
	}

	public String getIdcopropietario() {
		return this.idcopropietario;
	}

	public void setIdtg10tipocotizacion(String idtg10tipocotizacion) {
		this.idtg10tipocotizacion = idtg10tipocotizacion;
	}

	public String getIdtg10tipocotizacion() {
		return this.idtg10tipocotizacion;
	}

	public void setIdtg30cotvent_web(Integer idtg30cotvent_web) {
		this.idtg30cotvent_web = idtg30cotvent_web;
	}

	public Integer getIdtg30cotvent_web() {
		return this.idtg30cotvent_web;
	}

	public void setCuotainicial(Double cuotainicial) {
		this.cuotainicial = cuotainicial;
	}

	public Double getCuotainicial() {
		return this.cuotainicial;
	}

	public void setIdctacte(String idctacte) {
		this.idctacte = idctacte;
	}

	public String getIdctacte() {
		return this.idctacte;
	}



	/* Sets & Gets FK*/

}