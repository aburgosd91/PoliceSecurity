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
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_DOrdenServicio;
import com.nisira.view.Adapter.Adapter_edt_DOrdenServicio_vehiculo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class edt_OrdenServicio_Fragment extends FragmentNisira {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextInputEditText txt_documento;
    private TextInputEditText txt_cliente;
    private TextInputEditText txt_nromanual;
    private TextInputEditText txt_nrocont;
    private TextInputEditText txt_nroprecinto;
    private TextInputEditText txt_nroservicio;
    private TextView txt_fecha;
    private TextView txt_estado;
    private FloatingActionsMenu multiple_fab;
    private FloatingActionButton fab_modificar;
    List<Dordenserviciocliente> lstordenserviciocliente = new ArrayList<>();
    DordenservicioclienteDao  DordenservicioclienteDao;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private Ordenserviciocliente ordenserviciocliente;


    public edt_OrdenServicio_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static edt_OrdenServicio_Fragment newInstance(String param1, String param2) {
        edt_OrdenServicio_Fragment fragment = new edt_OrdenServicio_Fragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edt__dorden_servicio, container, false);
        animacionEntrada();
        txt_documento = (TextInputEditText)view.findViewById(R.id.txt_documento);
        txt_cliente = (TextInputEditText)view.findViewById(R.id.txt_ordenservicio);
        txt_nrocont = (TextInputEditText)view.findViewById(R.id.txt_nrocont);
        txt_nromanual = (TextInputEditText)view.findViewById(R.id.txt_nromanual);
        txt_nroprecinto = (TextInputEditText)view.findViewById(R.id.txt_nroprecinto);
        txt_nroservicio = (TextInputEditText)view.findViewById(R.id.txt_nroservicio);
        txt_fecha = (TextView)view.findViewById(R.id.txt_fecha);
        txt_estado = (TextView)view.findViewById(R.id.txt_estado);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_os);
        multiple_fab = (FloatingActionsMenu) view.findViewById(R.id.multiple_fab);
        fab_modificar = (FloatingActionButton)view.findViewById(R.id.fab_modificar);
        LlenarCampos();
        Listeners();
        return view;
    }
    

    public void animacionEntrada(){
        Slide slide = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
            setExitTransition(slide);
            setEnterTransition(slide);
        }

    }

    public void LlenarCampos(){
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.edt_OrdenServicio));
        txt_nrocont.setText(ordenserviciocliente.getNrocontenedor());
        txt_nromanual.setText(ordenserviciocliente.getNromanual());
        txt_nroprecinto.setText(ordenserviciocliente.getNroprecinto());
        txt_nroservicio.setText(ordenserviciocliente.getNro_oservicio());

        txt_documento.setText(ordenserviciocliente.getIddocumento()+"-"+ ordenserviciocliente.getSerie()+ "-"+ ordenserviciocliente.getNumero());
        txt_documento.setHint("Documento: ");
        txt_cliente.setText(ordenserviciocliente.getCliente());
        txt_cliente.setHint("Cliente:");
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(ordenserviciocliente.getFecha());
        txt_fecha.setText(strDate);

        String estado = ordenserviciocliente.getIdestado();
        if(estado.equals("PE")){
            txt_estado.setText("Pendiente");
        }


        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        DordenservicioclienteDao = new DordenservicioclienteDao();
        try {
            lstordenserviciocliente = DordenservicioclienteDao.ListarxOrdenServicio(ordenserviciocliente);
            switch (mParam1){
                case "Asignacion Personal":
                case "Registro Hora":
                    adapter = new Adapter_edt_DOrdenServicio(mParam1,lstordenserviciocliente,getFragmentManager(),ordenserviciocliente);
                    recyclerView.setAdapter(adapter);
                    multiple_fab.setVisibility(View.GONE);
                    break;
                case "Registro Vehiculo":
                    adapter = new Adapter_edt_DOrdenServicio_vehiculo(mParam1,lstordenserviciocliente,getFragmentManager(),ordenserviciocliente);
                    recyclerView.setAdapter(adapter);
                    multiple_fab.setVisibility(View.VISIBLE);
                    break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Listeners(){



            fab_modificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (int i = 0; i < lstordenserviciocliente.size(); i++) {
                        if (lstordenserviciocliente.get(i).isSeleccion()) {
                            Fragment fragment = mnt_DOrdenServicio_Fragment.newInstance(OPCION, "Modificar");
                            Bundle bundle = fragment.getArguments();
                            bundle.putSerializable("OrdenServicio", ordenserviciocliente);
                            bundle.putSerializable("DOrdenServicio",lstordenserviciocliente.get(i));
                            fragment.setArguments(bundle);
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    }
                }
            });
    }
}
