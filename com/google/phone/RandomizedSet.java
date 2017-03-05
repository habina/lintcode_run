package com.google.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    
    Map<Integer, Integer> map;
    List<Integer> lst;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        // value : index
        this.map = new HashMap<Integer, Integer>();
        // index : value
        this.lst = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int lastVal = lst.get(lst.size() - 1);
        int valIndex = map.get(val);
        lst.set(valIndex, lastVal);
        map.put(lastVal, valIndex);
        lst.remove(lst.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index =  rand.nextInt(lst.size());
        return lst.get(index);
    }
}