package com.example.amandeep.myfirstapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import static android.content.Context.MODE_APPEND;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        Context c = getContext();
        SQLiteDatabase db = c.openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);

        int status = db.delete("Customer", selection,selectionArgs);
        return status;


    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        Context c = getContext();
        SQLiteDatabase db = c.openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);
        db.insert("Customer", null, values);    //Null Column Hack it passes null if user keeps record empty
        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder)
    {
        Context c = getContext();   // SQLite is availabale in Activty not here
        SQLiteDatabase db = c.openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);
        String q = "select * fromm Customer";
        Cursor cur = db.rawQuery(q, null);
        return cur;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs)
    {
        Context c = getContext();
        SQLiteDatabase db = c.openOrCreateDatabase("RCPL_DB", MODE_APPEND, null);
        int status = db.update("Customer", values, selection, null);
        return status;
    }
}
