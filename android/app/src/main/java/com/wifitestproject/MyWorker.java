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
import androidx.work.Worker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import java.util.concurrent.TimeUnit;

public class MyWorker extends Worker {
    MyWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override
    public ListenableWorker.Result doWork() {
        WifiSwitcher.switchWifi();

        WorkManager workManager = WorkManager.getInstance(WifiSwitcher.context);
        workManager.enqueue(new OneTimeWorkRequest.Builder(MyWorker.class).setInitialDelay(15, TimeUnit.SECONDS).build());

        return ListenableWorker.Result.success();
    }

}