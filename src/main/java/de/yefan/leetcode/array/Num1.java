package de.yefan.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Two Sum
 * https://leetcode.com/problems/two-sum/description/
 */
public class Num1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int m = -1, n = -1;
        int[] result = new int[2];
        OK:
        for (int i = 0; i < len; i++) {
            m = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    n = j;
                    break OK;
                }
            }
        }
        result[0] = m;
        result[1] = n;
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && (map.get(target - nums[i]) != i)) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Num1 num1 = new Num1();
        int[] nums = {3, 2, 4};
        int[] res = num1.twoSum1(nums, 6);
        if (res != null) {
            System.out.println(res[0] + " " + res[1]);
        }
    }

}
