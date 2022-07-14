package com.company.Test.Txt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class newAndOld {

    public static void main(String[] args) {
        String path_new = "C:\\temporary\\new.txt";
        String path_old = "C:\\temporary\\old.txt";

        Set<String> set = new HashSet<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(path_old);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {// 直接返回读取的字符串
                // 将字符串 添加到 stringBuilder中
                String key = tempString.substring(tempString.indexOf('"') + 1, tempString.lastIndexOf('"'));
                set.add(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(path_new);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {// 直接返回读取的字符串
                // 将字符串 添加到 stringBuilder中
                String key = tempString.substring(tempString.indexOf('"') + 1, tempString.lastIndexOf('"'));
                if(!set.contains(key)){
                    System.out.println(key);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
