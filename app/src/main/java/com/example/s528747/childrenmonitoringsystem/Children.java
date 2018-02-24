package com.example.s528747.childrenmonitoringsystem;

import android.widget.CalendarView;

/**
 * Created by s528763 on 2/22/18.
 */

public class Children {
    private String childName;
    private String childPhone;
    private String date;

    public Children(String childName, String childPhone, String date){
        this.childName = childName;
        this.childPhone = childPhone;
        this.date = date;
    }
    public Children(){}

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildPhone() {
        return childPhone;
    }

    public void setChildPhone(String childPhone) {
        this.childPhone = childPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

