package com.example.starterproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.starterproject.R;
import com.example.starterproject.application.AppClass;
import com.example.starterproject.helper.SharedPreferencesManager;
import com.example.starterproject.managers.NotificationManager;

import java.util.Calendar;
import java.util.Locale;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        String shortDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH);
        String repeatingAlarms = SharedPreferencesManager.Companion.getInstance(AppClass.getContext()).getString(context.getString(R.string.app_name));
        if (repeatingAlarms.contains(shortDay)) {
            String title = context.getString(R.string.app_name);
            String text = context.getString(R.string.app_name);
            NotificationManager.getInstance().generateNotification(context, 1, title, text);
        }
    }
}