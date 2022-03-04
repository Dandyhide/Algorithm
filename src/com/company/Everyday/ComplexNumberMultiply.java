package com.company.Everyday;

/**
 * 537. 复数乘法
 *
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *  
 *
 * 提示：
 *
 * num1 和 num2 都是有效的复数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ComplexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        int[] a1 = getInt(num1);
        int[] a2 = getInt(num2);
        int val1 = 0, val2 = 0;
        val1 = a1[0] * a2[0] - a1[1] * a2[1];
        val2 = a1[0] * a2[1] + a1[1] * a2[0];
        return val1+"" + "+" + val2 + "" + "i";
    }

    public int[] getInt(String s){
        int[] result = new int[2];
        String val1 = s.substring(0, s.indexOf("+"));
        String val2 = s.substring(s.indexOf("+") + 1);
        result[0] = Integer.valueOf(val1);
        if (val2.contains("-")){
            result[1] = -Integer.valueOf(val2.substring(1, val2.length() - 1));
        }else{
            result[1] = Integer.valueOf(val2.substring(0, val2.length() - 1));
        }
        return result;
    }
}
