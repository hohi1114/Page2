package com.example.page2;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MusicItemClicked extends AppCompatActivity {   // if not working, change to extends Acitivity implements View.OnClickListener


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2_clicked);

        Intent intent = getIntent();

        final SeekBar mSeekBar=findViewById(R.id.seekBar1);

        ImageView Bigimage = (ImageView) findViewById(R.id.image1);
        TextView name = (TextView) findViewById(R.id.text1);
        TextView desc = (TextView) findViewById(R.id.text2);


        ImageButton musicOn = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton musicOff = (ImageButton) findViewById(R.id.imageButton2);

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

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService1.class));
                }
            });


        } else if (music_name.compareTo("return") == 0) {
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService2.class));

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService2.class));
                }
            });
        } else {
            musicOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startService(new Intent(getApplicationContext(), MusicService3.class));

                }
            });

            musicOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getApplicationContext(), MusicService3.class));
                }
            });


        }


    }
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
