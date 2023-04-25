package org.example;

public class RemoveVowel {
    public static void main(String[] args) {
        System.out.println(removeVowel("Hallo Javanesen"));
        System.out.println(removeVowel("BE NICE"));
        System.out.println(removeVowel2("Hallo Javanesen"));
        System.out.println(removeVowel2("BE NICE"));
    }

    //init empty -> input all but vowels
    static String removeVowel(String in){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < in.length(); i++){
            ret.append(switch (in.charAt(i)){
                    case 'A', 'Ä', 'E', 'I', 'O', 'Ö', 'U', 'Ü', 'Y',
                            'a', 'ä', 'e', 'i', 'o', 'ö', 'u', 'ü', 'y'-> "";
                    default -> in.charAt(i);
            });
        }
        return ret.toString();
    }

    //init with input -> delete vowels
    static String removeVowel2(String in){
        StringBuilder ret = new StringBuilder(in);
        int count = 0;
        for(int i = 0; i < in.length(); i++){
            if (isVowel(in, i)) {
                ret.deleteCharAt(i - count);
                count++;
            }
        }
        return ret.toString();
    }

    private static boolean isVowel(String in, int i) {
        return (in.charAt(i) == 'A') || (in.charAt(i) == 'Ä') || (in.charAt(i) == 'E') || (in.charAt(i) == 'I') || (in.charAt(i) == 'O') || (in.charAt(i) == 'Ö') || (in.charAt(i) == 'U') || (in.charAt(i) == 'Ü') || (in.charAt(i) == 'Y') || (in.charAt(i) == 'a') || (in.charAt(i) == 'ä') || (in.charAt(i) == 'e') || (in.charAt(i) == 'i') || (in.charAt(i) == 'o') || (in.charAt(i) == 'ö') || (in.charAt(i) == 'u') || (in.charAt(i) == 'ü') || (in.charAt(i) == 'y');
    }
}
