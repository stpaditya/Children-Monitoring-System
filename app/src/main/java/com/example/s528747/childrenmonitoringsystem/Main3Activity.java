package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void back(View V){
        EditText ed=(EditText) findViewById(R.id.username);
        EditText ed1=(EditText) findViewById(R.id.password);
        EditText ed3=(EditText) findViewById(R.id.repassword);
        EditText ed4=(EditText) findViewById(R.id.phonenumber);
        EditText ed5=(EditText) findViewById(R.id.Emailid);

        String username= ed.getText().toString();
        String password= ed1.getText().toString();
        String repassword= ed3.getText().toString();
        String phonenumber= ed4.getText().toString();
        String email= ed5.getText().toString();




        if(username.length()>0&&password.length()>=8){
            int x= password.compareTo(repassword);

            if(x!=0)
                Toast.makeText(getApplicationContext(),"password does not match"+repassword,Toast.LENGTH_SHORT).show();

            String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                    "\\@" +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                    "(" +

                    "\\." +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                    ")+";




            Matcher matcher= Pattern.compile(validemail).matcher(email);


            if (matcher.matches()){
                Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();

                Intent in = new Intent(this,MainActivity.class);
                startActivity(in);
            }
            else {
                Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_SHORT).show();
            }


        }

    }



}
