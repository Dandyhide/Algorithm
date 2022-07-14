package com.company.Everyday;

import java.util.*;

/**
 * 30. 串联所有单词的子串        Difficult
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 */

public class findSubstring {
    List<Integer> list = new ArrayList<>();
    List<String> word = new ArrayList<>();
    int length;
    int len;
    int target_len;

    public List<Integer> findSubstring(String s, String[] words) {
        length = s.length();
        len = words[0].length();
        target_len = words.length * len;
        Collections.addAll(word, words);
        for(int i = 0; i <= s.length() - target_len; i++){
            execute(s.substring(i), new ArrayList<>(word));
        }
        return list;
    }

    private void execute(String s, ArrayList<String> curr_word) {
        if(curr_word.isEmpty()){
            list.add(length - s.length() - target_len);
            return;
        }
        if(s.length() < curr_word.size() * len){
            return;
        }
        String temp_s = s.substring(0, len);
        if(curr_word.contains(temp_s)){
            curr_word.remove(temp_s);
            execute(s.substring(len), curr_word);
        }
    }

    public static void main(String[] args) {
        findSubstring findSubstring = new findSubstring();
        findSubstring.findSubstring("a", new String[]{"a"});
    }
}
