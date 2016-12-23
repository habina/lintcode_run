package com.google.phone;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    public class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    // dummyHead.next is always the most recent node
    Node dummyHead;
    // dummyTail.prev is always the least recent node
    Node dummyTail;
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.prev = dummyTail;
        dummyHead.next = dummyTail;
        dummyTail.next = dummyHead;
        dummyTail.prev = dummyHead;
    }

    // @return an integer
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // prepare for move to head
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            node.next.prev = node.prev;
            node.prev.next = node.next;
        } else {
            if (map.size() == this.capacity) {
                // remove
                map.remove(dummyTail.prev.key);
                dummyTail.prev = dummyTail.prev.prev;
                dummyTail.prev.next = dummyTail;
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        
        moveToHead(node);
    }
    
    public void moveToHead(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

}
