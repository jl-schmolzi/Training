package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public record Store(String name, Point location) {
    public static List<Store> findStoresAround(Collection<Store> stores, Point center) {
        class CenterComparator implements Comparator<Store> {

            @Override
            public int compare(Store o1, Store o2) {
                double d1 = center.distance(o1.location);
                double d2 = center.distance(o2.location);
                return Double.compare(d1, d2);
            }
        }
        List<Store> stores1 = new ArrayList<>(stores);
        stores1.sort(new CenterComparator());
        return stores1;
    }

    public static void main(String[] args) {
        Store s1 = new Store("ALDI", new Point(10, 10));
        Store s2 = new Store("LIDL", new Point(90, 80));
        Store s3 = new Store("REWE", new Point(51, 51));
        List<Store> list = Arrays.asList(s1, s2, s3);
        System.out.println(list);
        List<Store> around = findStoresAround(list, new Point(50, 50));
        System.out.println(around);
    }
}
