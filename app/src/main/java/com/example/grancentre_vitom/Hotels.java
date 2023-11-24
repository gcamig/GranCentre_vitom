package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Hotels extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    ArrayAdapter<restaurant> adapter;
    String[] estrellas = {"Tots","5*", "4*", "3*", "2*", "1*"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        inicialitzarViews();
    }

    private void inicialitzarViews(){
        spinner = findViewById(R.id.filtreHotels);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                estrellas
        ));

        listView = findViewById(R.id.hotelsList);
        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getHotels()
        ));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < estrellas.length) {
                    getSelectedCategoria(position);
                } else {
                    Toast.makeText(Hotels.this, "La categoria seleccionada no existeix!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Hotels.this, SingleHotel.class);
                startActivity(intent);

                Bundle bundel = new Bundle();
                ArrayList<hotel> hotelsList = getHotels();
                String nom = hotelsList.get(position).getNom();
                bundel.putString("Nom", hotelsList.get(position).getNom());
            }
        });
    }


    private ArrayList<hotel> getHotels() {
        ArrayList<hotel> data = new ArrayList<>();
        data.clear();

        //String[] categories = {"Tots","Italia", "Japones", "Mexica"};
        //0:tots, 1:Italia, 2:Japones, 3:Mexica

        data.add(new hotel("La Tremenda", 3));
        data.add(new hotel("Viena", 2));
        data.add(new hotel("Burguer", 2));
        data.add(new hotel("McDonalds", 2));
        data.add(new hotel("Pastas Mario", 1));

        return data;
    }

    private void getSelectedCategoria(int pos)
    {
        ArrayList<hotel> hotels = new ArrayList<>();
        if(pos == 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getHotels());
        } else {
            for (hotel Hotels : getHotels()){
                if (Hotels.getType() == pos) {
                    hotels.add(Hotels);
                }
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hotels);
        }
        listView.setAdapter(adapter);
    }
}
class hotel{
    public String nom;
    public int type;

    public String getNom(){
        return nom;
    }

    public int getType(){
        return type;
    }

    public hotel(String nom, int type)
    {
        this.nom = nom;
        this.type = type;
    }

    @Override
    public String toString() {
        return nom;
    }
}