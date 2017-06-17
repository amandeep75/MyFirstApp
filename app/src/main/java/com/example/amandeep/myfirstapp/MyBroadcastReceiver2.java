package com.example.amandeep.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver2 extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if( bundle != null)
        {
            String state = bundle.getString("state");
            if(state.equals("RINGING"))
            {
                Toast.makeText(context, "Please Pick up the Phone", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
