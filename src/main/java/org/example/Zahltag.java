package org.example;

import java.util.Scanner;

public class Zahltag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double in = scan.nextDouble();
        double minPercent = 0.9;
        double maxPercent = 1.2;
        int payValue = 1000;
        double minimalValue = minPercent * payValue;
        double maximalValue = maxPercent * payValue;
        if(in >= minimalValue && in <= maximalValue)
            System.out.println("Good boy!");
        else
            System.out.println("You son of a bi***!");
    }
}
