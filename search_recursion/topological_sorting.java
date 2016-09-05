package search_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class topological_sorting {

    static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
        
        public String toString() {
            return String.valueOf(this.label);
        }
    };
    
    /**
     * @param graph:
     *            A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // dfs way
        // runtime: number of node
        
        // use hashmap to count inbound edge for nodes 
        // {node : count of inbound}
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        
        // add nodes that has 0 inbound edge to the queue
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                stack.add(node);
            }
        }
        
        // starting on the 0 inbound edge node, and use bfs to traverse neighbor
        ArrayList<DirectedGraphNode> visited = new ArrayList<DirectedGraphNode>();
        
        while (!stack.isEmpty()) {
            DirectedGraphNode cur = stack.pop();
            visited.add(cur);
            // deduct cur's neighbor's inbound count
            for (DirectedGraphNode neighbor : cur.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    stack.push(neighbor);
                }
            }
        }
        
        return visited;
    }

//    /**
//     * @param graph:
//     *            A list of Directed graph node
//     * @return: Any topological order for the given graph.
//     */
//    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//        // bfs way
//        // runtime: number of node
//        
//        // use hashmap to count inbound edge for nodes 
//        // {node : count of inbound}
//        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
//        for (DirectedGraphNode node : graph) {
//            for (DirectedGraphNode neighbor : node.neighbors) {
//                if (map.containsKey(neighbor)) {
//                    map.put(neighbor, map.get(neighbor) + 1);
//                } else {
//                    map.put(neighbor, 1);
//                }
//            }
//        }
//        
//        // add nodes that has 0 inbound edge to the queue
//        Queue<DirectedGraphNode> q = new ArrayDeque<DirectedGraphNode>();
//        for (DirectedGraphNode node : graph) {
//            if (!map.containsKey(node)) {
//                q.offer(node);
//            }
//        }
//        
//        // starting on the 0 inbound edge node, and use bfs to traverse neighbor
//        ArrayList<DirectedGraphNode> visited = new ArrayList<DirectedGraphNode>();
//        while (!q.isEmpty()) {
//            DirectedGraphNode cur = q.poll();
//            visited.add(cur);
//            // add cur's neighbors to queue
//            for (DirectedGraphNode neighbor : cur.neighbors) {
//                // deduct neighbors inbound count
//                map.put(neighbor, map.get(neighbor) - 1);
//                // if no more inbound edge, add the neighbor to queue, ready for visit
//                if (map.get(neighbor) == 0) {
//                    q.offer(neighbor);
//                }
//            }
//        }
//        
//        return visited;
//    }

    public static void main(String[] args) {
        DirectedGraphNode zero = new DirectedGraphNode(0);
        DirectedGraphNode one = new DirectedGraphNode(1);
        DirectedGraphNode two = new DirectedGraphNode(2);
        DirectedGraphNode three = new DirectedGraphNode(3);
        DirectedGraphNode four = new DirectedGraphNode(4);
        DirectedGraphNode five = new DirectedGraphNode(5);
        
        ArrayList<DirectedGraphNode> g = new ArrayList<DirectedGraphNode>();
        g.add(zero);
        g.add(one);
        g.add(two);
        g.add(three);
        g.add(four);
        g.add(five);
        
        zero.neighbors.add(one);
        zero.neighbors.add(two);
        zero.neighbors.add(three);
        
        one.neighbors.add(four);
        
        two.neighbors.add(four);
        two.neighbors.add(five);
        
        three.neighbors.add(four);
        three.neighbors.add(five);
        
        System.out.println(topSort(g));
    }

}
