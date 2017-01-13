

public class DetectCycle {
    
    public static class Subset {
        int rank;
        int parent;
        
        public Subset(int rank, int parent) {
            this.rank = rank;
            this.parent = parent;
        }
    }
    
    public static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            // path compression
            // find root and make root as parent of i
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
        } else if (subsets[iRoot].rank > subsets[jRoot].rank) {
            subsets[jRoot].parent = iRoot;
        } else {
            subsets[jRoot].parent = iRoot;
            subsets[iRoot].rank += 1;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        
        Subset[] subsets = new Subset[v];
        for (int i = 0; i < v; i++) {
            // init rank to 0, and parent to self
            subsets[i] = new Subset(0, i);
        }
        
        int[][] edges = new int[v][v];
        
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
        

    }

}
