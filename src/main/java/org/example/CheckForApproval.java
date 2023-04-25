package org.example;

public class CheckForApproval {
    public static void main(String[] args) {
        System.out.println(allTrue(true, true, true));
        System.out.println(allTrue(true));
        System.out.println(allTrue(true, false));
        System.out.println(allTrue(true, null));
//        System.out.println(allTrue());
    }

    static boolean allTrue(boolean first, boolean... values){
        if(first){
           for(boolean value : values){
               if(!value){
                   return false;
               }
           }
        }else{
            return false;
        }
        return true;
    }
}
