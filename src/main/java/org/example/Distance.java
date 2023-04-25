package org.example;

public interface Distance {
    static Distance ofMeter(int value) {
        return null;
    }

    static Distance ofKilometer(int value) {
        return null;
    }

    int meter(); //abstract Überflüssig in Interfaces

    default int kilometer(){
        return 100;
    }
}
