package com.nisira.core.entity;

/**
 * Created by aabad on 16/08/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class EstructClieProvFree {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datos")
    @Expose
    private List<DatosClieProvFree> datos = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DatosClieProvFree> getDatos() {
        return datos;
    }

    public void setDatos(List<DatosClieProvFree> datos) {
        this.datos = datos;
    }
}
