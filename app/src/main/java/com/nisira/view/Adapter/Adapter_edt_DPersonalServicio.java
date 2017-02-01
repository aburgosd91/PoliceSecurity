package com.nisira.view.Adapter;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by GIANCARLO on 05/01/2017.
 */

public class Adapter_edt_DPersonalServicio extends RecyclerView.Adapter<Adapter_edt_DPersonalServicio.ListaViewHolder> {

    private List<Dpersonal_servicio> items;
    public String OPCION;
    private Personal_servicio personal_servicio;

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;
    public TextView documento;
    public TextView hora_req_llegada,hora_inicio_fin,hora_liberacion;

    public CircleImageView seleccion;
    public RelativeLayout fondo_seleccion;

        public ListaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen_personal);
            nombre = (TextView) v.findViewById(R.id.nombre);
            documento = (TextView) v.findViewById(R.id.txtdocumento);
            seleccion = (CircleImageView) v.findViewById(R.id.seleccion);
            fondo_seleccion = (RelativeLayout) v.findViewById(R.id.fondo_seleccion);
            hora_req_llegada = (TextView) v.findViewById(R.id.txt2);
            hora_inicio_fin = (TextView) v.findViewById(R.id.txt3);
            hora_liberacion = (TextView) v.findViewById(R.id.txt4);
        }
    }

    public Adapter_edt_DPersonalServicio(String OPCION, List<Dpersonal_servicio> items,
                                         FragmentManager fragmentManager, Personal_servicio personal_servicio) {
        this.OPCION = OPCION;
        this.items = items;
        this.personal_servicio = personal_servicio;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_dpersonalservicio, viewGroup, false);
        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {

        viewHolder.nombre.setText(personal_servicio.getNombres());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(items.get(i).getFecharegistro());
        viewHolder.documento.setText("Fecha: "+strDate);
        viewHolder.hora_req_llegada.setText("Requerida: "+
                Util.convertDecimalTime(items.get(i).getHora_req())+ " Llegada:"+
                Util.convertDecimalTime(items.get(i).getHora_llegada()));
        viewHolder.hora_inicio_fin.setText("Inicio:"+
                Util.convertDecimalTime(items.get(i).getHora_inicio_serv())+" Fin:"+
                        Util.convertDecimalTime(items.get(i).getHora_fin_serv()));

        viewHolder.hora_liberacion.setText("Liberacion: "+
        Util.convertDecimalTime(items.get(i).getHora_liberacion()));


        if(items.get(i).isSeleccion()){
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
            viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
        }else {
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
            viewHolder.seleccion.setImageResource(R.drawable.ic_none);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        }


        //TODO: EVENTOS
        viewHolder.seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(items.get(i).isSeleccion())) {
                    viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                    viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                    viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);

                    for(int j=0;j<items.size();j++){
                        items.get(j).setSeleccion(false);
                        notifyItemChanged(j);
                    }
                    items.get(i).setSeleccion(true);

                }else{
                    items.get(i).setSeleccion(false);
                    viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.blue_gray));
                    viewHolder.seleccion.setImageResource(R.drawable.ic_none);
                    viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.blue_gray));
                }
                notifyItemChanged(i);
            }
        });
    }
}