package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    public static final String EXTRA_CITY = "city_name";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_show);
        TextView t = findViewById(R.id.text_city);
        Button back = findViewById(R.id.button_back) ;
        Intent i = getIntent();
        String name = i.getStringExtra(EXTRA_CITY);
        if (name == null) {
            name = "";
        }
        t.setText(name);
        back.setOnClickListener(v  -> finish());
    }
}