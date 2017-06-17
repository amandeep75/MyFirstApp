package com.example.amandeep.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener
{
    MediaPlayer mplayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mplayer = MediaPlayer.create(this, R.raw.mysong);
        mplayer.setOnCompletionListener(this);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mplayer.isPlaying() == false)
        {
            mplayer.start();
        }

        Toast.makeText(this, "Music is Playing", Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mplayer.isPlaying() == true)
        {
            mplayer.stop();
        }
        Toast.makeText(this, "Service Stops", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp)
    {
        stopSelf();
    }
}
