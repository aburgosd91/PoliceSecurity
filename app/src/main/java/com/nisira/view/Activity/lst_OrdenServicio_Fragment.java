package com.nisira.view.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Usuario;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.service.ConsumerService;
import com.nisira.core.service.TypeMethod;
import com.nisira.core.util.Util;
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
    FloatingActionButton fab_abrir,fab_filtrar;
    EditText edit_filtro;
    RelativeLayout rlfiltro;
    Usuario user ;
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
        user = Util.session_object(this.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lst_ordenservicio, container, false);

        // Inflate the layout for this fragment
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        fab_abrir = (FloatingActionButton)view.findViewById(R.id.fab_abrir);

        fab_filtrar = (FloatingActionButton)view.findViewById(R.id.fab_filtrar);
        rlfiltro = (RelativeLayout)view.findViewById(R.id.rlfiltro);
        edit_filtro = (EditText)view.findViewById(R.id.edit_filtro);
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);
        LlenarCampos();
        Listeners();
        return view;
    }



    public void LlenarCampos(){
        try {
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            listServCliente = ordenservicioclienteDao.listOrdenServicioxCliente(user);
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

    }
    public void Listeners(){
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
        fab_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlfiltro.setVisibility(View.VISIBLE);
            }
        });
        fab_filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    UsuarioDao user= new UsuarioDao();
                    listServCliente = ordenservicioclienteDao.listOrdenServicioxClienteFiltro(edit_filtro.getText().toString(),user.listar().get(0));
                    rlfiltro.setVisibility(View.GONE);
                    adapter = new Adapter_lst_OrdenServicio(mParam1,listServCliente,getFragmentManager());
                    recycler.setAdapter(adapter);
                    InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(edit_filtro.getWindowToken(), 0);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}
