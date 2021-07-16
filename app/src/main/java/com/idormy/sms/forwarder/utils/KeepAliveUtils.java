package com.idormy.sms.forwarder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;

public class KeepAliveUtils {

    public static void ignoreBatteryOptimization(Activity activity) {
        PowerManager powerManager = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            boolean hasIgnored = powerManager.isIgnoringBatteryOptimizations(activity.getPackageName());
            if (!hasIgnored) {
                Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                ResolveInfo resolveInfo = activity.getPackageManager().resolveActivity(intent, 0);
                if (resolveInfo != null) {
                    activity.startActivity(intent);
                }
            }
        }
    }
}
