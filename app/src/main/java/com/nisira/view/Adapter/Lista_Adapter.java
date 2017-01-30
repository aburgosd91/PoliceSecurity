package com.nisira.view.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nisira.gcalderon.policesecurity.R;

import java.util.List;

/**
 * Created by gcalderon on 05/01/2017.
 */

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.ListaViewHolder> {

    private List<String> items;//Lo cambias por la coleccion que necesites Alex

public static class ListaViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;

    public ListaViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen_personal);
        nombre = (TextView) v.findViewById(R.id.nombre);
    }
}

    public Lista_Adapter(List<String> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_elementolista, viewGroup, false);
        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        //AQUI VAN TODOS LOS ELEMENTOS DE LA LISTA.
        //viewHolder.imagen.setImageResource());
        viewHolder.nombre.setText(items.get(i));
    }
}