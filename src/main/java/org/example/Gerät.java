package org.example;

public class Gerät {
    private boolean isOn;
    private int watt;

    public static int numberOfElectronicDevicesSwitchedOn(Gerät... devices) {
        int count = 0;
        for (Gerät gerät : devices) {
            if (gerät.isOn) count++;
        }
        return count;
    }

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        if (watt > 0) {
            this.watt = watt;
        } else {
            throw new IllegalWattException("Was soll das denn? " +  watt + "  <= 0");
        }
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Gerät{" +
                "isOn=" + isOn +
                "Verbrauch=" + watt +
                '}';
    }
}
