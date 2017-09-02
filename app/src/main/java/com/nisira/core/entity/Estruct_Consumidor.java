package com.nisira.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aabad on 16/08/2017.
 */

public class Estruct_Consumidor {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datos")
    @Expose
    private List<DatosConsumidor> datos = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DatosConsumidor> getDatos() {
        return datos;
    }

    public void setDatos(List<DatosConsumidor> datos) {
        this.datos = datos;
    }
}
