package com.example.electivefinals;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class FifteenthGuidedExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteenth_guided_exercise);

        // Register receivers
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver, filter);

        // Trigger custom broadcast
        Intent customIntent = new Intent("com.example.electivefinals.MY_CUSTOM_ACTION");
        sendBroadcast(customIntent);
    }
}
