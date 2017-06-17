package com.example.amandeep.myfirstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.amandeep.myfirstapp.R.id.textView;
import static com.example.amandeep.myfirstapp.R.id.textView1;

public class ServiceDemoActivity2 extends AppCompatActivity {

    TextView tv1;
    ServiceDemo2 serviceDemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo2);

        tv1 = (TextView) findViewById(R.id.textView1);
    }

    class MyServiceConnection implements ServiceConnection
    {

        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder)
        {
            ServiceDemo2.MyBinder myBinder=(ServiceDemo2.MyBinder)iBinder;
            serviceDemo2=myBinder.getRCPLService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {

        }
    }

    MyServiceConnection serviceConnection = null; //global variable

    public void b1Click(View view)
    {
        Intent intent = new Intent(this, ServiceDemo2.class);
        startService(intent);
        serviceConnection = new MyServiceConnection();
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        tv1.setText("New Service started");
    }

    public void b2Click(View view)
    {
        String msg = "Time Duration :"+ serviceDemo2.getTimeDuration()+"seconds";
        tv1.setText( msg );

    }

    public void b3Click(View view)
    {
        unbindService(serviceConnection);
        Intent intent = new Intent(this, ServiceDemo2.class);
        stopService(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
    }
}
