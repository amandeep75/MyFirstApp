package com.example.amandeep.myfirstapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MultiOptionAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_option_alert);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Fire Missile");
        final String color[] = {"Pink", "Red", "Green", "Orange"};

        builder.setItems(color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String str = color[which];
                Toast.makeText(MultiOptionAlertActivity.this, "You chose:   "+str, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
