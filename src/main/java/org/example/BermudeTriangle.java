package org.example;

import java.awt.*;
import java.util.Random;

public class BermudeTriangle {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.addPoint(33, 9);
        polygon.addPoint(17, 4);
        polygon.addPoint(33, 41);

        Point ship = new Point();
        ship.setLocation(28, 15);
        System.out.println(polygon.contains(ship));
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                if(i == 0 || j == 0 || i  == 49 || j == 49 ){
                    System.out.print("\uD83C\uDF08");
                }else {
                    System.out.print((polygon.contains(i, j) ? "\uD83D\uDC19" : "\uD83C\uDF2B"));
                }
            }
            System.out.println();
        }
    }

    static Polygon resetWithRandomTriangle( Polygon polygon ) {
        polygon.reset();
        for(int i = 0; i < 3; i++) {
            int x = (int) (Math.random() * 50);
            int y = (int) (Math.random() * 50);
            polygon.addPoint(x, y);
        }
        return polygon;
    }

    static Polygon createRandomTriangle() {
        Polygon polygon = new Polygon();
        //polygon = resetWithRandomTriangle(polygon)
        for(int i = 0; i < 3; i++) {
            int x = (int) (Math.random() * 50);
            int y = (int) (Math.random() * 50);
            polygon.addPoint(x, y);
        }
        return polygon;
    }

}
//