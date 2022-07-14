package com.company.Test;

import java.util.HashSet;

public class SetArray {
    public static void main(String[] args) {
        HashSet<int[]> set = new HashSet<>();
        set.add(new int[]{1,2,3});
        set.add(new int[]{2,3,4});
        System.out.println(set.contains(new int[]{1,2,3}));
    }
}
