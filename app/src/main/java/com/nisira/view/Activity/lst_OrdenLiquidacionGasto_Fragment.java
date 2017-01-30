package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.service.TypeMethod;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_PersonalServicio;

import java.util.List;

public class lst_OrdenLiquidacionGasto_Fragment extends FragmentNisira {

    // TODO: ELEMENTOS DEL LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab_agregar;
    private FloatingActionButton fab_modificar;
    private FloatingActionButton fab_eliminar;
    private SwipeRefreshLayout swiperefresh;

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
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        animacionEntrada();
        swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        fab_agregar = (FloatingActionButton) view.findViewById(R.id.fab_agregar);
        fab_modificar = (FloatingActionButton) view.findViewById(R.id.fab_modificar);
        fab_eliminar = (FloatingActionButton) view.findViewById(R.id.fab_eliminar);
        // Inflate the layout for this fragment
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Cargar datos desde la BD(items)
        try {
            ClieprovDao clieprovDao = new ClieprovDao();
            //List<Clieprov> listClieprov = (List<Clieprov>) Util.stringListObject("com.nisira.core.entity.Clieprov",result);
            List<Clieprov> listClieprov = clieprovDao.listar();
            // Crear un nuevo adaptador
            //adapter = new Adapter_edt_PersonalServicio(listClieprov);
            recycler.setAdapter(adapter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        // TODO: EVENTOS

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        fab_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new mnt_DPersonalServicio_Fragment(), "NewFragmentTag");
                ft.commit();
            }
        });
        fab_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new edt_OrdenServicio_Fragment(), "NewFragmentTag");
                ft.commit();
            }
        });
        fab_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new edt_OrdenServicio_Fragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        return view;
    }
    // TODO: TRANSICIONES Y ANIMACIONES

    public void animacionEntrada(){
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
        setEnterTransition(slide);
    }
    @Override
    public  void onPostExecuteWebService(ConsumerService cws, String result) {
        /*NO UTILIZADO*/
        if(cws.getMethod().trim().equals(TypeMethod.METHOD_LIST_CLIEPROV)){
        }
    }
}
