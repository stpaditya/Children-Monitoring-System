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

import java.util.Calendar;

public class Addchild extends AppCompatActivity {
    private Button addbtn;
    private EditText childname;

    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private String dateValue;
    Button dateP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);


        childname = (EditText) findViewById(R.id.child_name);
//
        addbtn = (Button) findViewById(R.id.addchild_acbtn);
//
//
       // ((Main2Activity)Addchild).addChildren();
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = childname.getText().toString();
                System.out.println("child name"+temp);
                Intent y= new Intent(getApplicationContext(),Main2Activity.class);
                y.putExtra("addch",temp);
                startActivity(y);
            }
        });

        dateP = (Button) findViewById(R.id.datepick);
        dateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Addchild.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth, onDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateValue = i1+"/"+i2+"/"+i;
            }
        };

        Intent y2 = new Intent(getApplicationContext(),Main2Activity.class);
        y2.putExtra("date",dateValue);
    }
}
