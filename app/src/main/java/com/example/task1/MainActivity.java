package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.task1.databinding.ActivityMainBinding;
import com.example.task1.service.MyService;
import com.example.task1.service.MyServiceImpl;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    IMyInterface mService = null;
    private TextView mResultTextView = null;
    private final int a = 10;
    private final int b = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button connectButton = binding.connectButton;
        connectButton.setOnClickListener(l -> {
            Log.i(TAG, "Starting connection");
            Intent intent = new Intent(getApplicationContext(), MyService.class);
            bindService(intent, new MyServiceConnection(), BIND_AUTO_CREATE);
            Log.i(TAG, "Finishing connection");
        });

        Button getResultButton = binding.getResultButton;
        getResultButton.setOnClickListener(l -> {
            try {
                mService.doWork(a, b, new MyServiceCallback());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        mResultTextView = binding.resultTextView;

    }

    private class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: " + service);
            mService = IMyInterface.Stub.asInterface(service);
            Log.i(TAG, "onServiceConnected exit");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected");
        }
    }

    private class MyServiceCallback extends ICallback.Stub {
        @Override
        public void onDataReady(int data) {
            Log.i(TAG, "onDataReady" + data);
            runOnUiThread(() -> mResultTextView.setText(String.valueOf(data)));
        }
    }
}