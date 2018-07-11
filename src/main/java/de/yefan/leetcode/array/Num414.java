package de.yefan.leetcode.array;

import java.util.*;

/**
 * Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/description/
 */
public class Num414 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != 0) {
                if (nums[i] != nums[i - 1]) {
                    count++;
                }
            } else {
                if (nums[i] != nums[i + 1]) {
                    count++;
                }
            }
            if (count == 3) {
                return nums[i];
            }
        }

        if (count < 3) {
            return nums[nums.length - 1];
        }

        return -1;
    }

    public int thirdMax1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
        }

        if (set.size() < 3) {
            return nums[nums.length - 1];
        }

        int count = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            count++;
            if (count == 3) {
                return iterator.next();
            } else {
                iterator.next();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Num414 num414 = new Num414();
        int[] nums = {2, 2, 3, 1};
        int res = num414.thirdMax1(nums);
        System.out.println(res);
    }

}
