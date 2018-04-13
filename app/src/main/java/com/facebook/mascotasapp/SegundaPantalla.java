package com.facebook.mascotasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;


public class SegundaPantalla extends AppCompatActivity {

    ArrayList<Mascotas> mascotas2;
    private RecyclerView listaMascotas2;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_segundapantalla);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas2 = findViewById(R.id.rvSegundaPantalla);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        //quiero que mi recyclerview listaMascotas2 se comporte como el LinearLayout anterior
        listaMascotas2.setLayoutManager(llm2);


        inicializarArrayMascotas2();

        inicializarAdaptador2();


    }

    //HAGO ESTOS DOS METODOS PARA NO PONER TO ESTE TEXTO EN EL METODO onCreate
    public void inicializarArrayMascotas2(){

        mascotas2 = new ArrayList<Mascotas>();

        mascotas2.add(new Mascotas(R.drawable.loro,"Paco el Perico",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.conejo,"Bonny el Conejo",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.gato,"Arthur el Gato",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.hamster,"Pedro el Curiel",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.mono,"Roco el Mono",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.perro,"Mochi el Perro",R.string.tvnumero));
        mascotas2.add(new Mascotas(R.drawable.tortuga,"Tita la Tortuga",R.string.tvnumero));

    }

    public void inicializarAdaptador2(){
        //le paso la lista de mascotas a mi objeto adaptador
        SegundaPantallaAdapter adaptador = new SegundaPantallaAdapter(mascotas2);
        //le paso a mi recyclerview el objeto adaptador que manejará
        listaMascotas2.setAdapter(adaptador);
    }
    //con esto activamos la navegación hacia atrás
    public void irAtras(View view){
        Intent atras = new Intent(SegundaPantalla.this, MainActivity.class);
        startActivity(atras);

    }
}
