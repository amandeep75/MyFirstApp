package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener
{

    ImageView iv1;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        iv1 = (ImageView) findViewById(R.id.imageView1);
        sm= (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        int rollNoOfSensor = Sensor.TYPE_PROXIMITY;

        Sensor s = sm.getDefaultSensor(rollNoOfSensor);
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();

        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        float f = event.values[0];
        Toast.makeText(this, "Sensor Value is: "+f, Toast.LENGTH_SHORT).show();

        if(f == 0.0)
        {
            iv1.setImageResource(R.drawable.m_7);
        }

        else
        {
            iv1.setImageResource(R.drawable.my);
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
