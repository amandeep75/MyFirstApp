package com.example.amandeep.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InvoiceActivity extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);

        Intent box = getIntent();

        Bundle bundle = box.getExtras();

        tv1.append("PRICE");
        tv1.append("QUANTITY");
    }

        public void buttonClicked(View v)
    {
        String answer = "Unanswered" ;
        if(v.getId() == R.id.button1)
        {
            answer = "Deal Confirmed Successfully" ;
        }

        else
        {
            answer = "Deal Rejected" ;
        }

        Intent intent = new Intent ();

        intent.putExtra("MSG", answer);
        setResult(0, intent);
        finish();
    }

}
