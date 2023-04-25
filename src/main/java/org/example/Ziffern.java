package org.example;

public class Ziffern {
    public static void main(String[] args) {
        int in = 0;
        int length = 1;
        while(in >= 10){
            in = in / 10;
            length++;
        }
        System.out.println(length);
    }
}
