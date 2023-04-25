package org.example;

import java.util.Scanner;

public class Fakultät {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long in = scan.nextInt();

        if(in < 0){
            System.out.println("Number must not be negative");
        }else if(in == 0){
            System.out.println("0! = 1");
        }else {
            System.out.printf("%s! = " , in);
            long fakultät = 1;
            for (int i = 1; i <= in; i++) {
                fakultät = fakultät * i;
                if (i != in)
                    System.out.printf("%s * ", i);
                else
                    System.out.print(i);
            }
            System.out.printf(" = %s%n", fakultät);
        }
    }
}
