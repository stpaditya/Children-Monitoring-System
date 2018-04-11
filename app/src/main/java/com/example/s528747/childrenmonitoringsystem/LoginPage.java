package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginPage extends AppCompatActivity {
    public static final String APPLICATION_ID = "3B0E7F39-9A46-5A3F-FF70-34D833BBAA00";
    public static final String API_KEY = "126D077E-DD6D-69B6-FF6F-61EF37FF5300";
    public static final String SERVER_URL = "https://api.backendless.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        Backendless.initApp(this,APPLICATION_ID,API_KEY);

    }

    public void login(View v){

        EditText et= findViewById(R.id.editText);
        EditText et1= findViewById(R.id.editText2);
        String str=et.getText().toString();
        String str1=et1.getText().toString();



        if(str.length()<=0||str1.length()<=0){
            Toast.makeText(getApplicationContext(),"Enter login credentials ", Toast.LENGTH_SHORT).show();
        }
        else{
            System.out.println(str+" "+str1);
            final   Intent in=new Intent(this,HomePage.class);
            in.putExtra("Name",str);
            Backendless.UserService.login(str, str1, new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser response) {

                    System.out.println(response);

                    startActivity(in);

                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    System.out.println(fault);

                }
            });

        }
    }
    public void forgotpassword(View v){
        EditText et= findViewById(R.id.editText);
        String str=et.getText().toString();
        if(str.length()<=0)
        {
            Toast.makeText(getApplicationContext(),"Enter Email ", Toast.LENGTH_SHORT).show();

        }

        else {

            Backendless.UserService.restorePassword(str, new AsyncCallback<Void>() {
                @Override
                public void handleResponse(Void response) {
                    System.out.println("sent "+response);
                    Toast.makeText(getApplicationContext(),"Email has been sent ", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    System.out.println("fault "+fault);
                }
            });

        }

    }
    public void signup(View V){

        Intent in = new Intent(this,RegistrationPage.class);
        startActivity(in);
    }


}
