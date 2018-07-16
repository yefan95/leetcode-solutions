package de.yefan.leetcode.math;

/**
 * Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/solution/
 */
public class Num191 {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
