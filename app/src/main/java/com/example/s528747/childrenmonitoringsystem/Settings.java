package com.example.s528747.childrenmonitoringsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Settings extends AppCompatActivity {

//    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Intent intent;
//            switch (item.getItemId()) {
//                case R.id.navigation_user_profile:
//                    intent = new Intent(getApplicationContext(), UserProfile.class);
//                    startActivity(intent);
//                    break;
//                case R.id.navigation_child:
//                    intent = new Intent(getApplicationContext(), HomePage.class);
//                    startActivity(intent);
//                    break;
//                case R.id.navigation_settings:
//                    intent = new Intent(getApplicationContext(), Settings.class);
//                    startActivity(intent);
//                    break;
////                case R.id.navigation_about_us:
////                    intent = new Intent(getApplicationContext(), AboutUs.class);
////                    startActivity(intent);
////                    break;
//            }
//            return true;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView navigation = findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void logout(View v){
        Intent ne= new Intent(this,LoginPage.class);
        startActivity(ne);
    }
}
