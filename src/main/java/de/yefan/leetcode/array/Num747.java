package de.yefan.leetcode.array;

/**
 * Largest Number At Least Twice of Others
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */
public class Num747 {

    public int dominantIndex(int[] nums) {

        if (nums == null) {
            return -1;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != index) {
                if (max / nums[i] < 2) {
                    index = -1;
                    break;
                }
            }
        }

        return index;
    }

}
