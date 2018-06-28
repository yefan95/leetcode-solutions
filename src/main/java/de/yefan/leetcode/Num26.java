package de.yefan.leetcode;

/**
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Num26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int size = nums.length;
        for (int j = 0; j < size; j++) {
            boolean flag = false;
            for (int k = 0; k < i; k++) {
                if (nums[k] == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
