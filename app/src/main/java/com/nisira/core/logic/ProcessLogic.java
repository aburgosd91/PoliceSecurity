package com.nisira.core.logic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.nisira.core.entity.Basedatos;

/**
 * Created by aburgos on 19/01/2017.
 */

public class ProcessLogic  extends AsyncTask<String, Void, String> {
    private final Context context1;
    private Activity activity;
    private Fragment fragment;
    private String method;
    String response = "";
    private Basedatos WSBasedatos;
    public ProgressDialog pd;
    public ProcessLogic(Activity activity, Context context, String method) {
        this.context1 = context;
        this.activity =activity;
        this.setMethod(method);
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
    }
    public ProcessLogic(Fragment fragment, Context context, String method) {
        this.context1 = context;
        this.fragment =fragment;
        this.setMethod(method);
        this.WSBasedatos = new Basedatos();
        WSBasedatos.setIdbasedatosconexion("AUTONOR");
    }
    protected String doInBackground(String... args) {
        return response;
    }
    public void onPostExecute(String result) {
        pd.dismiss();
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
