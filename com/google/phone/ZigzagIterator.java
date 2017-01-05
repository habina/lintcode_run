package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    List<List<Integer>> v;
    int index = 0;
    int level = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new ArrayList<List<Integer>>();
        v.add(v1);
        v.add(v2);
    }

    public int next() {
        index++;
        return v.get(index - 1).get(level);
    }

    public boolean hasNext() {
        if (index == v.size()) {
            index = 0;
            level++;
        }
        while (v.size() > 0 && level >= v.get(index).size()) {
            v.remove(index);
            if (index == v.size()) {
                index = 0;
                level++;
            }
        }
        if (v.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        List<Integer> v1 = new ArrayList<Integer>();
        v1.add(1);
        v1.add(2);
        List<Integer> v2 = new ArrayList<Integer>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void test2() {
        List<Integer> v1 = new ArrayList<Integer>();
        v1.add(1);
        List<Integer> v2 = new ArrayList<Integer>();
        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}