package org.example;

import java.util.Optional;

public enum CandyType {
    CARAMELS(9),
    CHOCOLATE(5),
    GUMMIES(4),
    LICORICE(3),
    LOLLIPOPS(2),
    CHEWINGGUMS(3),
    COTTONCANDY(1);

    private int addictiveQuality;

    CandyType(int addictiveQuality) {
        this.addictiveQuality = addictiveQuality;
    }

    public static CandyType fromName(String input){
        return switch(input.toLowerCase()){
            case "caramels" -> CARAMELS;
            case "gummies" -> GUMMIES;
            case "licorice" -> LICORICE;
            case "lollipops" -> LOLLIPOPS;
            case "chewinggums" -> CHEWINGGUMS;
            case "cottoncandy" -> COTTONCANDY;
            default -> null;
        };
    }

    public static Optional<CandyType> fromNameOpt(String input){
        return switch(input.toLowerCase()){
            case "caramels" -> Optional.of(CARAMELS);
            case "gummies" -> Optional.of(GUMMIES);
            case "licorice" -> Optional.of(LICORICE);
            case "lollipops" -> Optional.of(LOLLIPOPS);
            case "chewinggums" -> Optional.of(CHEWINGGUMS);
            case "cottoncandy" -> Optional.of(COTTONCANDY);
            default -> Optional.empty();
        };
    }

    public int addictiveQuality(){
        return addictiveQuality;
    }
//    public static Optional<CandyType> fromName(String input){
//        return switch(input.toLowerCase()){
//            case "caramels" -> CARAMELS;
//            case "gummies" -> GUMMIES;
//            case "licorice" -> LICORICE;
//            case "lollipops" -> LOLLIPOPS;
//            case "chewinggums" -> CHEWINGGUMS;
//            case "cottoncandy" -> COTTONCANDY;
//            default -> null;
//        };
//    }

    public CandyType next(){
        return switch(addictiveQuality){
            case 1 -> LOLLIPOPS;
            case 2 -> (Math.random() * 2 >= 1.0) ? CHEWINGGUMS : LICORICE;
            case 3 -> GUMMIES;
            case 4 -> CHOCOLATE;
            case 5 -> CARAMELS;
            case 9 -> CARAMELS;
            default -> COTTONCANDY;
        };
    }
    public static CandyType random(){
        int rnd = (int) Math.floor(Math.random() * 6);
        return switch(rnd){
            case 0 -> CARAMELS;
            case 1 -> GUMMIES;
            case 2 -> LICORICE;
            case 3 -> LOLLIPOPS;
            case 4 -> CHEWINGGUMS;
            case 5 -> COTTONCANDY;
            default -> null;
        };
    }
}
