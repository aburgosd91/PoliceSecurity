package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_PersonalServicio;


import java.util.List;


public class edt_PersonalServicio_Fragment extends FragmentNisira {

    // TODO: Rename parameter arguments, choose names that match

    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Personal_servicio> list;
    private EditText txt_documento;
    private EditText txt_cliente;
    private TextView txt_estado;
    private TextInputEditText txt_producto;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private Dordenserviciocliente dordenserviciocliente;
    private Ordenserviciocliente ordenserviciocliente;
    private FloatingActionButton  btn_agregar,btn_modificar,btn_delete;

    public edt_PersonalServicio_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static edt_PersonalServicio_Fragment newInstance(String param1, String param2) {
        edt_PersonalServicio_Fragment fragment = new edt_PersonalServicio_Fragment();
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
            dordenserviciocliente = (Dordenserviciocliente) getArguments().getSerializable("DOrdenServicio");
            ordenserviciocliente = (Ordenserviciocliente) getArguments().getSerializable("OrdenServicio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edt_personalservicio, container, false);
        animacionEntrada();

        txt_documento = (EditText)view.findViewById(R.id.txt_documento);
        txt_cliente = (EditText)view.findViewById(R.id.txt_cliente);
        txt_producto = (TextInputEditText)view.findViewById(R.id.txt_producto);
        txt_estado = (TextView)view.findViewById(R.id.txt_estado);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_os);
        /******FIJOS PARA MANTENEDOR**************/
        btn_agregar = (FloatingActionButton)view.findViewById(R.id.fab_agregar);
        btn_modificar = (FloatingActionButton)view.findViewById(R.id.fab_modificar);
        btn_delete = (FloatingActionButton)view.findViewById(R.id.fab_eliminar);
        /*****************************************/
        Listeners();
        LlenarCampos();
        return view;
    }

    public void animacionEntrada(){
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
        setEnterTransition(slide);
    }

    public void LlenarCampos(){
        //TODO LLENAR CAMPOS
        txt_documento.setText(ordenserviciocliente.getIddocumento()+ " " +
                ordenserviciocliente.getSerie()+ "-"+
                ordenserviciocliente.getNumero());
        txt_cliente.setText(ordenserviciocliente.getCliente());
        txt_producto.setText(dordenserviciocliente.getDescripcion_servicio());
        if(ordenserviciocliente.getIdestado().equals("PE")){
            txt_estado.setText("Pendiente");
        }
        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        Personal_servicioDao  personal_servicioDao = new Personal_servicioDao();
        try {
            list = personal_servicioDao.listarxDordenservicio(dordenserviciocliente);
            Adapter_edt_PersonalServicio adapter = new Adapter_edt_PersonalServicio(list,getFragmentManager());
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Listeners(){
        //TODO EVENTOS

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<list.size();i++) {
                    if (list.get(i).isSeleccion()) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("DOrdenServicio", dordenserviciocliente);
                        bundle.putSerializable("PersonalServicio", list.get(i));
                        Fragment fragment = mnt_PersonalServicio_Fragment.newInstance("Asignacion Personal", "Modificar");
                        fragment.setArguments(bundle);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    }
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DEFINIR
            }
        });
    }

}
