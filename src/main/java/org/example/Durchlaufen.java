package org.example;

public class Durchlaufen {

    public static void main(String[] args) {
        double t = Math.random() * 10;
        double upperLimit = 1;
        double lowerLimit = 0;
        while (t > lowerLimit) {
            t = (t < 1) ? t * 2 : t - 1;
            System.out.println(t);
        }
    }
}
