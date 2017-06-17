package com.example.amandeep.myfirstapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferenceActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        et1 = (EditText) findViewById(R.id.editText1);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sp = getSharedPreferences("Demofile", 0);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("Status", et1.getText().toString());
        editor.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        super.onStart();

        SharedPreferences sp = getSharedPreferences("Demofile", 0);

        String msg = sp.getString("Status", "Enter some text");
        et1.setText(msg);
    }
}
