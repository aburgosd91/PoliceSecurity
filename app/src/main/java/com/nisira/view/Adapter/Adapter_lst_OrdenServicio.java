package com.nisira.view.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.NavigationPolice_Activity;
import com.nisira.view.Activity.edt_OrdenServicio2_Fragment;
import com.nisira.view.Activity.edt_OrdenServicio_Fragment;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by GIANCARLO on 05/01/2017.
 */

public class Adapter_lst_OrdenServicio extends RecyclerView.Adapter<Adapter_lst_OrdenServicio.ListaViewHolder> {

    private List<Ordenserviciocliente> items;
    public FragmentManager fragmentManager;
    public String OPCION;

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item

        public ImageView imagen;
        public TextView nombre;
        public TextView ordenservicio;
        public TextView fecha;
        public TextView txtid;
        public TextView txttiposervicio;
        public CircleImageView seleccion;
        public RelativeLayout fondo_seleccion;
        public TextView indexnum;
        public boolean bool_seleccion;
        public ListaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen_personal);
            nombre = (TextView) v.findViewById(R.id.nombre);
            ordenservicio = (TextView) v.findViewById(R.id.txtdocumento);
            seleccion = (CircleImageView) v.findViewById(R.id.seleccion);
            fondo_seleccion = (RelativeLayout) v.findViewById(R.id.fondo_seleccion);
            fecha = (TextView) v.findViewById(R.id.txtfecha);
            txtid = (TextView) v.findViewById(R.id.txtid);
            txttiposervicio = (TextView) v.findViewById(R.id.txttiposervicio);
            indexnum = (TextView)v.findViewById(R.id.indexnum);
        }
    }

    public Adapter_lst_OrdenServicio(String OPCION,List<Ordenserviciocliente> items, FragmentManager fragmentManager) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
        Log.i("ADAPTER LST OS",OPCION);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_ordenservicio, viewGroup, false);
        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        //AQUI VAN TODOS LOS ELEMENTOS DE LA LISTA.
        viewHolder.indexnum.setText((i+1)+"");
        viewHolder.nombre.setText(items.get(i).getRazonsocial());
        viewHolder.ordenservicio.setText("Orden: "+items.get(i).getIddocumento()+" - "+items.get(i).getSerie()+" - "+items.get(i).getNumero());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(items.get(i).getFecha());
        viewHolder.fecha.setText("Fecha: "+strDate);
        viewHolder.txtid.setText("Doc: "+items.get(i).getIdclieprov());
        if(items.get(i).getTipo_servicio().equals("E")){
            viewHolder.txttiposervicio.setText("Tipo: Especial");
        }
        if(items.get(i).getTipo_servicio().equals("F")){
            viewHolder.txttiposervicio.setText("Tipo: Fijo");
        }
        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        System.out.println(gson.toJson(items.get(i)));

        //TODO: EVENTOS
        viewHolder.seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));

                Fragment fragment = edt_OrdenServicio_Fragment.newInstance(OPCION, "lst_OrdenServicio_Fragment");
                Bundle bundle = fragment.getArguments();
                fragment.setArguments(bundle);
                bundle.putSerializable("OrdenServicio", items.get(i));
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
                notifyItemChanged(i);
            }
        });
    }
}