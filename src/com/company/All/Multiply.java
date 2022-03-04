package com.company.All;

/**
 * 43. 字符串相乘            Medium
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.Arrays;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length() + 2];
        char[] m = num1.toCharArray();
        char[] n = num2.toCharArray();
        for (int i = n.length - 1; i >= 0; i--){
            String mul = getMul(n[i], num1);
            AddArraysAndString(res, GetReverseRes(mul), n.length - i - 1);
        }
        return GetReverseRes(res);
    }

    private void AddArraysAndString(int[] res, String mul, int k) {
        int array = 0;
        for (int i = 0; i < mul.length(); i++){
            int temp = res[k + i] + array + (mul.charAt(i) - '0');
            res[k + i] = temp % 10;
            array = temp / 10;
        }
        if (array != 0){
            res[k + mul.length()] += array;
        }
    }

    public String getMul(char m, String n){
        n = GetReverseRes(n);
        int[] res = new int[n.length() + 1];
        Arrays.fill(res, 0);
        char[] chars = n.toCharArray();
        int array = 0;
        for (int i = 0; i < chars.length; i++){
            int temp = (m - '0') * (chars[i] - '0');
            res[i]= (temp % 10 + array) % 10;
            array = (temp % 10 + array) / 10 + temp / 10;
        }
        res[res.length - 1] = array;
        return GetReverseRes(res);
    }

    private String GetReverseRes(int[] res) {
        StringBuilder sb = new StringBuilder();
        int k = res.length - 1;
        while (k >= 0 && res[k] == 0){
            k--;
        }
        for (int i = 0; i <= k; i++){
            sb.append(res[i]);
        }
        return sb.reverse().toString();
    }

    private String GetReverseRes(String res){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length(); i++){
            sb.append(res.charAt(i));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("12", "308"));
    }
}
