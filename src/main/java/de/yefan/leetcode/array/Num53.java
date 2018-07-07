package de.yefan.leetcode.array;

/**
 * Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Num53 num53 = new Num53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = num53.maxSubArray(nums);
        System.out.println(sum);
    }

}
