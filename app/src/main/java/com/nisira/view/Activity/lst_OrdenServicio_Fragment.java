package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.service.TypeMethod;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_lst_OrdenServicio;

import java.util.List;

public class lst_OrdenServicio_Fragment extends FragmentNisira {

    // TODO: ELEMENTOS DEL LAYOUT
    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private SwipeRefreshLayout swipeRefresh;
    List<Ordenserviciocliente> listServCliente;
    OrdenservicioclienteDao ordenservicioclienteDao;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public lst_OrdenServicio_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static lst_OrdenServicio_Fragment newInstance(String param1, String param2) {
        lst_OrdenServicio_Fragment fragment = new lst_OrdenServicio_Fragment();
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
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Cargar datos desde la BD(items)

        try {
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            listServCliente = ordenservicioclienteDao.listOrdenServicioxCliente();
            // Crear un nuevo adaptador
            adapter = new Adapter_lst_OrdenServicio(mParam1,listServCliente,getFragmentManager());
            recycler.setAdapter(adapter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        // TODO: EVENTOS

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    listServCliente = ordenservicioclienteDao.listOrdenServicioxCliente();
                    adapter.notifyDataSetChanged();
                    swipeRefresh.setRefreshing(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
