package de.yefan.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/description/
 */
public class Num496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map from x to next greater element of x
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > max) {
                max = nums2[i];
            }
        }
        int[] pos = new int[max + 1];

        if (nums2.length > 0) {
            pos[nums2[nums2.length - 1]] = -1;
        }
        for (int i = nums2.length - 2, j; i >= 0; i--) {
            j = i + 1;
            while (nums2[j] < nums2[i]) {
                j = pos[nums2[j]];
                if (j < 0) {
                    break;
                }
            }
            pos[nums2[i]] = j;
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            if (pos[nums1[i]] >= 0) {
                ans[i] = nums2[pos[nums1[i]]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Num496 num496 = new Num496();
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        int[] res = num496.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
