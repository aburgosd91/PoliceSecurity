package com.nisira.view.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;

import java.util.List;


public class mnt_DOrdenLiquidacionGasto_Fragment extends FragmentNisira {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Dordenliquidaciongasto dordenliquidaciongasto;
    private Ordenliquidaciongasto ordenliquidaciongasto;

    private AutoCompleteTextView listbox;
    private AutoCompleteTextView campo_proveedor;
    private AutoCompleteTextView campo_concepto;
    private AutoCompleteTextView campo_destino;


    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_aceptar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public mnt_DOrdenLiquidacionGasto_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static mnt_DOrdenLiquidacionGasto_Fragment newInstance(String param1, String param2) {
        mnt_DOrdenLiquidacionGasto_Fragment fragment = new mnt_DOrdenLiquidacionGasto_Fragment();
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
            ordenliquidaciongasto = (Ordenliquidaciongasto) getArguments().getSerializable("OrdenLiquidacionGasto");
            dordenliquidaciongasto = (Dordenliquidaciongasto) getArguments().getSerializable("DOrdenLiquidacionGasto");
        }
    }
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mnt_dordenliquidaciongasto2, container, false);
        animacionEntrada();
        TextView view1 = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view1.setText(getString(R.string.mnt_DOrdenLiquidacionGasto));
        //campo_proveedor = (AutoCompleteTextView)view.findViewById(R.id.campo_proveedor);
        //campo_concepto = (AutoCompleteTextView)view.findViewById(R.id.campo_concepto);
        //campo_destino = (AutoCompleteTextView)view.findViewById(R.id.campo_destino);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_aceptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);

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
        /*
        ClieprovDao dao = new ClieprovDao();
        try {
            List<Clieprov> list = dao.getPersonalxTipo(dordenliquidaciongasto.getIdempresa(),"P");
            ArrayAdapter<Clieprov> adapter = new ArrayAdapter<Clieprov>(getContext(),
                    android.R.layout.simple_dropdown_item_1line,list);
            campo_proveedor.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Concepto_cuentaDao dao1 = new Concepto_cuentaDao();
        try {
            List<Concepto_cuenta> list2 = dao1.ListarConsumidor(dordenliquidaciongasto);
            ArrayAdapter<Concepto_cuenta> adapter = new ArrayAdapter<Concepto_cuenta>(getContext(),
                    android.R.layout.simple_dropdown_item_1line,list2);
            campo_concepto.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }


        DestinoadquisicionDao dao2 = new DestinoadquisicionDao();
        try {
            List<Destinoadquisicion> list3 = dao2.listar();
            ArrayAdapter<Destinoadquisicion> adapter = new ArrayAdapter<Destinoadquisicion>(getContext(),
                    android.R.layout.simple_dropdown_item_1line,list3);
            campo_concepto.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public void Listeners(){
        //TODO EVENTOS
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}
