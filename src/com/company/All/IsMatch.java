package com.company.All;

import java.util.Scanner;

/**
 * 44. 通配符匹配        Hard
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] flag = new boolean[m + 1][n + 1];
        flag[0][0] = true;
        for (int i = 1; i <= m; i++){
            flag[i][0] = false;
        }
        for (int j = 1; j <= n; j++){
            flag[0][j] = flag[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                char tempS = s.charAt(i - 1);
                char tempP = p.charAt(j - 1);
                if (tempP == '?' || tempS == tempP){
                    flag[i][j] = flag[i - 1][j - 1];
                }else if(tempP == '*'){
                    flag[i][j] = flag[i - 1][j] || flag[i][j - 1];
                }else{
                    flag[i][j] = false;
                }
            }
        }
        return flag[m][n];
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(123);
        sb.setLength(0);
        System.out.println(sb.toString());
//        IsMatch isMatch = new IsMatch();
//        isMatch.isMatch("aa", "*");
    }
}
