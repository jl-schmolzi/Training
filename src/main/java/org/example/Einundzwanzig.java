package org.example;

import java.util.Scanner;

public class Einundzwanzig {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Eingaben ");
        int value1 = scan.nextInt();
        System.out.print(" und ");
        int value2 = scan.nextInt();

        if(value1 == 1 || value2 == 1){
            return;
        }
        //Beide > 21
        if(value1 > 21 && value2 > 21){
            System.out.println(0);
        //Einer > 21
        }else if(value1 > 21){
            System.out.println(value2);
        }else if(value2 > 21) {
            System.out.println(value1);
        //Beide < 21 -> größerer Wert
        }else if(value1 > value2){
            System.out.println(value1);
        }else{
            System.out.println(value2);
        }
    }
}
