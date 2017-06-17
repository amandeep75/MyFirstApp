package com.example.amandeep.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        tv1 = (TextView) findViewById(R.id.textView1);
    } // End of onCreate()


    public void add(View v)
    {
        int a = Integer.parseInt(et1.getText().toString()) ;
        int b = Integer.parseInt(et2.getText().toString()) ;

        int c = a + b ;
        //  String.valueof(c);

        tv1.setText(""+c);

    }

    public void sub(View v)
    {
        int a = Integer.parseInt(et1.getText().toString()) ;
        int b = Integer.parseInt(et2.getText().toString()) ;

        int c = a - b ;
        //  String.valueof(c);

        tv1.setText(""+c);

    }

    public void mul(View v)
    {
        int a = Integer.parseInt(et1.getText().toString()) ;
        int b = Integer.parseInt(et2.getText().toString()) ;

        int c = a * b ;
        //  String.valueof(c);

        tv1.setText(""+c);

    }

    public void div(View v)
    {
        int a = Integer.parseInt(et1.getText().toString()) ;
        int b = Integer.parseInt(et2.getText().toString()) ;

        int c = a / b ;
        //  String.valueof(c);

        tv1.setText(""+c);

    }
}