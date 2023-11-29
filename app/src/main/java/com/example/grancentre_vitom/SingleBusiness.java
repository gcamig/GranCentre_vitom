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

public class SingleBusiness extends AppCompatActivity {
    String[] data = new String[6];
    Boolean wheelchair;
    String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_business);
        categories = getResources().getStringArray(R.array.businessTypes);
        TextView businessName = findViewById(R.id.businessName),
                businessCategory = findViewById(R.id.businessCategory),
                businessTlf = findViewById(R.id.businessTlf),
                businessUrl = findViewById(R.id.businessUrl),
                businessUbi = findViewById(R.id.businessUbi);
        ImageView businessImg = findViewById(R.id.businessImg),
                wheelchairImg = findViewById(R.id.imgWheelchair);
        ImageButton bCall = findViewById(R.id.callBusiness),
                bWeb = findViewById(R.id.webBusiness),
                bUbi = findViewById(R.id.ubiBusiness);

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
        wheelchair = getbundle.getBoolean("wheelchair");

        businessName.setText(data[0]);
        businessCategory.setText(data[1]);
        businessTlf.setText("Tlf: " + data[3]);
        businessUrl.setText(data[2]);
        businessUbi.setText(data[4]);

        if (wheelchair){
            wheelchairImg.setImageResource(R.drawable.wheelchair);
            wheelchairImg.setBackgroundColor(getColor(R.color.black));
        }

        Glide.with(this)
                .load(data[5])
                .into(businessImg);

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