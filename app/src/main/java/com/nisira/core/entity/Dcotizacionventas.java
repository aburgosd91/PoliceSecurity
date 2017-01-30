package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "DCOTIZACIONVENTAS")
@XStreamAlias("DCOTIZACIONVENTAS")

public class Dcotizacionventas implements Serializable {
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
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("idcompra") 
	@XStreamAlias("IDCOMPRA") 
	private String idcompra = "" ;
	@Columna
	@SerializedName("itemcotizacion") 
	@XStreamAlias("ITEMCOTIZACION") 
	private String itemcotizacion = "" ;
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("IDPRODUCTO") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("IDMEDIDA") 
	private String idmedida = "" ;
	@Columna
	@SerializedName("cantidad") 
	@XStreamAlias("CANTIDAD") 
	private Double cantidad = 0.00 ;
	@Columna
	@SerializedName("precio") 
	@XStreamAlias("PRECIO") 
	private Double precio = 0.00 ;
	@Columna
	@SerializedName("descuento") 
	@XStreamAlias("DESCUENTO") 
	private Double descuento = 0.00 ;
	@Columna
	@SerializedName("importe") 
	@XStreamAlias("IMPORTE") 
	private Double importe = 0.00 ;
	@Columna
	@SerializedName("es_afecto") 
	@XStreamAlias("ES_AFECTO") 
	private Double es_afecto = 0.00 ;
	@Columna
	@SerializedName("porcentajedscto1") 
	@XStreamAlias("PORCENTAJEDSCTO1") 
	private Double porcentajedscto1 = 0.00 ;
	@Columna
	@SerializedName("porcentajedscto2") 
	@XStreamAlias("PORCENTAJEDSCTO2") 
	private Double porcentajedscto2 = 0.00 ;
	@Columna
	@SerializedName("porcentajedscto3") 
	@XStreamAlias("PORCENTAJEDSCTO3") 
	private Double porcentajedscto3 = 0.00 ;
	@Columna
	@SerializedName("impuesto_i") 
	@XStreamAlias("IMPUESTO_I") 
	private Double impuesto_i = 0.00 ;
	@Columna
	@SerializedName("impuesto") 
	@XStreamAlias("IMPUESTO") 
	private Double impuesto = 0.00 ;
	@Columna
	@SerializedName("importedscto1") 
	@XStreamAlias("IMPORTEDSCTO1") 
	private Double importedscto1 = 0.00 ;
	@Columna
	@SerializedName("importedscto2") 
	@XStreamAlias("IMPORTEDSCTO2") 
	private Double importedscto2 = 0.00 ;
	@Columna
	@SerializedName("importedscto3") 
	@XStreamAlias("IMPORTEDSCTO3") 
	private Double importedscto3 = 0.00 ;
	@Columna
	@SerializedName("subtotalsindscto") 
	@XStreamAlias("SUBTOTALSINDSCTO") 
	private Double subtotalsindscto = 0.00 ;
	@Columna
	@SerializedName("subtotalcondscto") 
	@XStreamAlias("SUBTOTALCONDSCTO") 
	private Double subtotalcondscto = 0.00 ;
	@Columna
	@SerializedName("idestadoproducto") 
	@XStreamAlias("IDESTADOPRODUCTO") 
	private String idestadoproducto = "" ;
	@Columna
	@SerializedName("descuento_total") 
	@XStreamAlias("DESCUENTO_TOTAL") 
	private Double descuento_total = 0.00 ;
	@Columna
	@SerializedName("destino") 
	@XStreamAlias("DESTINO") 
	private String destino = "" ;
	@Columna
	@SerializedName("idestado") 
	@XStreamAlias("IDESTADO") 
	private String idestado = "" ;
	@Columna
	@SerializedName("idestadoold") 
	@XStreamAlias("IDESTADOOLD") 
	private String idestadoold = "" ;
	@Columna
	@SerializedName("observaciones") 
	@XStreamAlias("OBSERVACIONES") 
	private String observaciones = "" ;
	@Columna
	@SerializedName("anniofabricacion") 
	@XStreamAlias("ANNIOFABRICACION") 
	private String anniofabricacion = "" ;
	@Columna
	@SerializedName("clase") 
	@XStreamAlias("CLASE") 
	private String clase = "" ;
	@Columna
	@SerializedName("carroceria") 
	@XStreamAlias("CARROCERIA") 
	private String carroceria = "" ;
	@Columna
	@SerializedName("transmision") 
	@XStreamAlias("TRANSMISION") 
	private String transmision = "" ;
	@Columna
	@SerializedName("tipomotor") 
	@XStreamAlias("TIPOMOTOR") 
	private String tipomotor = "" ;
	@Columna
	@SerializedName("combustible") 
	@XStreamAlias("COMBUSTIBLE") 
	private String combustible = "" ;
	@Columna
	@SerializedName("idreferencia") 
	@XStreamAlias("IDREFERENCIA") 
	private String idreferencia = "" ;
	@Columna
	@SerializedName("itemref") 
	@XStreamAlias("ITEMREF") 
	private String itemref = "" ;
	@Columna
	@SerializedName("tablaref") 
	@XStreamAlias("TABLAREF") 
	private String tablaref = "" ;
	@Columna
	@SerializedName("documentoref") 
	@XStreamAlias("DOCUMENTOREF") 
	private String documentoref = "" ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("idconsumidor") 
	@XStreamAlias("IDCONSUMIDOR") 
	private String idconsumidor = "" ;
	@Columna
	@SerializedName("idplantillacv") 
	@XStreamAlias("IDPLANTILLACV") 
	private String idplantillacv = "" ;
	@Columna
	@SerializedName("parafecha") 
	@XStreamAlias("PARAFECHA") 
	private Date parafecha;
	@Columna
	@SerializedName("dias") 
	@XStreamAlias("DIAS") 
	private Double dias = 0.00 ;
	@Columna
	@SerializedName("idserie") 
	@XStreamAlias("IDSERIE") 
	private String idserie = "" ;
	@Columna
	@SerializedName("idcolor") 
	@XStreamAlias("IDCOLOR") 
	private String idcolor = "" ;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("IDSUCURSAL") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("idalmacen") 
	@XStreamAlias("IDALMACEN") 
	private String idalmacen = "" ;
	@Columna
	@SerializedName("calibremm") 
	@XStreamAlias("CALIBREMM") 
	private String calibremm = "" ;
	@Columna
	@SerializedName("factorce") 
	@XStreamAlias("FACTORCE") 
	private Double factorce = 0.00 ;
	@Columna
	@SerializedName("idinsumo") 
	@XStreamAlias("IDINSUMO") 
	private String idinsumo = "" ;
	@Columna
	@SerializedName("idpresentacion") 
	@XStreamAlias("IDPRESENTACION") 
	private String idpresentacion = "" ;
	@Columna
	@SerializedName("idtalla") 
	@XStreamAlias("IDTALLA") 
	private String idtalla = "" ;
	@Columna
	@SerializedName("largo") 
	@XStreamAlias("LARGO") 
	private String largo = "" ;
	@Columna
	@SerializedName("total_ce") 
	@XStreamAlias("TOTAL_CE") 
	private Double total_ce = 0.00 ;
	@Columna
	@SerializedName("undxphl") 
	@XStreamAlias("UNDXPHL") 
	private Integer undxphl;
	@Columna
	@SerializedName("descuento_i") 
	@XStreamAlias("DESCUENTO_I") 
	private Double descuento_i = 0.00 ;
	@Columna
	@SerializedName("importe_isc") 
	@XStreamAlias("IMPORTE_ISC") 
	private Double importe_isc = 0.00 ;
	@Columna
	@SerializedName("accesorios_conigv") 
	@XStreamAlias("ACCESORIOS_CONIGV") 
	private Double accesorios_conigv = 0.00 ;
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
	@SerializedName("importedscto_importador_real") 
	@XStreamAlias("IMPORTEDSCTO_IMPORTADOR_REAL") 
	private Double importedscto_importador_real = 0.00 ;
	@Columna
	@SerializedName("importedscto_maxpermitido") 
	@XStreamAlias("IMPORTEDSCTO_MAXPERMITIDO") 
	private Double importedscto_maxpermitido = 0.00 ;
	@Columna
	@SerializedName("vventapublico_conigv") 
	@XStreamAlias("VVENTAPUBLICO_CONIGV") 
	private Double vventapublico_conigv = 0.00 ;
	@Columna
	@SerializedName("anniomodelo") 
	@XStreamAlias("ANNIOMODELO") 
	private String anniomodelo = "" ;
	@Columna
	@SerializedName("idtg20versionveh") 
	@XStreamAlias("IDTG20VERSIONVEH") 
	private Integer idtg20versionveh;
	@Columna
	@SerializedName("importeaccesorios") 
	@XStreamAlias("IMPORTEACCESORIOS") 
	private Double importeaccesorios = 0.00 ;



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

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setIdcompra(String idcompra) {
		this.idcompra = idcompra;
	}

	public String getIdcompra() {
		return this.idcompra;
	}

	public void setItemcotizacion(String itemcotizacion) {
		this.itemcotizacion = itemcotizacion;
	}

	public String getItemcotizacion() {
		return this.itemcotizacion;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setEs_afecto(Double es_afecto) {
		this.es_afecto = es_afecto;
	}

	public Double getEs_afecto() {
		return this.es_afecto;
	}

	public void setPorcentajedscto1(Double porcentajedscto1) {
		this.porcentajedscto1 = porcentajedscto1;
	}

	public Double getPorcentajedscto1() {
		return this.porcentajedscto1;
	}

	public void setPorcentajedscto2(Double porcentajedscto2) {
		this.porcentajedscto2 = porcentajedscto2;
	}

	public Double getPorcentajedscto2() {
		return this.porcentajedscto2;
	}

	public void setPorcentajedscto3(Double porcentajedscto3) {
		this.porcentajedscto3 = porcentajedscto3;
	}

	public Double getPorcentajedscto3() {
		return this.porcentajedscto3;
	}

	public void setImpuesto_i(Double impuesto_i) {
		this.impuesto_i = impuesto_i;
	}

	public Double getImpuesto_i() {
		return this.impuesto_i;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getImpuesto() {
		return this.impuesto;
	}

	public void setImportedscto1(Double importedscto1) {
		this.importedscto1 = importedscto1;
	}

	public Double getImportedscto1() {
		return this.importedscto1;
	}

	public void setImportedscto2(Double importedscto2) {
		this.importedscto2 = importedscto2;
	}

	public Double getImportedscto2() {
		return this.importedscto2;
	}

	public void setImportedscto3(Double importedscto3) {
		this.importedscto3 = importedscto3;
	}

	public Double getImportedscto3() {
		return this.importedscto3;
	}

	public void setSubtotalsindscto(Double subtotalsindscto) {
		this.subtotalsindscto = subtotalsindscto;
	}

	public Double getSubtotalsindscto() {
		return this.subtotalsindscto;
	}

	public void setSubtotalcondscto(Double subtotalcondscto) {
		this.subtotalcondscto = subtotalcondscto;
	}

	public Double getSubtotalcondscto() {
		return this.subtotalcondscto;
	}

	public void setIdestadoproducto(String idestadoproducto) {
		this.idestadoproducto = idestadoproducto;
	}

	public String getIdestadoproducto() {
		return this.idestadoproducto;
	}

	public void setDescuento_total(Double descuento_total) {
		this.descuento_total = descuento_total;
	}

	public Double getDescuento_total() {
		return this.descuento_total;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDestino() {
		return this.destino;
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

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setAnniofabricacion(String anniofabricacion) {
		this.anniofabricacion = anniofabricacion;
	}

	public String getAnniofabricacion() {
		return this.anniofabricacion;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getClase() {
		return this.clase;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getCarroceria() {
		return this.carroceria;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTransmision() {
		return this.transmision;
	}

	public void setTipomotor(String tipomotor) {
		this.tipomotor = tipomotor;
	}

	public String getTipomotor() {
		return this.tipomotor;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setIdreferencia(String idreferencia) {
		this.idreferencia = idreferencia;
	}

	public String getIdreferencia() {
		return this.idreferencia;
	}

	public void setItemref(String itemref) {
		this.itemref = itemref;
	}

	public String getItemref() {
		return this.itemref;
	}

	public void setTablaref(String tablaref) {
		this.tablaref = tablaref;
	}

	public String getTablaref() {
		return this.tablaref;
	}

	public void setDocumentoref(String documentoref) {
		this.documentoref = documentoref;
	}

	public String getDocumentoref() {
		return this.documentoref;
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

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setIdplantillacv(String idplantillacv) {
		this.idplantillacv = idplantillacv;
	}

	public String getIdplantillacv() {
		return this.idplantillacv;
	}

	public void setParafecha(Date parafecha) {
		this.parafecha = parafecha;
	}

	public Date getParafecha() {
		return this.parafecha;
	}

	public void setDias(Double dias) {
		this.dias = dias;
	}

	public Double getDias() {
		return this.dias;
	}

	public void setIdserie(String idserie) {
		this.idserie = idserie;
	}

	public String getIdserie() {
		return this.idserie;
	}

	public void setIdcolor(String idcolor) {
		this.idcolor = idcolor;
	}

	public String getIdcolor() {
		return this.idcolor;
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

	public void setCalibremm(String calibremm) {
		this.calibremm = calibremm;
	}

	public String getCalibremm() {
		return this.calibremm;
	}

	public void setFactorce(Double factorce) {
		this.factorce = factorce;
	}

	public Double getFactorce() {
		return this.factorce;
	}

	public void setIdinsumo(String idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getIdinsumo() {
		return this.idinsumo;
	}

	public void setIdpresentacion(String idpresentacion) {
		this.idpresentacion = idpresentacion;
	}

	public String getIdpresentacion() {
		return this.idpresentacion;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}

	public String getIdtalla() {
		return this.idtalla;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getLargo() {
		return this.largo;
	}

	public void setTotal_ce(Double total_ce) {
		this.total_ce = total_ce;
	}

	public Double getTotal_ce() {
		return this.total_ce;
	}

	public void setUndxphl(Integer undxphl) {
		this.undxphl = undxphl;
	}

	public Integer getUndxphl() {
		return this.undxphl;
	}

	public void setDescuento_i(Double descuento_i) {
		this.descuento_i = descuento_i;
	}

	public Double getDescuento_i() {
		return this.descuento_i;
	}

	public void setImporte_isc(Double importe_isc) {
		this.importe_isc = importe_isc;
	}

	public Double getImporte_isc() {
		return this.importe_isc;
	}

	public void setAccesorios_conigv(Double accesorios_conigv) {
		this.accesorios_conigv = accesorios_conigv;
	}

	public Double getAccesorios_conigv() {
		return this.accesorios_conigv;
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

	public void setImportedscto_importador_real(Double importedscto_importador_real) {
		this.importedscto_importador_real = importedscto_importador_real;
	}

	public Double getImportedscto_importador_real() {
		return this.importedscto_importador_real;
	}

	public void setImportedscto_maxpermitido(Double importedscto_maxpermitido) {
		this.importedscto_maxpermitido = importedscto_maxpermitido;
	}

	public Double getImportedscto_maxpermitido() {
		return this.importedscto_maxpermitido;
	}

	public void setVventapublico_conigv(Double vventapublico_conigv) {
		this.vventapublico_conigv = vventapublico_conigv;
	}

	public Double getVventapublico_conigv() {
		return this.vventapublico_conigv;
	}

	public void setAnniomodelo(String anniomodelo) {
		this.anniomodelo = anniomodelo;
	}

	public String getAnniomodelo() {
		return this.anniomodelo;
	}

	public void setIdtg20versionveh(Integer idtg20versionveh) {
		this.idtg20versionveh = idtg20versionveh;
	}

	public Integer getIdtg20versionveh() {
		return this.idtg20versionveh;
	}

	public void setImporteaccesorios(Double importeaccesorios) {
		this.importeaccesorios = importeaccesorios;
	}

	public Double getImporteaccesorios() {
		return this.importeaccesorios;
	}



	/* Sets & Gets FK*/

}