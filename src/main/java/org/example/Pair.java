package org.example;

public class Pair {

    public Double first;
    public Double second;


    public Pair(Double first, Double second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
