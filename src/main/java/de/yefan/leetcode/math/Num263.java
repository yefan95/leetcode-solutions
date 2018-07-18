package de.yefan.leetcode.math;

/**
 * Ugly Number
 * https://leetcode.com/problems/ugly-number/description/
 */
public class Num263 {
    public boolean isUgly(int num) {

        if (num == 0) {
            return false;
        }

        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }

        if (num == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Num263 num263 = new Num263();
        boolean res = num263.isUgly(-2147483648);
        System.out.println(res);
    }
}
