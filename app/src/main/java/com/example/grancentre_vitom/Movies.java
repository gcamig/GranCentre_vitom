package com.example.grancentre_vitom;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Movies extends AppCompatActivity implements View.OnClickListener {

    // Peli 1
    CardView peli1; //id: peli1 ( global )
    LinearLayout cart1; //id: peli1cart  ( backgroundTint -> transparent || transparent2 )
    TextView title1; //id: peli1title ( visibility -> visible || invisible )
    TextView temp1; //id: peli1temp ( visibility -> visible || invisible )
    ImageButton tiket1; //id: peli1tiket (visibility -> visible || invisible )


    // Peli 2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }

        peli1 = findViewById(R.id.peli1);
        cart1 = findViewById(R.id.peli1cart);
        title1 = findViewById(R.id.peli1title);
        temp1 = findViewById(R.id.peli1temp);
        tiket1 = findViewById(R.id.peli1tiket);

    }

    @Override
    public void onClick (View v) {
        if (v.getId() == peli1.getId())
        {
            if (title1.getVisibility() == View.INVISIBLE){
                cart1.getBackground().setTint(v.getResources().getColor(R.color.transparent2, null));
                title1.setVisibility(View.VISIBLE);
                temp1.setVisibility(View.VISIBLE);
                tiket1.setVisibility(View.VISIBLE);
            }
            else {
                cart1.getBackground().setTint(v.getResources().getColor(R.color.transparent, null));
                title1.setVisibility(View.INVISIBLE);
                temp1.setVisibility(View.INVISIBLE);
                tiket1.setVisibility(View.INVISIBLE);
            }
        }
        //else if (v.getId() == ) {}
    }

}
