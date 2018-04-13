package com.facebook.mascotasapp;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Johans on 08/04/2018.
 */

public class Mascotas extends AppCompatActivity {
    private int foto, cantidadLikes, iconoLike;
    private String nombre;

    public Mascotas(int foto, String nombre,int cantidadLikes) {
        this.foto = foto;
        this.nombre = nombre;
        this.cantidadLikes = cantidadLikes;
    }

    public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIconoLike() {
        return iconoLike;
    }

    public void setIconoLike(int iconoLike) {
        this.iconoLike = iconoLike;
    }
}
