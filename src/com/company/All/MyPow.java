package com.company.All;

/**
 * 50. Pow(x, n)        Medium
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == Integer.MIN_VALUE){
            return x > 1 ? 0 : 1;
        }
        boolean flag = n > 0 ? true : false;
        int m = Math.abs(n);
        String bin = GetBinary(m);
        double[] res = new double[bin.length()];
        double temp = x;
        double result = 1;
        for (int i = 0; i < bin.length(); i++){
            res[i] = temp;
            temp = temp * temp;
        }
        for (int i = 0; i < bin.length(); i++){
            if (bin.charAt(i) == '1'){
                result *= res[i];
            }
        }
        return flag ? result : 1 / result;
    }

    public String GetBinary(int n){
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int temp = n % 2;
            sb.append(temp);
            n = n / 2;
        }
        return sb.toString();
    }
}
