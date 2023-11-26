package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SingleBusiness extends AppCompatActivity {
    String[] data = new String[6];
    String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_business);
        categories = getResources().getStringArray(R.array.businessTypes);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("nom");
        data[1] = categories[getbundle.getInt("category")];
        data[2] = getbundle.getString("url");
        data[3] = getbundle.getString("tlf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");

        TextView businessName = findViewById(R.id.businessName);
        TextView businessCategory = findViewById(R.id.businessCategory);
        ImageView businessImg = findViewById(R.id.businessImg);

        businessName.setText(data[0]);
        businessCategory.setText(data[1]);

        Glide.with(this)
                .load(data[5])
                .into(businessImg);
    }
}