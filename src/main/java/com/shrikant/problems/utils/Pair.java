package com.shrikant.problems.utils;

import java.util.Objects;

public class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Pair)obj).first == this.first && ((Pair)obj).second == this.second;
    }
}
