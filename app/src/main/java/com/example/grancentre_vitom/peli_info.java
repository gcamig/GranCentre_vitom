package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class peli_info extends AppCompatActivity implements View.OnClickListener {

    Pelicula peliculaSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli_info);
        Intent intent = getIntent();
        List<Pelicula> listaDePeliculas = intent.getParcelableArrayListExtra("listaDePeliculas");
        int peliculaId = intent.getIntExtra("peliculaId", -1);

        if (peliculaId != -1) {
            peliculaSeleccionada = listaDePeliculas.get(peliculaId);
            // Resto del código para mostrar la información de la película

        } else {
            // Maneja el caso en el que no se proporciona un ID válido
        }

    }

    @Override
    public void onClick(View v) {
        String tituloPelicula = peliculaSeleccionada.getTitulo();
        Toast.makeText(this, tituloPelicula, Toast.LENGTH_SHORT).show();
    }
}