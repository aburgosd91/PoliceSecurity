package com.nisira.view.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.util.Util;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Activity.edt_DPersonalServicio_Fragment;
import com.nisira.view.Activity.edt_PersonalServicio_Fragment;
import com.nisira.view.Activity.mnt_PersonalServicio_Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    Context contexto;

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView documento;
        public TextView estado;
        public TextView cargo;
        public TextView vehiculo;
        public TextView fecha_fin;
        public CircleImageView seleccion;
        public RelativeLayout fondo_seleccion;
        public LinearLayout ll_fecha;
        public FloatingActionButton fab_fecha;
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
            vehiculo = (TextView)v.findViewById(R.id.txt_vehiculo_lst);
            ll_fecha = (LinearLayout)v.findViewById(R.id.ll_fecha);
            fecha_fin = (TextView)v.findViewById(R.id.txt4);
            fab_fecha = (FloatingActionButton)v.findViewById(R.id.fab_fecha);

        }
    }




    public Adapter_edt_PersonalServiciolst(String OPCION, List<Personal_servicio> items, FragmentManager fragmentManager, Ordenserviciocliente ordenserviciocliente, Dordenserviciocliente dordenserviciocliente,Context contexto) {
        this.OPCION = OPCION;
        this.items = items;
        this.fragmentManager = fragmentManager;
        this.ordenserviciocliente = ordenserviciocliente;
        this.dordenserviciocliente = dordenserviciocliente;
        this.contexto=contexto;
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
        if(items.get(i).getFechaoperacion()!=null){
            String strDate = sm.format(items.get(i).getFechaoperacion());
            viewHolder.estado.setText("Fecha Operacion: "+strDate);
        }else{
            viewHolder.estado.setText("Fecha Operacion: "+"");
        }

        viewHolder.cargo.setText("Cargo: "+items.get(i).getDescripcion_cargo());
        viewHolder.vehiculo.setText("Vehiculo: "+items.get(i).getIdvehiculo());
        viewHolder.ll_fecha.setVisibility(View.VISIBLE);

        if(items.get(i).getFechafin()!=null){
            String datefin =  sm.format(items.get(i).getFechafin());
            viewHolder.fecha_fin.setText("Fecha fin: " + datefin);
        }

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
        viewHolder.fab_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(items.get(i).getFechafin()== null) {
                    Calendar now = Calendar.getInstance();
                    SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
                    String strDate = sm.format(now.getTime());
                    viewHolder.fecha_fin.setText("Fecha fin: " + strDate);
                    items.get(i).setFechafin(now.getTime());
                    Personal_servicioDao dao = new Personal_servicioDao();
                    try {
                        dao.mezclarLocal(items.get(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    viewHolder.fecha_fin.setText("Fecha fin: ");
                    items.get(i).setFechafin(null);
                    Personal_servicioDao dao = new Personal_servicioDao();
                    try {
                        dao.mezclarLocal(items.get(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        edt_PersonalServicio_Fragment frameperdosnal;

        viewHolder.seleccion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fragment;
                viewHolder.fondo_seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setBackgroundColor(v.getResources().getColor(R.color.amarillo));
                viewHolder.seleccion.setImageResource(R.drawable.ic_check_big);
                if(OPCION=="Registro Vehiculo"){
                    //fragment = edt_DPersonalServicio_Fragment.newInstance(OPCION, "edt_OrdenServicio_Fragment");
                     fragment = mnt_PersonalServicio_Fragment.newInstance(OPCION, "Modificar");

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
                else {
                    if(Util.isnull(items.get(i).getDni(),"").equals("") || Util.isnull(items.get(i).getNombres(),"").equals("")){
                        Toast.makeText(contexto, "No Existe Personal Asignado", Toast.LENGTH_LONG).show();
                    }else{
                        fragment = edt_DPersonalServicio_Fragment.newInstance(OPCION, "edt_OrdenServicio_Fragment");

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

                   //Snackbar.make(getview , "No Existe Personal Asignado", Snackbar.LENGTH_SHORT).show();
                      //  fragment = edt_DPersonalServicio_Fragment.newInstance(OPCION, "edt_OrdenServicio_Fragment");

                }



            }
        });
    }
}