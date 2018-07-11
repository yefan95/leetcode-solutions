package de.yefan.leetcode.array;

/**
 * Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class Num674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                if (i == nums.length - 2) {
                    count++;
                    max = Math.max(max, count);
                }
            } else {
                count++;
                max = Math.max(max, count);
                count = 0;
            }

        }

        return max;
    }

    public int findLengthOfLCIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int prev = nums[0];
        int ret = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur <= prev) {
                //reset
                if (ret < len) {
                    ret = len;
                }
                len = 1;
            } else {
                //keep counting
                len++;
            }
            prev = cur;
        }
        if (ret < len) {
            ret = len;
        }
        return ret;
    }

    public static void main(String[] args) {
        Num674 num674 = new Num674();
//        int[] nums = {1, 3, 5, 7};
        int[] nums = {2, 2, 2, 2};
        int res = num674.findLengthOfLCIS(nums);
        System.out.println(res);
    }

}
