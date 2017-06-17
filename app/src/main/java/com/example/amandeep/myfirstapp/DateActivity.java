package com.example.amandeep.myfirstapp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class DateActivity extends AppCompatActivity {

    EditText et1;
    String str1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        et1 = (EditText) findViewById(R.id.editText1);
    }

    public void openCalender(View view)
    {
        MyDateChooser ref = new MyDateChooser();
        Date d = new Date();
        DatePickerDialog dialog;

        dialog = new DatePickerDialog(this, ref, d.getYear(), d.getMonth(), d.getDate());

        dialog.show();
    }

    class MyDateChooser implements DatePickerDialog.OnDateSetListener
    {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            String str = year+ "-" +month +"-" +dayOfMonth;
            Toast.makeText(DateActivity.this, str, Toast.LENGTH_SHORT).show();
            et1.setText(str);
        }
    }

}
