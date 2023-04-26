package org.example;

import java.text.NumberFormat;
import java.util.*;

public class Receipt {
    static class Item {
        public String name;
        public int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (price != item.price) return false;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + price;
            return result;
        }
    }

    private List<Item> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }


    public String toString() {
        StringBuilder ret = new StringBuilder();
        int sum = 0;
        Set<Item> toPrint = new HashSet<>(items);
        for(Item item : toPrint){
            int nrOfItem = Collections.frequency(items, item);
            ret.append(String.format("%d %s %d %d%n", nrOfItem, item.name, item.price, item.price * nrOfItem));
            sum += item.price * nrOfItem;
        }
        ret.append(String.format("Gesamt: %d", sum));
        return ret.toString();
    }
}
