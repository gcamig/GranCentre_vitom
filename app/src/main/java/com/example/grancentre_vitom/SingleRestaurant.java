package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


        nom.setText(data[0]);
        type.setText(data[1]);
        web.setText("Enllaç web: " + data[2]);
        tel.setText("Telefon: "+ data[3]);
        ubi.setText("Ubicacio: "+data[4]);

        Glide.with(this)
                .load(data[5])
                .into(Img);
    }
}