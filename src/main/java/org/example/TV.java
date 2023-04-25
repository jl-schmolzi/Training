package org.example;

public class TV extends Gerät{

    private Tube tube;

    public TV() {
        tube = new Tube(this);
    }

    @Override
    public void on() {
        System.out.println("TV on");
        super.on();
        tube.on();
    }

    @Override
    public void off() {
        super.off();
        System.out.println("TV off");
        tube.off();
    }

    @Override
    public String toString() {
        return "TV{" +
                "tube=" + tube +
                super.toString() +
                '}';
    }
}
