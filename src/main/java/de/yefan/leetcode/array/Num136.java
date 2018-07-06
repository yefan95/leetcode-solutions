package de.yefan.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Single Number
 * https://leetcode.com/problems/single-number/description/
 */
public class Num136 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == nums.length - 2) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i + 1];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int singleNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.remove(nums[i])) {
                set.add(nums[i]);
            }
        }

        return set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum2 += nums[i];
            }
            sum1 += nums[i];
        }

        return 2 * sum2 - sum1;
    }

    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }


}
