package com.example.amandeep.myfirstapp;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {

    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        iv1 = (ImageView) findViewById(R.id.imageView2);
    }

    public void setWall(View view)
    {
        WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
        Drawable d = iv1.getDrawable();

        BitmapDrawable bmd = (BitmapDrawable) d;

        Bitmap b = bmd.getBitmap();

        try
        {
            wm.setBitmap(b);
            Toast.makeText(this, "Wallpaper changed", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Toast.makeText(this, "Unable to set  Wallpaper", Toast.LENGTH_SHORT).show();
        }
    }

}
