package com.company.Everyday;

/**
 * 541. 反转字符串 II        simple
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReverseStr {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int temp = s.length() / (2 * k);
        for (int i = 0; i < temp * 2 * k; i = i + 2 * k){
            sb.append(reverseSubStr(s.substring(i, i + 2 * k), k));
        }
        if (s.length() % (2 * k) > 0){
            sb.append(reverseSubStr(s.substring(temp * 2 * k), k));
        }
        return sb.toString();
    }

    public String reverseSubStr(String s, int k){
        StringBuilder sb = new StringBuilder();
        if (s.length() <= k){
            return sb.append(s).reverse().toString();
        }else{
            sb.append(s.substring(0, k));
            sb.reverse();
            sb.append(s.substring(k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        reverseStr.reverseStr("abcdefg", 2);
    }
}
