package com.nisira.core.service;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.nisira.core.database.DataBaseClass;
import com.nisira.core.entity.Basedatos;
import com.nisira.core.interfaces.ActivityNisira;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.interfaces.FragmentNisira;

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
    private int timeout;
//    private Empresa WSEmpresa;
//    private Usuario WSUsuario;


    public ConsumerService(Activity activity, Context context, String method, Integer parametro_timeout,boolean _method_syncronize) {
        this.context1 = context;
        this.activity =activity;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.URL);
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
        this.setSyncronize(_method_syncronize);
        this.timeout=parametro_timeout;
    }
    public ConsumerService(Activity activity, Context context, String method, Integer parametro_timeout) {
        this.context1 = context;
        this.activity =activity;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.URL);
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
        this.setSyncronize(false);
        this.timeout=parametro_timeout;
    }
    public ConsumerService(Fragment fragment, Context context, String method, Integer parametro_timeout) {
        this.context1 = context;
        this.fragment =fragment;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.URL);
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
        this.setSyncronize(false);
        this.timeout=parametro_timeout;
    }
    public ConsumerService(Fragment fragment, Context context, String method, Integer parametro_timeout,boolean _method_syncronize) {
        this.context1 = context;
        this.fragment =fragment;
        this.setMethod(method);
        this.ws =new Service(context);
        this.setAttribute(new LinkedHashMap());
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setWsurl(Service.URL);
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
        this.setSyncronize(_method_syncronize);
        this.timeout=parametro_timeout;
    }

    //protected Integer doInBackground(String... args) {
    protected String doInBackground(String... args) {
        try {
            String trama = "",zip="";
            switch (getMethod().trim()){
                case TypeMethod.METHOD_VERIFICATION_USER           :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_VERIFICATION_USER, getAttribute(),this.timeout);
                    response = ActionService.ACTION_VERIFICATION_USER(WSBasedatos.getIdbasedatos(),trama);
                    break;
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
                case TypeMethod.METHOD_LIST_PERSONAL_SERVICIO       :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_PERSONAL_SERVICIO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_PERSONAL_SERVICIO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO       :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DPERSONAL_SERVICIO, getAttribute(),this.timeout);
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
                case TypeMethod.METHOD_LIST_ORDENSERVICIOCLIENTE    :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_ORDENSERVICIOCLIENTE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_ORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO  :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDENLIQUIDACIONGASTO, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DORDENLIQUIDACIONGASTO(WSBasedatos.getIdbasedatos(),trama);break;
                case TypeMethod.METHOD_LIST_DORDENSERVICIOCLIENTE   :
                    trama = (String)ws.requestObject(WSBasedatos.getWsurl(), TypeMethod.METHOD_LIST_DORDENSERVICIOCLIENTE, getAttribute(),this.timeout);
                    response = ActionService.ACTION_SYNCRONIZE_DORDENSERVICIOCLIENTE(WSBasedatos.getIdbasedatos(),trama);break;
            }
        } catch (IOException | XmlPullParserException e) {
            response = e.getMessage();
            e.printStackTrace();
        }
        //return 1;
        return response;
    }
    //protected void onPostExecute(Object result) {
    public void onPostExecute(String result) {
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
}

