package com.example.s528747.childrenmonitoringsystem;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Add extends AppCompatActivity {
    private EditText childname;
    //private EditText childEmail;
    private EditText childID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void add(View v)
    {
        childname =  findViewById(R.id.child_name);

        childID =  findViewById(R.id.child_id);

        String temp = childname.getText().toString();
        //String temp2 = childEmail.getText().toString();
        String temp3 = childID.getText().toString();


        AddChild ad= new AddChild();
        ad.setChildID(temp3);
        ad.setChildName(temp);
        Log.d("stringname",ad.getChildName());
        Backendless.Persistence.save(ad, new AsyncCallback<Object>() {

            @Override
            public void handleResponse(Object response) {

System.out.print(response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                System.out.print(fault);
            }


        });

    }

}
