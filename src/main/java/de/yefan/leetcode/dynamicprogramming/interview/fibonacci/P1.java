package de.yefan.leetcode.dynamicprogramming.interview.fibonacci;

/**
 * 给定整数N,返回斐波那契数列的第N项
 */
public class P1 {
    public static void main(String[] args) {
        P1 p1 = new P1();
        long start = System.currentTimeMillis();
        int res = p1.f3(10000);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
        start = System.currentTimeMillis();
        res = p1.f2(10000);
        System.out.println(res);
        end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
    }

    /**
     * O(2^N)
     *
     * @param n
     * @return
     */
    public int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    public int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }

        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);

        return res[0][0] + res[1][0];
    }

    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        //先把res设为单位矩阵，相当于整数中的1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }

        return res;
    }

    public int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
