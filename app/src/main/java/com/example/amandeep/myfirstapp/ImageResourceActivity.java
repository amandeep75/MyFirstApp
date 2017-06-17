package com.example.amandeep.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageResourceActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_resource);

        iv = (ImageView)findViewById(R.id.imageView1);
        iv.setImageResource(R.drawable.m_7);
    }
}
