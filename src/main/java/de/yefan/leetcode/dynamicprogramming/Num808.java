package de.yefan.leetcode.dynamicprogramming;

/**
 *Soup Servings
 * https://leetcode.com/problems/soup-servings/description/
 */
public class Num808 {
    public double soupServings(int N) {
        int n = N;
        if (n >= 10000) {
            // because you have 75% cost A more than B.
            return 1;
        }
        if (n % 25 != 0) {
            n = n / 25 + 1;
        } else {
            n = n / 25;
        }
        int[][] options = new int[][]{{4, 0}, {3, 1}, {2, 2}, {1, 3}};
        return dfs(n, n, options, new Double[n + 1][n + 1]);
    }

    private double dfs(int soupA, int soupB, int[][] options, Double[][] mem) {
        if (soupA <= 0) {
            if (soupB > 0) {
                return 1;
            }
            if (soupB <= 0) {
                return 0.5;
            }
        }
        if (soupB <= 0) {
            return 0;
        }
        if (mem[soupA][soupB] != null) {
            return mem[soupA][soupB];
        }
        // 4 options
        double res = 0.0;
        for (int i = 0; i < options.length; i++) {
            int nextA = soupA - options[i][0];
            int nextB = soupB - options[i][1];
            res += 0.25 * dfs(nextA, nextB, options, mem);
        }
        mem[soupA][soupB] = res;
        return res;
    }
}
