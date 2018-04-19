package com.example.s528747.childrenmonitoringsystem;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.persistence.local.UserIdStorageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends AppCompatActivity {
    String c = "tarun";
    String str;
    String str1;
    ChildAdapter ad;
    ArrayList<Children> listOfChildren = new ArrayList<>();
    public HashMap childDetails = new HashMap<>();
    private EditText childName, childPhone;

    //    private CalendarView dob;
    private String id, name, email;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.child:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.alert:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.profile:
                intent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent);
                return true;

            case R.id.settings:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.about_us:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

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
        setContentView(R.layout.activity_home_page);

        BottomNavigationView navigation = findViewById(R.id.navigation);
      //  navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        String userId = UserIdStorageFactory.instance().getStorage().get();
        String userID= Backendless.UserService.loggedInUser();
        String currentUserObjectId = UserIdStorageFactory.instance().getStorage().get();
        String where = "email='stp.aditya@gmail.com'";
        Log.d("xx",currentUserObjectId);        DataQueryBuilder query= DataQueryBuilder.create();
        query.setWhereClause(where);

        Backendless.Persistence.of(AddChild.class).find(query, new AsyncCallback<List<AddChild>>() {
            @Override
            public void handleResponse(List<AddChild> response) {
                for(int i=0;i<response.size();i++)
                {
                    listOfChildren.add(new Children(response.get(i).getChildName(),null,response.get(i).getChildID() ));
                    Log.d("for",listOfChildren.get(i).getChildName());
                    call();
                }
            }


            @Override
            public void handleFault(BackendlessFault fault) {
                System.out.println(fault);
            }
        });




        ad = new ChildAdapter(this, R.layout.listview, R.id.textView6, listOfChildren);
        final ListView list =  findViewById(R.id.listView);
        list.setAdapter(ad);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

                //ListEntry entry = (ListEntry) adapterView.getAdapter().getItem(i);
                Intent ne= new Intent(HomePage.this, ChildSelect.class);
                ne.putExtra("username","Parent");
                ne.putExtra("child","Child Name");
                startActivity(ne);

            }
        });

//
        TextView tv = findViewById(R.id.textView3);
        //tv.setText("Welcome, Aditya");

        Intent in = getIntent();
        name = in.getStringExtra("name");
        email = in.getStringExtra("email");
        id = in.getStringExtra("id");


        childDetails.put("childName", name);
        childDetails.put("emailID", email);
        childDetails.put("childID",id);
        System.out.println("Child Details anta " + childDetails);

        // listOfChildren.add(new Children(name, email, id));



    }


    public void call(){
        ad = new ChildAdapter(this, R.layout.listview, R.id.textView6, listOfChildren);
        final ListView list =  findViewById(R.id.listView);
        list.setAdapter(ad);

    }

    public void add(View v){
        Intent ne= new Intent(this,Add.class);
        startActivity(ne);
    }

    public void delete(View v){
        Intent ne= new Intent(this,HomePage.class);

        startActivity(ne);
    }

}
