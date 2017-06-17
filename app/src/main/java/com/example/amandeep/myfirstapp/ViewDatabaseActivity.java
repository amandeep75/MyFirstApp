package com.example.amandeep.myfirstapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDatabaseActivity extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);

        tv1 = (TextView) findViewById(R.id.textView1);
        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        Cursor cursor = db.rawQuery("Select * from Customer", null);

        tv1.setText("All Customer Details\n__________________________________________________\n");

        while(cursor.moveToNext())
        {
            int roll = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String details = roll + "\t" + name + "\t" + phone +"\n";
            tv1.append(details);
        }//end while
    }
}
