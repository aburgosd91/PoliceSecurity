package com.nisira.view.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nisira.core.database.DataBaseClass;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;

import static com.nisira.view.Activity.Login_Activity.startInstalledAppDetailsActivity;

public class NavigationPolice_Activity extends ActivityNisiraCompat
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView campo_titulo;
    public TextView campo_titulo2;
    RelativeLayout relativeLayout;
    public int item_tabla_syncro,item_tabla_syncrodoc;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final Object[][] TABLASINCRONIZACION={
            {"METHOD_LIST_CLIEPROV",20},
            {"METHOD_LIST_CONSUMIDOR", 8},
            {"METHOD_LIST_CONCEPTO_CUENTA", 5},
            {"METHOD_LIST_CARGOS_PERSONAL", 5},
            {"METHOD_LIST_DOCUMENTOS",6},
            {"METHOD_LIST_NUMEMISOR",10},
            {"METHOD_LIST_PERSONAL_SERVICIO",8},
            {"METHOD_LIST_DPERSONAL_SERVICIO",8},
            {"METHOD_LIST_PRODUCTOS",8},
            {"METHOD_LIST_RUTAS",8},
            {"METHOD_LIST_SUCURSALES",5},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO",8},
            {"METHOD_LIST_ORDENSERVICIOCLIENTE",8},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO",8},
            {"METHOD_LIST_DORDENSERVICIOCLIENTE",8}
    };
    private static final Object[][] TABLASINCRONIZACIONDOCS={
            {"METHOD_LIST_PERSONAL_SERVICIO",8},
            {"METHOD_LIST_DPERSONAL_SERVICIO",8},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO",8},
            {"METHOD_LIST_ORDENSERVICIOCLIENTE",8},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO",8},
            {"METHOD_LIST_DORDENSERVICIOCLIENTE",8}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_police);

        item_tabla_syncro = 0;
        item_tabla_syncrodoc = 0;
        relativeLayout = (RelativeLayout) findViewById(R.id.main_content);
//        variablesglobales = (VariableGlobal)getApplication();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkPermission())
            {
                try {
                    DataBaseClass.SincronizarDB(getApplication());
                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            } else {
                requestPermission();
                return;
            }
        }
        else
        {
            try {
                DataBaseClass.SincronizarDB(getApplication());
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.ic_menu_manage);
        campo_titulo = (TextView)findViewById(R.id.campo_titulo);
        campo_titulo2 = (TextView)findViewById(R.id.campo_titulo2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),   R.drawable.nisiralogoxxs, this.getTheme() );
        toggle.setDrawerIndicatorEnabled(false);
        drawer.setDrawerListener(toggle);
        toggle.setHomeAsUpIndicator(drawable);
        toggle.syncState();
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                Log.i("MainActivity", "popping backstack");
                fm.popBackStack();
            } else {
                Log.i("MainActivity", "nothing on backstack, calling super");
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_police, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_syncronize) {

            asyncronize();
            return true;
        }
        if (id == R.id.action_syncronizedocs) {

            asyncronizedocs();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        if(getSupportFragmentManager().getFragments()!=null){
            for(Fragment fragment:getSupportFragmentManager().getFragments()){

                getSupportFragmentManager().popBackStack();
                //getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }
        relativeLayout.clearDisappearingChildren();

        if (id == R.id.mov_configuracion) {

        } else if (id == R.id.mov_asignacion_personal) {
            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Asignacion Personal", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_registro_horas_cmt) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Hora", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_registro_vehiculo) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Vehiculo", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_liquidacion_gastos) {

            Fragment fragment = lst_OrdenLiquidacionGasto_Fragment.newInstance("Liquidacion Gastos", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_LiquidacionGasto));


        } else if (id == R.id.mov_ubicacion_gmap) {

        }else if (id == R.id.mov_foto) {

        }else if (id == R.id.mov_logout) {
            Intent intent = new Intent(NavigationPolice_Activity.this, Login_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        //AQUI SE AGREGA EL TITULO DEL ELEMENTO SELECCIONADO
        //selectItem((String) item.getTitle(),id);

        campo_titulo.setText(item.getTitle());

        //setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selectItem(String title, int id) {
        // Enviar título como arguemento del fragmento
        Bundle args = new Bundle();
        args.putString("numero de la seccion", title);
        Log.i("INFO",title);

        if(id == R.id.mov_ubicacion_gmap){
            Log.i("INFO","ENTRO");
            Fragment fragment = mnt_Ruta_Gps.newInstance("ejemplo", "ejemplo2");
            fragment.setArguments(args);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
        }
        else {
            Log.i("INFO","NO ENTRO");
            Fragment fragment = List_Fragment_Personal.newInstance("ejemplo", "ejemplo2");
            fragment.setArguments(args);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();

            // Cerrar drawer
        }
        setTitle(title); // Setear título actual

    }

    public void asyncronize(){
        String method_syncro=TABLASINCRONIZACION[item_tabla_syncro][0].toString();
        int time = (int) TABLASINCRONIZACION[item_tabla_syncro][1];
        item_tabla_syncro++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this,getApplicationContext(), method_syncro, time,true);
        cws.getAttribute().put("type","XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO","Sincronizando Base de Datos - "+method_syncro.replace("METHOD_LIST_",""), true, false);
    }
    public void asyncronizedocs(){
        String method_syncro=TABLASINCRONIZACIONDOCS[item_tabla_syncro][0].toString();
        int time = (int) TABLASINCRONIZACIONDOCS[item_tabla_syncro][1];
        item_tabla_syncrodoc++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this,getApplicationContext(), method_syncro, time,true);
        cws.getAttribute().put("type","XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO","Sincronizando Base de Datos - "+method_syncro.replace("METHOD_LIST_",""), true, false);
    }


    @Override
    public  void onPostExecuteWebService(ConsumerService cws, String result) {

        if(cws.isSyncronize()){
            if(TABLASINCRONIZACION.length>item_tabla_syncro && item_tabla_syncro>0){
                asyncronize();
            }
            if(TABLASINCRONIZACIONDOCS.length>item_tabla_syncrodoc && item_tabla_syncrodoc>0){
                asyncronizedocs();
            }
        }
        if(TABLASINCRONIZACION.length==item_tabla_syncro){
            item_tabla_syncro=0;
        }
        if(TABLASINCRONIZACIONDOCS.length==item_tabla_syncrodoc){
            item_tabla_syncrodoc=0;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(NavigationPolice_Activity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            String mensaje = "El aplicativo no tiene permiso de almacenamiento.?Ir a ajustes para brindar el permiso de almacenamiento al aplicativo.?";
            AlertDialog alert =  Util.msgboxConfirmacion(NavigationPolice_Activity.this,mensaje,"PERMISO DE ALMACENAMIENTO");
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startInstalledAppDetailsActivity(NavigationPolice_Activity.this);
                    alert.dismiss();
                }
            });

        } else {
            ActivityCompat.requestPermissions(NavigationPolice_Activity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(NavigationPolice_Activity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

}
