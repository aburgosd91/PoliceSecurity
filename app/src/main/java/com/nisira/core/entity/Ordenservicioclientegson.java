package com.nisira.core.entity;

import java.util.Date;

/**
 * Created by aabad on 09/08/2017.
 */

public class Ordenservicioclientegson {

    private String idempresa = "" ;
    private String idordenservicio = "" ;
    private String iddocumento = "" ;
    private String serie = "" ;
    private String numero = "" ;
    private String nromanual = "" ;
    private String idclieprov = "" ;
    private Date fecha;
    private String tipo_servicio = "" ;
    private String ambito_servicio = "" ;
    private String idestado = "" ;
    private String sincroniza = "" ;
    private Date fechacreacion;
    private String nrocontenedor = "" ;
    private String nroprecinto = "" ;
    private String nro_oservicio = "" ;
    private String idmotivo = "" ;
    private String glosa = "" ;
    private String idoperario="";
    private String idoperario2="";
    private String contacto="";
    private String razonsocial ="";
    private String estado="";
    private String operario="";
    private String operario2="";


    public Ordenservicioclientegson(String idempresa, String idordenservicio, String iddocumento, String serie, String numero, String nromanual, String idclieprov, Date fecha, String tipo_servicio, String ambito_servicio, String idestado, String sincroniza, Date fechacreacion, String nrocontenedor, String nroprecinto, String nro_oservicio, String idmotivo, String glosa,String idoperario, String idoperario2,String contacto ,String razonsocial, String estado, String operario, String operario2) {
        this.idempresa = idempresa;
        this.idordenservicio = idordenservicio;
        this.iddocumento = iddocumento;
        this.serie = serie;
        this.numero = numero;
        this.nromanual = nromanual;
        this.idclieprov = idclieprov;
        this.fecha = fecha;
        this.tipo_servicio = tipo_servicio;
        this.ambito_servicio = ambito_servicio;
        this.idestado = idestado;
        this.sincroniza = sincroniza;
        this.fechacreacion = fechacreacion;
        this.nrocontenedor = nrocontenedor;
        this.nroprecinto = nroprecinto;
        this.nro_oservicio = nro_oservicio;
        this.idmotivo = idmotivo;
        this.glosa = glosa;
        this.idoperario = idoperario;
        this.idoperario2 = idoperario2;
        this.contacto=contacto;
        this.razonsocial = razonsocial;
        this.estado = estado;
        this.operario = operario;
        this.operario2 = operario2;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdordenservicio() {
        return idordenservicio;
    }

    public void setIdordenservicio(String idordenservicio) {
        this.idordenservicio = idordenservicio;
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

    public String getNromanual() {
        return nromanual;
    }

    public void setNromanual(String nromanual) {
        this.nromanual = nromanual;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getAmbito_servicio() {
        return ambito_servicio;
    }

    public void setAmbito_servicio(String ambito_servicio) {
        this.ambito_servicio = ambito_servicio;
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

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getNrocontenedor() {
        return nrocontenedor;
    }

    public void setNrocontenedor(String nrocontenedor) {
        this.nrocontenedor = nrocontenedor;
    }

    public String getNroprecinto() {
        return nroprecinto;
    }

    public void setNroprecinto(String nroprecinto) {
        this.nroprecinto = nroprecinto;
    }

    public String getNro_oservicio() {
        return nro_oservicio;
    }

    public void setNro_oservicio(String nro_oservicio) {
        this.nro_oservicio = nro_oservicio;
    }

    public String getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(String idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getIdoperario() {
        return idoperario;
    }

    public void setIdoperario(String idoperario) {
        this.idoperario = idoperario;
    }

    public String getIdoperario2() {
        return idoperario2;
    }

    public void setIdoperario2(String idoperario2) {
        this.idoperario2 = idoperario2;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public String getOperario2() {
        return operario2;
    }

    public void setOperario2(String operario2) {
        this.operario2 = operario2;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
