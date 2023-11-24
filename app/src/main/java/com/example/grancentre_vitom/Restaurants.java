package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
ListView listView;
Spinner spinner;
ArrayAdapter<restaurant> adapter;
String[] categories = {"Tots","Italia", "Japones", "Mexica"};
String [] restaurantList = new String[30];
int [] imgList = {R.drawable.restaurants};

CustomAdapter customAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        getRestaurantString();
        inicialitzarViews();
    }
    private void inicialitzarViews(){
        spinner = findViewById(R.id.filtreRestaurants);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categories
        ));

        listView = findViewById(R.id.restaurantsList);
        //listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getRestaurant()));
        CustomAdapter customAdapter = new CustomAdapter(this, restaurantList, imgList);
        listView.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategoria(position);
                } else {
                    Toast.makeText(Restaurants.this, "La categoria seleccionada no existeix!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Restaurants.this, SingleRestaurant.class);
                startActivity(intent);

                Bundle bundel = new Bundle();
                ArrayList<restaurant> restaurantsList = getRestaurant();
                String nom = restaurantsList.get(position).getNom();
                bundel.putString("Nom", restaurantsList.get(position).getNom());
            }
        });
    }


    private ArrayList<restaurant> getRestaurant() {
        ArrayList<restaurant> data = new ArrayList<>();
        data.clear();

        //String[] categories = {"Tots","Italia", "Japones", "Mexica"};
        //0:tots, 1:Italia, 2:Japones, 3:Mexica

        data.add(new restaurant("La Tremenda", 3));
        data.add(new restaurant("Viena", 2));
        data.add(new restaurant("Burguer", 2));
        data.add(new restaurant("McDonalds", 2));
        data.add(new restaurant("Pastas Mario", 1));

        return data;
    }

    private void getRestaurantString(){
        int i=0;
        for (restaurant Restaurants : getRestaurant()){
            restaurantList[i] = Restaurants.getNom();
            i++;
        }
    }

    private void getSelectedCategoria(int pos)
    {
        String [] restList = new String[30];
        //ArrayList<restaurant> restaurants = new ArrayList<>();
        if(pos == 0) {
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getRestaurant());
            customAdapter1= new CustomAdapter(this,restaurantList,imgList);
        } else {
            int i=0;
            for (restaurant Restaurants : getRestaurant()){
                if (Restaurants.getType() == pos) {
                    //restaurants.add(Restaurants);
                    restList[i]= Restaurants.getNom();
                }
                i++;
            }
            customAdapter1= new CustomAdapter(this,restList,imgList);
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        }
        listView.setAdapter(customAdapter1);
    }
}
class restaurant{
    public String nom;
    public int type;

    public String getNom(){
        return nom;
    }

    public int getType(){
        return type;
    }

    public restaurant(String nom, int type)
    {
        this.nom = nom;
        this.type = type;
    }

    @Override
    public String toString() {
        return nom;
    }
}