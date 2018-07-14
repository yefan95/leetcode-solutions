package de.yefan.leetcode.dynamicprogramming;

/**
 * Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 */
public class Num338 {
    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i / 2];
            if (i % 2 == 1) {
                res[i]++;
            }
        }
        return res;
    }


    public int[] countBits1(int num) {
        /**
         * f[i] = f[i / 2] + i % 2
         */
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }


}
