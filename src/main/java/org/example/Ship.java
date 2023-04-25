package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Ship {
    private ArrayList<Gerät> geräte = new ArrayList<Gerät>();
    private static final int MAXIMUM_POWER_COMSUMPTION = 100;

    public Gerät findMostPowerConsumingElectronicDevice() {
        return java.util.Collections.max(geräte, new GerätWattVergleich());
    }

    public void load(Gerät gerät) {
        Objects.requireNonNull(gerät);
        if (gerät instanceof Radio radio) {
            if (radio.getVolume() > 0) {
                geräte.add(radio);
            }
        } else {
            geräte.add(gerät);
        }
        geräte.sort(new GerätWattVergleich());
    }

    public void holiday() {
        for (Gerät gerät : geräte) {
            gerät.off();
        }
    }

    public void removePowerConsumingElectronicDevices() {
        class consumesTooMuch implements java.util.function.Predicate<Gerät> {
            @Override
            public boolean test(Gerät o) {
                return o.getWatt() > MAXIMUM_POWER_COMSUMPTION;
            }
        }

        geräte.removeIf(new consumesTooMuch());

    }
}
