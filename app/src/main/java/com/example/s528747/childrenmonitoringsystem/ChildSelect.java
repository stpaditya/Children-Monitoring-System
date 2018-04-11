package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChildSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childselect);
        TextView ed= findViewById(R.id.user);
        TextView ed1= findViewById(R.id.child);
        Intent in=getIntent();
        String user=in.getStringExtra("username");
        String child=in.getStringExtra("child");
        ed.setText(user);
        ed1.setText(child);
    }

    public void childLocation(View v){
        Intent ne= new Intent(this,MapsActivity.class);
        startActivity(ne);
    }

    public void seeHistory(View v){
        Intent ne= new Intent(this,SeeHistory.class);
        startActivity(ne);
    }
}
