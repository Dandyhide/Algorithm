package com.company.Everyday;

import java.util.PriorityQueue;

public class MedianFinder2 {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder2() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (left.size() == 0) {
            left.add(num);
            return;
        }
        if (left.size() == right.size()){
            if (right.peek() >= num){
                left.add(num);
            }else{
                left.add(right.poll());
                right.add(num);
            }
        }else{
            if (num >= left.peek()){
                right.add(num);
            }else{
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()){
            double res = left.peek() + right.peek();
            return  res / 2;
        }else{
            return left.peek();
        }
    }
}
