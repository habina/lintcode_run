package com.google.phone;

import java.util.TreeMap;

public class HitCounter {
    
    TreeMap<Integer, Integer> map;
    int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.map = new TreeMap<Integer, Integer>();
        this.map.put(0, 0);
        this.count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        // lg n
        count++;
        this.map.put(timestamp, count);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        // lg n
        int endKey = map.floorKey(timestamp);
        int beginKey = timestamp - 300;
        if (beginKey <= 0) {
            return map.get(endKey);
        } else {
            beginKey = map.floorKey(beginKey);
            return map.get(endKey) - map.get(beginKey);
        }
    }
}