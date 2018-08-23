package de.yefan.leetcode.dynamicprogramming;

/**
 * Arithmetic Slices
 * <p>
 * https://leetcode.com/problems/arithmetic-slices/description/
 */
public class Num413 {

    /**
     * Dynamic Programming
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    /**
     * Constant Space Dynamic Programming
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices1(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int n = A.length;
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = dp + 1;
                sum += dp;
            }
        }
        return sum;
    }

    /**
     * Using Formula
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int n = A.length;
        int count = 0;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                sum += (1 + count) * count / 2;
                count = 0;
            }
        }
        return sum;
    }


    int sum = 0;

    /**
     * Using Recursion
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices3(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }

    public int slices(int[] A, int i) {
        if (i < 2) {
            return 0;
        }
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else {
            slices(A, i - 1);
        }
        return ap;
    }

    /**
     * Brute Force
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices4(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }


}
