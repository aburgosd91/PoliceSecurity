package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.gcalderon.policesecurity.R;

import java.util.ArrayList;
import java.util.List;

public class mnt_PersonalServicio_Fragment extends Fragment {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String OPCION = "param1";
    private static final String TIPO = "param2";
    private Personal_servicio personal_servicio;
    private Dordenserviciocliente dordenserviciocliente;
    private AutoCompleteTextView listbox,campo_personal;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;
    private TextView txt_titulo;
    private EditText campo_ID,campo_numero;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public mnt_PersonalServicio_Fragment() {
        // Required empty public constructor
    }

    public static mnt_PersonalServicio_Fragment newInstance(String param1, String param2) {
        mnt_PersonalServicio_Fragment fragment = new mnt_PersonalServicio_Fragment();
        Bundle args = new Bundle();
        args.putString(OPCION, param1);
        args.putString(TIPO, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(OPCION);
            mParam2 = getArguments().getString(TIPO);
            dordenserviciocliente = (Dordenserviciocliente) getArguments().getSerializable("DOrdenServicio");
            personal_servicio = (Personal_servicio) getArguments().getSerializable("PersonalServicio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mnt_personalservicio, container, false);
        animacionEntrada();

        campo_numero = (EditText) view.findViewById(R.id.campo_personal);
        campo_ID = (EditText) view.findViewById(R.id.campo_ID);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_acaptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        listbox = (AutoCompleteTextView) view.findViewById(R.id.autocompletetext1);
        txt_titulo = (TextView) view.findViewById(R.id.txt_titulo);
        campo_personal = (AutoCompleteTextView)view.findViewById(R.id.campo_personal);
        LlenarCampos();
        Listeners();

        return view;
    }

    public void animacionEntrada(){
        // TODO: TRANSICIONES Y ANIMACIONES
        Fade fade = (Fade) TransitionInflater.from(this.getContext()).inflateTransition(R.transition.activity_fade);
        setEnterTransition(fade);
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
    }

    public void LlenarCampos(){

        String[] NOMBRES = new String[] {
                "Gian", "Giancarlo", "Alex", "Andy","Ayrton","Acevedo","Antonela","Antony","Antonio"
                ,"André", "Joshe", "Alejandro","Aldo"
        };
        campo_ID.setText(personal_servicio.getItem2());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line,NOMBRES);
        listbox.setAdapter(adapter);

        txt_titulo.setText(TIPO);

        Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
        List<Personal_servicio> list_ps = new ArrayList<>();
        try {
            list_ps = personal_servicioDao.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<Personal_servicio> adapterps = new ArrayAdapter<Personal_servicio>(getContext(),
                android.R.layout.simple_dropdown_item_1line,list_ps);
        campo_personal.setAdapter(adapterps);
    }

    public void Listeners(){
        //TODO EVENTOS
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        btn_acaptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getFragmentManager().popBackStack();
            }
        });
    }


}
