package org.example;

public class RadioApp {
    public static void main(String[] args) {
        Radio grandmasOldRadio = new Radio();
        System.out.println( grandmasOldRadio.isOn() );     // false
        grandmasOldRadio.on();
        System.out.println( grandmasOldRadio.isOn() );     // true
        System.out.println( grandmasOldRadio.getVolume() );     // 0
        grandmasOldRadio.volumeUp();
        grandmasOldRadio.volumeUp();
        grandmasOldRadio.volumeDown();
        grandmasOldRadio.volumeUp();
        System.out.println( grandmasOldRadio.getVolume());     // 2
        System.out.println( grandmasOldRadio.toString() ); // Radio[volume=2, is on]
        System.out.println( grandmasOldRadio );            // Radio[volume=2, is on]
        grandmasOldRadio.off();
        System.out.println(grandmasOldRadio.stationNameToFrequency(null));
        System.out.println(grandmasOldRadio.stationNameToFrequency("Walking the Plank"));
        grandmasOldRadio.setModulation(Radio.Modulation2.FM);
        System.out.println(grandmasOldRadio);
    }
}
