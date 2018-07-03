package de.yefan.leetcode.array;

/**
 * Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */
public class Num628 {

    public int maximumProduct(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }

        sort(0, nums.length - 1, nums);

        int max1 = nums[nums.length - 1] * nums[0] * nums[1];
        int max2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return max1 > max2 ? max1 : max2;
    }

    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            }
            // n lies between min1 and min2
            else if (n <= min2) {
                min2 = n;
            }
            // n is greater than max1, max2 and max3
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            // n lies betweeen max1 and max2
            else if (n >= max2) {
                max3 = max2;
                max2 = n;
            }
            // n lies betwen max2 and max3
            else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public void select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param fist
     * @param last
     * @param arry
     */
    public void sort(int fist, int last, int arry[]) {
        int f = fist;
        int l = last;
        int mid = arry[(fist + last) / 2];
        int temp = 0;
        while (f < l) {
            while (arry[f] < mid) {
                f++;
            }
            while (arry[l] > mid) {
                l--;
            }
            if (f >= l) {
                break;
            }
            temp = arry[f];
            arry[f] = arry[l];
            arry[l] = temp;
            if (arry[f] == mid) {
                --l;
            }
            if (arry[l] == mid) {
                ++f;
            }
        }
        if (f == l) {
            f++;
            l--;
        }
        //利用递归快速排序
        if (fist < l) {
            sort(fist, l, arry);
        }

        if (last > f) {
            sort(f, last, arry);
        }
    }

}
