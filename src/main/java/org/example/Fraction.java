package org.example;

import java.math.BigInteger;

public class Fraction extends Number implements Comparable{
    public final int numerator;
    public final int denumerator;

    public Fraction(int value){
        numerator = value;
        denumerator = 1;
    }
    public Fraction(int numerator, int denumerator) {
        if (denumerator == 0) {
            throw new IllegalArgumentException("denum is zero");
        }
        if (numerator < 0 && denumerator < 0) {
            numerator *= -1;
            denumerator *= -1;
        }
        BigInteger gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denumerator));
        this.numerator = numerator / gcd.intValue();
        this.denumerator = denumerator / gcd.intValue();
    }

    public Fraction multiply(Fraction frac1, Fraction frac2){
        long numer = (long) frac1.numerator * frac2.numerator;
        long denumer = (long) frac1.denumerator * frac2.denumerator;
        if(numer > Integer.MAX_VALUE || denumer > Integer.MAX_VALUE){
            throw new ArithmeticException("OVERFLOW IN MULTIPLY");
        }
        return new Fraction((int) numer, (int) denumer);
    }

    public Fraction reciprocal(){
        return new Fraction(denumerator, numerator);
    }


    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return (float) (1.0 * numerator / denumerator);
    }

    @Override
    public double doubleValue() {
        return (1.0 * numerator / denumerator);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Fraction f){
            return Double.compare(this.doubleValue(), f.doubleValue());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denumerator == fraction.denumerator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denumerator;
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denumerator;
    }
}
