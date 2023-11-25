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
CustomAdapter customAdapter;
String[] categories = {"Tots","Esmorzars", "Menja Rapid", "Mexica", "Restaurants"};
//imatges ordenades dels restaurants
int [] imgList = {R.drawable.rest_latremenda, R.drawable.rest_latradicional};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);


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
        listView.setAdapter(new CustomAdapter(this, getRestaurantList(),imgList));

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

        //String[] categories = {"Tots","Esmorzar", "Menja Rapid", "Mexica", "Restaurants"};
        //0:tots, 1:Esmorzar, 2:Menja Rapid, 3:Mexica, 4:Restaurants
        //nom, tipus, web, tlf, ubi

        data.add(new restaurant("La tremenda", 4,"https://latremenda.com/" ,"tel:931716897" ,"geo:41.44294,2.20018" ));
        data.add(new restaurant("La Tradicional", 4, "https://latradicionaltapas.es/", "tel:930400564", "geo:41.44101799298387,2.1984500499960298"));
        //data.add(new restaurant(""))

        return data;
    }

    private String [] getRestaurantList(){
        String [] restaurantList = new String[30];
        int i=0;
        for (restaurant Restaurants : getRestaurant()){
            restaurantList[i] = Restaurants.getNom();
            i++;
        }
        return restaurantList;
    }

    private void getSelectedCategoria(int pos)
    {
        String [] restList = new String[30];
        //ArrayList<restaurant> restaurants = new ArrayList<>();
        if(pos == 0) {
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getRestaurant());
            customAdapter= new CustomAdapter(this,getRestaurantList(),imgList);
        } else {
            int i=0;
            for (restaurant Restaurants : getRestaurant()){
                if (Restaurants.getType() == pos) {
                    //restaurants.add(Restaurants);
                    restList[i]= Restaurants.getNom();
                }
                i++;
            }
            customAdapter= new CustomAdapter(this,restList,imgList);
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        }
        listView.setAdapter(customAdapter);
    }
}
class restaurant{
    public String nom;
    public int type;
    public String web;
    public String tlf;
    public String ubi;

    public String getNom(){
        return nom;
    }
    public int getType(){
        return type;
    }
    public String getWeb() { return web; }
    public String getTlf() { return tlf; }
    public  String getUbi() { return ubi; }
    public restaurant(String nom, int type, String web, String tlf, String ubi)
    {
        this.nom = nom;
        this.type = type;
        this.web = web;
        this.tlf = tlf;
        this.ubi = ubi;
    }

    @Override
    public String toString() {
        return nom;
    }
}