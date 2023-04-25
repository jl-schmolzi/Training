package org.example;

public class Radio extends Gerät{
    private int volume;
    private boolean isOn;
    private double frequency;
    private Modulation2 modulation = Modulation2.AM;
    public Radio(double frequency){
        this.frequency = frequency;
    }

    public Radio() {

    }

    public Radio(String name){
//        frequency = stationNameToFrequency(name);
        this(stationNameToFrequency(name));
    }

    public Radio(Radio radio){
        frequency = radio.getFrequency();
        volume = radio.getVolume();
        isOn = radio.isOn();
        modulation = radio.getModulation();
    }

    public Modulation2 getModulation() {
        return modulation;
    }

    public void setModulation(Modulation2 modulation) {
        if(modulation != null)
            this.modulation = modulation;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void on(){
        setOn(true);
    }

    public void off(){
        setOn(false);
    }

    public void volumeUp(){
        if(volume < 100)
            volume++;
    }
    public void volumeDown(){
        if(volume > 0 ){
            volume--;
        }
    }

    @Override
    public String toString() {
        return "Radio[" +
                "volume=" + volume +
                "frequency=" + frequency + modulation +
                super.toString() +
                ']';
    }

    static double stationNameToFrequency(String stationName){
        if(stationName == null){
            return 0.0;
        }
        return switch(stationName){
            case "Walking the Plank" -> 98.3;
            default -> 0.0;
        };
    }

    public enum Modulation2{
        AM, FM
    }
}
