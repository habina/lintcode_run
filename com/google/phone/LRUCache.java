package com.google.phone;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    public class Node {
        Node next;
        Node prev;
        int key;
        int val;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    Map<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;

    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyHead.prev = dummyTail;
        dummyTail.next = dummyHead;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            moveToHead(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            moveToHead(cur);
        } else {
            if (map.size() == this.capacity) {
                Node toRemove = dummyTail.prev;
                map.remove(toRemove.key);
                dummyTail.prev = toRemove.prev;
                dummyTail.prev.next = dummyTail;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToHead(newNode);
        }
        
    }

    public void moveToHead(Node cur) {
        cur.next = dummyHead.next;
        cur.prev = dummyHead;
        dummyHead.next.prev = cur;
        dummyHead.next = cur;
    }
}