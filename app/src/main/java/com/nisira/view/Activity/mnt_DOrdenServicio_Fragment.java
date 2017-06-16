package com.nisira.view.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.gcalderon.policesecurity.R;

import java.util.ArrayList;
import java.util.List;


public class mnt_DOrdenServicio_Fragment extends Fragment {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Ordenserviciocliente ordenserviciocliente;
    private Dordenserviciocliente dordenserviciocliente;
    private AutoCompleteTextView txt_vehiculos;
    private AutoCompleteTextView txtplaca;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public mnt_DOrdenServicio_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static mnt_DOrdenServicio_Fragment newInstance(String param1, String param2) {
        mnt_DOrdenServicio_Fragment fragment = new mnt_DOrdenServicio_Fragment();
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
            ordenserviciocliente = (Ordenserviciocliente) getArguments().getSerializable("OrdenServicio");
            dordenserviciocliente = (Dordenserviciocliente)getArguments().getSerializable("DOrdenServicio");
        }
    }
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mnt_dordenservicio_vehiculo, container, false);
        animacionEntrada();

        txtplaca = (AutoCompleteTextView)view.findViewById(R.id.txtplaca);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_acaptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        txt_vehiculos = (AutoCompleteTextView) view.findViewById(R.id.txt_vehiculos);
        LlenarCampos();
        Listeners();
        return view;
    }

    public void animacionEntrada(){
        // TODO: TRANSICIONES Y ANIMACIONES
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            Fade fade = (Fade) TransitionInflater.from(this.getContext()).inflateTransition(R.transition.activity_fade);
            setEnterTransition(fade);
            Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
            setExitTransition(slide);
        }
    }

    public void LlenarCampos(){
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.mnt_DPersonalServicio));
        txt_vehiculos.setText(dordenserviciocliente.getIdvehiculo());
        txtplaca.setText(dordenserviciocliente.getPlaca_cliente());
        ConsumidorDao dao = new ConsumidorDao();
        List<Consumidor> consumidors= new ArrayList<>();
        try {
            consumidors = dao.ListarConsumidor(ordenserviciocliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<Consumidor> adapter = new ArrayAdapter<Consumidor>(getContext(),
                android.R.layout.simple_dropdown_item_1line,consumidors);
        txtplaca.setAdapter(adapter);
    }

    public void Listeners(){
        //TODO EVENTOS

        txtplaca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Consumidor selected = (Consumidor) parent.getAdapter().getItem(position);
                dordenserviciocliente.setPlaca_cliente(txtplaca.getText().toString());
                dordenserviciocliente.setIdvehiculo(selected.getIdconsumidor());
                txt_vehiculos.setText(selected.getDescripcion());
                Log.i("Clicked " , selected.getIdconsumidor() + " " + selected.getDescripcion());
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

                if (dordenserviciocliente.getPlaca_cliente()==null && dordenserviciocliente.getPlaca_cliente().equals("")) {
                    Snackbar.make(getView(), "Error, seleccione una placa", Snackbar.LENGTH_SHORT).show();
                } else {

                    DordenservicioclienteDao dao = new DordenservicioclienteDao();
                    try {
                        dao.mezclarLocal(dordenserviciocliente);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getActivity().onBackPressed();
                }
            }
        });

    }

}
