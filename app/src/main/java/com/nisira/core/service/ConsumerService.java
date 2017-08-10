package com.nisira.core.service;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;

import com.nisira.core.database.DataBaseClass;
import com.nisira.core.entity.Basedatos;
import com.nisira.core.entity.Usuario;
import com.nisira.core.interfaces.ActivityNisira;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.util.Util;
import com.nisira.view.Inicio;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

//public class ConsumerService extends AsyncTaskService<String, Void, Integer> {
public class ConsumerService extends AsyncTask<String, Void, String> {
    private final Context context1;
    private Activity activity;
    private Fragment fragment;
    String response = "";
    public ProgressDialog pd;
    private String method;
    private Service ws;
    private LinkedHashMap attribute;
    private Basedatos WSBasedatos;
    private boolean syncronize;
    private int type_syncronize;
    private int timeout;
    private Usuario user_session ;
//    private Empresa WSEmpresa;
//    private Usuario WSUsuario;


    public ConsumerService(Activity activity, Context context, String method, Integer parametro_timeout,boolean _method_syncronize, int type_syncronize) {
        this.context1 = context;
        this.activity =activity;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.lst_url[0]);
        WSBasedatos.setIdbasedatosconexion("PSS");
        this.setSyncronize(_method_syncronize);
        this.type_syncronize=type_syncronize;
        this.timeout=parametro_timeout;
        this.user_session = Util.session_object(context1);
    }
    public ConsumerService(Activity activity, Context context, String method, Integer parametro_timeout) {
        this.context1 = context;
        this.activity =activity;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.lst_url[0]);
        WSBasedatos.setIdbasedatosconexion("PSS");
        this.setSyncronize(false);
        this.timeout=parametro_timeout;
        this.user_session = Util.session_object(context1);
    }
    public ConsumerService(Fragment fragment, Context context, String method, Integer parametro_timeout) {
        this.context1 = context;
        this.fragment =fragment;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.lst_url[0]);
        WSBasedatos.setIdbasedatosconexion("PSS");
        this.setSyncronize(false);
        this.timeout=parametro_timeout;
        this.user_session = Util.session_object(context1);
    }
    public ConsumerService(Fragment fragment, Context context, String method, Integer parametro_timeout,boolean _method_syncronize) {
        this.context1 = context;
        this.fragment =fragment;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.lst_url[0]);
        WSBasedatos.setIdbasedatosconexion("PSS");
        this.setSyncronize(_method_syncronize);
        this.timeout=parametro_timeout;
        this.user_session = Util.session_object(context1);
    }

    //protected Integer doInBackground(String... args) {
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected String doInBackground(String... args) {
        String trama = "";
        try {
            switch (getMethod().trim()){
                case TypeMethod.METHOD_VERIFICATION_USER           :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_VERIFICATION_USER, getAttribute(),this.timeout);
                    response = ActionService.ACTION_VERIFICATION_USER(WSBasedatos.getIdbasedatos(),trama);
                    break;
                case TypeMethod.METHOD_VERIFICATION_APPMOVILUSUARIO                :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_VERIFICATION_APPMOVILUSUARIO, getAttribute(),this.timeout);
                    //trama = Utilitarios.getXml(DataBaseClass.FOLDER_BASE_APP,zip);
                    response = ActionService.ACTION_VERIFICATION_USER(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_CLIEPROV                :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CLIEPROV, getAttribute(),this.timeout);
                    //trama = Utilitarios.getXml(DataBaseClass.FOLDER_BASE_APP,zip);
                    response = ActionService.ACTION_SYNCRONIZE_CLIEPROV(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_CONSUMIDOR              :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CONSUMIDOR, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_CONSUMIDOR(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_CARGOS_PERSONAL         :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CARGOS_PERSONAL, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_CARGOS_PERSONAL(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_CONCEPTO_CUENTA         :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CONCEPTO_CUENTA, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_CONCEPTO_CUENTA(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DESTINOADQUISICION      :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DESTINOADQUISICION, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DESTINOADQUISICION(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DOCUMENTOS              :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DOCUMENTOS, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DOCUMENTOS(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_NUMEMISOR               :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_NUMEMISOR, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_NUMEMISOR(WSBasedatos.getIdbasedatos(),trama);break;

                case TypeMethod.METHOD_LIST_PRODUCTOS               :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_PRODUCTOS, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_PRODUCTOS(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_RUTAS                   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_RUTAS, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_RUTAS(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_SUCURSALES              :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_SUCURSALES, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_SUCURSALES(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_ORDENLIQUIDACIONGASTO   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_ORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos(),trama);break;
              // CAMBIO ADD IDUSUARIO
                case TypeMethod.METHOD_LIST_ORDEN_SERVICIO_PENDIENTE    :
                    getAttribute().put("user",user_session.getIdusuario());
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ORDEN_SERVICIO_PENDIENTE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_ORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO  :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DORDEN_SERVICIO_PENDIENTE   :
                    getAttribute().put("user",user_session.getIdusuario());
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDEN_SERVICIO_PENDIENTE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_PERSONAL_SERVICIO_FREE       :
                    getAttribute().put("user",user_session.getIdusuario());
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_PERSONAL_SERVICIO_FREE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_PERSONAL_SERVICIO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO_FREE       :
                    getAttribute().put("user",user_session.getIdusuario());
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO_FREE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DPERSONAL_SERVICIO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_TIPOGASTO   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_TIPOGASTO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_TIPOGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_CODOPERACIONES   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CODOPERACIONES, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_CODOPERACIONES(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_ESTRUCTURA_COSTO_PRODUCTO :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ESTRUCTURA_COSTO_PRODUCTO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_ESTRUCTURA_COSTO_PRODUCTO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_WEB_RETURNID   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_WEB_RETURNID, getAttribute(),this.timeout);
                    response = trama;//ActionService.ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                    break;
                /*************************************************SINCRONIZACION***********************************************/
                case TypeMethod.METHOD_ASCENT_ORDENSERVICIOCLIENTE    :
                    trama = ActionService.ACTION_ASCENT_ORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos());
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENSERVICIOCLIENTE, getAttribute(),this.timeout);break;
                case TypeMethod.METHOD_ASCENT_DORDENSERVICIOCLIENTE   :
                    trama = ActionService.ACTION_ASCENT_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos());
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENSERVICIOCLIENTE, getAttribute(),this.timeout);break;
                case TypeMethod.METHOD_ASCENT_PERSONAL_SERVICIO       :
                    trama = ActionService.ACTION_ASCENT_PERSONAL_SERVICIO(WSBasedatos.getIdbasedatos());
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_PERSONAL_SERVICIO, getAttribute(),this.timeout);break;
                case TypeMethod.METHOD_ASCENT_DPERSONAL_SERVICIO       :
                    trama = ActionService.ACTION_ASCENT_DPERSONAL_SERVICIO(WSBasedatos.getIdbasedatos());
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DPERSONAL_SERVICIO, getAttribute(),this.timeout);break;
               /* case TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO   :
                    trama = ActionService.ACTION_ASCENT_ORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos());
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);break;
                case TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO  :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                    if(!trama.equals("")) {
                        getAttribute().put("datos", trama);
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);break;
                */
                case TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO2  :
                    //trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                    if(!trama.equals("")) {
                        //NECESITA "lista1" -> OLG y "lista2" -> DOLG
                        getAttribute().put("user", user_session.getIdusuario());
                    }
                    response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO2, getAttribute(),this.timeout);break;
            }
        } catch (IOException | XmlPullParserException e) {
            try {
                WSBasedatos.setWsurl(Service.lst_url[1]);
                switch (getMethod().trim()){
                    case TypeMethod.METHOD_VERIFICATION_USER           :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_VERIFICATION_USER, getAttribute(),this.timeout);
                        response = ActionService.ACTION_VERIFICATION_USER(WSBasedatos.getIdbasedatos(),trama);
                        break;
                    case TypeMethod.METHOD_VERIFICATION_APPMOVILUSUARIO                :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_VERIFICATION_APPMOVILUSUARIO, getAttribute(),this.timeout);
                        //trama = Utilitarios.getXml(DataBaseClass.FOLDER_BASE_APP,zip);
                        response = ActionService.ACTION_VERIFICATION_USER(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_CLIEPROV                :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CLIEPROV, getAttribute(),this.timeout);
                        //trama = Utilitarios.getXml(DataBaseClass.FOLDER_BASE_APP,zip);
                        response = ActionService.ACTION_SYNCRONIZE_CLIEPROV(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_CONSUMIDOR              :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CONSUMIDOR, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_CONSUMIDOR(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_CARGOS_PERSONAL         :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CARGOS_PERSONAL, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_CARGOS_PERSONAL(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_CONCEPTO_CUENTA         :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CONCEPTO_CUENTA, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_CONCEPTO_CUENTA(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_DESTINOADQUISICION      :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DESTINOADQUISICION, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_DESTINOADQUISICION(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_DOCUMENTOS              :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DOCUMENTOS, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_DOCUMENTOS(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_NUMEMISOR               :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_NUMEMISOR, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_NUMEMISOR(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_PERSONAL_SERVICIO_FREE       :
                        getAttribute().put("user",user_session.getIdusuario());
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_PERSONAL_SERVICIO_FREE, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_PERSONAL_SERVICIO(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO_FREE       :
                        getAttribute().put("user",user_session.getIdusuario());
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO_FREE, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_DPERSONAL_SERVICIO(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_PRODUCTOS               :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_PRODUCTOS, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_PRODUCTOS(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_RUTAS                   :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_RUTAS, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_RUTAS(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_SUCURSALES              :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_SUCURSALES, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_SUCURSALES(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_ORDENLIQUIDACIONGASTO   :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_ORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_ORDEN_SERVICIO_PENDIENTE    :
                        getAttribute().put("user",user_session.getIdusuario());
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ORDEN_SERVICIO_PENDIENTE, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_ORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO  :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_DORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_DORDEN_SERVICIO_PENDIENTE   :
                        getAttribute().put("user",user_session.getIdusuario());
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDEN_SERVICIO_PENDIENTE, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_TIPOGASTO   :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_TIPOGASTO, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_TIPOGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_CODOPERACIONES   :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_CODOPERACIONES, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_CODOPERACIONES(WSBasedatos.getIdbasedatos(),trama);break;
                    case TypeMethod.METHOD_LIST_ESTRUCTURA_COSTO_PRODUCTO :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ESTRUCTURA_COSTO_PRODUCTO, getAttribute(),this.timeout);
                        response = ActionService.ACTION_SYNCRONIZE_ESTRUCTURA_COSTO_PRODUCTO(WSBasedatos.getIdbasedatos(),trama);break;

                    /*************************************************SINCRONIZACION***********************************************/
                    case TypeMethod.METHOD_WEB_RETURNID :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_WEB_RETURNID, getAttribute(),this.timeout);
                        response = trama;
                        break;
                    case TypeMethod.METHOD_ASCENT_ORDENSERVICIOCLIENTE    :
                        trama = ActionService.ACTION_ASCENT_ORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos());
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENSERVICIOCLIENTE, getAttribute(),this.timeout);break;
                    case TypeMethod.METHOD_ASCENT_DORDENSERVICIOCLIENTE   :
                        trama = ActionService.ACTION_ASCENT_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos());
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENSERVICIOCLIENTE, getAttribute(),this.timeout);break;
                    case TypeMethod.METHOD_ASCENT_PERSONAL_SERVICIO       :
                        trama = ActionService.ACTION_ASCENT_PERSONAL_SERVICIO(WSBasedatos.getIdbasedatos());
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_PERSONAL_SERVICIO, getAttribute(),this.timeout);break;
                    case TypeMethod.METHOD_ASCENT_DPERSONAL_SERVICIO       :
                        trama = ActionService.ACTION_ASCENT_DPERSONAL_SERVICIO(WSBasedatos.getIdbasedatos());
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DPERSONAL_SERVICIO, getAttribute(),this.timeout);break;
                    /*case TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO   :
                        trama = ActionService.ACTION_ASCENT_ORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos());
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);break;
                    case TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO  :
                        trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                        if(!trama.equals("")) {
                            getAttribute().put("datos", trama);
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);break;
                        */
                    case TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO2  :
                        //trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                        if(!trama.equals("")) {
                            //NECESITA "lista1" -> OLG y "lista2" -> DOLG
                            getAttribute().put("user", user_session.getIdusuario());
                        }
                        response = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO2, getAttribute(),this.timeout);break;
                }
            }catch (IOException | XmlPullParserException e1) {
                response = e1.getMessage();
                e1.printStackTrace();
            }
        }
        return response;
    }
    //protected void onPostExecute(Object result) {
    public void onPostExecute(String result) {
        if(pd!=null)
            pd.dismiss();

        if(response.trim().contains("failed to connect to") ){
            response = "ERROR: No se puede conectar con NISIRA ERP.";
        }
        if(response.trim().contains("status: 404") ){
            response = "ERROR: Los Servicios Web están inactivos.";
        }

        if(getMethod().compareTo("getVerificarActualizacion") == 0)
        {
            if(response.trim().compareTo("Error de conectividad, Intente de nuevo")==0 || response == null)
            {
                //VerificarVersion(context1, "Error de conectividad, Intente de nuevo");
                super.onPostExecute(result);
                return;
            }
            else{
                //VerificarVersion(context1, res);
                super.onPostExecute(result);
                return;
            }
        }
        try {
            ((ActivityNisira) (activity)).onPostExecuteWebService(ConsumerService.this, response);
        }catch (Exception ex){
            try {
                ((ActivityNisiraCompat) (activity)).onPostExecuteWebService(ConsumerService.this, response);
            }catch (Exception ex2){
                ((FragmentNisira)(fragment)).onPostExecuteWebService(ConsumerService.this, response);
            }
        }
        super.onPostExecute(result);

    }

    public HashMap getAttribute() {
        return attribute;
    }

    public void setAttribute(LinkedHashMap attribute) {
        this.attribute = attribute;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isSyncronize() {
        return syncronize;
    }

    public void setSyncronize(boolean syncronize) {
        this.syncronize = syncronize;
    }

    public int getType_syncronize() {
        return type_syncronize;
    }

    public void setType_syncronize(int type_syncronize) {
        this.type_syncronize = type_syncronize;
    }
}

