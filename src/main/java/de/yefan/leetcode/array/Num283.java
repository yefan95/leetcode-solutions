package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class Num283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < list.size()) {
                nums[i] = list.get(i);
            } else {
                nums[i] = 0;
            }
        }

    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int lastNonZeroFoundAt = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }


}
