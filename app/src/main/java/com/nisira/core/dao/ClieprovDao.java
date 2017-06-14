package com.nisira.core.dao;

import com.nisira.core.entity.*;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.nisira.core.database.DataBaseClass;
import android.content.ContentValues;
import android.database.Cursor;
import com.nisira.core.util.ClaveMovil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClieprovDao extends BaseDao<Clieprov> {
	public ClieprovDao() {
		super(Clieprov.class);
	}
	public ClieprovDao(boolean usaCnBase) throws Exception {
		super(Clieprov.class, usaCnBase);
	}
	public void mezclarLocal(Clieprov obj)throws Exception{
		if(obj !=null){
			List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCLIEPROV))=?",obj.getIdempresa().trim(),obj.getIdclieprov().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
//			update(obj,"IDEMPRESA='"+obj.getIdempresa()+"' AND IDCLIEPROV='"+obj.getIdclieprov()+"'");
		}
	}
	public Clieprov getClientexempresa_codigo(String idempresa , String idclieprov) throws Exception {
		List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCLIEPROV))=?",idempresa.trim(),idclieprov.trim());
		if(!lst.isEmpty()){
			return lst.get(0);
		}
		return null;
	}

	public List<Clieprov> getPersonalxTipo(String idempresa, String tipo)throws Exception{
		if(idempresa !=null){
			List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.TIPO_CLIEPROV))=?",idempresa.trim(),tipo.trim());
			if(!lst.isEmpty())
				return lst;
		}
		return null;
	}
	public List<Clieprov> getPersonal_Operario(String idempresa)throws Exception{
		if(idempresa !=null){
			List<Clieprov> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND t0.IDGRUPOCLIEPROV IN ('SU', 'OP')",idempresa.trim());
			if(!lst.isEmpty())
				return lst;
		}
		return null;
	}

	public Boolean insert(Clieprov clieprov) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",clieprov.getIdempresa()); 
			initialValues.put("IDCLIEPROV",clieprov.getIdclieprov()); 
			initialValues.put("TIPO_CLIEPROV",clieprov.getTipo_clieprov()); 
			initialValues.put("TIPOPERSONA",clieprov.getTipopersona()); 
			initialValues.put("IDTIPOCLIENTE",clieprov.getIdtipocliente()); 
			initialValues.put("CON_RETENCION",clieprov.getCon_retencion()); 
			initialValues.put("SIN_RETENCION",clieprov.getSin_retencion()); 
			initialValues.put("CONTACTO",clieprov.getContacto()); 
			initialValues.put("DIRECCION",clieprov.getDireccion()); 
			initialValues.put("IDVIA1",clieprov.getIdvia1()); 
			initialValues.put("VIA1_DESCRIPCION",clieprov.getVia1_descripcion()); 
			initialValues.put("DIRECCION_NUMERO",clieprov.getDireccion_numero()); 
			initialValues.put("DIRECCION_INTERIOR",clieprov.getDireccion_interior()); 
			initialValues.put("DIRECCION_REFERENCIA",clieprov.getDireccion_referencia()); 
			initialValues.put("IDZONA1",clieprov.getIdzona1()); 
			initialValues.put("ZONA1_DESCRIPCION",clieprov.getZona1_descripcion()); 
			initialValues.put("IDUBIGEO1",clieprov.getIdubigeo1()); 
			initialValues.put("DISTRITO",clieprov.getDistrito()); 
			initialValues.put("DEPARTAMENTO",clieprov.getDepartamento()); 
			initialValues.put("APELLIDOPATERNO",clieprov.getApellidopaterno()); 
			initialValues.put("APELLIDOMATERNO",clieprov.getApellidomaterno()); 
			initialValues.put("NOMBRES",clieprov.getNombres()); 
			initialValues.put("RAZON_SOCIAL",clieprov.getRazon_social()); 
			initialValues.put("E_MAIL",clieprov.getE_mail()); 
			initialValues.put("FAX",clieprov.getFax()); 
			initialValues.put("TELEFONO_1",clieprov.getTelefono_1()); 
			initialValues.put("TELEFONO_2",clieprov.getTelefono_2()); 
			initialValues.put("TELEFONO_3",clieprov.getTelefono_3()); 
			initialValues.put("NOMBRE_GIRO",clieprov.getNombre_giro()); 
			initialValues.put("IDDOCIDENTIDAD",clieprov.getIddocidentidad()); 
			initialValues.put("NRODOCIDENTIDAD",clieprov.getNrodocidentidad()); 
			initialValues.put("DNI",clieprov.getDni()); 
			initialValues.put("NEXTEL",clieprov.getNextel()); 
			initialValues.put("PROVINCIA",clieprov.getProvincia()); 
			initialValues.put("REGIMEN_AGRARIO",clieprov.getRegimen_agrario()); 
			initialValues.put("RUC",clieprov.getRuc()); 
			initialValues.put("RUC_ANTERIOR",clieprov.getRuc_anterior()); 
			initialValues.put("INTXCLIENT",clieprov.getIntxclient()); 
			initialValues.put("DIAS_GRACIA",clieprov.getDias_gracia()); 
			initialValues.put("IDVENDEDOR",clieprov.getIdvendedor()); 
			initialValues.put("IDPERSONAL",clieprov.getIdpersonal()); 
			initialValues.put("ESTADO",clieprov.getEstado()); 
			initialValues.put("SINCRONIZA",clieprov.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(clieprov.getFechacreacion() ) ); 
			initialValues.put("CTACTE",clieprov.getCtacte()); 
			initialValues.put("EXTRANJERO",clieprov.getExtranjero()); 
			initialValues.put("PRECIO_APLICADO",clieprov.getPrecio_aplicado()); 
			initialValues.put("LIBREOCCLIENTE",clieprov.getLibreoccliente()); 
			initialValues.put("REGMTC",clieprov.getRegmtc()); 
			initialValues.put("SUBCONTRATADO",clieprov.getSubcontratado()); 
			initialValues.put("IDTIPOSOCIO",clieprov.getIdtiposocio()); 
			initialValues.put("FECHA_NACIMIENTO",dateFormat.format(clieprov.getFecha_nacimiento() ) ); 
			initialValues.put("IDPROFESION",clieprov.getIdprofesion()); 
			initialValues.put("CENTROTRABAJO",clieprov.getCentrotrabajo()); 
			initialValues.put("SEXO",clieprov.getSexo()); 
			initialValues.put("IDESTADOCIVIL",clieprov.getIdestadocivil()); 
			initialValues.put("IDVIA2",clieprov.getIdvia2()); 
			initialValues.put("VIA2_DESCRIPCION",clieprov.getVia2_descripcion()); 
			initialValues.put("DIRECCOB_NUMERO",clieprov.getDireccob_numero()); 
			initialValues.put("DIRECCOB_INTERIOR",clieprov.getDireccob_interior()); 
			initialValues.put("DIRECCOB_REFERENCIA",clieprov.getDireccob_referencia()); 
			initialValues.put("IDZONA2",clieprov.getIdzona2()); 
			initialValues.put("ZONA2_DESCRIPCION",clieprov.getZona2_descripcion()); 
			initialValues.put("IDUBIGEO2",clieprov.getIdubigeo2()); 
			initialValues.put("FECHA_INGRESO",dateFormat.format(clieprov.getFecha_ingreso() ) ); 
			initialValues.put("CREDITO",clieprov.getCredito()); 
			initialValues.put("NROCERTIF",clieprov.getNrocertif()); 
			initialValues.put("TIPOCERTIF",clieprov.getTipocertif()); 
			initialValues.put("NROLIBRO",clieprov.getNrolibro()); 
			initialValues.put("IDCOBRADOR",clieprov.getIdcobrador()); 
			initialValues.put("IDSOCIOCORP",clieprov.getIdsociocorp()); 
			initialValues.put("UNIVERSIDAD",clieprov.getUniversidad()); 
			initialValues.put("IDUBIGEO3_LN",clieprov.getIdubigeo3_ln()); 
			initialValues.put("FECHA_EMAIL",dateFormat.format(clieprov.getFecha_email() ) ); 
			initialValues.put("IDBARRA",clieprov.getIdbarra()); 
			initialValues.put("IDBANCO",clieprov.getIdbanco()); 
			initialValues.put("TIPO_CUENTABANCO",clieprov.getTipo_cuentabanco()); 
			initialValues.put("IDMONEDA",clieprov.getIdmoneda()); 
			initialValues.put("FOTO",clieprov.getFoto()); 
			initialValues.put("CREDNORMAL",clieprov.getCrednormal()); 
			initialValues.put("CREDTEMPORAL",clieprov.getCredtemporal()); 
			initialValues.put("CREDTOTAL",clieprov.getCredtotal()); 
			initialValues.put("IDDESCUENTO",clieprov.getIddescuento()); 
			initialValues.put("IDGRUPOCLIEPROV",clieprov.getIdgrupoclieprov()); 
			initialValues.put("IDBANCO_PRED",clieprov.getIdbanco_pred()); 
			initialValues.put("IDCTACTE_PRED",clieprov.getIdctacte_pred()); 
			initialValues.put("IDBANCO_PROV",clieprov.getIdbanco_prov()); 
			initialValues.put("CTACTE2",clieprov.getCtacte2()); 
			initialValues.put("CTACTE3",clieprov.getCtacte3()); 
			initialValues.put("CTACTE4",clieprov.getCtacte4()); 
			initialValues.put("IDBANCO_PROV2",clieprov.getIdbanco_prov2()); 
			initialValues.put("IDBANCO_PROV3",clieprov.getIdbanco_prov3()); 
			initialValues.put("IDBANCO_PROV4",clieprov.getIdbanco_prov4()); 
			initialValues.put("ESTADO_CTA",clieprov.getEstado_cta()); 
			initialValues.put("ESTADO_CTA2",clieprov.getEstado_cta2()); 
			initialValues.put("ESTADO_CTA3",clieprov.getEstado_cta3()); 
			initialValues.put("ESTADO_CTA4",clieprov.getEstado_cta4()); 
			initialValues.put("IDMONEDA2",clieprov.getIdmoneda2()); 
			initialValues.put("IDMONEDA3",clieprov.getIdmoneda3()); 
			initialValues.put("IDMONEDA4",clieprov.getIdmoneda4()); 
			initialValues.put("GIRAR_CHEQUE",clieprov.getGirar_cheque()); 
			initialValues.put("NOMBRE_ESPOSA",clieprov.getNombre_esposa()); 
			initialValues.put("DNI_ESPOSA",clieprov.getDni_esposa()); 
			initialValues.put("IDSECTOR",clieprov.getIdsector()); 
			initialValues.put("NOMBRE_COMERCIAL",clieprov.getNombre_comercial()); 
			initialValues.put("CIIU",clieprov.getCiiu()); 
			initialValues.put("IDNACIONALIDAD",clieprov.getIdnacionalidad()); 
			initialValues.put("INFOADREPORTE_PIE",clieprov.getInfoadreporte_pie()); 
			initialValues.put("ES_TRANSPORTISTA",clieprov.getEs_transportista()); 
			initialValues.put("IDCONVENIO",clieprov.getIdconvenio()); 
			initialValues.put("IDREFERIDO",clieprov.getIdreferido()); 
			initialValues.put("IDNIVELEDUCATIVO",clieprov.getIdniveleducativo()); 
			initialValues.put("IDCARGO",clieprov.getIdcargo()); 
			initialValues.put("ES_SOCIONEGOCIO",clieprov.getEs_socionegocio()); 
			initialValues.put("ES_OPERADORAEREO",clieprov.getEs_operadoraereo()); 
			initialValues.put("IDCONTACTO",clieprov.getIdcontacto()); 
			initialValues.put("IDCANAL",clieprov.getIdcanal()); 
			initialValues.put("IDFPAGO",clieprov.getIdfpago()); 
			initialValues.put("SERIEDOCVENTA",clieprov.getSeriedocventa()); 
			initialValues.put("ES_AGENTERETENEDOR",clieprov.getEs_agenteretenedor()); 
			initialValues.put("IDPAISEMISOR",clieprov.getIdpaisemisor()); 
			initialValues.put("ESTADO_SUNAT",clieprov.getEstado_sunat()); 
			initialValues.put("DESTACAPERSONAL_CLIENTE",clieprov.getDestacapersonal_cliente()); 
			initialValues.put("DESTACAPERSONAL_PROVEEDOR",clieprov.getDestacapersonal_proveedor()); 
			initialValues.put("IDTIPOACTIVIDAD",clieprov.getIdtipoactividad()); 
			initialValues.put("DOMICILIADO",clieprov.getDomiciliado()); 
			initialValues.put("REP_LEGAL",clieprov.getRep_legal()); 
			initialValues.put("IDPROCEDENCIA",clieprov.getIdprocedencia()); 
			initialValues.put("ES_NAVIERA",clieprov.getEs_naviera()); 
			initialValues.put("ES_AGENTEADUANA",clieprov.getEs_agenteaduana()); 
			initialValues.put("PORCENTAJECOMISION",clieprov.getPorcentajecomision()); 
			initialValues.put("COMISIONMINIMA",clieprov.getComisionminima()); 
			initialValues.put("MONTOCOMISIONMINIMA",clieprov.getMontocomisionminima()); 
			initialValues.put("CONDICION_SUNAT",clieprov.getCondicion_sunat()); 
			initialValues.put("IDREGIMENASEG_SALUD",clieprov.getIdregimenaseg_salud()); 
			initialValues.put("ES_AGRICULTOR",clieprov.getEs_agricultor()); 
			initialValues.put("MONTOMIN_GARANVSCONT",clieprov.getMontomin_garanvscont()); 
			initialValues.put("ES_ASEGURADORA",clieprov.getEs_aseguradora()); 
			initialValues.put("ASEGURADORA_WEB",clieprov.getAseguradora_web()); 
			initialValues.put("IMPORTADO_EXTERNO",clieprov.getImportado_externo()); 
			initialValues.put("ACTIVIDAD_ECONOMICA",clieprov.getActividad_economica()); 
			initialValues.put("CONYUGUE",clieprov.getConyugue()); 
			initialValues.put("DEPENDIENTE",clieprov.getDependiente()); 
			initialValues.put("DIRCONYUGUE",clieprov.getDirconyugue()); 
			initialValues.put("DIRCORRESPONDENCIA",clieprov.getDircorrespondencia()); 
			initialValues.put("DNI_ADICIONAL",clieprov.getDni_adicional()); 
			initialValues.put("EMPLEADOR",clieprov.getEmpleador()); 
			initialValues.put("E_MAIL2",clieprov.getE_mail2()); 
			initialValues.put("FNCONYUGUE",dateFormat.format(clieprov.getFnconyugue() ) ); 
			initialValues.put("REF_ADICIONAL",clieprov.getRef_adicional()); 
			initialValues.put("CNY_EMAIL1",clieprov.getCny_email1()); 
			initialValues.put("CNY_EMAIL2",clieprov.getCny_email2()); 
			initialValues.put("CNY_FAX",clieprov.getCny_fax()); 
			initialValues.put("CNY_FONO1",clieprov.getCny_fono1()); 
			initialValues.put("CNY_FONO2",clieprov.getCny_fono2()); 
			initialValues.put("DIREC1",clieprov.getDirec1()); 
			initialValues.put("DIREC2",clieprov.getDirec2()); 
			initialValues.put("DIREC3",clieprov.getDirec3()); 
			initialValues.put("DIREC4",clieprov.getDirec4()); 
			initialValues.put("DIREC5",clieprov.getDirec5()); 
			initialValues.put("FNH1",clieprov.getFnh1()); 
			initialValues.put("FNH2",clieprov.getFnh2()); 
			initialValues.put("FNH3",clieprov.getFnh3()); 
			initialValues.put("FNH4",clieprov.getFnh4()); 
			initialValues.put("FNH5",clieprov.getFnh5()); 
			initialValues.put("FNH6",clieprov.getFnh6()); 
			initialValues.put("FNH7",clieprov.getFnh7()); 
			initialValues.put("FNH8",clieprov.getFnh8()); 
			initialValues.put("HIJO1",clieprov.getHijo1()); 
			initialValues.put("HIJO2",clieprov.getHijo2()); 
			initialValues.put("HIJO3",clieprov.getHijo3()); 
			initialValues.put("HIJO4",clieprov.getHijo4()); 
			initialValues.put("HIJO5",clieprov.getHijo5()); 
			initialValues.put("HIJO6",clieprov.getHijo6()); 
			initialValues.put("HIJO7",clieprov.getHijo7()); 
			initialValues.put("HIJO8",clieprov.getHijo8()); 
			initialValues.put("INGRESO_MENSUAL",clieprov.getIngreso_mensual()); 
			initialValues.put("IDMONEDALC",clieprov.getIdmonedalc()); 
			initialValues.put("ESTADOLC",clieprov.getEstadolc()); 
			initialValues.put("ES_RETENEDOR",clieprov.getEs_retenedor()); 
			initialValues.put("ES_PERCEPCION",clieprov.getEs_percepcion()); 
			initialValues.put("ES_BUENCONTRIBUYENTE",clieprov.getEs_buencontribuyente()); 
			initialValues.put("IDAFP",clieprov.getIdafp()); 
			initialValues.put("INICIO_AFP",dateFormat.format(clieprov.getInicio_afp() ) ); 
			initialValues.put("INICIO_ONP",dateFormat.format(clieprov.getInicio_onp() ) ); 
			initialValues.put("AUTOGENERADOAFP",clieprov.getAutogeneradoafp()); 
			initialValues.put("IDTIPOPRECIO",clieprov.getIdtipoprecio()); 
			initialValues.put("IDCONDVENTA",clieprov.getIdcondventa()); 
			initialValues.put("IDFLETE",clieprov.getIdflete()); 
			initialValues.put("FACTURABLE",clieprov.getFacturable()); 
			initialValues.put("OCUPACION",clieprov.getOcupacion()); 
			initialValues.put("INGRESOPROMEDIO",clieprov.getIngresopromedio()); 
			initialValues.put("CENTROTRABAJO_CONYUGE",clieprov.getCentrotrabajo_conyuge()); 
			initialValues.put("INGRESOPROMEDIO_CONYUGE",clieprov.getIngresopromedio_conyuge()); 
			initialValues.put("INGRESOPROMEDIO_ANUAL",clieprov.getIngresopromedio_anual()); 
			initialValues.put("IDMONEDAINGRESOPROMEDIO",clieprov.getIdmonedaingresopromedio()); 
			initialValues.put("IDCONDICIONLABORAL",clieprov.getIdcondicionlaboral()); 
			initialValues.put("IDCATEGORIALABORAL",clieprov.getIdcategorialaboral()); 
			initialValues.put("CENTROTRABAJO_RUC",clieprov.getCentrotrabajo_ruc()); 
			initialValues.put("CONTRATOINDETERMINADO",clieprov.getContratoindeterminado()); 
			initialValues.put("CONDICIONINDEPENDIENTE_RUC",clieprov.getCondicionindependiente_ruc()); 
			initialValues.put("FECHA_INGRESO_INICIOACT",dateFormat.format(clieprov.getFecha_ingreso_inicioact() ) ); 
			initialValues.put("SEPARACIONBIENES",clieprov.getSeparacionbienes()); 
			initialValues.put("NUMEROHIJOS",clieprov.getNumerohijos()); 
			initialValues.put("NROTRABAJADORES",clieprov.getNrotrabajadores()); 
			initialValues.put("IDTIPOCLIEPROV",clieprov.getIdtipoclieprov()); 
			initialValues.put("ES_PROVEEDOR_TERCERO",clieprov.getEs_proveedor_tercero()); 
			initialValues.put("ES_REGISTROXWEB",clieprov.getEs_registroxweb()); 
			initialValues.put("CLAVE_CITA",clieprov.getClave_cita()); 
			initialValues.put("CONRUS",clieprov.getConrus()); 
			initialValues.put("IDCLASIFICACION_BS_SUNAT",clieprov.getIdclasificacion_bs_sunat()); 
			initialValues.put("IDVINCULO_CR_SUNAT",clieprov.getIdvinculo_cr_sunat()); 
			initialValues.put("IDEXONERACION_SUNAT",clieprov.getIdexoneracion_sunat()); 
			initialValues.put("IDTIPORENTA_SUNAT",clieprov.getIdtiporenta_sunat()); 
			initialValues.put("IDMODALIDAD_SUNAT",clieprov.getIdmodalidad_sunat()); 
			initialValues.put("ES_IMPORTADO",clieprov.getEs_importado()); 
			initialValues.put("CODEQUIVALENTE",clieprov.getCodequivalente()); 
			initialValues.put("CODIGO_ALT",clieprov.getCodigo_alt()); 
			resultado = mDb.insert("CLIEPROV",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Clieprov clieprov,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",clieprov.getIdempresa()) ; 
			initialValues.put("IDCLIEPROV",clieprov.getIdclieprov()) ; 
			initialValues.put("TIPO_CLIEPROV",clieprov.getTipo_clieprov()) ; 
			initialValues.put("TIPOPERSONA",clieprov.getTipopersona()) ; 
			initialValues.put("IDTIPOCLIENTE",clieprov.getIdtipocliente()) ; 
			initialValues.put("CON_RETENCION",clieprov.getCon_retencion()) ; 
			initialValues.put("SIN_RETENCION",clieprov.getSin_retencion()) ; 
			initialValues.put("CONTACTO",clieprov.getContacto()) ; 
			initialValues.put("DIRECCION",clieprov.getDireccion()) ; 
			initialValues.put("IDVIA1",clieprov.getIdvia1()) ; 
			initialValues.put("VIA1_DESCRIPCION",clieprov.getVia1_descripcion()) ; 
			initialValues.put("DIRECCION_NUMERO",clieprov.getDireccion_numero()) ; 
			initialValues.put("DIRECCION_INTERIOR",clieprov.getDireccion_interior()) ; 
			initialValues.put("DIRECCION_REFERENCIA",clieprov.getDireccion_referencia()) ; 
			initialValues.put("IDZONA1",clieprov.getIdzona1()) ; 
			initialValues.put("ZONA1_DESCRIPCION",clieprov.getZona1_descripcion()) ; 
			initialValues.put("IDUBIGEO1",clieprov.getIdubigeo1()) ; 
			initialValues.put("DISTRITO",clieprov.getDistrito()) ; 
			initialValues.put("DEPARTAMENTO",clieprov.getDepartamento()) ; 
			initialValues.put("APELLIDOPATERNO",clieprov.getApellidopaterno()) ; 
			initialValues.put("APELLIDOMATERNO",clieprov.getApellidomaterno()) ; 
			initialValues.put("NOMBRES",clieprov.getNombres()) ; 
			initialValues.put("RAZON_SOCIAL",clieprov.getRazon_social()) ; 
			initialValues.put("E_MAIL",clieprov.getE_mail()) ; 
			initialValues.put("FAX",clieprov.getFax()) ; 
			initialValues.put("TELEFONO_1",clieprov.getTelefono_1()) ; 
			initialValues.put("TELEFONO_2",clieprov.getTelefono_2()) ; 
			initialValues.put("TELEFONO_3",clieprov.getTelefono_3()) ; 
			initialValues.put("NOMBRE_GIRO",clieprov.getNombre_giro()) ; 
			initialValues.put("IDDOCIDENTIDAD",clieprov.getIddocidentidad()) ; 
			initialValues.put("NRODOCIDENTIDAD",clieprov.getNrodocidentidad()) ; 
			initialValues.put("DNI",clieprov.getDni()) ; 
			initialValues.put("NEXTEL",clieprov.getNextel()) ; 
			initialValues.put("PROVINCIA",clieprov.getProvincia()) ; 
			initialValues.put("REGIMEN_AGRARIO",clieprov.getRegimen_agrario()) ; 
			initialValues.put("RUC",clieprov.getRuc()) ; 
			initialValues.put("RUC_ANTERIOR",clieprov.getRuc_anterior()) ; 
			initialValues.put("INTXCLIENT",clieprov.getIntxclient()) ; 
			initialValues.put("DIAS_GRACIA",clieprov.getDias_gracia()) ; 
			initialValues.put("IDVENDEDOR",clieprov.getIdvendedor()) ; 
			initialValues.put("IDPERSONAL",clieprov.getIdpersonal()) ; 
			initialValues.put("ESTADO",clieprov.getEstado()) ; 
			initialValues.put("SINCRONIZA",clieprov.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(clieprov.getFechacreacion() ) ) ; 
			initialValues.put("CTACTE",clieprov.getCtacte()) ; 
			initialValues.put("EXTRANJERO",clieprov.getExtranjero()) ; 
			initialValues.put("PRECIO_APLICADO",clieprov.getPrecio_aplicado()) ; 
			initialValues.put("LIBREOCCLIENTE",clieprov.getLibreoccliente()) ; 
			initialValues.put("REGMTC",clieprov.getRegmtc()) ; 
			initialValues.put("SUBCONTRATADO",clieprov.getSubcontratado()) ; 
			initialValues.put("IDTIPOSOCIO",clieprov.getIdtiposocio()) ; 
			initialValues.put("FECHA_NACIMIENTO",dateFormat.format(clieprov.getFecha_nacimiento() ) ) ; 
			initialValues.put("IDPROFESION",clieprov.getIdprofesion()) ; 
			initialValues.put("CENTROTRABAJO",clieprov.getCentrotrabajo()) ; 
			initialValues.put("SEXO",clieprov.getSexo()) ; 
			initialValues.put("IDESTADOCIVIL",clieprov.getIdestadocivil()) ; 
			initialValues.put("IDVIA2",clieprov.getIdvia2()) ; 
			initialValues.put("VIA2_DESCRIPCION",clieprov.getVia2_descripcion()) ; 
			initialValues.put("DIRECCOB_NUMERO",clieprov.getDireccob_numero()) ; 
			initialValues.put("DIRECCOB_INTERIOR",clieprov.getDireccob_interior()) ; 
			initialValues.put("DIRECCOB_REFERENCIA",clieprov.getDireccob_referencia()) ; 
			initialValues.put("IDZONA2",clieprov.getIdzona2()) ; 
			initialValues.put("ZONA2_DESCRIPCION",clieprov.getZona2_descripcion()) ; 
			initialValues.put("IDUBIGEO2",clieprov.getIdubigeo2()) ; 
			initialValues.put("FECHA_INGRESO",dateFormat.format(clieprov.getFecha_ingreso() ) ) ; 
			initialValues.put("CREDITO",clieprov.getCredito()) ; 
			initialValues.put("NROCERTIF",clieprov.getNrocertif()) ; 
			initialValues.put("TIPOCERTIF",clieprov.getTipocertif()) ; 
			initialValues.put("NROLIBRO",clieprov.getNrolibro()) ; 
			initialValues.put("IDCOBRADOR",clieprov.getIdcobrador()) ; 
			initialValues.put("IDSOCIOCORP",clieprov.getIdsociocorp()) ; 
			initialValues.put("UNIVERSIDAD",clieprov.getUniversidad()) ; 
			initialValues.put("IDUBIGEO3_LN",clieprov.getIdubigeo3_ln()) ; 
			initialValues.put("FECHA_EMAIL",dateFormat.format(clieprov.getFecha_email() ) ) ; 
			initialValues.put("IDBARRA",clieprov.getIdbarra()) ; 
			initialValues.put("IDBANCO",clieprov.getIdbanco()) ; 
			initialValues.put("TIPO_CUENTABANCO",clieprov.getTipo_cuentabanco()) ; 
			initialValues.put("IDMONEDA",clieprov.getIdmoneda()) ; 
			initialValues.put("FOTO",clieprov.getFoto()) ; 
			initialValues.put("CREDNORMAL",clieprov.getCrednormal()) ; 
			initialValues.put("CREDTEMPORAL",clieprov.getCredtemporal()) ; 
			initialValues.put("CREDTOTAL",clieprov.getCredtotal()) ; 
			initialValues.put("IDDESCUENTO",clieprov.getIddescuento()) ; 
			initialValues.put("IDGRUPOCLIEPROV",clieprov.getIdgrupoclieprov()) ; 
			initialValues.put("IDBANCO_PRED",clieprov.getIdbanco_pred()) ; 
			initialValues.put("IDCTACTE_PRED",clieprov.getIdctacte_pred()) ; 
			initialValues.put("IDBANCO_PROV",clieprov.getIdbanco_prov()) ; 
			initialValues.put("CTACTE2",clieprov.getCtacte2()) ; 
			initialValues.put("CTACTE3",clieprov.getCtacte3()) ; 
			initialValues.put("CTACTE4",clieprov.getCtacte4()) ; 
			initialValues.put("IDBANCO_PROV2",clieprov.getIdbanco_prov2()) ; 
			initialValues.put("IDBANCO_PROV3",clieprov.getIdbanco_prov3()) ; 
			initialValues.put("IDBANCO_PROV4",clieprov.getIdbanco_prov4()) ; 
			initialValues.put("ESTADO_CTA",clieprov.getEstado_cta()) ; 
			initialValues.put("ESTADO_CTA2",clieprov.getEstado_cta2()) ; 
			initialValues.put("ESTADO_CTA3",clieprov.getEstado_cta3()) ; 
			initialValues.put("ESTADO_CTA4",clieprov.getEstado_cta4()) ; 
			initialValues.put("IDMONEDA2",clieprov.getIdmoneda2()) ; 
			initialValues.put("IDMONEDA3",clieprov.getIdmoneda3()) ; 
			initialValues.put("IDMONEDA4",clieprov.getIdmoneda4()) ; 
			initialValues.put("GIRAR_CHEQUE",clieprov.getGirar_cheque()) ; 
			initialValues.put("NOMBRE_ESPOSA",clieprov.getNombre_esposa()) ; 
			initialValues.put("DNI_ESPOSA",clieprov.getDni_esposa()) ; 
			initialValues.put("IDSECTOR",clieprov.getIdsector()) ; 
			initialValues.put("NOMBRE_COMERCIAL",clieprov.getNombre_comercial()) ; 
			initialValues.put("CIIU",clieprov.getCiiu()) ; 
			initialValues.put("IDNACIONALIDAD",clieprov.getIdnacionalidad()) ; 
			initialValues.put("INFOADREPORTE_PIE",clieprov.getInfoadreporte_pie()) ; 
			initialValues.put("ES_TRANSPORTISTA",clieprov.getEs_transportista()) ; 
			initialValues.put("IDCONVENIO",clieprov.getIdconvenio()) ; 
			initialValues.put("IDREFERIDO",clieprov.getIdreferido()) ; 
			initialValues.put("IDNIVELEDUCATIVO",clieprov.getIdniveleducativo()) ; 
			initialValues.put("IDCARGO",clieprov.getIdcargo()) ; 
			initialValues.put("ES_SOCIONEGOCIO",clieprov.getEs_socionegocio()) ; 
			initialValues.put("ES_OPERADORAEREO",clieprov.getEs_operadoraereo()) ; 
			initialValues.put("IDCONTACTO",clieprov.getIdcontacto()) ; 
			initialValues.put("IDCANAL",clieprov.getIdcanal()) ; 
			initialValues.put("IDFPAGO",clieprov.getIdfpago()) ; 
			initialValues.put("SERIEDOCVENTA",clieprov.getSeriedocventa()) ; 
			initialValues.put("ES_AGENTERETENEDOR",clieprov.getEs_agenteretenedor()) ; 
			initialValues.put("IDPAISEMISOR",clieprov.getIdpaisemisor()) ; 
			initialValues.put("ESTADO_SUNAT",clieprov.getEstado_sunat()) ; 
			initialValues.put("DESTACAPERSONAL_CLIENTE",clieprov.getDestacapersonal_cliente()) ; 
			initialValues.put("DESTACAPERSONAL_PROVEEDOR",clieprov.getDestacapersonal_proveedor()) ; 
			initialValues.put("IDTIPOACTIVIDAD",clieprov.getIdtipoactividad()) ; 
			initialValues.put("DOMICILIADO",clieprov.getDomiciliado()) ; 
			initialValues.put("REP_LEGAL",clieprov.getRep_legal()) ; 
			initialValues.put("IDPROCEDENCIA",clieprov.getIdprocedencia()) ; 
			initialValues.put("ES_NAVIERA",clieprov.getEs_naviera()) ; 
			initialValues.put("ES_AGENTEADUANA",clieprov.getEs_agenteaduana()) ; 
			initialValues.put("PORCENTAJECOMISION",clieprov.getPorcentajecomision()) ; 
			initialValues.put("COMISIONMINIMA",clieprov.getComisionminima()) ; 
			initialValues.put("MONTOCOMISIONMINIMA",clieprov.getMontocomisionminima()) ; 
			initialValues.put("CONDICION_SUNAT",clieprov.getCondicion_sunat()) ; 
			initialValues.put("IDREGIMENASEG_SALUD",clieprov.getIdregimenaseg_salud()) ; 
			initialValues.put("ES_AGRICULTOR",clieprov.getEs_agricultor()) ; 
			initialValues.put("MONTOMIN_GARANVSCONT",clieprov.getMontomin_garanvscont()) ; 
			initialValues.put("ES_ASEGURADORA",clieprov.getEs_aseguradora()) ; 
			initialValues.put("ASEGURADORA_WEB",clieprov.getAseguradora_web()) ; 
			initialValues.put("IMPORTADO_EXTERNO",clieprov.getImportado_externo()) ; 
			initialValues.put("ACTIVIDAD_ECONOMICA",clieprov.getActividad_economica()) ; 
			initialValues.put("CONYUGUE",clieprov.getConyugue()) ; 
			initialValues.put("DEPENDIENTE",clieprov.getDependiente()) ; 
			initialValues.put("DIRCONYUGUE",clieprov.getDirconyugue()) ; 
			initialValues.put("DIRCORRESPONDENCIA",clieprov.getDircorrespondencia()) ; 
			initialValues.put("DNI_ADICIONAL",clieprov.getDni_adicional()) ; 
			initialValues.put("EMPLEADOR",clieprov.getEmpleador()) ; 
			initialValues.put("E_MAIL2",clieprov.getE_mail2()) ; 
			initialValues.put("FNCONYUGUE",dateFormat.format(clieprov.getFnconyugue() ) ) ; 
			initialValues.put("REF_ADICIONAL",clieprov.getRef_adicional()) ; 
			initialValues.put("CNY_EMAIL1",clieprov.getCny_email1()) ; 
			initialValues.put("CNY_EMAIL2",clieprov.getCny_email2()) ; 
			initialValues.put("CNY_FAX",clieprov.getCny_fax()) ; 
			initialValues.put("CNY_FONO1",clieprov.getCny_fono1()) ; 
			initialValues.put("CNY_FONO2",clieprov.getCny_fono2()) ; 
			initialValues.put("DIREC1",clieprov.getDirec1()) ; 
			initialValues.put("DIREC2",clieprov.getDirec2()) ; 
			initialValues.put("DIREC3",clieprov.getDirec3()) ; 
			initialValues.put("DIREC4",clieprov.getDirec4()) ; 
			initialValues.put("DIREC5",clieprov.getDirec5()) ; 
			initialValues.put("FNH1",clieprov.getFnh1()) ; 
			initialValues.put("FNH2",clieprov.getFnh2()) ; 
			initialValues.put("FNH3",clieprov.getFnh3()) ; 
			initialValues.put("FNH4",clieprov.getFnh4()) ; 
			initialValues.put("FNH5",clieprov.getFnh5()) ; 
			initialValues.put("FNH6",clieprov.getFnh6()) ; 
			initialValues.put("FNH7",clieprov.getFnh7()) ; 
			initialValues.put("FNH8",clieprov.getFnh8()) ; 
			initialValues.put("HIJO1",clieprov.getHijo1()) ; 
			initialValues.put("HIJO2",clieprov.getHijo2()) ; 
			initialValues.put("HIJO3",clieprov.getHijo3()) ; 
			initialValues.put("HIJO4",clieprov.getHijo4()) ; 
			initialValues.put("HIJO5",clieprov.getHijo5()) ; 
			initialValues.put("HIJO6",clieprov.getHijo6()) ; 
			initialValues.put("HIJO7",clieprov.getHijo7()) ; 
			initialValues.put("HIJO8",clieprov.getHijo8()) ; 
			initialValues.put("INGRESO_MENSUAL",clieprov.getIngreso_mensual()) ; 
			initialValues.put("IDMONEDALC",clieprov.getIdmonedalc()) ; 
			initialValues.put("ESTADOLC",clieprov.getEstadolc()) ; 
			initialValues.put("ES_RETENEDOR",clieprov.getEs_retenedor()) ; 
			initialValues.put("ES_PERCEPCION",clieprov.getEs_percepcion()) ; 
			initialValues.put("ES_BUENCONTRIBUYENTE",clieprov.getEs_buencontribuyente()) ; 
			initialValues.put("IDAFP",clieprov.getIdafp()) ; 
			initialValues.put("INICIO_AFP",dateFormat.format(clieprov.getInicio_afp() ) ) ; 
			initialValues.put("INICIO_ONP",dateFormat.format(clieprov.getInicio_onp() ) ) ; 
			initialValues.put("AUTOGENERADOAFP",clieprov.getAutogeneradoafp()) ; 
			initialValues.put("IDTIPOPRECIO",clieprov.getIdtipoprecio()) ; 
			initialValues.put("IDCONDVENTA",clieprov.getIdcondventa()) ; 
			initialValues.put("IDFLETE",clieprov.getIdflete()) ; 
			initialValues.put("FACTURABLE",clieprov.getFacturable()) ; 
			initialValues.put("OCUPACION",clieprov.getOcupacion()) ; 
			initialValues.put("INGRESOPROMEDIO",clieprov.getIngresopromedio()) ; 
			initialValues.put("CENTROTRABAJO_CONYUGE",clieprov.getCentrotrabajo_conyuge()) ; 
			initialValues.put("INGRESOPROMEDIO_CONYUGE",clieprov.getIngresopromedio_conyuge()) ; 
			initialValues.put("INGRESOPROMEDIO_ANUAL",clieprov.getIngresopromedio_anual()) ; 
			initialValues.put("IDMONEDAINGRESOPROMEDIO",clieprov.getIdmonedaingresopromedio()) ; 
			initialValues.put("IDCONDICIONLABORAL",clieprov.getIdcondicionlaboral()) ; 
			initialValues.put("IDCATEGORIALABORAL",clieprov.getIdcategorialaboral()) ; 
			initialValues.put("CENTROTRABAJO_RUC",clieprov.getCentrotrabajo_ruc()) ; 
			initialValues.put("CONTRATOINDETERMINADO",clieprov.getContratoindeterminado()) ; 
			initialValues.put("CONDICIONINDEPENDIENTE_RUC",clieprov.getCondicionindependiente_ruc()) ; 
			initialValues.put("FECHA_INGRESO_INICIOACT",dateFormat.format(clieprov.getFecha_ingreso_inicioact() ) ) ; 
			initialValues.put("SEPARACIONBIENES",clieprov.getSeparacionbienes()) ; 
			initialValues.put("NUMEROHIJOS",clieprov.getNumerohijos()) ; 
			initialValues.put("NROTRABAJADORES",clieprov.getNrotrabajadores()) ; 
			initialValues.put("IDTIPOCLIEPROV",clieprov.getIdtipoclieprov()) ; 
			initialValues.put("ES_PROVEEDOR_TERCERO",clieprov.getEs_proveedor_tercero()) ; 
			initialValues.put("ES_REGISTROXWEB",clieprov.getEs_registroxweb()) ; 
			initialValues.put("CLAVE_CITA",clieprov.getClave_cita()) ; 
			initialValues.put("CONRUS",clieprov.getConrus()) ; 
			initialValues.put("IDCLASIFICACION_BS_SUNAT",clieprov.getIdclasificacion_bs_sunat()) ; 
			initialValues.put("IDVINCULO_CR_SUNAT",clieprov.getIdvinculo_cr_sunat()) ; 
			initialValues.put("IDEXONERACION_SUNAT",clieprov.getIdexoneracion_sunat()) ; 
			initialValues.put("IDTIPORENTA_SUNAT",clieprov.getIdtiporenta_sunat()) ; 
			initialValues.put("IDMODALIDAD_SUNAT",clieprov.getIdmodalidad_sunat()) ; 
			initialValues.put("ES_IMPORTADO",clieprov.getEs_importado()) ; 
			initialValues.put("CODEQUIVALENTE",clieprov.getCodequivalente()) ; 
			initialValues.put("CODIGO_ALT",clieprov.getCodigo_alt()) ; 
			resultado = mDb.update("CLIEPROV",initialValues,where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boolean delete(String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			resultado = mDb.delete("CLIEPROV",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Clieprov> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Clieprov> lista  = new ArrayList<Clieprov>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CLIEPROV",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCLIEPROV" ,
							 "TIPO_CLIEPROV" ,
							 "TIPOPERSONA" ,
							 "IDTIPOCLIENTE" ,
							 "CON_RETENCION" ,
							 "SIN_RETENCION" ,
							 "CONTACTO" ,
							 "DIRECCION" ,
							 "IDVIA1" ,
							 "VIA1_DESCRIPCION" ,
							 "DIRECCION_NUMERO" ,
							 "DIRECCION_INTERIOR" ,
							 "DIRECCION_REFERENCIA" ,
							 "IDZONA1" ,
							 "ZONA1_DESCRIPCION" ,
							 "IDUBIGEO1" ,
							 "DISTRITO" ,
							 "DEPARTAMENTO" ,
							 "APELLIDOPATERNO" ,
							 "APELLIDOMATERNO" ,
							 "NOMBRES" ,
							 "RAZON_SOCIAL" ,
							 "E_MAIL" ,
							 "FAX" ,
							 "TELEFONO_1" ,
							 "TELEFONO_2" ,
							 "TELEFONO_3" ,
							 "NOMBRE_GIRO" ,
							 "IDDOCIDENTIDAD" ,
							 "NRODOCIDENTIDAD" ,
							 "DNI" ,
							 "NEXTEL" ,
							 "PROVINCIA" ,
							 "REGIMEN_AGRARIO" ,
							 "RUC" ,
							 "RUC_ANTERIOR" ,
							 "INTXCLIENT" ,
							 "DIAS_GRACIA" ,
							 "IDVENDEDOR" ,
							 "IDPERSONAL" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "CTACTE" ,
							 "EXTRANJERO" ,
							 "PRECIO_APLICADO" ,
							 "LIBREOCCLIENTE" ,
							 "REGMTC" ,
							 "SUBCONTRATADO" ,
							 "IDTIPOSOCIO" ,
							 "FECHA_NACIMIENTO" ,
							 "IDPROFESION" ,
							 "CENTROTRABAJO" ,
							 "SEXO" ,
							 "IDESTADOCIVIL" ,
							 "IDVIA2" ,
							 "VIA2_DESCRIPCION" ,
							 "DIRECCOB_NUMERO" ,
							 "DIRECCOB_INTERIOR" ,
							 "DIRECCOB_REFERENCIA" ,
							 "IDZONA2" ,
							 "ZONA2_DESCRIPCION" ,
							 "IDUBIGEO2" ,
							 "FECHA_INGRESO" ,
							 "CREDITO" ,
							 "NROCERTIF" ,
							 "TIPOCERTIF" ,
							 "NROLIBRO" ,
							 "IDCOBRADOR" ,
							 "IDSOCIOCORP" ,
							 "UNIVERSIDAD" ,
							 "IDUBIGEO3_LN" ,
							 "FECHA_EMAIL" ,
							 "IDBARRA" ,
							 "IDBANCO" ,
							 "TIPO_CUENTABANCO" ,
							 "IDMONEDA" ,
							 "FOTO" ,
							 "CREDNORMAL" ,
							 "CREDTEMPORAL" ,
							 "CREDTOTAL" ,
							 "IDDESCUENTO" ,
							 "IDGRUPOCLIEPROV" ,
							 "IDBANCO_PRED" ,
							 "IDCTACTE_PRED" ,
							 "IDBANCO_PROV" ,
							 "CTACTE2" ,
							 "CTACTE3" ,
							 "CTACTE4" ,
							 "IDBANCO_PROV2" ,
							 "IDBANCO_PROV3" ,
							 "IDBANCO_PROV4" ,
							 "ESTADO_CTA" ,
							 "ESTADO_CTA2" ,
							 "ESTADO_CTA3" ,
							 "ESTADO_CTA4" ,
							 "IDMONEDA2" ,
							 "IDMONEDA3" ,
							 "IDMONEDA4" ,
							 "GIRAR_CHEQUE" ,
							 "NOMBRE_ESPOSA" ,
							 "DNI_ESPOSA" ,
							 "IDSECTOR" ,
							 "NOMBRE_COMERCIAL" ,
							 "CIIU" ,
							 "IDNACIONALIDAD" ,
							 "INFOADREPORTE_PIE" ,
							 "ES_TRANSPORTISTA" ,
							 "IDCONVENIO" ,
							 "IDREFERIDO" ,
							 "IDNIVELEDUCATIVO" ,
							 "IDCARGO" ,
							 "ES_SOCIONEGOCIO" ,
							 "ES_OPERADORAEREO" ,
							 "IDCONTACTO" ,
							 "IDCANAL" ,
							 "IDFPAGO" ,
							 "SERIEDOCVENTA" ,
							 "ES_AGENTERETENEDOR" ,
							 "IDPAISEMISOR" ,
							 "ESTADO_SUNAT" ,
							 "DESTACAPERSONAL_CLIENTE" ,
							 "DESTACAPERSONAL_PROVEEDOR" ,
							 "IDTIPOACTIVIDAD" ,
							 "DOMICILIADO" ,
							 "REP_LEGAL" ,
							 "IDPROCEDENCIA" ,
							 "ES_NAVIERA" ,
							 "ES_AGENTEADUANA" ,
							 "PORCENTAJECOMISION" ,
							 "COMISIONMINIMA" ,
							 "MONTOCOMISIONMINIMA" ,
							 "CONDICION_SUNAT" ,
							 "IDREGIMENASEG_SALUD" ,
							 "ES_AGRICULTOR" ,
							 "MONTOMIN_GARANVSCONT" ,
							 "ES_ASEGURADORA" ,
							 "ASEGURADORA_WEB" ,
							 "IMPORTADO_EXTERNO" ,
							 "ACTIVIDAD_ECONOMICA" ,
							 "CONYUGUE" ,
							 "DEPENDIENTE" ,
							 "DIRCONYUGUE" ,
							 "DIRCORRESPONDENCIA" ,
							 "DNI_ADICIONAL" ,
							 "EMPLEADOR" ,
							 "E_MAIL2" ,
							 "FNCONYUGUE" ,
							 "REF_ADICIONAL" ,
							 "CNY_EMAIL1" ,
							 "CNY_EMAIL2" ,
							 "CNY_FAX" ,
							 "CNY_FONO1" ,
							 "CNY_FONO2" ,
							 "DIREC1" ,
							 "DIREC2" ,
							 "DIREC3" ,
							 "DIREC4" ,
							 "DIREC5" ,
							 "FNH1" ,
							 "FNH2" ,
							 "FNH3" ,
							 "FNH4" ,
							 "FNH5" ,
							 "FNH6" ,
							 "FNH7" ,
							 "FNH8" ,
							 "HIJO1" ,
							 "HIJO2" ,
							 "HIJO3" ,
							 "HIJO4" ,
							 "HIJO5" ,
							 "HIJO6" ,
							 "HIJO7" ,
							 "HIJO8" ,
							 "INGRESO_MENSUAL" ,
							 "IDMONEDALC" ,
							 "ESTADOLC" ,
							 "ES_RETENEDOR" ,
							 "ES_PERCEPCION" ,
							 "ES_BUENCONTRIBUYENTE" ,
							 "IDAFP" ,
							 "INICIO_AFP" ,
							 "INICIO_ONP" ,
							 "AUTOGENERADOAFP" ,
							 "IDTIPOPRECIO" ,
							 "IDCONDVENTA" ,
							 "IDFLETE" ,
							 "FACTURABLE" ,
							 "OCUPACION" ,
							 "INGRESOPROMEDIO" ,
							 "CENTROTRABAJO_CONYUGE" ,
							 "INGRESOPROMEDIO_CONYUGE" ,
							 "INGRESOPROMEDIO_ANUAL" ,
							 "IDMONEDAINGRESOPROMEDIO" ,
							 "IDCONDICIONLABORAL" ,
							 "IDCATEGORIALABORAL" ,
							 "CENTROTRABAJO_RUC" ,
							 "CONTRATOINDETERMINADO" ,
							 "CONDICIONINDEPENDIENTE_RUC" ,
							 "FECHA_INGRESO_INICIOACT" ,
							 "SEPARACIONBIENES" ,
							 "NUMEROHIJOS" ,
							 "NROTRABAJADORES" ,
							 "IDTIPOCLIEPROV" ,
							 "ES_PROVEEDOR_TERCERO" ,
							 "ES_REGISTROXWEB" ,
							 "CLAVE_CITA" ,
							 "CONRUS" ,
							 "IDCLASIFICACION_BS_SUNAT" ,
							 "IDVINCULO_CR_SUNAT" ,
							 "IDEXONERACION_SUNAT" ,
							 "IDTIPORENTA_SUNAT" ,
							 "IDMODALIDAD_SUNAT" ,
							 "ES_IMPORTADO" ,
							 "CODEQUIVALENTE" ,
							 "CODIGO_ALT" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Clieprov clieprov = new Clieprov() ;
					clieprov.setIdempresa(cur.getString(j++));
					clieprov.setIdclieprov(cur.getString(j++));
					clieprov.setTipo_clieprov(cur.getString(j++));
					clieprov.setTipopersona(cur.getString(j++));
					clieprov.setIdtipocliente(cur.getString(j++));
					clieprov.setCon_retencion(cur.getDouble(j++));
					clieprov.setSin_retencion(cur.getString(j++));
					clieprov.setContacto(cur.getString(j++));
					clieprov.setDireccion(cur.getString(j++));
					clieprov.setIdvia1(cur.getString(j++));
					clieprov.setVia1_descripcion(cur.getString(j++));
					clieprov.setDireccion_numero(cur.getDouble(j++));
					clieprov.setDireccion_interior(cur.getString(j++));
					clieprov.setDireccion_referencia(cur.getString(j++));
					clieprov.setIdzona1(cur.getString(j++));
					clieprov.setZona1_descripcion(cur.getString(j++));
					clieprov.setIdubigeo1(cur.getString(j++));
					clieprov.setDistrito(cur.getString(j++));
					clieprov.setDepartamento(cur.getString(j++));
					clieprov.setApellidopaterno(cur.getString(j++));
					clieprov.setApellidomaterno(cur.getString(j++));
					clieprov.setNombres(cur.getString(j++));
					clieprov.setRazon_social(cur.getString(j++));
					clieprov.setE_mail(cur.getString(j++));
					clieprov.setFax(cur.getString(j++));
					clieprov.setTelefono_1(cur.getString(j++));
					clieprov.setTelefono_2(cur.getString(j++));
					clieprov.setTelefono_3(cur.getString(j++));
					clieprov.setNombre_giro(cur.getString(j++));
					clieprov.setIddocidentidad(cur.getString(j++));
					clieprov.setNrodocidentidad(cur.getString(j++));
					clieprov.setDni(cur.getString(j++));
					clieprov.setNextel(cur.getString(j++));
					clieprov.setProvincia(cur.getString(j++));
					clieprov.setRegimen_agrario(cur.getDouble(j++));
					clieprov.setRuc(cur.getString(j++));
					clieprov.setRuc_anterior(cur.getString(j++));
					clieprov.setIntxclient(cur.getDouble(j++));
					clieprov.setDias_gracia(cur.getDouble(j++));
					clieprov.setIdvendedor(cur.getString(j++));
					clieprov.setIdpersonal(cur.getString(j++));
					clieprov.setEstado(cur.getDouble(j++));
					clieprov.setSincroniza(cur.getString(j++));
					clieprov.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					clieprov.setCtacte(cur.getString(j++));
					clieprov.setExtranjero(cur.getDouble(j++));
					clieprov.setPrecio_aplicado(cur.getString(j++));
					clieprov.setLibreoccliente(cur.getDouble(j++));
					clieprov.setRegmtc(cur.getString(j++));
					clieprov.setSubcontratado(cur.getDouble(j++));
					clieprov.setIdtiposocio(cur.getString(j++));
					clieprov.setFecha_nacimiento(dateFormat.parse(cur.getString(j++)) );
					clieprov.setIdprofesion(cur.getString(j++));
					clieprov.setCentrotrabajo(cur.getString(j++));
					clieprov.setSexo(cur.getString(j++));
					clieprov.setIdestadocivil(cur.getString(j++));
					clieprov.setIdvia2(cur.getString(j++));
					clieprov.setVia2_descripcion(cur.getString(j++));
					clieprov.setDireccob_numero(cur.getDouble(j++));
					clieprov.setDireccob_interior(cur.getString(j++));
					clieprov.setDireccob_referencia(cur.getString(j++));
					clieprov.setIdzona2(cur.getString(j++));
					clieprov.setZona2_descripcion(cur.getString(j++));
					clieprov.setIdubigeo2(cur.getString(j++));
					clieprov.setFecha_ingreso(dateFormat.parse(cur.getString(j++)) );
					clieprov.setCredito(cur.getString(j++));
					clieprov.setNrocertif(cur.getString(j++));
					clieprov.setTipocertif(cur.getString(j++));
					clieprov.setNrolibro(cur.getString(j++));
					clieprov.setIdcobrador(cur.getString(j++));
					clieprov.setIdsociocorp(cur.getString(j++));
					clieprov.setUniversidad(cur.getString(j++));
					clieprov.setIdubigeo3_ln(cur.getString(j++));
					clieprov.setFecha_email(dateFormat.parse(cur.getString(j++)) );
					clieprov.setIdbarra(cur.getString(j++));
					clieprov.setIdbanco(cur.getString(j++));
					clieprov.setTipo_cuentabanco(cur.getString(j++));
					clieprov.setIdmoneda(cur.getString(j++));
					clieprov.setFoto(cur.getString(j++));
					clieprov.setCrednormal(cur.getDouble(j++));
					clieprov.setCredtemporal(cur.getDouble(j++));
					clieprov.setCredtotal(cur.getDouble(j++));
					clieprov.setIddescuento(cur.getString(j++));
					clieprov.setIdgrupoclieprov(cur.getString(j++));
					clieprov.setIdbanco_pred(cur.getString(j++));
					clieprov.setIdctacte_pred(cur.getString(j++));
					clieprov.setIdbanco_prov(cur.getString(j++));
					clieprov.setCtacte2(cur.getString(j++));
					clieprov.setCtacte3(cur.getString(j++));
					clieprov.setCtacte4(cur.getString(j++));
					clieprov.setIdbanco_prov2(cur.getString(j++));
					clieprov.setIdbanco_prov3(cur.getString(j++));
					clieprov.setIdbanco_prov4(cur.getString(j++));
					clieprov.setEstado_cta(cur.getDouble(j++));
					clieprov.setEstado_cta2(cur.getDouble(j++));
					clieprov.setEstado_cta3(cur.getDouble(j++));
					clieprov.setEstado_cta4(cur.getDouble(j++));
					clieprov.setIdmoneda2(cur.getString(j++));
					clieprov.setIdmoneda3(cur.getString(j++));
					clieprov.setIdmoneda4(cur.getString(j++));
					clieprov.setGirar_cheque(cur.getString(j++));
					clieprov.setNombre_esposa(cur.getString(j++));
					clieprov.setDni_esposa(cur.getString(j++));
					clieprov.setIdsector(cur.getString(j++));
					clieprov.setNombre_comercial(cur.getString(j++));
					clieprov.setCiiu(cur.getString(j++));
					clieprov.setIdnacionalidad(cur.getString(j++));
					clieprov.setInfoadreporte_pie(cur.getString(j++));
					clieprov.setEs_transportista(cur.getDouble(j++));
					clieprov.setIdconvenio(cur.getString(j++));
					clieprov.setIdreferido(cur.getString(j++));
					clieprov.setIdniveleducativo(cur.getString(j++));
					clieprov.setIdcargo(cur.getString(j++));
					clieprov.setEs_socionegocio(cur.getDouble(j++));
					clieprov.setEs_operadoraereo(cur.getDouble(j++));
					clieprov.setIdcontacto(cur.getString(j++));
					clieprov.setIdcanal(cur.getString(j++));
					clieprov.setIdfpago(cur.getString(j++));
					clieprov.setSeriedocventa(cur.getString(j++));
					clieprov.setEs_agenteretenedor(cur.getDouble(j++));
					clieprov.setIdpaisemisor(cur.getString(j++));
					clieprov.setEstado_sunat(cur.getString(j++));
					clieprov.setDestacapersonal_cliente(cur.getDouble(j++));
					clieprov.setDestacapersonal_proveedor(cur.getDouble(j++));
					clieprov.setIdtipoactividad(cur.getString(j++));
					clieprov.setDomiciliado(cur.getDouble(j++));
					clieprov.setRep_legal(cur.getString(j++));
					clieprov.setIdprocedencia(cur.getString(j++));
					clieprov.setEs_naviera(cur.getDouble(j++));
					clieprov.setEs_agenteaduana(cur.getDouble(j++));
					clieprov.setPorcentajecomision(cur.getDouble(j++));
					clieprov.setComisionminima(cur.getDouble(j++));
					clieprov.setMontocomisionminima(cur.getDouble(j++));
					clieprov.setCondicion_sunat(cur.getString(j++));
					clieprov.setIdregimenaseg_salud(cur.getString(j++));
					clieprov.setEs_agricultor(cur.getDouble(j++));
					clieprov.setMontomin_garanvscont(cur.getDouble(j++));
					clieprov.setEs_aseguradora(cur.getDouble(j++));
					clieprov.setAseguradora_web(cur.getString(j++));
					clieprov.setImportado_externo(cur.getDouble(j++));
					clieprov.setActividad_economica(cur.getString(j++));
					clieprov.setConyugue(cur.getString(j++));
					clieprov.setDependiente(cur.getDouble(j++));
					clieprov.setDirconyugue(cur.getString(j++));
					clieprov.setDircorrespondencia(cur.getString(j++));
					clieprov.setDni_adicional(cur.getString(j++));
					clieprov.setEmpleador(cur.getString(j++));
					clieprov.setE_mail2(cur.getString(j++));
					clieprov.setFnconyugue(dateFormat.parse(cur.getString(j++)) );
					clieprov.setRef_adicional(cur.getString(j++));
					clieprov.setCny_email1(cur.getString(j++));
					clieprov.setCny_email2(cur.getString(j++));
					clieprov.setCny_fax(cur.getString(j++));
					clieprov.setCny_fono1(cur.getString(j++));
					clieprov.setCny_fono2(cur.getString(j++));
					clieprov.setDirec1(cur.getString(j++));
					clieprov.setDirec2(cur.getString(j++));
					clieprov.setDirec3(cur.getString(j++));
					clieprov.setDirec4(cur.getString(j++));
					clieprov.setDirec5(cur.getString(j++));
					clieprov.setFnh1(cur.getString(j++));
					clieprov.setFnh2(cur.getString(j++));
					clieprov.setFnh3(cur.getString(j++));
					clieprov.setFnh4(cur.getString(j++));
					clieprov.setFnh5(cur.getString(j++));
					clieprov.setFnh6(cur.getString(j++));
					clieprov.setFnh7(cur.getString(j++));
					clieprov.setFnh8(cur.getString(j++));
					clieprov.setHijo1(cur.getString(j++));
					clieprov.setHijo2(cur.getString(j++));
					clieprov.setHijo3(cur.getString(j++));
					clieprov.setHijo4(cur.getString(j++));
					clieprov.setHijo5(cur.getString(j++));
					clieprov.setHijo6(cur.getString(j++));
					clieprov.setHijo7(cur.getString(j++));
					clieprov.setHijo8(cur.getString(j++));
					clieprov.setIngreso_mensual(cur.getDouble(j++));
					clieprov.setIdmonedalc(cur.getString(j++));
					clieprov.setEstadolc(cur.getDouble(j++));
					clieprov.setEs_retenedor(cur.getDouble(j++));
					clieprov.setEs_percepcion(cur.getDouble(j++));
					clieprov.setEs_buencontribuyente(cur.getDouble(j++));
					clieprov.setIdafp(cur.getString(j++));
					clieprov.setInicio_afp(dateFormat.parse(cur.getString(j++)) );
					clieprov.setInicio_onp(dateFormat.parse(cur.getString(j++)) );
					clieprov.setAutogeneradoafp(cur.getString(j++));
					clieprov.setIdtipoprecio(cur.getString(j++));
					clieprov.setIdcondventa(cur.getString(j++));
					clieprov.setIdflete(cur.getString(j++));
					clieprov.setFacturable(cur.getDouble(j++));
					clieprov.setOcupacion(cur.getString(j++));
					clieprov.setIngresopromedio(cur.getDouble(j++));
					clieprov.setCentrotrabajo_conyuge(cur.getString(j++));
					clieprov.setIngresopromedio_conyuge(cur.getDouble(j++));
					clieprov.setIngresopromedio_anual(cur.getDouble(j++));
					clieprov.setIdmonedaingresopromedio(cur.getString(j++));
					clieprov.setIdcondicionlaboral(cur.getString(j++));
					clieprov.setIdcategorialaboral(cur.getString(j++));
					clieprov.setCentrotrabajo_ruc(cur.getString(j++));
					clieprov.setContratoindeterminado(cur.getString(j++));
					clieprov.setCondicionindependiente_ruc(cur.getString(j++));
					clieprov.setFecha_ingreso_inicioact(dateFormat.parse(cur.getString(j++)) );
					clieprov.setSeparacionbienes(cur.getString(j++));
					clieprov.setNumerohijos(cur.getDouble(j++));
					clieprov.setNrotrabajadores(cur.getDouble(j++));
					clieprov.setIdtipoclieprov(cur.getString(j++));
					clieprov.setEs_proveedor_tercero(cur.getDouble(j++));
					clieprov.setEs_registroxweb(cur.getDouble(j++));
					clieprov.setClave_cita(cur.getString(j++));
					clieprov.setConrus(cur.getString(j++));
					clieprov.setIdclasificacion_bs_sunat(cur.getString(j++));
					clieprov.setIdvinculo_cr_sunat(cur.getString(j++));
					clieprov.setIdexoneracion_sunat(cur.getString(j++));
					clieprov.setIdtiporenta_sunat(cur.getString(j++));
					clieprov.setIdmodalidad_sunat(cur.getString(j++));
					clieprov.setEs_importado(cur.getDouble(j++));
					clieprov.setCodequivalente(cur.getString(j++));
					clieprov.setCodigo_alt(cur.getString(j++));

					lista.add(clieprov); 
					i++; 
					if(i == limit){ 
						break; 
					} 
					cur.moveToNext(); 
				} 
				cur.close(); 
			} 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return lista; 
	} 
}