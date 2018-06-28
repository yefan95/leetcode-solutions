package de.yefan.leetcode;

/**
 * Remove Element
 * https://leetcode.com/problems/remove-element/description/
 */
public class Num27 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int size = nums.length;
        for (int j = 0; j < size; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
