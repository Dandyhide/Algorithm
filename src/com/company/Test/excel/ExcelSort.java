package com.company.Test.excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcelSort {
    public static void main(String[] args) {

        String path = "C:/title.txt";

        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = null;

        List<String> all_list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {// 直接返回读取的字符串
                // 将字符串 添加到 stringBuilder中
                String key = tempString.substring(3);
                if(map.containsKey(key)){
                    map.get(key).add(tempString);
                }else{
                    List<String> temp_List = new ArrayList<>();
                    temp_List.add(tempString);
                    map.put(key, temp_List);
                }
                all_list.add(tempString);
            }
            Set<String> set = map.keySet();

            list = new ArrayList<>(set);

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1_left = o1.substring(0, 3);
                    String s1_right = o1.substring(3);
                    String s2_left = o2.substring(0, 3);
                    String s2_right = o2.substring(3);
                    if(s1_right.equals(s2_left)){
                        return s1_left.compareTo(s2_left);
                    }
                    return s1_right.compareTo(s2_right);
                }
            });
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        HashSet<String> flag_set = new HashSet<>();
        for (String s : all_list){
            String key = s.substring(3);
            if(!flag_set.contains(key)){
                List<String> temp_list = map.get(key);
                Collections.sort(temp_list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String s1_left = o1.substring(0, 3);
                        String s1_right = o1.substring(3);
                        String s2_left = o2.substring(0, 3);
                        String s2_right = o2.substring(3);
                        if(s1_right.equals(s2_left)){
                            return s1_left.compareTo(s2_left);
                        }
                        return s1_right.compareTo(s2_right);
                    }
                });
                flag_set.add(key);
                for (String s1 : temp_list) {
                    System.out.println(s1);
                }
                if(temp_list.size() > 1)
                System.out.println();
            }
        }

    }
}
