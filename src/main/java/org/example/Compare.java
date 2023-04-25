package org.example;

import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double value1 = scan.nextDouble();
        double value2 = scan.nextDouble();
        double value3 = scan.nextDouble();
        double sum = value1 + value2 + value3;
        System.out.println(sum > 100000.0);
    }
}