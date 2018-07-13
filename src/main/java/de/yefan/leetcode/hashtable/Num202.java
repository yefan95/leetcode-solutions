package de.yefan.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * https://leetcode.com/problems/happy-number/description/
 */
public class Num202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int tmp = n;
            int sum = 0;

            while (tmp > 0) {
                int digit = tmp % 10;
                sum += digit * digit;
                tmp /= 10;
            }

            n = sum;

            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Num202 num202 = new Num202();
        boolean res = num202.isHappy(1111111);
        System.out.println(res);
    }


}
