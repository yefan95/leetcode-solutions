package de.yefan.leetcode.sort;

import java.util.Arrays;

/**
 * Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Num75 {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * counting sort
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < (count[0] + count[1])) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int second = nums.length - 1, zero = 0;

        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) {
                swap(nums, i, second);
                second--;
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero);
                zero++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
