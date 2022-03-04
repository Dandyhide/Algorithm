package com.company.Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 *
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                if (gcd(i, j) == 1){
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}
