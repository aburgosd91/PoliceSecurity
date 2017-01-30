package com.nisira.core.service;
import android.content.Context;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
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
    static final String URL="http://69.64.88.9:8080/WebServiceNisira?wsdl";
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
