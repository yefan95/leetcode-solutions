package de.yefan.leetcode.sort;

import java.util.Arrays;

/**
 * Maximum Gap
 * https://leetcode.com/problems/maximum-gap/description/
 */
public class Num164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }

        return max;
    }

    /**
     * Radix Sort
     *
     * @param nums
     * @return
     */
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int exp = 1;
        int radix = 10;

        int[] aux = new int[nums.length];

        while (maxVal / exp > 0) {
            int[] count = new int[radix];

            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }

            exp *= 10;
        }

        int maxGap = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(nums[i + 1] - nums[i], maxGap);
        }

        return maxGap;
    }
}
