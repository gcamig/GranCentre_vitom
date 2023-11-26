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
                Intent intent = new Intent(Businesses.this, SingleBusiness.class);
                startActivity(intent);

                Bundle info = new Bundle();
                ArrayList<business> businessesList = getBusiness();
                info.putString("Nom", businessesList.get(position).getNom());
            }
        });
    }

    private ArrayList<business> getBusiness() {
        ArrayList<business> data = new ArrayList<>();
        data.clear();

        data.add(new business("Bershka",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/ntvorzs9cju1rvp0dlfl.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","748242723\n"));
        data.add(new business("Adidas",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/li93b2aonvmiilfse3ec.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","636348161"));
        data.add(new business("Calzedonia",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/zq0aoc887rfaxawpe9db.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","769638782"));
        data.add(new business("Desigual",6,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/xvajbeqoaxigywwrvvoh.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641459754"));
        data.add(new business("Drim",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/bbhfmxygqk29gisdphnq.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","736519600"));
        data.add(new business("Juguettos",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/izccunk7stgfaaqg4smr.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","691700299"));
        data.add(new business("Lego Store",5,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/dodovmdzgcap7g0reb8b.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","789366543"));
        data.add(new business("Dyson",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/tbegab93mrqobqylx1dk.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","747712736"));
        data.add(new business("Gato Preto",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mpioprelb9y1l902qr8n.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","618102604"));
        data.add(new business("La Mallorquina",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/pvivrolzvnlmvahaqzsq.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","714913443"));
        data.add(new business("Natura",4,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/gwqtfu9aelfdcaxdqtvz.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","696711936"));
        data.add(new business("Apple",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/amnvadoexwv0dzogh3vt.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","738501387"));
        data.add(new business("Casa del libro",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/iprlflymktju24s6lvrl.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","719137122"));
        data.add(new business("Game",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/oj5ytom4heplagy7d9wf.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","714982275"));
        data.add(new business("Fnac",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/wh9ut7gxqer4dv9igmo9.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641839238"));
        data.add(new business("Media Markt",3,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/mdposc97izase4its2lo.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","619701749"));
        data.add(new business("Crocs",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/hite812d7f9cddxxqrxl.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","632970449"));
        data.add(new business("Munich",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/raso2dbpgewn5kojurs9.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","692939310"));
        data.add(new business("AW Lab",2,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/e1hswoenpboizhetz4o6.jpg","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","761130287"));
        data.add(new business("Druni",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/f1xqpb5jeezc76nrftez.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","794189611"));
        data.add(new business("Primor",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/onqepfvbf2rbzbgopknh.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","756694612"));
        data.add(new business("Sephora",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/t0jlyjlbcri1qawwirw0.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","641009985"));
        data.add(new business("Rituals",1,"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/atx0rzszo73ncdz2glb5.png","Paseo Potosi, 2 El Bon Pastor, 08030 Barcelona Spain","724817600"));

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
    public business(String nom, int category, String img, String ubi, String tlf){
        this.nom = nom;
        this.category = category;
        this.img = img;
        this.ubi = ubi;
        this.tlf = tlf;
    }

    public String getUrl() {return url;}
    public String getTlf() {return tlf;}
    public String getUbi() {return ubi;}

    @Override
    public String toString() {return nom;}
}