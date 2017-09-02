package com.nisira.core.entity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by aabad on 16/08/2017.
 */

public class DatosClieProvFree {
        @SerializedName("idbasedatos")
        @Expose
        private String idbasedatos;
        @SerializedName("idempresa")
        @Expose
        private String idempresa;
        @SerializedName("idclieprov")
        @Expose
        private String idclieprov;
        @SerializedName("tipo_clieprov")
        @Expose
        private String tipoClieprov;
        @SerializedName("tipopersona")
        @Expose
        private String tipopersona;
        @SerializedName("apellidopaterno")
        @Expose
        private String apellidopaterno;
        @SerializedName("apellidomaterno")
        @Expose
        private String apellidomaterno;
        @SerializedName("nombres")
        @Expose
        private String nombres;
        @SerializedName("dni")
        @Expose
        private String dni;
        @SerializedName("ruc")
        @Expose
        private String ruc;
        @SerializedName("razonsocial")
        @Expose
        private String razonsocial;
        @SerializedName("direccion")
        @Expose
        private String direccion;
        @SerializedName("estado")
        @Expose
        private Double estado;
        @SerializedName("idgrupoclieprov")
        @Expose
        private String idgrupoclieprov;

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

        public String getIdclieprov() {
            return idclieprov;
        }

        public void setIdclieprov(String idclieprov) {
            this.idclieprov = idclieprov;
        }

        public String getTipoClieprov() {
            return tipoClieprov;
        }

        public void setTipoClieprov(String tipoClieprov) {
            this.tipoClieprov = tipoClieprov;
        }

        public String getTipopersona() {
            return tipopersona;
        }

        public void setTipopersona(String tipopersona) {
            this.tipopersona = tipopersona;
        }

        public String getApellidopaterno() {
            return apellidopaterno;
        }

        public void setApellidopaterno(String apellidopaterno) {
            this.apellidopaterno = apellidopaterno;
        }

        public String getApellidomaterno() {
            return apellidomaterno;
        }

        public void setApellidomaterno(String apellidomaterno) {
            this.apellidomaterno = apellidomaterno;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getRuc() {
            return ruc;
        }

        public void setRuc(String ruc) {
            this.ruc = ruc;
        }

        public String getRazonsocial() {
            return razonsocial;
        }

        public void setRazonsocial(String razonsocial) {
            this.razonsocial = razonsocial;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public Double getEstado() {
            return estado;
        }

        public void setEstado(Double estado) {
            this.estado = estado;
        }

        public String getIdgrupoclieprov() {
            return idgrupoclieprov;
        }

        public void setIdgrupoclieprov(String idgrupoclieprov) {
            this.idgrupoclieprov = idgrupoclieprov;
        }
}
