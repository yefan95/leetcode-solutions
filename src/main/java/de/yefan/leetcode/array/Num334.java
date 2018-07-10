package de.yefan.leetcode.array;

/**
 * Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
public class Num334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } // update small if n is smaller than both
            else if (n <= big) {
                big = n;
            } // update big only if greater than small but smaller than big
            else {
                return true;
            }// return if you find a number bigger than both
        }
        return false;

    }
}
