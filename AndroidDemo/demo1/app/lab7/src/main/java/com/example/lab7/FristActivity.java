package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FristActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取编辑框文本
                String name=((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
                String num=((EditText)findViewById(R.id.editTextTextPersonName2)).getText().toString();
                String phone=((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString();
                String address=((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString();
                String temperam=((EditText)findViewById(R.id.editTextTextPersonName5)).getText().toString();
                // 创建intent实例
                Intent intent = new Intent(FristActivity.this,SecondActivity.class);
                // 创建bundle实例
                Bundle bundle = new Bundle();
                // 使用bundle存储数据
                bundle.putString("name",name);
                bundle.putString("num",num);
                bundle.putString("phone",phone);
                bundle.putString("address",address);
                bundle.putString("temperam",temperam);
                // 将bundle放进intent传递
                intent.putExtras(bundle);
                // 启动activity
                startActivity(intent);
            }
        });

    }
}