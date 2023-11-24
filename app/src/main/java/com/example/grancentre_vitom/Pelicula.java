package com.example.grancentre_vitom;

import android.os.Parcel;
import android.os.Parcelable;

public class Pelicula implements Parcelable {
    private String id;
    private String titulo;
    private String descripcion;
    private double precio;
    private String url;


    // Constructor, getters y setters
    public Pelicula(String peliId, String Title, String Desc, double price, String urlPeli) {
        id = peliId;
        titulo = Title;
        descripcion = Desc;
        precio = price;
        url = urlPeli;
    }
    // Implementación de Parcelable
    protected Pelicula(Parcel in) {
        id = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }

        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }

    public String getTitulo() {
        return titulo;
    }

}