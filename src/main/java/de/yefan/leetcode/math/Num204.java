package de.yefan.leetcode.math;

/**
 * Count Primes
 * https://leetcode.com/problems/count-primes/description/
 */
public class Num204 {

    /**
     * 暴力法(超时)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes1(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Num204 num204 = new Num204();
        long start = System.currentTimeMillis();
        int res = num204.countPrimes(499979);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("Cost Time: " + (end - start));
        start = System.currentTimeMillis();
        res = num204.countPrimes1(499979);
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("Cost Time: " + (end - start));

    }
}
