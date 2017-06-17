package com.example.amandeep.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity
{
    String arr[] = {"CalculatorActivity", "CameraActivity", "DealActivity", "FullCalc", "IntentDemoActivity", "VibrationActivity","LoginActivity", "SpinnerActivity","RadioActivity", "MainActivity", "ImageResourceActivity", "AlertDialogActivity", "MultiOptionAlertActivity", "ToggleSwitchActivity", "DateActivity", "OptionMenuActivity", "SharedPreferenceActivity", "ProximitySensorActivity",
            "AccelerometerActivity", "WallpaperActivity", "NotificationActivity", "SDCardActivity",
            "MusicActivity", "ServiceDemoActivity","ServiceDemoActivity2",
            "VideoActivity","MusicActivity", "SeekBarActivity","GPSDemoActivity", "BluetoothActivity", "WifiActivity"
    ,"DatabaseActivity", "ViewDatabaseActivity", "DatabaseDeleteActivity", "DatabaseUpdateActivity",
            "DatabaseView2Activity", "Orientation_Entry_Save", "MyBroadcastReciever1", "MyBroadcastReceiver2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter adapter = new ArrayAdapter(MenuActivity.this, android.R.layout.simple_list_item_1, arr);

        setListAdapter(adapter);

        registerForContextMenu(getListView());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        String str = arr[position];
        String str1 = "com.example.amandeep.myfirstapp"+"."+str;

        try {
            Class c = Class.forName(str1);               //It loads class in c
            Intent intent = new Intent(this, c);

            startActivity(intent);
        }

        catch(ClassNotFoundException e)
        {
            //Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Add");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        Toast.makeText(this, arr[(int)info.id], Toast.LENGTH_SHORT).show();
        if( item.getTitle().equals("Add"))
        {
            Toast.makeText(this, "Add Invoked", Toast.LENGTH_SHORT).show();
        }

        else if(item.getTitle().equals("Edit"))
        {
            Toast.makeText(this, "Edit Invoked", Toast.LENGTH_SHORT).show();
        }

        else if(item.getTitle().equals("Delete"))
        {
            Toast.makeText(this, "Delete Invoked", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
