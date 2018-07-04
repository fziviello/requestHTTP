package ziviello.com.httprequest;

import android.app.Application;
import android.content.Context;

/**
 * Created by fziviello on 31/01/18.
 */

public class MyApplication extends Application{

    private static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx=this;
    }

    public static Context getGlobalContext() {
        return ctx;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;
}