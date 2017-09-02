package com.nisira.core.entity;

/**
 * Created by aabad on 01/09/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StructOrdenLiquidacionGastos {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datos")
    @Expose
    private List<DatosOrdenLiquidacionGastos> datos = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DatosOrdenLiquidacionGastos> getDatos() {
        return datos;
    }

    public void setDatos(List<DatosOrdenLiquidacionGastos> datos) {
        this.datos = datos;
    }

}
//public class StructOrdenLiquidacionGastos {}
