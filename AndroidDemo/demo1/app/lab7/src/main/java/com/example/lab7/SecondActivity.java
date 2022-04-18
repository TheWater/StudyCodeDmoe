package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 获取intent
        Intent intent=getIntent();
        // 使用Bundle获取数据
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        String num=bundle.getString("num");
        String phone=bundle.getString("phone");
        String address=bundle.getString("address");
        String temperam=bundle.getString("temperam");
        EditText name_text=(EditText) findViewById(R.id.editTextTextPersonName8);
        EditText num_text=(EditText) findViewById(R.id.editTextTextPersonName9);
        EditText phone_text=(EditText) findViewById(R.id.editTextTextPersonName10);
        EditText address_text=(EditText) findViewById(R.id.editTextTextPersonName11);
        EditText temperam_text=(EditText) findViewById(R.id.editTextTextPersonName13);

        name_text.setText(name);
        num_text.setText(num);
        phone_text.setText(phone);
        address_text.setText(address);
        temperam_text.setText(temperam);

        Button button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
                intent.putExtra("tempream",temperam);
                setResult(10,intent);
                finish();


            }
        });
    }
}