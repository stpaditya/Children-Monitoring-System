package com.example.s528747.childrenmonitoringsystem;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    String c = "tarun";
    String str;
    String str1;
    ArrayList<Children> listOfChildren = new ArrayList<>();
    public HashMap childDetails = new HashMap<>();
    private EditText childName, childPhone;
    //    private CalendarView dob;
    private String date, name, phoneNumber;
    Intent in = getIntent();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Children> ad = new ChildAdapter(this, R.layout.listview, R.id.textView6, listOfChildren);
        list.setAdapter(ad);



//        dob = (CalendarView)findViewById(R.id.calendarView);
//        dob.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month,
//                                            int dayOfMonth) {
//                // TODO Auto-generated method stub
//                date = dayOfMonth +"/" + (month+1) + "/" + year;
//
//            }
//        });

//        ListView lv = (ListView) findViewById(R.id.listView);
//        TextView tv = (TextView) findViewById(R.id.textView3);
//
//        ArrayAdapter<Children> ad = new ChildAdapter(this, R.layout.listview, R.id.textView6, listOfChildren);
//        lv.setAdapter(ad);
//
//        String[] children = new String[] {};
//        final List<String> children_list = new ArrayList<String>(Arrays.asList(children));
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview, R.id.textView6, children_list);


//        lv.setAdapter(arrayAdapter);
//        System.out.println(str1);
//
//        Intent in = getIntent();
//        date = in.getStringExtra("date");

//        Backendless.Persistence.of( "NewChild" ).find( new AsyncCallback<List<Map>>(){
//            @Override
//            public void handleResponse( List<Map> foundContacts )
//            {
//                // every loaded object from the "Contact" table is now an individual java.util.Map
//            }
//            @Override
//            public void handleFault( BackendlessFault fault )
//            {
//                // an error has occurred, the error code can be retrieved with fault.getCode()
//            }
//        });

//        ListView list = (ListView) findViewById(R.id.listView);
//        list.setOnItemClickListener(new ListView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
//
////                listOfChildren.remove(i);
//                ListView list = (ListView) findViewById(R.id.listView);
//                ArrayAdapter<Children> ad = new ChildAdapter(getApplicationContext(), R.layout.children, R.id.childrentv, listOfChildren);
//                list.setAdapter(ad);
//                ad.notifyDataSetChanged();
//                Toast.makeText(getApplicationContext(),"Deleted the row!",Toast.LENGTH_SHORT).show();
//            }
//        });

//        childName = (EditText) findViewById(R.id.child_name);
//        childPhone = (EditText) findViewById(R.id.child_number);
//        Intent in = getIntent();
//        date = in.getStringExtra("date");
//        name = in.getStringExtra("name");
//        phoneNumber = in.getStringExtra("phoneNumber");
//
//
//        childDetails.put("name", name);
//        childDetails.put("phoneNumber", phoneNumber);
//        childDetails.put("dob",date);
//        System.out.println("Child Details anta " + childDetails);
//        Backendless.Persistence.of( "NewChild" ).save( childDetails, new AsyncCallback<Map>() {
//            public void handleResponse( Map response )
//            {
//                System.out.println(response);
//                // new Contact instance has been saved
//
//            }
//
//            public void handleFault( BackendlessFault fault )
//            {
//                System.out.println(fault);
//
//                // an error has occurred, the error code can be retrieved with fault.getCode()
//            }
//        });
//        listOfChildren.add(new Children(name, phoneNumber, date));
//        System.out.println("sadsafdsafsd list of children " + listOfChildren.toString());
//
//        ArrayAdapter<Children> ad = new ChildAdapter(this, R.layout.children, R.id.childrentv, listOfChildren);
//        list.setAdapter(ad);
//        ad.notifyDataSetChanged();

//        ListView list = (ListView) findViewById(R.id.listView);
//        ArrayAdapter<Children> ad = new ChildAdapter(this, R.layout.children, R.id.childrentv, listOfChildren);
//        list.setAdapter(ad);
//        ad.notifyDataSetChanged();


//
//
//        if (str1 != null) {
//            System.out.println("Value is" + str1);
//            children_list.add(str1);
//            System.out.println(children_list);
//            arrayAdapter.notifyDataSetChanged();
//        }


    }
    public void add(View v){
        Intent ne= new Intent(this,Addchild.class);

        startActivity(ne);
    }

    public void delete(View v){
        Intent ne= new Intent(this,Main2Activity.class);

        startActivity(ne);
    }

    public void settings(View v){
        Intent ne= new Intent(this,Settings.class);

        startActivity(ne);
    }

    public void click(View v)
    {
        Intent ne= new Intent(this,ChildSelect.class);
        ne.putExtra("username",str);
        ne.putExtra("child",c);
        startActivity(ne);

    }

    public void addChildren(View v){

//        childName = (EditText) findViewById(R.id.child_name);
//        childPhone = (EditText) findViewById(R.id.child_number);

        name = in.getStringExtra("name");
        phoneNumber = in.getStringExtra("phoneNumber");
        date = in.getStringExtra("date");


        childDetails.put("name", name);
        childDetails.put("phoneNumber", phoneNumber);
        childDetails.put("dob",date);
        System.out.println("Child Details anta " + childDetails);
        Backendless.Persistence.of( "NewChild" ).save( childDetails, new AsyncCallback<Map>() {
            public void handleResponse( Map response )
            {
                System.out.println(response);
                // new Contact instance has been saved

            }

            public void handleFault( BackendlessFault fault )
            {
                System.out.println(fault);

                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });
        listOfChildren.add(new Children(name, phoneNumber, date));
        ListView list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Children> ad = new ChildAdapter(this, R.layout.listview, R.id.textView6, listOfChildren);
        list.setAdapter(ad);


    }

    public void hehe(View v) {
        System.out.println("LOLLllllllll ************** ");

    }

}
