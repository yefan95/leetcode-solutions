package de.yefan.leetcode.array;


/**
 * Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class Num485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int max = 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }

        if (max < count) {
            max = count;
        }

        return max;
    }


}
