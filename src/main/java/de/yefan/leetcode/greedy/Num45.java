package de.yefan.leetcode.greedy;

/**
 * Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class Num45 {
    /**
     * greedy
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int lastPos = 0;
        int count = 0;
        int furthestJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthestJump = Math.max(furthestJump, nums[i] + i);
            if (furthestJump >= nums.length - 1) {
                return ++count;
            }
            if (i == lastPos) {
                count++;
                lastPos = furthestJump;
            }
        }

        return count;
    }

    /**
     * greedy
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int ans = 0, cur = 0, i = 0;
        // not '< nums.length'
        while (cur < nums.length - 1) {
            ans++;
            int pre = cur;
            for (; i <= pre; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
            // if question doesn't say the last element can always be reached
            // if (pre == cur) return -1;
        }
        return ans;
    }

    /**
     * dp with greedy
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        result[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            result[i] = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (result[j] != -1 && nums[j] >= i - j) {
                    min = Math.min(min, result[j] + 1);
                }
                if (min == 1) {
                    break;
                }
            }
            result[i] = min;
        }

        return result[nums.length - 1] == -1 ? 0 : result[nums.length - 1];
    }


    public static void main(String[] args) {
        Num45 num45 = new Num45();
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {1, 2, 1, 1, 1};
        int res = num45.jump2(nums);
        System.out.println(res);
    }

}
