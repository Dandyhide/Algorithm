package com.company.competition.Week_280;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 *
 * 给你一个 正 整数数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 *
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少 还有 一颗 魔法豆的袋子）魔法豆的数目 相等 。一旦魔法豆从袋子中取出，你不能将它放到任何其他的袋子中。
 *
 * 请你返回你需要拿出魔法豆的 最少数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/removing-minimum-number-of-magic-beans
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimumRemoval {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int len = beans.length;
        long[] sum = new long[len];
        sum[0] = beans[0];
        for (int i = 1; i < len; i++){
            sum[i] = sum[i - 1] + beans[i];
        }
        double min = sum[len - 1] - sum[0] - (long)(len - 1) * (long)beans[0];
        for (int i = 1; i < len; i++){
            min = Math.min(sum[i - 1] + sum[len - 1] - sum[i] - (long)beans[i] * (long)(len - i - 1), min);
        }
        return (long) min;
    }
}
