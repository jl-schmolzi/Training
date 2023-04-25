package org.example;

public class Feuermelder extends Gerät{

    public Feuermelder(){
        on();
    }

    @Override
    public void off(){
        System.out.println("Nicht mit dem Feuermelder bitte");
    }
}
