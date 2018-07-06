package de.yefan.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 */
public class Num137 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Long> set = new HashSet<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            long l = (long) nums[i];
            if (!set.contains(l)) {
                set.add(l);
                sum2 += l;
            }
            sum1 += l;
        }

        return (int) ((3 * sum2 - sum1) / 2);
    }

    public int singleNumber1(int[] nums) {
        int one = 0, two = 0;
        for (int i : nums) {
            one = (one ^ i) & ~two;
            two = (two ^ i) & ~one;
        }
        return one;
    }


}
