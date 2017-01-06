package com.google.phone;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {
    
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
        } else {
            map.put(timestamp, 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int low = Math.max(1, timestamp - 300 + 1);
        int high = timestamp;
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (map.containsKey(i)) {
                count += map.get(i);
            }
        }
        
        return count;
    }
}