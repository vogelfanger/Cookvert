package com.cookvert.util;

import android.app.Application;
import android.content.Context;

/**
 * Utility class that is used as a static way to get the application context.
 */

public class Cookvert extends Application {

    public static final String PREFS_NAME = "SignInPreferences";
    public static final String PREF_SIGN_IN_SHOW = "SignInShow";
    public static final String PREF_SIGN_IN_SETTING = "SignInSetting";
    public static final String PREFS_DB_LAST_EDITED = "databaseLastEditDate";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Cookvert.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
