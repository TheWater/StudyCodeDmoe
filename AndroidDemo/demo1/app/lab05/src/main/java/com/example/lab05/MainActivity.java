package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,View.OnLongClickListener{

//    private String[] data = {"汉堡","薯条","可乐","玉米浓汤"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Resources resourse = this.getResources();
//        String[] data = resourse.getStringArray(R.array.foot);
//        Set<String> set = new HashSet<String>();
//        setContentView(R.layout.layout_demo1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, data
//        );
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                TextView textView=(TextView) view;
//                System.out.println(textView.getText().toString());
//                //获取文本内容
//                String item=textView.getText().toString();
//                //判断在集合中是否存在对象
//                if(set.contains(item)){
//                    set.remove(item);
//                }else{
//                    set.add(item);
//                }
//                String msg;
//                if(set.size()>0){
//                    msg="你点了：";
//                    for (String str:set)
//                        msg+=" "+str;
//                }else {
//                    msg="请点餐";
//                }
//                //将集合放入编辑框
//                EditText et=findViewById(R.id.edit_view);
//                et.setText(msg);
//
//
//            }
//        });
        super.onCreate(savedInstanceState);
        char[] counter = o;
        setContentView(R.layout.activity_main);
        //获取组件
        TextView textView=findViewById(R.id.txt);
        Button button=findViewById(R.id.bt1);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.txt)
        {
            counter=0;
            textView.setText(String.valueOf(counter));
        }
        else
        {
            counter+=s;
            textView.setText(String.valueOf(counter));
        }
        return false;
    }
}