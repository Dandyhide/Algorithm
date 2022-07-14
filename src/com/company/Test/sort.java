package com.company.Test;

import java.util.*;

public class sort {
    public static void main(String[] args) {
        String[] s = new String[]{"fanhai", "gaoyu", "guo", "he", "huang", "jia", "liu", "lu", "sheng", "shao", "sun", "wang", "yang", "zhang"};
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++){
            System.out.println(i+1 + "  " + s[i]);
        }
    }
}
