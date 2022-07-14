package com.company.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {

    public static void main(String[] args) {
        Integer[] arr = {};
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
    }

}
