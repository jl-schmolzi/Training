package org.example;

public class RightTriangle {
    public static boolean isRightTriangle( double a, double b, double c ) {
        return ((a * a + b * b) == c * c) ||
                ((a * a + c * c) == b * b) ||
                ((b * b + c * c) == a * a);
    }
}
