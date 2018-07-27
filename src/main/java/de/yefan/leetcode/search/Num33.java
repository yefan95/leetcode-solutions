package de.yefan.leetcode.search;

/**
 * Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class Num33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < nums[low]) {
                if (target < nums[mid] || target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] || target < nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
