package com.example.electivefinals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Custom Broadcast Received: " + intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
