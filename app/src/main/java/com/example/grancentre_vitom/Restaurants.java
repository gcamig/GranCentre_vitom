package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
ListView listView;
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

        listView = findViewById(R.id.ListView);
        ArrayAdapter<CharSequence> adapterList = ArrayAdapter.createFromResource(
                this,
                R.array.restaurantList,
                android.R.layout.simple_list_item_1
        );
        listView.setAdapter(adapterList);

    }
    //filtra por nombre pero falta aprender a filtrar por tipo
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Obtener la opción seleccionada en el Spinner
        String categoriaSeleccionada = parent.getItemAtPosition(position).toString();
        //obtenemos el array de restaurantes
        String [] restaurants = getResources().getStringArray(R.array.restaurantList);
        // Filtrar los datos en el adaptador del ListView según la categoría seleccionada
        ArrayList<String> datosFiltrados = new ArrayList<>();
        for (String restaurante : restaurants) {
            if (restaurante.contains(categoriaSeleccionada)) {
                datosFiltrados.add(restaurante);
            }
        }

        // Actualizar el adaptador del ListView con los datos filtrados
        ArrayAdapter<String> adapterFiltrado = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                datosFiltrados
        );
        listView.setAdapter(adapterFiltrado);
    }

    //@Override
    public void onNothingSelected(AdapterView<?> parent){
        //no hagas nada si no hay nada seleccionado
    }

}