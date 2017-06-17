package com.example.amandeep.myfirstapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Fire Missile");
        builder.setMessage("Are you sure to fire Missile");

        builder.setPositiveButton("Fire", new DialogInterface.OnClickListener()
        {
           @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this, "Missile Launched Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(AlertDialogActivity.this, "You saved the shit from happening", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
