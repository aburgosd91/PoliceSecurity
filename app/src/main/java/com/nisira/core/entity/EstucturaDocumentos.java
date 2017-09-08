package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aabad on 06/09/2017.
 */

public class EstucturaDocumentos {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datos")
    @Expose
    private List<DatosDocumentos> datosDocumentos = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DatosDocumentos> getDatos() {
        return datosDocumentos;
    }

    public void setDatos(List<DatosDocumentos> datosDocumentos) {
        this.datosDocumentos = datosDocumentos;
    }
}
