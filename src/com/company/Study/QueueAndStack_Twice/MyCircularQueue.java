package com.company.Study.QueueAndStack_Twice;

public class MyCircularQueue {
    int[] res;
    int head;
    int tail;
    int capacity;
    int size;
    public MyCircularQueue(int k) {
        res = new int[k];
        head = 0;
        tail = -1;
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        size++;
        tail = (tail + 1) % capacity;
        res[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        size--;
        head = (head + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return res[head];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return res[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
