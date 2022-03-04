package com.company.Test;

import java.util.PriorityQueue;

public class Test0902 {
    public static void main(String[] args) {
        PriorityQueue<Integer> objects = new PriorityQueue<>((a, b) -> b - a);
    }
}
