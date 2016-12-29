package com.google.phone;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    
    public static List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<String>();
        if (tickets.length < 1) {
            return res;
        }
        
        Map<String, PriorityQueue<String>> g = new HashMap<String, PriorityQueue<String>>();
        // build graph
        for (String[] it : tickets) {
            if (!g.containsKey(it[0])) {
                g.put(it[0], new PriorityQueue<String>());
            }
            g.get(it[0]).add(it[1]);
        }
        String cur = "JFK";
        
        dfs(cur, g, res);
        Collections.reverse(res);
        
        return res;
    }
    
    public static void dfs(String cur, Map<String, PriorityQueue<String>> g, List<String> res) {
        while (g.containsKey(cur) && !g.get(cur).isEmpty()) {
            dfs(g.get(cur).poll(), g, res);
        }
        res.add(cur);
    }

    public static void main(String[] args) {
        String[][] a = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        System.out.println(findItinerary(a));
    }

}
