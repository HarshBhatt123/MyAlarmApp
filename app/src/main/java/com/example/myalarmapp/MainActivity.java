package com.example.myalarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.AlarmBtn);
        b2 = findViewById(R.id.TimerBtn);
        b3 = findViewById(R.id.StopwatchBtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity1();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });


    }
    public void  openActivity1(){
        Intent intent = new Intent(this , Alarm.class);
        startActivity(intent);
    }
    public void  openActivity2(){
        Intent intent = new Intent(this , TimerWin.class);
        startActivity(intent);
    }
    public void  openActivity3(){
        Intent intent = new Intent(this , StopwatchWin.class);
        startActivity(intent);
    }
}
