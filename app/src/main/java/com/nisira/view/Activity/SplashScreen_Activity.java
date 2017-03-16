package com.nisira.view.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.github.jorgecastillo.FillableLoader;
import com.nisira.gcalderon.policesecurity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashScreen_Activity extends AppCompatActivity {
    /*VARIABLES DE VISTA*/
    @Bind(R.id.pgBar)
    ProgressBar pgBar;
    FillableLoader fillableLoader;
    /*VARIABLES DE CLASE*/
    public static final int seconds=8;
    public static final int miliseconds_total=seconds*1000;
    public static final int delay=2;
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
        fillableLoader.setSvgPath(getString(R.string.xml_nisira));
        fillableLoader.start();
        pgBar = new ProgressBar(this);
        pgBar.setMax(max_progress());
        initAnimation();
    }
    public void initAnimation(){
        new CountDownTimer(miliseconds_total,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pgBar.setProgress(progress(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashScreen_Activity.this, NavigationPolice_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public int progress(long miliseconds){
        return (int)((miliseconds_total-miliseconds)/1000);
    }
    public int max_progress(){
        return seconds-delay;
    }
}
