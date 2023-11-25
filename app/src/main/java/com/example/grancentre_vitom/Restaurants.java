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
CustomAdapter customAdapter;
String[] categories = {"Tots","Esmorzars", "Menja Rapid", "Mexica", "Restaurants"};
//imatges ordenades dels restaurants
int [] imgList = {
        R.drawable.rest_latremenda,
        R.drawable.rest_latradicional,
        R.drawable.res_crepnova,
        R.drawable.res_farggi,
        R.drawable.res_starbucks,
        R.drawable.res_manolonakes,
        R.drawable.res_burger,
        R.drawable.res_kfc,
        R.drawable.res_mcdonald,
        R.drawable.res_empanada,
        R.drawable.res_oakberry,
        R.drawable.res_tacobell
};


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

        //data.add(new restaurant(""))
        data.add(new restaurant("La tremenda", 4,"https://latremenda.com/" ,"tel:931716897" ,"geo:41.44294,2.20018" ));
        data.add(new restaurant("La Tradicional", 4, "https://latradicionaltapas.es/", "tel:930400564", "geo:41.44101799298387,2.1984500499960298"));
        data.add(new restaurant("Crep Nova", 4, "https://www.crepnova.com/", "tel:931564445", "geo:41.44295916318629, 2.200000488170791"));
        data.add(new restaurant("Farggi 1957", 1, "https://www.farggicafe.com/", "tel:933011018", "geo:41.44012061412995, 2.1985896388934534"));
        data.add(new restaurant("Starbucks", 1, "https://www.starbucks.es/", "tel:935216257", "geo:41.44208686620995, 2.1984668100577798"));
        data.add(new restaurant("MANOLO BAKES", 1, "https://www.manolobakes.com/", "tel:930134526", "geo:41.439535429909355, 2.196971938893445"));
        data.add(new restaurant("Burger King", 2, "https://www.burgerking.es/home", "tel:933608953", "geo:41.44081375561922, 2.197923425400824"));
        data.add(new restaurant("KFC - Kentucky Fried Chicken", 2, "https://www.kfc.es/", "tel:933609873", "geo:41.43919621584857, 2.197391981221852"));
        data.add(new restaurant("Mc Donald's", 2, "https://mcdonalds.es/", "tel:938339106", "geo:41.44289645148902, 2.20023189656514"));
        data.add(new restaurant("I Love Empanada", 3, "https://www.iloveempanada.com/", "tel:645558408", "geo:41.43986468592533, 2.1983984407438713"));
        data.add(new restaurant("OAKBERRY", 3, "https://www.oakberry.com/es-es", "tel:685226513", "geo:41.443106550572345, 2.1990305834373913"));
        data.add(new restaurant("TACO BELL", 3, "https://tacobell.es/", "tel:933608982", "geo:41.440959255330675, 2.198054156087031"));
        return data;
    }

    private String [] getRestaurantList(){
        String [] restaurantList = new String[12];
        int i=0;
        for (restaurant Restaurants : getRestaurant()){
            restaurantList[i] = Restaurants.getNom();
            i++;
        }
        return restaurantList;
    }

    private void getSelectedCategoria(int pos)
    {
        String [] restList = new String[12];
        if(pos == 0) {
            customAdapter= new CustomAdapter(this,getRestaurantList(),imgList);
        } else {
            int i=0;
            for (restaurant Restaurants : getRestaurant()){
                if (Restaurants.getType() == pos) {
                    restList[i]= Restaurants.getNom();
                }
                i++;
            }
            customAdapter= new CustomAdapter(this,restList,imgList);
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