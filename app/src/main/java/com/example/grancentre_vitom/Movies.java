package com.example.grancentre_vitom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity implements View.OnClickListener {

    ImageButton b1,b2,b3,b4,b5,b6;

    List<Pelicula> listaDePeliculas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        b1 = findViewById(R.id.peli_hypnotic);
        b2 = findViewById(R.id.peli_hungerGames);
        listaDePeliculas.add(new Pelicula("peli_hypnotic", "Hypnotic", "Decidido a encontrar a su hija desaparecida, el detective Danny Rourke (Ben Affleck) se ve inmerso en un laberinto mientras investiga una serie de asaltos a bancos que desafían la realidad y que le harán cuestionarse sobre todo y todos los que le rodean. Con la ayuda de Diana Cruz, una vidente superdotada, Rourke persigue y, al mismo tiempo, es perseguido por un espectro letal, el único hombre que él cree que tiene la clave para encontrar a su hija. Pero acabará descubriendo mucho más de lo que esperaba.", 12.4, "hofd"));
        listaDePeliculas.add(new Pelicula("peli_hungerGames", "Los Juegos del Hambre", "Descripción de la Pelicula 1", 23, "hofd"));
    }

    @Override
    public void onClick(View v) {
        String resourceName = getResources().getResourceEntryName(v.getId());
        int peliculaId = getResources().getIdentifier(resourceName, "id", getPackageName());

        if (peliculaId != 0) {
            Intent intent = new Intent(this, peli_info.class);
            intent.putParcelableArrayListExtra("listaDePeliculas", (ArrayList<? extends Parcelable>) listaDePeliculas);
            intent.putExtra("peliculaId", peliculaId);
            startActivity(intent);
        }
    }
}
