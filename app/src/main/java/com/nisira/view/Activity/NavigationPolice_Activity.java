package com.nisira.view.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nisira.core.database.DataBaseClass;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.nisira.view.Activity.Login_Activity.startInstalledAppDetailsActivity;

public class NavigationPolice_Activity extends ActivityNisiraCompat
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int TAKE_PICTURE = 1;
    private Uri imageUri;
    public TextView campo_titulo;
    public TextView campo_titulo2;
    public CircleImageView imageViewprofile;
    RelativeLayout relativeLayout;
    public int item_tabla_syncro,item_tabla_syncrodoc,item_tabla_ascentdoc;
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
            {"METHOD_LIST_ORDENSERVICIOCLIENTE",8},
            {"METHOD_LIST_DORDENSERVICIOCLIENTE",8},
            {"METHOD_LIST_PERSONAL_SERVICIO",8},
            {"METHOD_LIST_DPERSONAL_SERVICIO",8},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO",8},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO",8}
    };
    private static final Object[][] TABLA_ASCENT_DOCS={
            //{"METHOD_ASCENT_ORDENSERVICIOCLIENTE",8},
            {"METHOD_ASCENT_DORDENSERVICIOCLIENTE",8},
            {"METHOD_ASCENT_PERSONAL_SERVICIO",8},
            {"METHOD_ASCENT_DPERSONAL_SERVICIO",8}
            //{"METHOD_ASCENT_ORDENLIQUIDACIONGASTO",8},
            //{"METHOD_ASCENT_DORDENLIQUIDACIONGASTO",8}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_police);
        item_tabla_syncro = 0;
        item_tabla_syncrodoc = 0;
        item_tabla_ascentdoc = 0;
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
        View hView =  navigationView.getHeaderView(0);
        imageViewprofile = (CircleImageView)hView.findViewById(R.id.imageViewprofile);
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
        if (id == R.id.action_ascentdocs) {

            ascentdocs();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        List<Fragment> fragments = new ArrayList<>();
        int id = item.getItemId();

        FragmentManager manager = getSupportFragmentManager();
/*
        if(manager.getFragments() != null) {
            if (!manager.getFragments().isEmpty()) {
                for(int i = 0 ; i<manager.getFragments().size()-1;i++)
                manager.beginTransaction().hide(manager.getFragments().get(i)).commit();
            }
            for(int i = 0 ; i<manager.getFragments().size();i++)
                manager.popBackStack();
        }
*/
        try {
            if(manager.getFragments()!=null){
                if(manager.getBackStackEntryCount()>0) {
                    for (int i = 0; i < manager.getBackStackEntryCount(); i++)
                        manager.popBackStack();
                    manager.beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.main_content)).commit();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if (id == R.id.mov_configuracion) {

        } else if (id == R.id.mov_asignacion_personal) {
            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Asignacion Personal", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));
            fragments.add(fragment);

        } else if (id == R.id.mov_registro_horas_cmt) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Hora", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));
            fragments.add(fragment);

        } else if (id == R.id.mov_registro_vehiculo) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Vehiculo", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));
            fragments.add(fragment);

        } else if (id == R.id.mov_liquidacion_gastos) {

            Fragment fragment = lst_OrdenLiquidacionGasto_Fragment.newInstance("Liquidacion Gastos", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_LiquidacionGasto));
            fragments.add(fragment);

        } else if (id == R.id.mov_ubicacion_gmap) {

        } else if (id == R.id.mov_foto) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(photo));
            imageUri = Uri.fromFile(photo);
            startActivityForResult(intent, TAKE_PICTURE);

        } else if (id == R.id.mov_logout) {
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

    public void asyncronize(){
        String method_syncro=TABLASINCRONIZACION[item_tabla_syncro][0].toString();
        int time = (int) TABLASINCRONIZACION[item_tabla_syncro][1];
        item_tabla_syncro++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this,getApplicationContext(), method_syncro, time,true,1);
        cws.getAttribute().put("type","XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO","Sincronizando Base de Datos - "+method_syncro.replace("METHOD_LIST_",""), true, false);
    }
    public void asyncronizedocs(){
        String method_syncro=TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][0].toString();
        int time = (int) TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][1];
        item_tabla_syncrodoc++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this,getApplicationContext(), method_syncro, time,true,2);
        cws.getAttribute().put("type","XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO","Sincronizando Base de Datos - "+method_syncro.replace("METHOD_LIST_",""), true, false);
    }
    public void ascentdocs(){
        String method_syncro=TABLA_ASCENT_DOCS[item_tabla_ascentdoc][0].toString();
        int time = (int) TABLA_ASCENT_DOCS[item_tabla_ascentdoc][1];
        item_tabla_ascentdoc++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this,getApplicationContext(), method_syncro, time,true,3);
        cws.getAttribute().put("type","XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SUBIENDO","Sincronizando Base de Datos - "+method_syncro.replace("METHOD_ASCENT_",""), true, false);
    }


    @Override
    public  void onPostExecuteWebService(ConsumerService cws, String result) {
        if(cws.isSyncronize()){
            if(cws.getType_syncronize()==1){/*SINCRONIZACION TOTAL*/
                if(TABLASINCRONIZACION.length>item_tabla_syncro && item_tabla_syncro>0){
                    asyncronize();
                }
                if(TABLASINCRONIZACION.length==item_tabla_syncro){
                    item_tabla_syncro=0;
                }
            }else if(cws.getType_syncronize()==2){/*SINCRONIZACION DOCUMENTOS*/
                if(TABLASINCRONIZACIONDOCS.length>item_tabla_syncrodoc && item_tabla_syncrodoc>0){
                    asyncronizedocs();
                }
                if(TABLASINCRONIZACIONDOCS.length==item_tabla_syncrodoc){
                    item_tabla_syncrodoc=0;
                }
            }else if(cws.getType_syncronize()==3){/*ASCENT DOCUMENTOS*/
                if(TABLA_ASCENT_DOCS.length>item_tabla_ascentdoc && item_tabla_ascentdoc>0){
                    ascentdocs();
                }
                if(TABLA_ASCENT_DOCS.length==item_tabla_ascentdoc){
                    item_tabla_ascentdoc=0;
                }
            }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = imageUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    ContentResolver cr = getContentResolver();
                    Bitmap bitmap;
                    try {
                        bitmap = android.provider.MediaStore.Images.Media
                                .getBitmap(cr, selectedImage);
                        imageViewprofile.setImageBitmap(bitmap);

                    } catch (Exception e) {

                        Log.e("Camera", e.toString());
                    }
                    System.out.println("GG1");
                }
        }

    }
}
