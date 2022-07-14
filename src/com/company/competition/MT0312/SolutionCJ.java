package com.company.competition.MT0312;

import java.util.Scanner;

public class SolutionCJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int[] flag = new int[n];        //负数下表数组
        int k = 0;
        for (int i : arr) {
            if (i == -1){
                flag[k++] = i;
            }
        }
        int result = 0;
        for (int i = 0; i < k; i = i + 2){      //-1的个数为偶数时乘积为正。遍历0-2-4...
            if (i == 0){
                result += n - k;
            }
            result += getResult(flag, i, k, n);
        }
        System.out.println(result);
    }

    private static int getResult(int[] flag, int count, int k, int n) {
        int result = 0;
        for (int i = 0; i <= k - count; i++){
            int countLeft = flag[i] - (i > 0 ? flag[i - 1] - 1 : 0) + 1;
            int countRight = (i + count >= k ? n : flag[i + count] - 1) - flag[i + count - 1] + 1;
            result += countLeft * countRight;
        }
        return result;
    }
}
