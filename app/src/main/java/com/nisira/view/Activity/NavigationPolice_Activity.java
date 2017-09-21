package com.nisira.view.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
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

import com.google.android.gms.common.api.GoogleApiClient;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.database.DataBaseClass;
import com.nisira.core.entity.Usuario;
import com.nisira.core.interfaces.ActivityNisiraCompat;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.CustomDialogFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public TextView txt_user_name_header;
    public TextView txt_user_email_header;
    public CircleImageView imageViewprofile;
    RelativeLayout relativeLayout;
    NavigationView navigationView;
    File photo;
    public int item_tabla_syncro, item_tabla_syncrodoc, item_tabla_ascentdoc;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final Object[][] TABLASINCRONIZACION = {
           /* {"METHOD_LIST_ESTRUCTURA_COSTO_PRODUCTO",8},
            {"METHOD_LIST_CODOPERACIONES", 8},
            {"METHOD_LIST_CLIEPROV", 20},
            {"METHOD_LIST_CONSUMIDOR", 8},
            {"METHOD_LIST_TIPOGASTO",8},
            {"METHOD_LIST_CONCEPTO_CUENTA", 5},
            {"METHOD_LIST_CARGOS_PERSONAL", 5},
            {"METHOD_LIST_DOCUMENTOS", 8},
            {"METHOD_LIST_NUMEMISOR", 10},
            {"METHOD_LIST_PERSONAL_SERVICIO", 8},
            {"METHOD_LIST_DPERSONALSERVICIO_FREE", 8},
            {"METHOD_LIST_PRODUCTOS", 8},
            {"METHOD_LIST_RUTAS", 8},
            {"METHOD_LIST_SUCURSALES", 5},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO", 8},
            {"METHOD_LIST_ORDENSERVICIOCLIENTE", 8},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO", 8},
            {"METHOD_LIST_DORDENSERVICIOCLIENTE", 8}*/
            {"METHOD_LIST_CLIEPROV_FREE", 50},
            {"METHOD_LIST_CONSUMIDOR", 50},
            {"METHOD_LIST_TIPOGASTO", 20},
            {"METHOD_LIST_ORDEN_SERVICIO_PENDIENTE", 20},
            {"METHOD_LIST_DORDEN_SERVICIO_PENDIENTE", 20},
            {"METHOD_LIST_PERSONAL_SERVICIO_FREE", 20},
            {"METHOD_LIST_DPERSONALSERVICIO_FREE", 20},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO", 20},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO", 20},
            {"METHOD_LIST_DOCUMENTOS", 20}
    };
    private static final Object[][] TABLASINCRONIZACIONDOCS = {
            //{"METHOD_LIST_CARGOS_PERSONAL", 5},
            {"METHOD_LIST_ORDEN_SERVICIO_PENDIENTE", 8},
            {"METHOD_LIST_DORDEN_SERVICIO_PENDIENTE", 8},
            {"METHOD_LIST_PERSONAL_SERVICIO_FREE", 8},
            {"METHOD_LIST_DPERSONALSERVICIO_FREE", 8},
            {"METHOD_LIST_ORDENLIQUIDACIONGASTO", 20},
            {"METHOD_LIST_DORDENLIQUIDACIONGASTO", 20},
    };
    private static final Object[][] TABLA_ASCENT_DOCS = {
            //{"METHOD_ASCENT_ORDENSERVICIOCLIENTE",8},
            {"METHOD_ASCENT_DORDENSERVICIOCLIENTE", 8},
            {"METHOD_ASCENT_PERSONAL_SERVICIO", 8},
            {"METHOD_ASCENT_DPERSONAL_SERVICIO", 8},
            {"METHOD_ASCENT_ORDENLIQUIDACIONGASTO",8},
            {"METHOD_ASCENT_DORDENLIQUIDACIONGASTO",8}

    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_police);
        item_tabla_syncro = 0;
        item_tabla_syncrodoc = 0;
        item_tabla_ascentdoc = 0;
        relativeLayout = (RelativeLayout) findViewById(R.id.main_content);
        photo = new File(Environment.getExternalStorageDirectory(), "Pic.jpg");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campo_titulo = (TextView) findViewById(R.id.campo_titulo);
        campo_titulo2 = (TextView) findViewById(R.id.campo_titulo2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkPermission()) {
                try {
                    DataBaseClass.SincronizarDB(getApplication());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                requestPermission();
                return;
            }
        } else {
            try {
                DataBaseClass.SincronizarDB(getApplication());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //EVENTO DE ABRIR Y CERRAR DRAWABLE
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.nisiralogoxxs, this.getTheme());
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
        navigationView.setNavigationItemSelectedListener(this);
        //FIN DEL EVENTO DEL DRAWABLE
        setFotoPerfil();
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
                //super.onBackPressed();
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
        try {
            if (!manager.getFragments().isEmpty()) {
                if (manager.getBackStackEntryCount() > 0) {
                    for (int i = 0; i < manager.getBackStackEntryCount(); i++)
                        manager.popBackStack();
                    manager.beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.main_content)).commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (id == R.id.mov_configuracion) {

        } else if (id == R.id.mov_asignacion_personal) {
            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Vehiculo", "NavigationPolice_Activity");
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

        } /*
        else if (id == R.id.mov_registro_vehiculo) {

            Fragment fragment = lst_OrdenServicio_Fragment.newInstance("Registro Vehiculo", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_OrdenServicio));
            fragments.add(fragment);

        } */
        else if (id == R.id.mov_liquidacion_gastos) {

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
            Fragment fragment = mnt_Ruta_Gps.newInstance("Liquidacion Gastos", "NavigationPolice_Activity");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
            campo_titulo2.setText(getString(R.string.lst_LiquidacionGasto));
            fragments.add(fragment);

        }else if (id == R.id.mov_foto) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void asyncronize() {
        String method_syncro = TABLASINCRONIZACION[item_tabla_syncro][0].toString();
        int time = (int) TABLASINCRONIZACION[item_tabla_syncro][1];
        item_tabla_syncro++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this, getApplicationContext(), method_syncro, time, true, 1);
        cws.getAttribute().put("type", "JSON");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO", "Sincronizando Base de Datos - " + method_syncro.replace("METHOD_LIST_", ""), true, false);
    }

    public void asyncronizedocs() {
        try {
            String method_syncro = TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][0].toString();
            int time = (int) TABLASINCRONIZACIONDOCS[item_tabla_syncrodoc][1];
            item_tabla_syncrodoc++;
            ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this, getApplicationContext(), method_syncro, time, true, 2);
            cws.getAttribute().put("type", "JSON");
            cws.execute("");
            cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SINCRONIZANDO", "Sincronizando Base de Datos - " + method_syncro.replace("METHOD_LIST_", ""), true, false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ascentdocs() {
        String method_syncro = TABLA_ASCENT_DOCS[item_tabla_ascentdoc][0].toString();
        int time = (int) TABLA_ASCENT_DOCS[item_tabla_ascentdoc][1];
        item_tabla_ascentdoc++;
        ConsumerService cws = new ConsumerService(NavigationPolice_Activity.this, getApplicationContext(), method_syncro, time, true, 3);
        cws.getAttribute().put("type", "XML");
        cws.execute("");
        cws.pd = ProgressDialog.show(NavigationPolice_Activity.this, "SUBIENDO", "Sincronizando Base de Datos - " + method_syncro.replace("METHOD_ASCENT_", ""), true, false);
    }

    @Override
    public void onPostExecuteWebService(ConsumerService cws, String result) {
        if (cws.isSyncronize()) {
            if (cws.getType_syncronize() == 1) {/*SINCRONIZACION TOTAL*/
                if (TABLASINCRONIZACION.length > item_tabla_syncro && item_tabla_syncro > 0) {
                    asyncronize();
                }
                if (TABLASINCRONIZACION.length == item_tabla_syncro) {
                    item_tabla_syncro = 0;
                }
            } else if (cws.getType_syncronize() == 2) {/*SINCRONIZACION DOCUMENTOS*/
                if (TABLASINCRONIZACIONDOCS.length > item_tabla_syncrodoc && item_tabla_syncrodoc > 0) {
                    asyncronizedocs();
                }
                if (TABLASINCRONIZACIONDOCS.length == item_tabla_syncrodoc) {
                    item_tabla_syncrodoc = 0;
                }
            } else if (cws.getType_syncronize() == 3) {/*ASCENT DOCUMENTOS*/
                if (TABLA_ASCENT_DOCS.length > item_tabla_ascentdoc && item_tabla_ascentdoc > 0) {
                    ascentdocs();
                }
                if (TABLA_ASCENT_DOCS.length == item_tabla_ascentdoc) {
                    item_tabla_ascentdoc = 0;
                }
            }
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(NavigationPolice_Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            String mensaje = "El aplicativo no tiene permiso de almacenamiento.?Ir a ajustes para brindar el permiso de almacenamiento al aplicativo.?";
            AlertDialog alert = Util.msgboxConfirmacion(NavigationPolice_Activity.this, mensaje, "PERMISO DE ALMACENAMIENTO");
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startInstalledAppDetailsActivity(NavigationPolice_Activity.this);
                    alert.dismiss();
                }
            });

        } else {
            ActivityCompat.requestPermissions(NavigationPolice_Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(NavigationPolice_Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
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
                    //
                    try {

                        Bitmap myBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                        ExifInterface exif = new ExifInterface(imageUri.getPath());
                        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                        FileOutputStream os;
                        Matrix matrix = new Matrix();
                        if (orientation == 6) {
                            matrix.postRotate(90);
                        } else if (orientation == 3) {
                            matrix.postRotate(180);
                        } else if (orientation == 8) {
                            matrix.postRotate(270);
                        }
                        myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true);
                        imageViewprofile.setImageBitmap(myBitmap);

                    } catch (Exception e) {
                        e.printStackTrace();
                        DialogFragment popup = new CustomDialogFragment();
                        Bundle args = new Bundle();
                        args.putString("titulo", "Error");
                        args.putString("mensaje", "No se pudo cargar la foto de perfil");
                        popup.setArguments(args);
                        popup.show(getSupportFragmentManager(),"dialog");
                    }
                    //
                };break;
            default:
                /*RECUPERAR USER*/
                Usuario user = Util.session_object(this.getApplicationContext());
                if(user !=null){
                    if(!user.getUsr_nombres().isEmpty())
                        txt_user_name_header.setText(user.getUsr_nombres());
                    if(!user.getEmail().isEmpty())
                        txt_user_email_header.setText(user.getEmail());
                }
        }

    }
    public void setFotoPerfil() {
        View hView = navigationView.getHeaderView(0);
        imageViewprofile = (CircleImageView) hView.findViewById(R.id.imageViewprofile);
        txt_user_name_header= (TextView) hView.findViewById(R.id.txt_user_name_header);
        txt_user_email_header= (TextView) hView.findViewById(R.id.txt_user_email_header);
        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = dao.listar().get(0);
            txt_user_name_header.setText(usuario.getUsr_nombres());
            txt_user_email_header.setText(usuario.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (photo.exists()) {

            try {
                //comprueba que hay foto
                imageUri = Uri.fromFile(photo);
                Bitmap bmp = null;
                //
                Bitmap myBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ExifInterface exif = new ExifInterface(imageUri.getPath());
                int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                FileOutputStream os;
                Matrix matrix = new Matrix();
                if (orientation == 6) {
                    matrix.postRotate(90);
                } else if (orientation == 3) {
                    matrix.postRotate(180);
                } else if (orientation == 8) {
                    matrix.postRotate(270);
                }
                myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true);
                imageViewprofile.setImageBitmap(myBitmap);

            } catch (Exception e) {
                e.printStackTrace();
                DialogFragment popup = new CustomDialogFragment();
                Bundle args = new Bundle();
                args.putString("titulo", "Error");
                args.putString("mensaje", "No se pudo cargar la foto de perfil");
                popup.setArguments(args);
                popup.show(getSupportFragmentManager(),"dialog");
            }

        }
    }

}
