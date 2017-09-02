package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aabad on 16/08/2017.
 */

public class DatosConsumidor {
    @SerializedName("idempresa")
    @Expose
    private String idempresa;
    @SerializedName("idconsumidor")
    @Expose
    private String idconsumidor;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("jerarquia")
    @Expose
    private String jerarquia;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("idccosto")
    @Expose
    private String idccosto;
    @SerializedName("fecha_ingreso")
    @Expose
    private String fechaIngreso;
    @SerializedName("estado")
    @Expose
    private Double estado;
    @SerializedName("marca")
    @Expose
    private String marca;
    @SerializedName("placa")
    @Expose
    private String placa;
    @SerializedName("tipovehiculo")
    @Expose
    private String tipovehiculo;
    @SerializedName("anio")
    @Expose
    private Double anio;
    @SerializedName("idbasedatos")
    @Expose
    private String idbasedatos;

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdconsumidor() {
        return idconsumidor;
    }

    public void setIdconsumidor(String idconsumidor) {
        this.idconsumidor = idconsumidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdccosto() {
        return idccosto;
    }

    public void setIdccosto(String idccosto) {
        this.idccosto = idccosto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Double getEstado() {
        return estado;
    }

    public void setEstado(Double estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public Double getAnio() {
        return anio;
    }

    public void setAnio(Double anio) {
        this.anio = anio;
    }

    public String getIdbasedatos() {
        return idbasedatos;
    }

    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }
}
