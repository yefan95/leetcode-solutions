package de.yefan.leetcode.sort;

import java.util.Arrays;

/**
 * Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 */
public class Num324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public void wiggleSort1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        int index = 0;
        while (left >= 0 && right >= (n + 1) / 2) {
            nums[index++] = temp[left--];
            nums[index++] = temp[right--];
        }
        if (left >= 0) {
            nums[index] = temp[left];
        }
    }

    public static void main(String[] args) {
        Num324 num324 = new Num324();
//        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums = {4, 5, 5, 6};
        num324.wiggleSort(nums);
    }
}
