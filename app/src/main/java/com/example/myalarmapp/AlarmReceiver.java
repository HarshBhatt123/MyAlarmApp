package com.example.myalarmapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getSystemService;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm!!!!!!!", Toast.LENGTH_LONG).show();

        Vibrator v;
        v=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = { 10, 100, 1000 };
        v.vibrate(pattern, 1);
      //  v.vibrate(10000);

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }else if(!ringtone.isPlaying()){
            ringtone.stop();
        }

        ringtone.play();



        PendingIntent Sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        NotificationManager manager = (NotificationManager)context.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
        Notification noti = new Notification(android.R.drawable.stat_notify_more, "Wake up alarm", System.currentTimeMillis());
       // noti.setLatestEventInfo(context, "My Alarm", "WAKE UP...!!!", Sender);
        noti.flags = Notification.FLAG_AUTO_CANCEL;
        manager.notify(R.string.app_name, noti);

        Intent myIntent = new Intent(context, Alarm.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);




    }
}
