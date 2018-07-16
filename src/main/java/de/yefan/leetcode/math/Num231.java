package de.yefan.leetcode.math;

/**
 * Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 */
public class Num231 {

    /**
     * 迭代
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return (n == 1);
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));
    }

    /**
     * 位运算
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }


}
