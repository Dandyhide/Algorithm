package com.company.Test;

/**
 * 将每个单词首字母大写
 */

public class Test1 {
    public static void main(String[] args) {
        String s = "  i    am   a    Boy   ";
        String newS = s.trim();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        boolean flag = true;
        while (k < newS.length()){
            if (flag && newS.charAt(k) != ' '){
                sb.append((newS.charAt(k)+"").toUpperCase());
                flag = false;
            }else{
                if (!flag && newS.charAt(k) == ' '){
                    flag = true;
                }else{
                    sb.append(newS.charAt(k));
                }
            }
            k++;
        }
        System.out.println(sb.toString());
    }
}
