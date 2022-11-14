// IMyInterface.aidl
package com.example.task1;

// Declare any non-default types here with import statements
import com.example.task1.ICallback;

interface IMyInterface {
    oneway void doWork(int a, int b, ICallback callback);
}