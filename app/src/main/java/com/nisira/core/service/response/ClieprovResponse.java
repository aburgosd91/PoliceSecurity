package com.nisira.core.service.response;

import com.nisira.core.entity.Clieprov;

import java.util.List;

/**
 * Created by aburgos on 26/01/2017.
 */

public class ClieprovResponse {
    private List<Clieprov> datos;
    private int total;

    public List<Clieprov> getdatos() {
        return datos;
    }

    public void setdatos(List<Clieprov> datos) {
        this.datos = datos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Clieprov{" +
                "total=" + total +","+
                "datos=" + datos +
                '}';
    }
}
