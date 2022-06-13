package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FristActivity extends AppCompatActivity {
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        //获取只能被本应用程序读，写的sharePreferences对象
        SharedPreferences preferences = getSharedPreferences("hello", MODE_PRIVATE);
        edit = preferences.edit();
        Button read = findViewById(R.id.read);
        Button write = findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //读取字符串数据
                String time = preferences.getString("time", null);
                int randNum = preferences.getInt("random",0);
                String result = time ==null?"您暂时还没写入数据":"写入时间为："+time+"\n上次生成的随机数为："+randNum;
                Toast.makeText(FristActivity.this,result,Toast.LENGTH_LONG).show();

            }

        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日" + "hh:mm:ss", Locale.CANADA);
                //存入当前时间
                edit.putString("time",simpleDateFormat.format(new Date()));
                //存入一个随机数
                edit.putInt("rando,",(int)(Math.random()*100));
                //提交所有存入的数据
                edit.commit();
            }
        });
    }
}