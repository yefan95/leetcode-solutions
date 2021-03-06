package de.yefan.leetcode.array;

/**
 * Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/description/
 */
public class Num498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = 0;
        int[] nums = new int[m * n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = matrix[r][c];
            // moving up
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            }
            // moving down
            else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return nums;
    }
}
