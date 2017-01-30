package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "SUCURSALES")
@XStreamAlias("SUCURSALES")

public class Sucursales implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("IDSUCURSAL") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("distribuir") 
	@XStreamAlias("DISTRIBUIR") 
	private Double distribuir = 0.00 ;
	@Columna
	@SerializedName("e_mail") 
	@XStreamAlias("E_MAIL") 
	private String e_mail = "" ;
	@Columna
	@SerializedName("direccion") 
	@XStreamAlias("DIRECCION") 
	private String direccion = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("DESCRIPCION") 
	private String descripcion = "" ;
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
	@SerializedName("idtipoestablecimiento") 
	@XStreamAlias("IDTIPOESTABLECIMIENTO") 
	private String idtipoestablecimiento = "" ;
	@Columna
	@SerializedName("codestablecimiento") 
	@XStreamAlias("CODESTABLECIMIENTO") 
	private String codestablecimiento = "" ;
	@Columna
	@SerializedName("domiciliofiscal") 
	@XStreamAlias("DOMICILIOFISCAL") 
	private Double domiciliofiscal = 0.00 ;
	@Columna
	@SerializedName("idcondicionestablecimiento") 
	@XStreamAlias("IDCONDICIONESTABLECIMIENTO") 
	private String idcondicionestablecimiento = "" ;
	@Columna
	@SerializedName("idvia") 
	@XStreamAlias("IDVIA") 
	private String idvia = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	private Double numero = 0.00 ;
	@Columna
	@SerializedName("interior") 
	@XStreamAlias("INTERIOR") 
	private Double interior = 0.00 ;
	@Columna
	@SerializedName("idzona") 
	@XStreamAlias("IDZONA") 
	private String idzona = "" ;
	@Columna
	@SerializedName("nombrezona") 
	@XStreamAlias("NOMBREZONA") 
	private String nombrezona = "" ;
	@Columna
	@SerializedName("referencia") 
	@XStreamAlias("REFERENCIA") 
	private String referencia = "" ;
	@Columna
	@SerializedName("idubigeo") 
	@XStreamAlias("IDUBIGEO") 
	private String idubigeo = "" ;
	@Columna
	@SerializedName("esplanta") 
	@XStreamAlias("ESPLANTA") 
	private Double esplanta = 0.00 ;
	@Columna
	@SerializedName("fce") 
	@XStreamAlias("FCE") 
	private String fce = "" ;
	@Columna
	@SerializedName("fda") 
	@XStreamAlias("FDA") 
	private String fda = "" ;
	@Columna
	@SerializedName("codigo_rtps") 
	@XStreamAlias("CODIGO_RTPS") 
	private String codigo_rtps = "" ;
	@Columna
	@SerializedName("tasa") 
	@XStreamAlias("TASA") 
	private Double tasa = 0.00 ;
	@Columna
	@SerializedName("plantcode") 
	@XStreamAlias("PLANTCODE") 
	private String plantcode = "" ;
	@Columna
	@SerializedName("idcontrol") 
	@XStreamAlias("IDCONTROL") 
	private String idcontrol = "" ;
	@Columna
	@SerializedName("esproduccionpropia") 
	@XStreamAlias("ESPRODUCCIONPROPIA") 
	private Double esproduccionpropia = 0.00 ;
	@Columna
	@SerializedName("escentroriesgo") 
	@XStreamAlias("ESCENTRORIESGO") 
	private Double escentroriesgo = 0.00 ;
	@Columna
	@SerializedName("ctactemn") 
	@XStreamAlias("CTACTEMN") 
	private String ctactemn = "" ;
	@Columna
	@SerializedName("ctacteme") 
	@XStreamAlias("CTACTEME") 
	private String ctacteme = "" ;
	@Columna
	@SerializedName("codalterno") 
	@XStreamAlias("CODALTERNO") 
	private String codalterno = "" ;
	@Columna
	@SerializedName("cc_cpf") 
	@XStreamAlias("CC_CPF") 
	private String cc_cpf = "" ;
	@Columna
	@SerializedName("departamento") 
	@XStreamAlias("DEPARTAMENTO") 
	private String departamento = "" ;
	@Columna
	@SerializedName("distrito") 
	@XStreamAlias("DISTRITO") 
	private String distrito = "" ;
	@Columna
	@SerializedName("provincia") 
	@XStreamAlias("PROVINCIA") 
	private String provincia = "" ;
	@Columna
	@SerializedName("codigo_mtc") 
	@XStreamAlias("CODIGO_MTC") 
	private String codigo_mtc = "" ;
	@Columna
	@SerializedName("esdespacho") 
	@XStreamAlias("ESDESPACHO") 
	private Double esdespacho = 0.00 ;
	@Columna
	@SerializedName("genera_reqinterno") 
	@XStreamAlias("GENERA_REQINTERNO") 
	private Double genera_reqinterno = 0.00 ;
	@Columna
	@SerializedName("idclieprov_destino") 
	@XStreamAlias("IDCLIEPROV_DESTINO") 
	private String idclieprov_destino = "" ;
	@Columna
	@SerializedName("idresponsable") 
	@XStreamAlias("IDRESPONSABLE") 
	private String idresponsable = "" ;
	@Columna
	@SerializedName("idsucursal_spring") 
	@XStreamAlias("IDSUCURSAL_SPRING") 
	private String idsucursal_spring = "" ;
	@Columna
	@SerializedName("es_fundo") 
	@XStreamAlias("ES_FUNDO") 
	private Double es_fundo = 0.00 ;
	@Columna
	@SerializedName("nombre_corto") 
	@XStreamAlias("NOMBRE_CORTO") 
	private String nombre_corto = "" ;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setDistribuir(Double distribuir) {
		this.distribuir = distribuir;
	}

	public Double getDistribuir() {
		return this.distribuir;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
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

	public void setIdtipoestablecimiento(String idtipoestablecimiento) {
		this.idtipoestablecimiento = idtipoestablecimiento;
	}

	public String getIdtipoestablecimiento() {
		return this.idtipoestablecimiento;
	}

	public void setCodestablecimiento(String codestablecimiento) {
		this.codestablecimiento = codestablecimiento;
	}

	public String getCodestablecimiento() {
		return this.codestablecimiento;
	}

	public void setDomiciliofiscal(Double domiciliofiscal) {
		this.domiciliofiscal = domiciliofiscal;
	}

	public Double getDomiciliofiscal() {
		return this.domiciliofiscal;
	}

	public void setIdcondicionestablecimiento(String idcondicionestablecimiento) {
		this.idcondicionestablecimiento = idcondicionestablecimiento;
	}

	public String getIdcondicionestablecimiento() {
		return this.idcondicionestablecimiento;
	}

	public void setIdvia(String idvia) {
		this.idvia = idvia;
	}

	public String getIdvia() {
		return this.idvia;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public Double getNumero() {
		return this.numero;
	}

	public void setInterior(Double interior) {
		this.interior = interior;
	}

	public Double getInterior() {
		return this.interior;
	}

	public void setIdzona(String idzona) {
		this.idzona = idzona;
	}

	public String getIdzona() {
		return this.idzona;
	}

	public void setNombrezona(String nombrezona) {
		this.nombrezona = nombrezona;
	}

	public String getNombrezona() {
		return this.nombrezona;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setEsplanta(Double esplanta) {
		this.esplanta = esplanta;
	}

	public Double getEsplanta() {
		return this.esplanta;
	}

	public void setFce(String fce) {
		this.fce = fce;
	}

	public String getFce() {
		return this.fce;
	}

	public void setFda(String fda) {
		this.fda = fda;
	}

	public String getFda() {
		return this.fda;
	}

	public void setCodigo_rtps(String codigo_rtps) {
		this.codigo_rtps = codigo_rtps;
	}

	public String getCodigo_rtps() {
		return this.codigo_rtps;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Double getTasa() {
		return this.tasa;
	}

	public void setPlantcode(String plantcode) {
		this.plantcode = plantcode;
	}

	public String getPlantcode() {
		return this.plantcode;
	}

	public void setIdcontrol(String idcontrol) {
		this.idcontrol = idcontrol;
	}

	public String getIdcontrol() {
		return this.idcontrol;
	}

	public void setEsproduccionpropia(Double esproduccionpropia) {
		this.esproduccionpropia = esproduccionpropia;
	}

	public Double getEsproduccionpropia() {
		return this.esproduccionpropia;
	}

	public void setEscentroriesgo(Double escentroriesgo) {
		this.escentroriesgo = escentroriesgo;
	}

	public Double getEscentroriesgo() {
		return this.escentroriesgo;
	}

	public void setCtactemn(String ctactemn) {
		this.ctactemn = ctactemn;
	}

	public String getCtactemn() {
		return this.ctactemn;
	}

	public void setCtacteme(String ctacteme) {
		this.ctacteme = ctacteme;
	}

	public String getCtacteme() {
		return this.ctacteme;
	}

	public void setCodalterno(String codalterno) {
		this.codalterno = codalterno;
	}

	public String getCodalterno() {
		return this.codalterno;
	}

	public void setCc_cpf(String cc_cpf) {
		this.cc_cpf = cc_cpf;
	}

	public String getCc_cpf() {
		return this.cc_cpf;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setCodigo_mtc(String codigo_mtc) {
		this.codigo_mtc = codigo_mtc;
	}

	public String getCodigo_mtc() {
		return this.codigo_mtc;
	}

	public void setEsdespacho(Double esdespacho) {
		this.esdespacho = esdespacho;
	}

	public Double getEsdespacho() {
		return this.esdespacho;
	}

	public void setGenera_reqinterno(Double genera_reqinterno) {
		this.genera_reqinterno = genera_reqinterno;
	}

	public Double getGenera_reqinterno() {
		return this.genera_reqinterno;
	}

	public void setIdclieprov_destino(String idclieprov_destino) {
		this.idclieprov_destino = idclieprov_destino;
	}

	public String getIdclieprov_destino() {
		return this.idclieprov_destino;
	}

	public void setIdresponsable(String idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getIdresponsable() {
		return this.idresponsable;
	}

	public void setIdsucursal_spring(String idsucursal_spring) {
		this.idsucursal_spring = idsucursal_spring;
	}

	public String getIdsucursal_spring() {
		return this.idsucursal_spring;
	}

	public void setEs_fundo(Double es_fundo) {
		this.es_fundo = es_fundo;
	}

	public Double getEs_fundo() {
		return this.es_fundo;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}



	/* Sets & Gets FK*/

}