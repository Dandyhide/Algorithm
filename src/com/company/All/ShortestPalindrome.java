package com.company.All;

/**
 * 214. 最短回文串       Hard
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aacecaaa"
 * 输出："aaacecaaa"
 * 示例 2：
 *
 * 输入：s = "abcd"
 * 输出："dcbabcd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        char temp = s.charAt(0);
        int i;
        for (i = s.length() - 1; i > 0; i--){
            if (s.charAt(i) == temp){
                if (check(s, i)){
                    break;
                }
            }
        }
        return getResult(s, i);
    }

    private boolean check(String s, int i) {
        int left = 0, right = i;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private String getResult(String s, int i){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(i + 1));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}
