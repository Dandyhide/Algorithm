package com.company.Study.Hash;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {
    private LinkedList[] set;
    private static final int size = 769;
    public MyHashSet() {
        set = new LinkedList[size];
        for (int i = 0; i < size; i++){
            set[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = getHash(key);
        Iterator<Integer> iterator = set[hash].iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (key == next){
                return;
            }
        }
        set[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = getHash(key);
        Iterator<Integer> iterator = set[hash].iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (key == next){
                set[hash].remove(next);
                return;
            }
        }
    }

    public int getHash(int key){
        return key % size;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = getHash(key);
        Iterator<Integer> iterator = set[hash].iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (key == next){
                return true;
            }
        }
        return false;
    }
}
