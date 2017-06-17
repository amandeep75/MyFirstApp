package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Orientation_Entry_Save extends AppCompatActivity implements SensorEventListener
{

    EditText et1, et2;
    SensorManager sm;
    TextView tv1, tv2;
    int CONSTANT = 350, CONSTANT2 = -450;

    boolean flag = false;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation__entry__save);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);

        SQLiteDatabase db = openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);
        cursor = db.rawQuery("Select * from Customer", null);

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(SensorEvent event)
    {
        int x =(int) (event.values[0] * 100);
        int y = (int) (event.values[1] * 100);
        int z = (int) (event.values[2] * 100);
        String  status = "x :"+x+"\ny :"+y+"\nz :"+z;
        tv2.setText(status);
        if (x > CONSTANT && !flag && cursor.moveToNext())
        {
                int roll = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                String details = roll + "\t" + name + "\t" + phone +"\n";
                tv1.append(details);
            flag = true;
        }
        else if(x < 120 && x > -120)
            flag = false;
        else if (x < CONSTANT2 && !flag && cursor.moveToPrevious())
        {
            int roll = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String details = roll + "\t" + name + "\t" + phone +"\n";
            tv1.append(details);
            flag = true;
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void stop(View view)
    {
        sm.unregisterListener(this);
        finish();
    }
}