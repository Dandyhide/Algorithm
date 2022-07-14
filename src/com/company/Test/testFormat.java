package com.company.Test;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class testFormat {
    public static void main(String[] args) {

//        int l = 5;
//        System.out.println(String.format("%-" + l + "s", "123"));
        String str = "测试";
        try {
            byte[] buf = str.getBytes("GBK");
            System.out.println(buf.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Set<Integer> set = new HashSet<>();
    }
}
