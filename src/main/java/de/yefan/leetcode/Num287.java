package de.yefan.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class Num287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
