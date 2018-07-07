package de.yefan.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class Num697 {

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }

        return ans;
    }

    public int findShortestSubArray1(int[] nums) {
        int maxNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }

        int[] count = new int[maxNum + 1];
        int[] start = new int[maxNum + 1];
        int[] end = new int[maxNum + 1];

        int maxCount = 0;
        int minD = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (start[nums[i]] == 0) {
                start[nums[i]] = i + 1;
                end[nums[i]] = i + 1;
            } else {
                end[nums[i]] = i + 1;
            }
            count[nums[i]]++;
            if (count[nums[i]] > maxCount) {
                maxCount = count[nums[i]];
            }
        }

        for (int i = 0; i <= maxNum; i++) {
            if (count[i] == maxCount) {
                int distance = end[i] - start[i] + 1;
                if (distance < minD) {
                    minD = distance;
                }
            }
        }
        return minD;
    }

}
