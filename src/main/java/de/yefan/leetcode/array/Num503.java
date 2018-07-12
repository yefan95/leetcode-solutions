package de.yefan.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class Num503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {

        int[] idxs = new int[nums.length];
        int idxSize = 0;
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            while (idxSize > 0 && nums[idxs[idxSize - 1]] < nums[i % nums.length]) {
                int top = idxs[--idxSize];
                ret[top] = nums[i % nums.length];
            }
            if (i < nums.length) {
                idxs[idxSize++] = i;
            }
        }
        return ret;
    }
}
