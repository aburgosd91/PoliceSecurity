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
import com.nisira.core.dao.TipogastoDao;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Tipogasto;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;
import com.nisira.view.Activity.mnt_DOrdenLiquidacionGasto_Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    Ordenliquidaciongasto ordenliquidaciongasto;

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView placa;
        public TextView fecha_fin;
        public TextView txt_importetotal;
        public TextView estado,txt_dinero;
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
            txt_dinero = (TextView)v.findViewById(R.id.txt_dinero);
            txt_importetotal = (TextView)v.findViewById(R.id.txt_importetotal);
        }
    }

    public Adapter_edt_OrdenLiquidacionGasto(String OPCION, List<Dordenliquidaciongasto> items, FragmentManager fragmentManager, Ordenliquidaciongasto ordenliquidaciongasto) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
        this.ordenliquidaciongasto = ordenliquidaciongasto;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_dordenliquidacion, viewGroup, false);
        return new Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter_edt_OrdenLiquidacionGasto.ListaViewHolder viewHolder, int i) {

        TipogastoDao tipogastoDao = new TipogastoDao();
        try {
            List<Tipogasto> tipogastoList = tipogastoDao.listarxID(items.get(i).getIdconcepto());
            viewHolder.nombre.setText(items.get(i).getIddocumento()+" : "+items.get(i).getSerie()+ "-"+items.get(i).getNumero());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        //String strDate = sm.format(""+items.get(i).getFecha().toString());
        viewHolder.fecha_fin.setText("Fecha: "+items.get(i).getFecha().toString());
        viewHolder.placa.setText("Descripcion: "+ items.get(i).getGlosa());
        Double dinero = items.get(i).getImporte()-items.get(i).getImpuesto();
        viewHolder.txt_dinero.setText("IGV: "+ items.get(i).getImpuesto() + "  Subtotal: "+ dinero);
        viewHolder.txt_importetotal.setText("Importe: "+ items.get(i).getImporte());
        if(items.get(i).isSeleccion()){
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
            viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
        }else {
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
            viewHolder.seleccion.setImageResource(R.drawable.ic_none);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        }
        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        System.out.println("DOrdenServicio: "+gson.toJson(items.get(i)));



        viewHolder.fondo_seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                /*
                Fragment fragment = mnt_DOrdenLiquidacionGasto_Fragment.newInstance(OPCION, "edt_OrdenLiquidacionGasto_Fragment");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("DOrdenLiquidacionGasto", items.get(i));
                bundle.putSerializable("OrdenLiquidacionGasto",ordenliquidaciongasto);
                bundle.putSerializable("tipo_entrada","ACTUALIZAR");
                fragment.setArguments(bundle);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
                */
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
