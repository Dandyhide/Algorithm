package com.company.Everyday;


import java.util.*;

/**
 * 面试题 10.02. 变位词组          Medium
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List <String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = getSort(str);
            if (map.containsKey(temp)){
                map.get(temp).add(str);
            }else{
                ArrayList<String> l = new ArrayList<>();
                l.add(str);
                map.put(temp, l);
            }
        }
        List<List<String>>list  = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }

    private String getSort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }
}
