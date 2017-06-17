package com.example.amandeep.myfirstapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class NotificationActivity extends AppCompatActivity {

    EditText et1, et2;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
    }

    public void buttonClick(View v)
    {
        String title = et1.getText().toString();
        String message = et2.getText().toString();

        NotificationManager nmanager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);

       nBuilder.setSmallIcon(android.R.drawable.stat_notify_missed_call);
        nBuilder.setContentTitle(title);
        nBuilder.setContentText(message);

        nBuilder.setDefaults(Notification.DEFAULT_ALL);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(ResultActivity.class);
        Intent resultIntent = new Intent(this, ResultActivity.class);

        resultIntent.putExtra("TITLE", title);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent((int)System.currentTimeMillis(), PendingIntent.FLAG_UPDATE_CURRENT);

        nBuilder.setContentIntent(resultPendingIntent);

        Notification n = nBuilder.build();
        nmanager.notify(++count, n);


    }
}
