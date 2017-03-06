package com.nisira.view.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.CustomDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;


    public class mnt_DPersonalServicio_Fragment extends FragmentNisira {
    // TODO: ELEMENTOS DE LAYOUT
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Dpersonal_servicio dpersonal_servicio;
    private Personal_servicio personal_servicio;
    private EditText hora_llegada;
    private EditText hora_requerida;
    private EditText hora_inicio;
    private EditText hora_fin;
    private EditText hora_liberacion;
    private EditText fecha_operacion;
    private TextView txt_titulo;
    private FloatingActionButton btn_cancelar;
    private FloatingActionButton btn_acaptar;

    // TODO: PARAMETROS DE ENTRADA
    private String mParam1;
    private String mParam2;

    public mnt_DPersonalServicio_Fragment() {
        // Required empty public constructor
    }

    // TODO: FUNCIONES Y METODOS
    public static mnt_DPersonalServicio_Fragment newInstance(String param1, String param2) {
        mnt_DPersonalServicio_Fragment fragment = new mnt_DPersonalServicio_Fragment();
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
            dpersonal_servicio = (Dpersonal_servicio) getArguments().getSerializable("DPersonalServicio");
            personal_servicio = (Personal_servicio) getArguments().getSerializable("PersonalServicio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mnt_dpersonalservicio, container, false);
        animacionEntrada();
        hora_requerida = (EditText)view.findViewById(R.id.hora_requerida);
        hora_llegada = (EditText)view.findViewById(R.id.hora_llegada);
        hora_inicio = (EditText)view.findViewById(R.id.hora_inicio);
        hora_fin = (EditText)view.findViewById(R.id.hora_fin);
        hora_liberacion = (EditText)view.findViewById(R.id.hora_liberacion);
        fecha_operacion = (EditText)view.findViewById(R.id.fecha_servicio);
        btn_cancelar = (FloatingActionButton)view.findViewById(R.id.fab_cancelar);
        btn_acaptar = (FloatingActionButton)view.findViewById(R.id.fab_aceptar);
        txt_titulo = (TextView)view.findViewById(R.id.txt_titulo);

        LlenarCampos();
        Listeners();

        return view;
    }

    // TODO: TRANSICIONES Y ANIMACIONES

    public void animacionEntrada(){
        Fade fade = (Fade) TransitionInflater.from(this.getContext()).inflateTransition(R.transition.activity_fade);
        setEnterTransition(fade);
        Slide slide = (Slide) TransitionInflater.from(getContext()).inflateTransition(R.transition.activity_slide);
        setExitTransition(slide);
    }

    public void LlenarCampos(){
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.mnt_DPersonalServicio));
        txt_titulo.setText(mParam2);
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate="";
        switch (mParam2){
            case "Modificar":
                hora_requerida.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_req()
                ));
                hora_llegada.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_llegada()
                ));
                hora_inicio.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_inicio_serv()
                ));
                hora_fin.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_fin_serv()
                ));
                hora_liberacion.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_liberacion()
                ));
                strDate = sm.format(dpersonal_servicio.getFecharegistro());
                fecha_operacion.setText(strDate);
                break;
            case "Agregar":
                hora_requerida.setText(Util.convertDecimalTime(
                        dpersonal_servicio.getHora_req()
                ));
                sm = new SimpleDateFormat("dd-MM-yyyy");
                strDate = sm.format(dpersonal_servicio.getFecharegistro());
                fecha_operacion.setText(strDate);
                break;
        }
    }

    public void Listeners(){
        //TODO EVENTOS
        hora_requerida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd1 = new TimePickerDialog(getContext(),
                    android.app.TimePickerDialog.THEME_HOLO_LIGHT,
                    new android.app.TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hora_requerida.setText(TimetoString(hourOfDay)+":"+TimetoString(minute));
                    }
                },
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),false);
                tpd1.show();
            }
        });

        hora_llegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd1 = new TimePickerDialog(getContext(),
                        android.app.TimePickerDialog.THEME_HOLO_LIGHT,
                        new android.app.TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hora_llegada.setText(TimetoString(hourOfDay)+":"+TimetoString(minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false);
                tpd1.show();
            }
        });

        hora_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd1 = new TimePickerDialog(getContext(),
                        android.app.TimePickerDialog.THEME_HOLO_LIGHT,
                        new android.app.TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hora_inicio.setText(TimetoString(hourOfDay)+":"+TimetoString(minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false);
                tpd1.show();
            }
        });

        hora_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd1 = new TimePickerDialog(getContext(),
                        android.app.TimePickerDialog.THEME_HOLO_LIGHT,
                        new android.app.TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hora_fin.setText(TimetoString(hourOfDay)+":"+TimetoString(minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false);
                tpd1.show();
            }
        });

        hora_liberacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                now.set(1,1,1);
                TimePickerDialog tpd1 = new TimePickerDialog(getContext(),
                        android.app.TimePickerDialog.THEME_HOLO_LIGHT,
                        new android.app.TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hora_liberacion.setText(TimetoString(hourOfDay)+":"+TimetoString(minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false);
                tpd1.show();
            }
        });

        fecha_operacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                if(fecha_operacion.getText().toString().isEmpty()){
                    String[] fechas = fecha_operacion.getText().toString().split("-");
                    now.set(Integer.parseInt(fechas[2]),Integer.parseInt(fechas[1]),Integer.parseInt(fechas[0]));
                }
                DatePickerDialog dpd = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                fecha_operacion.setText(dayOfMonth+"-"+month+1+"-"+year);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show();
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
                boolean okflag=false;
                Dpersonal_servicioDao dao = new Dpersonal_servicioDao();
                try {
                    dpersonal_servicio.setHora_req((double) Util.convertTimeDecimal(
                            hora_requerida.getText().toString()
                    ));
                    dpersonal_servicio.setHora_llegada((double) Util.convertTimeDecimal(
                            hora_llegada.getText().toString()
                    ));
                    dpersonal_servicio.setHora_inicio_serv((double) Util.convertTimeDecimal(
                            hora_inicio.getText().toString()
                    ));
                    dpersonal_servicio.setHora_fin_serv((double) Util.convertTimeDecimal(
                            hora_fin.getText().toString()
                    ));
                    dpersonal_servicio.setHora_liberacion((double) Util.convertTimeDecimal(
                            hora_liberacion.getText().toString()
                    ));
                    okflag=true;
                }catch (Exception e){
                    e.printStackTrace();
                    DialogFragment popup = new CustomDialogFragment();
                    Bundle args = new Bundle();
                    args.putString("titulo", "Advertencia");
                    args.putString("mensaje", "No se termino de llenar todos los campos");
                    popup.setArguments(args);
                    popup.show(getActivity().getSupportFragmentManager(),"dialog");

                }finally {
                    if(okflag==true){
                        try {
                            dao.mezclarLocal(dpersonal_servicio);
                            getActivity().onBackPressed();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });
    }


    String TimetoString(int time){
        if(time<=9){
            return "0"+time;
        }
        return time+"";
    }

}
