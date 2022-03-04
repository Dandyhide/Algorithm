package com.company.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test08313 {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            String temp = sc.next();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        sc.close();
        System.out.println(map.get("张三"));
    }
}
