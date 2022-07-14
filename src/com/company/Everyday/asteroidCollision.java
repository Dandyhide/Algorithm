package com.company.Everyday;

/**
 * 735. 行星碰撞        Medium
 *
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *  
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int a : asteroids){
            if(stack.isEmpty() || a > 0 || stack.peek() < 0){
                stack.push(a);
            }else{
                boolean flag = true;
                while (!stack.isEmpty()){
                    int temp = stack.pop();
                    if(temp < 0){
                        stack.push(temp);
                        flag = false;
                        break;
                    }
                    if(temp > Math.abs(a)){
                        stack.push(temp);
                        flag = false;
                        break;
                    }else if(temp == Math.abs(a)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    stack.push(a);
                }
            }
        }
        int k = stack.size();
        int[] result = new int[k];
        while (!stack.isEmpty()){
            result[--k] = stack.pop();
        }
        return result;
    }
}
