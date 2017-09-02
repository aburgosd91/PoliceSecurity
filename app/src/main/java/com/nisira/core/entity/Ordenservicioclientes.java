package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aabad on 10/08/2017.
 */

public class Ordenservicioclientes {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datos")
    @Expose
    private List<Dato> datos = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Dato> getDatos() {
        return datos;
    }

    public void setDatos(List<Dato> datos) {
        this.datos = datos;
    }
}
