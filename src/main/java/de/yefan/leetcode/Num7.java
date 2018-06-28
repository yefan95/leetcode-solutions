package de.yefan.leetcode;

/**
 * Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Num7 {

    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            ans = ans * 10 + tmp;
            x = x / 10;
        }
        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int) ans;
        } else {
            return 0;
        }
    }

}
