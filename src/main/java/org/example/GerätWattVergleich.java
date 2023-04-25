package org.example;

public class GerätWattVergleich implements java.util.Comparator<Gerät>{
    @Override
    public int compare(Gerät o1, Gerät o2) {
        int o1Watt = o1.getWatt();
        int o2Watt = o2.getWatt();
        return Integer.compare(o1Watt, o2Watt);
//        if(o1Watt < o2Watt){
//            return -1;
//        }else if(o1Watt > o2Watt){
//            return 1;
//        }else{
//            return 0;
//        }
    }
}
