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

public class SingleHotel extends AppCompatActivity {
    String[] data = new String[6];

    String[] starsS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hotel);
        starsS = getResources().getStringArray(R.array.starsIc);
        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("nom");
        data[1] = starsS[getbundle.getInt("stars")];
        data[2] = getbundle.getString("web");
        data[3] = getbundle.getString("telf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");

        ImageView Img = findViewById(R.id.hotel_img);
        TextView nom = findViewById(R.id.hotel_nom);
        TextView stars = findViewById(R.id.hotel_stars);
        //TextView web = findViewById(R.id.hotel_web); falta añadir
        TextView tel = findViewById(R.id.hotel_tel);
        //TextView ubi = findViewById(R.id.hotel_ubi); falta añadir
        ImageButton bCall = findViewById(R.id.call_hotel);
        ImageButton bWeb = findViewById(R.id.web_hotel);
        ImageButton bUbi = findViewById(R.id.ubi_hotel);

        nom.setText(data[0]);
        stars.setText(data[1]);
        tel.setText("Telefon: "+ data[3]);

        Glide.with(this)
                .load(data[5])
                .into(Img);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }

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