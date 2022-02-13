package com.heaboy.equalsAndHashcode;

import java.util.HashSet;

public class EAHTest {
    public static void main(String[] args) {
        HashSet<Pt> hashSet = new HashSet<>();
        Pt e1 = new Pt(3, 4);
        Pt e2 = new Pt(3, 4);
        System.out.println("e1 == e2 "+(e1 == e2));
        System.out.println("e1.equals(e2) "+e1.equals(e2));
        hashSet.add(e1);
        hashSet.add(e2);

        System.out.println(hashSet);
    }
}
