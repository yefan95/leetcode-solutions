package de.yefan.leetcode.search;

import java.util.Arrays;

/**
 * Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/description/
 */
public class Num377 {

    /**
     * 超时
     *
     * @param candidates
     * @param target
     * @return
     */
    public int combinationSum4(int[] candidates, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                res += combinationSum4(candidates, target - candidates[i]);
            }
        }
        return res;
    }

    private int[] dp;

    public int combinationSum41(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public int combinationSum42(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }


    public static void main(String[] args) {
        Num377 num377 = new Num377();
        int[] candidates = {1, 2, 3};
        int target = 4;
        int res = num377.combinationSum4(candidates, target);
        System.out.println(res);
    }
}


