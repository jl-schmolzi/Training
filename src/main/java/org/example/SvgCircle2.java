package org.example;

import java.util.Locale;
import java.util.Scanner;

public class SvgCircle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        double r = Math.random() * 10 + 10;
        System.out.printf(Locale.US, "<svg height=\"400\" width=\"1000\">%n\t<circle cx=\"%d\" cy=\"%d\" r=\"%.5f\" />%n</svg>%n", x, y, r);
    }
}
