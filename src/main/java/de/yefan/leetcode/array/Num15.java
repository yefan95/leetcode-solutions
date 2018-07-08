package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3Sum
 * https://leetcode.com/problems/3sum/description/
 */
public class Num15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    ArrayList<List<Integer>> result;

    public List<List<Integer>> threeSum1(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return result;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        for (start = 0; start < end; start++) {
            int current = nums[start];
            if (start == 0 || (start != 0 && nums[start] != nums[start - 1])) {
                twoSum(start + 1, end, -current, nums);
            }
        }

        return (result);
    }

    public void twoSum(int start, int end, int target, int[] nums) {
        // List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                //dedup
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
    }


}
