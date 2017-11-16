package com.example.d2a.myalarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class StandUp extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Inside Receiver",Toast.LENGTH_SHORT).show();

        NotificationManagerCompat myManager = NotificationManagerCompat.from(context);

        NotificationCompat.Builder myNotif = new NotificationCompat.Builder(context);
        myNotif.setContentTitle("Stand UP Notification");
        myNotif.setContentText("Wake up coeg. Turu wae");
        myNotif.setSmallIcon(android.R.drawable.ic_lock_idle_alarm);

        Intent i1 = new Intent(context,StandUpActivity.class);
        PendingIntent p1 = PendingIntent.getActivity(context,0,i1,0);
        myNotif.setContentIntent(p1);

        myNotif.setAutoCancel(true);

        myManager.notify(1,myNotif.build());


    }
}
