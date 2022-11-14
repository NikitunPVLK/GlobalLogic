// IRobotVacuumCleanerInterface.aidl
package com.example.task1;

// Declare any non-default types here with import statements

interface IRobotVacuumCleanerInterface {
    oneway boolean subscribeOnPositionChange(IChangePositionCallback onPositionChanged);
    oneway boolean start();
    oneway boolean stop();
    oneway boolean pause();
    oneway boolean resume();
    oneway boolean returnToStation(); 
    oneway boolean changeCleaningMode(int mode);
}