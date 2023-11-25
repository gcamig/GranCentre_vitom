package com.example.grancentre_vitom;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String listRestaurant[];
    int listImages [];
    LayoutInflater inflater;
    public CustomAdapter(Context ctx, String[] restaurantList, int[] images){
        this.context = ctx;
        this.listRestaurant = restaurantList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listRestaurant.length;
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
        convertView = inflater.inflate(R.layout.activity_custom_list, null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView Img = (ImageView) convertView.findViewById(R.id.imgView);
        //TextView desc = (TextView) convertView.findViewById(R.id.desc);
        //desc.setText(listRestaurant[position]);
        name.setText(listRestaurant[position]);
        //Img.setImageResource(listImages[position]);
        Img.setImageResource(listImages[position]);
        return convertView;
    }
}
