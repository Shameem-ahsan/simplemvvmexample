package com.user.simplemvvmexample;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import com.user.simplemvvmexample.dagger_mvc.DaggerMvcMainActivity;
import com.user.simplemvvmexample.dagger_mvvm.DaggerMvvmMainActivity;
import com.user.simplemvvmexample.mvc.MvcMainActivity;
import com.user.simplemvvmexample.mvp.MvpMainActivity;
import com.user.simplemvvmexample.mvvm.MvvmMainActivity;
import com.user.simplemvvmexample.rxjava_mvc.RxMvcMainActivity;
import com.user.simplemvvmexample.rxjava_mvvm.RxMvvmMainActivity;

public class HomeActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);

        button1.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), MvcMainActivity.class);
            startActivity(i);
        });
        button2.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), MvpMainActivity.class);
            startActivity(i);
        });
        button3.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), MvvmMainActivity.class);
            startActivity(i);
        });
        button4.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), RxMvcMainActivity.class);
            startActivity(i);
        });
        button5.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), RxMvvmMainActivity.class);
            startActivity(i);
        });
        button6.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), DaggerMvcMainActivity.class);
            startActivity(i);
        });
        button7.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), DaggerMvvmMainActivity.class);
            startActivity(i);
        });
    }
}
