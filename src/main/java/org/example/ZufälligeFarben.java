package org.example;

public class ZufälligeFarben {

    public static void main(String[] args) {
        double rand = Math.random() * 3;
        String colour = "";
        if(rand < 1.0){
            colour = "red";
        }else if(rand < 2.0){
            colour = "green";
        }else{
            colour = "blue";
        }
        System.out.println(colour);
    }
}
