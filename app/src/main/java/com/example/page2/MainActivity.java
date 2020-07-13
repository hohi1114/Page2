package com.example.page2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Customer> list;
    private ListView listView;
    private EditText editSearch;
    private ListViewAdapter_mod adapter;
    private ArrayList<Customer> arraylist;

    ListView listview = null ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageButton = (Button) findViewById(R.id.button1);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity_01.class);
                startActivity(intent);
            }
        });

        editSearch = (EditText) findViewById(R.id.editTextFilter);
        listView = (ListView) findViewById(R.id.listview1);

        list = new ArrayList<Customer>();

        AssetManager assetManager = getAssets();
        try {
            InputStream is= assetManager.open("data1.json");
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader reader= new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            String line= reader.readLine();
            while (line!=null){
                buffer.append(line+"\n");
                line=reader.readLine();
            }

            String jsonData= buffer.toString();
            JSONArray jsonArray= new JSONArray(jsonData);
            ArrayList<Integer> myImageList = new ArrayList<>();
            myImageList.add(R.drawable.image1);
            myImageList.add(R.drawable.image2);
            myImageList.add(R.drawable.image3);
            myImageList.add(R.drawable.image4);
            myImageList.add(R.drawable.image5);
            myImageList.add(R.drawable.image6);
            myImageList.add(R.drawable.image7);
            myImageList.add(R.drawable.image8);
            myImageList.add(R.drawable.image9);




            String s="";

            for(int i=0; i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);

                String name= jo.getString("name");
                String msg= jo.getString("msg");
                String gender = jo.getString("gender");
                list.add(new Customer(name, msg, gender, ContextCompat.getDrawable(this,myImageList.get(i))));
                //items.add(new Customer(name, msg, gender));
                //JSONObject flag=jo.getJSONObject("flag");
                //int aa= flag.getInt("aa");
                //int bb= flag.getInt("bb");

                //s += name+" : "+msg+"==>"+aa+","+bb+"\n";
            }
            //tv.setText(s);

        } catch (IOException e) {e.printStackTrace();} catch (JSONException e) {e.printStackTrace();}
        arraylist = new ArrayList<Customer>();
        arraylist.addAll(list);

        adapter = new ListViewAdapter_mod(list, this);

        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), CustomersClicked.class);
                intent.putExtra("name", list.get(position).getName());
                intent.putExtra("gender", list.get(position).getGender());
                intent.putExtra("phone", list.get(position).getPhone());
                startActivity(intent);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list.remove(i);
                arraylist.remove(i);
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), i+1+"번째 전화번호가 삭제되었습니다", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        Button addButton = (Button)findViewById(R.id.addPhone);
        addButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
//                int count;
////                count = adapter.getCount();

                //adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.anonymous), "신성진", "010-9238-7609");
                list.add(new Customer("신성진", "010-9238-7609", "남자",ContextCompat.getDrawable(getApplicationContext(), R.drawable.anonymous)));
                arraylist.add(new Customer("신성진", "010-9238-7609", "남자",ContextCompat.getDrawable(getApplicationContext(), R.drawable.anonymous)));
                //addList.add("LIST"+Integer.toString(count+1));

                adapter.notifyDataSetChanged();
                //Toast.makeText(getApplicationContext(), "와우", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void search(String charText){
        list.clear();

        if(charText.length()==0){
            list.addAll(arraylist);
        }

        else
        {
            for(int i = 0;i<arraylist.size();i++){
                if (arraylist.get(i).getName().toLowerCase().contains(charText)||arraylist.get(i).getPhone().toLowerCase().contains(charText)){
                    list.add(arraylist.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged();
    }
}