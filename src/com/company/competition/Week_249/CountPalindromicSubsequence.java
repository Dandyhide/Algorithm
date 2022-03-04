package com.company.competition.Week_249;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    Set<Character> chars = new HashSet<>();
    Set<String> set = new HashSet<>();
    public int countPalindromicSubsequence(String s) {
        for (int i = 0; i < s.length(); i++){
//            if (!chars.contains())
        }
        return set.size();
    }

    private void getCount(String s, int left, int right) {
        if (left > right - 2){
            return;
        }
        if (s.charAt(left) == s.charAt(right)){
            getSubsequence(s, left, right);
        }else{
            getCount(s, left + 1, right);
            getCount(s, left, right - 1);
        }
    }

    private void getSubsequence(String s, int left, int right) {
        String l = s.charAt(left)+"";
        String r = s.charAt(right)+"";
        String temp = "";
        for (int i = left + 1; i < right; i++){
            temp = l + s.charAt(i) + r;
            if (set.contains(temp)){
                return;
            }else{
                set.add(temp);
            }
        }
    }


}
