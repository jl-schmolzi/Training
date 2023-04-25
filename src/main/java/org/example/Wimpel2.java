package org.example;

public class Wimpel2 {

    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++){
            int start = (10 - i) / 2;
            System.out.print(" ");
            if(i == start) {
                for (int j = 1; j <= i; j++) {
                    System.out.printf("%d ", i);
                }

            }
            System.out.println("");
        }
    }
}
