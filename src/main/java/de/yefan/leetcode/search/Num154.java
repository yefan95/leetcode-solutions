package de.yefan.leetcode.search;

/**
 * Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */
public class Num154 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
