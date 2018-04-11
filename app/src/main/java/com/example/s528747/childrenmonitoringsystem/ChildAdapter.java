package com.example.s528747.childrenmonitoringsystem;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by s528763 on 2/22/18.
 */

public class ChildAdapter extends ArrayAdapter {
    public ChildAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull ArrayList<Children> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        TextView tv1 = v.findViewById(R.id.textView6);
//        TextView tv2 = (TextView) v.findViewById(R.id.textView4);
//        TextView tv3 = (TextView) v.findViewById(R.id.textView4);
        Children even = (Children) getItem(position);
        tv1.setText(even.getChildName());
        Log.d("adapter",even.getChildName() );
//        tv2.setText(even.getChildPhone());
//        tv3.setText(even.getDate());
        return v;
    }
}
