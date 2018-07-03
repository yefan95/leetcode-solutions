package de.yefan.leetcode.array;

/**
 * Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class Num4 {

    public int[] mergeList(int[] a, int[] b) {
        int[] result;
        //定义一个新数组，长度为两个数组长度之和
        result = new int[a.length + b.length];
        //i:a数组下标    j：b数组下标  k：新数组下标
        int i = 0, j = 0, k = 0;
        //按位循环比较两个数组，较小元素的放入新数组，下标加一（注意，较大元素对应的下标不加一），直到某一个下标等于数组长度时退出循环
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        /* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 *
         * 此时较短数组已经全部放入新数组，较长数组还有部分剩余，最后将剩下的部分元素放入新数组，大功告成*/
        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = mergeList(nums1, nums2);
        int size = nums.length;
        if (size % 2 == 0) {
            return (nums[size / 2 - 1] + nums[size / 2]) / 2.0;
        } else {
            return nums[size / 2];
        }
    }

}
