package com.example.grancentre_vitom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EventsAdapter extends BaseAdapter {
    Context context;
    String listEvents[];
    LayoutInflater inflater;
    String[] imageUrls;

    public EventsAdapter(Context ctx, String[] eventsList, String[] images) {
        this.context = ctx;
        this.listEvents = eventsList;
        this.imageUrls = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        int contadorNoNulos = 0;

        for (int i = 0; i < listEvents.length; i++) {
            if (listEvents[i] != null) {
                contadorNoNulos++;
            }
        }
        return contadorNoNulos;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_events, null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView Img = (ImageView) convertView.findViewById(R.id.imgView);
        //TextView desc = (TextView) convertView.findViewById(R.id.desc);
        //desc.setText(listRestaurant[position]);
        name.setText(listEvents[position]);
        //Img.setImageResource(listImages[position]);
        Glide.with(convertView)
                .load(imageUrls[position])
                .into(Img);

        return convertView;
    }
}
