package com.company.Study.QueueAndStack.Summay;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack2 {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        int n = queue1.size();
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Deque<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()){
            return -1;
        }
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        if (empty()){
            return -1;
        }
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
