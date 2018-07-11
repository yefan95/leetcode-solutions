package de.yefan.leetcode.array;

/**
 * Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/description/
 */
public class Num605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length <= 0) {
            return false;
        }
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return true;
            } else {
                if (n == 0) {
                    return true;
                }
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] != 1) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else {
                    if (flowerbed[i + 1] != 1 && flowerbed[i - 1] != 1) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
        }

        if (count >= n) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Num605 num605 = new Num605();
        int[] nums = {1, 0, 0, 0, 1, 0, 0};
        boolean flag = num605.canPlaceFlowers(nums, 2);
        System.out.println(flag);
    }

}
