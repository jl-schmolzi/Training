package org.example;

public class Überladen {
    public static void main(String[] args) {

    }

    static void line(int length){
        for(int i = 0; i < length; i++){
            System.out.print("-");
        }
        //line(length, 'c');
    }

    static void line(int length, char c){
        for(int i = 0; i < length; i++){
            System.out.print(c);
        }
    }

    static void line(String prefix, int len, char c, String suffix){
        System.out.print(prefix);
        line(len, c);
        System.out.println(suffix);
    }
}
