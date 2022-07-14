package com.company.Test;

public class TestD {

    static int[] basic = new int[]{150, 375, 775, 1225};        //每一级的基础价格
    static int[] price = new int[]{30,15,10,9};             //每一集每笔订单价格
    static int[] section = new int[]{0,5,20,50};

    public static void main(String[] args) {
        int num = 0;        //给定的值
        int level = getLevel(num);
        int result = basic[level] + (num - section[level]) * price[level];
    }

    //返回等级
    private static int getLevel(int num){
        return 0;
    }
}
