package com.company.All;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串       Hrad
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//TODO    TODO  TODO    TODO    TODO    未完成

public class MinWindow {

    int min = Integer.MAX_VALUE;
    int start = -1;
    int end = -1;

    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            char temp = t.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int left = 0, right = 0;
        while (true){
            char temp = s.charAt(left);
            if (map.containsKey(temp)){
                break;
            }
            left++;
        }
        while (right < len){
            char temp = s.charAt(right);
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp) - 1);
                if (check(map)){
                    int nowLen = right - left + 1;
                    if (nowLen < min){
                        min = nowLen;
                        start = left;
                        end = right;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left++;
                    while (true){
                        char tempLeft = s.charAt(left);
                        if (map.containsKey(temp)){
                            break;
                        }
                        left++;
                    }
                }
            }
            right++;
        }

        return min > 0 ? s.substring(left, right + 1) : "";
    }

    private boolean check(Map<Character, Integer> map){
        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() > 0){
                return false;
            }
        }
        return true;
    }
}
