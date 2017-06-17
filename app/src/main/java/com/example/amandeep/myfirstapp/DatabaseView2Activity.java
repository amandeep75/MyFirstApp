package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseView2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view2);

        listView1 = (ListView) findViewById(R.id.listView1);

        // Cursor Adapter that takes value from database

        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        Cursor cursor = db.rawQuery("select * from Customer", null);

        MyCurserAdapter myCurserAdapter = new MyCurserAdapter(this, cursor,0);

        listView1.setOnItemClickListener(this);
        listView1.setAdapter(myCurserAdapter);

     //   listView1.setAdapter(myCurserAdapter);
    //    listView1.setOnItemClickListener(this);
    }// OnCreate

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Cursor cursor = (Cursor)parent.getItemAtPosition(position);
        int cid = cursor.getInt(cursor.getColumnIndex("_id"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String phone = cursor.getString(cursor.getColumnIndex("phone"));

        Toast.makeText(this, "Clicked   :" + cid+"-"+name+"("+phone +")", Toast.LENGTH_SHORT).show();
    }

    class MyCurserAdapter extends CursorAdapter
    {

        public MyCurserAdapter(Context context, Cursor c, int flags)
        {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = inflater.inflate(R.layout.row, parent, false); //XML file to design graphic
            // false says no sublist
            return v;
        }
//          v is passed to bindView(View view

        @Override
        public void bindView(View view, Context context, Cursor cursor)   //Cursor is already set
        {
            TextView tvCid = (TextView) view.findViewById(R.id.textView1);
            TextView tvName = (TextView) view.findViewById(R.id.textView2);
            TextView tvPhone = (TextView) view.findViewById(R.id.textView3);

            int cid = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));

            tvCid.setText( "Id:"+cid );
            tvName.setText("Name:"+name);
            tvPhone.setText("Phone:"+phone);

        }
    }// End of MyCurserAdapter class

}
