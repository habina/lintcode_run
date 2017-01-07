package com.google.phone;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    
    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int t = map.get(message);
            if (timestamp - t >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}