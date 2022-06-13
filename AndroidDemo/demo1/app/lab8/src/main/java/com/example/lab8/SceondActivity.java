package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class SceondActivity extends AppCompatActivity {
    //获取系统定义的数组资源
    String[] texts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceond);
        texts = getResources().getStringArray(R.array.string_arr);
        //创建一个BaseAdapter对象
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                //指定一共包含8个选项
                return texts.length;
            }

            @Override
            public Object getItem(int position) {
                //返回指定位置的文本
                System.out.println("1" + position);
                return texts[position];
            }

            @Override
            public long getItemId(int position) {
                System.out.println("2" + position);
                return position;
            }

            //重写该方法，该方法返回的View将作为的GridView的每个格子
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(SceondActivity.this);
                Resources res = getResources();
                //使用尺度资源来设置文本框的高度、宽度
                text.setWidth((int) res.getDimension(R.dimen.width));
                text.setHeight((int) res.getDimension(R.dimen.height));
                //使用字符串资源设置文本框的内容
                text.setText(texts[position]);
                System.out.println("3" + position);
                TypedArray icons = res.obtainTypedArray(R.array.plain_arr);
                //使用颜色资源来设置文本框的 背景色

                text.setBackground(icons.getDrawable(position));


                text.setTextSize(20);
                text.setGravity(Gravity.CENTER);
                return text;
            }
        };
        GridView grid = findViewById(R.id.grid01);
        //为GridView设置Adapter
        grid.setAdapter(ba);
        //获取按钮组件 返回到第1个界面
        Button button = findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //补充代码段，实现页面跳转到FirstActivity


            }
        });
    }
    }
