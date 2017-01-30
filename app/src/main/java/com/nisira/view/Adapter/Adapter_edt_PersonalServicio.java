package com.nisira.view.Adapter;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.gcalderon.policesecurity.R;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ABURGOS on 05/01/2017.
 */

public class Adapter_edt_PersonalServicio extends RecyclerView.Adapter<Adapter_edt_PersonalServicio.ListaViewHolder> {

    private List<Personal_servicio> items;//Lo cambias por la coleccion que necesites Alex

public static class ListaViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;
    public TextView documento;
    public TextView estado;
    public CircleImageView seleccion;
    public RelativeLayout fondo_seleccion;
    public boolean bool_seleccion;
    public ListaViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen_personal);
        nombre = (TextView) v.findViewById(R.id.nombre);
        documento = (TextView) v.findViewById(R.id.txtdocumento);
        seleccion = (CircleImageView) v.findViewById(R.id.seleccion);
        fondo_seleccion = (RelativeLayout) v.findViewById(R.id.fondo_seleccion);
        estado = (TextView) v.findViewById(R.id.txt2);
    }
}

    public Adapter_edt_PersonalServicio(List<Personal_servicio> items, FragmentManager fragmentManager) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_personalservicio, viewGroup, false);
        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        //AQUI VAN TODOS LOS ELEMENTOS DE LA LISTA.
        //viewHolder.imagen.setImageResource());
        viewHolder.nombre.setText(items.get(i).getNombres());
        viewHolder.documento.setText("Dni: "+items.get(i).getDni());
        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = sm.format(items.get(i).getFechaoperacion());
        viewHolder.estado.setText("Fecha Operación: "+strDate);

        if(items.get(i).isSeleccion()){
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
            viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
        }else {
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
            viewHolder.seleccion.setImageResource(R.drawable.ic_none);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        }

        //viewHolder.estado.setText((items.get(i).getEstado()==1.00?"Activo":"Inactivo"));
        //viewHolder.seleccion.setChecked(false);

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