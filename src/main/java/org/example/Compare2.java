package org.example;

import java.util.Scanner;

public class Compare2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of bottles in total?");
        int bottles = scan.nextInt();
        int bottlesCaptain = 0;
        int bolltesCrew = 0;
        bottlesCaptain  = bottles / 2;
        bolltesCrew = bottles - bottlesCaptain;
        System.out.printf("bottles for the captain: %s%n", bottlesCaptain);
        System.out.printf("bottles for the crew: %s%n", bolltesCrew);
        System.out.println("Number of crew Members?");
        int crewMembers = scan.nextInt();
        System.out.println((bolltesCrew % crewMembers) == 0);
    }
}