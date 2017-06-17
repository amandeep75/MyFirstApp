package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv1 = (TextView)findViewById(R.id.textView1);
        Intent box = getIntent();
        String str = box.getStringExtra("TITLE");
        tv1.setText("TITLE  :"+str);
    }
}
