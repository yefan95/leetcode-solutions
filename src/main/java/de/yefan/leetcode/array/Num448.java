package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class Num448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
        }

        int n = nums.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 1) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
