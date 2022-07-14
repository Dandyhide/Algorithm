package com.company.Test.MGL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcelSort {
    public static void main(String[] args) {

        String path = "C:/excel.txt";

        List<String> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {// 直接返回读取的字符串
                // 将字符串 添加到 stringBuilder中
                list.add(tempString);
                tempString = tempString.substring(tempString.indexOf("-") + 1);
                tempString = tempString.substring(tempString.indexOf("S") + 1);
                if(isDigit(tempString)){
                    map.put(Integer.valueOf(tempString), map.getOrDefault(tempString, 0) + 1);
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Integer> set = map.keySet();
        List<Integer> sort_list = new ArrayList<>(set);
        Collections.sort(sort_list);
        ArrayList<Object> flag_list = new ArrayList<>();
        for(int i = 1; i < 3980; i++){
            if(!sort_list.contains(i)){
                System.out.println(i);
                flag_list.add(i);
            }
        }
        System.out.println("end..............");
        for(int i = 1; i < 3980; i++){
            if(!list.contains(i+"") && !list.contains("S"+i) && !list.contains("S-"+i) && !flag_list.contains(i)){
                System.out.println(i);
            }
        }
//        System.out.println(list.size());
    }

    /**
     * 使用类型转换判断是否为数字
     */
    public static boolean isDigit(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
