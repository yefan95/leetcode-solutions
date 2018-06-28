package de.yefan.leetcode;

/**
 * Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Num88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] nums = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i];
                i++;
            } else {
                nums[index++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            nums[index++] = nums1[i];
            i++;
        }

        while (j < n) {
            nums[index++] = nums2[j];
            j++;
        }

        for (int k = 0; k < nums.length; k++) {
            nums1[k] = nums[k];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
