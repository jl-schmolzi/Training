package org.example;

import java.util.Scanner;

public class SummingCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        while(true){
            int in = scan.nextInt();
            if(in == 0){
                break;
            }
            sum += in;
        }
    }
}
