package com.example.s528747.childrenmonitoringsystem;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AlertSettings extends AppCompatActivity {

    private EditText timeInterval;

//    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Intent intent;
//            switch (item.getItemId()) {
//                case R.id.navigation_child:
//                    intent = new Intent(getApplicationContext(), HomePage.class);
//                    startActivity(intent);
//                    break;
////                case R.id.navigation_alert_settings:
////                    intent = new Intent(getApplicationContext(), AlertSettings.class);
////                    startActivity(intent);
////                    break;
//                case R.id.navigation_user_profile:
//                    intent = new Intent(getApplicationContext(), UserProfile.class);
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
        setContentView(R.layout.activity_alert_settings);
//        BottomNavigationView navigation = findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void sendNotification(View view) {

        //Get an instance of NotificationManager//

        timeInterval =  findViewById(R.id.time_interval);

        String temp = timeInterval.getText().toString();
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentTitle("Alert!")
                        .setContentText("You have set an alert for restricted areas for every " + temp + " mins");

        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // When you issue multiple notifications about the same type of event,
        // it’s best practice for your app to try to update an existing notification
        // with this new information, rather than immediately creating a new notification.
        // If you want to update this notification at a later date, you need to assign it an ID.
        // You can then use this ID whenever you issue a subsequent notification.
        // If the previous notification is still visible, the system will update this existing notification,
        // rather than create a new one. In this example, the notification’s ID is 001//

        try {
            mNotificationManager.notify(001, mBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent ne = new Intent(this, HomePage.class);
        startActivity(ne);
    }
}