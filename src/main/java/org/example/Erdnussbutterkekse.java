package org.example;

public class Erdnussbutterkekse {
    public static void main(String[] args) {
        System.out.println(kekseZählen("PSESEPESP"));
        System.out.println(kekseZählen("PPPEEESSS"));
        System.out.println(kekseZählen("SEPEPLSEE"));
    }

    static int kekseZählen(String in) {
        int count = 0;
        for (int i = 0; i < in.length() - 2; i++) {
            String current = in.substring(i, i + 3);
            System.out.println(current);
            if (current.contains("P") && current.contains("S") && current.contains("E")) {
                count++;
                i = i + 2;
            }
        }
        return count;
    }
}
