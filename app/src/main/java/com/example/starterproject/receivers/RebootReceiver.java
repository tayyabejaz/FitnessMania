package com.example.starterproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.starterproject.R;
import com.example.starterproject.helper.SharedPreferencesManager;
import com.example.starterproject.managers.AlarmManager;


public class RebootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SharedPreferencesManager.Companion.getInstance(context).getBoolean(context.getString(R.string.alarm), true)) {
            int hour = Integer.parseInt(SharedPreferencesManager.Companion.getInstance(context).getString(context.getString(R.string.hour)));
            int minute = Integer.parseInt(SharedPreferencesManager.Companion.getInstance(context).getString(context.getString(R.string.minute)));
            AlarmManager.getInstance().setAlarm(context, hour, minute);
        }
    }
}
