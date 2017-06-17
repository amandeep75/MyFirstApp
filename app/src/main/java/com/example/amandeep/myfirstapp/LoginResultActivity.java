package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity
{

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        tv1 = (TextView)findViewById(R.id.textView1);

        Intent box = getIntent();

        Bundle b = box.getExtras();
        String s1 = b.getString("U");
        String s2 = b.getString("P");

        tv1.setText("Username:  "+s1);
        tv1.append("\n Password:  "+s2);
    }
}
