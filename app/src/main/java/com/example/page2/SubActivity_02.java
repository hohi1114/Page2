package com.example.page2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SubActivity_02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_02);

        ImageButton btn_start_1 = (ImageButton)findViewById(R.id.imageButton1);
        ImageButton btn_end_1 = (ImageButton)findViewById(R.id.imageButton2);
        btn_start_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService.class));

            }
        });

        btn_end_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService.class));
            }
        });

        ImageButton btn_start_2 = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton btn_end_2 = (ImageButton)findViewById(R.id.imageButton4);
        btn_start_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService1.class));

            }
        });

        btn_end_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService1.class));
            }
        });


        ImageButton btn_start_3 = (ImageButton)findViewById(R.id.imageButton5);
        ImageButton btn_end_3 = (ImageButton)findViewById(R.id.imageButton6);
        btn_start_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService2.class));

            }
        });

        btn_end_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService2.class));
            }
        });


        ImageButton btn_start_4 = (ImageButton)findViewById(R.id.imageButton7);
        ImageButton btn_end_4 = (ImageButton)findViewById(R.id.imageButton8);
        btn_start_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService3.class));

            }
        });

        btn_end_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService3.class));
            }
        });


        Button imageButton = (Button) findViewById(R.id.prev_page2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity_01.class);
                startActivity(intent);
            }
        });
    }
}