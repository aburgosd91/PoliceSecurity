package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aabad on 06/09/2017.
 */

public class DatosDocumentos {

    @SerializedName("idbasedatos")
    @Expose
    private String idbasedatos;
    @SerializedName("idempresa")
    @Expose
    private String idempresa;
    @SerializedName("iddocumento")
    @Expose
    private String iddocumento;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("codigo_sunat")
    @Expose
    private String codigoSunat;
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

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoSunat() {
        return codigoSunat;
    }

    public void setCodigoSunat(String codigoSunat) {
        this.codigoSunat = codigoSunat;
    }

    public Double getEstado() {
        return estado;
    }

    public void setEstado(Double estado) {
        this.estado = estado;
    }

}
