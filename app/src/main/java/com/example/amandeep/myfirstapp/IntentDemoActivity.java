package com.example.amandeep.myfirstapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class IntentDemoActivity extends ListActivity
{
    String ScrArray[] = {"PHONE CALL", "SMS", "WEB", "WEB SEARCH", "PHONE BOOK", "MAP SEARCH", "EXIT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  //      setContentView(R.layout.activity_intent_demo);
        ArrayAdapter adapter = new ArrayAdapter(IntentDemoActivity.this, android.R.layout.simple_list_item_1, ScrArray);

        setListAdapter(adapter);
    } //end of onCreate()

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //String str = ScrArray[position];

        //Toast.makeText(this, str + " Clicked", Toast.LENGTH_SHORT).show();
        if (ScrArray[position].equals("EXIT"))
        {
            finish();
        }
        else if (ScrArray[position].equals("PHONE CALL"))
        {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 8155820610"));
            startActivity(i);
        }

        else if(ScrArray[position].equals("SMS"))
        {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms: 8155820610"));

            i.putExtra("sms_body", "Hello This is my first sms from app");
            startActivity(i);
        }

        else if(ScrArray[position].equals("WEB"))
        {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(i);
        }

        else if(ScrArray[position].equals("WEB SEARCH"))
        {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY, "Indian Railway");
            startActivity(i);
        }

        else if(ScrArray[position].equals("MAP SEARCH"))
        {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0, 0?q = Lucknow"));
            startActivity(i);
        }

        else if(ScrArray[position].equals("PHONE BOOK"))
        {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
            startActivity(i);
        }
    }
}
