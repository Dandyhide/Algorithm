package com.company.Study.DesignDataStructure;

/**
 * 146. LRU 缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/designing-data-structures/rt971j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int k, v;
        Node l, r;
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    Node head, tail;    //哨兵
    Map<Integer, Node> map;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)){
            node =  map.get(key);
            node.v = value;
        }else{
            if (map.size() == size) {
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        refresh(node);
    }

    public void refresh(Node node) {
        delete(node);
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

    public void delete(Node node) {
        if (node.l != null){
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }
}
