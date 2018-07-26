package de.yefan.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * https://leetcode.com/problems/largest-number/description/
 */
public class Num179 {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }


    public String largestNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Num179 num179 = new Num179();
//        int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {10, 2};
        String res = num179.largestNumber(nums);
        System.out.println(res);
    }
}
