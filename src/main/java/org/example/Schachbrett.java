package org.example;

import java.util.Scanner;

public class Schachbrett {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("width:");
        int width = scan.nextInt();
        System.out.println("height:");
        int height = scan.nextInt();
        char start = ' ';
        for(int i = 0; i < height; i++){
            start = (i % 2 == 0) ? '_'  : '#';
            for(int j = 0; j < width; j++){
                if(i % 2 == 0)
                    System.out.print((j % 2 == 0 ? '_' : '#'));
                else
                    System.out.print((j % 2 == 0 ? '#' : '_'));
            }
            System.out.println("");
        }
    }
}
