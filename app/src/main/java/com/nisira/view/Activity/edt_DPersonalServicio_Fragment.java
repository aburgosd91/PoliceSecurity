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
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_DPersonalServicio;
import com.nisira.view.Adapter.Adapter_edt_PersonalServicio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static android.view.View.GONE;


public class edt_DPersonalServicio_Fragment extends FragmentNisira {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";
    private Ordenserviciocliente ordenserviciocliente;
    private Dordenserviciocliente dordenserviciocliente;
    private Personal_servicio personal_servicio;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText txt_documento;
    private TextInputEditText txt_personal,txt_producto;
    private TextView txt_fecha,txt_estado;
    private RecyclerView recyclerView;
    private Adapter_edt_DPersonalServicio adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton btn_agregar,btn_modificar,btn_delete;
    private List<Dpersonal_servicio> list;
    private FloatingActionsMenu multiple_fab;

    public edt_DPersonalServicio_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static edt_DPersonalServicio_Fragment newInstance(String param1, String param2) {
        edt_DPersonalServicio_Fragment fragment = new edt_DPersonalServicio_Fragment();
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
            ordenserviciocliente = (Ordenserviciocliente) getArguments().getSerializable("OrdenServicio");
            personal_servicio = (Personal_servicio)getArguments().getSerializable("PersonalServicio");
            dordenserviciocliente = (Dordenserviciocliente)getArguments().getSerializable("DOrdenServicio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edt_dpersonalservicio, container, false);
        animacionEntrada();
        txt_documento = (EditText)view.findViewById(R.id.txt_documento);
        txt_personal = (TextInputEditText) view.findViewById(R.id.txt_personal);
        txt_producto = (TextInputEditText)view.findViewById(R.id.txt_producto);
        txt_fecha = (TextView)view.findViewById(R.id.txt_fecha);
        txt_estado = (TextView)view.findViewById(R.id.txt_estado);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_os);
        multiple_fab = (FloatingActionsMenu)view.findViewById(R.id.multiple_fab);
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
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo);
        view.setText(getString(R.string.edt_DPersonalServicio));
        txt_documento.setText(ordenserviciocliente.getIddocumento()+ " " +
                ordenserviciocliente.getSerie()+ "-"+
                ordenserviciocliente.getNumero());
        txt_personal.setText(personal_servicio.getNombres());
        txt_producto.setText(dordenserviciocliente.getDescripcion_servicio());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(personal_servicio.getFechaoperacion());
        txt_fecha.setText(strDate);
        if(ordenserviciocliente.getIdestado().equals("PE")){
            txt_estado.setText("Pendiente");
        }
        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        Dpersonal_servicioDao Dpersonal_servicioDao = new Dpersonal_servicioDao();
        try {
            list = Dpersonal_servicioDao.listarxPersonalServicio(personal_servicio);
            switch (mParam1){
                case "Registro Hora":
                     adapter = new Adapter_edt_DPersonalServicio(mParam1,list,
                            getFragmentManager(),personal_servicio);
                    recyclerView.setAdapter(adapter);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Listeners(){
        //TODO EVENTOS

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dpersonal_servicio dpersonal_servicio = new Dpersonal_servicio();
                dpersonal_servicio.setIdcargo(personal_servicio.getIdcargo());
                dpersonal_servicio.setIdempresa(personal_servicio.getIdempresa());
                dpersonal_servicio.setItem_dordenservicio(personal_servicio.getItem());
                dpersonal_servicio.setItem2(personal_servicio.getItem2());
                dpersonal_servicio.setIdordenservicio(personal_servicio.getIdordenservicio());
                dpersonal_servicio.setFecharegistro(Calendar.getInstance().getTime());

                Fragment fragment = mnt_DPersonalServicio_Fragment.newInstance(mParam1, "Agregar");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("DOrdenServicio", dordenserviciocliente);
                bundle.putSerializable("DPersonalServicio",dpersonal_servicio);
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<list.size();i++) {

                    if (list.get(i).isSeleccion()) {

                        Fragment fragment = mnt_DPersonalServicio_Fragment.newInstance(mParam1, "Modificar");
                        Bundle bundle = fragment.getArguments();
                        bundle.putSerializable("DOrdenServicio", dordenserviciocliente);
                        bundle.putSerializable("DPersonalServicio", list.get(i));
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
                for(int i=0;i<list.size();i++) {

                    if (list.get(i).isSeleccion()) {
                        Dpersonal_servicioDao dao = new Dpersonal_servicioDao();
                        try {
                            dao.Eliminar(list.get(i));
                            list.remove(i);
                            adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

}
