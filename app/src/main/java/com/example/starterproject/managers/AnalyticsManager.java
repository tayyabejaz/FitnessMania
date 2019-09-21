package com.example.starterproject.managers;

import android.os.Bundle;

import com.example.starterproject.application.AppClass;
import com.example.starterproject.helper.AppConstants;
import com.google.firebase.analytics.FirebaseAnalytics;


public class AnalyticsManager {

    private static AnalyticsManager manager;
    private FirebaseAnalytics firebaseAnalytics;

    private AnalyticsManager() {
        firebaseAnalytics = FirebaseAnalytics.getInstance(AppClass.getContext());
    }

    public static AnalyticsManager getInstance() {
        if (manager == null) {
            manager = new AnalyticsManager();
        }
        return manager;
    }

    public void sendAnalytics(String actionDetail, String actionName) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, (actionDetail));
        bundle.putString(AppConstants.ACTION_TYPE, actionName);
        firebaseAnalytics.logEvent(actionName, bundle);
    }
}
