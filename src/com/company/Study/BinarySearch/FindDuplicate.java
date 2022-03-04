package com.company.Study.BinarySearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{2, 3, 3, 5, 4}));
    }
}
