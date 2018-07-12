package de.yefan.leetcode.array;

/**
 * Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/description/
 */
public class Num665 {

    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0) {
                    if (nums[i + 1] < nums[i - 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i + 1];
                    }
                }
                count++;
            }
        }

        if (count > 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Num665 num665 = new Num665();
//        int[] nums = {3, 4, 2, 3};
        int[] nums = {4, 2, 3};
        boolean flag = num665.checkPossibility(nums);
        System.out.println(flag);
    }
}
