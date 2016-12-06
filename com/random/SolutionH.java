package com.random;

public class SolutionH {

    public static int solution(int A) {
        /*
         * If A is odd, we will always do command L first, since update L first
         * will always give us odd answer. If A is even, we will always do
         * command R.
         */
        if (A % 2 == 1) {
            return solution(A, -1, 1) + 1;
        } else {
            return solution(A, 0, 2) + 1;
        }
    }

    public static int solution(int A, int L, int R) {
        if (A == L || A == R) {
            return 0;
        } else if (Math.abs(L) > Math.abs(A) || Math.abs(R) > Math.abs(A)) {
            return -1;
        } else {
            int nextL = solution(A, doAction(L, R), R);
            int nextR = solution(A, L, doAction(R, L));
            if (nextL == -1 && nextR == -1) {
                return -1;
            } else if (nextL == -1 || nextR == -1) {
                return 1 + Math.max(nextL, nextR);
            } else {
                return 1 + Math.min(nextL, nextR);
            }
        }
    }

    public static int doAction(int a, int b) {
        return 2 * a - b;
    }
    
    public static int solution2(int a) {
        a = Math.abs(a);
        int sum = 2;
        int count = 1;
        while (sum < a) {
            sum *= 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 147483647; i++) {
            System.out.println(solution(i));
            System.out.println(solution2(i));
            System.out.println();
        }
    }

}
