package com.google.phone;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    
    int window;
    int index;
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.window = size;
        this.index = 0;
        this.q = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (q.size() == window) {
            q.poll();
        }
        q.offer(val);
        
        return getAvg();
    }
    
    public double getAvg() {
        double sum = 0;
        for (Integer i: q) {
            sum += i;
        }
        return sum / q.size();
    }
}