package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Businesses extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    CustomAdapter adapter;
    String[] categories;
    int [] imgList = {R.drawable.rest_latremenda};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses);

        iniViews();
    }

    private void iniViews(){
        categories = getResources().getStringArray(R.array.businessTypes);
        spinner = findViewById(R.id.filtreBusiness);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        ));
        listView = findViewById(R.id.businessList);
        listView.setAdapter(new CustomAdapter(
                this,
                getBusinessList(),
                getBusinessImg()
        ));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategory(position);
                } else {
                    Toast.makeText(Businesses.this, "La categoria seleccionada no existeix!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<business> getBusiness() {
        ArrayList<business> data = new ArrayList<>();
        data.clear();

        data.add(new business("Bershka",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/ntvorzs9cju1rvp0dlfl.jpg"));
        data.add(new business("Adidas",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/li93b2aonvmiilfse3ec.jpg"));
        data.add(new business("Calzedonia",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/zq0aoc887rfaxawpe9db.png"));
        data.add(new business("Desigual",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/xvajbeqoaxigywwrvvoh.jpg"));
        data.add(new business("Drim",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/bbhfmxygqk29gisdphnq.png"));
        data.add(new business("Juguettos",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/izccunk7stgfaaqg4smr.png"));
        data.add(new business("Lego Store",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/dodovmdzgcap7g0reb8b.jpg"));
        data.add(new business("Dyson",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/tbegab93mrqobqylx1dk.png"));
        data.add(new business("Gato Preto",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mpioprelb9y1l902qr8n.png"));
        data.add(new business("La Mallorquina",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/pvivrolzvnlmvahaqzsq.jpg"));
        data.add(new business("Natura",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/gwqtfu9aelfdcaxdqtvz.png"));
        data.add(new business("Apple",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/amnvadoexwv0dzogh3vt.png"));
        data.add(new business("Casa del libro",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/iprlflymktju24s6lvrl.png"));
        data.add(new business("Game",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/oj5ytom4heplagy7d9wf.png"));
        data.add(new business("Fnac",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/wh9ut7gxqer4dv9igmo9.png"));
        data.add(new business("Media Markt",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mdposc97izase4its2lo.png"));
        data.add(new business("Crocs",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/hite812d7f9cddxxqrxl.png"));
        data.add(new business("Munich",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/raso2dbpgewn5kojurs9.png"));
        data.add(new business("AW Lab",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/e1hswoenpboizhetz4o6.jpg"));
        data.add(new business("Druni",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/f1xqpb5jeezc76nrftez.png"));
        data.add(new business("Primor",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/onqepfvbf2rbzbgopknh.png"));
        data.add(new business("Sephora",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/t0jlyjlbcri1qawwirw0.png"));
        data.add(new business("Rituals",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/atx0rzszo73ncdz2glb5.png"));

        return data;
    }

    private String[] getBusinessList(){
        String[] businessList = new String[30];
        int i = 0;
        for (business b : getBusiness()){
            businessList[i] = b.getNom();
            i++;
        }
        return businessList;
    }

    private String[] getBusinessImg(){
        String[] businessList = new String[30];
        int i = 0;
        for (business b : getBusiness()){
            businessList[i] = b.getImg();
            i++;
        }
        return businessList;
    }

    // Devuelve los negocios que en el "category" tienen la misma posición que en el spinner dentro del array de categorias.
    private void getSelectedCategory(int pos){
        String[] restList = new String[30];
        String[] restImg = new String[30];
        if (pos == 0) adapter = new CustomAdapter(this, getBusinessList(), getBusinessImg());
        else {
            int i = 0;
            for (business b : getBusiness()){
                if (b.getCategory() == pos){
                    restList[i] = b.getNom();
                    restImg[i] = b.getImg();
                    i++;
                }
            }
            adapter = new CustomAdapter(this, restList, restImg);
        }
        listView.setAdapter(adapter);
    }
}

class business{
    public String nom;
    public int category;
    public String img;
    public String url;
    public String tlf;
    public String ubi;
    public String getNom() {return nom;}
    public int getCategory() {return category;}
    public String getImg() {return img;}
    public business(String nom, int category, String img){
        this.nom = nom;
        this.category = category;
        this.img = img;
    }

    public String getUrl() {return url;}
    public String getTlf() {return tlf;}
    public String getUbi() {return ubi;}

    @Override
    public String toString() {return nom;}
}