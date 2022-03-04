package com.company.Study.QueueAndStack.Summay;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/queue-stack/gdwjv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        String tempS = "";
        String tempN = "";
        Deque<String> stackS = new LinkedList<>();
        Deque<Integer> stackN = new LinkedList<>();
        for (char aChar : chars) {
            switch (getType(aChar)){
                case 'N':
                    tempN += aChar;
                    break;
                case 'S':
                    tempS += aChar;
                    break;
                case 'B':
                    if (!tempN.isEmpty()){
                        stackN.push(Integer.valueOf(tempN));
                        tempN = "";
                    }
                    if (!tempS.isEmpty()){
                        stackS.push(tempS);
                        tempS = "";
                    }
                    if (aChar == '['){
                        stackS.push(aChar+"");
                    }
                    if (aChar == ']'){
                        String temp = "";
                        while (!stackS.peek().equals("[")){
                            temp = stackS.pop() + temp;       //拼字符串
                        }
                        stackS.pop();       //"["出栈
                        int n = stackN.pop();
                        StringBuilder tempSb = new StringBuilder();
                        for (int i = 0; i < n; i++){
                            tempSb.append(temp);
                        }
                        stackS.push(tempSb.toString());
                    }
                    break;
            }
        }
        if (!tempS.isEmpty()){
            stackS.push(tempS);
        }
        StringBuilder result = new StringBuilder();
        while (!stackS.isEmpty()){
            result.append(stackS.removeLast());
        }
        return result.toString();
    }

    private Character getType(char aChar) {
        if (aChar >= '0' && aChar <= '9'){
            return 'N';
        }
        if (aChar == '[' || aChar == ']'){
            return 'B';
        }
        return 'S';
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
