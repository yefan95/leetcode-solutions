package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class Num442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
        }
        int[] arr = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int location = Math.abs(nums[i]) - 1;
            if (nums[location] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[location] = -nums[location];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }

}
