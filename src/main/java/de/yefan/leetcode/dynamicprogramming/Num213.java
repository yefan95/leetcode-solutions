package de.yefan.leetcode.dynamicprogramming;

/**
 * House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class Num213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = lo; i <= hi; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);

            preNotRob = notRob;
            preRob = rob;
        }

        return Math.max(rob, notRob);
    }


    public int rob1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int maxSkip = 0;
        int maxNonSkip = 0;
        int[] skip = new int[len];
        int[] nonSkip = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                skip[i] = 0;
                nonSkip[i] = nums[i];
            } else if (i == 1) {
                skip[i] = nums[i];
                nonSkip[i] = nums[i];
            } else if (i == 2) {
                skip[i] = nums[i];
                nonSkip[i] = nonSkip[0] + nums[i];
            } else {
                skip[i] = Math.max(skip[i - 2], skip[i - 3]) + nums[i];
                nonSkip[i] = Math.max(nonSkip[i - 2], nonSkip[i - 3]) + nums[i];
            }
            maxSkip = Math.max(maxSkip, skip[i]);
            if (i != len - 1) {
                maxNonSkip = Math.max(maxNonSkip, nonSkip[i]);
            }
        }

        return Math.max(maxNonSkip, maxSkip);
    }

    public static void main(String[] args) {
        Num213 num213 = new Num213();
        int[] nums = {1};
        int res = num213.rob(nums);
        System.out.println(res);
    }
}
