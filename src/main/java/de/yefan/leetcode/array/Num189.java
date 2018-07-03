package de.yefan.leetcode.array;

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

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
