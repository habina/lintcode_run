package com.google.phone;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int count;
    
    public FindMedianFromDataStream() {
        // second half
        this.min = new PriorityQueue<Integer>();
        // first half
        this.max = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        this.count = 0;
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (this.max.size() == this.min.size()) {
            this.max.offer(num);
        } else {
            this.min.offer(num);
        }
        
        if (!this.max.isEmpty() && !this.min.isEmpty()) {
            if (this.max.peek() > this.min.peek()) {
                int t = this.max.poll();
                this.max.offer(this.min.poll());
                this.min.offer(t);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (this.min.size() == this.max.size()) {
            return (this.max.peek() + this.min.peek()) / 2.0;
        } else {
            return this.max.peek();
        }
    }

}
