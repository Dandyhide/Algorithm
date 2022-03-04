package com.company.Study.DesignDataStructure;

import java.util.Arrays;

/**
 * 面试题 03.01. 三合一
 *
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *  
 *
 * 提示：
 *
 * 0 <= stackNum <= 2
 *
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/designing-data-structures/ru3fuj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class TripleInOne {
    int[] arr;
    int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize*3];
        Arrays.fill(arr, -1);
    }

    public void push(int stackNum, int value) {
        if (stackSize == 0){
            return;
        }
        if (arr[stackNum * stackSize + stackSize - 1] != -1){
            return;
        }
        int i = stackNum * stackSize + stackSize - 1;
        while (i >= stackNum * stackSize &&  arr[i] == -1){
            i--;
        }
        for (; i >= stackNum * stackSize; i--){
            arr[i + 1] = arr[i];
        }
        arr[stackNum * stackSize] = value;
    }

    public int pop(int stackNum) {
        if (stackSize == 0){
            return -1;
        }
        int res = arr[stackNum * stackSize];
        if (res != -1){
            int i = stackNum * stackSize + 1;
            while (i < (stackNum + 1 ) * stackSize && arr[i] != -1){
                arr[i - 1] = arr[i];
                i++;
            }
            arr[i - 1] = -1;
        }
        return res;
    }

    public int peek(int stackNum) {
        if (stackSize == 0){
            return -1;
        }
        return arr[stackNum * stackSize];
    }

    public boolean isEmpty(int stackNum) {
        if (stackSize == 0){
            return true;
        }
        return arr[stackNum * stackSize] == -1;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);
        tripleInOne.pop(0);
    }
}


















