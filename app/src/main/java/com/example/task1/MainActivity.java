package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        TextView inputText = findViewById(R.id.inputText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            String text = inputText.getText().toString();
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            Log.i(TAG, text);
        });
    }
}