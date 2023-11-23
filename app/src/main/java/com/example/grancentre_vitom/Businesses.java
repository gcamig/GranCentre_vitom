package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Businesses extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    ArrayAdapter<business> adapter;
    String[] categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses);

        iniViews();
    }

    private void iniViews(){
        categories = getResources().getStringArray(R.array.businessTypes);
        spinner = findViewById(R.id.filtreBusiness);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        ));
        listView = findViewById(R.id.businessList);
        listView.setAdapter(new ArrayAdapter<>(
                this,
                (android.R.layout.simple_list_item_1),
                getBusiness()
        ));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategory(position);
                } else {
                    Toast.makeText(Businesses.this, "La categoria seleccionada no existeix!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<business> getBusiness() {
        ArrayList<business> data = new ArrayList<>();
        data.clear();

        data.add(new business("Bershka",3));

        return data;
    }

    private void getSelectedCategory(int pos){
        ArrayList<business> businesses = new ArrayList<>();
        if (pos == 0) adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getBusiness());
        else {
            for (business b : getBusiness()){
                if (b.getCategory() == pos) businesses.add(b);
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, businesses);
        }
        listView.setAdapter(adapter);
    }
}

class business{
    public String nom;
    public int category;
    public String getNom() {return nom;}
    public int getCategory() {return category;}
    public business(String nom, int category){
        this.nom = nom;
        this.category = category;
    }

    @Override
    public String toString() {return nom;}
}