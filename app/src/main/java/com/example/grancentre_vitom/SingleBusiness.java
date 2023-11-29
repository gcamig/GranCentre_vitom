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
        data[0] = getbundle.getString("name");
        data[1] = categories[getbundle.getInt("category")];
        data[2] = getbundle.getString("url");
        data[3] = getbundle.getString("tlf");
        data[4] = getbundle.getString("ubi");
        data[5] = getbundle.getString("img");

        TextView businessName = findViewById(R.id.businessName);
        TextView businessCategory = findViewById(R.id.businessCategory);
        TextView businessTlf = findViewById(R.id.businessTlf);
        ImageView businessImg = findViewById(R.id.businessImg);
        TextView businessUrl = findViewById(R.id.businessUrl);
        TextView businessUbi = findViewById(R.id.businessUbi);

        businessName.setText(data[0]);
        businessCategory.setText(data[1]);
        businessTlf.setText(data[3]);
        businessUrl.setText(data[2]);
        businessUbi.setText(data[4]);


        Glide.with(this)
                .load(data[5])
                .into(businessImg);
    }
}