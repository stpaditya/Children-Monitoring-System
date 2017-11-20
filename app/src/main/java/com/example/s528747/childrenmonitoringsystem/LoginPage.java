package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

    }

    public void login(View v){

        EditText et=(EditText) findViewById(R.id.editText);
        EditText et1=(EditText)  findViewById(R.id.editText2);
        String str=et.getText().toString();
        String str1=et1.getText().toString();



        if(str.length()<=0||str1.length()<=0){
            Toast.makeText(getApplicationContext(),"Enter login credentials ", Toast.LENGTH_SHORT).show();
        }
        else{ Intent in=new Intent(this,Main2Activity.class);
            in.putExtra("Name",str);
            startActivity(in);}
    }

    public void signup(View V){

        Intent in = new Intent(this,Main3Activity.class);
        startActivity(in);
    }


}
