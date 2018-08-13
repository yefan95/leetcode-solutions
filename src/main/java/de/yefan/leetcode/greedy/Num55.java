package de.yefan.leetcode.greedy;

/**
 * Jump Game
 * https://leetcode.com/problems/jump-game/description/
 */
public class Num55 {

    /**
     * Greedy
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;

        return false;
    }

    /**
     * Dynamic Programming Top-down
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    /**
     * Dynamic Programming Bottom-up
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i > memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }

    public boolean canJumpFromPosition1(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition1(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Backtracking
     *
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        return canJumpFromPosition1(0, nums);
    }

}
