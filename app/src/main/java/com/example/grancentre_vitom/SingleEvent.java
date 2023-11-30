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

public class SingleEvent extends AppCompatActivity {
    String[] data = new String[5];
    Boolean wheelchair;
    String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        categories = getResources().getStringArray(R.array.eventCategories);
        TextView eventTitle = findViewById(R.id.eventTitle),
                eventCategory = findViewById(R.id.eventCategory),
                eventDate = findViewById(R.id.eventDate),
                eventUbi = findViewById(R.id.eventUbi);
        ImageView eventImg = findViewById(R.id.eventImg),
                wheelchairImg = findViewById(R.id.imgWheelchair);
        ImageButton bUbi = findViewById(R.id.ubiEvent);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
        Bundle getbundle = getIntent().getExtras();
        data[0] = getbundle.getString("title");
        data[1] = categories[getbundle.getInt("category")];
        data[2] = getbundle.getString("ubi");
        data[3] = getbundle.getString("img");
        data[4] = getbundle.getString("date");
        wheelchair = getbundle.getBoolean("wheelchair");

        eventTitle.setText(data[0]);
        eventCategory.setText(data[1]);
        eventDate.setText(data[4]);
        eventUbi.setText(data[2]);

        if (wheelchair){
            wheelchairImg.setImageResource(R.drawable.wheelchair);
            wheelchairImg.setBackgroundColor(getColor(R.color.black));
        }

        Glide.with(this)
                .load(data[3])
                .into(eventImg);

        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=:"+data[2]));
                startActivity(intent);
            }
        });
    }
}