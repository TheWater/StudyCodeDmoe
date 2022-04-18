package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //声明组件
    DatePicker datePicker;
    //封装年、月、日
    private int year;
    private int month;
    private int day;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        int arr[]=new int[10];
        for (int i=0;i<=10;++i){
            arr[i]=i+1;
        }

    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.week3_demo2);
//
//
//        Calendar calendar=Calendar.getInstance();
//        year=calendar.get(calendar.YEAR);
//        month=calendar.get(calendar.MONTH);
//        day=calendar.get(calendar.MONDAY);
//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//                year=+i;
//                month=i1;
//                day=i2;
//
//                String str="开学时间是"+year+"年";
//            }
//        });
//
//
//
//
//
//    }
}