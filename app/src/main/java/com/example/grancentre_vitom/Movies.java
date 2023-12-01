package com.example.grancentre_vitom;

import android.content.Intent;
import android.net.Uri;
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
    CardView peli2; //id: peli2 ( global )
    LinearLayout cart2; //id: peli2cart  ( backgroundTint -> transparent || transparent2 )
    TextView title2; //id: peli2title ( visibility -> visible || invisible )
    TextView temp2; //id: peli2temp ( visibility -> visible || invisible )
    ImageButton tiket2; //id: peli2tiket (visibility -> visible || invisible )

    // Peli 3
    CardView peli3; //id: peli3 ( global )
    LinearLayout cart3; //id: peli3cart  ( backgroundTint -> transparent || transparent2 )
    TextView title3; //id: peli3title ( visibility -> visible || invisible )
    TextView temp3; //id: peli3temp ( visibility -> visible || invisible )
    ImageButton tiket3; //id: peli3tiket (visibility -> visible || invisible )

    // Peli 4
    CardView peli4; //id: peli4 ( global )
    LinearLayout cart4; //id: peli4cart  ( backgroundTint -> transparent || transparent2 )
    TextView title4; //id: peli4title ( visibility -> visible || invisible )
    TextView temp4; //id: peli4temp ( visibility -> visible || invisible )
    ImageButton tiket4; //id: peli4tiket (visibility -> visible || invisible )

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }

        //PELI 1
        peli1 = findViewById(R.id.peli1);
        cart1 = findViewById(R.id.peli1cart);
        title1 = findViewById(R.id.peli1title);
        temp1 = findViewById(R.id.peli1temp);
        tiket1 = findViewById(R.id.peli1tiket);

        //PELI 2
        peli2 = findViewById(R.id.peli2);
        cart2 = findViewById(R.id.peli2cart);
        title2 = findViewById(R.id.peli2title);
        temp2 = findViewById(R.id.peli2temp);
        tiket2 = findViewById(R.id.peli2tiket);

        //PELI 3
        peli3 = findViewById(R.id.peli3);
        cart3 = findViewById(R.id.peli3cart);
        title3 = findViewById(R.id.peli3title);
        temp3 = findViewById(R.id.peli3temp);
        tiket3 = findViewById(R.id.peli3tiket);

        //PELI 4
        peli4 = findViewById(R.id.peli4);
        cart4 = findViewById(R.id.peli4cart);
        title4 = findViewById(R.id.peli4title);
        temp4 = findViewById(R.id.peli4temp);
        tiket4 = findViewById(R.id.peli4tiket);
    }

    @Override
    public void onClick (View v) {
        //PELI 1
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
        else if (v.getId() == tiket1.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.westfield.com/spain/lamaquinista/peliculas-detalle/06e945196bb44160_los-juegos-del-hambre-balada-de-pjaros-cantores-y-serpientes"));
            startActivity(intent);
        }

        //PELI 2
        else if (v.getId() == peli2.getId())
        {
            if (title2.getVisibility() == View.INVISIBLE){
                cart2.getBackground().setTint(v.getResources().getColor(R.color.transparent2, null));
                title2.setVisibility(View.VISIBLE);
                temp2.setVisibility(View.VISIBLE);
                tiket2.setVisibility(View.VISIBLE);
            }
            else {
                cart2.getBackground().setTint(v.getResources().getColor(R.color.transparent, null));
                title2.setVisibility(View.INVISIBLE);
                temp2.setVisibility(View.INVISIBLE);
                tiket2.setVisibility(View.INVISIBLE);
            }
        }
        else if (v.getId() == tiket2.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.westfield.com/spain/lamaquinista/peliculas-detalle/3b7a274b89554333_digimon-adventure-02-the-beginning"));
            startActivity(intent);
        }

        //PELI 3
        else if (v.getId() == peli3.getId())
        {
            if (title3.getVisibility() == View.INVISIBLE){
                cart3.getBackground().setTint(v.getResources().getColor(R.color.transparent2, null));
                title3.setVisibility(View.VISIBLE);
                temp3.setVisibility(View.VISIBLE);
                tiket3.setVisibility(View.VISIBLE);
            }
            else {
                cart3.getBackground().setTint(v.getResources().getColor(R.color.transparent, null));
                title3.setVisibility(View.INVISIBLE);
                temp3.setVisibility(View.INVISIBLE);
                tiket3.setVisibility(View.INVISIBLE);
            }
        }
        else if (v.getId() == tiket3.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.westfield.com/spain/lamaquinista/peliculas-detalle/3ea51b6fc9eb4c1c_la-navidad-en-sus-manos"));
            startActivity(intent);
        }

        //PELI 4
        else if (v.getId() == peli4.getId())
        {
            if (title4.getVisibility() == View.INVISIBLE){
                cart4.getBackground().setTint(v.getResources().getColor(R.color.transparent2, null));
                title4.setVisibility(View.VISIBLE);
                temp4.setVisibility(View.VISIBLE);
                tiket4.setVisibility(View.VISIBLE);
            }
            else {
                cart4.getBackground().setTint(v.getResources().getColor(R.color.transparent, null));
                title4.setVisibility(View.INVISIBLE);
                temp4.setVisibility(View.INVISIBLE);
                tiket4.setVisibility(View.INVISIBLE);
            }
        }
        else if (v.getId() == tiket4.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.westfield.com/spain/lamaquinista/peliculas-detalle/4884622439f14828_la-patrulla-canina-la-superpelcula"));
            startActivity(intent);
        }

    }

}
