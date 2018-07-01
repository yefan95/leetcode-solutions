package de.yefan.leetcode;

/**
 * Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class Num209 {


    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int start = 0, index = start;
        int count = 0;

        int minLength = 0;

        int sum = 0;

        while (start <= nums.length - 1) {
            if (nums[start] == s) {
                return 1;
            }
            sum += nums[start];
            if (sum >= s) {
                if (minLength == 0) {
                    minLength = start - index + 1;
                } else if (minLength > (start - index + 1)) {
                    minLength = start - index + 1;
                }
                count++;
                start = count;
                index = start;
                sum = 0;
            } else {
                start++;
            }

        }

        return minLength;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        int start = 0;
        int end = 0;

        while (start < nums.length) {
            //if current window doesn't add up to the given sum then
            //strech the window to right
            if (curSum < s && end < nums.length) {
                curSum += nums[end];
                end++;
            }
            //if current window adds up to at least given sum then
            //we can shrink the window
            else if (curSum >= s) {
                minLen = Math.min(minLen, end - start);
                curSum -= nums[start];
                start++;
            }
            //cur sum less than required sum but we reach the end
            else {
                break;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        Num209 num209 = new Num209();
        int[] nums = {1, 1};
        int res = num209.minSubArrayLen1(3, nums);
        System.out.println(res);
    }

}
