package com.example.amandeep.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReciever1 extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String str = intent.getAction(); //even OS shares data via intent
        // Both CONNECTED and DISCONNECTED signal will come in str

        if(str.equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
            Toast.makeText(context, "Charging Started by Amandeep", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(context, "Charging Unplugged by Amandeep ", Toast.LENGTH_SHORT).show();
        }
    }
}
