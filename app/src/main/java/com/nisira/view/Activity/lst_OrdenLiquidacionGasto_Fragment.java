package com.nisira.view.Activity;

import android.accounts.NetworkErrorException;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.maps.SupportMapFragment;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Usuario;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.service.TypeMethod;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_lst_OrdenLiquidacionGasto;
import com.nisira.view.Adapter.Adapter_lst_OrdenServicio;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class lst_OrdenLiquidacionGasto_Fragment extends FragmentNisira {

    // TODO: ELEMENTOS DEL LAYOUT
    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    List<Ordenliquidaciongasto> listServCliente;
    FloatingActionButton fab_abrir,fab_filtrar,fab_nuevo;
    OrdenliquidaciongastoDao dao;
    EditText edit_filtro;
    RelativeLayout rlfiltro;
    ConsumerService cs;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public lst_OrdenLiquidacionGasto_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static lst_OrdenLiquidacionGasto_Fragment newInstance(String param1, String param2) {
        lst_OrdenLiquidacionGasto_Fragment fragment = new lst_OrdenLiquidacionGasto_Fragment();
        Bundle args = new Bundle();
        args.putString(OPCION, param1);
        args.putString(ANTERIOR, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(OPCION);
            mParam2 = getArguments().getString(ANTERIOR);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lst_ordenliquidaciongasto, container, false);
        animacionEntrada();
        cs = new ConsumerService(this,getContext(), TypeMethod.METHOD_WEB_RETURNID,3);
        // Inflate the layout for this fragment
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swiperefresh);
        fab_abrir = (FloatingActionButton)view.findViewById(R.id.fab_abrir);
        fab_nuevo = (FloatingActionButton)view.findViewById(R.id.fab_nuevo);
        fab_filtrar = (FloatingActionButton)view.findViewById(R.id.fab_filtrar);
        rlfiltro = (RelativeLayout)view.findViewById(R.id.rlfiltro);
        edit_filtro = (EditText)view.findViewById(R.id.edit_filtro);
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Cargar datos desde la BD(items)
        try {
            dao = new OrdenliquidaciongastoDao();
            //List<Clieprov> listClieprov = (List<Clieprov>) Util.stringListObject("com.nisira.core.entity.Clieprov",result);
            UsuarioDao dao2= new UsuarioDao();
            Usuario user = dao2.listar().get(0);
            listServCliente = dao.ListarxUsuario(user.getIdclieprov());
            // Crear un nuevo adaptador
            adapter = new Adapter_lst_OrdenLiquidacionGasto(mParam1,listServCliente,getFragmentManager());
            recycler.setAdapter(adapter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        LlenarCampos();
        Listeners();
        return view;
    }


    public void animacionEntrada(){    // TODO: TRANSICIONES Y ANIMACIONES
        Fade slide = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            slide = (Fade) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_fade);
            setExitTransition(slide);
            setEnterTransition(slide);
        }

    }
    public void LlenarCampos(){

    }

    public void Listeners(){        // TODO: EVENTOS
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    listServCliente = dao.listar();
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        fab_filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //listServCliente = dao.(edit_filtro.getText().toString());
                    rlfiltro.setVisibility(View.GONE);
                    adapter = new Adapter_lst_OrdenLiquidacionGasto(mParam1,listServCliente,getFragmentManager());
                    recycler.setAdapter(adapter);
                    InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(edit_filtro.getWindowToken(), 0);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        fab_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cs.execute("");
                    cs.pd = ProgressDialog.show(getActivity(), "SINCRONIZANDO", "Generando Token de Orden Liquidacion Gasto", true, false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public  void onPostExecuteWebService(ConsumerService cws, String result) {
        /*DESPUES DE BOTON NUEVO*/

        if(result.equals("ERROR: No se puede conectar con NISIRA ERP.")){
            Snackbar.make(getView(), result, Snackbar.LENGTH_SHORT).show();
        }else
        if(cws.getMethod().trim().equals(TypeMethod.METHOD_WEB_RETURNID)){

            Log.i("Resultado",result);
            String ws_result = result;
            try {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setMessage("Desea generar una nueva Orden de Liquidacion?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                try {
                                String[] x= ws_result.split(",");
                                OrdenliquidaciongastoDao dao_ol = new OrdenliquidaciongastoDao();
                                Ordenliquidaciongasto ol = new Ordenliquidaciongasto();
                                UsuarioDao usuarioDao = new UsuarioDao();
                                Usuario usuario = usuarioDao.listar().get(0);
                                //AGREGAR LO DEL USUARIO
                                Calendar now = Calendar.getInstance();
                                now.getTime();
                                ol.setIdempresa("001");
                                ol.setIdorden(x[0]);
                                ol.setIddocumento(x[1]);
                                ol.setSerie(x[2]);
                                ol.setNumero(x[3]);
                                ol.setIdmoneda(x[4]);
                                ol.setIdestado(x[5]);
                                ol.setIgv(Double.valueOf(x[6]));
                                ol.setIdemisor("001");
                                ol.setPeriodo(now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH));
                                ol.setIdclieprov(usuario.getIdclieprov());
                                ol.setIdsucursal("001");
                                ol.setRazonsocial(usuario.getUsr_nombres());
                                ol.setFechacreacion(now.getTime());

                                ConsumerService cws = new ConsumerService(getActivity(), getContext(), TypeMethod.METHOD_ASCENT_ORDENLIQUIDACIONGASTO2, 5, true, 1);
                                cws.getAttribute().put("type", "XML");
                                cws.getAttribute().put("lista1",ol);
                                //cws.getAttribute().put("lista2",);
                                cws.execute("");

                                dao_ol.mezclarLocal(ol);
                                Snackbar.make(getView(), "Orden Liquidacion Creada", Snackbar.LENGTH_LONG).show();
                                Fragment fragment = edt_OrdenLiquidacionGasto_Fragment.newInstance(mParam1, "lst_OrdenLiquidacionGasto");
                                Bundle bundle = fragment.getArguments();
                                fragment.setArguments(bundle);
                                bundle.putSerializable("OrdenLiquidacionGasto", ol);
                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                                ft.addToBackStack(null);
                                ft.commit();

                                Fragment fragment2 = mnt_DOrdenLiquidacionGasto_Fragment.newInstance(OPCION, "lst_OrdenServicio_Fragment");
                                Bundle bundle2 = fragment2.getArguments();
                                bundle2.putSerializable("OrdenLiquidacionGasto",ol);
                                bundle2.putSerializable("tipo_entrada","NUEVO");
                                fragment2.setArguments(bundle2);
                                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                                ft2.replace(R.id.main_content, fragment2, "NewFragmentTag");
                                ft2.addToBackStack(null);
                                ft2.commit();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                               //NADA PASA
                            }
                        });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            } catch (Exception e){
                e.printStackTrace();

            }

        }

    }

}
