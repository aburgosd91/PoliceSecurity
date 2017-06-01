package com.nisira.view.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.jorgecastillo.FillableLoader;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.service.ConsumerService;
import com.nisira.gcalderon.policesecurity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashScreen_Activity extends ActivityNisiraCompat {
    /*VARIABLES DE VISTA*/
    @Bind(R.id.pgBar)
    ProgressBar pgBar;
    FillableLoader fillableLoader;
    TextView txt_progressbar;
    float percentage =0;
    /*VARIABLES DE CLASE*/
    public static final int seconds=8;
    public static final int miliseconds_total=seconds*1000;
    public static final int delay=2;

    private static final Object[][] TABLASINCRONIZACIONDOCS = {
            //{"METHOD_LIST_CARGOS_PERSONAL", 5},
            //{"METHOD_LIST_ORDENSERVICIOCLIENTE",8},
            {"METHOD_LIST_DORDENSERVICIOCLIENTE", 8},
            {"METHOD_LIST_PERSONAL_SERVICIO", 8},
            {"METHOD_LIST_DPERSONAL_SERVICIO", 8},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO", 8},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO", 8}
    };

    public static int value = 0;
    public static final int rango = (int)(100 / TABLASINCRONIZACIONDOCS.length);
    public int item_tabla_syncrodoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        /*
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            View decorView = getWindow().getDecorView();
            //Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
*/

        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        fillableLoader = (FillableLoader)findViewById(R.id.fillableLoader);
        fillableLoader.setSvgPath(getString(R.string.xmlLogo));
        fillableLoader.setPercentage(percentage);
        fillableLoader.start();
        item_tabla_syncrodoc = 0;
        pgBar = new ProgressBar(this);
        txt_progressbar = (TextView)findViewById(R.id.txt_progressbar);
        //pgBar.setMax(max_progress());
        asyncronizedocs();
        //initAnimation();
    }

    public void initAnimation(){
        new CountDownTimer(miliseconds_total,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //pgBar.setProgress(progress(millisUntilFinished));

            }

            @Override
            public void onFinish() {
                /*
                Intent intent = new Intent(SplashScreen_Activity.this, NavigationPolice_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();*/
            }
        }.start();
    }
    public int progress(long miliseconds){
        return (int)((miliseconds_total-miliseconds)/1000);
    }
    public int max_progress(){
        return seconds-delay;
    }

    public void asyncronizedocs() {
        String method_syncro = TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][0].toString();
        int time = (int) TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][1];
        item_tabla_syncrodoc++;
        txt_progressbar.setText(value+"%"+" <<"+method_syncro.replace("METHOD_LIST_", "")+">>");
        ConsumerService cws = new ConsumerService(SplashScreen_Activity.this, getApplicationContext(), method_syncro, time, true, 2);
        cws.getAttribute().put("type", "XML");
        cws.execute("");
        cws.pd = new ProgressDialog(SplashScreen_Activity.this);
        //cws.pd = ProgressDialog.show(SplashScreen_Activity.this, "SINCRONIZANDO", "Sincronizando Base de Datos - " + method_syncro.replace("METHOD_LIST_", ""), true, false);
    }
    @Override
    public void onPostExecuteWebService(ConsumerService cws, String result) {
        if (cws.isSyncronize()) {
            percentage+=25;
            fillableLoader.setPercentage(percentage);
            fillableLoader.start();
            if (cws.getType_syncronize() == 2) {/*SINCRONIZACION DOCUMENTOS*/
                if (TABLASINCRONIZACIONDOCS.length > item_tabla_syncrodoc && item_tabla_syncrodoc > 0) {
                    value += rango;
                    pgBar.setProgress((int)(value));
                    asyncronizedocs();
                }
                /*TERMINO SYNCRONIZADOR*/
                if (TABLASINCRONIZACIONDOCS.length == item_tabla_syncrodoc) {
                    item_tabla_syncrodoc = 0;
                    value = 0 ;
                    Intent intent = new Intent(SplashScreen_Activity.this, NavigationPolice_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}
