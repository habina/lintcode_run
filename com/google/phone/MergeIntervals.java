package com.google.phone;

import java.util.ArrayList;
import java.util.List;

import com.google.phone.InsertInterval.Interval;

public class MergeIntervals {

    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> sorted = mergeSort(intervals);
        List<Interval> res = new ArrayList<Interval>();
        Interval cur = sorted.get(0);
        
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).start <= cur.end) {
                cur.end = Math.max(cur.end, sorted.get(i).end);
            } else {
                res.add(cur);
                cur = sorted.get(i);
            }
        }
        
        res.add(cur);
        return res;
    }
    
    public List<Interval> mergeSort(List<Interval> lst) {
        if (lst.size() < 2) {
            return lst;
        }
        
        int mid = lst.size() / 2;
        List<Interval> left = mergeSort(lst.subList(0, mid));
        List<Interval> right = mergeSort(lst.subList(mid, lst.size()));
        List<Interval> res = new ArrayList<Interval>();
        
        int i = 0;
        int j = 0;
        
        while (i < left.size() && j < right.size()) {
            if (left.get(i).start < right.get(j).start) {
                res.add(left.get(i));
                i++;
            } else {
                res.add(right.get(j));
                j++;
            }
        }
        
        while (i < left.size()) {
            res.add(left.get(i));
            i++;
        }
        
        while (j < right.size()) {
            res.add(right.get(j));
            j++;
        }
        
        return res;
    }

}
