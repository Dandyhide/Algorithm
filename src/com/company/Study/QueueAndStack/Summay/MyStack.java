package com.company.Study.QueueAndStack.Summay;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()){
            return -1;
        }
        if (queue1.size() == 1){
            return queue1.remove();
        }
        if (queue1.size() > 1){
            while (queue1.size() > 1){
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
        while (!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }
        return pop();
    }

    /** Get the top element. */
    public int top() {
        int temp = pop();
        queue1.add(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
