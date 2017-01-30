package com.nisira.core.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.nisira.gcalderon.policesecurity.R;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;

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

}
