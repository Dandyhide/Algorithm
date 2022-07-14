package com.company.competition.MT0312;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这题就算求最佳的跳跃策略，那每次的目标肯定的n个房间中最后出现的那个
 */

public class Solution1 {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        //上面为输入
        int result = 0;
        int key = 1;                            //用于记录跳跃的房间号，初始为1，因为一号房一开始没有炸弹
        boolean[] flag = new boolean[n + 1];    //用于记录房间的出现情况
        int i = 0;
        while (i < m){
            if (arr[i] == key){
                result++;
                while (i < m){
                    flag[arr[i]] = true;        //记录出现的附件号
                    if(check(flag)){            //如果是最后一个，进行处理
                        key = arr[i];
                        Arrays.fill(flag, false);
                        break;
                    }
                    i++;
                }
            }
            i++;
        }
        System.out.println(result);
    }

    private static boolean check(boolean[] flag){
        for (int i = 1; i < flag.length; i++){
            if (!flag[i]){
                return false;
            }
        }
        return true;
    }
}
