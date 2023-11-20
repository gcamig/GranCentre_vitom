package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Spinner spinner = findViewById(R.id.FiltreRestaurants);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(
                this,
                //solo cambia el array segun lo que quieras poner, esta definido en el string.xml
                R.array.restaurantType,
                android.R.layout.simple_spinner_item
        );
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        ListView listView = findViewById(R.id.ListView);
        ArrayAdapter<CharSequence> adapterList = ArrayAdapter.createFromResource(
                this,
                R.array.restaurantList,
                android.R.layout.simple_list_item_1
        );
        listView.setAdapter(adapterList);

    }

    public void onItemSelected() {

    }

}