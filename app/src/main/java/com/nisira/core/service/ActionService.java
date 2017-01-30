package com.nisira.core.service;

import android.util.Log;

import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.ProductosDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Productos;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Sucursales;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.Util;

import java.util.Date;
import java.util.List;

/**
 * Created by aburgos on 06/01/2017.
 */

public class ActionService {

    public static String ACTION_VERIFICATION_USER (String db,String response){
        try {
            Usuario usuario = (Usuario) Util.stringObject("com.nisira.core.entity.Usuario",response);
            if(usuario!=null){
                //boolean request= (new UsuarioDao()).insertar(usuario);
                usuario.setFechacreacion(new Date());
                usuario.setEstado(1);
//                (new UsuarioDao()).insertar(usuario);
                return "OK";
            }
            return "";
        }
        catch (Exception e)
        {
            Log.i("ActionService ->",e.getMessage());
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
            List consumidores = (List<Consumidor>) Util.stringObject("com.nisira.core.entity.Consumidor",response);
            ConsumidorDao consumidorDao = new ConsumidorDao();
            if(consumidores!=null){
                for(int i=0;i<consumidores.size();i++){
                    Consumidor obj= (Consumidor)consumidores.get(i);
                    consumidorDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_CARGOS_PERSONAL (String db,String response){
        try {
            List cargos_personals = (List<Cargos_personal>) Util.stringObject("com.nisira.core.entity.Cargos_personal",response);
            Cargos_personalDao cargos_personalDao = new Cargos_personalDao();
            if(cargos_personals!=null){
                for(int i=0;i<cargos_personals.size();i++){
                    Cargos_personal obj= (Cargos_personal)cargos_personals.get(i);
                    cargos_personalDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_CONCEPTO_CUENTA (String db,String response){
        try {
            List concepto_cuentas = (List<Concepto_cuenta>) Util.stringObject("com.nisira.core.entity.Concepto_cuenta",response);
            Concepto_cuentaDao concepto_cuentaDao = new Concepto_cuentaDao();
            if(concepto_cuentas!=null){
                for(int i=0;i<concepto_cuentas.size();i++){
                    Concepto_cuenta obj= (Concepto_cuenta)concepto_cuentas.get(i);
                    concepto_cuentaDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_DOCUMENTOS (String db,String response){
        try {
            List<Documentos> lstdocumentos = (List<Documentos>) Util.stringObject("com.nisira.core.entity.Documentos",response);
            DocumentosDao documentosDao = new DocumentosDao();
            if(lstdocumentos!=null){
                for(int i=0;i<lstdocumentos.size();i++){
                    Documentos obj= (Documentos)lstdocumentos.get(i);
                    documentosDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_PERSONAL_SERVICIO (String db,String response){
        try {
            List personal_servicios = (List<Personal_servicio>) Util.stringObject("com.nisira.core.entity.Personal_servicio",response);
            Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
            if(personal_servicios!=null){
                for(int i=0;i<personal_servicios.size();i++){
                    Personal_servicio obj= (Personal_servicio)personal_servicios.get(i);
                    personal_servicioDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_DPERSONAL_SERVICIO (String db,String response){
        try {
            List dpersonal_servicios = (List<Dpersonal_servicio>) Util.stringObject("com.nisira.core.entity.Dpersonal_servicio",response);
            Dpersonal_servicioDao dpersonal_servicioDao = new Dpersonal_servicioDao();
            if(dpersonal_servicios!=null){
                for(int i=0;i<dpersonal_servicios.size();i++){
                    Dpersonal_servicio obj= (Dpersonal_servicio)dpersonal_servicios.get(i);
                    dpersonal_servicioDao.mezclarLocal(obj);
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
            List lstsucursales = (List<Sucursales>) Util.stringObject("com.nisira.core.entity.Sucursales",response);
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
    /* DOCUMENTOS PRINCIPALES*/
    public static String ACTION_SYNCRONIZE_ORDENSERVICIOCLIENTE  (String db,String response){
        try {
            List lstordenserviciocliente = (List<Ordenserviciocliente>) Util.stringObject("com.nisira.core.entity.Ordenserviciocliente",response);
            OrdenservicioclienteDao ordenservicioclienteDao = new OrdenservicioclienteDao();
            if(lstordenserviciocliente!=null){
                for(int i=0;i<lstordenserviciocliente.size();i++){
                    Ordenserviciocliente obj= (Ordenserviciocliente)lstordenserviciocliente.get(i);
                    ordenservicioclienteDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE  (String db,String response){
        try {
            List lstdordenserviciocliente = (List<Dordenserviciocliente>) Util.stringObject("com.nisira.core.entity.Dordenserviciocliente",response);
            DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
            if(lstdordenserviciocliente!=null){
                for(int i=0;i<lstdordenserviciocliente.size();i++){
                    Dordenserviciocliente obj= (Dordenserviciocliente)lstdordenserviciocliente.get(i);
                    dordenservicioclienteDao.mezclarLocal(obj);
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
    public static String ACTION_SYNCRONIZE_ORDENLIQUIDACIONGASTO  (String db,String response){
        try {
            List lstordenliquidaciongasto = (List<Ordenliquidaciongasto>) Util.stringObject("com.nisira.core.entity.Ordenliquidaciongasto",response);
            OrdenliquidaciongastoDao ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
            if(lstordenliquidaciongasto!=null){
                for(int i=0;i<lstordenliquidaciongasto.size();i++){
                    Ordenliquidaciongasto obj= (Ordenliquidaciongasto)lstordenliquidaciongasto.get(i);
                    ordenliquidaciongastoDao.mezclarLocal(obj);
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

}
