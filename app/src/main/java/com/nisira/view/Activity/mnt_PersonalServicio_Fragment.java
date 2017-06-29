package com.nisira.view.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Consumidor;
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
    private AutoCompleteTextView txt_vehiculos;
    private AutoCompleteTextView campo_personal;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;
    private TextView txt_titulo;
    private EditText campo_ID,campo_numero,campo_cargo;
    List<Clieprov> list_ps = new ArrayList<>();
    List<String> empleados = new ArrayList<>();

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

        campo_numero = (EditText) view.findViewById(R.id.campo_numero);
        campo_ID = (EditText) view.findViewById(R.id.campo_ID);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_acaptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        campo_cargo = (EditText)view.findViewById(R.id.campo_cargo);
        txt_titulo = (TextView) view.findViewById(R.id.txt_titulo);
        campo_personal = (AutoCompleteTextView)view.findViewById(R.id.campo_personal);
        txt_vehiculos = (AutoCompleteTextView) view.findViewById(R.id.txt_vehiculos_ps);
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

        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.mnt_PersonalServicio));

        campo_ID.setText(personal_servicio.getItem2());
        campo_cargo.setText(personal_servicio.getDescripcion_cargo());
        campo_numero.setText(personal_servicio.getDni());
        campo_personal.setText(personal_servicio.getNombres());
        txt_vehiculos.setText(personal_servicio.getIdvehiculo());
        txt_titulo.setText("Modificar");

        ClieprovDao clieprovDao = new ClieprovDao();

        ConsumidorDao dao = new ConsumidorDao();
        List<Consumidor> consumidors= new ArrayList<>();

        try {
            list_ps = clieprovDao.getPersonalxTipo(dordenserviciocliente.getIdempresa(),"E");
            for(int i=0;i<list_ps.size();i++){
                empleados.add(list_ps.get(i).getNombres() + " "+
                        list_ps.get(i).getApellidopaterno()+" "+
                        list_ps.get(i).getApellidomaterno());
            }
            consumidors = dao.ListarConsumidor(personal_servicio.getIdempresa());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<Clieprov> adapterps = new ArrayAdapter<Clieprov>(getContext(),
                android.R.layout.simple_dropdown_item_1line,list_ps);
        campo_personal.setThreshold(1);
        campo_personal.setAdapter(adapterps);

        ArrayAdapter<Consumidor> adapter = new ArrayAdapter<Consumidor>(getContext(),
                android.R.layout.simple_dropdown_item_1line,consumidors);
        txt_vehiculos.setAdapter(adapter);

    }

    public void Listeners(){
        //TODO EVENTOS
        final Personal_servicio personal_servicio1 = personal_servicio;
        campo_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campo_personal.setText("");
            }
        });
        campo_personal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Clieprov selected = (Clieprov) parent.getAdapter().getItem(position);
                personal_servicio1.setIdpersonal(selected.getIdclieprov());
                personal_servicio1.setNombres(selected.getApellidopaterno()+" "+
                        selected.getApellidomaterno()+" "+selected.getNombres());
                personal_servicio1.setDni(selected.getDni());
                Log.i("Clicked " , selected.getIdclieprov()+ " " + selected.getApellidopaterno() );
                campo_numero.setText(selected.getDni());
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        btn_acaptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
                try {
                    personal_servicioDao.mezclarLocal(personal_servicio1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Toast.makeText(getContext(),"Modificado con exito",Toast.LENGTH_SHORT);
                getActivity().onBackPressed();
            }
        });
        txt_vehiculos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Consumidor selected = (Consumidor) parent.getAdapter().getItem(position);
                personal_servicio1.setIdvehiculo(selected.getIdconsumidor());
                Log.i("Clicked " , selected.getIdconsumidor() + " " + selected.getDescripcion());
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            }
        });
    }


}
