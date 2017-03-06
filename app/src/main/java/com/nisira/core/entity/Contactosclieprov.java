package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import java.util.ArrayList;

@Tabla(nombre = "CONTACTOSCLIEPROV")
@XStreamAlias("CONTACTOSCLIEPROV")

public class Contactosclieprov implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("ITEM") 
	private String item = "" ;
	@Columna
	@SerializedName("nombre") 
	@XStreamAlias("NOMBRE") 
	private String nombre = "" ;
	@Columna
	@SerializedName("direccion") 
	@XStreamAlias("DIRECCION") 
	private String direccion = "" ;
	@Columna
	@SerializedName("telefono1") 
	@XStreamAlias("TELEFONO1") 
	private String telefono1 = "" ;
	@Columna
	@SerializedName("telefono2") 
	@XStreamAlias("TELEFONO2") 
	private String telefono2 = "" ;
	@Columna
	@SerializedName("telefono3") 
	@XStreamAlias("TELEFONO3") 
	private String telefono3 = "" ;
	@Columna
	@SerializedName("email") 
	@XStreamAlias("EMAIL") 
	private String email = "" ;
	@Columna
	@SerializedName("predeterminado") 
	@XStreamAlias("PREDETERMINADO") 
	private Double predeterminado = 0.00 ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;
	@Columna
	@SerializedName("sincroniza") 
	@XStreamAlias("SINCRONIZA") 
	private String sincroniza = "" ;
	@Columna
	@SerializedName("fechacreacion") 
	@XStreamAlias("FECHACREACION") 
	private Date fechacreacion;
	@Columna
	@SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	private String idcargo = "" ;
	@Columna
	@SerializedName("dni") 
	@XStreamAlias("DNI") 
	private String dni = "" ;
	@Columna
	@SerializedName("apellidopaterno") 
	@XStreamAlias("APELLIDOPATERNO") 
	private String apellidopaterno = "" ;
	@Columna
	@SerializedName("apellidomaterno") 
	@XStreamAlias("APELLIDOMATERNO") 
	private String apellidomaterno = "" ;
	@Columna
	@SerializedName("sexo") 
	@XStreamAlias("SEXO") 
	private String sexo = "" ;
	@Columna
	@SerializedName("fecha_nacimiento") 
	@XStreamAlias("FECHA_NACIMIENTO") 
	private Date fecha_nacimiento;
	@Columna
	@SerializedName("direccion_numero") 
	@XStreamAlias("DIRECCION_NUMERO") 
	private Double direccion_numero = 0.00 ;
	@Columna
	@SerializedName("idubigeo") 
	@XStreamAlias("IDUBIGEO") 
	private String idubigeo = "" ;
	@Columna
	@SerializedName("idestadocivil") 
	@XStreamAlias("IDESTADOCIVIL") 
	private String idestadocivil = "" ;
	@Columna
	@SerializedName("telefono4") 
	@XStreamAlias("TELEFONO4") 
	private String telefono4 = "" ;
	@Columna
	@SerializedName("telefono5") 
	@XStreamAlias("TELEFONO5") 
	private String telefono5 = "" ;
	@Columna
	@SerializedName("horapref") 
	@XStreamAlias("HORAPREF") 
	private String horapref = "" ;
	@Columna
	@SerializedName("modocontacto") 
	@XStreamAlias("MODOCONTACTO") 
	private String modocontacto = "" ;
	@Columna
	@SerializedName("cargo") 
	@XStreamAlias("CARGO") 
	private String cargo = "" ;
	@Columna
	@SerializedName("espropietario") 
	@XStreamAlias("ESPROPIETARIO") 
	private Double espropietario = 0.00 ;
	@Columna
	@SerializedName("horaprefh") 
	@XStreamAlias("HORAPREFH") 
	private String horaprefh = "" ;

	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCLIEPROV",campoRelacionado="IDCLIEPROV")})
	private Clieprov clieprov_fk_contactosclieprov_clieprov;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getTelefono3() {
		return this.telefono3;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPredeterminado(Double predeterminado) {
		this.predeterminado = predeterminado;
	}

	public Double getPredeterminado() {
		return this.predeterminado;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_nacimiento() {
		return this.fecha_nacimiento;
	}

	public void setDireccion_numero(Double direccion_numero) {
		this.direccion_numero = direccion_numero;
	}

	public Double getDireccion_numero() {
		return this.direccion_numero;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdestadocivil(String idestadocivil) {
		this.idestadocivil = idestadocivil;
	}

	public String getIdestadocivil() {
		return this.idestadocivil;
	}

	public void setTelefono4(String telefono4) {
		this.telefono4 = telefono4;
	}

	public String getTelefono4() {
		return this.telefono4;
	}

	public void setTelefono5(String telefono5) {
		this.telefono5 = telefono5;
	}

	public String getTelefono5() {
		return this.telefono5;
	}

	public void setHorapref(String horapref) {
		this.horapref = horapref;
	}

	public String getHorapref() {
		return this.horapref;
	}

	public void setModocontacto(String modocontacto) {
		this.modocontacto = modocontacto;
	}

	public String getModocontacto() {
		return this.modocontacto;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setEspropietario(Double espropietario) {
		this.espropietario = espropietario;
	}

	public Double getEspropietario() {
		return this.espropietario;
	}

	public void setHoraprefh(String horaprefh) {
		this.horaprefh = horaprefh;
	}

	public String getHoraprefh() {
		return this.horaprefh;
	}



	/* Sets & Gets FK*/
	public void setClieprov_fk_contactosclieprov_clieprov(Clieprov clieprov_fk_contactosclieprov_clieprov) {
		this.clieprov_fk_contactosclieprov_clieprov = clieprov_fk_contactosclieprov_clieprov;
	}

	public Clieprov getClieprov_fk_contactosclieprov_clieprov() {
		return this.clieprov_fk_contactosclieprov_clieprov;
	}


}