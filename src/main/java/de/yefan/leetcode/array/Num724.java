package de.yefan.leetcode.array;

/**
 * Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class Num724 {

    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int sum = 0, leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Num724 num724 = new Num724();
        int[] nums = {-1, -1, -1, -1, 0, 1};
        int index = num724.pivotIndex(nums);
        System.out.println("index= " + index);
    }

}
