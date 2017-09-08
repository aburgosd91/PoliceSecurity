package com.nisira.core.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nisira.core.entity.Usuario;
import com.nisira.gcalderon.policesecurity.R;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * Created by vzavala on 08/11/2016.
 */

public final class Util {
    private static Integer confirmacion;

    public static boolean isOnLine(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static void msgbox(Activity activity, String mensaje, String titulo){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(mensaje)
                .setTitle( Html.fromHtml("<font color='"+activity.getResources().getColor(R.color.colorPrimary)+"'>"+titulo+"</font>"))
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public static AlertDialog msgboxConfirmacion(Activity activity, String mensaje, String titulo){
        confirmacion = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(mensaje.toString())
                .setTitle( Html.fromHtml("<font color='"+activity.getResources().getColor(R.color.colorPrimary)+"'>"+titulo+"</font>"))
                .setCancelable(false)
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

        final AlertDialog alert = builder.create();
        alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        alert.show();
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmacion = 1;
                alert.dismiss();
            }
        });

        alert.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmacion = -1;
                alert.dismiss();
            }
        });

        return alert;


    }

    /************************ AGREGADO by aburgos ***************************/
    public static Object stringObject(String _class, String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        XStream xstream= new XStream(){
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        try {
                            return definedIn != Object.class || realClass(fieldName) != null;
                        } catch (CannotResolveClassException cnrce) {
                            return false;
                        }
                    }
                };
            }
        };
        xstream.processAnnotations(oClase);
        Object object = (Object)xstream.fromXML(obj);
        return object;
    }
    public static List<? extends Object> stringListObject(String _class, String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        XStream xstream= new XStream(){
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        try {
                            return definedIn != Object.class || realClass(fieldName) != null;
                        } catch (CannotResolveClassException cnrce) {
                            return false;
                        }
                    }
                };
            }
        };
        xstream.processAnnotations(oClase);
        List<? extends Object> object = (List<? extends Object>)xstream.fromXML(obj);
        return object;
    }
    public static Object stringGson(String _class,String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        Gson gson = new Gson();
        Object object = (Object)gson.fromJson(obj, oClase);
        return object;
    }
    public static List<? extends Object> stringListGson(String _class,String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        Gson gson = new Gson();
        List<? extends Object> object = (List<? extends Object>)gson.fromJson(obj, oClase);
        return object;
    }

    public static float convertTimeDecimal(String time){
        if(time.equals("")) return Float.parseFloat(null);
        float timeF=0.0f;
        String[] parts = time.split(":");
        int hora= Integer.parseInt(parts[0]);
        int minutos= Integer.parseInt(parts[1]);
        timeF=((float)hora)+((float)minutos/(float)60);
        return Math.round(timeF*100.0f)/100.0f;
    }
    public static String convertDecimalTime(double timeF){
        String obj;
        int hora = (int)timeF;
        int minutos = (int)((timeF-(float)hora)*60);
        if(minutos==6)
            obj= hora+":"+minutos+"0";
        else
            obj= hora+":"+minutos;
        return obj;
    }
    public static String objectGson(int total,Object obj){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return "{\"total\":"+total+",\"datos\":"+gson.toJson(obj)+"}";
    }
    public static String objectGson(Object obj){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }
    public static String objectXml(String _class,Object obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        String xml="<?xml version='1.0' encoding='ISO-8859-1'?>";

        XStream xStream= new XStream(){
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        try {
                            return definedIn != Object.class || realClass(fieldName) != null;
                        } catch (CannotResolveClassException cnrce) {
                            return false;
                        }
                    }
                };
            }
        };
        xStream.processAnnotations(oClase);
        return xml+xStream.toXML(obj);
    }
    public static String idGeneradoTres(int id){
        if(id<10) return "00"+id;
        else if(id<100) return "0"+id;
        else return String.valueOf(id);
    }
    public static Usuario session_object(Context context1){
        Usuario user_session = new Usuario();
        SharedPreferences prefs = context1.getSharedPreferences("USER_SESSION", context1.MODE_PRIVATE);
        user_session.setIdusuario(prefs.getString("IDUSUARIO", null));
        user_session.setUsr_nombres(prefs.getString("USR_NOMBRES", null));
        user_session.setIdclieprov(prefs.getString("IDCLIEPROV", null));
        user_session.setEmail(prefs.getString("EMAIL", null));
        user_session.setSincroniza(prefs.getBoolean("SINCRONIZAR",false));
        return user_session;
    }

    public static float  convertStringTimeFloat(final String time ){
        if(time == null){
            return 0.0f;
        }else if(time.trim().equals("")){
            return 0.0f;
        }else if(time.trim().equals("__:__")){
            return 0.0f;
        }else if(time.trim().equals("24:00"))
            return 0.0f;
        else if(time.trim().equals("00:00"))
            return 0.0f;
        else{
            String[] horas_string = time.split(":");

            if(horas_string.length==0){
                return 0.0f;
            }else{
                BigDecimal hora_decimal = new BigDecimal(horas_string[0]);
                BigDecimal minutos_decimal = new BigDecimal(horas_string[1]);
                BigDecimal fraccion = minutos_decimal.divide(new BigDecimal(60),2, BigDecimal.ROUND_HALF_UP);
//                fraccion=fraccion.setScale(0, RoundingMode.HALF_UP);
                return fraccion.add(hora_decimal).floatValue();
            }
        }
    }

    public static String convertTimeFloatString(Float time){
        if(time == null){
            return "";
        }else if(time.floatValue()==0.0f){
            return "00:00";
        }else{
            BigDecimal number = new BigDecimal(time);
            int hora = number.intValue();
            BigDecimal fraccion = number.remainder(BigDecimal.ONE).multiply(new BigDecimal(60));
            fraccion=fraccion.setScale(0, RoundingMode.HALF_UP);
            int minutos = fraccion.intValue();
            return idGeneradoDos(hora)+":"+idGeneradoDos(minutos);
        }
    }
    public static String idGeneradoDos(int id){
        if(id<10) return "0"+id;
        else return String.valueOf(id);
    }
    public  static String isnull(String valor, String valor2){

        if (valor==null){
            return valor2;
        }
        return  valor;

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
