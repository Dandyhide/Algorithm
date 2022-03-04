package com.company.All;

/**
 * 22. 括号生成     Medium
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class GenerateParenthesis {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        getDeque(n, n, new StringBuilder());
        return list;
    }

    public void getDeque(int left, int right, StringBuilder sb){
        if (left < 0 || right < 0 || left > right){
            return;
        }
        if (left == 0){
            for (int i = right; i > 0; i--){
                sb.append(')');
            }
            list.add(sb.toString());
            for (int i = right; i > 0; i--){
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }
        if (left == right){
            sb.append('(');
            getDeque(left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right){
            sb.append('(');
            getDeque(left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            getDeque(left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
