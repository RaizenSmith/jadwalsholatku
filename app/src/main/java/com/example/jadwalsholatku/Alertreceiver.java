package com.example.jadwalsholatku;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


public class Alertreceiver extends BroadcastReceiver {
    MediaPlayer player;
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());

        Toast.makeText(context, "Alarm Sholat Aktif!", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(context, R.raw.adzanku);
        player.start();
    }
}