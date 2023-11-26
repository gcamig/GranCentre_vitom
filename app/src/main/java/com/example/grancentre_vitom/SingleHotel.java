package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleHotel extends AppCompatActivity {
    String[] data = new String[6];
    int stars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hotel);

        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("nom");
        stars = getbundle.getInt("stars");
        data[2] = getbundle.getString("web");
        data[3] = getbundle.getString("telf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");

        if(stars == 1) data[1] = "Hotel de 1 ⭐";
        if (stars == 2) data[1] = "Hotel de 2 ⭐";
        if (stars == 3) data[1] = "Hotel de 3 ⭐";
        if (stars == 4) data[1] = "Hotel de 4 ⭐";
        if (stars == 5) data[1] = "Hotel de 5 ⭐";

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
}