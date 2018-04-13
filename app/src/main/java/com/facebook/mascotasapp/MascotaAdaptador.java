package com.facebook.mascotasapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Johans on 09/04/2018.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


   ArrayList<Mascotas> mascotas;
    Activity activity;


    public MascotaAdaptador( ArrayList<Mascotas> mascotas){

        this.mascotas = mascotas;
    }

    public MascotaAdaptador( ArrayList<Mascotas> mascotas, Activity activity){

        this.activity = activity;
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //en la siguiente línea indicamos que layout estará reciclando el RecyclerView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        //asocia cada elemento de la vista con cada view
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.ivFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvNumero.setText(mascota.getCantidadLikes());
        //mascotaViewHolder.ibIcono.setImageResource(mascota.getIconoLike());
        //mascotaViewHolder.ivIcono.setImageResource(R.drawable.icons8_enamorado_96);

        mascotaViewHolder.setOnClickListener();

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivFoto;
        //private ImageView ivIcono;
        private TextView tvNombre, tvNumero;
        private ImageButton ibLike;
        Context context;
        //FloatingActionButton miFab;

        public MascotaViewHolder(View itemView) {

            super(itemView);
            context = itemView.getContext();// este debe ir despues del super, si va antes da error

            ivFoto = itemView.findViewById(R.id.ivmascota);
            //ivIcono = itemView.findViewById(R.id.ivLikes);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNumero = itemView.findViewById(R.id.tvCantidad);
            ibLike = itemView.findViewById(R.id.ibLike);

        }
        public void setOnClickListener(){
            ibLike.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ibLike:
                    Toast.makeText(context,"diste like a "+ tvNombre.getText(),Toast.LENGTH_SHORT).show();
                    //convierto en int el valor dentro y le realizo una suma
                    int plusLike = Integer.parseInt(tvNumero.getText().toString());
                    tvNumero.setText(String.valueOf(plusLike + 1));
                    break;
            }
        }
    }

}
