package com.company.Study.DesignDataStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int temp = queue1.poll();
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return temp;
    }

    /** Get the top element. */
    public int top() {
        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int temp = queue1.peek();
        queue2.offer(queue1.poll());
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
