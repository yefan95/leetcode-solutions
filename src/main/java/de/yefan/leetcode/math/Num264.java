package de.yefan.leetcode.math;

/**
 * Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 */
public class Num264 {


    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2 * ugly[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++index5];
            }
        }
        return ugly[n - 1];
    }

    /**
     * 暴力法(超时)
     *
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        if (n <= 0) {
            return -1;
        }
        int res = 1;

        int count = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (count == n) {
                break;
            }
            if (i == 1) {
                count++;
            } else {
                int num = i;
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
                    res = i;
                    count++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Num264 num264 = new Num264();
        int res = num264.nthUglyNumber1(1352);
        System.out.println(res);
    }
}
