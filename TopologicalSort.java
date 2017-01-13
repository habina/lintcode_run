import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    };

    /**
     * @param graph:
     *            A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // find out who does not have an in bound edge
        // node : in bound count
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        
        // BFS
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                res.add(node);
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            for (DirectedGraphNode neighbor : cur.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    res.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        
        return res;
    }
}
