package com.facebook.mascotasapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaro mi toolbar para que trabaje bien en mis pantallas
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);



        listaMascotas = findViewById(R.id.rvMascotas);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //quiero que mi recyclerview listaMascotas se comporte como el LinearLayout anterior
        listaMascotas.setLayoutManager(llm);

        inicializarArrayMascotas();
        inicializarAdaptador();
        agregarFAB();




    }

    //HAGO ESTOS DOS METODOS PARA NO PONER TO ESTE TEXTO EN EL METODO onCreate
    public void inicializarArrayMascotas(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.loro,"Coti el Loro",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.conejo,"Bonny el Conejo",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.gato,"Arthur el Gato",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.hamster,"Pedro el Curiel",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.mono,"Roco el Mono",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.perro,"Mochi el Perro",R.string.tvnumero));
        mascotas.add(new Mascotas(R.drawable.tortuga,"Tita la Tortuga",R.string.tvnumero));

    }
    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        //le paso la lista de mascotas a mi objeto adaptador
         adaptador = new MascotaAdaptador( mascotas);
        //le paso a mi recyclerview el objeto adaptador que manejará
        listaMascotas.setAdapter(adaptador);
    }
    TextView tvNumero;
    public void agregarFAB(){
        FloatingActionButton miFab = findViewById(R.id.miFab);
        miFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SegundaPantalla.class);
                startActivity(intent);
            }
        });

    }


}
