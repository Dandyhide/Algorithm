package com.company.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterTest {
    public static void main(String[] args) {
        String s1 = "dfa.adsf";
        String s2 = "d*.f";
        s2 = s2.replace("*", "\\w*").replaceAll("\\.", "\\.");
        System.out.println(s2);
        Pattern p = Pattern.compile(s2);
        Matcher m = p.matcher(s1);
        if (m.find()){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }

    }
}
