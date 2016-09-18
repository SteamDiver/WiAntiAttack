package com.example.home.wiantiattack;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by home on 18.09.16.
 */
public class Notifier {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Notifier(Context context, String Title, String Text, int NOTIFY_ID){
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);


        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.color.colorPrimary)
                .setContentTitle(Title)
                .setContentText(Text); // Текст уведомления

        Notification notification = builder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFY_ID, notification);
    }
}
