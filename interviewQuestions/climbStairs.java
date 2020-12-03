package interviewQuestions;

public class climbStairs {
    // public int climbStairs(int n) {
    //     return climb_Stairs(0, n);
    // }

    // public int climb_Stairs(int i, int n) {
    //     if (i > n) {
    //         return 0;
    //     }
    //     if (i == n) {
    //         return 1;
    //     }
    //     return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    // }
    //memoization
    /**
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
     */
    //dynamic programming
    /**
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/
    //fibonacci
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    //Reference: https://leetcode.com/problems/climbing-stairs/solution/
}
// to do implement memoization, fib, dp, bines and fib formula approaches
