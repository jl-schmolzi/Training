package org.example;

import java.util.Scanner;

public class Literangaben {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter quantity in liters:");
        double in = scan.nextDouble();
        if(in >= 1.0) {
            System.out.printf("approx. %d l%n", (long) in); //long da große Zahlen
        }else if(in >= 0.1){
            System.out.printf("approx. %d cl%n", (int) (in*100));
        }else{
            System.out.printf("approx. %d ml%n", (int) (in*1000));
        }
    }
}
