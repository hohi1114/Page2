package com.example.page2;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class MusicItemClicked extends AppCompatActivity {   // if not working, change to extends Acitivity implements View.OnClickListener

    public static MediaPlayer mediaPlayer;
    SeekBar mSeekBar;

    ImageView Bigimage;
    TextView name;
    TextView desc;
    TextView curTime;
    TextView totTime;


    ImageButton musicOn;
    ImageButton musicOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2_clicked);
        mSeekBar=(SeekBar)findViewById(R.id.mSeekBar);
        Bigimage= (ImageView) findViewById(R.id.image1);
        name= (TextView) findViewById(R.id.text1);
        desc=(TextView) findViewById(R.id.text2);
        curTime= findViewById(R.id.curTime);
        totTime=findViewById(R.id.totalTime);
        musicOn = (ImageButton) findViewById(R.id.imageButton1);
        musicOff = (ImageButton) findViewById(R.id.imageButton2);
        Intent intent = getIntent();

        mediaPlayer = new MediaPlayer();

        //image.setImageURI();
        String music_name = intent.getStringExtra("info1");
        name.setText(music_name);
        desc.setText(intent.getStringExtra("info2"));


        byte[] arr = intent.getByteArrayExtra("image");
        Bitmap image = BitmapFactory.decodeByteArray(arr, 0, arr.length);

        Bigimage.setImageBitmap(image);




        //"Blueming"
        //"사계(Four Seasons)"
        // "return"
        //"눈"
        if (music_name.compareTo("Blueming") == 0) {
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startService(new Intent(getApplicationContext(), MusicService.class));
                    initPlayer();



                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService.class));
                }
            });

        } else if (music_name.compareTo("사계(Four Seasons)") == 0) {
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService1.class));
                    initPlayer();

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService1.class));
                }
            });


        } else if (music_name.compareTo("Return (FEAT.THAMA)") == 0) {
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService2.class));
                    initPlayer();

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService2.class));
                }
            });
        } else if( music_name.compareTo("눈(SNOW) (feat.이문세)")==0){
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService3.class));
                    initPlayer();

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService3.class));
                }
            });

        }
        else{
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService4.class));
                    initPlayer();

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService4.class));
                }
            });

        };


    }
    private void initPlayer(){
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                    mSeekBar.setProgress(progress);
                }
            }
        });

     new Thread(new Runnable() {
        @Override
        public void run() {
            while (mediaPlayer != null) {
                try {
//                        Log.i("Thread ", "Thread Called");
                    // create new message to send to handler
                    if (mediaPlayer.isPlaying()) {
                        mSeekBar.setMax(mediaPlayer.getDuration());
                        Message msg = new Message();
                        msg.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}
    @SuppressLint("HandlerLeak")
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg){
            String totalTime=createTimerLabel(mediaPlayer.getDuration());
            totTime.setText(totalTime);
            int current_pos= msg.what;
            mSeekBar.setProgress(current_pos);
            String cTime=createTimerLabel(current_pos);
            curTime.setText(cTime);
        }
    };
    public String createTimerLabel(int duration){
        String timerLabel="";
        int min=duration / 1000 / 60;
        int sec= duration /1000 % 60;
        timerLabel+=min+ ":";

        if(sec<10){
            timerLabel +="0";
        }
        timerLabel += sec;
        return timerLabel;
    }
}











        /*
        musicOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService.class));

            }
        });

        musicOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService.class));
            }
        });
*/
