package com.company.Everyday;

import java.util.ArrayList;
import java.util.List;

public class ProfitableSchemes {

    int res = 0;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        check(0, n, minProfit,0, group, profit);
        return res;
    }

    public void check(int sum,int n, int minProfit, int k, int[] group, int[] profit){
        if (n < 0){
            return;
        }
        if (sum >= minProfit && k == group.length){
            res = (res + 1) % 1000000007;
            return;
        }
        if (k >= group.length){
            return;
        }
        check(sum + profit[k], n - group[k], minProfit, k + 1, group, profit);
        check(sum, n, minProfit, k + 1, group, profit);
    }

    public static void main(String[] args) {
        ProfitableSchemes profitableSchemes = new ProfitableSchemes();
        profitableSchemes.profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8});
    }

}
