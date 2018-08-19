package de.yefan.leetcode.dynamicprogramming.interview.fibonacci;

/**
 * 给定整数N,代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法
 */
public class P2 {


    public static void main(String[] args) {
        P2 p2 = new P2();
        long start = System.currentTimeMillis();
        int res = p2.s3(100000);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
        start = System.currentTimeMillis();
        res = p2.s2(100000);
        System.out.println(res);
        end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
    }

    public int s1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        return s1(n - 1) + s1(n - 2);
    }

    public int s2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int res = 2;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }

        return res;
    }

    public int s3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);

        return 2 * res[0][0] + res[1][0];
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
