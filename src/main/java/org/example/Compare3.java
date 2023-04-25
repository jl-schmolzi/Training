package org.example;

import java.util.Scanner;

public class Compare3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int value1 = scan.nextInt() % 100;
        int value2 = scan.nextInt() % 100;

        int firstDigitValue1 = value1 / 10;
        int firstDigitValue2 = value2 / 10;

        int secondDigitValue1 = value1 % 10;
        int secondDigitValue2 = value2 % 10;

        System.out.println((firstDigitValue1 == firstDigitValue2) ||
                (firstDigitValue1 == secondDigitValue2) ||
                (secondDigitValue1 == firstDigitValue2) ||
                (secondDigitValue1 == secondDigitValue2));
    }
}