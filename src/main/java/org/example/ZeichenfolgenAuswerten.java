package org.example;

import java.util.Scanner;

public class ZeichenfolgenAuswerten {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String out = switch(input){
            case "ay", "aye", "ay, ay", "ja", "joo" -> "Keep it up!";
            default -> "Don’t you dare!";
        };
        System.out.println(out);
    }
}
