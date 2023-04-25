package org.example;

import java.awt.*;
import java.util.Arrays;

public class PointsArray {
    public static void main(String[] args) {
        Point[] points = { null, null, null, null };
        Point p = new Point();
        p.setLocation( 1, 2 );
        points[ 0 ] = p;
        p.setLocation( 3, 4 );
        points[ 1 ] = p;
        Point q = points[ 1 ];
        q.setLocation( 5, 6 );
        points[ 2 ] = points[ 3 ] = q;
        System.out.println( Arrays.toString( points ) );
    }
}
