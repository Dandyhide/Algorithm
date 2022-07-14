package com.company.Everyday;

/**
 * 745. 前缀和后缀搜索     Difficult
 *
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *  
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


//超时
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFilter {
    Map<String, List<Pair>> data;

    public WordFilter(String[] words) {
        data = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String key = words[i].substring(0, 1);
            List<Pair> list = data.containsKey(key) ? data.get(key) : new ArrayList<>();
            list.add(new Pair(words[i], i));
            data.put(key, list);
        }
    }

    public int f(String pref, String suff) {
        String key = pref.substring(0, 1);
        List<Pair> pairs = data.get(key);
        if(pairs.isEmpty()){
            return -1;
        }
        int result = -1;
        for (Pair pair : pairs) {
            String temp = pair.value;
            if(temp.startsWith(pref) && temp.endsWith(suff)){
                result = Math.max(result, pair.index);
            }
        }
        return result;
    }

    class Pair{
        String value;
        int index;
        public Pair(String value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
