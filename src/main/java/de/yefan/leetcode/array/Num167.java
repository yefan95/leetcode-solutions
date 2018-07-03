package de.yefan.leetcode.array;

/**
 * Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class Num167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int start = 0, end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Num167 num167 = new Num167();
        int[] nums = {-1, 0};
        int[] res = num167.twoSum(nums, -1);
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }
        }else {
            System.out.println(res);
        }
    }

}
