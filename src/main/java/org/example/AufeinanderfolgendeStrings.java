package org.example;

public class AufeinanderfolgendeStrings {
    public static void main(String[] args) {
        String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
        System.out.println(isProbablyApproaching( signs1 ));  // true

        String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" };
        System.out.println(isProbablyApproaching( signs2 ));  // false);
    }

    static boolean isProbablyApproaching(String[] signs){
        int count = 1;
        String current = signs[0];
        for(int i = 1; i < signs.length; i++){
            if(current.equals(signs[i])){
                count++;
                if(count == 4) {
                    return true;
                }
            }else{
                count = 1;
                current = signs[i];
            }
        }
        return false;
    }
}
