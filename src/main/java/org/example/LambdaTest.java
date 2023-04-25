package org.example;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        record City( String name, int population ) { }
        /* interface Runnable    { void run(); }
        interface ActionListener { void actionPerformed(ActionEvent e); }
        interface Supplier<T>    { T get(); }
        interface Consumer<T>    { void accept(T t); }
        interface Comparator<T>  { int compare(T o1, T o2); } */
        Runnable runnable = System.out::println;
        ActionListener listener = System.out::println;
        Supplier<String> supplier = () -> "HI";
        Consumer<Point> consumer = System.out::println;
        Comparator<Rectangle> comparator = (r1, r2) -> 0;
        DoubleSupplier ds = () -> 1.0;
        LongToDoubleFunction ltdf = l -> 2.0 * l;
        UnaryOperator<String> up = s -> s + "_";

        List<City> cityTour = new ArrayList<>();
        City g = new City( "Gotham (cathedral)", 8_000_000 );
        City m = new City( "Metropolis (pleasure garden)", 1_600_000 );
        City h = new City( "Hogsmeade (Shopping Street)", 1_124 );
        Collections.addAll( cityTour, g, m, h );
        System.out.println(cityTour);
        cityTour.removeIf( c -> c.population < 10_000);
        System.out.println(cityTour);
        cityTour.replaceAll(c -> new City("HI", c.population));
        System.out.println(cityTour);
        cityTour.forEach(c -> System.out.println(c.name + "," + c.population));
    }
}


