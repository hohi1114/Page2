package com.example.page2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class SubActivity_01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_01);
        Button imageButton = (Button) findViewById(R.id.prev_page);
        Button imageButton1 = (Button) findViewById(R.id.next_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Launching the RecyclerViewFragement
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, RecyclerViewFragment.newInstance())
                .commit();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity_02.class);
                startActivity(intent);
            }
        });
    }
}