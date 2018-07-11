package de.yefan.leetcode.array;

/**
 * Product of Array Except Self
 * https://leetcode-cn.com/problems/product-of-array-except-self/description/
 */
public class Num238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return new int[]{0};
        }

        int len = nums.length;

        int[] output = new int[len];

        int[] left = new int[len];

        int[] right = new int[len];

        left[0] = nums[0];

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        output[0] = right[1];
        output[len - 1] = left[len - 2];

        for (int i = 1; i < len - 1; i++) {
            output[i] = left[i - 1] * right[i + 1];
        }

        return output;
    }
}
