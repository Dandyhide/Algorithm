package com.company.Test;

import java.util.Map;
import java.util.Set;

public class TestNullMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        String s = "";
    }
}
