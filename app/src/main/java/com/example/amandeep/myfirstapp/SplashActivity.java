package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    Thread.sleep(3000);
                    Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                    startActivity(intent);

                }
                catch (InterruptedException e)
                {
                }
            }//end of run
        };
        t.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
