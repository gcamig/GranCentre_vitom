package com.example.grancentre_vitom;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String listRestaurant[];
    int listImages [];
    LayoutInflater inflater;
    String[] imageUrls = {"https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/retailer/logos/g2gwjgya5erwmcctrahw.jpg"};
    public CustomAdapter(Context ctx, String[] restaurantList, int[] images){
        this.context = ctx;
        this.listRestaurant = restaurantList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        int contadorNoNulos = 0;

        for (int i = 0; i < listRestaurant.length; i++) {
            if (listRestaurant[i] != null) {
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
        convertView = inflater.inflate(R.layout.activity_custom_list, null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView Img = (ImageView) convertView.findViewById(R.id.imgView);
        //TextView desc = (TextView) convertView.findViewById(R.id.desc);
        //desc.setText(listRestaurant[position]);
        name.setText(listRestaurant[position]);
        //Img.setImageResource(listImages[position]);
        Glide.with(convertView)
                .load(imageUrls[position])
                        .into(Img);

        return convertView;
    }
}
