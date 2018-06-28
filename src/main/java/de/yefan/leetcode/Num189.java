package de.yefan.leetcode;

/**
 * Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 */
public class Num189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[(i + k) % n] = nums[i];
        }
        for (int j = 0; j < n; j++) {
            nums[j] = a[j];
        }
    }
}
