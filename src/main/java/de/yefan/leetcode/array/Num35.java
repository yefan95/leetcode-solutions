package de.yefan.leetcode.array;

/**
 * Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class Num35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return target > nums[left] ? left + 1 : left;
    }

}
