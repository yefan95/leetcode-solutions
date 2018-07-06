package de.yefan.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class Num219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (j - i <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int step = 1;
            while (step <= k) {
                if (i + step < nums.length) {
                    if (nums[i] == nums[i + step]) {
                        return true;
                    }
                    step++;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
