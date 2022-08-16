package com.wifitestproject;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.util.Log;
import android.net.wifi.WifiManager;
import android.content.Context;
import androidx.work.WorkManager;
import androidx.work.OneTimeWorkRequest;
import java.util.concurrent.TimeUnit;

import com.wifitestproject.MyWorker;


public class WifiSwitcher extends ReactContextBaseJavaModule {
    static ReactApplicationContext context;
    static boolean isSwitching = false;

    WifiSwitcher(ReactApplicationContext context) {
        super(context);
        WifiSwitcher.context = context;
    }

    @Override
    public String getName() {
        return "WifiSwitcher";
    }

    @ReactMethod
    public static void switchWifi() {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE); 
        wifiManager.setWifiEnabled(!wifiManager.isWifiEnabled());
    }

    @ReactMethod
    static public void startWork() {
        if(!isSwitching) {
            WorkManager workManager = WorkManager.getInstance(context);
            workManager.enqueue(new OneTimeWorkRequest.Builder(MyWorker.class).setInitialDelay(15, TimeUnit.SECONDS).build());
            isSwitching = true;
        } else {
            WorkManager workManager = WorkManager.getInstance(context);
            workManager.cancelAllWork();
            isSwitching = false;
        }
    }

}
