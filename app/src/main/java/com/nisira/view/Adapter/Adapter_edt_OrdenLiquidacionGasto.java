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
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;
import com.nisira.view.Activity.mnt_DOrdenLiquidacionGasto_Fragment;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gcalderon on 17/01/2017.
 */

public class Adapter_edt_OrdenLiquidacionGasto extends RecyclerView.Adapter<Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder>{

    private List<Dordenliquidaciongasto> items;
    public String OPCION;
    Context context;
    FragmentManager fragmentManager;

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView placa;
        public TextView fecha_fin;
        public TextView estado;
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

        }
    }

    public Adapter_edt_OrdenLiquidacionGasto(String OPCION, List<Dordenliquidaciongasto> items,FragmentManager fragmentManager) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_dordenservicio, viewGroup, false);
        return new Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder viewHolder, int i) {

        viewHolder.nombre.setText(items.get(i).getDescripcion_concepto());
        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = sm.format(items.get(i).getFecha());
        viewHolder.fecha_fin.setText("Fecha: "+strDate);
        viewHolder.placa.setText("Destino: "+items.get(i).getIddestino());

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

                Fragment fragment = mnt_DOrdenLiquidacionGasto_Fragment.newInstance(OPCION, "edt_OrdenLiquidacionGasto_Fragment");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("DOrdenLiquidacionGasto", items.get(i));
                fragment.setArguments(bundle);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();

            }
        });

    }

}
