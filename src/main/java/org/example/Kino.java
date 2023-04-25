package org.example;

import java.awt.*;

public class Kino {
    public static void main(String[] args) {
        Point[] points = { new Point(10, 20), new Point(12, 2), new Point(44, 4) };
        System.out.println(minDistance(points, 3));
    }

    static double minDistance(Point[] points, int size){
        if(points == null || points.length == 0 || size > points.length){
            throw new IllegalArgumentException();
        }
        Point zero = new Point(0, 0);
        double distance = Double.MAX_VALUE;
        for(int i = 0; i < size; i++){
            if (points[i] == null){
                throw new IllegalArgumentException();
            }else{
                double currentDistance = zero.distance(points[i]);
                distance = Math.min(currentDistance, distance);
            }
        }
        return distance;
    }
}
