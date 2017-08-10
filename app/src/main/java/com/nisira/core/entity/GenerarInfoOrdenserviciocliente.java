package com.nisira.core.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aabad on 09/08/2017.
 */

public class GenerarInfoOrdenserviciocliente {
    private Integer total=0;
     private ArrayList<Ordenservicioclientegson> datos;
    //List<Ordenservicioclientegson> ListOrdenservicioclientegson;

    public GenerarInfoOrdenserviciocliente(Integer total) {
        this.total = total;
        datos = new ArrayList<>();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ArrayList<Ordenservicioclientegson> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Ordenservicioclientegson> datos) {
        this.datos = datos;
    }
}
