package com.facebook.mascotasapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class SegundaPantallaAdapter extends RecyclerView.Adapter<SegundaPantallaAdapter.SegundaPantallaViewHolder> {

    ArrayList<Mascotas> mascotas2;
    Activity activity;
    MascotaAdaptador mascotaAdaptador;//he puesto a ver

    public SegundaPantallaAdapter(ArrayList<Mascotas> mascotas){
        this.mascotas2 = mascotas;
    }

    public SegundaPantallaAdapter( ArrayList<Mascotas> mascotas2, Activity activity){

        this.activity = activity;
        this.mascotas2 = mascotas2;
    }

    @Override
    public SegundaPantallaViewHolder     onCreateViewHolder(ViewGroup parent, int viewType) {
        //en la siguiente línea indicamos que layout estará reciclando el RecyclerView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new SegundaPantallaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SegundaPantallaViewHolder segundaPantallaViewHolder, int position) {
        //asocia cada elemento de la vista con cada view

        final Mascotas mascota2 = mascotas2.get(position);

        segundaPantallaViewHolder.ivFoto.setImageResource(mascota2.getFoto());
        segundaPantallaViewHolder.tvNombre.setText(mascota2.getNombre());


        segundaPantallaViewHolder.tvNumero.setText(mascota2.getCantidadLikes());

        //mascotaViewHolder.ibIcono.setImageResource(mascota.getIconoLike());
        //mascotaViewHolder.ivIcono.setImageResource(R.drawable.icons8_enamorado_96);



    }

    @Override
    public int getItemCount() {
       return 5;
    }

    //public void obtenerLikes(){    }

    public static class SegundaPantallaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        //private ImageView ivIcono;
        private TextView tvNombre, tvNumero;
        private ImageButton ibIcono;

        public SegundaPantallaViewHolder(View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivmascota);
            //ivIcono = itemView.findViewById(R.id.ivLikes);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNumero = itemView.findViewById(R.id.tvCantidad);
            ibIcono = itemView.findViewById(R.id.ibLike);


        }

    }
}
