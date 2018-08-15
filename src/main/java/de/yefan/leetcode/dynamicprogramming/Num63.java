package de.yefan.leetcode.dynamicprogramming;

/**
 * Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class Num63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (i > 0) {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Num63 num63 = new Num63();

//        int[][] obstacleGrid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
        int[][] obstacleGrid = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
//        int[][] obstacleGrid = {
//                {1}
//        };
        int res = num63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
