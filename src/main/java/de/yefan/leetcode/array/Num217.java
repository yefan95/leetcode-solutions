package de.yefan.leetcode.array;

import java.util.Arrays;

/**
 * Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class Num217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
