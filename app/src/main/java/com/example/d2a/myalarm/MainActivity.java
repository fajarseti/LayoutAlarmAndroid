package com.example.d2a.myalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlarmManager myAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAlarm =(AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void startSomething(View view) {
        Toast.makeText(this,"Alarm Started",Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent();
        i1.setAction("com.lalit.myown.receiver.Message");
        i1.addCategory("android.intent.category.DEFAULT");
        PendingIntent p1 = PendingIntent.getBroadcast(this,0,i1,0);

        myAlarm.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000 * 30,p1);
    }

    public void stopSomething(View view) {
        Toast.makeText(this,"Alarm Stopped",Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent();
        i1.setAction("com.lalit.myown.receiver.Message");
        i1.addCategory("android.intent.category.DEFAULT");
        PendingIntent p1 = PendingIntent.getBroadcast(this,0,i1,0);

        myAlarm.cancel(p1);
    }
}
