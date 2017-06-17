package com.example.amandeep.myfirstapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {

    EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        //db.execSQL("drop tabe if exists Customer"

        db.execSQL("create table if not exists Customer(_id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar, phone varchar) ");

        db.close();

        Toast.makeText(this, "Table Created/ Exists", Toast.LENGTH_SHORT).show();

    }

    public void insertRecord(View view)
    {
        String name = et1.getText().toString();
        String phone = et2.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        //db.execSQL("drop tabe if exists Customer"

        String q = "insert into Customer(name,phone) values('"+name+"','"+phone+"')";
        db.execSQL(q);
        Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
    }
}
