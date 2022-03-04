package com.company.Everyday;

/**
 * 838. 推多米诺        Medium
 *
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] chars = dominoes.toCharArray();
        int[] temp = new int[len + 2];
        getInt(chars, temp);
        int[] flag = new int[len];
        String oldString = "";
        String newString = getString(chars);
        while (!oldString.equals(newString)){
            oldString = newString;
            for (int i = 0; i < len; i++){
                if (temp[i + 1] == 0){
                    int val = temp[i] + temp[i + 2];
                    if (val == 2 || val == -2){
                        flag[i] = val / 2;
                    }else if (val == 1){
                        flag[i] = temp[i];
                    }else if(val == -1){
                        flag[i] = temp[i + 2];
                    }
                }
            }
            for (int i = 0; i < len; i++){
                if (flag[i] > 0){
                    chars[i] = 'R';
                }
                if (flag[i] < 0){
                    chars[i] = 'L';
                }
            }
            getInt(chars, temp);
            Arrays.fill(flag, 0);
            newString = getString(chars);
        }
        return newString;
    }

    public void getInt(char[] chars, int[] temp){
        temp[0] = 0;temp[temp.length - 1] = 0;
        for (int i = 1; i < temp.length - 1; i++){
            if (chars[i - 1] == '.'){
                temp[i] = 0;
            }else if(chars[i - 1] == 'L'){
                temp[i] = -1;
            }else{
                temp[i] = 1;
            }
        }
    }

    public String getString(char[] chars){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        pushDominoes.pushDominoes(".L.R...LR..L..");
    }
}
