package de.yefan.leetcode.array;

/**
 * First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class Num41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                arr[nums[i]]++;
            }
        }

        int i = 0;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        Num41 num41 = new Num41();
        int[] nums = {1, 2, 0};
        int index = num41.firstMissingPositive(nums);
        System.out.println(index);
    }

}
