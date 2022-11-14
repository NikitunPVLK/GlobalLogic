// IChangePositionCallback.aidl
package com.example.task1;

// Declare any non-default types here with import statements

interface IChangePositionCallback {
    oneway void onPositionChanged(int x, int y);
}