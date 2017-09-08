package com.nisira.core.entity;

/**
 * Created by aabad on 01/09/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosOrdenLiquidacionGastos {
    @SerializedName("idbasedatos")
    @Expose
    private String idbasedatos;
    @SerializedName("idempresa")
    @Expose
    private String idempresa;
    @SerializedName("idorden")
    @Expose
    private String idorden;
    @SerializedName("idemisor")
    @Expose
    private String idemisor;
    @SerializedName("periodo")
    @Expose
    private String periodo;
    @SerializedName("fecharegistro")
    @Expose
    private String fecharegistro;
    @SerializedName("idsucursal")
    @Expose
    private String idsucursal;
    @SerializedName("iddocumento")
    @Expose
    private String iddocumento;
    @SerializedName("serie")
    @Expose
    private String serie;
    @SerializedName("numero")
    @Expose
    private String numero;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("tcambio")
    @Expose
    private Double tcambio;
    @SerializedName("idclieprov")
    @Expose
    private String idclieprov;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("ruc")
    @Expose
    private String ruc;
    @SerializedName("razonsocial")
    @Expose
    private String razonsocial;
    @SerializedName("idregimen")
    @Expose
    private String idregimen;
    @SerializedName("idmoneda")
    @Expose
    private String idmoneda;
    @SerializedName("tcmoneda")
    @Expose
    private Double tcmoneda;
    @SerializedName("idtipomov")
    @Expose
    private String idtipomov;
    @SerializedName("idfpago")
    @Expose
    private String idfpago;
    @SerializedName("idarea")
    @Expose
    private String idarea;
    @SerializedName("glosa")
    @Expose
    private String glosa;
    @SerializedName("vventa")
    @Expose
    private Double vventa;
    @SerializedName("inafecto")
    @Expose
    private Double inafecto;
    @SerializedName("otros")
    @Expose
    private Double otros;
    @SerializedName("impuesto")
    @Expose
    private Double impuesto;
    @SerializedName("pimpuesto")
    @Expose
    private Double pimpuesto;
    @SerializedName("descuento")
    @Expose
    private Double descuento;
    @SerializedName("pdescuento")
    @Expose
    private Double pdescuento;
    @SerializedName("descuentodoc")
    @Expose
    private Double descuentodoc;
    @SerializedName("redondeo")
    @Expose
    private Double redondeo;
    @SerializedName("importe")
    @Expose
    private Double importe;
    @SerializedName("importemof")
    @Expose
    private Double importemof;
    @SerializedName("importemex")
    @Expose
    private Double importemex;
    @SerializedName("idestado")
    @Expose
    private String idestado;
    @SerializedName("sincroniza")
    @Expose
    private String sincroniza;
    @SerializedName("igv")
    @Expose
    private Double igv;
    @SerializedName("idusuario")
    @Expose
    private String idusuario;
    @SerializedName("fechacreacion")
    @Expose
    private String fechacreacion;
    @SerializedName("moneda")
    @Expose
    private String moneda;
    @SerializedName("sucursal")
    @Expose
    private String sucursal;
    @SerializedName("emisor")
    @Expose
    private String emisor;

   // DATOS DORDERNLIQUIDACIONCOSTO


    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("idconcepto")
    @Expose
    private String idconcepto;
    @SerializedName("idcuenta")
    @Expose
    private String idcuenta;
    @SerializedName("idccosto")
    @Expose
    private String idccosto;
    @SerializedName("iddestino")
    @Expose
    private String iddestino;
    @SerializedName("afecto")
    @Expose
    private Double afecto;
    @SerializedName("idconsumidor")
    @Expose
    private String idconsumidor;
    @SerializedName("conceptocuenta")
    @Expose
    private String conceptocuenta;
    @SerializedName("destinoadquisicion")
    @Expose
    private String destinoadquisicion;

    // ADD DATOS PARA TIPO_GASTO

    @SerializedName("idtipogasto")
    @Expose
    private String idtipogasto;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("estado")
    @Expose
    private Double estado;




    public String getIdbasedatos() {
        return idbasedatos;
    }

    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdorden() {
        return idorden;
    }

    public void setIdorden(String idorden) {
        this.idorden = idorden;
    }

    public String getIdemisor() {
        return idemisor;
    }

    public void setIdemisor(String idemisor) {
        this.idemisor = idemisor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(String idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTcambio() {
        return tcambio;
    }

    public void setTcambio(Double tcambio) {
        this.tcambio = tcambio;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getIdregimen() {
        return idregimen;
    }

    public void setIdregimen(String idregimen) {
        this.idregimen = idregimen;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Double getTcmoneda() {
        return tcmoneda;
    }

    public void setTcmoneda(Double tcmoneda) {
        this.tcmoneda = tcmoneda;
    }

    public String getIdtipomov() {
        return idtipomov;
    }

    public void setIdtipomov(String idtipomov) {
        this.idtipomov = idtipomov;
    }

    public String getIdfpago() {
        return idfpago;
    }

    public void setIdfpago(String idfpago) {
        this.idfpago = idfpago;
    }

    public String getIdarea() {
        return idarea;
    }

    public void setIdarea(String idarea) {
        this.idarea = idarea;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public Double getVventa() {
        return vventa;
    }

    public void setVventa(Double vventa) {
        this.vventa = vventa;
    }

    public Double getInafecto() {
        return inafecto;
    }

    public void setInafecto(Double inafecto) {
        this.inafecto = inafecto;
    }

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getPimpuesto() {
        return pimpuesto;
    }

    public void setPimpuesto(Double pimpuesto) {
        this.pimpuesto = pimpuesto;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPdescuento() {
        return pdescuento;
    }

    public void setPdescuento(Double pdescuento) {
        this.pdescuento = pdescuento;
    }

    public Double getDescuentodoc() {
        return descuentodoc;
    }

    public void setDescuentodoc(Double descuentodoc) {
        this.descuentodoc = descuentodoc;
    }

    public Double getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(Double redondeo) {
        this.redondeo = redondeo;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getImportemof() {
        return importemof;
    }

    public void setImportemof(Double importemof) {
        this.importemof = importemof;
    }

    public Double getImportemex() {
        return importemex;
    }

    public void setImportemex(Double importemex) {
        this.importemex = importemex;
    }

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public String getSincroniza() {
        return sincroniza;
    }

    public void setSincroniza(String sincroniza) {
        this.sincroniza = sincroniza;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }


    // DATOS DORDENLIQUIDACIONCOSTO


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(String idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getIdccosto() {
        return idccosto;
    }

    public void setIdccosto(String idccosto) {
        this.idccosto = idccosto;
    }

    public String getIddestino() {
        return iddestino;
    }

    public void setIddestino(String iddestino) {
        this.iddestino = iddestino;
    }

    public Double getAfecto() {
        return afecto;
    }

    public void setAfecto(Double afecto) {
        this.afecto = afecto;
    }

    public String getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(String idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public String getConceptocuenta() {
        return conceptocuenta;
    }

    public void setConceptocuenta(String conceptocuenta) {
        this.conceptocuenta = conceptocuenta;
    }

    public String getDestinoadquisicion() {
        return destinoadquisicion;
    }

    public void setDestinoadquisicion(String destinoadquisicion) {
        this.destinoadquisicion = destinoadquisicion;
    }

    //ADD DATOS PARA TIPO_GASTO


    public String getIdtipogasto() {
        return idtipogasto;
    }

    public void setIdtipogasto(String idtipogasto) {
        this.idtipogasto = idtipogasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getEstado() {
        return estado;
    }

    public void setEstado(Double estado) {
        this.estado = estado;
    }

}
