package com.nisira.view.Adapter;

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

import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_DPersonalServicio_Fragment;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ABURGOS on 05/01/2017.
 */

public class Adapter_edt_PersonalServiciolst extends RecyclerView.Adapter<Adapter_edt_PersonalServiciolst.ListaViewHolder> {

    private List<Personal_servicio> items;
    private FragmentManager fragmentManager;
    private Ordenserviciocliente ordenserviciocliente;
    private Dordenserviciocliente dordenserviciocliente;
    public String OPCION;

public static class ListaViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;
    public TextView documento;
    public TextView estado;
    public TextView cargo;
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
        estado = (TextView) v.findViewById(R.id.txt3);
        cargo = (TextView) v.findViewById(R.id.txt2);
    }
}

    public Adapter_edt_PersonalServiciolst(String OPCION, List<Personal_servicio> items, FragmentManager fragmentManager, Ordenserviciocliente ordenserviciocliente, Dordenserviciocliente dordenserviciocliente) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
        this.ordenserviciocliente = ordenserviciocliente;
        this.dordenserviciocliente = dordenserviciocliente;
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

        viewHolder.nombre.setText(items.get(i).getNombres());
        viewHolder.documento.setText("Dni: "+items.get(i).getDni());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(items.get(i).getFechaoperacion());
        viewHolder.estado.setText("Fecha Operacion: "+strDate);
        viewHolder.cargo.setText("Cargo: "+items.get(i).getDescripcion_cargo());

        if(items.get(i).isSeleccion()){
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
            viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.amarillo));
        }else {
            viewHolder.seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
            viewHolder.seleccion.setImageResource(R.drawable.ic_arrow_white);
            viewHolder.fondo_seleccion.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.blue_gray));
        }


        //TODO: EVENTOS
        viewHolder.seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                Fragment fragment = edt_DPersonalServicio_Fragment.newInstance(OPCION, "edt_OrdenServicio_Fragment");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("PersonalServicio", items.get(i));
                bundle.putSerializable("DOrdenServicio",dordenserviciocliente);
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