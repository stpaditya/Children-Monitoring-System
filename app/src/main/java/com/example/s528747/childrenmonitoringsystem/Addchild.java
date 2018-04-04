package com.example.s528747.childrenmonitoringsystem;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Addchild extends AppCompatActivity {
    private Button addbtn;
    private EditText childname;
    private EditText childEmail;
    private EditText childID;

    private DatePickerDialog.OnDateSetListener onDateSetListener;
//    private String dateValue;
    Button dateP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);


        childname = (EditText) findViewById(R.id.child_name);
        childEmail = (EditText) findViewById(R.id.child_email);
        childID = (EditText) findViewById(R.id.child_id);

//
        addbtn = (Button) findViewById(R.id.addchild_acbtn);

//        dateP = (Button) findViewById(R.id.datepick);
//        dateP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar calendar = Calendar.getInstance();
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(Addchild.this,
//                        android.R.style.Theme_Holo_Dialog_MinWidth, onDateSetListener,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//
//        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                i1 = i1 + 1;
//                dateValue = i1+"/"+i2+"/"+i;
//            }
//        };

        //System.out.println("OnDatesetLister aindi " + dateValue);
//
//
        //
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String temp = childname.getText().toString();
                String temp2 = childEmail.getText().toString();
                String temp3 = childID.getText().toString();
//
//
//                System.out.println("child name"+temp);
                //System.out.println("addbtn lo " + temp2 + " ---- " + temp + " date anta " + dateValue);
                Intent y = new Intent(getApplicationContext(),Main2Activity.class);
                y.putExtra("name",temp);
                y.putExtra("email",temp2);
                y.putExtra("id",temp3);

                startActivity(y);

                System.out.println("Inka ikkade undi");

//
//                Intent ini = new Intent(this, Main2Activity.class);
//                startActivity(ini);

//                Main2Activity mainAct = new Main2Activity();
//
//                //Calling function from another class and storing string return value in string b.
//                mainAct.addChildren(view);

                // Printing b value on activity screen using toast message.
//                Toast.makeText(Addchild.this, mainAct, Toast.LENGTH_LONG).show();

            }
        });



//        Intent y2 = new Intent(getApplicationContext(),Main2Activity.class);
//        y2.putExtra("date",dateValue);
    }
}
