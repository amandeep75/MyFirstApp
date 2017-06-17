package com.example.amandeep.myfirstapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.R.attr.data;

public class SDCardActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView1);
    }

    public void save(View v)
    {
        String n = et1.getText().toString();
        String ph = et2.getText().toString();

        try
        {
            File rootpath = Environment.getExternalStorageDirectory();

            File f = new File(rootpath, "ContactData.txt");

            if(f.exists() == false)
            {
                f.createNewFile();
                Toast.makeText(this, "New ContactData.txt file Created", Toast.LENGTH_SHORT).show();
            }

            String details = n + ":" +ph+ "\n";

            FileOutputStream fos = new FileOutputStream(f, true);

            fos.write(details.getBytes());

            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
        }

        catch (IOException e) {
            Toast.makeText(this, "Some Error "+e, Toast.LENGTH_SHORT).show();
        }
    }

    public void read(View v)
    {
        try
        {
            File rootpath = Environment.getExternalStorageDirectory();

            File f = new File(rootpath, "ContactData.txt");

            if(f.exists())
            {
                FileInputStream fis = new FileInputStream(f);

                String data = "";
                while(true)
                {
                    int a = fis.read();
                    if(a == -1)
                    {
                        break;
                    }

                    data = data + (char)a;
                }   //While Ends
                tv1.setText(""+data);
            }
            else
            {
                Toast.makeText(this, "f does not exists", Toast.LENGTH_SHORT).show();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Stack Trace Error", Toast.LENGTH_SHORT).show();
        }
    }

}
