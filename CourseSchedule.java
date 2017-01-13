import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> inbound = new HashMap<Integer, Integer>();
        for (int[] edge : prerequisites) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> t = new ArrayList<Integer>();
                t.add(edge[1]);
                map.put(edge[0], t);
            }

            if (inbound.containsKey(edge[1])) {
                inbound.put(edge[1], inbound.get(edge[1]) + 1);
            } else {
                inbound.put(edge[1], 1);
            }
        }

        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!inbound.containsKey(i)) {
                q.offer(i);
                visited.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.containsKey(cur)) {
                for (Integer neighbor : map.get(cur)) {
                    inbound.put(neighbor, inbound.get(neighbor) - 1);
                    if (inbound.get(neighbor) == 0) {
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
        }

        return visited.size() == numCourses;
    }

    public static void main(String[] args) {
        int a = 2;
        int[][] b = { { 1, 0 } };
        System.out.println(canFinish(a, b));
    }

}
