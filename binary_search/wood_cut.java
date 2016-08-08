package binary_search;

public class wood_cut {

    /**
     * @param L:
     *            Given n pieces of wood with length L[i]
     * @param k:
     *            An integer return: The maximum length of the small pieces.
     */
    public static int woodCut(int[] L, int k) {
        // runtime: n log Len, Len is the longest length of wood

        int min = 0;
        // find max number
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > max) {
                max = L[i];
            }
        }
        
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            int total = 0;
            for (int len : L) {
                total += (int) (len / mid);
            }
            if (total < k) {
                max = mid;
            } else {
                min = mid;
            }
        }
        
        return min;
    }

    public static void main(String[] args) {
        int[] L = { 232, 124, 456 };
        int k = 7;
        System.out.println(woodCut(L, k));
    }

}
