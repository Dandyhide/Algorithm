package com.company.Test;

public class TestNK {
    public static void main(String[] args){
        int b = 15;
        for(int i = 1; i <= 300; i++){
            int num = i * i;
            String temp = getB(num, b);
            if(check(temp)){
                System.out.println(i + " " + temp);
            }
        }
    }

    public static String getB(int i, int b){
        StringBuilder sb = new StringBuilder();
        while(i > 0){
            int temp = i % b;
            i = i / b;
            if(temp >= 10){
                char c = (char)((temp - 10) + 'A');
                sb.append(c);
            }else{
                sb.append(temp);
            }
        }
        return sb.reverse().toString();
    }

    public static boolean check(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
