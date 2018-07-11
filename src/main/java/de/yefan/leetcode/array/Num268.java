package de.yefan.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Missing Number
 * https://leetcode.com/problems/missing-number/description/
 */
public class Num268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }

    public int missingNumber1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int missingNumber3(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Num268 num268 = new Num268();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int num = num268.missingNumber1(nums);
        System.out.println(num);
    }
}
