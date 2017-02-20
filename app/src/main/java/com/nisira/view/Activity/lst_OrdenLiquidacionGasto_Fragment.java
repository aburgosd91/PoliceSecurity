package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.service.TypeMethod;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_lst_OrdenLiquidacionGasto;
import com.nisira.view.Adapter.Adapter_lst_OrdenServicio;

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
    OrdenliquidaciongastoDao dao;

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

        View view = inflater.inflate(R.layout.fragment_lst_ordenservicio, container, false);
        animacionEntrada();
        // Inflate the layout for this fragment
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swiperefresh);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Cargar datos desde la BD(items)
        try {
            dao = new OrdenliquidaciongastoDao();
            //List<Clieprov> listClieprov = (List<Clieprov>) Util.stringListObject("com.nisira.core.entity.Clieprov",result);
            listServCliente = dao.listar();
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

        // TODO: EVENTOS

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    dao = new OrdenliquidaciongastoDao();
                    listServCliente = dao.listar();
                    adapter.notifyDataSetChanged();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
    // TODO: TRANSICIONES Y ANIMACIONES

    public void animacionEntrada(){
        Fade slide = (Fade) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_fade);
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
