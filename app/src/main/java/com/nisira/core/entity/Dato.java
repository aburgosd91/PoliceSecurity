package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by aabad on 10/08/2017.
 */

public class Dato {
    @SerializedName("idempresa")
    @Expose
    private String idempresa;
    @SerializedName("idordenservicio")
    @Expose
    private String idordenservicio;
    @SerializedName("iddocumento")
    @Expose
    private String iddocumento;
    @SerializedName("serie")
    @Expose
    private String serie;
    @SerializedName("numero")
    @Expose
    private String numero;
    @SerializedName("nromanual")
    @Expose
    private String nromanual;
    @SerializedName("idclieprov")
    @Expose
    private String idclieprov;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("tipo_servicio")
    @Expose
    private String tipoServicio;
    @SerializedName("ambito_servicio")
    @Expose
    private String ambitoServicio;
    @SerializedName("idestado")
    @Expose
    private String idestado;
    @SerializedName("sincroniza")
    @Expose
    private String sincroniza;
    @SerializedName("fechacreacion")
    @Expose
    private String fechacreacion;
    @SerializedName("nrocontenedor")
    @Expose
    private String nrocontenedor;
    @SerializedName("nroprecinto")
    @Expose
    private String nroprecinto;
    @SerializedName("nro_oservicio")
    @Expose
    private String nroOservicio;
    @SerializedName("idmotivo")
    @Expose
    private String idmotivo;
    @SerializedName("glosa")
    @Expose
    private String glosa;
    @SerializedName("idoperario")
    @Expose
    private String idoperario;
    @SerializedName("idoperario2")
    @Expose
    private String idoperario2;
    @SerializedName("razonsocial")
    @Expose
    private String razonsocial;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("operario")
    @Expose
    private String operario;
    @SerializedName("operario2")
    @Expose
    private String operario2;
/***  THIS DATA IS FOR DORDENSERVICIOCLIENTE ****/
    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("idvehiculo")
    @Expose
    private String idvehiculo;
    @SerializedName("placa_cliente")
    @Expose
    private String placa_cliente;
    @SerializedName("hora_req")
    @Expose
    private Double hora_req;
    @SerializedName("fecha_fin_servicio")
    @Expose
    private String fecha_fin_servicio;
    @SerializedName("idreferencia")
    @Expose
    private String idreferencia;
    @SerializedName("itemreferencia")
    @Expose
    private String itemreferencia;
    @SerializedName("idservicio")
    @Expose
    private String idservicio;
    @SerializedName("conductor_cliente")
    @Expose
    private String conductor_cliente;
    @SerializedName("hora_rc")
    @Expose
    private Double hora_rc;
    @SerializedName("codoperaciones")
    @Expose
    private String codoperaciones;
    @SerializedName("idruta_ec")
    @Expose
    private String idruta_ec;
    @SerializedName("idconsumidor")
    @Expose
    private String idconsumidor;
    @SerializedName("descripcion_vehiculo")
    @Expose
    private String descripcion_vehiculo;
    @SerializedName("descripcion_servicio")
    @Expose
    private String descripcion_servicio;

    /****  THIS DATA FOR PERSONAL_CLIENTE ****/

    @SerializedName("item2")
    @Expose
    private String item2;
    @SerializedName("idpersonal")
    @Expose
    private String idpersonal;
    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("nombres")
    @Expose
    private String nombres;
    @SerializedName("fechaoperacion")
    @Expose
    private String fechaoperacion;
    @SerializedName("idcargo")
    @Expose
    private String idcargo;
    @SerializedName("fechafin")
    @Expose
    private String fechafin;
    @SerializedName("checklist")
    @Expose
    private String checklist;
    @SerializedName("brevete_cliente")
    @Expose
    private String brevete_cliente;
    @SerializedName("descripcion_cargo")
    @Expose
    private String descripcion_cargo;

    /*** THIS DATA FOR DPERSONAL_CLIENTE ***/

    @SerializedName("item_dordenservicio")
    @Expose
    private String item_dordenservicio;
    @SerializedName("hora_llegada")
    @Expose
    private Double hora_llegada;
    @SerializedName("hora_inicio_serv")
    @Expose
    private Double hora_inicio_serv;
    @SerializedName("hora_fin_serv")
    @Expose
    private Double hora_fin_serv;
    @SerializedName("hora_liberacion")
    @Expose
    private Double hora_liberacion;
    @SerializedName("fecharegistro")
    @Expose
    private String fecharegistro;
    @SerializedName("fechafinregistro")
    @Expose
    private String fechafinregistro;


/***************************  SETTERS AND GETTERS ********************************************/

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getAmbitoServicio() {
        return ambitoServicio;
    }

    public void setAmbitoServicio(String ambitoServicio) {
        this.ambitoServicio = ambitoServicio;
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

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
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

    public String getNroOservicio() {
        return nroOservicio;
    }

    public void setNroOservicio(String nroOservicio) {
        this.nroOservicio = nroOservicio;
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

    /*** ADD SETTER AND GETTER FOR DORDENSERVICIOCLIENTE ***/

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca_cliente() {
        return placa_cliente;
    }

    public void setPlaca_cliente(String placa_cliente) {
        this.placa_cliente = placa_cliente;
    }

    public Double getHora_req() {
        return hora_req;
    }

    public void setHora_req(Double hora_req) {
        this.hora_req = hora_req;
    }

    public String getFecha_fin_servicio() {
        return fecha_fin_servicio;
    }

    public void setFecha_fin_servicio(String fecha_fin_servicio) {
        this.fecha_fin_servicio = fecha_fin_servicio;
    }
    public String getIdreferencia() {
        return idreferencia;
    }

    public void setIdreferencia(String idreferencia) {
        this.idreferencia = idreferencia;
    }

    public String getItemreferencia() {
        return itemreferencia;
    }

    public void setItemreferencia(String itemreferencia) {
        this.itemreferencia = itemreferencia;
    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getConductor_cliente() {
        return conductor_cliente;
    }

    public void setConductor_cliente(String conductor_cliente) {
        this.conductor_cliente = conductor_cliente;
    }
    public Double getHora_rc() {
        return hora_rc;
    }

    public void setHora_rc(Double hora_rc) {
        this.hora_rc = hora_rc;
    }

    public String getCodoperaciones() {
        return codoperaciones;
    }

    public void setCodoperaciones(String codoperaciones) {
        this.codoperaciones = codoperaciones;
    }

    public String getIdruta_ec() {
        return idruta_ec;
    }

    public void setIdruta_ec(String idruta_ec) {
        this.idruta_ec = idruta_ec;
    }

    public String getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(String idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public String getDescripcion_vehiculo() {
        return descripcion_vehiculo;
    }

    public void setDescripcion_vehiculo(String descripcion_vehiculo) {
        this.descripcion_vehiculo = descripcion_vehiculo;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    /***************** ADD SETTER AND GETTER FOR PERSONAL_SERVICIO ******************/

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(String idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaoperacion() {
        return fechaoperacion;
    }

    public void setFechaoperacion(String fechaoperacion) {
        this.fechaoperacion = fechaoperacion;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public String getBrevete_cliente() {
        return brevete_cliente;
    }

    public void setBrevete_cliente(String brevete_cliente) {
        this.brevete_cliente = brevete_cliente;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

    /*************** ADD SETTER AND GETTER FOR DPERSONAL_SERVICIO *********************/

    public String getItem_dordenservicio() {
        return item_dordenservicio;
    }

    public void setItem_dordenservicio(String item_dordenservicio) {
        this.item_dordenservicio = item_dordenservicio;
    }

    public Double getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Double hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Double getHora_inicio_serv() {
        return hora_inicio_serv;
    }

    public void setHora_inicio_serv(Double hora_inicio_serv) {
        this.hora_inicio_serv = hora_inicio_serv;
    }

    public Double getHora_fin_serv() {
        return hora_fin_serv;
    }

    public void setHora_fin_serv(Double hora_fin_serv) {
        this.hora_fin_serv = hora_fin_serv;
    }

    public Double getHora_liberacion() {
        return hora_liberacion;
    }

    public void setHora_liberacion(Double hora_liberacion) {
        this.hora_liberacion = hora_liberacion;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getFechafinregistro() {
        return fechafinregistro;
    }

    public void setFechafinregistro(String fechafinregistro) {
        this.fechafinregistro = fechafinregistro;
    }
}
