package com.idormy.sms.forwarder;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import com.idormy.sms.forwarder.sender.SendHistory;
import com.idormy.sms.forwarder.utils.Define;
import com.idormy.sms.forwarder.utils.PhoneUtils;
import com.idormy.sms.forwarder.utils.SettingUtil;
import com.smailnet.emailkit.EmailKit;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    //SIM卡信息
    public static List<PhoneUtils.SimInfo> SimInfoList = new ArrayList<>();
    //是否关闭页面提示
    public static boolean showHelpTip = true;
    //企业微信
    public static String QyWxAccessToken;
    public static long QyWxAccessTokenExpiresIn = 0;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        Intent intent = new Intent(this, FrontService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
        SendHistory.init(this);
        SettingUtil.init(this);

        EmailKit.initialize(this);

        SharedPreferences sp = MyApplication.this.getSharedPreferences(Define.SP_CONFIG, Context.MODE_PRIVATE);
        showHelpTip = sp.getBoolean(Define.SP_CONFIG_SWITCH_HELP_TIP, true);

    }
}
