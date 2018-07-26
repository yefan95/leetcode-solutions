package de.yefan.leetcode.dynamicprogramming;

import java.util.List;

/**
 * Triangle
 * https://leetcode.com/problems/triangle/description/
 */
public class Num120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int previous = dp[0];
            dp[0] += list.get(0);
            for (int j = 1; j < i; j++) {
                int temp = dp[j];
                dp[j] = list.get(j) + Math.min(previous, dp[j]);
                previous = temp;
            }

            dp[i] = previous + list.get(i);
        }

        int result = dp[0];

        for (int i = 1; i < triangle.size(); i++) {
            result = Math.min(result, dp[i]);
        }

        return result;
    }
}
