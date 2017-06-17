package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {

    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE );

    }//End of OnCreate

    public void onWifi(View view)
    {
        wifiManager.setWifiEnabled(true);
        Toast.makeText(this, "Wifi on By BhallalDev", Toast.LENGTH_SHORT).show();
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if(wifiInfo.getBSSID() != null) // BSSID: Basic Service Set Identifier
        {
            String name = wifiInfo.getSSID();
            int signalFrequency = wifiInfo.getRssi(); // RSSI: Received Signal Strength Identifier

            int status = wifiManager.calculateSignalLevel(signalFrequency, 10);
            Toast.makeText(this, "Wi-fi Name : "+name, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Wifi Strength(10):    "+status, Toast.LENGTH_SHORT).show();
        }// End of if block
    }

    public void offWifi(View view)
    {

    }


}
