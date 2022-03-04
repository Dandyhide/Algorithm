package com.company.Study.Hash;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while (left < s.length()){
            while (right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);
            if (right == s.length()){
                right--;
            }
            while (left < s.length() && s.charAt(left) != s.charAt(right)){
                set.remove(s.charAt(left));
                left++;
            }
            set.remove(s.charAt(left));
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
    }
}
