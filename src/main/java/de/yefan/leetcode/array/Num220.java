package de.yefan.leetcode.array;

import java.util.TreeSet;

/**
 * Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class Num220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] * 1.0 - nums[i] * 1.0) * 1.0 <= t * 1.0 && (j - i <= k)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.min(nums.length - i - 1, k);
            for (int j = 1; j <= index; j++) {
                if (Math.abs(nums[i + j] * 1.0 - nums[i] * 1.0) * 1.0 <= t * 1.0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long l = (long) nums[i];
            final Long floor = values.floor(l + t);
            final Long ceil = values.ceiling(l - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            values.add(l);

            if (i >= k) {
                values.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
