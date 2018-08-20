package de.yefan.leetcode.dynamicprogramming.interview;

import java.util.Arrays;

/**
 * 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
 * <p>
 * 给定一个整数数组A及它的大小n，请返回最短子数组的长度。
 */
public class ShortestSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};
        int res = findShortest(arr, arr.length);
        System.out.println(res);
    }

    public static int findShortest(int[] A, int n) {
        if (n < 2) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = A[i];
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        while (left <= right && A[left] == nums[left]) {
            left++;
        }
        while (right >= left && A[right] == nums[right]) {
            right--;
        }
        return right - left + 1;
    }
}
