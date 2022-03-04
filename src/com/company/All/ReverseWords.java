package com.company.All;

public class ReverseWords {
    //TODO      考虑多个空格，原地解法
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String res = "";
        for (int i = 0; i < s1.length; i++){
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < s1[i].length(); j++){
                sb.append(s1[i].charAt(j));
            }
            sb.append(" ");
            res += sb.reverse().toString();
        }
        return res.trim();
    }
}
