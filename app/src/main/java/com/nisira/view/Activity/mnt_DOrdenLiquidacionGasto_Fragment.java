package com.nisira.view.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.TipogastoDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Tipogasto;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;

import org.kxml2.kdom.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class mnt_DOrdenLiquidacionGasto_Fragment extends FragmentNisira {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Dordenliquidaciongasto dordenliquidaciongasto;
    private Ordenliquidaciongasto ordenliquidaciongasto;
    public static String OPCION;
    public static String ANTERIOR;

    private AutoCompleteTextView list_concepto;
    private AutoCompleteTextView campo_proveedor;
    private AutoCompleteTextView campo_concepto;
    private AutoCompleteTextView campo_destino;

    private EditText txtfecha,txtmonto,txtserie,txtnumero,txtruc,txtdetalle;

    private CheckBox checkboxIGV;

    private Spinner spinner_tipoPago;

    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_aceptar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;
    private String tipo_entrada;

    public mnt_DOrdenLiquidacionGasto_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static mnt_DOrdenLiquidacionGasto_Fragment newInstance(String param1, String param2) {
        mnt_DOrdenLiquidacionGasto_Fragment fragment = new mnt_DOrdenLiquidacionGasto_Fragment();
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
            mParam2 = getArguments().getString(ANTERIOR);
            mParam1 = getArguments().getString(OPCION);
            tipo_entrada = (String)getArguments().getSerializable("tipo_entrada");
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
        txtmonto = (EditText)view.findViewById(R.id.txtmonto);
        txtserie = (EditText)view.findViewById(R.id.txtserie);
        txtnumero = (EditText)view.findViewById(R.id.txtnumero);
        txtruc = (EditText)view.findViewById(R.id.txtruc);
        txtdetalle = (EditText)view.findViewById(R.id.txtdetalle);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_aceptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        spinner_tipoPago = (Spinner)view.findViewById(R.id.spinnerpago);
        list_concepto = (AutoCompleteTextView)view.findViewById(R.id.list_concepto);
        checkboxIGV = (CheckBox)view.findViewById(R.id.checkboxIGV);
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
        List<Documentos> lista1 = new ArrayList<>();
        try{
            TipogastoDao daogasto_concepto = new TipogastoDao();
            DocumentosDao daodocs_tipodoc = new DocumentosDao();
            /*+++++SPINNER++++++*/

            lista1 = daodocs_tipodoc.listar_comprobantes();
            ArrayAdapter<Documentos> adapterps = new ArrayAdapter<>(this.getActivity(),
                    android.R.layout.simple_spinner_item, lista1);
            adapterps.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_tipoPago.setAdapter(adapterps);
                    /*+++++AUTOCOMPLETE++++++*/
            List<Tipogasto> listatg = new ArrayList<>();
            listatg = daogasto_concepto.listar();
            ArrayAdapter<Tipogasto> adapter = new ArrayAdapter<Tipogasto>(getContext(),
                    android.R.layout.simple_dropdown_item_1line, listatg);
            list_concepto.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (tipo_entrada) {
            case "NUEVO":
                try {
                    strDate = sm.format(Calendar.getInstance().getTime());
                    txtfecha.setText(strDate);
                    dordenliquidaciongasto = new Dordenliquidaciongasto();
                    DordenliquidaciongastoDao dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
                    List<Dordenliquidaciongasto> dordenliquidaciongastoList = dordenliquidaciongastoDao.listarxOrdenLG(ordenliquidaciongasto);
                    if(dordenliquidaciongastoList.size()==0 )
                        dordenliquidaciongasto.setItem("001");
                    else{
                        Dordenliquidaciongasto dordenliquidaciongasto1 = dordenliquidaciongastoList.get(dordenliquidaciongastoList.size()-1);
                        int num = Integer.parseInt(dordenliquidaciongasto1.getItem());
                        num++;
                        dordenliquidaciongasto.setItem("00"+num);
                    }

                    dordenliquidaciongasto.setIdorden(ordenliquidaciongasto.getIdorden());
                    dordenliquidaciongasto.setIdempresa(ordenliquidaciongasto.getIdempresa());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "ACTUALIZAR":
                try{
                    TipogastoDao tipogastoDao = new TipogastoDao();
                    List<Tipogasto> tipogastoList = tipogastoDao.listarxID(dordenliquidaciongasto.getIdconcepto());
                    txtfecha.setText(""+dordenliquidaciongasto.getFecha());
                    txtmonto.setText(""+dordenliquidaciongasto.getImporte());
                    txtnumero.setText(""+dordenliquidaciongasto.getNumero());
                    txtserie.setText(""+dordenliquidaciongasto.getSerie());
                    txtruc.setText(""+dordenliquidaciongasto.getIdclieprov());
                    txtdetalle.setText(""+dordenliquidaciongasto.getGlosa());
                    list_concepto.setText(""+tipogastoList.get(0).getDescripcion());
                    if(dordenliquidaciongasto.getImpuesto()!= null && dordenliquidaciongasto.getImpuesto()==1){
                        checkboxIGV.setChecked(true);
                    }
                    for(int i = 0;i<lista1.size();i++){
                        if(lista1.get(i).getIddocumento().equals(dordenliquidaciongasto.getIddocumento())){
                            spinner_tipoPago.setSelection(i);
                            i=lista1.size();
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

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
                try {
                    dordenliquidaciongasto.getIdconcepto();
                    dordenliquidaciongasto.setFecha(txtfecha.getText().toString());
                    //dordenliquidaciongasto.setImporte();
                    dordenliquidaciongasto.setIdclieprov("" + txtruc.getText().toString());
                    dordenliquidaciongasto.setGlosa("" + txtdetalle.getText().toString());
                    if(checkboxIGV.isChecked()){
                        dordenliquidaciongasto.setAfecto(Double.valueOf(txtmonto.getText().toString()));
                        dordenliquidaciongasto.setInafecto(0.0);
                        dordenliquidaciongasto.setPimpuesto(ordenliquidaciongasto.getIgv());
                        dordenliquidaciongasto.setImpuesto(Double.valueOf(txtmonto.getText().toString())*ordenliquidaciongasto.getIgv());
                        dordenliquidaciongasto.setImporte(Double.valueOf(txtmonto.getText().toString())+dordenliquidaciongasto.getImpuesto());
                    }else{
                        dordenliquidaciongasto.setAfecto(0.0);
                        dordenliquidaciongasto.setInafecto(Double.valueOf(txtmonto.getText().toString()));
                        dordenliquidaciongasto.setPimpuesto(0.0);
                        dordenliquidaciongasto.setImpuesto(0.0);
                        dordenliquidaciongasto.setImporte(Double.valueOf(txtmonto.getText().toString()));
                    }
                    DordenliquidaciongastoDao dao2 = new DordenliquidaciongastoDao();
                    if(dordenliquidaciongasto.getIdconcepto()!=null && dordenliquidaciongasto.getIdconcepto()!=""){
                        if(Validardatos()){
                            String serie1="";
                            String num1 ="";
                            for(int i=0; i<4-txtserie.getText().toString().length();i++){
                                serie1+="0";
                            }
                            for(int i=0; i<7-txtnumero.getText().toString().length();i++){
                                num1+="0";
                            }
                            dordenliquidaciongasto.setSerie(serie1 + txtserie.getText().toString());
                            dordenliquidaciongasto.setNumero(num1 + txtnumero.getText().toString());
                            dao2.mezclarLocal(dordenliquidaciongasto);
                            Snackbar.make(getView(), "Detalle Orden Liquidacion Guardado", Snackbar.LENGTH_SHORT).show();
                            if(tipo_entrada.equals("NUEVO")){
                                getActivity().onBackPressed();
                            }else {
                                getActivity().onBackPressed();
                            }
                        }
                    }else{
                        list_concepto.setText("");
                        Snackbar.make(getView(), "Error. Verifique los datos", Snackbar.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Snackbar.make(getView(), "Error. No se pudo guardar", Snackbar.LENGTH_SHORT).show();
                }

            }
        });


        spinner_tipoPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Documentos selected = (Documentos) parent.getAdapter().getItem(position);
                dordenliquidaciongasto.setIddocumento(selected.getIddocumento());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        list_concepto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tipogasto selected = (Tipogasto) parent.getAdapter().getItem(position);
                dordenliquidaciongasto.setIdconcepto(selected.getIdtipogasto());
            }
        });
        list_concepto.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                list_concepto.showDropDown();
                return false;
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
    
    boolean Validardatos(){
        if(txtruc.getText().toString().length()!=11){
            Snackbar.make(getView(), "El RUC debe contener 11 digitos", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        if(txtserie.getText().length()==0){
            Snackbar.make(getView(), "Ingresar Serie", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        if(txtnumero.getText().length()==0){
            Snackbar.make(getView(), "Ingresar Numero", Snackbar.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
