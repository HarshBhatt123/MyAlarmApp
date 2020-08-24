package com.example.myalarmapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Alarm extends AppCompatActivity {
    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;



    final int RQS_RINGTONEPICKER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void OnSetClicked(View view) {
        long time;

            Toast.makeText(Alarm.this, "ALARM ON", Toast.LENGTH_LONG).show();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);



            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time)
            {
                if (calendar.AM_PM == 0)
                    time = time + (1000*60*60*12);
                else
                    time = time + (1000*60*60*24);
            }
         alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, time, alarmManager.INTERVAL_DAY, pendingIntent);



    }


    public void alarmOff(View view) {


        ArrayList<String> Queslist = new ArrayList<>();
        Queslist.add("A@nd%$kjd");
        Queslist.add("saY!=Gv#2");
        Queslist.add("2s(HGn)13");
        Queslist.add("81*s_dy&");
        Queslist.add("12-w_+8^3");

        Random random = new Random();
        final String q = Queslist.get(random.nextInt(Queslist.size()));





        //finish();
        //System.exit(0);
       // if (alarmManager!= null) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText( this);
        edittext.setSingleLine();
        alert.setMessage(q);
        alert.setTitle("Type below text as it is to turn off alarm \n ");
        alert.setCancelable(false);
        alert.setView(edittext);

        alert.setPositiveButton("Yes Option", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int whichButton) {

                String inputAns = edittext.getText().toString();
                if(inputAns.equals(q)){
                    Toast.makeText(Alarm.this, "Right Answer !!! Alarm Off", Toast.LENGTH_LONG).show();

                   finish();
                    //   finishAffinity();
                   System.exit(0);
                    //Intent myIntent = new Intent(Alarm.this, MainActivity.class);
                   //startActivity(myIntent);


                }else{
                    Toast.makeText(Alarm.this, "Wrong Answer , Try Again", Toast.LENGTH_SHORT).show();
                }


            }


        });
        alert.show();


      //      alarmManager.cancel(pendingIntent);
      //  }







    }


}
