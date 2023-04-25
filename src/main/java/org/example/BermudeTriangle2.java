package org.example;

import java.awt.*;

public class BermudeTriangle2 {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.addPoint(33, 9);
        polygon.addPoint(17, 4);
        polygon.addPoint(33, 41);

        Point ship = new Point();
        ship.setLocation(28, 15);
        System.out.println(polygon.contains(ship));
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Point current = new Point(i, j);
                if (polygon.contains(current)) {
                    if (!(polygon.contains(i - 1, j - 1)) ||
                            !(polygon.contains(i - 1, j)) ||
                            !(polygon.contains(i - 1, j + 1)) ||
                            !(polygon.contains(i, j - 1)) ||
                            !(polygon.contains(i, j + 1)) ||
                            !(polygon.contains(i + 1, j - 1)) ||
                            !(polygon.contains(i + 1, j)) ||
                            !(polygon.contains(i + 1, j + 1))) {
                        System.out.print("\uD83C\uDF08");
                    }else{
                        System.out.print("\uD83D\uDC19");
                    }
                }else{
                    System.out.print("\uD83C\uDF2B");
                }
            }
            System.out.println();
        }
    }
}
