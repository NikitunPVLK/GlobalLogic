// ICallback.aidl
package com.example.task1;

// Declare any non-default types here with import statements

interface ICallback {
    oneway void onDataReady(int data);
}