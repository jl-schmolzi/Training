package org.example;

import java.util.Locale;

public class SvgCircle1 {
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        double r = Math.random() * 10 + 10;
        System.out.printf(Locale.US, "<svg height=\"400\" width=\"1000\">%n\t<circle cx=\"%d\" cy=\"%d\" r=\"%.5f\" />%n</svg>%n", x, y, r);
    }
}
