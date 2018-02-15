package com.example.s528747.childrenmonitoringsystem;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    String c = "tarun";
    String str;
    String str1;
    //ArrayList<String> event = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ListView lv = (ListView) findViewById(R.id.listView);
        final TextView tv = (TextView) findViewById(R.id.textView3);

        String[] children = new String[] {"Aditya","Kamal"};
        final List<String> children_list = new ArrayList<String>(Arrays.asList(children));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.listview, R.id.textView6, children_list);

        lv.setAdapter(arrayAdapter);
        System.out.println(str1);

        tv.setText(str);
        Intent in = getIntent();
        str= in.getStringExtra("Name");
        str1= in.getStringExtra("addch");
        children_list.add(str1);
        arrayAdapter.notifyDataSetChanged();


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Add new Items to List
//                children_list.add(str1);
//                arrayAdapter.notifyDataSetChanged();
//            }
//        });



//        tv.setText(str);
//        System.out.println("Value is"+str1);
//        children_list.add(str1);
//        arrayAdapter.notifyDataSetChanged();


//        final ListView lv = (ListView) findViewById(R.id.listView);
//        final ArrayAdapter<String> server = new ArrayAdapter(this,R.layout.listview, R.id.textView6, event);
//        lv.setAdapter(server);



    }
    public void add(View v){
        Intent ne= new Intent(this,Addchild.class);

        startActivity(ne);
    }

    public void delete(View v){
        Intent ne= new Intent(this,Main2Activity.class);

        startActivity(ne);
    }

    public void settings(View v){
        Intent ne= new Intent(this,Settings.class);

        startActivity(ne);
    }

    public void click(View v)
    {
        Intent ne= new Intent(this,ChildSelect.class);
        ne.putExtra("username",str);
        ne.putExtra("child",c);
        startActivity(ne);

    }

//    public void addChildr(View v) {
//        Intent in = getIntent();
//        str= in.getStringExtra("Name");
//        str1= in.getStringExtra("addch");
//        children_list.add(str1);
//        arrayAdapter.notifyDataSetChanged();
//    }

}
