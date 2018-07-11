package de.yefan.leetcode.array;

/**
 * 1-bit and 2-bit Characters
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */
public class Num717 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length <= 0) {
            return false;
        }

        int start = 0;

        while (start < bits.length - 1) {
            if (bits[start] == 1) {
                start += 2;
            } else {
                start++;
            }
        }

        if (start == bits.length) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Num717 num717 = new Num717();
        int[] nums = {1, 1, 1, 0};
        boolean res = num717.isOneBitCharacter(nums);
        System.out.println(res);
    }
}
