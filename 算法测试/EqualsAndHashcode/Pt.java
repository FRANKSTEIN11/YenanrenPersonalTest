package com.heaboy.equalsAndHashcode;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Pt {
    int x, y;

    public Pt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pt pt = (Pt) o;
        return x == pt.x && y == pt.y;
        LinkedHashMap
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
