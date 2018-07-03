package de.yefan.leetcode.array;

/**
 * Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */
public class Num1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int m = -1, n = -1;
        int[] result = new int[2];
        OK:
        for (int i = 0; i < len; i++) {
            m = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    n = j;
                    break OK;
                }
            }
        }
        result[0] = m;
        result[1] = n;
        return result;
    }

}
