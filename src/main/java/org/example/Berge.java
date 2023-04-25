package org.example;

public class Berge {
    public static void main(String[] args) {
        printMountain(new int[]{0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0});
    }

    static void printMountain(int[] altitudes) {
        int maxAltitude = 0;
        int minAltitude = Integer.MAX_VALUE;
        for (int altitude : altitudes) {
            maxAltitude = Math.max(altitude, maxAltitude);
            minAltitude = Math.min(altitude, minAltitude);
        }

        for (int currentAltitude = maxAltitude; currentAltitude >= minAltitude; currentAltitude--) {
            System.out.print(currentAltitude + ": ");
            for (int altitude : altitudes) {
                System.out.print(altitude == currentAltitude ? "*" : " ");
            }
            System.out.println();
        }
    }

    static void printMountain2(int[] altitudes) {
        int maxAltitude = 0;
        int minAltitude = Integer.MAX_VALUE;
        for (int altitude : altitudes) {
            maxAltitude = Math.max(altitude, maxAltitude);
            minAltitude = Math.min(altitude, minAltitude);
        }
        for (int currentAltitude = maxAltitude; currentAltitude >= minAltitude; currentAltitude--) {
            System.out.print(currentAltitude + ": ");
            for (int i = 0; i < altitudes.length; i++) {
                if (currentAltitude == altitudes[i]) {
                    int current = altitudes[i];
                    int left = -1;
                    int right = -1;
                    if (i != 0) {
                        left = altitudes[i - 1];
                    }
                    if (i != altitudes.length - 1) {
                        right = altitudes[i + 1];
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
