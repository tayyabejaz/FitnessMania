package com.example.starterproject.managers;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.starterproject.R;
import com.example.starterproject.activities.MainActivity;

public class NotificationManager {

    private static NotificationManager manager;
    private final static int NOTIFICATION_ID_MORNING = 1;
    private final static int NOTIFICATION_ID_SLEEPY = 2;
    private static final String TAG = NotificationManager.class.getSimpleName();

    private NotificationManager() {
    }

    public static NotificationManager getInstance() {
        if (manager == null) {
            manager = new NotificationManager();
        }
        return manager;
    }

    public void generateNotification(Context context, int exerciseType, String title, String text) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            //TODO:Notification ICON
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, TAG)
                    .setSound(uri)
                    .setAutoCancel(true)
                    .setContentText(text)
                    .setContentTitle(title)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = context.getString(R.string.app_name);
                String description = context.getString(R.string.app_name);
                NotificationChannel channel = new NotificationChannel(TAG, name, android.app.NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription(description);
                notificationManager.createNotificationChannel(channel);
            }
            notificationManager.notify(exerciseType == 1 ? NOTIFICATION_ID_MORNING : NOTIFICATION_ID_SLEEPY, notificationBuilder.build());
        }
    }
}