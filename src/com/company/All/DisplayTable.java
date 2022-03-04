package com.company.All;

import java.util.*;

public class DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        List<String> table = new ArrayList<>();
        for (List<String> order : orders) {
            if (!table.contains(order.get(2))){
                table.add(order.get(2));
            }
            if (map.containsKey(Integer.valueOf(order.get(1)))){
                Map<String, Integer> temp = map.get(Integer.valueOf(order.get(1)));
                temp.put(order.get(2), temp.getOrDefault(order.get(2), 0) + 1);
            }else{
                HashMap<String, Integer> temp = new HashMap<>();
                temp.put(order.get(2), 1);
                map.put(Integer.valueOf(order.get(1)), temp);
            }
        }
        String[] objects = ListToStringSort(table);
        table.clear();
        table.add("Table");
        for (String object : objects) {
            table.add(object);
        }
        List<List<String>> result = new ArrayList<>();
        result.add(table);
        Integer[] key =  ListToIntegerSort(map.keySet());
        for (Integer integer : key) {
            List<String> list = new ArrayList<>();
            list.add(integer+"");
            Map<String, Integer> stringIntegerMap = map.get(integer);
            for (String object : objects) {
                if (stringIntegerMap.containsKey(object)){
                    list.add(stringIntegerMap.get(object)+"");
                }else{
                    list.add("0");
                }
            }
            result.add(list);
        }
        return result;
    }

    public String[] ListToStringSort(List<String> list){
        String[] result = new String[list.size()];
        int k = 0;
        for (String s : list) {
            result[k++] = s;
        }
        Arrays.sort(result);
        return result;
    }

    public Integer[] ListToIntegerSort(Set<Integer> list){
        Integer[] result = new Integer[list.size()];
        int k = 0;
        for (Integer s : list) {
            result[k++] = s;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        List<String> table = new ArrayList<>();
        table.add("David");
        table.add("3");
        table.add("Ceviche");
        result.add(table);
        List<String> table1 = new ArrayList<>();
        table1.add("Corina");
        table1.add("10");
        table1.add("Beef Burrito");
        result.add(table1);
        List<String> table2 = new ArrayList<>();
        table2.add("David");
        table2.add("3");
        table2.add("Fried Chicken");
        result.add(table2);
        DisplayTable displayTable = new DisplayTable();
        displayTable.displayTable(result);
    }
}
