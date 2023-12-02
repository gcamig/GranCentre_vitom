package com.example.grancentre_vitom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

public class Configuration extends AppCompatActivity {
    ColorPickerView selector;
    LinearLayout selectedColor, businessLayout;
    TextView colorValue;
    BrightnessSlideBar brightnessSlideBar;
    Button btnSubmitColor;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        selector = findViewById(R.id.selector);
        colorValue = findViewById(R.id.colorValue);
        selectedColor = findViewById(R.id.selectedColor);
        brightnessSlideBar = findViewById(R.id.brightnessSlideBar);
        btnSubmitColor = findViewById(R.id.btnSubmitColor);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment_navbar())
                    .commit();
        }

        selector.attachBrightnessSlider(brightnessSlideBar);
        selector.setColorListener(new ColorEnvelopeListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                color = envelope.getColor();
                selectedColor.setBackgroundColor(envelope.getColor());
                colorValue.setText(envelope.getHexCode());
            }
        });

        btnSubmitColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Aquí estaba intentant enviar el SharedPreference
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("backColor", color);
                editor.apply();*/
            }
        });
    }
}