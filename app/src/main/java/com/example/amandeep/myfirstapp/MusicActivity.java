package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.amandeep.myfirstapp.R;

public class MusicActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        intent = new Intent(this, MusicService.class);
    }

    public void b1Click(View v)
    {
        startService(intent);
    }

    public void b2Click(View v)
    {
        stopService(intent);
    }
}
