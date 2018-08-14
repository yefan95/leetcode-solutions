package de.yefan.leetcode.dynamicprogramming;

/**
 * Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class Num70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
