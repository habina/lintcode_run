package com.google.phone;

import java.util.ArrayList;

public class InsertInterval {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * Insert newInterval into intervals.
     * 
     * @param intervals:
     *            Sorted interval list.
     * @param newInterval:
     *            A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int insertPos = 0;
        
        for (Interval iter : intervals) {
            if (newInterval.start > iter.end) {
                result.add(iter);
                insertPos++;
            } else if (newInterval.end < iter.start) {
                result.add(iter);
            } else {
                newInterval.start = Math.min(newInterval.start, iter.start);
                newInterval.end = Math.max(newInterval.end, iter.end);
            }
        }
        
        result.add(insertPos, newInterval);
        return result;
    }

}
