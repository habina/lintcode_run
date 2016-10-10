package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class word_ladder {
    
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
   public static int ladderLength(String start, String end, Set<String> dict) {
       // idea is implement a getNextWords which returns a list of next word.
       // runtime: bfs o(|v| + |e|)

       Queue<String> q = new LinkedList<String>();
       Set<String> visited = new HashSet<String>();
       
       int distance = 1;
       if (start.equals(end)) {
           return distance;
       }

       dict.add(start);
       dict.add(end);
       q.offer(start);
       visited.add(start);

       while (!q.isEmpty()) {
           distance++;
           int size = q.size();
           
           // check up all next words at current level for shorted path.
           for (int i = 0; i < size; i++) {
               String cur = q.poll();
               for (String next : getNextWords(cur, dict)) {
//                   if (visited.contains(next)) {
//                       continue;
//                   }
                   if (next.equals(end)) {
                       return distance;
                   }
                   q.offer(next);
                   visited.add(next);
               }
           }
           
           dict.removeAll(visited);
           visited.clear();
       }
       return 0;
   }
   
   public static List<String> getNextWords(String word, Set<String> dict) {
       List<String> res = new ArrayList<String>();
       for (int j = 0; j < word.length(); j++) {
           StringBuilder sb = new StringBuilder();
           sb.append(word);
           for (int i = 'a'; i <= 'z'; i++) {
               sb.replace(j, j + 1, String.valueOf((char) i));
               if (dict.contains(sb.toString())) {
                   res.add(sb.toString());
               }
           }
       }
       return res;
   }

    public static void main(String[] args) {
        String[] d = {"hot","dot","dog","lot","log"};
        Set<String> dict = new HashSet<String>();
        dict.addAll(Arrays.asList(d));
        String start = "hit";
        String end = "cog";
        System.out.println(ladderLength(start, end, dict));
        
        String[] dd = {"a","b","c"};
        Set<String> ddict = new HashSet<String>();
        ddict.addAll(Arrays.asList(dd));
        System.out.println(ladderLength("a", "c", ddict));
    }

}
