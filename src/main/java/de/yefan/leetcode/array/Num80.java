package de.yefan.leetcode.array;

/**
 * Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class Num80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                count = 0;
            } else {
                count = count + 1;
                if (count <= 1) {
                    i++;
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
}
