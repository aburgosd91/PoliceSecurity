package com.nisira.core.service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.nisira.core.dao.AppmovilusuarioDao;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Codoperaciones_pssDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.Estructura_costos_productoDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.ProductosDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TipogastoDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Appmovilusuario;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Codoperaciones_pss;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Dato;
import com.nisira.core.entity.DatosClieProvFree;
import com.nisira.core.entity.DatosConsumidor;
import com.nisira.core.entity.DatosOrdenLiquidacionGastos;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.EstructClieProvFree;
import com.nisira.core.entity.Estruct_Consumidor;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Ordenliquidaciongasto;

import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Ordenservicioclientes;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Productos;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.StructOrdenLiquidacionGastos;
import com.nisira.core.entity.Sucursales;
import com.nisira.core.entity.Tipogasto;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.Util;
import com.thoughtworks.xstream.converters.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.DateFormat;



import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
/**
 * Created by aburgos on 06/01/2017.
 */

public class ActionService {

    public static String ACTION_VERIFICATION_USER (String db,String response){
        try {
            Usuario usuario = (Usuario) Util.stringObject("com.nisira.core.entity.Usuario",response);
            if(usuario!=null){
                usuario.setFechacreacion(new Date());
                usuario.setEstado(1);
                UsuarioDao usuarioDao = new UsuarioDao();
                if(usuario!=null){
                    usuarioDao.mezclarLocal(usuario);
                }
                return "OK";
            }
            return null;
        }
        catch (Exception e)
        {
            Log.i("ActionService ->",e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static String ACTION_VERIFICATION_APPMOVILUSUARIO (String db,String response){
        try {
            List appmovilusuario_lst = (List<Appmovilusuario>) Util.stringObject("com.nisira.core.entity.Appmovilusuario",response);
            AppmovilusuarioDao appmovilusuarioDao = new AppmovilusuarioDao();
            if(appmovilusuario_lst!=null){
                for(int i=0;i<appmovilusuario_lst.size();i++){
                    Appmovilusuario obj= (Appmovilusuario)appmovilusuario_lst.get(i);
                    appmovilusuarioDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            Log.i("ActionService ->",e.getMessage());
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_CLIEPROV (String db,String response){
        try {
            List clieprovs = (List<Clieprov>) Util.stringObject("com.nisira.core.entity.Clieprov",response);
            ClieprovDao clieprovDao = new ClieprovDao();
            if(clieprovs!=null){
                for(int i=0;i<clieprovs.size();i++){
                    Clieprov obj= (Clieprov)clieprovs.get(i);
                    clieprovDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            Log.i("ActionService ->",e.getMessage());
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_CLIEPROV_FREE (String db,String response){
       /** try {
            List clieprovs = (List<Clieprov>) Util.stringObject("com.nisira.core.entity.Clieprov",response);
            ClieprovDao clieprovDao = new ClieprovDao();
            if(clieprovs!=null){
                for(int i=0;i<clieprovs.size();i++){
                    Clieprov obj= (Clieprov)clieprovs.get(i);
                    clieprovDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            Log.i("ActionService ->",e.getMessage());
            return e.getMessage();
        }**/
String succes="false";
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Gson gson = new Gson();
            EstructClieProvFree ListInfo = gson.fromJson(response,EstructClieProvFree.class);
            /*crear*/
            Clieprov or;
            List<Clieprov> lst = new ArrayList<>();
            for(DatosClieProvFree ob :ListInfo.getDatos()){
                or = new Clieprov();
                or.setIdempresa(ob.getIdempresa());
                or.setIdclieprov(ob.getIdclieprov());
                or.setTipo_clieprov(ob.getTipoClieprov());
                or.setTipopersona(ob.getTipopersona());
                or.setApellidopaterno(ob.getApellidopaterno());
                or.setApellidomaterno(ob.getApellidomaterno());
                or.setNombres(ob.getNombres());
                or.setDni(ob.getDni());
                or.setRuc(ob.getRuc());
                or.setRazon_social(ob.getRazonsocial());
                or.setDireccion(ob.getDireccion());
                or.setEstado(ob.getEstado());
                or.setIdgrupoclieprov(ob.getIdgrupoclieprov());
                lst.add(or);
            }
            if(!lst.isEmpty()){
                ClieprovDao clieprovDao = new ClieprovDao();
                //clieprovDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Clieprov obj= lst.get(i);
                    clieprovDao.mezclarLocal(obj);
                }
                return succes="OK";
            }
            return succes;
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_CONSUMIDOR (String db,String response){
        try {
            /**List consumidores = (List<Consumidor>) Util.stringObject("com.nisira.core.entity.Consumidor",response);
             ConsumidorDao consumidorDao = new ConsumidorDao();

            if(consumidores!=null){
                for(int i=0;i<consumidores.size();i++){
                    Consumidor obj= (Consumidor)consumidores.get(i);
                    consumidorDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";**/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        Gson gson = new Gson();
        Estruct_Consumidor ListInfo = gson.fromJson(response,Estruct_Consumidor.class);
            /*crear*/
        Consumidor or;
        List<Consumidor> lst = new ArrayList<>();
        for(DatosConsumidor ob :ListInfo.getDatos()){
            or = new Consumidor();
            or.setIdempresa(ob.getIdempresa());
            or.setIdconsumidor(ob.getIdconsumidor());
            or.setTipo(ob.getTipo());
            or.setJerarquia(ob.getJerarquia());
            or.setDescripcion(ob.getDescripcion());
            or.setIdccosto(ob.getIdccosto());
            if(ob.getFechaIngreso()!=null)
                or.setFecha_ingreso(dateFormat.parse(Conversionfecha(ob.getFechaIngreso())));
            or.setEstado(ob.getEstado());
            or.setAnio(ob.getAnio());
            or.setIdbasedatos(ob.getIdbasedatos());

            lst.add(or);
        }
        if(!lst.isEmpty()){
            ConsumidorDao consumidorDao = new ConsumidorDao();
           // consumidorDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
            for(int i=0;i<lst.size();i++){
                Consumidor obj= lst.get(i);
                consumidorDao.mezclarLocal(obj);
            }
            return "OK";

        }
        return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_CARGOS_PERSONAL (String db,String response){
        try {
            List cargos_personals = (List<Cargos_personal>) Util.stringObject("com.nisira.core.entity.Cargos_personal",response);
            Cargos_personalDao cargos_personalDao = new Cargos_personalDao();
            if(cargos_personals!=null){
                for(int i=0;i<cargos_personals.size();i++){
                    Cargos_personal obj= (Cargos_personal)cargos_personals.get(i);
                    cargos_personalDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_CONCEPTO_CUENTA (String db,String response){
        try {
            List concepto_cuentas = (List<Concepto_cuenta>) Util.stringObject("com.nisira.core.entity.Concepto_cuenta",response);
            Concepto_cuentaDao concepto_cuentaDao = new Concepto_cuentaDao();
            if(concepto_cuentas!=null){
                for(int i=0;i<concepto_cuentas.size();i++){
                    Concepto_cuenta obj= (Concepto_cuenta)concepto_cuentas.get(i);
                    concepto_cuentaDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_DOCUMENTOS (String db,String response){
        try {
            List<Documentos> lstdocumentos = (List<Documentos>) Util.stringObject("com.nisira.core.entity.Documentos",response);
            DocumentosDao documentosDao = new DocumentosDao();
            if(lstdocumentos!=null){
                for(int i=0;i<lstdocumentos.size();i++){
                    Documentos obj= (Documentos)lstdocumentos.get(i);
                    documentosDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String a (String db,String response){
        try {
            List<Documentos> lstdocumentos = (List<Documentos>) Util.stringObject("com.nisira.core.entity.Documentos",response);
            DocumentosDao documentosDao = new DocumentosDao();
            if(lstdocumentos!=null){
                for(int i=0;i<lstdocumentos.size();i++){
                    Documentos obj= (Documentos)lstdocumentos.get(i);
                    documentosDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_NUMEMISOR (String db,String response){
        try {
            List<Numemisor> numemisors = (List<Numemisor>) Util.stringObject("com.nisira.core.entity.Numemisor",response);
            NumemisorDao numemisorDao = new NumemisorDao();
            if(numemisors!=null){
                for(int i=0;i<numemisors.size();i++){
                    Numemisor obj= (Numemisor)numemisors.get(i);
                    numemisorDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_PRODUCTOS (String db,String response){
        try {
            List lstproductos = (List<Productos>) Util.stringObject("com.nisira.core.entity.Productos",response);
            ProductosDao productosDao = new ProductosDao();
            if(lstproductos!=null){
                for(int i=0;i<lstproductos.size();i++){
                    Productos obj= (Productos)lstproductos.get(i);
                    productosDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_RUTAS (String db,String response){
        try {
            List lstrutas = (List<Rutas>) Util.stringObject("com.nisira.core.entity.Rutas",response);
            RutasDao rutasDao = new RutasDao();
            if(lstrutas!=null){
                for(int i=0;i<lstrutas.size();i++){
                    Rutas obj= (Rutas)lstrutas.get(i);
                    rutasDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_SUCURSALES (String db,String response){
        try {
            List lstsucursales = (List<Sucursales>) Util.stringGson("com.nisira.core.entity.Sucursales",response);
            SucursalesDao sucursalesDao = new SucursalesDao();
            if(lstsucursales!=null){
                for(int i=0;i<lstsucursales.size();i++){
                    Sucursales obj= (Sucursales)lstsucursales.get(i);
                    sucursalesDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    /* DOCUMENTOS PRINCIPALES -> descent*/
    public static String ACTION_SYNCRONIZE_ORDENSERVICIOCLIENTE  (String db,String response){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Gson gson = new Gson();
            Ordenservicioclientes ListInfo = gson.fromJson(response,Ordenservicioclientes.class);
            /*crear*/
            Ordenserviciocliente or;
            List<Ordenserviciocliente> lst = new ArrayList<>();
            for(Dato ob :ListInfo.getDatos()){
                or = new Ordenserviciocliente();
                or.setIdempresa(ob.getIdempresa());
                or.setIdordenservicio(ob.getIdordenservicio());
                or.setIddocumento(ob.getIddocumento());
                or.setSerie(ob.getSerie());
                or.setNumero(ob.getNumero());
                or.setNromanual(ob.getNromanual());
                or.setIdclieprov(ob.getIdclieprov());
                or.setFecha(dateFormat.parse(Conversionfecha(ob.getFecha())));
                or.setTipo_servicio(ob.getTipoServicio());
                or.setAmbito_servicio(ob.getAmbitoServicio());
                or.setIdestado(ob.getIdestado());
                or.setSincroniza(ob.getSincroniza());
                or.setFechacreacion(dateFormat.parse(Conversionfecha(ob.getFechacreacion())));
                or.setNrocontenedor(ob.getNrocontenedor());
                or.setNroprecinto(ob.getNroprecinto());
                or.setNro_oservicio(ob.getNroOservicio());
                or.setIdmotivo(ob.getIdmotivo());
                or.setGlosa(ob.getGlosa());
                or.setIdoperario(ob.getIdoperario());
                or.setIdoperario2(ob.getIdoperario2());
                or.setRazonsocial(ob.getRazonsocial());
                or.setEstado(ob.getEstado());
                or.setOperario(ob.getOperario());
                or.setOperario2(ob.getOperario2());


                lst.add(or);
            }
            if(!lst.isEmpty()){
                OrdenservicioclienteDao ordenservicioclienteDao = new OrdenservicioclienteDao();
                ordenservicioclienteDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Ordenserviciocliente obj= lst.get(i);
                    ordenservicioclienteDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE  (String db,String response){
        try {
           /* List<Dordenserviciocliente> lstdordenserviciocliente = (List<Dordenserviciocliente>) Util.stringObject("com.nisira.core.entity.Dordenserviciocliente",response);
            DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
            if(lstdordenserviciocliente!=null){
                dordenservicioclienteDao.borrar("IDEMPRESA = ?",lstdordenserviciocliente.get(0).getIdempresa());
                for(int i=0;i<lstdordenserviciocliente.size();i++){
                    Dordenserviciocliente obj= (Dordenserviciocliente)lstdordenserviciocliente.get(i);
                    dordenservicioclienteDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";*/

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            Gson gson = new Gson();
            Ordenservicioclientes ListInfo = gson.fromJson(response,Ordenservicioclientes.class);
            /*crear*/
            Dordenserviciocliente or;
            List<Dordenserviciocliente> lst = new ArrayList<>();
            for(Dato ob :ListInfo.getDatos()){
                or = new Dordenserviciocliente();
                or.setIdempresa(ob.getIdempresa());
                or.setIdordenservicio(ob.getIdordenservicio());
                or.setItem(ob.getItem());
                or.setIdvehiculo(ob.getIdvehiculo());
                or.setPlaca_cliente(ob.getPlaca_cliente());
                or.setHora_req(ob.getHora_req());
                if(ob.getFecha_fin_servicio()!=null)
                    or.setFecha_fin_servicio(dateFormat.parse(Conversionfecha(ob.getFecha_fin_servicio())));
                if(ob.getFechacreacion()!=null)
                    or.setFechacreacion(dateFormat.parse(Conversionfecha(ob.getFechacreacion())));
                or.setIdreferencia(ob.getIdreferencia());
                or.setItemreferencia(ob.getItemreferencia());
                or.setIdservicio(ob.getIdservicio());
                or.setConductor_cliente(ob.getConductor_cliente());
                or.setGlosa(ob.getGlosa());
                or.setHora_rc(ob.getHora_rc());
                or.setCodoperaciones(ob.getCodoperaciones());
                or.setIdruta_ec(ob.getIdruta_ec());
               // or.setIdconsumidor(ob.getIdconsumidor());
                or.setDescripcion_vehiculo(ob.getDescripcion_vehiculo());
                or.setDescripcion_servicio(ob.getDescripcion_servicio());

                lst.add(or);
            }
            if(!lst.isEmpty()){
                DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
                dordenservicioclienteDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Dordenserviciocliente obj= lst.get(i);
                    dordenservicioclienteDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_PERSONAL_SERVICIO (String db,String response){
        try {
          /**
            List<Personal_servicio> personal_servicios = (List<Personal_servicio>) Util.stringObject("com.nisira.core.entity.Personal_servicio",response);
            Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
            if(personal_servicios!=null){
                personal_servicioDao.borrar("IDEMPRESA = ?",personal_servicios.get(0).getIdempresa());
                for(int i=0;i<personal_servicios.size();i++){
                    Personal_servicio obj= (Personal_servicio)personal_servicios.get(i);
                    personal_servicioDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";**/

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            Gson gson = new Gson();
            Ordenservicioclientes ListInfo = gson.fromJson(response,Ordenservicioclientes.class);
            /*crear*/
            Personal_servicio or;
            List<Personal_servicio> lst = new ArrayList<>();
            for(Dato ob :ListInfo.getDatos()){
                or = new Personal_servicio();
                or.setIdempresa(ob.getIdempresa());
                or.setIdordenservicio(ob.getIdordenservicio());
                or.setItem(ob.getItem());
                or.setItem2(ob.getItem2());
                or.setIdpersonal(ob.getIdpersonal());
                or.setDni(ob.getDni());
                or.setNombres(ob.getNombres());
                if(ob.getFechaoperacion()!=null)
                or.setFechaoperacion(dateFormat.parse(Conversionfecha(ob.getFechaoperacion())));
                or.setIdcargo(ob.getIdcargo());
                if(ob.getFechafin()!=null)
                or.setFechafin(dateFormat.parse(Conversionfecha(ob.getFechafin())));
                or.setChecklist(ob.getChecklist());
                or.setIdvehiculo(ob.getIdvehiculo());
                or.setNrocontenedor(ob.getNrocontenedor());
                or.setNroprecinto(ob.getNroprecinto());
                or.setNro_oservicio(ob.getNroOservicio());
                or.setPlaca_cliente(ob.getPlaca_cliente());
                or.setConductor_cliente(ob.getConductor_cliente());
                or.setBrevete_cliente(ob.getBrevete_cliente());
                or.setDescripcion_vehiculo(ob.getDescripcion_vehiculo());
                or.setDescripcion_cargo(ob.getDescripcion_cargo());

                lst.add(or);
            }
            if(!lst.isEmpty()){
                Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
                personal_servicioDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Personal_servicio obj= lst.get(i);
                    personal_servicioDao.mezclarLocal(obj);
                }
                return "OK";

            }
            return "";

        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }

    public static String ACTION_SYNCRONIZE_DPERSONAL_SERVICIO (String db,String response){
        try {
            /***
            List<Dpersonal_servicio> dpersonal_servicios = (List<Dpersonal_servicio>) Util.stringObject("com.nisira.core.entity.Dpersonal_servicio",response);
            Dpersonal_servicioDao dpersonal_servicioDao = new Dpersonal_servicioDao();
            if(dpersonal_servicios!=null){
                dpersonal_servicioDao.borrar("IDEMPRESA = ?",dpersonal_servicios.get(0).getIdempresa());
                for(int i=0;i<dpersonal_servicios.size();i++){
                    Dpersonal_servicio obj= (Dpersonal_servicio)dpersonal_servicios.get(i);
                    dpersonal_servicioDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return ""; **/

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Gson gson = new Gson();
            Ordenservicioclientes ListInfo = gson.fromJson(response,Ordenservicioclientes.class);
            /*crear*/
            Dpersonal_servicio or;
            List<Dpersonal_servicio> lst = new ArrayList<>();
            for(Dato ob :ListInfo.getDatos()){
                or = new Dpersonal_servicio();
                or.setIdempresa(ob.getIdempresa());
                or.setIdordenservicio(ob.getIdordenservicio());
                or.setItem(ob.getItem());
                or.setItem2(ob.getItem2());
                or.setHora_req(ob.getHora_req());
                or.setHora_llegada(ob.getHora_llegada());
                or.setHora_inicio_serv(ob.getHora_inicio_serv());
                or.setHora_fin_serv(ob.getHora_fin_serv());
                or.setHora_liberacion(ob.getHora_liberacion());
                or.setIdcargo(ob.getIdcargo());
                if(ob.getFecharegistro()!=null)
                or.setFecharegistro(dateFormat.parse(Conversionfecha(ob.getFecharegistro())));
                if(ob.getFechafinregistro()!=null)
                or.setFechafinregistro(dateFormat.parse(Conversionfecha(ob.getFechafinregistro())));
                lst.add(or);
            }
            if(!lst.isEmpty()){
                Dpersonal_servicioDao dpersonal_servicioDao = new Dpersonal_servicioDao();
                dpersonal_servicioDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Dpersonal_servicio obj= lst.get(i);
                    dpersonal_servicioDao.mezclarLocal(obj);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_SYNCRONIZE_ORDENLIQUIDACIONGASTO  (String db,String response){
        try {
            /*
            List lstordenliquidaciongasto = (List<Ordenliquidaciongasto>) Util.stringObject("com.nisira.core.entity.Ordenliquidaciongasto",response);
            OrdenliquidaciongastoDao ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
            if(lstordenliquidaciongasto!=null){
                for(int i=0;i<lstordenliquidaciongasto.size();i++){
                    Ordenliquidaciongasto obj= (Ordenliquidaciongasto)lstordenliquidaciongasto.get(i);
                    ordenliquidaciongastoDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);*/
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Gson gson = new Gson();
            StructOrdenLiquidacionGastos ListInfo = gson.fromJson(response,StructOrdenLiquidacionGastos.class);
            /*crear*/
            Ordenliquidaciongasto obj;
            List<Ordenliquidaciongasto> lst = new ArrayList<>();
            for(DatosOrdenLiquidacionGastos ob :ListInfo.getDatos()){
                obj = new Ordenliquidaciongasto();
                obj.setIdempresa(ob.getIdempresa());
                obj.setIdorden(ob.getIdorden());
                obj.setIdemisor(ob.getIdemisor());
                obj.setPeriodo(ob.getPeriodo());
                if(ob.getFecharegistro()!=null)
                    obj.setFecharegistro(dateFormat.parse(Conversionfecha(ob.getFecharegistro())));
                obj.setIdsucursal(ob.getIdsucursal());
                obj.setIddocumento(ob.getIddocumento());
                obj.setSerie(ob.getSerie());
                obj.setNumero(ob.getNumero());
                if(ob.getFecha()!=null)
                    obj.setFecha(dateFormat.parse(Conversionfecha(ob.getFecha())));
                obj.setTcambio(ob.getTcambio());
                obj.setIdclieprov(ob.getIdclieprov());
                obj.setDireccion(ob.getDireccion());
                obj.setRuc(ob.getRuc());
                obj.setRazonsocial(ob.getRazonsocial());
                obj.setIdregimen(ob.getIdregimen());
                obj.setIdmoneda(ob.getIdmoneda());
                obj.setTcmoneda(ob.getTcmoneda());
                obj.setIdtipomov(ob.getIdtipomov());
                obj.setIdfpago(ob.getIdfpago());
                obj.setIdarea(ob.getIdarea());
                obj.setGlosa(ob.getGlosa());
                obj.setVventa(ob.getVventa());
                obj.setInafecto(ob.getInafecto());
                obj.setOtros(ob.getOtros());
                obj.setImpuesto(ob.getImpuesto());
                obj.setPimpuesto(ob.getPimpuesto());
                obj.setDescuento(ob.getDescuento());
                obj.setPdescuento(ob.getPdescuento());
                obj.setDescuentodoc(ob.getDescuentodoc());
                obj.setRedondeo(ob.getRedondeo());
                obj.setImporte(ob.getImporte());
                obj.setImportemof(ob.getImportemof());
                obj.setImportemex(ob.getImportemex());
                obj.setIdestado(ob.getIdestado());
                obj.setSincroniza(ob.getSincroniza());
                obj.setIgv(ob.getIgv());
                obj.setIdusuario(ob.getIdusuario());
                obj.setVentana(ob.getVventa().toString());
                if(ob.getFechacreacion()!=null)
                    obj.setFechacreacion(dateFormat.parse(Conversionfecha(ob.getFechacreacion())));

            }
            if(!lst.isEmpty()){
                OrdenliquidaciongastoDao ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
                ordenliquidaciongastoDao.borrar("IDEMPRESA = ?",lst.get(0).getIdempresa());
                for(int i=0;i<lst.size();i++){
                    Ordenliquidaciongasto obj1= lst.get(i);
                    ordenliquidaciongastoDao.mezclarLocal(obj1);
                }
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_DORDENLIQUIDACIONGASTO (String db,String response){
        try {
            List lstdordenliquidaciongasto = (List<Dordenliquidaciongasto>) Util.stringObject("com.nisira.core.entity.Dordenliquidaciongasto",response);
            DordenliquidaciongastoDao dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
            if(lstdordenliquidaciongasto!=null){
                for(int i=0;i<lstdordenliquidaciongasto.size();i++){
                    Dordenliquidaciongasto obj= (Dordenliquidaciongasto)lstdordenliquidaciongasto.get(i);
                    dordenliquidaciongastoDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_DESTINOADQUISICION  (String db,String response){
        try {
            List destinoadquisiciones = (List<Destinoadquisicion>) Util.stringObject("com.nisira.core.entity.Destinoadquisicion",response);
            DestinoadquisicionDao destinoadquisicionDao = new DestinoadquisicionDao();
            if(destinoadquisiciones!=null){
                for(int i=0;i<destinoadquisiciones.size();i++){
                    Destinoadquisicion obj= (Destinoadquisicion)destinoadquisiciones.get(i);
                    destinoadquisicionDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_TIPOGASTO (String db,String response){
        try {
            List tipogastos = (List<Tipogasto>) Util.stringObject("com.nisira.core.entity.Tipogasto",response);
            TipogastoDao tipogastosDao = new TipogastoDao();
            if(tipogastos!=null){
                for(int i=0;i<tipogastos.size();i++){
                    Tipogasto obj= (Tipogasto)tipogastos.get(i);
                    tipogastosDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }

    public static String ACTION_SYNCRONIZE_CODOPERACIONES (String db,String response){
        try {
            List codoperaciones = (List<Codoperaciones_pss>) Util.stringObject("com.nisira.core.entity.Codoperaciones_pss",response);
            Codoperaciones_pssDao codoDao = new Codoperaciones_pssDao();
            if(codoperaciones!=null){
                for(int i=0;i<codoperaciones.size();i++){
                    Codoperaciones_pss obj= (Codoperaciones_pss)codoperaciones.get(i);
                    codoDao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }
    public static String ACTION_SYNCRONIZE_ESTRUCTURA_COSTO_PRODUCTO(String db,String response){
        try {
            List estructuraList = (List<Estructura_costos_producto>) Util.stringObject("com.nisira.core.entity.Estructura_costos_producto",response);
            Estructura_costos_productoDao estructuradao = new Estructura_costos_productoDao();
            if(estructuraList!=null){
                for(int i=0;i<estructuraList.size();i++){
                    Estructura_costos_producto obj= (Estructura_costos_producto)estructuraList.get(i);
                    estructuradao.mezclarLocal(obj);
                }
                //boolean request= (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
//            if(VERERRORESSINCRONIZACION==1)
//            {
//                return e.toString();
//            }
//            else
//            {
//                return "Error de conectividad, Intente de nuevo";
//            }
        }
    }

    /* DOCUMENTOS PRINCIPALES -> ascent*/
    public static String ACTION_ASCENT_ORDENSERVICIOCLIENTE  (String db){
        try {
            OrdenservicioclienteDao ordenservicioclienteDao = new OrdenservicioclienteDao();
            List lstordenserviciocliente = ordenservicioclienteDao.listar();
            String xml_ordenserviciocliente = Util.objectXml("com.nisira.core.entity.Ordenserviciocliente", lstordenserviciocliente);
            if(xml_ordenserviciocliente!=null){
                return xml_ordenserviciocliente;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_DORDENSERVICIOCLIENTE  (String db){
        try {
            DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
            List lstdordenserviciocliente = dordenservicioclienteDao.listar();
            String xml_dordenserviciocliente = Util.objectXml("com.nisira.core.entity.Dordenserviciocliente", lstdordenserviciocliente);
            if(xml_dordenserviciocliente!=null){
                return xml_dordenserviciocliente;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_PERSONAL_SERVICIO (String db){
        try {
            Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
            List personal_servicios = personal_servicioDao.listar();
            String xml_personal_servicio = Util.objectXml("com.nisira.core.entity.Personal_servicio", personal_servicios);
            if(xml_personal_servicio!=null){
                return xml_personal_servicio;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_DPERSONAL_SERVICIO (String db){
        try {
            Dpersonal_servicioDao dpersonal_servicioDao = new Dpersonal_servicioDao();
            List dpersonal_servicios = dpersonal_servicioDao.listar();
            String xml_dpersonal_servicios = Util.objectXml("com.nisira.core.entity.Dpersonal_servicio", dpersonal_servicios);
            if(xml_dpersonal_servicios!=null){
                return xml_dpersonal_servicios;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_ORDENLIQUIDACIONGASTO  (String db){
        try {
            OrdenliquidaciongastoDao ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
            List lstordenliquidaciongasto = ordenliquidaciongastoDao.listar();
            String xml_ordenliquidaciongasto = Util.objectXml("com.nisira.core.entity.Ordenliquidaciongasto", lstordenliquidaciongasto);
            if(xml_ordenliquidaciongasto!=null){
                return xml_ordenliquidaciongasto;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_ORDENLIQUIDACIONGASTOxID  (String db,Ordenliquidaciongasto od){
        try {
            OrdenliquidaciongastoDao ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
            List lstordenliquidaciongasto = new ArrayList();
            lstordenliquidaciongasto.add(od);
            String xml_ordenliquidaciongasto = Util.objectXml("com.nisira.core.entity.Ordenliquidaciongasto", lstordenliquidaciongasto);
            if(xml_ordenliquidaciongasto!=null){
                return xml_ordenliquidaciongasto;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }


    public static String ACTION_ASCENT_DORDENLIQUIDACIONGASTO (String db){
        try {
            DordenliquidaciongastoDao dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
            List lstdordenliquidaciongasto = dordenliquidaciongastoDao.listar();
            String xml_ordenliquidaciongasto = Util.objectXml("com.nisira.core.entity.Dordenliquidaciongasto", lstdordenliquidaciongasto);
            if(xml_ordenliquidaciongasto!=null){
                return xml_ordenliquidaciongasto;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
    public static String ACTION_ASCENT_DESTINOADQUISICION  (String db){
        try {
            DestinoadquisicionDao destinoadquisicionDao = new DestinoadquisicionDao();
            List destinoadquisiciones = destinoadquisicionDao.listar();
            String xml_ordenliquidaciongasto = Util.objectXml("com.nisira.core.entity.Destinoadquisicion", destinoadquisiciones);
            if(xml_ordenliquidaciongasto!=null){
                return xml_ordenliquidaciongasto;
            }
            return "";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    public static  String Conversionfecha(String fecha){
        String result="";
        String mes="";
        String dia="";
        String anio="";
        String mesnum="";

        try{
            if(fecha!="") {
                if (fecha.length() == 11) {
                    mes = fecha.substring(0, 3);
                    dia = fecha.substring(4, 5);
                    anio = fecha.substring(7, 11);

                } else {
                    mes = fecha.substring(0, 3);
                    dia = fecha.substring(4, 6);
                    anio = fecha.substring(8, 12);
                }
                switch(mes){
                    case "ene":
                    {
                        mesnum="01";
                        break;
                    }
                    case "feb":
                    {
                        mesnum="02";
                        break;
                    }
                    case "mar":
                    {
                        mesnum="03";
                        break;
                    }
                    case "abr":
                    {
                        mesnum="04";
                        break;
                    }
                    case "may":
                    {
                        mesnum="05";
                        break;
                    }
                    case "jun":
                    {
                        mesnum="06";
                        break;
                    }
                    case "jul":
                    {
                        mesnum="07";
                        break;
                    }
                    case "ago":
                    {
                        mesnum="08";
                        break;
                    }
                    case "sep":
                    {
                        mesnum="09";
                        break;
                    }
                    case "oct":
                    {
                        mesnum="10";
                        break;
                    }
                    case "nov":
                    {
                        mesnum="11";
                        break;
                    }
                    case "dic":
                    {
                        mesnum="12";
                        break;
                    }
                    default:
                    {
                        mesnum="01";
                        break;
                    }
                }

                result= anio+"-"+mesnum+"-"+dia;

            }
            else{
                result=null;
            }

        }catch(Exception ex){}

        return result;
    }

}
