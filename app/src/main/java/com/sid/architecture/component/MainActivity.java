package com.sid.architecture.component;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sid.architecture.component.livedata.view.HeroDeatilsActivity;
import com.sid.architecture.component.retrofit.ui.RetrofitActivityDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRetrofit1, btnLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         getInit();
    }
    void getInit(){
        btnRetrofit1 = (Button)findViewById(R.id.btnRetrofit1);
        btnRetrofit1.setOnClickListener(this);
        btnLiveData = (Button)findViewById(R.id.btnLiveData);
        btnLiveData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnRetrofit1){
            startActivity(new Intent(MainActivity.this, RetrofitActivityDemo.class));
        }else if(v == btnLiveData){
            startActivity(new Intent(MainActivity.this, HeroDeatilsActivity.class));
        }

    }
}
