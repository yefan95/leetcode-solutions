package de.yefan.leetcode.search;

/**
 * Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */
public class Num81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}
