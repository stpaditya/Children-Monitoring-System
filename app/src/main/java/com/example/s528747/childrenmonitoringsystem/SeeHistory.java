package com.example.s528747.childrenmonitoringsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeeHistory extends Activity
{
    // Array of strings...
    ListView simpleList;
    String countryList[] = {"04-20-2018", "04-19-2018", "04-18-2018", "04-14-2018", "03-28-2018"};

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      setContentView(R.layout.activity_see_history);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, countryList);
        simpleList.setAdapter(arrayAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                Intent myIntent = new Intent(SeeHistory.this, MapsActivity.class);
                SeeHistory.this.startActivity(myIntent);
            }
        });
    }


}