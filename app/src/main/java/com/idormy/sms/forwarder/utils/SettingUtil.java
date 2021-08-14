package com.idormy.sms.forwarder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SettingUtil {
    static Boolean hasInit = false;
    private static String TAG = "SettingUtil";
    private static SharedPreferences sp_setting = null;
    private static Context context = null;

    public static void init(Context context1) {
        synchronized (hasInit) {
            if (hasInit) return;
            hasInit = true;
            context = context1;
            Log.d(TAG, "init ");
            sp_setting = PreferenceManager.getDefaultSharedPreferences(context1);
        }
    }

    public static void switchAddExtra(Boolean switchAddExtra) {
        Log.d(TAG, "switchAddExtra :" + switchAddExtra);
        sp_setting.edit()
                .putBoolean(Define.SP_MSG_KEY_SWITCH_ADD_EXTRA, switchAddExtra)
                .apply();
    }

    public static boolean getSwitchAddExtra() {
        return sp_setting.getBoolean(Define.SP_MSG_KEY_SWITCH_ADD_EXTRA, false);
    }

    public static void switchAddDeviceName(Boolean switchAddDeviceName) {
        Log.d(TAG, "switchAddDeviceName :" + switchAddDeviceName);
        sp_setting.edit()
                .putBoolean(Define.SP_MSG_KEY_STRING_ADD_EXTRA_DEVICE_NAME, switchAddDeviceName)
                .apply();
    }


    public static boolean getSwitchAddDeviceName() {
        return sp_setting.getBoolean(Define.SP_MSG_KEY_STRING_ADD_EXTRA_DEVICE_NAME, false);
    }

    public static void switchEnablePhone(Boolean enable) {
        sp_setting.edit()
                .putBoolean(Define.SP_MSG_KEY_STRING_ENABLE_PHONE, enable)
                .apply();
    }

    public static boolean getSwitchEnablePhone() {
        return sp_setting.getBoolean(Define.SP_MSG_KEY_STRING_ENABLE_PHONE, true);
    }

    public static void switchSmsTemplate(Boolean switchSmsTemplate) {
        Log.d(TAG, "switchSmsTemplate :" + switchSmsTemplate);
        sp_setting.edit()
                .putBoolean(Define.SP_MSG_KEY_SWITCH_SMS_TEMPLATE, switchSmsTemplate)
                .apply();
    }

    public static boolean getSwitchSmsTemplate() {
        return sp_setting.getBoolean(Define.SP_MSG_KEY_SWITCH_SMS_TEMPLATE, false);
    }

    public static String getAddExtraDeviceMark() {
        String res = sp_setting.getString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_DEVICE_MARK, "");
        if (res == null || res.equals("")) {
            res = android.os.Build.MODEL;
        }
        return res;
    }

    public static void setAddExtraDeviceMark(String addExtraDeviceMark) {
        Log.d(TAG, "addExtraDeviceMark :" + addExtraDeviceMark);
        sp_setting.edit()
                .putString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_DEVICE_MARK, addExtraDeviceMark)
                .apply();
    }

    public static String getSmsTemplate() {
        return sp_setting.getString(Define.SP_MSG_KEY_STRING_SMS_TEMPLATE, "{{来源号码}}\n{{短信内容}}\n{{卡槽信息}}\n{{接收时间}}\n{{设备名称}}");
    }

    public static void setSmsTemplate(String textSmsTemplate) {
        Log.d(TAG, "textSmsTemplate :" + textSmsTemplate);
        sp_setting.edit()
                .putString(Define.SP_MSG_KEY_STRING_SMS_TEMPLATE, textSmsTemplate)
                .apply();
    }

    public static String getAddExtraSim1() {
        String res = sp_setting.getString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_SIM1, "");
        if (res == null || res.equals("")) {
            res = SimUtil.getSimInfo(1);
        }
        return res;
    }

    public static void setAddExtraSim1(String sim1) {
        Log.d(TAG, "sim1 :" + sim1);
        sp_setting.edit()
                .putString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_SIM1, sim1)
                .apply();
    }

    public static String getAddExtraSim2() {
        String res = sp_setting.getString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_SIM2, "");
        if (res == null || res.equals("")) {
            res = SimUtil.getSimInfo(2);
        }
        return res;
    }

    public static void setAddExtraSim2(String sim2) {
        Log.d(TAG, "sim2 :" + sim2);
        sp_setting.edit()
                .putString(Define.SP_MSG_KEY_STRING_ADD_EXTRA_SIM2, sim2)
                .apply();
    }

    public static boolean saveMsgHistory() {
        return sp_setting.getBoolean("option_save_history_on", false);
    }
}
