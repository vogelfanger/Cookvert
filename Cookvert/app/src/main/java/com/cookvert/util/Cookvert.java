package com.cookvert.util;

import android.app.Application;
import android.content.Context;

/**
 * Utility class that is used as a static way to get the application context.
 */

public class Cookvert extends Application {

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
