package search_recursion;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class word_ladder_ii {

    /**
     * @param start,
     *            a string
     * @param end,
     *            a string
     * @param dict,
     *            a set of string
     * @return an integer
     */
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // idea is implement a getNextWords which returns a list of next word.
        // runtime: bfs o(|v| + |e|)

        List<List<String>> res = new LinkedList<List<String>>();

        dict.add(start);
        dict.add(end);

        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        Map<String, Set<String>> parent = new HashMap<String, Set<String>>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                for (String next : getNextWords(cur, dict)) {

                    if (parent.containsKey(next)) {
                        parent.get(next).add(cur);
                    } else {
                        Set<String> set = new HashSet<String>();
                        set.add(cur);
                        parent.put(next, set);
                    }
                    
                    if (next.equals(end)) {
                        continue;
                    }
                    q.offer(next);
                    visited.add(next);

                }
            }
            dict.removeAll(visited);
            visited.clear();
        }

        // backtracking
        LinkedList<String> path = new LinkedList<String>();
        path.add(end);
        dfs(parent, end, start, path, res);

        // filter the shortest
        int dist = Integer.MAX_VALUE;
        List<List<String>> shortest = new LinkedList<List<String>>();

        for (List<String> list : res) {
            if (list.size() < dist) {
                dist = list.size();
            }
        }

        for (List<String> list : res) {
            if (list.size() == dist) {
                shortest.add(list);
            }
        }
        
        return shortest;
    }

    public static void dfs(Map<String, Set<String>> parent, String cur, String start, LinkedList<String> path,
        List<List<String>> res) {

        if (cur.equals(start)) {
            res.add(new LinkedList<String>(path));
        } else {
            for (String prev : parent.get(cur)) {
                
                path.addFirst(prev);
                dfs(parent, prev, start, path, res);
                path.removeFirst();
            }
        }
    }

    public static Set<String> getNextWords(String word, Set<String> dict) {
        Set<String> res = new HashSet<String>();

        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (int j = 'a'; j <= 'z'; j++) {
                sb.replace(i, i + 1, String.valueOf((char) j));
                String next = sb.toString();
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
        }

        res.remove(word);

        return res;
    }

    public static void main(String[] args) {
        String[] d = { "hot", "dot", "dog", "lot", "log" };
        Set<String> dict = new HashSet<String>();
        dict.addAll(Arrays.asList(d));
        String start = "hit";
        String end = "cog";
        System.out.println(findLadders(start, end, dict));

        String[] dd = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm",
            "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma",
            "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th",
            "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an",
            "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
            "ni", "mr", "pa", "he", "lr", "sq", "ye" };
        Set<String> ddict = new HashSet<String>();
        ddict.addAll(Arrays.asList(dd));
        System.out.println(findLadders("qa", "sq", ddict));
    }

}
