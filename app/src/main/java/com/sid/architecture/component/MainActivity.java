package com.sid.architecture.component;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.sid.architecture.component.retrofit.ui.RetrofitActivityDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRetrofit1, btnRetrofit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);

         getInit();
    }
    void getInit(){
        btnRetrofit1 = (Button)findViewById(R.id.btnRetrofit1);
        btnRetrofit1.setOnClickListener(this);
        btnRetrofit2 = (Button)findViewById(R.id.btnRetrofit2);
        btnRetrofit2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnRetrofit1){
            startActivity(new Intent(MainActivity.this, RetrofitActivityDemo.class));
        }else if(v == btnRetrofit2){
            //startActivity(new Intent(MainActivity.this, RetrofitActivityDemo2.class));
        }

    }
}
