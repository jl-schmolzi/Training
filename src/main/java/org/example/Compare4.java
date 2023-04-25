package org.example;

import java.util.Scanner;

public class Compare4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter amount of money:");
        double valueDouble = scan.nextDouble();
        int value = (int) (valueDouble * 100);
        int[] coinsInCent = {200, 100, 50, 20, 10, 5, 2, 1};
        for(int coin : coinsInCent){
            int coinsNeeded = 0;
            if(value >= coin){
                coinsNeeded = value / coin;
                value = value % coin;
            }
            if(coin >= 100){
                System.out.printf("%s X %s Liretta%n", coinsNeeded,coin/100);
            }else{
                System.out.printf("%s X %s Lirettacent%n", coinsNeeded,coin);
            }
        }
    }
}
