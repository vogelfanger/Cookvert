package com.cookvert.util;

import android.app.Application;
import android.content.Context;

/**
 * Utility class that is used as a static way to get the application context.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
