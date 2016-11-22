package com.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int totalSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (totalSum < desiredTotal) {
            return false;
        }

        if (desiredTotal == 0) {
            return true;
        }
        boolean[] use = new boolean[maxChoosableInteger + 1];
        for (int i = 1; i <= maxChoosableInteger; i++) {
            use[i] = true;
        }
        Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

        return canIWin(use, desiredTotal, memo);
    }
    
    public static int makeBoardKey(boolean[] use) {
        int res = 0;
        for (boolean b : use) {
            res = res << 1;
            if (b) {
                res |= 0x1;
            }
        }

        return res;
    }

    public static boolean canIWin(boolean[] use, int target, Map<Integer, Boolean> memo) {
        if (target <= 0) {
            return false;
        }

        int key = makeBoardKey(use);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean result = false;
        for (int i = use.length - 1; i >= 1; i--) {
            if (use[i]) {
                use[i] = false;
                result = !canIWin(use, target - i, memo);
                if (result) {
                    memo.put(key, result);
                    use[i] = true;
                    return true;
                }
                use[i] = true;
            }
        }

        memo.put(key, result);
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(canIWin(10, 1));
        System.out.println(canIWin(10, 11));
        System.out.println(canIWin(3, 5));
        System.out.println(canIWin(10, 40));
        System.out.println(canIWin(20, 210));
        System.out.println(canIWin(5, 50));
        System.out.println(canIWin(14, 10));
        System.out.println(canIWin(18, 188));
    }

}
