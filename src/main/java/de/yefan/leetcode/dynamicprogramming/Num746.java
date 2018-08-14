package de.yefan.leetcode.dynamicprogramming;

/**
 * Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class Num746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int costV = (i == cost.length) ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + costV;
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        Num746 num746 = new Num746();
        int[] cost = {0, 0, 0, 1};
        int res = num746.minCostClimbingStairs(cost);
        System.out.println(res);
    }
}
