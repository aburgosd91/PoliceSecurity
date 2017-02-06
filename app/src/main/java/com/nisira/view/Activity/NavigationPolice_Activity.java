package com.nisira.view.Activity;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nisira.core.service.ConsumerService;
import com.nisira.gcalderon.policesecurity.R;

public class NavigationPolice_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView campo_titulo;
    public TextView campo_titulo2;
    public int item_tabla_syncro;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_police);
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
            }
        }

        if (id == R.id.mov_configuracion) {

        } else if (id == R.id.mov_asignacion_personal) {
            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Asignacion Personal", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_registro_horas_cmt) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Hora", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_registro_vehiculo) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Vehiculo", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
            campo_titulo.setText(getString(R.string.lst_OrdenServicio));

        } else if (id == R.id.mov_liquidacion_gastos) {

        } else if (id == R.id.mov_ubicacion_gmap) {

        }else if (id == R.id.mov_foto) {

        }else if (id == R.id.mov_registro_horas_grd) {

        }

        //AQUI SE AGREGA EL TITULO DEL ELEMENTO SELECCIONADO
        //selectItem((String) item.getTitle(),id);

        campo_titulo2.setText(item.getTitle());

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

}
