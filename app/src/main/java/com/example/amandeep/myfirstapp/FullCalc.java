package com.example.amandeep.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.amandeep.myfirstapp.R.id.add;

public class FullCalc extends AppCompatActivity {
    int num1;
    int num2;
    int num3 = 0;
    int op = 0;
    /* op == 1 ADD
        op == 2 SUB
        op == 3 MUL
        op == 4 DIV
     */

    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_calc);
        tv1 = (TextView) findViewById(R.id.textView1);
    }

    public void one(View view)
    {
        tv1.append("1");
    }

    public void two(View view)
    {
        tv1.append("2");
    }

    public void three(View view)
    {
        tv1.append("3");
    }

    public void four(View view)
    {
        tv1.append("4");
    }

    public void five(View view)
    {
        tv1.append("5");
    }

    public void six(View view)
    {
        tv1.append("6");
    }

    public void seven(View view)
    {
        tv1.append("7");
    }

    public void eight(View view)
    {
        tv1.append("8");
    }

    public void nine(View view)
    {
        tv1.append("9");
    }

    public void zero(View view)
    {
        tv1.append("0");
    }

    public void add(View view)
    {
        num1 = Integer.parseInt(tv1.getText().toString()) ;
        tv1.setText("");
        op = 1;
    }

    public void sub(View view)
    {
        num1 = Integer.parseInt(tv1.getText().toString()) ;
        tv1.setText("");
        op = 2;
    }

    public void mul(View view)
    {
        num1 = Integer.parseInt(tv1.getText().toString()) ;
        tv1.setText("");
        op = 3;
    }

    public void div(View view)
    {
        num1 = Integer.parseInt(tv1.getText().toString()) ;
        tv1.setText("");
        op = 4;
    }

    public void clear(View view)
    {
        num1 = 0;
        tv1.setText("");
    }

    public void equal(View view)
    {
        num2 = Integer.parseInt(tv1.getText().toString());
        Toast.makeText(FullCalc.this, "number1: "+num1, Toast.LENGTH_SHORT).show();
        Toast.makeText(FullCalc.this, "number2: "+num2, Toast.LENGTH_SHORT).show();
        if(op == 1)
        {
            num3 = num1 + num2;
        }
        else if(op == 2)
        {
            num3 = num1 - num2;
        }
        else if(op == 3)
        {
            num3 = num1*num2;
        }

        else if(op == 4)
        {
            if(num2 == 0)
                Toast.makeText(FullCalc.this, "Undefined Division", Toast.LENGTH_SHORT).show();
            else
                num3 = num1/num2;
        }


        else if(op == 0)
            Toast.makeText(FullCalc.this, "Invalid Operation", Toast.LENGTH_SHORT).show();


        tv1.setText(""+num3);
    }
}
