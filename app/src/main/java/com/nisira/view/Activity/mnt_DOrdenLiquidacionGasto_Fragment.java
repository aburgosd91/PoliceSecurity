package com.nisira.view.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.gcalderon.policesecurity.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;


public class mnt_DOrdenLiquidacionGasto_Fragment extends Fragment {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AutoCompleteTextView listbox;
    private EditText hora_llegada;
    private EditText hora_requerida;
    private EditText hora_inicio;
    private EditText hora_fin;
    private EditText hora_liberacion;
    private EditText fecha_operacion;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;
/*
    public mnt_DPersonalServicio_Fragment() {
        // Required empty public constructor
    }
*/
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
        }
    }
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mnt_personalservicio, container, false);
        animacionEntrada();
        String[] NOMBRES = new String[] {
                "Gian", "Giancarlo", "Alex", "Andy","Ayrton","Acevedo","Antonela","Antony","Antonio"
                ,"André", "Joshe", "Alejandro","Aldo"
        };
        hora_requerida = (EditText)view.findViewById(R.id.hora_requerida);
        hora_llegada = (EditText)view.findViewById(R.id.hora_llegada);
        hora_inicio = (EditText)view.findViewById(R.id.hora_inicio);
        hora_fin = (EditText)view.findViewById(R.id.hora_fin);
        hora_liberacion = (EditText)view.findViewById(R.id.hora_liberacion);
        fecha_operacion = (EditText)view.findViewById(R.id.fecha_servicio);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_acaptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        listbox = (AutoCompleteTextView) view.findViewById(R.id.autocompletetext1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line,NOMBRES);
        listbox.setAdapter(adapter);

        //TODO EVENTOS
        hora_requerida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                                hora_requerida.setText(hourOfDay+":"+minute);
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });
        hora_llegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                                hora_llegada.setText(hourOfDay+":"+minute);
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });
        hora_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                                hora_inicio.setText(hourOfDay+":"+minute);
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });
        hora_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                                hora_fin.setText(hourOfDay+":"+minute);
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });
        hora_liberacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                                hora_liberacion.setText(hourOfDay+":"+minute);
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });
        fecha_operacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                fecha_operacion.setText(dayOfMonth+"/"+monthOfYear+1+"/"+year);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new List_Fragment_Personal(), "NewFragmentTag");
                ft.commit();
            }
        });
        btn_acaptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, new List_Fragment_Personal(), "NewFragmentTag");
                ft.commit();
            }
        });

        return view;
    }

    // TODO: TRANSICIONES Y ANIMACIONES

    @SuppressLint("NewApi")
    public void animacionEntrada(){
        Fade fade = (Fade) TransitionInflater.from(this.getContext()).inflateTransition(R.transition.activity_fade);
        setEnterTransition(fade);
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
    }



}
