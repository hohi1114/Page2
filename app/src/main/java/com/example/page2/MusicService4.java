package com.example.page2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService4 extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        MusicItemClicked.mediaPlayer=MediaPlayer.create(this,R.raw.cold);
        MusicItemClicked.mediaPlayer.setLooping(false);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        MusicItemClicked.mediaPlayer.stop();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        MusicItemClicked.mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }


}
