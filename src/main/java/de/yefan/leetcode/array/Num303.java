package de.yefan.leetcode.array;

/**
 * Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class Num303 {
    class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }

            return sum;
        }
    }
}
