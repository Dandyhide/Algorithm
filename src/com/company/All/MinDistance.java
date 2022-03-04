package com.company.All;

/**
 * 72. 编辑距离     Hard
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            result[i][0] = i;
        }
        for (int i = 0; i <= n; i++){
            result[0][i] = i;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    result[i][j] = result[i - 1][ j - 1];
                }else{
                    int temp = Math.min(result[i - 1][j], result[i][j - 1]);
                    result[i][j] = Math.min(temp, result[i - 1][j - 1]) + 1;
                }
            }
        }
        return result[m][n];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        minDistance.minDistance("horse", "ros");
    }
}
