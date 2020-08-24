package com.example.myalarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimerWin extends AppCompatActivity {



private TextView mTV;
private Button mBtnStartPause;
private Button mBtnReset;
private Button mBtnset;
private EditText mEt;

private CountDownTimer mCdt;
private boolean mTimerRunning;

 private   long Start_Time ;

private long mTimeLeft = Start_Time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_timer_win);
            mTV =findViewById(R.id.TV);
            mBtnReset= findViewById(R.id.reset);
            mBtnset=findViewById(R.id.btnset);
            mBtnStartPause =findViewById(R.id.start);
        mEt = findViewById(R.id.et);




        mBtnset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnStartPause.setEnabled(true);
                String input = mEt.getText().toString();
                if(input.length()==0){
                    Toast.makeText(TimerWin.this, "Enter time", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisInput = Long.parseLong(input) * 60000;
                if(millisInput==0){
                    Toast.makeText(TimerWin.this, "Enter positive number", Toast.LENGTH_SHORT).show();
                    return;
                }
                setTime (millisInput);
                mEt.setText("");

            }
        });


        mBtnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTV.setText("00:00");
                mBtnStartPause.setEnabled(false);// resetTimer();
            }
        });
        updateCountDownText();
    }

    private void setTime(long milliseconds){
        Start_Time = milliseconds;
        resetTimer();
    }

    private void startTimer(){
        mCdt = new CountDownTimer(mTimeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning= false;
                mBtnStartPause.setText("Start");

            }
        }.start();

        mTimerRunning=true;
        mBtnStartPause.setText("Pause");
    }
    private void pauseTimer(){
        mCdt.cancel();
        mTimerRunning=false;
        mBtnStartPause.setText ("Start") ;
    }
    private void resetTimer(){
        mTimeLeft=Start_Time;
        updateCountDownText();

    }
    private void updateCountDownText(){
        int hrs = (int) ( mTimeLeft /1000 )/3600 ;
        int min = (int) (( mTimeLeft /1000 )%3600) /60 ;
        int sec= (int) ( mTimeLeft /1000 )%60 ;
        String timeLeft;
        if(hrs>0){
            timeLeft = String.format(Locale.getDefault(),"%d:%02d:%02d",hrs,min,sec);
        }else{
            timeLeft = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        }

        mTV.setText(timeLeft);
    }
}
