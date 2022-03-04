package com.company.All;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号       Hard
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
