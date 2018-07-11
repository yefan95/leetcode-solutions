package de.yefan.leetcode.array;

import java.util.Arrays;

/**
 * Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class Num215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
