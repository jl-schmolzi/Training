package org.example;

public class Papagei {
    public static void main(String[] args) {
        System.out.println(abcz());
        System.out.println(abcz('A', 'Z'));
        System.out.println(abcz('A', 26));
    }

    static String abcz(){
        StringBuilder ret = new StringBuilder();
        for(char i = 'A'; i <= 'Z'; i++){
            ret.append(i);
        }
        return ret.toString();
    }

    static String abcz(char start, char end){
        StringBuilder ret = new StringBuilder();
        for(char i = (char) (start + 1)  ; i <= end; i++){
            ret.append(i);
        }
        return ret.toString();
    }

    static String abcz(char start, int length){
        return abcz((char) (start - 1), (char) (start + length));
    }
}
