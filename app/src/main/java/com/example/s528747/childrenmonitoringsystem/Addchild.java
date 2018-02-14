package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addchild extends AppCompatActivity {
    private Button x;
    private EditText childname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);


        childname = (EditText) findViewById(R.id.child_name);

        x = (Button) findViewById(R.id.button4);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = childname.getText().toString();
                System.out.println("child name"+temp);
                Intent y= new Intent(getApplicationContext(),Main2Activity.class);
                y.putExtra("add",temp);
                startActivity(y);
            }
        });

    }


}
