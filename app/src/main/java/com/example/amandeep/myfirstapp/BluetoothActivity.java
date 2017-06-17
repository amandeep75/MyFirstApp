package com.example.amandeep.myfirstapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    ListView lv;
    BluetoothAdapter badapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        lv = (ListView) findViewById(R.id.listView1);

        badapter = BluetoothAdapter.getDefaultAdapter();

    }

    public void on(View view)
    {
        if(badapter.isEnabled() == false)
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); //Implicit Intent
            startActivityForResult(intent,0);
        }
        Toast.makeText(this, "Bluetooth On By Amendra Bahubali", Toast.LENGTH_SHORT).show();
    }

    public void off(View view)
    {
        badapter.disable();
        Toast.makeText(this, "Bluetooth Disabled By Katappa", Toast.LENGTH_SHORT).show();

    }

    public void show(View view)
    {
        Toast.makeText(this, "Discovery Started", Toast.LENGTH_SHORT).show();
        badapter.startDiscovery();
        Toast.makeText(this, "Discovery Completed", Toast.LENGTH_SHORT).show();
        Set<BluetoothDevice> deviceArr = badapter.getBondedDevices(); // In this <BluetoothDevices> , <StringObjects>, etc

        ArrayList arrayList = new ArrayList();
        for(BluetoothDevice device : deviceArr)
        {
            String deviceName = device.getName();
            arrayList.add(deviceName);
        }// End of for loop

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);
        
    }

    public void discovery(View view)
    {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(intent, 0);
        Toast.makeText(this, "Bluetooth is now Discoverable", Toast.LENGTH_SHORT).show();
    }
}
