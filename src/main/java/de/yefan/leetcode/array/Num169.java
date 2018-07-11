package de.yefan.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * https://leetcode.com/problems/majority-element/description/
 */
public class Num169 {

    public int majorityElement(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > n / 2) {
                return (int) entry.getKey();
            }
        }

        return -1;
    }

    public int majorityElement1(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if (i == nums.length - 2) {
                    count++;
                    if (count > n / 2) {
                        return i;
                    }
                }
            } else {
                count++;
                if (count > n / 2) {
                    return i;
                }
                count = 0;
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
            }
            if (nums[i] == major) {
                ++count;
            } else {
                --count;
            }
        }
        return major;
    }
}
