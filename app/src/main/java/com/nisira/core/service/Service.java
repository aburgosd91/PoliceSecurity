package com.nisira.core.service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aburgos on 06/01/2017.
 */

public class Service {
    /*
        CONSTANTES
    */
    static final String[] lst_url={
            "http://10.250.50.88:8080/service/WebServiceNisira?wsdl",
            "http://190.102.145.230:8080/service/WebServiceNisira?wsdl"

    };
    static final String URL="http://190.102.145.230:8080/WebServiceNisira?wsdl";/*FUERA DE OFICINA*/
    //static final String URL="http://10.250.50.88:8080/WebServiceNisira?wsdl";/*DENTRO DE OFICINA*/
    static final String NAMESPACE="http://webservice/";
    static final Integer timeout_=10*1000;
    /*
        CONFIGURACIONES
    */
    private String METHOD;
    private String SOAP_ACTION="";
    /****************************************************/
    private Context context;
    private Service service;
    public Service(Context context){
        this.context = context;
    }

    public Object requestObject(String URL,String METHOD_NAME, HashMap params,int timeout) throws IOException, XmlPullParserException {
        //String ip = executeCmd("ping -c 1 -w 1 190.102.145.230:8080/", false);
        SOAP_ACTION = NAMESPACE+METHOD_NAME;
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); /*DECLARACION SOAP*/
        /*ATRIBUTOS*/
        Iterator entries = params.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            request.addProperty((String)entry.getKey(),entry.getValue().toString());
        }
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE ht = new HttpTransportSE(URL,timeout*1000);
        /***************************CORRIGE ERROR DE CONECTIVIDAD***********************************/
        ArrayList<HeaderProperty> headerPropertyArrayList = new ArrayList<HeaderProperty>();
        headerPropertyArrayList.add(new HeaderProperty("Connection", "close"));
        ht.call(SOAP_ACTION, envelope,headerPropertyArrayList);
        /*****************************************************************************************/
        SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
        if(response==null)return null;
        return response.toString();
    }

    public static String executeCmd(String cmd, boolean sudo){
        try {
            Process p;
            if(!sudo)
                p= Runtime.getRuntime().exec(cmd);
            else{
                p= Runtime.getRuntime().exec(new String[]{"su", "-c", cmd});
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String s;
            String res = "";
            while ((s = stdInput.readLine()) != null) {
                res += s + "\n";
            }
            p.destroy();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }
    /*determinar el tipo de red si es WiFi */
    public static boolean isConnectedWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
    /* determinar el tipo de red si es movil */
    public static boolean isConnectedMobile(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }


    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
