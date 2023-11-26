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

public class Hotels extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    CustomAdapter customAdapter;
    String[] estrellas = {"Tots","5⭐", "4⭐", "3⭐", "2⭐", "1⭐"};
    //imatges ordenades dels hotels
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
        listView.setAdapter(new CustomAdapter(this, getHotelList(),getHotelList()));

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
                ArrayList<hotel> hotelsList = getHotel();
                bundel.putString("Nom", hotelsList.get(position).getNom());
            }
        });
    }


    private ArrayList<hotel> getHotel() {
        ArrayList<hotel> data = new ArrayList<>();
        data.clear();

        //String[] estrellas = {"Tots","5⭐", "4⭐", "3⭐", "2⭐", "1⭐"};
        //0:tots, 1:Esmorzar, 2:Menja Rapid, 3:Mexica, 4:Restaurants
        //nom, tipus, web, tlf, ubi

        //data.add(new restaurant(""))
        data.add(new hotel("Barcelona Corona Hostal", 5, "https://www.coronahostel.com/", "tel:935393239", "geo:41.434735793010205, 2.218611552434027","https://los40.com/resizer/PQPPAQVYQT03CkJhLQrBsD-YW44=/654x491/filters:format(jpg):quality(70)/cloudfront-eu-central-1.images.arcpublishing.com/prisaradiolos40/NZIOJAQ7EFKE5LZ4PGLIGZBGXM.jpg"));
        data.add(new hotel("Catalonia La Maquinista", 4, "https://www.cataloniahotels.com/es/hotel/catalonia-la-maquinista?mb=1", "tel:932745370", "geo:41.44006025991857, 2.1999962137958367","https://lh3.googleusercontent.com/3bXLbllNTRoiTCBdkybd1YzqVWWDRrRwJNkVRZ3mcf7rlydWfR13qJlCSxJRO8kPe304nw1jQ_B0niDo56gPgoGx6x_ZOjtVOK6UGIr3kshpmTq46pvFObfJ2K0wzoqk36MWWSnh0y9PzgE7PVSRz6Y"));
        data.add(new hotel("Can PANISOLA", 4, "https://www.hoteldiario.com/cal-ganxet/", "tel:653889191", "geo:41.44431868060959, 2.1762411677744797", "https://malavitaclothing.com/cdn/shop/files/Diseno_sin_titulo.png?v=1697707421&width=160"));
        data.add(new hotel("Hotel Marina Badalona", 4, "https://www.hotelmarinabadalona.com/?utm_source=google&utm_medium=organic&utm_campaign=my_business", "tel:830831083", "geo:41.43794220160368, 2.242390346692835","https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/768px-LEGO_logo.svg.png"));
        data.add(new hotel("Hostal Badaloní", 3, "http://www.hostalbadaloni.com/", "tel:933888899", "geo:41.44634499496082, 2.238301559817194","https://www.hostalbadaloni.com/imatges/305x80-logo-1.png"));
        data.add(new hotel("Laramond Barcelona Rooms", 3, "http://www.laramond.com/", "tel:931751099", "geo:41.42895021904784, 2.1791933069867877","https://cdn.logo.com/hotlink-ok/logo-social.png"));
        data.add(new hotel("Kamelly", 3, "https://www.hotelesfinder.com/kamelly-badalona/", "tel:663690848", "geo:41.44629586982608, 2.224075559817194","https://img.freepik.com/vector-premium/ilustracion-simple-logotipo-hotel_434503-736.jpg?w=2000"));
        data.add(new hotel("Ciutat de Sant Adrià", 2,"https://www.ciutatdesantadria.com/CA/hotel.html" ,"tel:934620333" ,"geo:41.43020878781353, 2.22120696275744", "https://www.ciutatdesantadria.com/templates/cadenas/smartnew/images/fotos_hotels/SYN1405/logo.png"));
        data.add(new hotel("Ibis", 2, "https://all.accor.com/lien_externe.svlt?goto=fiche_hotel&code_hotel=3310&merchantid=seo-maps-ES-3310&sourceid=aw-cen&utm_medium=seo+maps&utm_source=google+Maps&utm_campaign=seo+maps&y_source=1_MTUzNTg2MzktNzE1LWxvY2F0aW9uLndlYnNpdGU%3D", "tel:932768310", "geo:41.43601183293106, 2.181586518308421","https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Ibis_Hotel_Logo_2016.png/800px-Ibis_Hotel_Logo_2016.png"));
        data.add(new hotel("Mellow Hostel Barcelona", 2, "http://www.mellowbarcelona.com/", "tel:934294533", "geo:41.42649320924335, 2.168244791072217","https://www.cubez.es/images/header/logo.png"));
        data.add(new hotel("Hostal Athenas", 1, "https://www.hostalathenas.com/", "tel:934622030", "geo:41.43246109018272, 2.2180741429044106","https://hostalathenas.com/wp-content/uploads/2016/05/Hostal_Athenas_retina.png"));
        data.add(new hotel("Be Dream Hostel", 1, "http://www.behostels.com/dream", "tel:933991420", "geo:41.44482674566689, 2.237455082540814","https://behostels.com/wp-content/uploads/2015/06/be-dream-hostel.png"));
        return data;

    }

    private String [] getHotelList(){
        String [] hotelList = new String[12];
        int i=0;
        for (hotel Hotels : getHotel()){
            hotelList[i] = Hotels.getNom();
            i++;
        }
        return hotelList;
    }
    private String [] getHotelImg(){
        String [] hotelImg = new String[12];
        int i=0;
        for (hotel Hotels : getHotel()){
            hotelImg [i] = Hotels.getImgUrl();
            i++;
        }
        return hotelImg;
    }

    private void getSelectedCategoria(int pos)
    {
        String [] restList = new String[12];
        String [] restImg = new String[12];
        if(pos == 0) {
            customAdapter= new CustomAdapter(this,getHotelList(),getHotelImg());
        } else {
            int i=0;
            for (hotel r : getHotel()){
                if (r.getType() == pos) {
                    restList[i]= r.nom;
                    restImg[i] = r.imgUrl;
                    i++;
                }
            }
            customAdapter= new CustomAdapter(this,restList,restImg);
        }
        listView.setAdapter(customAdapter);
    }
}
class hotel{
    public String nom;
    public int stars;
    public String web;
    public String tlf;
    public String ubi;
    public String imgUrl;
    public String getNom(){
        return nom;
    }
    public int getType(){
        return stars;
    }
    public String getWeb() { return web; }
    public String getTlf() { return tlf; }
    public String getUbi() { return ubi; }
    public String getImgUrl() { return imgUrl; }
    public hotel(String nom, int stars, String web, String tlf, String ubi, String imgUrl)
    {
        this.nom = nom;
        this.stars = stars;
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