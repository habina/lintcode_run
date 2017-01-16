import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    
    public static class Subset {
        int rank;
        int parent;
        Set<Integer> set;
        
        public Subset(int rank, int parent) {
            this.rank = rank;
            this.parent = parent;
            this.set = new HashSet<Integer>();
            set.add(parent);
        }
    }
    
    public static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            // find root and make root as parent of i
            // path compression
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    
    public static void union(Subset[] subsets, int i, int j) {
        int iRoot = find(subsets, i);
        int jRoot = find(subsets, j);
        
        // union by rank
        // attach smaller rank tree under root of high rank tree
        if (subsets[iRoot].rank < subsets[jRoot].rank) {
            subsets[iRoot].parent = jRoot;
            subsets[jRoot].set.addAll(subsets[iRoot].set);
        } else if (subsets[iRoot].rank > subsets[jRoot].rank) {
            subsets[jRoot].parent = iRoot;
            subsets[iRoot].set.addAll(subsets[jRoot].set);
        } else {
            subsets[jRoot].parent = iRoot;
            subsets[iRoot].set.addAll(subsets[jRoot].set);
            subsets[iRoot].rank += 1;
        }
    }

    public static void main(String[] args) {
        int v = 8;
        
        Subset[] subsets = new Subset[v];
        for (int i = 0; i < v; i++) {
            // init rank to 0, and parent to self
            subsets[i] = new Subset(0, i);
        }
        
        int[][] edges = new int[6][2];
        
        edges[0] = new int[] {0, 1};
        edges[1] = new int[] {2, 3};
        edges[2] = new int[] {4, 5};
        edges[3] = new int[] {6, 7};
        edges[4] = new int[] {0, 3};
        edges[5] = new int[] {5, 6};
        
        for (int[] e : edges) {
            // find set number
            int x = find(subsets, e[0]);
            int y = find(subsets, e[1]);
            
            // if in the same set, find cycle
            if (x == y) {
                System.out.println("find cycle");
            } else {
                // otherwise, union them
                union(subsets, x, y);
            }
        }
        
        for (Subset s : subsets) {
            System.out.println(s.rank);
            System.out.println(s.set);
        }
        

    }

}
