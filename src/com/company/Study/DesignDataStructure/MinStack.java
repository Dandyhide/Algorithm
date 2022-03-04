package com.company.Study.DesignDataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2= new LinkedList<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        if (val < stack2.peek()){
            stack2.push(val);
        }else{
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.poll();
        stack2.poll();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
