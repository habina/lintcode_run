package binary_tree;

public class unique_binary_search_tree {
    
    public static int numTrees(int n) {
        // n = 1, 1
        // n = 2, 2
        // 1        2
        //  \      /
        //   2    1
        // n = 3
        //       1           3    3       2      1
        //        \         /    /       / \      \
        //         3      2     1       1   3      2
        //        /      /       \                  \
        //       2     1          2                  3
        // let i to be the root node
        // left tree nodes contain [1, i - 1]
        // right tree nodes contain [i + 1, n]
        // let n = length([1, i-1]), m = length([i+1, n])
        // then total number of bst for root i is n * m.
        
        // dp[n] stands for number of BST at n
        // dp[n] = sum(dp[k] * dp[n - k - 1]) for k = 0 to n - 1
        // dp(n) = dp(0)*dp(n-1) + dp(1)*dp(n-2) + ... + dp(i)*dp(n-i-1) ... + dp(n-2)*dp(1) + dp(n-1)*dp(0)

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                dp[i] += dp[k] * dp[i - k - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

}
