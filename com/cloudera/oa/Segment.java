package com.cloudera.oa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Segment {

    static void enQueue(Deque<Integer> q, int num) {
        while (!q.isEmpty() && q.peekLast() > num) {
            q.pollLast();
        }
        q.offer(num);
    }
    
    static void deQueue(Deque<Integer> q, int num) {
        if (q.peekFirst() == num) {
            q.pollFirst();
        }
    }

    static int segment(int x, int[] arr) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> q = new ArrayDeque<Integer>();
        int max = Integer.MIN_VALUE;

        // init q
        for (int i = 0; i < x - 1; i++) {
            enQueue(q, arr[i]);
        }

        for (int i = x - 1; i < arr.length; i++) {
            enQueue(q, arr[i]);
            res.add(q.peekFirst());
            deQueue(q, arr[i - x + 1]);
        }
        
        for (Integer i : res) {
            max = Math.max(max, i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 1, 2 };
        int x = 1;
        System.out.println(segment(x, a));

        int[] b = { 1, 1, 1 };
        x = 2;
        System.out.println(segment(x, b));

        int[] c = { 2, 5, 4, 6, 8 };
        x = 3;
        System.out.println(segment(x, c));
    }

}
