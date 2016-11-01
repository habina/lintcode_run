package com.twitter.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TweetRecommendation {

    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser,
        int minLikeThreshold) {
        Set<Integer> idole = getIdole(targetUser, followGraph_edges);
        TreeSet<Integer> tweets = analyzeTweets(idole, likeGraph_edges, minLikeThreshold);
        int[] res = new int[tweets.size()];
        int i = 0;
        for (Integer tid : tweets) {
            res[i] = tid;
            i++;
        }
        return res;
    }
    
    static Set<Integer> getIdole(int user, int[][] g) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int[] pair : g) {
            if (pair[0] == user) {
                set.add(pair[1]);
            }
        }
        
        return set;
    }
    
    static TreeSet<Integer> analyzeTweets(Set<Integer> idole, int[][] likes, int minLike) {
        TreeSet<Integer> tweets = new TreeSet<Integer>();
        // Tweets ID : likes count
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int[] pair : likes) {
            int tid = pair[1];
            int iid = pair[0];
            if (idole.contains(iid)) {
                if (map.containsKey(tid)) {
                    map.put(tid, 1 + map.get(tid));
                } else {
                    map.put(tid, 1);
                }
                if (map.get(tid) >= minLike) {
                    tweets.add(tid);
                }
            }
        }
        
        return tweets;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
