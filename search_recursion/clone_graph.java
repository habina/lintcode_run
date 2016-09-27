package search_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class clone_graph {
    
    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };
    
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            if (visited.contains(cur)) {
                continue;
            } else {
                visited.add(cur);
            }

            UndirectedGraphNode newCur = null;
            if (map.containsKey(cur.label)) {
                newCur = map.get(cur.label);
            } else {
                newCur = new UndirectedGraphNode(cur.label);
                map.put(newCur.label, newCur);
            }

            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                newCur.neighbors.add(map.get(neighbor.label));
                q.offer(neighbor);
            }
        }
        
        return map.get(node.label);
    }
    
    public static String serializeGraph(UndirectedGraphNode node) {
        String res = "";
        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            if (set.contains(cur)) {
                continue;
            } else {
                set.add(cur);
            }
            res += cur.label + ", ";
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                res += neighbor.label + ", ";
                q.offer(neighbor);
            }
            
            res += "# ";
        }
        
        return res;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);

        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        
        System.out.println(serializeGraph(node0));
        System.out.println(serializeGraph(cloneGraph(node0)));
    }

}
