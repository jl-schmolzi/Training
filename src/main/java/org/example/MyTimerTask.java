package org.example;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    public static final int TEN_MB = 10_000_000;

    @Override
    public void run() {
        long freeDiskSpace = java.io.File.listRoots()[0].getFreeSpace();
        if(freeDiskSpace < TEN_MB){
            System.out.println("ACHTUNG SPEICHER");
        }
    }
}
