package com.nisira.view.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_OrdenServicio_Fragment;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;
import com.nisira.view.Activity.mnt_DPersonalServicio_Fragment;
import com.nisira.core.util.Util;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gcalderon on 17/01/2017.
 */

public class Adapter_edt_DOrdenServicio extends RecyclerView.Adapter<Adapter_edt_DOrdenServicio.ListaViewHolder>{

    private List<Dordenserviciocliente> items;
    public String OPCION;
    Context context;
    FragmentManager fragmentManager;
    Ordenserviciocliente ordenserviciocliente;

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView placa;
        public TextView fecha_fin;
        public TextView estado;
        public  TextView txtnombrecarro;
        public CircleImageView seleccion;
        public RelativeLayout fondo_seleccion;
        public boolean bool_seleccion;

        public ListaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen_personal);
            nombre = (TextView) v.findViewById(R.id.nombre);
            placa = (TextView) v.findViewById(R.id.txtplaca);
            seleccion = (CircleImageView) v.findViewById(R.id.seleccion);
            fecha_fin = (TextView)v.findViewById(R.id.txtfechafin);
            fondo_seleccion = (RelativeLayout) v.findViewById(R.id.fondo_seleccion);
            txtnombrecarro = (TextView) v.findViewById(R.id.txtnombrecarro);

        }
    }

    public Adapter_edt_DOrdenServicio(String OPCION,List<Dordenserviciocliente> items, FragmentManager fragmentManager, Ordenserviciocliente ordenserviciocliente) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
        this.ordenserviciocliente = ordenserviciocliente;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Adapter_edt_DOrdenServicio.ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        context = viewGroup.getContext();
        if(OPCION=="Registro Vehiculo"){
            v= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_dordenservicio_vehiculo, viewGroup, false);
        }else{
            v= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_dordenservicio, viewGroup, false);
        }


        return new Adapter_edt_DOrdenServicio.ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter_edt_DOrdenServicio.ListaViewHolder viewHolder, int i) {

        viewHolder.nombre.setText(items.get(i).getDescripcion_servicio());
        /**
        if(items.get(i).getFecha_fin_servicio()!=null){
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = sm.format(items.get(i).getFecha_fin_servicio());
            viewHolder.fecha_fin.setText("Fin servicio: "+strDate);
        }else{
            String strDate="";
            viewHolder.fecha_fin.setText("Fin servicio: "+strDate);
        }**/

          //viewHolder.txtnombrecarro.setText("Cod.Oper.: ' "+items.get(i).getCodoperaciones().toString()+" '");
            viewHolder.txtnombrecarro.setText(Html.fromHtml("Cod.Oper.: <b> "+items.get(i).getCodoperaciones().toString()+"<b>"));


            viewHolder.placa.setText("Hora Estruct.: "+Util.convertTimeFloatString(items.get(i).getHora_rc().floatValue()));
            viewHolder.fecha_fin.setText("Hora.Req. : "+Util.convertTimeFloatString(items.get(i).getHora_req().floatValue()));
            //viewHolder.placa.setText("Placa: "+items.get(i).getPlaca_cliente());



        viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        viewHolder.seleccion.setImageResource(R.drawable.ic_arrow_white);
        viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));

        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        System.out.println("DOrdenServicio: "+gson.toJson(items.get(i)));

        viewHolder.fondo_seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));

                Fragment fragment = edt_PersonalServicio_Fragment.newInstance(OPCION, "edt_OrdenServicio_Fragment");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("DOrdenServicio", items.get(i));
                bundle.putSerializable("OrdenServicio",ordenserviciocliente);
                fragment.setArguments(bundle);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

}
