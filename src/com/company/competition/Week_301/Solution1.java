package com.company.competition.Week_301;

public class Solution1 {
    public boolean canChange(String start, String target) {
        start = remove(start);
        target = remove(target);
        return start.equals(target);
    }

    private String remove(String start) {
        char[] chars = start.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'L'){
                if(i > 0 && chars[i - 1] == '_'){
                    int k = i - 1;
                    while(k >= 0 && chars[k] == '_'){
                        k--;
                    }
                    chars[k + 1] = 'L';
                    chars[i] = '_';
                }

            }
        }
        for(int i = chars.length - 1; i >= 0; i--){
            if(chars[i] == 'R'){
                if(i < chars.length - 1 && chars[i + 1] == '_'){
                    int k = i + 1;
                    while (k < chars.length && chars[k] == '_'){
                        k++;
                    }
                    chars[k - 1] = 'R';
                    chars[i] = '_';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.canChange("_L__R__R_", "L______RR");
    }
}
