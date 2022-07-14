package com.company.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test0512 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int x = 2, y = 4;
        for (int i = 0;i < x; i++){
            list.add(-1);
        }
        for (int i = 0;i < y; i++){
            list.add(1);
        }
        while(list.size() > 1){
            int size = list.size();
            Random random = new Random();
            int m = random.nextInt(size);
            int n = random.nextInt(size);
            while(n == m){
                n = random.nextInt(size);
            }
            if(list.get(m) * list.get(n) == 1){
                int temp = list.get(m);
                int k = 2, i = 0;
                while (k > 0){
                    if(list.get(i) == temp){
                        list.remove(i);
                        i = 0;
                        k--;
                    }
                }
                list.add(-1);
            }else{
                if(list.get(m) == -1){
                    list.remove(m);
                }else{
                    list.remove(n);
                }
            }
        }
        System.out.println(list.get(0));
    }
}
