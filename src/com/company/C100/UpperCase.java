package com.company.C100;

import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ( c- 'a' >= 0 && c - 'z' <= 0){
                sb.append((char)(c-32));
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
