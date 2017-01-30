package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getbase.floatingactionbutton.FloatingActionButton;

import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Lista_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Lista_Fragment extends Fragment {

    // TODO: ELEMENTOS DEL LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab_agregar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public Lista_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static Lista_Fragment newInstance(String param1, String param2) {
        Lista_Fragment fragment = new Lista_Fragment();
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
        fab_agregar = (FloatingActionButton) view.findViewById(R.id.fab_agregar);
        fab_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new mnt_DPersonalServicio_Fragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        // Inflate the layout for this fragment
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Cargar datos desde la BD(items)

        List<String> items;
        items = new ArrayList<>();
        items.add("Patos FTW");
        items.add("Prueba");
        items.add("Patos FTW");
        items.add("Prueba");
        items.add("Patos FTW");
        items.add("Prueba");
        items.add("Patos FTW");
        items.add("Prueba");

        // Crear un nuevo adaptador
        adapter = new Lista_Adapter(items);
        recycler.setAdapter(adapter);



        return view;
    }

    // TODO: TRANSICIONES Y ANIMACIONES

    public void animacionEntrada(){
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
    }

}
