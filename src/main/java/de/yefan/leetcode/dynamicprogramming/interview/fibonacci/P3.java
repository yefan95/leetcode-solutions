package de.yefan.leetcode.dynamicprogramming.interview.fibonacci;

/**
 * 假设农场中成熟的母牛每年只会生1头小牛，并且永远不会死。第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛3年后成熟又可以生小母牛。给定整数N,求N年后牛的数量。
 */
public class P3 {

    public static void main(String[] args) {
        P3 p3 = new P3();
        long start = System.currentTimeMillis();
        int res = p3.c3(1000);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
        start = System.currentTimeMillis();
        res = p3.c2(1000);
        System.out.println(res);
        end = System.currentTimeMillis();
        System.out.println("Cost Time: " + (end - start));
    }

    public int c1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return c1(n - 1) + c1(n - 3);
    }

    public int c2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 4; i <= n; i++) {
            temp1 = res;
            temp2 = pre;
            res = res + prepre;
            pre = temp1;
            prepre = temp2;
        }

        return res;
    }

    public int c3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n - 3);

        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
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
