package com.example.page2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubActivity_02 extends AppCompatActivity {

    ListView listview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_02);



        final ArrayList<MusicItem> items = new ArrayList<>();

        //final ArrayList<ListViewItem> items = new ArrayList<>();
        final MusicItemAdapter adapter;

        // Adapter 생성
        adapter = new MusicItemAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("data.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }

            String jsonData = buffer.toString();
            JSONArray jsonArray = new JSONArray(jsonData);
            ArrayList<Integer> myImageList = new ArrayList<>();
            myImageList.add(R.drawable.blueming);
            myImageList.add(R.drawable.four);
            myImageList.add(R.drawable.return1);
            myImageList.add(R.drawable.snow);
            myImageList.add(R.drawable.cold);


            String s = "";

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);


                String name = jo.getString("info1");
                String msg = jo.getString("info2");
                adapter.addItem(ContextCompat.getDrawable(this, myImageList.get(i)), name, msg);
                items.add(new MusicItem((ContextCompat.getDrawable(this, myImageList.get(i))), name, msg));
                //JSONObject flag=jo.getJSONObject("flag");
                //int aa= flag.getInt("aa");
                //int bb= flag.getInt("bb");

                //s += name+" : "+msg+"==>"+aa+","+bb+"\n";
            }
            //tv.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        EditText editTextFilter = (EditText) findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                if (filterText.length() > 0) {
                    listview.setFilterText(filterText);
                } else {
                    listview.clearTextFilter();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), MusicItemClicked.class);
                intent.putExtra("info1", items.get(position).getInfo1());
                intent.putExtra("info2", items.get(position).getInfo2());

                Bitmap sendBitmap=null;
                System.out.println(position);




                switch(position){
                    case 0:
                        sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blueming);
                        break;
                    case 1:
                        sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
                        break;
                    case 2:
                        sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.return1);
                        break;
                    case 3:
                        sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.snow);
                        break;
                    case 4:
                        sendBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cold);
                    default:
                        break;
                }


                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 98, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image",byteArray);

                startActivity(intent);
            }
        });

        ///////////////////////전화번호 추가 기능/////////////////////////////
//        final ArrayList<String> addList = new ArrayList<String>();
//        final ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice);
/*
        final ListView LV = (ListView) findViewById(R.id.listview1);
        LV.setAdapter(adapter);

        Button addButton = (Button)findViewById(R.id.addPhone);
        addButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                int count;
                count = adapter.getCount();

                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.anonymous), "신성진", "010-9238-7609");
                items.add(new Customer("신성진", "010-9238-7609", "남자"));
                //addList.add("LIST"+Integer.toString(count+1));

                adapter.notifyDataSetChanged();
                //Toast.makeText(getApplicationContext(), "와우", Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    }
}









        /*
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
        */

