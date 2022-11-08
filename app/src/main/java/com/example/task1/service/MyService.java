package com.example.task1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.task1.MainActivity;

public class MyService extends Service {
    public static final String TAG = "MyService";
    private final IBinder mBinder = new MyServiceImpl();

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind:" + mBinder);
        return mBinder;
    }
}