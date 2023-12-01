package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Parking extends AppCompatActivity {
    TextView nom1, nom2, nom3;
    TextView ubi1, ubi2, ubi3;
    TextView places1, places2, places3;
    TextView disp1, disp2, disp3;
    ArrayList<ParkingsClass> parkings = getParkings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
        getiID();

        introduirNom();
        introduirUbi();
        introduirDisponibles();
        introduirPlaces();
    }

    private void getiID() {
        nom1 = findViewById(R.id.pk_nom1);
        nom2 = findViewById(R.id.pk_nom2);
        nom3 = findViewById(R.id.pk_nom3);

        ubi1= findViewById(R.id.pk_dir1);
        ubi2= findViewById(R.id.pk_dir2);
        ubi3= findViewById(R.id.pk_dir3);

        places1= findViewById(R.id.pk_places1);
        places2= findViewById(R.id.pk_places2);
        places3= findViewById(R.id.pk_places3);

        disp1 = findViewById(R.id.pk_disp1);
        disp2 = findViewById(R.id.pk_disp2);
        disp3 = findViewById(R.id.pk_disp3);
    }

    private void introduirNom() {
        nom1.setText(parkings.get(0).nom);
        nom2.setText(parkings.get(1).nom);
        nom2.setText(parkings.get(2).nom);
    }
    private void introduirUbi() {
        ubi1.setText(parkings.get(0).ubi);
        ubi2.setText(parkings.get(1).ubi);
        ubi3.setText(parkings.get(2).ubi);
    }
    private void introduirPlaces() {
        places1.setText("Places totals: "+parkings.get(0).places);
        places2.setText("Places totals: "+parkings.get(1).places);
        places3.setText("Places totals: "+parkings.get(2).places);
    }
    private void introduirDisponibles() {
        disp1.setText("Places disponibles: "+parkings.get(0).disponibles);
        disp2.setText("Places disponibles: "+parkings.get(1).disponibles);
        disp3.setText("Places disponibles: "+parkings.get(2).disponibles);
    }

    private ArrayList<ParkingsClass> getParkings() {
        ArrayList<ParkingsClass> data = new ArrayList<>();

        data.add(new ParkingsClass("Garaje en calle Primer Marques de Les Franqueses en L'Hostal - Lledoner", "Direccio: L'Hostal - Lledoner, Granollers, Barcelona (provincia)", "214", "109"));
        data.add(new ParkingsClass("Atenea Estació Granollers", "Passeig Cristòfol Colom, 21, 08402, Granollers", "400", "53"));
        data.add(new ParkingsClass("Parc De Les Pruneres PARKIA", "Rambla Pompeu Fabra, 9-19, 8100, Mollet del Valles", "138", "80"));
        return data;
    }
}


class ParkingsClass {
    public String nom;
    public String ubi;
    public String places;
    public String disponibles;

    public ParkingsClass (String nom, String ubi, String places, String disponibles)
    {
        this.nom = nom;
        this.ubi = ubi;
        this.places = places;
        this.disponibles = disponibles;
    }
}