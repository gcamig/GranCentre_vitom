package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleHotel extends AppCompatActivity implements View.OnClickListener{
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

        ImageView Img = findViewById(R.id.resHotelImg);
        TextView nomH = findViewById(R.id.nomH);
        TextView stars = findViewById(R.id.stars);

        nomH.setText(data[0]);
        stars.setText(data[1]);

        Glide.with(this)
                .load(data[5])
                .into(Img);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.callHotel){
            Intent intent = new Intent(this, data[3].getClass());
            startActivity(intent);
        }
    }
}