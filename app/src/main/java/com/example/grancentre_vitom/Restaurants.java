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
ArrayList<restaurant> restaurantsList = getRestaurant();
String[] categories;
//imatges ordenades dels restaurants
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        categories = getResources().getStringArray(R.array.restaurantTypes);

        inicialitzarViews();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
    }
    private void inicialitzarViews(){
        spinner = findViewById(R.id.filtreRestaurants);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categories
        ));

        listView = findViewById(R.id.restaurantsList);
        listView.setAdapter(new CustomAdapter(this, getRestaurantList(),getRestaurantImg()));

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

                Bundle bundel = new Bundle();
                bundel.putString("nom", restaurantsList.get(position).getNom());
                bundel.putInt("type", restaurantsList.get(position).getType());
                bundel.putString("web", restaurantsList.get(position).getWeb());
                bundel.putString("telf", restaurantsList.get(position).getTlf());
                bundel.putString("ubi", restaurantsList.get(position).getUbi());
                bundel.putString("img", restaurantsList.get(position).getImgUrl());

                Intent intent = new Intent(Restaurants.this, SingleRestaurant.class);
                intent.putExtras(bundel);
                startActivity(intent);
            }
        });
    }


    private ArrayList<restaurant> getRestaurant() {
        ArrayList<restaurant> data = new ArrayList<>();
        data.clear();

        //Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain
        //String[] categories = {"Tots","Esmorzar", "Menja Rapid", "Mexica", "Restaurants"};
        //0:tots, 1:Esmorzar, 2:Menja Rapid, 3:Mexica, 4:Restaurants
        //nom, tipus, web, tlf, ubi

        //data.add(new restaurant(""))
        data.add(new restaurant("La tremenda", 4,"https://latremenda.com/" ,"931716897" ,"41.44294,2.20018", "https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/xgchmwunby4hasiobwdq.png"));
        data.add(new restaurant("La Tradicional", 4, "https://latradicionaltapas.es/", "930400564", "41.44101799298387,2.1984500499960298","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/ew1ke3macv55lr4gmv2w.png"));
        data.add(new restaurant("Crep Nova", 4, "https://www.crepnova.com/", "931564445", "41.44295916318629, 2.200000488170791","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/i28sdrypjo7qtmnsemcc.jpg"));
        data.add(new restaurant("Farggi 1957", 1, "https://www.farggicafe.com/", "933011018", "41.44012061412995, 2.1985896388934534","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/g75a018efhvfdntgavei.png"));
        data.add(new restaurant("Starbucks", 1, "https://www.starbucks.es/", "935216257", "41.44208686620995, 2.1984668100577798","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/kqejqiplso7upnqra6yv.png"));
        data.add(new restaurant("MANOLO BAKES", 1, "https://www.manolobakes.com/", "930134526", "41.439535429909355, 2.196971938893445", "https://weareevolbe.com/wp-content/uploads/2022/06/MANOLO-BAKES_LOGO.png"));
        data.add(new restaurant("Burger King", 2, "https://www.burgerking.es/home", "933608953", "41.44081375561922, 2.197923425400824","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/wubbuveuoseyanubltfd.jpg"));
        data.add(new restaurant("KFC - Kentucky Fried Chicken", 2, "https://www.kfc.es/", "933609873", "41.43919621584857, 2.197391981221852","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/bvwrhxjnjdyi77tij3sw.jpg"));
        data.add(new restaurant("Mc Donald's", 2, "https://mcdonalds.es/", "938339106", "41.44289645148902, 2.20023189656514","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/b6ursf9o3pfoaxf7afm4.png"));
        data.add(new restaurant("I Love Empanada", 3, "https://www.iloveempanada.com/", "645558408", "41.43986468592533, 2.1983984407438713","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/aqomkshoz2hocjj8gdcp.png"));
        data.add(new restaurant("OAKBERRY", 3, "https://www.oakberry.com/es-es", "685226513", "41.443106550572345, 2.1990305834373913","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/hxqax8xnwcgclqdyftfd.jpg"));
        data.add(new restaurant("TACO BELL", 3, "https://tacobell.es/", "933608982", "41.440959255330675, 2.198054156087031","https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/gfci4qsarkgdzt0b9csf.png"));
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
    private String [] getRestaurantImg(){
        String [] restaurantImg = new String[12];
        int i=0;
        for (restaurant Restaurants : getRestaurant()){
            restaurantImg[i] = Restaurants.getImgUrl();
            i++;
        }
        return restaurantImg;
    }

    private void getSelectedCategoria(int pos)
    {
        String [] restList = new String[12];
        String [] restImg = new String[12];
        if(pos == 0) {
            customAdapter= new CustomAdapter(this,getRestaurantList(),getRestaurantImg());
            restaurantsList = getRestaurant();
        } else {
            restaurantsList.clear();
            int i=0;
            for (restaurant r : getRestaurant()){
                if (r.getType() == pos) {
                    restList[i]= r.nom;
                    restImg[i] = r.imgUrl;
                    restaurantsList.add(r);
                    i++;
                }
            }
            customAdapter= new CustomAdapter(this,restList,restImg);
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
    public String imgUrl;
    public String getNom(){
        return nom;
    }
    public int getType(){
        return type;
    }
    public String getWeb() { return web; }
    public String getTlf() { return tlf; }
    public String getUbi() { return ubi; }
    public String getImgUrl() { return imgUrl; }
    public restaurant(String nom, int type, String web, String tlf, String ubi, String imgUrl)
    {
        this.nom = nom;
        this.type = type;
        this.web = web;
        this.tlf = tlf;
        this.ubi = ubi;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return nom;
    }
}