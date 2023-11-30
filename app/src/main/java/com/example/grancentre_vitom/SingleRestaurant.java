package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class SingleRestaurant extends AppCompatActivity {

    String[] data = new String[6];
    String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_restaurant);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }

        categories = getResources().getStringArray(R.array.restaurantTypes);

        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("nom");
        data[1] = categories[getbundle.getInt("type")];
        data[2] = getbundle.getString("web");
        data[3] = getbundle.getString("telf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");


        ImageView Img = findViewById(R.id.rest_img);
        TextView nom = findViewById(R.id.rest_nom);
        TextView type = findViewById(R.id.rest_type);
        TextView web = findViewById(R.id.rest_web);
        TextView tel = findViewById(R.id.rest_tel);
        TextView ubi = findViewById(R.id.rest_ubi);
        ImageButton bCall = findViewById(R.id.call_restaurant);
        ImageButton bWeb = findViewById(R.id.web_restaurant);
        ImageButton bUbi = findViewById(R.id.ubi_restaurant);

        nom.setText(data[0]);
        type.setText(data[1]);
        tel.setText("Telefon: "+ data[3]);


        Glide.with(this)
                .load(data[5])
                .into(Img);


        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+data[3]));
                startActivity(intent);
            }
        });
        bWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data[2]));
                startActivity(intent);
            }
        });
        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=:"+data[4]));
                startActivity(intent);
            }
        });
    }
}