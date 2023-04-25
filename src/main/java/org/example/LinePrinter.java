package org.example;

public class LinePrinter {
    static String line() {
        return "♥♥♥♥♥♥♥♥♥♥";
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

    static void line(int len, String s){
        int stringLength = s.length();
        int fullWrites = len / stringLength;
        int overflow = len % stringLength;
        for(int i = 0; i < fullWrites; i++){
            System.out.print(s);
        }
        for(int i = 0; i < overflow; i++){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
}
