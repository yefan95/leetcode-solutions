package de.yefan.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Single Number III
 * https://leetcode.com/problems/single-number-iii/description/
 */
public class Num260 {


    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.remove(nums[i])) {
                set.add(nums[i]);
            }
        }
        int index = 0;
        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }
        return result;
    }

    public int[] singleNumber1(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        // this array stores the two numbers we will return
        int[] res = {0, 0};
        for (int num : nums) {
            // the bit is not set
            if ((num & diff) == 0) {
                res[0] ^= num;
            }
            // the bit is set
            else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
