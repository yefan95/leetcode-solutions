package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Majority Element II
 * https://leetcode.com/problems/majority-element-ii/description/
 */
public class Num229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
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
            if ((int) entry.getValue() > n / 3) {
                list.add((Integer) entry.getKey());
            }
        }

        return list;
    }

    public List<Integer> majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<Integer>();
        int candidate1 = 0;
        int candidate2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (candidate1 == nums[i]) {
                ++cnt1;
            } else if (candidate2 == nums[i]) {
                ++cnt2;
            } else if (cnt1 == 0) {
                candidate1 = nums[i];
                ++cnt1;
            } else if (cnt2 == 0) {
                candidate2 = nums[i];
                ++cnt2;
            } else {
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                ++cnt1;
            } else if (n == candidate2) {
                ++cnt2;
            }
        }
        if (cnt1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (cnt2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }

}
