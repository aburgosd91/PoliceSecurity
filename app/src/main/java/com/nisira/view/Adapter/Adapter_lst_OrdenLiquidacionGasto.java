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
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_OrdenLiquidacionGasto_Fragment;
import com.nisira.view.Activity.edt_OrdenServicio_Fragment;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by GIANCARLO on 05/01/2017.
 */

public class Adapter_lst_OrdenLiquidacionGasto extends RecyclerView.Adapter<Adapter_lst_OrdenLiquidacionGasto.ListaViewHolder> {

    private List<Ordenliquidaciongasto> items;
    public FragmentManager fragmentManager;
    public String OPCION;

public static class ListaViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item

    public ImageView imagen;
    public TextView nombre;
    public TextView ordenservicio;
    public TextView fecha;
    public CircleImageView seleccion;
    public RelativeLayout fondo_seleccion;
    public boolean bool_seleccion;
    public ListaViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen_personal);
        nombre = (TextView) v.findViewById(R.id.nombre);
        ordenservicio = (TextView) v.findViewById(R.id.txtdocumento);
        seleccion = (CircleImageView) v.findViewById(R.id.seleccion);
        fondo_seleccion = (RelativeLayout) v.findViewById(R.id.fondo_seleccion);
        fecha = (TextView) v.findViewById(R.id.txtfecha);

    }
}

    public Adapter_lst_OrdenLiquidacionGasto(String OPCION, List<Ordenliquidaciongasto> items, FragmentManager fragmentManager) {
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
        viewHolder.nombre.setText(items.get(i).getRazonsocial());
        viewHolder.ordenservicio.setText("Orden: "+items.get(i).getIddocumento()+" - "+items.get(i).getSerie()+" - "+items.get(i).getNumero());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(items.get(i).getFechacreacion());
        viewHolder.fecha.setText("Fecha: "+strDate);

        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        System.out.println(gson.toJson(items.get(i)));

        //TODO: EVENTOS
        viewHolder.seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));

                Fragment fragment = edt_OrdenLiquidacionGasto_Fragment.newInstance(OPCION, "lst_OrdenLiquidacionGasto");
                Bundle bundle = fragment.getArguments();
                fragment.setArguments(bundle);
                bundle.putSerializable("OrdenLiquidacionGasto", items.get(i));
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();

                notifyItemChanged(i);
            }
        });
    }
}