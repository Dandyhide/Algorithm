package com.company.Study.Hash;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private class Pair{
        private int key;
        private int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private LinkedList[] map;
    private static final int size = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[size];
        for (int i = 0; i < size; i++){
            map[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = getHash(key);
        Iterator<Pair> iterator = map[hash].iterator();
        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.getKey() == key){
                next.setValue(value);
                return;
            }
        }
        map[hash].offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        Iterator<Pair> iterator = map[hash].iterator();
        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.getKey() == key){
                return next.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHash(key);
        Iterator<Pair> iterator = map[hash].iterator();
        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.getKey() == key){
                map[hash].remove(next);
                return;
            }
        }
    }

    public int getHash(int key){
        return key % size;
    }
}
