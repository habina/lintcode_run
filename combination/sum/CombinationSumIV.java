package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV {
    
    public int combinationSum4(int[] nums, int target) {
        // dp[i] stands for number of combinations that sums to i
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    dp[i] += dp[i - n];
                }
            }
        }
        
        return dp[target];
    }
}
