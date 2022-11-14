package com.example.task1.service;

import android.os.RemoteException;
import android.util.Log;

import com.example.task1.ICallback;
import com.example.task1.IMyInterface;

public class MyServiceImpl extends IMyInterface.Stub {

    public static final String TAG = "MyServiceImpl";

    @Override
    public void doWork(int a, int b, ICallback callback) throws RemoteException {
        Log.i(TAG, "doWork entry pid=" + android.os.Process.myPid());
        try {
            Thread.sleep(5000);
            callback.onDataReady(a + b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "doWork exit");
    }
}
