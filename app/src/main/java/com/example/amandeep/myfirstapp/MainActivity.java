package com.example.amandeep.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int num = 100;
    TextView tv1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button1);

        tv1 = (TextView) findViewById(R.id.textView1);

        b1.setOnClickListener(this);
    }   //end of onCreate()

    @Override
    public void onClick(View v) {
        num -= 5;
        tv1.setText("num = "+ num);
    }
}
