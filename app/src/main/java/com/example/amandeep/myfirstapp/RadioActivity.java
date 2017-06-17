package com.example.amandeep.myfirstapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup rg1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        tv1 = (TextView) findViewById(R.id.textView1);


        rg1.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
    {
        switch(checkedId)
        {
            case R.id.radioButton1:
                tv1.setText("You have selected: Call Of Duty");
                break;
            case R.id.radioButton2:
                tv1.setText("You have selected: CastleVania");
                break;
            case R.id.radioButton3:
                tv1.setText("You have selected: BlackOp");
                break;
        }// End of Switch
    }

    public void clearSelection(View v)
    {
        rg1.clearCheck();
        tv1.setText("You have Selected: NONE");
    }

}
