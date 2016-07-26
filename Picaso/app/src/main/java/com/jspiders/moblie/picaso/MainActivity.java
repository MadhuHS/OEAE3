package com.jspiders.moblie.picaso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv =(ImageView) findViewById(R.id.imageView);


        Picasso.with(MainActivity.this).load("https://drive.google.com/open?id=0B9htz-JBoqRAMWF0aDhRZkhlRFEtc3J2cjludjdSVkpwWTlV").into(iv);

    }
}
