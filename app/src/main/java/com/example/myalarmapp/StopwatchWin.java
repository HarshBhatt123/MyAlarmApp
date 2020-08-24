package com.example.myalarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopwatchWin extends AppCompatActivity {
    private Chronometer chronometer;

    private long pausex;
    private boolean running;
    ListView listView;
    Button lap;
    String[] ListElements = new String[] {  };

    List<String> ListElementsArrayList ;

    ArrayAdapter<String> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch_win);
        lap = (Button)findViewById(R.id.btnlap) ;
        listView = (ListView)findViewById(R.id.lv1);
        chronometer =findViewById(R.id.chro);

        Handler handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(StopwatchWin.this,android.R.layout.simple_list_item_1,ListElementsArrayList);

        listView.setAdapter(adapter);

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListElementsArrayList.add(chronometer.getText().toString());

                adapter.notifyDataSetChanged();

            }
        });



    }
    public void start(View v){
        if (!running){
            Toast.makeText(StopwatchWin.this, "Stopwatch Started",Toast.LENGTH_SHORT).show();
            chronometer.setBase(SystemClock.elapsedRealtime() - pausex);
            chronometer.start();
            running=true;
        }
    }
    public void pause(View v){
        if(running){
            Toast.makeText(StopwatchWin.this, "Stopwatch Paused",Toast.LENGTH_SHORT).show();
            chronometer.stop();
            pausex =SystemClock.elapsedRealtime() - chronometer.getBase();
            running=false;
        }
    }
    public void reset(View v){
       chronometer.setBase(SystemClock.elapsedRealtime());
       pausex=0;
    }

}
