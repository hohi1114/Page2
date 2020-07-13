package com.example.page2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CustomersClicked extends AppCompatActivity implements View.OnClickListener {
    private TextView mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_clicked);

        Intent intent = getIntent();

        TextView name = (TextView) findViewById(R.id.tv_name);
        TextView gender = (TextView) findViewById(R.id.tv_gender);
        TextView phone = (TextView) findViewById(R.id.tv_phone);
        ImageView image = (ImageView) findViewById(R.id.image);

        Button mDialogCall = (Button) findViewById(R.id.btnDial);
        Button mCall = (Button) findViewById(R.id.btnCall);

        String person_name = intent.getStringExtra("name");
        name.setText(person_name);

        gender.setText(intent.getStringExtra("gender"));
        phone.setText(intent.getStringExtra("phone"));
        // image.setImageDrawable();
         if (person_name.compareTo("신성진") == 0) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image1));

        } else if (person_name.compareTo("조호연") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image2));
        } else if (person_name.compareTo("오수지") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image3));

        } else if (person_name.compareTo("이혜민") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image4));

        } else if (person_name.compareTo("이건주") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image5));

        } else if (person_name.compareTo("김하운") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image6));

        } else if (person_name.compareTo("서유림") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image7));
        } else if (person_name.compareTo("정서현") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image8));
        } else if (person_name.compareTo("이현호") == 0) {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image9));

        } else {
             image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.anonymous));

        }

    mNum = phone;
        mDialogCall.setOnClickListener(this);
        mCall.setOnClickListener(this);
    }

    public void onClick(View v){

        String tel = "tel:" + mNum.getText().toString();
        switch(v.getId()){
            case R.id.btnCall:
                startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel)));
            case R.id.btnDial:
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
        }
    }
}