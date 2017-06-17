package com.example.amandeep.myfirstapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseDeleteActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_delete);
        et1 = (EditText) findViewById(R.id.editText1);

    }

    public void delete(View view)
    {
        int cid = Integer.parseInt( et1.getText().toString() );
        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        String query = "delete from Customer where _id = "+cid;
        db.execSQL(query);
        Toast.makeText(this, "Record "+cid+" deleted", Toast.LENGTH_SHORT).show();
        Log.d("RCPLMESSAGE", "******************************1"+query);      //DEbug use filter debug (search RCPL)
        db.close();

    } //end of delete
}
