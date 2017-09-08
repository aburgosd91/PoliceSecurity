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
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class mnt_PersonalServicio_Fragment extends Fragment {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String OPCION = "param1";
    private static final String TIPO = "param2";
    private Personal_servicio personal_servicio;
    private Clieprov clieprov;
    private Dordenserviciocliente dordenserviciocliente;
    private AutoCompleteTextView txt_vehiculos;
    private AutoCompleteTextView campo_personal;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;
    private TextView txt_titulo;
    private EditText campo_ID,campo_numero,campo_cargo,txt_checklist,txt_nrocontenedor,txt_nroprecinto,txt_nroServicio,txt_PlacaCliente,txt_Conductor,txt_Brevete;
    List<Clieprov> list_ps = new ArrayList<>();
    List<Personal_servicio> list_personal = new ArrayList<>();
    List<String> empleados = new ArrayList<>();
    List<Consumidor> list_consumidors= new ArrayList<>();


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
        txt_checklist = (EditText) view.findViewById(R.id.txt_checklist);
        txt_nrocontenedor = (EditText) view.findViewById(R.id.txt_nrocontenedor);
        txt_nroprecinto = (EditText) view.findViewById(R.id.txt_nroprecinto);
        txt_nroServicio = (EditText) view.findViewById(R.id.txt_nroservicio);
        txt_Conductor = (EditText) view.findViewById(R.id.txt_ConductorCliente);
        txt_PlacaCliente = (EditText) view.findViewById(R.id.txt_PlacaCliente);
        txt_Brevete = (EditText) view.findViewById(R.id.txt_BreveteCliente);

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
    public  void SettearCampos(){

        Personal_servicio personal_servicio1=personal_servicio;

        personal_servicio1.setChecklist(Util.isnull(personal_servicio.getChecklist(),"").equals("")?txt_checklist.getText().toString():personal_servicio.getChecklist().toString());
        personal_servicio1.setNrocontenedor(Util.isnull(personal_servicio.getNrocontenedor(),"").equals("")?txt_nrocontenedor.getText().toString():personal_servicio.getNrocontenedor().toString());
        personal_servicio1.setNroprecinto(Util.isnull(personal_servicio.getNroprecinto(),"").equals("")?txt_nroprecinto.getText().toString():personal_servicio.getNroprecinto().toString());
        personal_servicio1.setNro_oservicio(Util.isnull(personal_servicio.getNro_oservicio(),"").equals("")?txt_nroServicio.getText().toString():personal_servicio.getNro_oservicio().toString());
        personal_servicio1.setPlaca_cliente(Util.isnull(personal_servicio.getPlaca_cliente(),"").equals("")?txt_PlacaCliente.getText().toString():personal_servicio.getPlaca_cliente().toString());
        personal_servicio1.setConductor_cliente(Util.isnull(personal_servicio.getConductor_cliente(),"").equals("")?txt_Conductor.getText().toString():personal_servicio.getConductor_cliente());
        personal_servicio1.setBrevete_cliente(Util.isnull(personal_servicio.getBrevete_cliente(),"").equals("")?txt_Brevete.getText().toString():personal_servicio.getBrevete_cliente().toString());


          /*  personal_servicio1.setChecklist(txt_checklist.getText().toString());
            personal_servicio1.setNrocontenedor(txt_nrocontenedor.getText().toString());
            personal_servicio1.setNroprecinto(txt_nroprecinto.getText().toString());
            personal_servicio1.setNro_oservicio(txt_nroServicio.getText().toString());
            personal_servicio1.setPlaca_cliente(txt_PlacaCliente.getText().toString());
            personal_servicio1.setConductor_cliente(txt_Conductor.getText().toString());
            personal_servicio1.setBrevete_cliente(txt_Brevete.getText().toString());

        if(Util.isnull(personal_servicio.getChecklist(),"").equals(""))
            personal_servicio1.setChecklist(txt_checklist.getText().toString());
        if(Util.isnull(personal_servicio.getNrocontenedor(),"").equals(""))
            personal_servicio1.setNrocontenedor(txt_nrocontenedor.getText().toString());
        if(Util.isnull(personal_servicio.getNroprecinto(),"").equals(""))
            personal_servicio1.setNroprecinto(txt_nroprecinto.getText().toString());
        if(Util.isnull(personal_servicio.getNro_oservicio(),"").equals(""))
            personal_servicio1.setNro_oservicio(txt_nroServicio.getText().toString());
        if(Util.isnull(personal_servicio.getPlaca_cliente(),"").equals(""))
            personal_servicio1.setPlaca_cliente(txt_PlacaCliente.getText().toString());
        if(Util.isnull(personal_servicio.getConductor_cliente(),"").equals(""))
            personal_servicio1.setConductor_cliente(txt_Conductor.getText().toString());
        if(Util.isnull(personal_servicio.getBrevete_cliente(),"").equals(""))
            personal_servicio1.setBrevete_cliente(txt_Brevete.getText().toString());**/

    }


    public void LlenarCampos(){

        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.mnt_PersonalServicio));

        campo_ID.setText(personal_servicio.getItem2().toString());
        campo_cargo.setText(personal_servicio.getDescripcion_cargo().toString());
        campo_numero.setText(personal_servicio.getDni().toString());
        campo_personal.setText(personal_servicio.getNombres().toString());
        txt_vehiculos.setText(personal_servicio.getIdvehiculo().toString());

        txt_checklist.setText(personal_servicio.getChecklist().toString());
        txt_nrocontenedor.setText(personal_servicio.getNrocontenedor().toString());
        txt_nroprecinto.setText(personal_servicio.getNroprecinto().toString());
        txt_nroServicio.setText(personal_servicio.getNro_oservicio().toString());
        txt_PlacaCliente.setText(personal_servicio.getPlaca_cliente().toString());
        txt_Conductor.setText(personal_servicio.getConductor_cliente().toString());
        txt_Brevete.setText(personal_servicio.getBrevete_cliente().toString());
        txt_titulo.setText("Modificar");

        ClieprovDao clieprovDao = new ClieprovDao();
        Personal_servicioDao personal_servicioDao = new Personal_servicioDao();

        ConsumidorDao consumidorDao = new ConsumidorDao();


        try {
            list_personal=personal_servicioDao.getListPersonal_servicio();
            list_ps = clieprovDao.getPersonalxTipo(dordenserviciocliente.getIdempresa(),"E");
            for(int i =0;i<list_personal.size();i++){
                for(int j =0; j<list_ps.size();j++){
                    if(list_ps.get(j).getDni().equals(list_personal.get(i).getDni())){
                        list_ps.remove(list_ps.get(j));
                    }
                }
            }

            for(int i=0;i<list_ps.size();i++){
                empleados.add(list_ps.get(i).getNombres() + " "+
                        list_ps.get(i).getApellidopaterno()+" "+
                        list_ps.get(i).getApellidomaterno());
            }
           list_consumidors = consumidorDao.ListarConsumidor(dordenserviciocliente.getIdempresa());
            for(int i=0;i<list_personal.size();i++){
                for(int j=0;j<list_consumidors.size();j++){
                    if(list_consumidors.get(j).getIdconsumidor().equals(list_personal.get(i).getIdvehiculo())){
                        list_consumidors.remove(list_consumidors.get(j));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<Clieprov> adapterps = new ArrayAdapter<Clieprov>(getContext(),
                android.R.layout.simple_dropdown_item_1line,list_ps);
        campo_personal.setThreshold(1);
        campo_personal.setAdapter(adapterps);

        ArrayAdapter<Consumidor> adapter = new ArrayAdapter<Consumidor>(getContext(),
                android.R.layout.simple_dropdown_item_1line,list_consumidors);
        txt_vehiculos.setThreshold(1);
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

                //campo_ID.setText(selected.getIdempresa().toString());
                campo_numero.setText(selected.getDni().toString() );


               personal_servicio1.setIdpersonal(selected.getIdclieprov().toString());
                personal_servicio1.setNombres(selected.getApellidopaterno().toString()+" "+
                        selected.getApellidomaterno()+" "+selected.getNombres().toString());
                personal_servicio1.setDni(selected.getDni().toString());

                Log.i("Clicked " , selected.getIdclieprov().toString()+ " " + selected.getApellidopaterno().toString() );
                //campo_numero.setText(selected.getDni().toString());
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
                SettearCampos();

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