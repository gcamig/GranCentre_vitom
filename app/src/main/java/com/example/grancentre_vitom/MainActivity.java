package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btnHotels);
        b2 = findViewById(R.id.btnMovies);
        b3 = findViewById(R.id.btnRestaurants);
        b4 = findViewById(R.id.btnTransport);
        b5 = findViewById(R.id.btnBusiness);
        b6 = findViewById(R.id.btnEvents);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == b1.getId()){
            Intent intent = new Intent(this, Hotels.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Hoteles", Toast.LENGTH_SHORT);
            //tio.show();
        }
        else if (view.getId() == b2.getId()){
            Intent intent = new Intent(this, Movies.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Pelis", Toast.LENGTH_SHORT);
            //tio.show();
        }
        else if (view.getId() == b3.getId()){
            Intent intent = new Intent(this, Restaurants.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Restaurantes", Toast.LENGTH_SHORT);
            //tio.show();
        }
        else if (view.getId() == b4.getId()){
            Intent intent = new Intent(this, Transport.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Transporte", Toast.LENGTH_SHORT);
            //tio.show();
        }
        else if (view.getId() == b5.getId()){
            Intent intent = new Intent(this, Business.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Bussiness", Toast.LENGTH_SHORT);
            //tio.show();
        }
        else if (view.getId() == b6.getId()){
            Intent intent = new Intent(this, Events.class);
            startActivity(intent);
            //Toast tio = Toast.makeText(this, "Pagina de Eventos", Toast.LENGTH_SHORT);
            //tio.show();
        }
    }
}