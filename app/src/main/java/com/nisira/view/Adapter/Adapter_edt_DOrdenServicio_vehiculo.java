package com.nisira.view.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;
import com.nisira.view.Activity.mnt_DOrdenServicio_Fragment;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gcalderon on 17/01/2017.
 */

public class Adapter_edt_DOrdenServicio_vehiculo extends RecyclerView.Adapter<Adapter_edt_DOrdenServicio_vehiculo.ListaViewHolder>{

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
        public TextView txtnombrecarro;
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
            txtnombrecarro = (TextView)v.findViewById(R.id.txtnombrecarro);
        }
    }

    public Adapter_edt_DOrdenServicio_vehiculo(String OPCION, List<Dordenserviciocliente> items, FragmentManager fragmentManager, Ordenserviciocliente ordenserviciocliente) {
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
    public Adapter_edt_DOrdenServicio_vehiculo.ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_dordenservicio_vehiculo, viewGroup, false);
        return new Adapter_edt_DOrdenServicio_vehiculo.ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter_edt_DOrdenServicio_vehiculo.ListaViewHolder viewHolder, int i) {



        Personal_servicioDao daop = new Personal_servicioDao();
        try {
            List<Personal_servicio>personales = daop.listarxDordenservicio(items.get(i));
            if(personales.size()>0){
            //viewHolder.nombre.setText("Placa personal: "+personales.get(0).getIdvehiculo());
              //viewHolder.nombre.setText("Placa personal: "+personales.get(0).getIdvehiculo());
            }
            else{
               // viewHolder.nombre.setText("Placa personal: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(items.get(i).getFecha_fin_servicio()!=null){
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = sm.format(items.get(i).getFecha_fin_servicio());
            viewHolder.fecha_fin.setText("Fin servicio: "+strDate);
        }else{
            String strDate="";
            viewHolder.fecha_fin.setText("Fin servicio: "+strDate);
        }
        viewHolder.placa.setText(items.get(i).getDescripcion_servicio());
        viewHolder.txtnombrecarro.setText("Placa cliente:" +items.get(i).getPlaca_cliente()+ items.get(i).getDescripcion_vehiculo());

        if(items.get(i).isSeleccion()){
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
            viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
        }else {
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
            viewHolder.seleccion.setImageResource(R.drawable.ic_none);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        }

        viewHolder.fondo_seleccion.setOnClickListener(new View.OnClickListener() {
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
