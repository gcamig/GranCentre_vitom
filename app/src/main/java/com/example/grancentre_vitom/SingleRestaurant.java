package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class SingleRestaurant extends AppCompatActivity {

    String[] data = new String[6];
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_restaurant);

        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("nom");
        type = getbundle.getInt("type");
        data[2] = getbundle.getString("web");
        data[3] = getbundle.getString("telf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");

        if(type == 1) data[1] = "Esmorzars";
        if (type == 2) data[1] = "MenjaRapid";
        if (type == 3) data[1] = "Mexica";
        if (type == 4) data[1] = "Restaurants";

        ImageView Img = findViewById(R.id.Tvimg);
        TextView nom = findViewById(R.id.nom);
        TextView type = findViewById(R.id.type);

        nom.setText(data[0]);
        type.setText(data[1]);

        Glide.with(this)
                .load(data[5])
                .into(Img);
    }
}