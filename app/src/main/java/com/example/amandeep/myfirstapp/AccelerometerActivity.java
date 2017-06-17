package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener
{

    ConstraintLayout r1;
    SensorManager sm;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        tv1 = (TextView) findViewById(R.id.textView1);
        r1 = (ConstraintLayout) findViewById(R.id.layout1);

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int x =(int) (event.values[0] * 100);
        int y = (int) (event.values[1] * 100);
        int z = (int) (event.values[2] * 100);

        String status = "X="+x+" Y="+y+" Z="+z;
        tv1.setText(status);
        r1.setBackgroundColor(Color.rgb(x, y, z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
