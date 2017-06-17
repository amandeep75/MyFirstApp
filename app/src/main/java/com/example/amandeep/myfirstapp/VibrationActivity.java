package com.example.amandeep.myfirstapp;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VibrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        et1 = (EditText)findViewById(R.id.editText1);
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int duration = Integer.parseInt(et1.getText().toString());
        Vibrator vi = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vi.vibrate(duration);
    }
    //end of VibrationActivity
}
