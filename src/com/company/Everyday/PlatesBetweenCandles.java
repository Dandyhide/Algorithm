package com.company.Everyday;

/**
 * 2055. 蜡烛之间的盘子        Medium
 *
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 *
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 *
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * 示例 2:
 *
 *
 *
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 *  
 *
 * 提示：
 *
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plates-between-candles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//TODO   使用前缀和解决

public class PlatesBetweenCandles {

    int[] flag;
    int k = 0;

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int qlen = queries.length;
        flag = new int[len];
        int[] result = new int[qlen];
        for (int i = 0; i < len; i++){
            if (s.charAt(i) == '|'){
                flag[k++] = i;
            }
        }
        for (int i = 0; i < qlen; i++){
            result[i] = getResult(queries[i][0], queries[i][1]);
        }
        return result;
    }

    private int getResult(int m, int n) {
        int left = 0, right = k - 1;
        int indexL = -1, indexR = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (flag[mid] > m){
                right = mid - 1;
            }else if(flag[mid] < m){
                left = mid + 1;
            }else{
                indexL = mid;
                break;
            }
        }
        indexL = indexL > 0 ? indexL : left;
        left = 0; right = k - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (flag[mid] > n){
                right = mid - 1;
            }else if(flag[mid] < n){
                left = mid + 1;
            }else{
                indexR = mid;
                break;
            }
        }
        indexR = indexR > 0 ? indexR : right;
        if (indexR > indexL){
            return flag[indexR] - flag[indexL] - (indexR - indexL);
        }
        return 0;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        platesBetweenCandles.platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}});
    }
}
