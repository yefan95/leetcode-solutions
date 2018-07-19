package de.yefan.leetcode.math;


/**
 * Super Ugly Number
 * https://leetcode.com/problems/super-ugly-number/description/
 */
public class Num313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] pointer = new int[primes.length];

        int[] pos = new int[1000];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[pointer[j]] * primes[j] < min) {
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }
            ugly[i] = min;
            pointer[minIndex]++;
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Num313 num313 = new Num313();
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int res = num313.nthSuperUglyNumber(n, primes);
        System.out.println(res);
    }
}
