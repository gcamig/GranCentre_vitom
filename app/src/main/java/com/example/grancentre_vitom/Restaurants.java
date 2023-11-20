package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Spinner spinner = findViewById(R.id.FiltreRestaurants);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                //solo cambia el array segun lo que quieras poner, esta definido en el string.xml
                R.array.restaurantList,
                android.R.layout.simple_spinner_item
        );

    }
}