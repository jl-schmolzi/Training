package org.example;

public class Tube {
    private TV tv;

    public Tube(TV tv){
        this.tv = tv;
    }
    public void on(){
        System.out.println("Röhre on");
    }

    public void off(){
        System.out.println("Röhre off");
    }
}
