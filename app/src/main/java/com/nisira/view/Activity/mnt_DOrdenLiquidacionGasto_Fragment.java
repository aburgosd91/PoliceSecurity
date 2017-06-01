package com.nisira.view.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.TipogastoDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;

import org.kxml2.kdom.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class mnt_DOrdenLiquidacionGasto_Fragment extends FragmentNisira {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Dordenliquidaciongasto dordenliquidaciongasto;
    private Ordenliquidaciongasto ordenliquidaciongasto;

    private AutoCompleteTextView list_concepto;
    private AutoCompleteTextView campo_proveedor;
    private AutoCompleteTextView campo_concepto;
    private AutoCompleteTextView campo_destino;

    private EditText txtfecha;

    private Spinner spinner_tipoPago;

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
        txtfecha = (EditText)view.findViewById(R.id.txt_fecha);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_aceptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        spinner_tipoPago = (Spinner)view.findViewById(R.id.spinnerpago);
        list_concepto = (AutoCompleteTextView)view.findViewById(R.id.list_concepto);
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
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate="";
        sm = new SimpleDateFormat("dd-MM-yyyy");
        strDate = sm.format(Calendar.getInstance().getTime());
        txtfecha.setText(strDate);
        TipogastoDao daogasto_concepto = new TipogastoDao();
        DocumentosDao daodocs_tipodoc = new DocumentosDao();
        try {
            List<Documentos> lista = new ArrayList<>();
            lista = daodocs_tipodoc.listar_comprobantes();
            ArrayAdapter<Documentos> adapterps = new ArrayAdapter<>(this.getActivity(),
                    android.R.layout.simple_spinner_item, lista);
            adapterps.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_tipoPago.setAdapter(adapterps);
        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        try {
            List<Documentos>
            ArrayAdapter<Consumidor> adapter = new ArrayAdapter<Consumidor>(getContext(),
                    android.R.layout.simple_dropdown_item_1line, consumidors);
            list_concepto.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }
*/
    }

    public void Listeners(){
        //TODO EVENTOS
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        txtfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                now.getTime();
                DatePickerDialog tpd1 = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                txtfecha.setText(dayOfMonth+"-"+month+1+"-"+year);
                            }
                        },now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                tpd1.show();
            }
        });
    }

}
