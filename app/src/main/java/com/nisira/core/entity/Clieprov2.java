package com.nisira.core.entity;

import com.google.gson.annotations.SerializedName;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by aabad on 28/08/2017.
 */
@Tabla(nombre = "CLIEPROV")
@XStreamAlias("CLIEPROV")
public class Clieprov2 implements Serializable{
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
    @Columna
    @SerializedName("tipo_clieprov")
    @XStreamAlias("TIPO_CLIEPROV")
    private String tipo_clieprov = "" ;
    @Columna
    @SerializedName("tipopersona")
    @XStreamAlias("TIPOPERSONA")
    private String tipopersona = "" ;
    @Columna
    @SerializedName("idtipocliente")
    @XStreamAlias("IDTIPOCLIENTE")
    private String idtipocliente = "" ;
    @Columna
    @SerializedName("con_retencion")
    @XStreamAlias("CON_RETENCION")
    private Double con_retencion = 0.00 ;
    @Columna
    @SerializedName("sin_retencion")
    @XStreamAlias("SIN_RETENCION")
    private String sin_retencion = "" ;
    @Columna
    @SerializedName("contacto")
    @XStreamAlias("CONTACTO")
    private String contacto = "" ;
    @Columna
    @SerializedName("direccion")
    @XStreamAlias("DIRECCION")
    private String direccion = "" ;
    @Columna
    @SerializedName("idvia1")
    @XStreamAlias("IDVIA1")
    private String idvia1 = "" ;
    @Columna
    @SerializedName("via1_descripcion")
    @XStreamAlias("VIA1_DESCRIPCION")
    private String via1_descripcion = "" ;
    @Columna
    @SerializedName("direccion_numero")
    @XStreamAlias("DIRECCION_NUMERO")
    private Double direccion_numero = 0.00 ;
    @Columna
    @SerializedName("direccion_interior")
    @XStreamAlias("DIRECCION_INTERIOR")
    private String direccion_interior = "" ;
    @Columna
    @SerializedName("direccion_referencia")
    @XStreamAlias("DIRECCION_REFERENCIA")
    private String direccion_referencia = "" ;
    @Columna
    @SerializedName("idzona1")
    @XStreamAlias("IDZONA1")
    private String idzona1 = "" ;
    @Columna
    @SerializedName("zona1_descripcion")
    @XStreamAlias("ZONA1_DESCRIPCION")
    private String zona1_descripcion = "" ;
    @Columna
    @SerializedName("idubigeo1")
    @XStreamAlias("IDUBIGEO1")
    private String idubigeo1 = "" ;
    @Columna
    @SerializedName("distrito")
    @XStreamAlias("DISTRITO")
    private String distrito = "" ;
    @Columna
    @SerializedName("departamento")
    @XStreamAlias("DEPARTAMENTO")
    private String departamento = "" ;
    @Columna
    @SerializedName("apellidopaterno")
    @XStreamAlias("APELLIDOPATERNO")
    private String apellidopaterno = "" ;
    @Columna
    @SerializedName("apellidomaterno")
    @XStreamAlias("APELLIDOMATERNO")
    private String apellidomaterno = "" ;
    @Columna
    @SerializedName("nombres")
    @XStreamAlias("NOMBRES")
    private String nombres = "" ;
    @Columna
    @SerializedName("razon_social")
    @XStreamAlias("RAZON_SOCIAL")
    private String razon_social = "" ;
    @Columna
    @SerializedName("e_mail")
    @XStreamAlias("E_MAIL")
    private String e_mail = "" ;
    @Columna
    @SerializedName("fax")
    @XStreamAlias("FAX")
    private String fax = "" ;
    @Columna
    @SerializedName("telefono_1")
    @XStreamAlias("TELEFONO_1")
    private String telefono_1 = "" ;
    @Columna
    @SerializedName("telefono_2")
    @XStreamAlias("TELEFONO_2")
    private String telefono_2 = "" ;
    @Columna
    @SerializedName("telefono_3")
    @XStreamAlias("TELEFONO_3")
    private String telefono_3 = "" ;
    @Columna
    @SerializedName("nombre_giro")
    @XStreamAlias("NOMBRE_GIRO")
    private String nombre_giro = "" ;
    @Columna
    @SerializedName("iddocidentidad")
    @XStreamAlias("IDDOCIDENTIDAD")
    private String iddocidentidad = "" ;
    @Columna
    @SerializedName("nrodocidentidad")
    @XStreamAlias("NRODOCIDENTIDAD")
    private String nrodocidentidad = "" ;
    @Columna
    @SerializedName("dni")
    @XStreamAlias("DNI")
    private String dni = "" ;
    @Columna
    @SerializedName("nextel")
    @XStreamAlias("NEXTEL")
    private String nextel = "" ;
    @Columna
    @SerializedName("provincia")
    @XStreamAlias("PROVINCIA")
    private String provincia = "" ;
    @Columna
    @SerializedName("regimen_agrario")
    @XStreamAlias("REGIMEN_AGRARIO")
    private Double regimen_agrario = 0.00 ;
    @Columna
    @SerializedName("ruc")
    @XStreamAlias("RUC")
    private String ruc = "" ;
    @Columna
    @SerializedName("ruc_anterior")
    @XStreamAlias("RUC_ANTERIOR")
    private String ruc_anterior = "" ;
    @Columna
    @SerializedName("intxclient")
    @XStreamAlias("INTXCLIENT")
    private Double intxclient = 0.00 ;
    @Columna
    @SerializedName("dias_gracia")
    @XStreamAlias("DIAS_GRACIA")
    private Double dias_gracia = 0.00 ;
    @Columna
    @SerializedName("idvendedor")
    @XStreamAlias("IDVENDEDOR")
    private String idvendedor = "" ;
    @Columna
    @SerializedName("idpersonal")
    @XStreamAlias("IDPERSONAL")
    private String idpersonal = "" ;
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
    @SerializedName("ctacte")
    @XStreamAlias("CTACTE")
    private String ctacte = "" ;
    @Columna
    @SerializedName("extranjero")
    @XStreamAlias("EXTRANJERO")
    private Double extranjero = 0.00 ;
    @Columna
    @SerializedName("precio_aplicado")
    @XStreamAlias("PRECIO_APLICADO")
    private String precio_aplicado = "" ;
    @Columna
    @SerializedName("libreoccliente")
    @XStreamAlias("LIBREOCCLIENTE")
    private Double libreoccliente = 0.00 ;
    @Columna
    @SerializedName("regmtc")
    @XStreamAlias("REGMTC")
    private String regmtc = "" ;
    @Columna
    @SerializedName("subcontratado")
    @XStreamAlias("SUBCONTRATADO")
    private Double subcontratado = 0.00 ;
    @Columna
    @SerializedName("idtiposocio")
    @XStreamAlias("IDTIPOSOCIO")
    private String idtiposocio = "" ;
    @Columna
    @SerializedName("fecha_nacimiento")
    @XStreamAlias("FECHA_NACIMIENTO")
    private Date fecha_nacimiento;
    @Columna
    @SerializedName("idprofesion")
    @XStreamAlias("IDPROFESION")
    private String idprofesion = "" ;
    @Columna
    @SerializedName("centrotrabajo")
    @XStreamAlias("CENTROTRABAJO")
    private String centrotrabajo = "" ;
    @Columna
    @SerializedName("sexo")
    @XStreamAlias("SEXO")
    private String sexo = "" ;
    @Columna
    @SerializedName("idestadocivil")
    @XStreamAlias("IDESTADOCIVIL")
    private String idestadocivil = "" ;
    @Columna
    @SerializedName("idvia2")
    @XStreamAlias("IDVIA2")
    private String idvia2 = "" ;
    @Columna
    @SerializedName("via2_descripcion")
    @XStreamAlias("VIA2_DESCRIPCION")
    private String via2_descripcion = "" ;
    @Columna
    @SerializedName("direccob_numero")
    @XStreamAlias("DIRECCOB_NUMERO")
    private Double direccob_numero = 0.00 ;
    @Columna
    @SerializedName("direccob_interior")
    @XStreamAlias("DIRECCOB_INTERIOR")
    private String direccob_interior = "" ;
    @Columna
    @SerializedName("direccob_referencia")
    @XStreamAlias("DIRECCOB_REFERENCIA")
    private String direccob_referencia = "" ;
    @Columna
    @SerializedName("idzona2")
    @XStreamAlias("IDZONA2")
    private String idzona2 = "" ;
    @Columna
    @SerializedName("zona2_descripcion")
    @XStreamAlias("ZONA2_DESCRIPCION")
    private String zona2_descripcion = "" ;
    @Columna
    @SerializedName("idubigeo2")
    @XStreamAlias("IDUBIGEO2")
    private String idubigeo2 = "" ;
    @Columna
    @SerializedName("fecha_ingreso")
    @XStreamAlias("FECHA_INGRESO")
    private Date fecha_ingreso;
    @Columna
    @SerializedName("credito")
    @XStreamAlias("CREDITO")
    private String credito = "" ;
    @Columna
    @SerializedName("nrocertif")
    @XStreamAlias("NROCERTIF")
    private String nrocertif = "" ;
    @Columna
    @SerializedName("tipocertif")
    @XStreamAlias("TIPOCERTIF")
    private String tipocertif = "" ;
    @Columna
    @SerializedName("nrolibro")
    @XStreamAlias("NROLIBRO")
    private String nrolibro = "" ;
    @Columna
    @SerializedName("idcobrador")
    @XStreamAlias("IDCOBRADOR")
    private String idcobrador = "" ;
    @Columna
    @SerializedName("idsociocorp")
    @XStreamAlias("IDSOCIOCORP")
    private String idsociocorp = "" ;
    @Columna
    @SerializedName("universidad")
    @XStreamAlias("UNIVERSIDAD")
    private String universidad = "" ;
    @Columna
    @SerializedName("idubigeo3_ln")
    @XStreamAlias("IDUBIGEO3_LN")
    private String idubigeo3_ln = "" ;
    @Columna
    @SerializedName("fecha_email")
    @XStreamAlias("FECHA_EMAIL")
    private Date fecha_email;
    @Columna
    @SerializedName("idbarra")
    @XStreamAlias("IDBARRA")
    private String idbarra = "" ;
    @Columna
    @SerializedName("idbanco")
    @XStreamAlias("IDBANCO")
    private String idbanco = "" ;
    @Columna
    @SerializedName("tipo_cuentabanco")
    @XStreamAlias("TIPO_CUENTABANCO")
    private String tipo_cuentabanco = "" ;
    @Columna
    @SerializedName("idmoneda")
    @XStreamAlias("IDMONEDA")
    private String idmoneda = "" ;
    @Columna
    @SerializedName("foto")
    @XStreamAlias("FOTO")
    private String foto = "" ;
    @Columna
    @SerializedName("crednormal")
    @XStreamAlias("CREDNORMAL")
    private Double crednormal = 0.00 ;
    @Columna
    @SerializedName("credtemporal")
    @XStreamAlias("CREDTEMPORAL")
    private Double credtemporal = 0.00 ;
    @Columna
    @SerializedName("credtotal")
    @XStreamAlias("CREDTOTAL")
    private Double credtotal = 0.00 ;
    @Columna
    @SerializedName("iddescuento")
    @XStreamAlias("IDDESCUENTO")
    private String iddescuento = "" ;
    @Columna
    @SerializedName("idgrupoclieprov")
    @XStreamAlias("IDGRUPOCLIEPROV")
    private String idgrupoclieprov = "" ;
    @Columna
    @SerializedName("idbanco_pred")
    @XStreamAlias("IDBANCO_PRED")
    private String idbanco_pred = "" ;
    @Columna
    @SerializedName("idctacte_pred")
    @XStreamAlias("IDCTACTE_PRED")
    private String idctacte_pred = "" ;
    @Columna
    @SerializedName("idbanco_prov")
    @XStreamAlias("IDBANCO_PROV")
    private String idbanco_prov = "" ;
    @Columna
    @SerializedName("ctacte2")
    @XStreamAlias("CTACTE2")
    private String ctacte2 = "" ;
    @Columna
    @SerializedName("ctacte3")
    @XStreamAlias("CTACTE3")
    private String ctacte3 = "" ;
    @Columna
    @SerializedName("ctacte4")
    @XStreamAlias("CTACTE4")
    private String ctacte4 = "" ;
    @Columna
    @SerializedName("idbanco_prov2")
    @XStreamAlias("IDBANCO_PROV2")
    private String idbanco_prov2 = "" ;
    @Columna
    @SerializedName("idbanco_prov3")
    @XStreamAlias("IDBANCO_PROV3")
    private String idbanco_prov3 = "" ;
    @Columna
    @SerializedName("idbanco_prov4")
    @XStreamAlias("IDBANCO_PROV4")
    private String idbanco_prov4 = "" ;
    @Columna
    @SerializedName("estado_cta")
    @XStreamAlias("ESTADO_CTA")
    private Double estado_cta = 0.00 ;
    @Columna
    @SerializedName("estado_cta2")
    @XStreamAlias("ESTADO_CTA2")
    private Double estado_cta2 = 0.00 ;
    @Columna
    @SerializedName("estado_cta3")
    @XStreamAlias("ESTADO_CTA3")
    private Double estado_cta3 = 0.00 ;
    @Columna
    @SerializedName("estado_cta4")
    @XStreamAlias("ESTADO_CTA4")
    private Double estado_cta4 = 0.00 ;
    @Columna
    @SerializedName("idmoneda2")
    @XStreamAlias("IDMONEDA2")
    private String idmoneda2 = "" ;
    @Columna
    @SerializedName("idmoneda3")
    @XStreamAlias("IDMONEDA3")
    private String idmoneda3 = "" ;
    @Columna
    @SerializedName("idmoneda4")
    @XStreamAlias("IDMONEDA4")
    private String idmoneda4 = "" ;
    @Columna
    @SerializedName("girar_cheque")
    @XStreamAlias("GIRAR_CHEQUE")
    private String girar_cheque = "" ;
    @Columna
    @SerializedName("nombre_esposa")
    @XStreamAlias("NOMBRE_ESPOSA")
    private String nombre_esposa = "" ;
    @Columna
    @SerializedName("dni_esposa")
    @XStreamAlias("DNI_ESPOSA")
    private String dni_esposa = "" ;
    @Columna
    @SerializedName("idsector")
    @XStreamAlias("IDSECTOR")
    private String idsector = "" ;
    @Columna
    @SerializedName("nombre_comercial")
    @XStreamAlias("NOMBRE_COMERCIAL")
    private String nombre_comercial = "" ;
    @Columna
    @SerializedName("ciiu")
    @XStreamAlias("CIIU")
    private String ciiu = "" ;
    @Columna
    @SerializedName("idnacionalidad")
    @XStreamAlias("IDNACIONALIDAD")
    private String idnacionalidad = "" ;
    @Columna
    @SerializedName("infoadreporte_pie")
    @XStreamAlias("INFOADREPORTE_PIE")
    private String infoadreporte_pie = "" ;
    @Columna
    @SerializedName("es_transportista")
    @XStreamAlias("ES_TRANSPORTISTA")
    private Double es_transportista = 0.00 ;
    @Columna
    @SerializedName("idconvenio")
    @XStreamAlias("IDCONVENIO")
    private String idconvenio = "" ;
    @Columna
    @SerializedName("idreferido")
    @XStreamAlias("IDREFERIDO")
    private String idreferido = "" ;
    @Columna
    @SerializedName("idniveleducativo")
    @XStreamAlias("IDNIVELEDUCATIVO")
    private String idniveleducativo = "" ;
    @Columna
    @SerializedName("idcargo")
    @XStreamAlias("IDCARGO")
    private String idcargo = "" ;
    @Columna
    @SerializedName("es_socionegocio")
    @XStreamAlias("ES_SOCIONEGOCIO")
    private Double es_socionegocio = 0.00 ;
    @Columna
    @SerializedName("es_operadoraereo")
    @XStreamAlias("ES_OPERADORAEREO")
    private Double es_operadoraereo = 0.00 ;
    @Columna
    @SerializedName("idcontacto")
    @XStreamAlias("IDCONTACTO")
    private String idcontacto = "" ;
    @Columna
    @SerializedName("idcanal")
    @XStreamAlias("IDCANAL")
    private String idcanal = "" ;
    @Columna
    @SerializedName("idfpago")
    @XStreamAlias("IDFPAGO")
    private String idfpago = "" ;
    @Columna
    @SerializedName("seriedocventa")
    @XStreamAlias("SERIEDOCVENTA")
    private String seriedocventa = "" ;
    @Columna
    @SerializedName("es_agenteretenedor")
    @XStreamAlias("ES_AGENTERETENEDOR")
    private Double es_agenteretenedor = 0.00 ;
    @Columna
    @SerializedName("idpaisemisor")
    @XStreamAlias("IDPAISEMISOR")
    private String idpaisemisor = "" ;
    @Columna
    @SerializedName("estado_sunat")
    @XStreamAlias("ESTADO_SUNAT")
    private String estado_sunat = "" ;
    @Columna
    @SerializedName("destacapersonal_cliente")
    @XStreamAlias("DESTACAPERSONAL_CLIENTE")
    private Double destacapersonal_cliente = 0.00 ;
    @Columna
    @SerializedName("destacapersonal_proveedor")
    @XStreamAlias("DESTACAPERSONAL_PROVEEDOR")
    private Double destacapersonal_proveedor = 0.00 ;
    @Columna
    @SerializedName("idtipoactividad")
    @XStreamAlias("IDTIPOACTIVIDAD")
    private String idtipoactividad = "" ;
    @Columna
    @SerializedName("domiciliado")
    @XStreamAlias("DOMICILIADO")
    private Double domiciliado = 0.00 ;
    @Columna
    @SerializedName("rep_legal")
    @XStreamAlias("REP_LEGAL")
    private String rep_legal = "" ;
    @Columna
    @SerializedName("idprocedencia")
    @XStreamAlias("IDPROCEDENCIA")
    private String idprocedencia = "" ;
    @Columna
    @SerializedName("es_naviera")
    @XStreamAlias("ES_NAVIERA")
    private Double es_naviera = 0.00 ;
    @Columna
    @SerializedName("es_agenteaduana")
    @XStreamAlias("ES_AGENTEADUANA")
    private Double es_agenteaduana = 0.00 ;
    @Columna
    @SerializedName("porcentajecomision")
    @XStreamAlias("PORCENTAJECOMISION")
    private Double porcentajecomision = 0.00 ;
    @Columna
    @SerializedName("comisionminima")
    @XStreamAlias("COMISIONMINIMA")
    private Double comisionminima = 0.00 ;
    @Columna
    @SerializedName("montocomisionminima")
    @XStreamAlias("MONTOCOMISIONMINIMA")
    private Double montocomisionminima = 0.00 ;
    @Columna
    @SerializedName("condicion_sunat")
    @XStreamAlias("CONDICION_SUNAT")
    private String condicion_sunat = "" ;
    @Columna
    @SerializedName("idregimenaseg_salud")
    @XStreamAlias("IDREGIMENASEG_SALUD")
    private String idregimenaseg_salud = "" ;
    @Columna
    @SerializedName("es_agricultor")
    @XStreamAlias("ES_AGRICULTOR")
    private Double es_agricultor = 0.00 ;
    @Columna
    @SerializedName("montomin_garanvscont")
    @XStreamAlias("MONTOMIN_GARANVSCONT")
    private Double montomin_garanvscont = 0.00 ;
    @Columna
    @SerializedName("es_aseguradora")
    @XStreamAlias("ES_ASEGURADORA")
    private Double es_aseguradora = 0.00 ;
    @Columna
    @SerializedName("aseguradora_web")
    @XStreamAlias("ASEGURADORA_WEB")
    private String aseguradora_web = "" ;
    @Columna
    @SerializedName("importado_externo")
    @XStreamAlias("IMPORTADO_EXTERNO")
    private Double importado_externo = 0.00 ;
    @Columna
    @SerializedName("actividad_economica")
    @XStreamAlias("ACTIVIDAD_ECONOMICA")
    private String actividad_economica = "" ;
    @Columna
    @SerializedName("conyugue")
    @XStreamAlias("CONYUGUE")
    private String conyugue = "" ;
    @Columna
    @SerializedName("dependiente")
    @XStreamAlias("DEPENDIENTE")
    private Double dependiente = 0.00 ;
    @Columna
    @SerializedName("dirconyugue")
    @XStreamAlias("DIRCONYUGUE")
    private String dirconyugue = "" ;
    @Columna
    @SerializedName("dircorrespondencia")
    @XStreamAlias("DIRCORRESPONDENCIA")
    private String dircorrespondencia = "" ;
    @Columna
    @SerializedName("dni_adicional")
    @XStreamAlias("DNI_ADICIONAL")
    private String dni_adicional = "" ;
    @Columna
    @SerializedName("empleador")
    @XStreamAlias("EMPLEADOR")
    private String empleador = "" ;
    @Columna
    @SerializedName("e_mail2")
    @XStreamAlias("E_MAIL2")
    private String e_mail2 = "" ;
    @Columna
    @SerializedName("fnconyugue")
    @XStreamAlias("FNCONYUGUE")
    private Date fnconyugue;
    @Columna
    @SerializedName("ref_adicional")
    @XStreamAlias("REF_ADICIONAL")
    private String ref_adicional = "" ;
    @Columna
    @SerializedName("cny_email1")
    @XStreamAlias("CNY_EMAIL1")
    private String cny_email1 = "" ;
    @Columna
    @SerializedName("cny_email2")
    @XStreamAlias("CNY_EMAIL2")
    private String cny_email2 = "" ;
    @Columna
    @SerializedName("cny_fax")
    @XStreamAlias("CNY_FAX")
    private String cny_fax = "" ;
    @Columna
    @SerializedName("cny_fono1")
    @XStreamAlias("CNY_FONO1")
    private String cny_fono1 = "" ;
    @Columna
    @SerializedName("cny_fono2")
    @XStreamAlias("CNY_FONO2")
    private String cny_fono2 = "" ;
    @Columna
    @SerializedName("direc1")
    @XStreamAlias("DIREC1")
    private String direc1 = "" ;
    @Columna
    @SerializedName("direc2")
    @XStreamAlias("DIREC2")
    private String direc2 = "" ;
    @Columna
    @SerializedName("direc3")
    @XStreamAlias("DIREC3")
    private String direc3 = "" ;
    @Columna
    @SerializedName("direc4")
    @XStreamAlias("DIREC4")
    private String direc4 = "" ;
    @Columna
    @SerializedName("direc5")
    @XStreamAlias("DIREC5")
    private String direc5 = "" ;
    @Columna
    @SerializedName("fnh1")
    @XStreamAlias("FNH1")
    private String fnh1 = "" ;
    @Columna
    @SerializedName("fnh2")
    @XStreamAlias("FNH2")
    private String fnh2 = "" ;
    @Columna
    @SerializedName("fnh3")
    @XStreamAlias("FNH3")
    private String fnh3 = "" ;
    @Columna
    @SerializedName("fnh4")
    @XStreamAlias("FNH4")
    private String fnh4 = "" ;
    @Columna
    @SerializedName("fnh5")
    @XStreamAlias("FNH5")
    private String fnh5 = "" ;
    @Columna
    @SerializedName("fnh6")
    @XStreamAlias("FNH6")
    private String fnh6 = "" ;
    @Columna
    @SerializedName("fnh7")
    @XStreamAlias("FNH7")
    private String fnh7 = "" ;
    @Columna
    @SerializedName("fnh8")
    @XStreamAlias("FNH8")
    private String fnh8 = "" ;
    @Columna
    @SerializedName("hijo1")
    @XStreamAlias("HIJO1")
    private String hijo1 = "" ;
    @Columna
    @SerializedName("hijo2")
    @XStreamAlias("HIJO2")
    private String hijo2 = "" ;
    @Columna
    @SerializedName("hijo3")
    @XStreamAlias("HIJO3")
    private String hijo3 = "" ;
    @Columna
    @SerializedName("hijo4")
    @XStreamAlias("HIJO4")
    private String hijo4 = "" ;
    @Columna
    @SerializedName("hijo5")
    @XStreamAlias("HIJO5")
    private String hijo5 = "" ;
    @Columna
    @SerializedName("hijo6")
    @XStreamAlias("HIJO6")
    private String hijo6 = "" ;
    @Columna
    @SerializedName("hijo7")
    @XStreamAlias("HIJO7")
    private String hijo7 = "" ;
    @Columna
    @SerializedName("hijo8")
    @XStreamAlias("HIJO8")
    private String hijo8 = "" ;
    @Columna
    @SerializedName("ingreso_mensual")
    @XStreamAlias("INGRESO_MENSUAL")
    private Double ingreso_mensual = 0.00 ;
    @Columna
    @SerializedName("idmonedalc")
    @XStreamAlias("IDMONEDALC")
    private String idmonedalc = "" ;
    @Columna
    @SerializedName("estadolc")
    @XStreamAlias("ESTADOLC")
    private Double estadolc = 0.00 ;
    @Columna
    @SerializedName("es_retenedor")
    @XStreamAlias("ES_RETENEDOR")
    private Double es_retenedor = 0.00 ;
    @Columna
    @SerializedName("es_percepcion")
    @XStreamAlias("ES_PERCEPCION")
    private Double es_percepcion = 0.00 ;
    @Columna
    @SerializedName("es_buencontribuyente")
    @XStreamAlias("ES_BUENCONTRIBUYENTE")
    private Double es_buencontribuyente = 0.00 ;
    @Columna
    @SerializedName("idafp")
    @XStreamAlias("IDAFP")
    private String idafp = "" ;
    @Columna
    @SerializedName("inicio_afp")
    @XStreamAlias("INICIO_AFP")
    private Date inicio_afp;
    @Columna
    @SerializedName("inicio_onp")
    @XStreamAlias("INICIO_ONP")
    private Date inicio_onp;
    @Columna
    @SerializedName("autogeneradoafp")
    @XStreamAlias("AUTOGENERADOAFP")
    private String autogeneradoafp = "" ;
    @Columna
    @SerializedName("idtipoprecio")
    @XStreamAlias("IDTIPOPRECIO")
    private String idtipoprecio = "" ;
    @Columna
    @SerializedName("idcondventa")
    @XStreamAlias("IDCONDVENTA")
    private String idcondventa = "" ;
    @Columna
    @SerializedName("idflete")
    @XStreamAlias("IDFLETE")
    private String idflete = "" ;
    @Columna
    @SerializedName("facturable")
    @XStreamAlias("FACTURABLE")
    private Double facturable = 0.00 ;
    @Columna
    @SerializedName("ocupacion")
    @XStreamAlias("OCUPACION")
    private String ocupacion = "" ;
    @Columna
    @SerializedName("ingresopromedio")
    @XStreamAlias("INGRESOPROMEDIO")
    private Double ingresopromedio = 0.00 ;
    @Columna
    @SerializedName("centrotrabajo_conyuge")
    @XStreamAlias("CENTROTRABAJO_CONYUGE")
    private String centrotrabajo_conyuge = "" ;
    @Columna
    @SerializedName("ingresopromedio_conyuge")
    @XStreamAlias("INGRESOPROMEDIO_CONYUGE")
    private Double ingresopromedio_conyuge = 0.00 ;
    @Columna
    @SerializedName("ingresopromedio_anual")
    @XStreamAlias("INGRESOPROMEDIO_ANUAL")
    private Double ingresopromedio_anual = 0.00 ;
    @Columna
    @SerializedName("idmonedaingresopromedio")
    @XStreamAlias("IDMONEDAINGRESOPROMEDIO")
    private String idmonedaingresopromedio = "" ;
    @Columna
    @SerializedName("idcondicionlaboral")
    @XStreamAlias("IDCONDICIONLABORAL")
    private String idcondicionlaboral = "" ;
    @Columna
    @SerializedName("idcategorialaboral")
    @XStreamAlias("IDCATEGORIALABORAL")
    private String idcategorialaboral = "" ;
    @Columna
    @SerializedName("centrotrabajo_ruc")
    @XStreamAlias("CENTROTRABAJO_RUC")
    private String centrotrabajo_ruc = "" ;
    @Columna
    @SerializedName("contratoindeterminado")
    @XStreamAlias("CONTRATOINDETERMINADO")
    private String contratoindeterminado = "" ;
    @Columna
    @SerializedName("condicionindependiente_ruc")
    @XStreamAlias("CONDICIONINDEPENDIENTE_RUC")
    private String condicionindependiente_ruc = "" ;
    @Columna
    @SerializedName("fecha_ingreso_inicioact")
    @XStreamAlias("FECHA_INGRESO_INICIOACT")
    private Date fecha_ingreso_inicioact;
    @Columna
    @SerializedName("separacionbienes")
    @XStreamAlias("SEPARACIONBIENES")
    private String separacionbienes = "" ;
    @Columna
    @SerializedName("numerohijos")
    @XStreamAlias("NUMEROHIJOS")
    private Double numerohijos = 0.00 ;
    @Columna
    @SerializedName("nrotrabajadores")
    @XStreamAlias("NROTRABAJADORES")
    private Double nrotrabajadores = 0.00 ;
    @Columna
    @SerializedName("idtipoclieprov")
    @XStreamAlias("IDTIPOCLIEPROV")
    private String idtipoclieprov = "" ;
    @Columna
    @SerializedName("es_proveedor_tercero")
    @XStreamAlias("ES_PROVEEDOR_TERCERO")
    private Double es_proveedor_tercero = 0.00 ;
    @Columna
    @SerializedName("es_registroxweb")
    @XStreamAlias("ES_REGISTROXWEB")
    private Double es_registroxweb = 0.00 ;
    @Columna
    @SerializedName("clave_cita")
    @XStreamAlias("CLAVE_CITA")
    private String clave_cita = "" ;
    @Columna
    @SerializedName("conrus")
    @XStreamAlias("CONRUS")
    private String conrus = "" ;
    @Columna
    @SerializedName("idclasificacion_bs_sunat")
    @XStreamAlias("IDCLASIFICACION_BS_SUNAT")
    private String idclasificacion_bs_sunat = "" ;
    @Columna
    @SerializedName("idvinculo_cr_sunat")
    @XStreamAlias("IDVINCULO_CR_SUNAT")
    private String idvinculo_cr_sunat = "" ;
    @Columna
    @SerializedName("idexoneracion_sunat")
    @XStreamAlias("IDEXONERACION_SUNAT")
    private String idexoneracion_sunat = "" ;
    @Columna
    @SerializedName("idtiporenta_sunat")
    @XStreamAlias("IDTIPORENTA_SUNAT")
    private String idtiporenta_sunat = "" ;
    @Columna
    @SerializedName("idmodalidad_sunat")
    @XStreamAlias("IDMODALIDAD_SUNAT")
    private String idmodalidad_sunat = "" ;
    @Columna
    @SerializedName("es_importado")
    @XStreamAlias("ES_IMPORTADO")
    private Double es_importado = 0.00 ;
    @Columna
    @SerializedName("codequivalente")
    @XStreamAlias("CODEQUIVALENTE")
    private String codequivalente = "" ;
    @Columna
    @SerializedName("codigo_alt")
    @XStreamAlias("CODIGO_ALT")
    private String codigo_alt = "" ;

    private Boolean seleccion;


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

    public void setTipo_clieprov(String tipo_clieprov) {
        this.tipo_clieprov = tipo_clieprov;
    }

    public String getTipo_clieprov() {
        return this.tipo_clieprov;
    }

    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getTipopersona() {
        return this.tipopersona;
    }

    public void setIdtipocliente(String idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public String getIdtipocliente() {
        return this.idtipocliente;
    }

    public void setCon_retencion(Double con_retencion) {
        this.con_retencion = con_retencion;
    }

    public Double getCon_retencion() {
        return this.con_retencion;
    }

    public void setSin_retencion(String sin_retencion) {
        this.sin_retencion = sin_retencion;
    }

    public String getSin_retencion() {
        return this.sin_retencion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setIdvia1(String idvia1) {
        this.idvia1 = idvia1;
    }

    public String getIdvia1() {
        return this.idvia1;
    }

    public void setVia1_descripcion(String via1_descripcion) {
        this.via1_descripcion = via1_descripcion;
    }

    public String getVia1_descripcion() {
        return this.via1_descripcion;
    }

    public void setDireccion_numero(Double direccion_numero) {
        this.direccion_numero = direccion_numero;
    }

    public Double getDireccion_numero() {
        return this.direccion_numero;
    }

    public void setDireccion_interior(String direccion_interior) {
        this.direccion_interior = direccion_interior;
    }

    public String getDireccion_interior() {
        return this.direccion_interior;
    }

    public void setDireccion_referencia(String direccion_referencia) {
        this.direccion_referencia = direccion_referencia;
    }

    public String getDireccion_referencia() {
        return this.direccion_referencia;
    }

    public void setIdzona1(String idzona1) {
        this.idzona1 = idzona1;
    }

    public String getIdzona1() {
        return this.idzona1;
    }

    public void setZona1_descripcion(String zona1_descripcion) {
        this.zona1_descripcion = zona1_descripcion;
    }

    public String getZona1_descripcion() {
        return this.zona1_descripcion;
    }

    public void setIdubigeo1(String idubigeo1) {
        this.idubigeo1 = idubigeo1;
    }

    public String getIdubigeo1() {
        return this.idubigeo1;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return this.distrito;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
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

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRazon_social() {
        return this.razon_social;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getE_mail() {
        return this.e_mail;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return this.fax;
    }

    public void setTelefono_1(String telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public String getTelefono_1() {
        return this.telefono_1;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getTelefono_2() {
        return this.telefono_2;
    }

    public void setTelefono_3(String telefono_3) {
        this.telefono_3 = telefono_3;
    }

    public String getTelefono_3() {
        return this.telefono_3;
    }

    public void setNombre_giro(String nombre_giro) {
        this.nombre_giro = nombre_giro;
    }

    public String getNombre_giro() {
        return this.nombre_giro;
    }

    public void setIddocidentidad(String iddocidentidad) {
        this.iddocidentidad = iddocidentidad;
    }

    public String getIddocidentidad() {
        return this.iddocidentidad;
    }

    public void setNrodocidentidad(String nrodocidentidad) {
        this.nrodocidentidad = nrodocidentidad;
    }

    public String getNrodocidentidad() {
        return this.nrodocidentidad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return this.dni;
    }

    public void setNextel(String nextel) {
        this.nextel = nextel;
    }

    public String getNextel() {
        return this.nextel;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setRegimen_agrario(Double regimen_agrario) {
        this.regimen_agrario = regimen_agrario;
    }

    public Double getRegimen_agrario() {
        return this.regimen_agrario;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc_anterior(String ruc_anterior) {
        this.ruc_anterior = ruc_anterior;
    }

    public String getRuc_anterior() {
        return this.ruc_anterior;
    }

    public void setIntxclient(Double intxclient) {
        this.intxclient = intxclient;
    }

    public Double getIntxclient() {
        return this.intxclient;
    }

    public void setDias_gracia(Double dias_gracia) {
        this.dias_gracia = dias_gracia;
    }

    public Double getDias_gracia() {
        return this.dias_gracia;
    }

    public void setIdvendedor(String idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getIdvendedor() {
        return this.idvendedor;
    }

    public void setIdpersonal(String idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getIdpersonal() {
        return this.idpersonal;
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

    public void setCtacte(String ctacte) {
        this.ctacte = ctacte;
    }

    public String getCtacte() {
        return this.ctacte;
    }

    public void setExtranjero(Double extranjero) {
        this.extranjero = extranjero;
    }

    public Double getExtranjero() {
        return this.extranjero;
    }

    public void setPrecio_aplicado(String precio_aplicado) {
        this.precio_aplicado = precio_aplicado;
    }

    public String getPrecio_aplicado() {
        return this.precio_aplicado;
    }

    public void setLibreoccliente(Double libreoccliente) {
        this.libreoccliente = libreoccliente;
    }

    public Double getLibreoccliente() {
        return this.libreoccliente;
    }

    public void setRegmtc(String regmtc) {
        this.regmtc = regmtc;
    }

    public String getRegmtc() {
        return this.regmtc;
    }

    public void setSubcontratado(Double subcontratado) {
        this.subcontratado = subcontratado;
    }

    public Double getSubcontratado() {
        return this.subcontratado;
    }

    public void setIdtiposocio(String idtiposocio) {
        this.idtiposocio = idtiposocio;
    }

    public String getIdtiposocio() {
        return this.idtiposocio;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setIdprofesion(String idprofesion) {
        this.idprofesion = idprofesion;
    }

    public String getIdprofesion() {
        return this.idprofesion;
    }

    public void setCentrotrabajo(String centrotrabajo) {
        this.centrotrabajo = centrotrabajo;
    }

    public String getCentrotrabajo() {
        return this.centrotrabajo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setIdestadocivil(String idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public String getIdestadocivil() {
        return this.idestadocivil;
    }

    public void setIdvia2(String idvia2) {
        this.idvia2 = idvia2;
    }

    public String getIdvia2() {
        return this.idvia2;
    }

    public void setVia2_descripcion(String via2_descripcion) {
        this.via2_descripcion = via2_descripcion;
    }

    public String getVia2_descripcion() {
        return this.via2_descripcion;
    }

    public void setDireccob_numero(Double direccob_numero) {
        this.direccob_numero = direccob_numero;
    }

    public Double getDireccob_numero() {
        return this.direccob_numero;
    }

    public void setDireccob_interior(String direccob_interior) {
        this.direccob_interior = direccob_interior;
    }

    public String getDireccob_interior() {
        return this.direccob_interior;
    }

    public void setDireccob_referencia(String direccob_referencia) {
        this.direccob_referencia = direccob_referencia;
    }

    public String getDireccob_referencia() {
        return this.direccob_referencia;
    }

    public void setIdzona2(String idzona2) {
        this.idzona2 = idzona2;
    }

    public String getIdzona2() {
        return this.idzona2;
    }

    public void setZona2_descripcion(String zona2_descripcion) {
        this.zona2_descripcion = zona2_descripcion;
    }

    public String getZona2_descripcion() {
        return this.zona2_descripcion;
    }

    public void setIdubigeo2(String idubigeo2) {
        this.idubigeo2 = idubigeo2;
    }

    public String getIdubigeo2() {
        return this.idubigeo2;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_ingreso() {
        return this.fecha_ingreso;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getCredito() {
        return this.credito;
    }

    public void setNrocertif(String nrocertif) {
        this.nrocertif = nrocertif;
    }

    public String getNrocertif() {
        return this.nrocertif;
    }

    public void setTipocertif(String tipocertif) {
        this.tipocertif = tipocertif;
    }

    public String getTipocertif() {
        return this.tipocertif;
    }

    public void setNrolibro(String nrolibro) {
        this.nrolibro = nrolibro;
    }

    public String getNrolibro() {
        return this.nrolibro;
    }

    public void setIdcobrador(String idcobrador) {
        this.idcobrador = idcobrador;
    }

    public String getIdcobrador() {
        return this.idcobrador;
    }

    public void setIdsociocorp(String idsociocorp) {
        this.idsociocorp = idsociocorp;
    }

    public String getIdsociocorp() {
        return this.idsociocorp;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return this.universidad;
    }

    public void setIdubigeo3_ln(String idubigeo3_ln) {
        this.idubigeo3_ln = idubigeo3_ln;
    }

    public String getIdubigeo3_ln() {
        return this.idubigeo3_ln;
    }

    public void setFecha_email(Date fecha_email) {
        this.fecha_email = fecha_email;
    }

    public Date getFecha_email() {
        return this.fecha_email;
    }

    public void setIdbarra(String idbarra) {
        this.idbarra = idbarra;
    }

    public String getIdbarra() {
        return this.idbarra;
    }

    public void setIdbanco(String idbanco) {
        this.idbanco = idbanco;
    }

    public String getIdbanco() {
        return this.idbanco;
    }

    public void setTipo_cuentabanco(String tipo_cuentabanco) {
        this.tipo_cuentabanco = tipo_cuentabanco;
    }

    public String getTipo_cuentabanco() {
        return this.tipo_cuentabanco;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getIdmoneda() {
        return this.idmoneda;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setCrednormal(Double crednormal) {
        this.crednormal = crednormal;
    }

    public Double getCrednormal() {
        return this.crednormal;
    }

    public void setCredtemporal(Double credtemporal) {
        this.credtemporal = credtemporal;
    }

    public Double getCredtemporal() {
        return this.credtemporal;
    }

    public void setCredtotal(Double credtotal) {
        this.credtotal = credtotal;
    }

    public Double getCredtotal() {
        return this.credtotal;
    }

    public void setIddescuento(String iddescuento) {
        this.iddescuento = iddescuento;
    }

    public String getIddescuento() {
        return this.iddescuento;
    }

    public void setIdgrupoclieprov(String idgrupoclieprov) {
        this.idgrupoclieprov = idgrupoclieprov;
    }

    public String getIdgrupoclieprov() {
        return this.idgrupoclieprov;
    }

    public void setIdbanco_pred(String idbanco_pred) {
        this.idbanco_pred = idbanco_pred;
    }

    public String getIdbanco_pred() {
        return this.idbanco_pred;
    }

    public void setIdctacte_pred(String idctacte_pred) {
        this.idctacte_pred = idctacte_pred;
    }

    public String getIdctacte_pred() {
        return this.idctacte_pred;
    }

    public void setIdbanco_prov(String idbanco_prov) {
        this.idbanco_prov = idbanco_prov;
    }

    public String getIdbanco_prov() {
        return this.idbanco_prov;
    }

    public void setCtacte2(String ctacte2) {
        this.ctacte2 = ctacte2;
    }

    public String getCtacte2() {
        return this.ctacte2;
    }

    public void setCtacte3(String ctacte3) {
        this.ctacte3 = ctacte3;
    }

    public String getCtacte3() {
        return this.ctacte3;
    }

    public void setCtacte4(String ctacte4) {
        this.ctacte4 = ctacte4;
    }

    public String getCtacte4() {
        return this.ctacte4;
    }

    public void setIdbanco_prov2(String idbanco_prov2) {
        this.idbanco_prov2 = idbanco_prov2;
    }

    public String getIdbanco_prov2() {
        return this.idbanco_prov2;
    }

    public void setIdbanco_prov3(String idbanco_prov3) {
        this.idbanco_prov3 = idbanco_prov3;
    }

    public String getIdbanco_prov3() {
        return this.idbanco_prov3;
    }

    public void setIdbanco_prov4(String idbanco_prov4) {
        this.idbanco_prov4 = idbanco_prov4;
    }

    public String getIdbanco_prov4() {
        return this.idbanco_prov4;
    }

    public void setEstado_cta(Double estado_cta) {
        this.estado_cta = estado_cta;
    }

    public Double getEstado_cta() {
        return this.estado_cta;
    }

    public void setEstado_cta2(Double estado_cta2) {
        this.estado_cta2 = estado_cta2;
    }

    public Double getEstado_cta2() {
        return this.estado_cta2;
    }

    public void setEstado_cta3(Double estado_cta3) {
        this.estado_cta3 = estado_cta3;
    }

    public Double getEstado_cta3() {
        return this.estado_cta3;
    }

    public void setEstado_cta4(Double estado_cta4) {
        this.estado_cta4 = estado_cta4;
    }

    public Double getEstado_cta4() {
        return this.estado_cta4;
    }

    public void setIdmoneda2(String idmoneda2) {
        this.idmoneda2 = idmoneda2;
    }

    public String getIdmoneda2() {
        return this.idmoneda2;
    }

    public void setIdmoneda3(String idmoneda3) {
        this.idmoneda3 = idmoneda3;
    }

    public String getIdmoneda3() {
        return this.idmoneda3;
    }

    public void setIdmoneda4(String idmoneda4) {
        this.idmoneda4 = idmoneda4;
    }

    public String getIdmoneda4() {
        return this.idmoneda4;
    }

    public void setGirar_cheque(String girar_cheque) {
        this.girar_cheque = girar_cheque;
    }

    public String getGirar_cheque() {
        return this.girar_cheque;
    }

    public void setNombre_esposa(String nombre_esposa) {
        this.nombre_esposa = nombre_esposa;
    }

    public String getNombre_esposa() {
        return this.nombre_esposa;
    }

    public void setDni_esposa(String dni_esposa) {
        this.dni_esposa = dni_esposa;
    }

    public String getDni_esposa() {
        return this.dni_esposa;
    }

    public void setIdsector(String idsector) {
        this.idsector = idsector;
    }

    public String getIdsector() {
        return this.idsector;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNombre_comercial() {
        return this.nombre_comercial;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }

    public String getCiiu() {
        return this.ciiu;
    }

    public void setIdnacionalidad(String idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public String getIdnacionalidad() {
        return this.idnacionalidad;
    }

    public void setInfoadreporte_pie(String infoadreporte_pie) {
        this.infoadreporte_pie = infoadreporte_pie;
    }

    public String getInfoadreporte_pie() {
        return this.infoadreporte_pie;
    }

    public void setEs_transportista(Double es_transportista) {
        this.es_transportista = es_transportista;
    }

    public Double getEs_transportista() {
        return this.es_transportista;
    }

    public void setIdconvenio(String idconvenio) {
        this.idconvenio = idconvenio;
    }

    public String getIdconvenio() {
        return this.idconvenio;
    }

    public void setIdreferido(String idreferido) {
        this.idreferido = idreferido;
    }

    public String getIdreferido() {
        return this.idreferido;
    }

    public void setIdniveleducativo(String idniveleducativo) {
        this.idniveleducativo = idniveleducativo;
    }

    public String getIdniveleducativo() {
        return this.idniveleducativo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getIdcargo() {
        return this.idcargo;
    }

    public void setEs_socionegocio(Double es_socionegocio) {
        this.es_socionegocio = es_socionegocio;
    }

    public Double getEs_socionegocio() {
        return this.es_socionegocio;
    }

    public void setEs_operadoraereo(Double es_operadoraereo) {
        this.es_operadoraereo = es_operadoraereo;
    }

    public Double getEs_operadoraereo() {
        return this.es_operadoraereo;
    }

    public void setIdcontacto(String idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getIdcontacto() {
        return this.idcontacto;
    }

    public void setIdcanal(String idcanal) {
        this.idcanal = idcanal;
    }

    public String getIdcanal() {
        return this.idcanal;
    }

    public void setIdfpago(String idfpago) {
        this.idfpago = idfpago;
    }

    public String getIdfpago() {
        return this.idfpago;
    }

    public void setSeriedocventa(String seriedocventa) {
        this.seriedocventa = seriedocventa;
    }

    public String getSeriedocventa() {
        return this.seriedocventa;
    }

    public void setEs_agenteretenedor(Double es_agenteretenedor) {
        this.es_agenteretenedor = es_agenteretenedor;
    }

    public Double getEs_agenteretenedor() {
        return this.es_agenteretenedor;
    }

    public void setIdpaisemisor(String idpaisemisor) {
        this.idpaisemisor = idpaisemisor;
    }

    public String getIdpaisemisor() {
        return this.idpaisemisor;
    }

    public void setEstado_sunat(String estado_sunat) {
        this.estado_sunat = estado_sunat;
    }

    public String getEstado_sunat() {
        return this.estado_sunat;
    }

    public void setDestacapersonal_cliente(Double destacapersonal_cliente) {
        this.destacapersonal_cliente = destacapersonal_cliente;
    }

    public Double getDestacapersonal_cliente() {
        return this.destacapersonal_cliente;
    }

    public void setDestacapersonal_proveedor(Double destacapersonal_proveedor) {
        this.destacapersonal_proveedor = destacapersonal_proveedor;
    }

    public Double getDestacapersonal_proveedor() {
        return this.destacapersonal_proveedor;
    }

    public void setIdtipoactividad(String idtipoactividad) {
        this.idtipoactividad = idtipoactividad;
    }

    public String getIdtipoactividad() {
        return this.idtipoactividad;
    }

    public void setDomiciliado(Double domiciliado) {
        this.domiciliado = domiciliado;
    }

    public Double getDomiciliado() {
        return this.domiciliado;
    }

    public void setRep_legal(String rep_legal) {
        this.rep_legal = rep_legal;
    }

    public String getRep_legal() {
        return this.rep_legal;
    }

    public void setIdprocedencia(String idprocedencia) {
        this.idprocedencia = idprocedencia;
    }

    public String getIdprocedencia() {
        return this.idprocedencia;
    }

    public void setEs_naviera(Double es_naviera) {
        this.es_naviera = es_naviera;
    }

    public Double getEs_naviera() {
        return this.es_naviera;
    }

    public void setEs_agenteaduana(Double es_agenteaduana) {
        this.es_agenteaduana = es_agenteaduana;
    }

    public Double getEs_agenteaduana() {
        return this.es_agenteaduana;
    }

    public void setPorcentajecomision(Double porcentajecomision) {
        this.porcentajecomision = porcentajecomision;
    }

    public Double getPorcentajecomision() {
        return this.porcentajecomision;
    }

    public void setComisionminima(Double comisionminima) {
        this.comisionminima = comisionminima;
    }

    public Double getComisionminima() {
        return this.comisionminima;
    }

    public void setMontocomisionminima(Double montocomisionminima) {
        this.montocomisionminima = montocomisionminima;
    }

    public Double getMontocomisionminima() {
        return this.montocomisionminima;
    }

    public void setCondicion_sunat(String condicion_sunat) {
        this.condicion_sunat = condicion_sunat;
    }

    public String getCondicion_sunat() {
        return this.condicion_sunat;
    }

    public void setIdregimenaseg_salud(String idregimenaseg_salud) {
        this.idregimenaseg_salud = idregimenaseg_salud;
    }

    public String getIdregimenaseg_salud() {
        return this.idregimenaseg_salud;
    }

    public void setEs_agricultor(Double es_agricultor) {
        this.es_agricultor = es_agricultor;
    }

    public Double getEs_agricultor() {
        return this.es_agricultor;
    }

    public void setMontomin_garanvscont(Double montomin_garanvscont) {
        this.montomin_garanvscont = montomin_garanvscont;
    }

    public Double getMontomin_garanvscont() {
        return this.montomin_garanvscont;
    }

    public void setEs_aseguradora(Double es_aseguradora) {
        this.es_aseguradora = es_aseguradora;
    }

    public Double getEs_aseguradora() {
        return this.es_aseguradora;
    }

    public void setAseguradora_web(String aseguradora_web) {
        this.aseguradora_web = aseguradora_web;
    }

    public String getAseguradora_web() {
        return this.aseguradora_web;
    }

    public void setImportado_externo(Double importado_externo) {
        this.importado_externo = importado_externo;
    }

    public Double getImportado_externo() {
        return this.importado_externo;
    }

    public void setActividad_economica(String actividad_economica) {
        this.actividad_economica = actividad_economica;
    }

    public String getActividad_economica() {
        return this.actividad_economica;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getConyugue() {
        return this.conyugue;
    }

    public void setDependiente(Double dependiente) {
        this.dependiente = dependiente;
    }

    public Double getDependiente() {
        return this.dependiente;
    }

    public void setDirconyugue(String dirconyugue) {
        this.dirconyugue = dirconyugue;
    }

    public String getDirconyugue() {
        return this.dirconyugue;
    }

    public void setDircorrespondencia(String dircorrespondencia) {
        this.dircorrespondencia = dircorrespondencia;
    }

    public String getDircorrespondencia() {
        return this.dircorrespondencia;
    }

    public void setDni_adicional(String dni_adicional) {
        this.dni_adicional = dni_adicional;
    }

    public String getDni_adicional() {
        return this.dni_adicional;
    }

    public void setEmpleador(String empleador) {
        this.empleador = empleador;
    }

    public String getEmpleador() {
        return this.empleador;
    }

    public void setE_mail2(String e_mail2) {
        this.e_mail2 = e_mail2;
    }

    public String getE_mail2() {
        return this.e_mail2;
    }

    public void setFnconyugue(Date fnconyugue) {
        this.fnconyugue = fnconyugue;
    }

    public Date getFnconyugue() {
        return this.fnconyugue;
    }

    public void setRef_adicional(String ref_adicional) {
        this.ref_adicional = ref_adicional;
    }

    public String getRef_adicional() {
        return this.ref_adicional;
    }

    public void setCny_email1(String cny_email1) {
        this.cny_email1 = cny_email1;
    }

    public String getCny_email1() {
        return this.cny_email1;
    }

    public void setCny_email2(String cny_email2) {
        this.cny_email2 = cny_email2;
    }

    public String getCny_email2() {
        return this.cny_email2;
    }

    public void setCny_fax(String cny_fax) {
        this.cny_fax = cny_fax;
    }

    public String getCny_fax() {
        return this.cny_fax;
    }

    public void setCny_fono1(String cny_fono1) {
        this.cny_fono1 = cny_fono1;
    }

    public String getCny_fono1() {
        return this.cny_fono1;
    }

    public void setCny_fono2(String cny_fono2) {
        this.cny_fono2 = cny_fono2;
    }

    public String getCny_fono2() {
        return this.cny_fono2;
    }

    public void setDirec1(String direc1) {
        this.direc1 = direc1;
    }

    public String getDirec1() {
        return this.direc1;
    }

    public void setDirec2(String direc2) {
        this.direc2 = direc2;
    }

    public String getDirec2() {
        return this.direc2;
    }

    public void setDirec3(String direc3) {
        this.direc3 = direc3;
    }

    public String getDirec3() {
        return this.direc3;
    }

    public void setDirec4(String direc4) {
        this.direc4 = direc4;
    }

    public String getDirec4() {
        return this.direc4;
    }

    public void setDirec5(String direc5) {
        this.direc5 = direc5;
    }

    public String getDirec5() {
        return this.direc5;
    }

    public void setFnh1(String fnh1) {
        this.fnh1 = fnh1;
    }

    public String getFnh1() {
        return this.fnh1;
    }

    public void setFnh2(String fnh2) {
        this.fnh2 = fnh2;
    }

    public String getFnh2() {
        return this.fnh2;
    }

    public void setFnh3(String fnh3) {
        this.fnh3 = fnh3;
    }

    public String getFnh3() {
        return this.fnh3;
    }

    public void setFnh4(String fnh4) {
        this.fnh4 = fnh4;
    }

    public String getFnh4() {
        return this.fnh4;
    }

    public void setFnh5(String fnh5) {
        this.fnh5 = fnh5;
    }

    public String getFnh5() {
        return this.fnh5;
    }

    public void setFnh6(String fnh6) {
        this.fnh6 = fnh6;
    }

    public String getFnh6() {
        return this.fnh6;
    }

    public void setFnh7(String fnh7) {
        this.fnh7 = fnh7;
    }

    public String getFnh7() {
        return this.fnh7;
    }

    public void setFnh8(String fnh8) {
        this.fnh8 = fnh8;
    }

    public String getFnh8() {
        return this.fnh8;
    }

    public void setHijo1(String hijo1) {
        this.hijo1 = hijo1;
    }

    public String getHijo1() {
        return this.hijo1;
    }

    public void setHijo2(String hijo2) {
        this.hijo2 = hijo2;
    }

    public String getHijo2() {
        return this.hijo2;
    }

    public void setHijo3(String hijo3) {
        this.hijo3 = hijo3;
    }

    public String getHijo3() {
        return this.hijo3;
    }

    public void setHijo4(String hijo4) {
        this.hijo4 = hijo4;
    }

    public String getHijo4() {
        return this.hijo4;
    }

    public void setHijo5(String hijo5) {
        this.hijo5 = hijo5;
    }

    public String getHijo5() {
        return this.hijo5;
    }

    public void setHijo6(String hijo6) {
        this.hijo6 = hijo6;
    }

    public String getHijo6() {
        return this.hijo6;
    }

    public void setHijo7(String hijo7) {
        this.hijo7 = hijo7;
    }

    public String getHijo7() {
        return this.hijo7;
    }

    public void setHijo8(String hijo8) {
        this.hijo8 = hijo8;
    }

    public String getHijo8() {
        return this.hijo8;
    }

    public void setIngreso_mensual(Double ingreso_mensual) {
        this.ingreso_mensual = ingreso_mensual;
    }

    public Double getIngreso_mensual() {
        return this.ingreso_mensual;
    }

    public void setIdmonedalc(String idmonedalc) {
        this.idmonedalc = idmonedalc;
    }

    public String getIdmonedalc() {
        return this.idmonedalc;
    }

    public void setEstadolc(Double estadolc) {
        this.estadolc = estadolc;
    }

    public Double getEstadolc() {
        return this.estadolc;
    }

    public void setEs_retenedor(Double es_retenedor) {
        this.es_retenedor = es_retenedor;
    }

    public Double getEs_retenedor() {
        return this.es_retenedor;
    }

    public void setEs_percepcion(Double es_percepcion) {
        this.es_percepcion = es_percepcion;
    }

    public Double getEs_percepcion() {
        return this.es_percepcion;
    }

    public void setEs_buencontribuyente(Double es_buencontribuyente) {
        this.es_buencontribuyente = es_buencontribuyente;
    }

    public Double getEs_buencontribuyente() {
        return this.es_buencontribuyente;
    }

    public void setIdafp(String idafp) {
        this.idafp = idafp;
    }

    public String getIdafp() {
        return this.idafp;
    }

    public void setInicio_afp(Date inicio_afp) {
        this.inicio_afp = inicio_afp;
    }

    public Date getInicio_afp() {
        return this.inicio_afp;
    }

    public void setInicio_onp(Date inicio_onp) {
        this.inicio_onp = inicio_onp;
    }

    public Date getInicio_onp() {
        return this.inicio_onp;
    }

    public void setAutogeneradoafp(String autogeneradoafp) {
        this.autogeneradoafp = autogeneradoafp;
    }

    public String getAutogeneradoafp() {
        return this.autogeneradoafp;
    }

    public void setIdtipoprecio(String idtipoprecio) {
        this.idtipoprecio = idtipoprecio;
    }

    public String getIdtipoprecio() {
        return this.idtipoprecio;
    }

    public void setIdcondventa(String idcondventa) {
        this.idcondventa = idcondventa;
    }

    public String getIdcondventa() {
        return this.idcondventa;
    }

    public void setIdflete(String idflete) {
        this.idflete = idflete;
    }

    public String getIdflete() {
        return this.idflete;
    }

    public void setFacturable(Double facturable) {
        this.facturable = facturable;
    }

    public Double getFacturable() {
        return this.facturable;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setIngresopromedio(Double ingresopromedio) {
        this.ingresopromedio = ingresopromedio;
    }

    public Double getIngresopromedio() {
        return this.ingresopromedio;
    }

    public void setCentrotrabajo_conyuge(String centrotrabajo_conyuge) {
        this.centrotrabajo_conyuge = centrotrabajo_conyuge;
    }

    public String getCentrotrabajo_conyuge() {
        return this.centrotrabajo_conyuge;
    }

    public void setIngresopromedio_conyuge(Double ingresopromedio_conyuge) {
        this.ingresopromedio_conyuge = ingresopromedio_conyuge;
    }

    public Double getIngresopromedio_conyuge() {
        return this.ingresopromedio_conyuge;
    }

    public void setIngresopromedio_anual(Double ingresopromedio_anual) {
        this.ingresopromedio_anual = ingresopromedio_anual;
    }

    public Double getIngresopromedio_anual() {
        return this.ingresopromedio_anual;
    }

    public void setIdmonedaingresopromedio(String idmonedaingresopromedio) {
        this.idmonedaingresopromedio = idmonedaingresopromedio;
    }

    public String getIdmonedaingresopromedio() {
        return this.idmonedaingresopromedio;
    }

    public void setIdcondicionlaboral(String idcondicionlaboral) {
        this.idcondicionlaboral = idcondicionlaboral;
    }

    public String getIdcondicionlaboral() {
        return this.idcondicionlaboral;
    }

    public void setIdcategorialaboral(String idcategorialaboral) {
        this.idcategorialaboral = idcategorialaboral;
    }

    public String getIdcategorialaboral() {
        return this.idcategorialaboral;
    }

    public void setCentrotrabajo_ruc(String centrotrabajo_ruc) {
        this.centrotrabajo_ruc = centrotrabajo_ruc;
    }

    public String getCentrotrabajo_ruc() {
        return this.centrotrabajo_ruc;
    }

    public void setContratoindeterminado(String contratoindeterminado) {
        this.contratoindeterminado = contratoindeterminado;
    }

    public String getContratoindeterminado() {
        return this.contratoindeterminado;
    }

    public void setCondicionindependiente_ruc(String condicionindependiente_ruc) {
        this.condicionindependiente_ruc = condicionindependiente_ruc;
    }

    public String getCondicionindependiente_ruc() {
        return this.condicionindependiente_ruc;
    }

    public void setFecha_ingreso_inicioact(Date fecha_ingreso_inicioact) {
        this.fecha_ingreso_inicioact = fecha_ingreso_inicioact;
    }

    public Date getFecha_ingreso_inicioact() {
        return this.fecha_ingreso_inicioact;
    }

    public void setSeparacionbienes(String separacionbienes) {
        this.separacionbienes = separacionbienes;
    }

    public String getSeparacionbienes() {
        return this.separacionbienes;
    }

    public void setNumerohijos(Double numerohijos) {
        this.numerohijos = numerohijos;
    }

    public Double getNumerohijos() {
        return this.numerohijos;
    }

    public void setNrotrabajadores(Double nrotrabajadores) {
        this.nrotrabajadores = nrotrabajadores;
    }

    public Double getNrotrabajadores() {
        return this.nrotrabajadores;
    }

    public void setIdtipoclieprov(String idtipoclieprov) {
        this.idtipoclieprov = idtipoclieprov;
    }

    public String getIdtipoclieprov() {
        return this.idtipoclieprov;
    }

    public void setEs_proveedor_tercero(Double es_proveedor_tercero) {
        this.es_proveedor_tercero = es_proveedor_tercero;
    }

    public Double getEs_proveedor_tercero() {
        return this.es_proveedor_tercero;
    }

    public void setEs_registroxweb(Double es_registroxweb) {
        this.es_registroxweb = es_registroxweb;
    }

    public Double getEs_registroxweb() {
        return this.es_registroxweb;
    }

    public void setClave_cita(String clave_cita) {
        this.clave_cita = clave_cita;
    }

    public String getClave_cita() {
        return this.clave_cita;
    }

    public void setConrus(String conrus) {
        this.conrus = conrus;
    }

    public String getConrus() {
        return this.conrus;
    }

    public void setIdclasificacion_bs_sunat(String idclasificacion_bs_sunat) {
        this.idclasificacion_bs_sunat = idclasificacion_bs_sunat;
    }

    public String getIdclasificacion_bs_sunat() {
        return this.idclasificacion_bs_sunat;
    }

    public void setIdvinculo_cr_sunat(String idvinculo_cr_sunat) {
        this.idvinculo_cr_sunat = idvinculo_cr_sunat;
    }

    public String getIdvinculo_cr_sunat() {
        return this.idvinculo_cr_sunat;
    }

    public void setIdexoneracion_sunat(String idexoneracion_sunat) {
        this.idexoneracion_sunat = idexoneracion_sunat;
    }

    public String getIdexoneracion_sunat() {
        return this.idexoneracion_sunat;
    }

    public void setIdtiporenta_sunat(String idtiporenta_sunat) {
        this.idtiporenta_sunat = idtiporenta_sunat;
    }

    public String getIdtiporenta_sunat() {
        return this.idtiporenta_sunat;
    }

    public void setIdmodalidad_sunat(String idmodalidad_sunat) {
        this.idmodalidad_sunat = idmodalidad_sunat;
    }

    public String getIdmodalidad_sunat() {
        return this.idmodalidad_sunat;
    }

    public void setEs_importado(Double es_importado) {
        this.es_importado = es_importado;
    }

    public Double getEs_importado() {
        return this.es_importado;
    }

    public void setCodequivalente(String codequivalente) {
        this.codequivalente = codequivalente;
    }

    public String getCodequivalente() {
        return this.codequivalente;
    }

    public void setCodigo_alt(String codigo_alt) {
        this.codigo_alt = codigo_alt;
    }

    public String getCodigo_alt() {
        return this.codigo_alt;
    }
    public boolean isSeleccion() {
        return seleccion;
    }
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    @Override
    public String toString() {
        return nombres+" "+apellidopaterno+" "+apellidomaterno;
    }
	/* Sets & Gets FK*/

}
