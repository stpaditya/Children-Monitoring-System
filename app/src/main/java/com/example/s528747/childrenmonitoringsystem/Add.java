package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.HashMap;
import java.util.Map;

public class Add extends AppCompatActivity {
    private EditText childname;
    //private EditText childEmail;
    private EditText childID;
    HashMap AddChild = new HashMap();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void add(View v)
    {
        childname =  findViewById(R.id.child_name);

        childID =  findViewById(R.id.child_id);

        String temp = childname.getText().toString();
        //String temp2 = childEmail.getText().toString();
        String temp3 = childID.getText().toString();
        System.out.println();
        AddChild.put("email","stp.aditya@gmail.com");
        AddChild.put("childID",temp3);
        AddChild.put("childName",temp);
        Backendless.Persistence.of( "AddChild" ).save( AddChild, new AsyncCallback<Map>() {
            public void handleResponse( Map response )
            {
                Log.d("success",response.toString());
                // new Contact instance has been saved
            }

            public void handleFault( BackendlessFault fault )
            {
                System.out.println(fault);
                Log.d("Failure",fault.toString());
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });

        Intent one = new Intent(this, HomePage.class);
        startActivity(one);


    }

    public void addChild_cancel(View v){
        Intent ne= new Intent(this,HomePage.class);
        startActivity(ne);
    }

}
