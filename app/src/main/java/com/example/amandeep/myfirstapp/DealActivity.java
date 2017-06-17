package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DealActivity extends AppCompatActivity
{
    EditText et1, et2;
    final int REQUEST_CODE = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);

        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
    }

    public void buttonClick(View v)
    {
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();

        Intent box = new Intent(DealActivity.this, InvoiceActivity.class);

        box.putExtra("U", str1);
        box.putExtra("P", str2);

        startActivityForResult(box, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String str = data.getStringExtra("MSG");
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
    }
}
