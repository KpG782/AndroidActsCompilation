package com.example.electivefinals;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String title;
        String message;

        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            title = "Battery Status";
            message = "Battery state has changed.";
            logEvent("Battery change detected.");
        } else if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            title = "Airplane Mode";
            message = isAirplaneModeOn ? "Airplane mode is ON." : "Airplane mode is OFF.";
            logEvent("Airplane mode toggle detected: " + message);
        } else {
            return; // Unknown action
        }

        showNotification(context, title, message);
    }

    private void showNotification(Context context, String title, String message) {
        String channelId = "notification_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId, "Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_announcement)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        manager.notify(1, builder.build());
    }

    private void logEvent(String message) {
        Log.d("MyReceiver", message);
    }
}
