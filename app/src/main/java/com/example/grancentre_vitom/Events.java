package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Events extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    EventsAdapter adapter;
    String[] categories;
    ArrayList<event> eventsList = getEvent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        iniViews();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }
    }
    private void iniViews() {
        categories = getResources().getStringArray(R.array.eventCategories);
        spinner = findViewById(R.id.filtreEvents);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        ));
        listView = findViewById(R.id.eventsList);
        listView.setAdapter(new CustomAdapter(
                this,
                getEventList(),
                getEventImg()
        ));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategory(position);
                } else {
                    Toast.makeText(Events.this, "La categoria seleccionada no existeix!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundel = new Bundle();
                bundel.putString("title", eventsList.get(position).getTitle());
                bundel.putInt("category", eventsList.get(position).getCategory());
                bundel.putString("ubi", eventsList.get(position).getUbi());
                bundel.putString("img", eventsList.get(position).getImg());
                bundel.putString("date", eventsList.get(position).getDate());
                bundel.putBoolean("wheelchair", eventsList.get(position).getWheelchair());

                Intent intent = new Intent(Events.this, SingleEvent.class);
                intent.putExtras(bundel);
                startActivity(intent);
            }
        });
    }
    private ArrayList<event> getEvent() {
        ArrayList<event> data = new ArrayList<>();
        data.clear();

        data.add(new event("Tutankamón, la experiencia inmersiva",1,"1 Dic - 29 Feb 2023","https://aws-tiqets-cdn.imgix.net/images/content/f05e5cd991e3469a936dd61784163e30.jpeg?auto=format&dpr=1&fit=crop&h=280&ixlib=python-3.2.1&q=40&w=280&s=37eaccdc5484018f8ca21ebdd80313d0","Carrer Badajoz, 38-40, 08005, Barcelona, ES",false));
        data.add(new event("Museo Banksy Barcelona",1,"30 nov - 31 Dic 2023","https://aws-tiqets-cdn.imgix.net/images/content/66f3b5966999447298147f6d7c56eb31.jpg?auto=format&dpr=1&fit=crop&h=280&ixlib=python-3.2.1&q=40&w=280&s=0a64725b4633ef6e02ee2f53bc9449c9","C/Trafalgar, 34, PB, 08010, Barcelona, ES",true));
        data.add(new event("Primavera Sound Barcelona",2,"30 may - 1 Jun 2024","https://assets-img.primaverasound.com/730x520/psweb/ccg0vqdbpp8vs20h32va_1688034727634.png","Rambla de Prim 2-4 El Maresme Fòrum, Barcelona Spain",false));
        data.add(new event("Barcelona Beach Festival",2,"Por confirmar","https://www.bcnbeachfestival.com/wp-content/uploads/2022/07/bbf-skull-22-clean.png","C. de la Pau, 08930, Barcelona",true));
        data.add(new event("Olivia Rodrigo",3,"18 Jun 2024","https://s1.ticketm.net/img/tat/dam/a/166/1f478346-1013-4b88-a07c-83caa0e40166_CUSTOM.jpg","Paseo Olímpico s/n, 08004 Barcelona, España",true));
        data.add(new event("Jonas Brothers",3,"25 May 2024","https://s1.ticketm.net/img/tat/dam/a/482/dcec68c6-a651-4115-a2b9-cf7bbd384482_CUSTOM.jpg","Paseo Olímpico s/n, 08004 Barcelona, España",false));
        data.add(new event("Mother Mother",3,"17 Mar 2024","https://s1.ticketm.net/img/tat/dam/a/a85/84547492-316f-4ae1-b61f-819515593a85_CUSTOM.jpg","Paseo Olímpico s/n, 08004 Barcelona, España",true));

        return data;
    }
    private String[] getEventList(){
        String[] businessList = new String[30];
        int i = 0;
        for (event e : getEvent()){
            businessList[i] = e.getTitle();
            i++;
        }
        return businessList;
    }
    private String[] getEventImg(){
        String[] businessList = new String[30];
        int i = 0;
        for (event e : getEvent()){
            businessList[i] = e.getImg();
            i++;
        }
        return businessList;
    }
    private void getSelectedCategory(int pos){
        String[] restList = new String[30];
        String[] restImg = new String[30];
        if (pos == 0){
            adapter = new EventsAdapter(this, getEventList(), getEventImg());
            eventsList = getEvent();
        }
        else {
            eventsList.clear();
            int i = 0;
            for (event e : getEvent()){
                if (e.getCategory() == pos){
                    restList[i] = e.getTitle();
                    restImg[i] = e.getImg();
                    eventsList.add(e);
                    i++;
                }
            }
            adapter = new EventsAdapter(this, restList, restImg);
        }
        listView.setAdapter(adapter);
    }
}


class event{
    public String title;
    public int category;
    public String img;
    public String ubi;
    public String date;
    public boolean wheelchair;
    public String getTitle() {return title;}
    public int getCategory() {return category;}
    public String getImg() {return img;}
    public String getUbi() {return ubi;}
    public String getDate() {return date;}
    public Boolean getWheelchair() {return wheelchair;}
    public event(String title, int category, String date, String img, String ubi, Boolean wheelchair){
        this.title = title;
        this.category = category;
        this.date = date;
        this.img = img;
        this.ubi = ubi;
        this.wheelchair = wheelchair;
    }
    @Override
    public String toString() {return title;}
}