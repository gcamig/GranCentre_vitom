package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ArrayList<business> businessesList = getBusiness();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses);
        iniViews();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundel = new Bundle();
                bundel.putString("name", businessesList.get(position).getNom());
                bundel.putInt("category", businessesList.get(position).getCategory());
                bundel.putString("url", businessesList.get(position).getUrl());
                bundel.putString("tlf", businessesList.get(position).getTlf());
                bundel.putString("ubi", businessesList.get(position).getUbi());
                bundel.putString("img", businessesList.get(position).getImg());
                bundel.putBoolean("wheelchair", businessesList.get(position).getWheelchair());

                Intent intent = new Intent(Businesses.this, SingleBusiness.class);
                intent.putExtras(bundel);
                startActivity(intent);
            }
        });
    }

    private ArrayList<business> getBusiness() {
        ArrayList<business> data = new ArrayList<>();
        data.clear();

        data.add(new business("Bershka",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/ntvorzs9cju1rvp0dlfl.jpg","https://www.bershka.com/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","748242723\n",false));
        data.add(new business("Adidas",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/li93b2aonvmiilfse3ec.jpg","https://www.adidas.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","636348161",true));
        data.add(new business("Calzedonia",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/zq0aoc887rfaxawpe9db.png","https://www.calzedonia.com/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","769638782",true));
        data.add(new business("Desigual",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/xvajbeqoaxigywwrvvoh.jpg","https://www.desigual.com/es_ES/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641459754",false));
        data.add(new business("Drim",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/bbhfmxygqk29gisdphnq.png","https://www.drim.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","736519600",true));
        data.add(new business("Juguettos",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/izccunk7stgfaaqg4smr.png","https://juguettos.com/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","691700299",true));
        data.add(new business("Lego Store",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/dodovmdzgcap7g0reb8b.jpg","https://www.lego.com/es-es/stores","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","789366543",true));
        data.add(new business("Dyson",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/tbegab93mrqobqylx1dk.png","https://www.dyson.es/es","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","747712736",false));
        data.add(new business("Gato Preto",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mpioprelb9y1l902qr8n.png","https://gatopreto.com/es/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","618102604",true));
        data.add(new business("La Mallorquina",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/pvivrolzvnlmvahaqzsq.jpg","https://lamallorquina.es/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","714913443",false));
        data.add(new business("Natura",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/gwqtfu9aelfdcaxdqtvz.png","https://www.naturaselection.com/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","696711936",true));
        data.add(new business("Apple",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/amnvadoexwv0dzogh3vt.png","https://www.apple.com/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","738501387",false));
        data.add(new business("Casa del libro",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/iprlflymktju24s6lvrl.png","https://www.casadellibro.com/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","719137122",true));
        data.add(new business("Game",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/oj5ytom4heplagy7d9wf.png","https://www.game.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","714982275",true));
        data.add(new business("Fnac",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/wh9ut7gxqer4dv9igmo9.png","https://www.fnac.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641839238",false));
        data.add(new business("Media Markt",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mdposc97izase4its2lo.png","https://www.mediamarkt.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","619701749",true));
        data.add(new business("Crocs",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/hite812d7f9cddxxqrxl.png","https://crocs.es/es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","632970449",true));
        data.add(new business("Munich",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/raso2dbpgewn5kojurs9.png","https://www.munichsports.com/es","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","692939310",false));
        data.add(new business("AW Lab",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/e1hswoenpboizhetz4o6.jpg","https://es.aw-lab.com/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","761130287",true));
        data.add(new business("Druni",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/f1xqpb5jeezc76nrftez.png","https://www.druni.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","794189611",false));
        data.add(new business("Primor",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/onqepfvbf2rbzbgopknh.png","https://www.primor.eu/es_es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","756694612",true));
        data.add(new business("Sephora",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/t0jlyjlbcri1qawwirw0.png","https://www.sephora.es/","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641009985",false));
        data.add(new business("Rituals",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/atx0rzszo73ncdz2glb5.png","https://www.rituals.com/es-es/home","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","724817600",true));

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
        if (pos == 0){
            adapter = new CustomAdapter(this, getBusinessList(), getBusinessImg());
            businessesList = getBusiness();
        }
        else {
            businessesList.clear();
            int i = 0;
            for (business b : getBusiness()){
                if (b.getCategory() == pos){
                    restList[i] = b.getNom();
                    restImg[i] = b.getImg();
                    businessesList.add(b);
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
    public boolean wheelchair;
    public String getNom() {return nom;}
    public int getCategory() {return category;}
    public String getImg() {return img;}
    public String getUrl() {return url;}
    public String getTlf() {return tlf;}
    public String getUbi() {return ubi;}
    public Boolean getWheelchair() {return wheelchair;}
    public business(String nom, int category, String img, String url, String ubi, String tlf, Boolean wheelchair){
        this.nom = nom;
        this.category = category;
        this.img = img;
        this.url = url;
        this.ubi = ubi;
        this.tlf = tlf;
        this.wheelchair = wheelchair;
    }
    @Override
    public String toString() {return nom;}
}