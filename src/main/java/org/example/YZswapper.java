package org.example;

public class YZswapper {
    public static void main(String[] args) {
        printSwappedYZ("yootaxz");
        printSwappedYZ2("yootaxz");
        printSwappedYZ("Yanthoxzl");
        printSwappedYZ2("Yanthoxzl");
    }

    static void printSwappedYZ2(String in){
        for(int i = 0; i < in.length(); i++){
            char c = in.charAt(i);
            c = switch (c){
                case 'y' -> 'z';
                case 'z' -> 'y';
                case 'Z' -> 'Y';
                case 'Y' -> 'Z';
                default -> c;
            };
            System.out.print(c);
        }
        System.out.println();
    }

    static void printSwappedYZ(String in){
        for(int i = 0; i < in.length(); i++){
            char c = in.charAt(i);
            if(c == 'y'){
                c = 'z';
            }else if(c == 'z'){
                c = 'y';
            }else if(c == 'Y'){
                c = 'Z';
            }else if(c == 'Z'){
                c = 'Y';
            }
            System.out.print(c);
        }
        System.out.println();
    }
}
