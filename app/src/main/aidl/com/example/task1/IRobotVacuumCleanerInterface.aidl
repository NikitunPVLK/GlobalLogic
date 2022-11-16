// IRobotVacuumCleanerInterface.aidl
package com.example.task1;

import com.example.task1.IChangePositionCallback;

interface IRobotVacuumCleanerInterface {
    boolean subscribeOnPositionChange(IChangePositionCallback onPositionChanged);
    boolean start();
    boolean stop();
    boolean pause();
    boolean resume();
    boolean returnToStation();
    /**
    * mode:
    * 0 - silent,
    * 1 - standard,
    * 2 - powerful
    */
    boolean changeCleaningMode(int mode);
}